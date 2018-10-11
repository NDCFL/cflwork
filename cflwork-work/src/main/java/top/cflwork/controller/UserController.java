package top.cflwork.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.cflwork.common.Message;
import top.cflwork.query.StatusQuery;
import top.cflwork.query.UserAccountPasswordQuery;
import top.cflwork.service.RoleService;
import top.cflwork.service.UserRoleService;
import top.cflwork.service.UserService;
import top.cflwork.util.Log;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenfeilong on 2017/10/27.
 */
@Controller
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleService roleService;
    @RequestMapping("regPage")
    public String regPage() {
        return "loginRegister/regPage";
    }

    @RequestMapping("loginPage")
    public String loginPage() {
        return "loginRegister/loginPage";
    }

    @RequestMapping("userReg")
    public String userReg(UserVo userVo, HttpServletRequest request) {
        try {
            //使用shiro进行md5加密
            userVo.setGender((byte) 0);
            userVo.setIsActive((byte) 0);
            userVo.setPassword(new Md5Hash(userVo.getPassword()).toString());
            userVo.setNickname(userVo.getPhone());
            //这里是注册时，新增公司的id暂时只有一家公司瑞蓝酒店
            userVo.setCompanyId(1l);
            userService.save(userVo);
            //通过新增的管理员的手机号获取新增管理员的id
            UserVo userVo1 = userService.findByPhone(userVo.getPhone());
            //通过权限名称来获取到权限的id
            RoleVo roleVo = roleService.findByName("总管理员");
            UserRoleVo userRoleVo = new UserRoleVo();
            if(roleVo==null || "".equals(roleVo)){
                RoleVo roleVo1 = new RoleVo();
                roleVo1.setTitle("总管理员");
                roleVo1.setDescription("总管理员");
                roleVo1.setIsActive((byte)0);
                roleService.save(roleVo1);
            }
            if (roleVo.getId() == 0) {

            } else {
                //同时把信息保存到用户权限表中
                userRoleVo.setIsActive((byte) 0);
                userRoleVo.setUserId(userVo1.getId());
                userRoleVo.setRoleId(roleVo.getId());
                userRoleService.save(userRoleVo);
            }
            return "loginRegister/loginPage";
        } catch (Exception e) {
            e.printStackTrace();
            return "loginRegister/regPage";
        }
    }

    @RequestMapping("checkReg")
    @ResponseBody
    public Map<String, Boolean> checkReg(String phone) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        int count = userService.checkReg(phone);
        if (count == 0) {
            result.put("valid", true);
        } else {
            result.put("valid", false);
        }
        return result;
    }

    @RequestMapping("checkLogin")
    @ResponseBody
    public Map<String, Boolean> checkLogin(String phone) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        int count = userService.checkLogin(phone);
        if (count == 0) {
            result.put("valid", false);
        } else {
            result.put("valid", true);
        }
        return result;

    }
    @Log("用户登录")
    @RequestMapping("getInfo")
    @ResponseBody
    public Message getInfo(String phone,String password) {
        try{
            UserVo userVo = userService.getByAccountPassword(new UserAccountPasswordQuery(phone, new Md5Hash(password).toString()));
            if((userVo.getPhone().equals(phone) || userVo.getAccountName().equals(phone) || userVo.getRealname().equals(phone) || userVo.getNickname().equals(phone) || userVo.getEmail().equals(phone)) && userVo.getPassword().equals(new Md5Hash(password).toString())){
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(phone, new Md5Hash(password).toString()));
                Session session = subject.getSession();
                session.setAttribute("userVo", userVo);
                return  Message.success("验证成功");
            }else{
                return  Message.fail("账号或密码输入有误,或已被禁用");
            }
        } catch (DisabledAccountException dax) {
            return Message.fail(phone + " 用户已经被禁用！");
        } catch (ExcessiveAttemptsException eae) {
            return Message.fail(" 用户登录次数过多，有暴力破解的嫌疑！");
        } catch (AccountException ae) {
            return Message.fail(" 帐号或密码错误！");
        } catch (AuthenticationException ae) {
            return Message.fail("身份认证失败！");
        } catch (Exception e) {
            return Message.fail("登录认证错误！");
        }
    }

    @RequestMapping("checkPhoneAndPwd")
    @ResponseBody
    public Map<String, Boolean> checkPhoneAndPwd(String phone, String password) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UserVo userVo = userService.getByAccountPassword(new UserAccountPasswordQuery(phone, new Md5Hash(password).toString()));
            subject.login(new UsernamePasswordToken(phone, new Md5Hash(password).toString()));
            Session session = subject.getSession();
            session.setAttribute("userVo", userVo);
            result.put("valid", true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("valid", false);
            return result;
        }
    }

    @RequestMapping("exit")
    @Log("退出登录")
    public String exit(HttpSession session) {
        return "loginRegister/loginPage";
    }

    @RequestMapping("bossInfoPage")
    public String bossInfoPage() {
        return "user/bossInfoPage";
    }

    @RequestMapping("bossInfo")
    @ResponseBody
    public UserVo bossInfo(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return userService.getById(userVo.getId());
    }
    @RequestMapping("getUser")
    @ResponseBody
    public List<Select2Vo> getUser(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return userService.getUser(userVo.getCompanyId());
    }

    @RequestMapping("updateBossInfo")
    @ResponseBody
    public Message updateBossInfo(UserVo userVo) {
        try{
            userService.update(userVo);
            return Message.success("资料修改成功！");
        }catch (Exception e){
            return Message.success("资料修改失败！");
        }
    }

    @RequestMapping("checkPwd")
    @ResponseBody
    public Map<String, Boolean> checkPwd(String password, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        try {
            Subject subject = SecurityUtils.getSubject();
            String pwd = userService.getPassword(userVo.getId());
            if (pwd.equals(new Md5Hash(password).toString())) {
                result.put("valid", true);
            } else {
                result.put("valid", false);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("valid", false);
            return result;
        }
    }

    @RequestMapping("updatePassword")
    @ResponseBody
    public Message updatePassword(HttpSession session, String newpassword) {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            userService.updatePwd(userVo.getId(), new Md5Hash(newpassword).toString());
            return  Message.success("密码修改成功!");
        }catch (Exception e){
            return  Message.success("密码修改失败!");
        }
    }

    @RequestMapping("changePhone")
    public Message changePhone(HttpSession session, String phone) {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            userService.updatePhone(userVo.getId(), phone);
            return  Message.success("修改手机绑定成功!");
        }catch (Exception e){
            return  Message.success("修改手机绑定失败!");
        }
    }

    @RequestMapping("getUserIdAndName")
    @ResponseBody
    public List<Select2Vo> getUserIdAndName() {
        List<Select2Vo> select2Vo = userService.getUserIdAndName();
        return select2Vo;
    }

    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id, @PathVariable("status") int status) throws Exception {
        try {
            userService.updateStatus(new StatusQuery(id, status));
            return Message.success("ok");
        } catch (Exception e) {
            return Message.fail("fail");
        }
    }

    @RequestMapping("/deleteManyUser")
    @ResponseBody
    public Message deleteManycashSubject(@Param("manyId") String manyId) throws Exception {
        try {
            String str[] = manyId.split(",");
            for (String s : str) {
                userService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    //修改头像
    @RequestMapping("updateHeadIcon")
    @ResponseBody
    public FileVo fileUp(MultipartFile file, HttpServletRequest request,HttpSession session){
        FileVo fileVo = new FileVo();
        try{
            //使用原始文件名称
            String fileName = file.getOriginalFilename();
            //重新格式化文件名称
            //String fileName = getFileName(file.getOriginalFilename());
            String path = request.getSession().getServletContext().getRealPath("upload");
            UserVo userVo1 = (UserVo) session.getAttribute("userVo");
            String names = getFileName(fileName);
            File dir = new File(path,names);
            if(!dir.exists()){
                dir.mkdirs();
            }
            file.transferTo(dir);
            Map<String,String> data = new HashMap<String, String>();
            data.put("src","/upload/"+names);
            fileVo.setData(data);
            System.out.println("保存到数据库的图片地址:/upload/"+names);
            fileVo.setCode(0);
            //如果修改了头像择删除原来的头像
            File file1 = new File(path+userVo1.getHeadicon());
            file1.delete();
            UserVo userVo = new UserVo();
            userVo.setId(userVo1.getId());
            userVo.setHeadicon("/upload/"+names);
            userService.updateHeadIcon(userVo);//保存头像
        }catch (Exception e){
            e.printStackTrace();
            fileVo.setCode(1);
        }
        fileVo.setMsg("上传成功!");
        return  fileVo;
    }
    @RequestMapping("/deleteUser/{id}")
    @ResponseBody
    public Message deletecashSubject(@PathVariable("id") long id) throws Exception {
        try {
            userService.removeById(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/findUser/{id}")
    @ResponseBody
    public UserVo findUser(@PathVariable("id") Long id) throws Exception {
        try {
            if(id==null){
                return null;
            }
            return userService.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }

}
