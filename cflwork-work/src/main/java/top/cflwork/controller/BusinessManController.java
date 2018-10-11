package top.cflwork.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.BusinessManService;
import top.cflwork.service.CharService;
import top.cflwork.service.PriceItemService;
import top.cflwork.service.VerifcodeService;
import top.cflwork.util.HttpClientUtil;
import top.cflwork.util.MsgInfo;
import top.cflwork.vo.BusinessManVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;
import top.cflwork.vo.Verifcode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("businessMan")
public class BusinessManController {

    @Resource
    private BusinessManService businessManService;
    @Resource
    private VerifcodeService verifcodeService;
    @Resource
    private PriceItemService priceItemService;
    @Resource
    private CharService charService;
    @RequestMapping("businessManLogin")
    @ResponseBody
    public Message businessManLogin() throws  Exception{
        return Message.success("ok");
    }
    @RequestMapping("businessManList")
    @ResponseBody
    public PagingBean businessManList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(businessManService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(businessManService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }

    @RequestMapping("findBusinessManList")
    @ResponseBody
    public PagingBean findBusinessManList(int pageSize, int pageIndex, String searchVal, HttpSession session,BusinessManVo businessManVo) throws  Exception{
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(pageSize);
            pagingBean.setCurrentPage(pageIndex);
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setHotelId(-1l);
            pageQuery.setSearchVal(searchVal);
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(businessManService.findBusinessByCount(pageQuery,businessManVo));
            pagingBean.setrows(businessManService.findBusinessManList(pageQuery,businessManVo));
            return pagingBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @RequestMapping("/businessManAddSave")
    @ResponseBody
    public Message addSavebusinessMan(BusinessManVo businessMan, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            if(businessMan.getName()==null){
                businessMan.setName(businessMan.getPhone());
            }
            businessMan.setPassword(new Md5Hash(businessMan.getPhone()).toString());
            businessMan.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            businessMan.setType(ActiveStatusEnum.ACTIVE.getValue());
            businessManService.save(businessMan);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findBusinessMan/{id}")
    @ResponseBody
    public BusinessManVo findbusinessMan(@PathVariable("id") long id){
        BusinessManVo businessMan = businessManService.getById(id);
        return businessMan;
    }
    @RequestMapping("updateImg")
    @ResponseBody
    public Message upload(Long id,String files) throws  Exception{
        try{
            businessManService.updateFaceImg(id,files);
            return Message.success("修改成功");
        }catch (Exception e){
            return Message.fail("修改失败");
        }

    }
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }
    @RequestMapping("/businessManUpdateSave")
    @ResponseBody
    public Message updatebusinessMan(BusinessManVo businessMan) throws  Exception{
        try{
            System.out.println(businessMan.getPhone()+"======"+businessMan.getHotelSinName());
            int cnt = businessManService.checkPhones(businessMan);
            int count = businessManService.checkName(businessMan);
            if(cnt>0){
                return  Message.fail("修改失败，手机号已被占用!");
            }
            if(count>0){
                return  Message.fail("修改失败，酒店简称已被占用!");
            }
            businessManService.update(businessMan);
            return  Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyBusinessMan")
    @ResponseBody
    public Message deleteManybusinessMan(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                businessManService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBusinessMan/{id}")
    @ResponseBody
    public Message deletebusinessMan(@PathVariable("id") long id) throws  Exception{
        try{
            businessManService.removeById(id);
            priceItemService.deletePriceItem(id);
            charService.deleteChar(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/businessManPage")
    public String table() throws  Exception{
        return "business/businessManList";
    }
    @RequestMapping("/getBusinessManLists")
    @ResponseBody
    public List<Select2Vo> getBusinessManLists() throws  Exception{
        return businessManService.businessManList();
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            businessManService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @RequestMapping("updateType")
    @ResponseBody
    public Message updateType(long id,int status) throws  Exception{
        try{
            BusinessManVo b = businessManService.getById(id);
            businessManService.updateType(new StatusQuery(id,status));
            if(b.getPhone()==null || b.getPhone().equals("") ||  b.getPhone().indexOf("未填写")>-1){
                return Message.success("ok");
            }else{
                //发送短信通知
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                if(status==0){
                    int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, "【瑞蓝软件】非常抱歉，您的账户已被系统停用，您将无法进入系统，详情请联系管理员，电话0532-85696999", b.getPhone());
                }else{
                    int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, "【瑞蓝软件】恭喜您！您在公寓联盟平台注册的账号已通过系统授权，可以正常进入平台，请及时维护个人信息", b.getPhone());
                }
                return Message.success("ok");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("fail");
        }
    }
    @RequestMapping("checkPhone")
    @ResponseBody
    public Message checkPhone(String phone) throws  Exception{
        try{
           int cnt = businessManService.checkPhone(phone);
            if(cnt==0){
                return Message.fail("账号不存在");
            }else{
                return Message.success("账号已存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("账号不存在");
        }
    }
    @RequestMapping("getBusinessManList")
    @ResponseBody
    public List<BusinessManVo> getBusinessManList(BusinessManVo businessManVo) throws  Exception{
        return businessManService.getBusinessManList(businessManVo);
    }
    @RequestMapping("login")
    @ResponseBody
    public Message login(String phone,String password) throws  Exception{
        try{
            BusinessManVo businessManVo = businessManService.getByAccountPassword(phone, new Md5Hash(password).toString());
            if(businessManVo==null){
                return Message.fail("账号或密码输入有误,或已被禁用");
            }else{
                if(phone.equals(businessManVo.getPhone()) && (new Md5Hash(password).toString()).equals(businessManVo.getPassword())){
                    return Message.success(businessManVo.getId()+"");
                }else{
                    return Message.fail("账号或密码输入有误,或已被禁用");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("账号或密码输入有误,或已被禁用");
        }
    }
    @RequestMapping("sendCode")
    @ResponseBody
    public Message addCode(Verifcode verifcode){
        try{
            int cnt = businessManService.checkPhone(verifcode.getMobile());
            //查询改手机号在有效期5分钟之内是否还有未使用的短信，如果有则返回code如果没有则返回-1
            String dbCode = verifcodeService.queryByCode(verifcode.getMobile());
            Integer cnts = verifcodeService.cnt(verifcode.getMobile());
            if(cnts>=10){
                return Message.fail("今天操作过于频繁");
            }
            if(dbCode==null || dbCode.equals("")){
                //生成6位数的验证码
                int code = new Random().nextInt(888888)+100000;
                //执行注册发送的验证码
                if(verifcode.getCodeType().equals("register")){
                    if(cnt!=0){
                        return  Message.fail("账号已被注册!");
                    }
                    //保存到数据库中并且发送到手机上
                    verifcode.setCode(code+"");
                    verifcode.setMsg("【瑞蓝软件】注册验证码，你的验证码是："+code+"，请妥善保管5分钟内有效。");
                    System.out.println(code+"====注册发送的验证码==>>>");
                }else if(verifcode.getCodeType().equals("findPwd")){
                    if(cnt==0){
                        return  Message.fail("账号不存在!");
                    }
                    //保存到数据库中并且发送到手机上
                    verifcode.setCode(code+"");
                    verifcode.setMsg("【瑞蓝软件】找回密码，你的验证码是："+code+"，请妥善保管5分钟内有效。");
                    System.out.println(code+"====找回密码注册发送的验证码==>>>");
                }
                verifcodeService.save(verifcode);
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, verifcode.getMsg(), verifcode.getMobile());
                if(result>0){
                    return  Message.success("短信发送成功!");
                }else{
                    return  Message.fail(client.getErrorMsg(result));
                }
            }else{
                //发送数据库原来就有的验证码dbcode
                //模拟接收验证码
                Verifcode verifcode1 = verifcodeService.getVerifcode(verifcode.getMobile());
                System.out.println(dbCode+"====来自于数据库的验证码====>>>");
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, verifcode1.getMsg(), verifcode1.getMobile());
                if(result>0){
                    return  Message.fail("短信发送成功!");
                }else{
                    return  Message.fail(client.getErrorMsg(result));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("验证码发送失败!");
        }
    }
    @RequestMapping("findPassWord")
    @ResponseBody
    public Message findPassWord(Verifcode verifcode) throws  Exception{
        try{
            //查询改手机号在有效期5分钟之内是否还有未使用的短信，如果有则返回code如果没有则返回-1
            String dbCode = verifcodeService.queryByCode(verifcode.getMobile());
            if(!dbCode.equals(verifcode.getCode())){
                return  Message.fail("验证码输入错误!");
            }else{
                verifcodeService.updateCodeStatus(new StatusQuery(1,verifcode.getMobile()));
                businessManService.updatePwd(verifcode.getMobile(),new Md5Hash(verifcode.getPassword()).toString());
                return  Message.success("密码找回成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("账号不存在");
        }
    }
    @RequestMapping("reg")
    @ResponseBody
    public Message reg(Verifcode verifcode) throws  Exception{
        try{
            //查询改手机号在有效期5分钟之内是否还有未使用的短信，如果有则返回code如果没有则返回-1
            String dbCode = verifcodeService.queryByCode(verifcode.getMobile());
            if(!dbCode.equals(verifcode.getCode())){
                return  Message.fail("验证码输入错误!");
            }else{
                verifcodeService.updateCodeStatus(new StatusQuery(1,verifcode.getMobile()));
                BusinessManVo businessManVo1 = new BusinessManVo();
                businessManVo1.setName(verifcode.getMobile());
                businessManVo1.setHotelSinName("未填写");
                businessManVo1.setHotelName("未填写");
                businessManVo1.setName(verifcode.getMobile());
                businessManVo1.setIsActive((byte) 1);
                businessManVo1.setCreateTime(new Date());
                businessManVo1.setType(1);
                businessManVo1.setPhone(verifcode.getMobile());
                businessManVo1.setPassword(new Md5Hash(verifcode.getPassword()).toString());
                businessManService.save(businessManVo1);
                return  Message.success(businessManVo1.getId()+"");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("账号不存在");
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
