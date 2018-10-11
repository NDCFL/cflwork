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
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.*;
import top.cflwork.vo.EmployeeVo;
import top.cflwork.vo.RoleVo;
import top.cflwork.vo.UserRoleVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/11/3.
 */
@Controller
@RequestMapping("hotelManager")
public class HotelManagerController {
    @Resource
    private UserService userService;
    @Resource
    private HotelManagerService hotelManagerService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping("hotelManagerList")
    @ResponseBody
    public PagingBean hotelManagerList(int pageSize, int pageIndex,HttpSession session,String searchVal) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(hotelManagerService.count(pageQuery));
        pagingBean.setrows(hotelManagerService.listPages(pageQuery));
        return pagingBean;
    }
    @RequestMapping("hotelManagerAllList")
    @ResponseBody
    public ModelAndView hotelManagerAllList(HttpSession session) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotelList",hotelManagerService.listAlls(userVo.getCompanyId()));
        modelAndView.setViewName("employee/hotelManager");
        return modelAndView;
    }
    @RequestMapping("addHotelManager")
    @ResponseBody
    public Message addHotelManager(UserVo userVo, HttpSession session) {
        UserRoleVo userRole = (UserRoleVo) session.getAttribute("userRole");
        UserVo user = (UserVo) session.getAttribute("userVo");
        userVo.setHeadicon("static/img/face.gif");
        userVo.setIsActive((byte) 0);
        userVo.setPassword(new Md5Hash(userVo.getPassword()).toString());
        userVo.setNickname(userVo.getPhone());
        userVo.setCompanyId(user.getCompanyId());
        //保存管理员信息
        userService.save(userVo);
        EmployeeVo employeeVo = new EmployeeVo();
        employeeVo.setCompanyId(userVo.getCompanyId());
        if(userRole.getRoleVo().getTitle().equals("总管理员")){
            employeeVo.setHotelId(-1);
        }
        employeeVo.setUserId(user.getId());
        employeeVo.setEmployeeId(userVo.getId());
        employeeService.save(employeeVo);
        //通过新增的管理员的手机号获取新增管理员的id
        UserVo userVo1 = userService.findByPhone(userVo.getPhone());
        //通过权限名称来获取到权限的id
        RoleVo roleVo = roleService.findByName("管理员");
        UserRoleVo userRoleVo = new UserRoleVo();
        if (roleVo==null) {
            RoleVo roleVo1 = new RoleVo();
            roleVo1.setIsActive((byte)0);
            roleVo1.setDescription("管理员");
            roleVo1.setTitle("管理员");
            roleService.save(roleVo1);
            roleVo = roleService.findByName("管理员");
        }
        //同时把信息保存到用户权限表中
        userRoleVo.setIsActive((byte) 0);
        userRoleVo.setUserId(userVo1.getId());
        userRoleVo.setRoleId(roleVo.getId());
        userRoleService.save(userRoleVo);
        return Message.success("管理员账号新增成功!");
    }
    @RequestMapping("/findHotelManager/{id}")
    @ResponseBody
    public UserVo findHotelManager(@PathVariable("id") long id) {
        UserVo hotelManager = hotelManagerService.getById(id);
        return hotelManager;
    }
    @RequestMapping("/initPwd/{id}")
    @ResponseBody
    public Message initPwd(@PathVariable("id") long id) {
        try{
            hotelManagerService.initPwd(new Md5Hash("888888").toString(),id);
            return Message.success("初始化成功，密码为888888请妥善保管");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("初始化失败");
        }

    }
    @RequestMapping("/hotelManagerUpdateSave")
    @ResponseBody
    public Message updateHotelManager(UserVo hotelManager) throws Exception {
        try {
            hotelManagerService.update(hotelManager);
            return Message.success("修改成功!");
        } catch (Exception e) {
            return Message.fail("修改失败!");
        }
    }

    @RequestMapping("/deleteManyHotelManager")
    @ResponseBody
    public Message deleteManyhotelManager(@Param("manyId") String manyId) throws Exception {
        try {
            String str[] = manyId.split(",");
            for (String s : str) {
                hotelManagerService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/deleteHotelManager/{id}")
    @ResponseBody
    public Message deletehotelManager(@PathVariable("id") long id) throws Exception {
        try {
            hotelManagerService.removeById(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/hotelManagerListPage")
    public String table() throws Exception {
        return "employee/hotelManagerList";
    }

    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id, @PathVariable("status") int status) throws Exception {
        try {
            hotelManagerService.updateStatus(new StatusQuery(id, status));
            return Message.success("ok");
        } catch (Exception e) {
            return Message.fail("fail");
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
