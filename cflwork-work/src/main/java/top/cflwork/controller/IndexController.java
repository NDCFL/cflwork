package top.cflwork.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.query.UserAccountPasswordQuery;
import top.cflwork.service.*;
import top.cflwork.util.MsgInfo;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 用于显示主页的控制器<br />
 * 创建于2017-08-28
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private HotelService hotelService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private BusinessManService businessManService;
    @Resource
    private ContractMasterService contractMasterService;
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        try{
            UserVo user = (UserVo) session.getAttribute("userVo");
            Subject subject = SecurityUtils.getSubject();
            UserVo userVo = userService.getByAccountPassword(new UserAccountPasswordQuery(user.getPhone(), user.getPassword()));
            subject.login(new UsernamePasswordToken(user.getPhone(), user.getPassword()));
            UserRoleVo userRoleVo = userRoleService.getRole(user.getId());
            if(userRoleVo.getRoleVo().getTitle().equals("店长")){
                HotelVo hotelVo = hotelService.findHotel(user.getId());
                session.setAttribute("hotelVo",hotelVo);
            }
            session.setAttribute("userRole",userRoleVo);
            modelAndView.addObject("permissionList",permissionService.listPermissionTree(user.getId()));
            modelAndView.setViewName("index");
            return modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.setViewName("loginRegister/loginPage");
            return modelAndView;
        }
    }
    @RequestMapping(value = "logins", method = RequestMethod.GET)
    public ModelAndView logins(String code, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        MsgInfo msgInfo = new MsgInfo();
        String accessor = msgInfo.authLogin(code);
        if (accessor != null) {
            JSONObject accessorJSON = JSON.parseObject(accessor);
            String accessToken = accessorJSON.getString("access_token");
            if (accessToken != null) {
                // 如果授权登录成功，则通过access_token和openid去获取用户信息
                String openid = accessorJSON.getString("openid");
                //通过openid去查询该微信是否被某个账号所绑定过
                ContractMasterVo contractMasterVo = contractMasterService.findByOpenId(openid);
                if(contractMasterVo!=null){
                    modelAndView.addObject("id",contractMasterVo.getId());
                }else{
                    String userInfo = msgInfo.getUserInfo(accessToken, openid);
                    try {
                        userInfo = new String(userInfo.getBytes("ISO8859-1"), "utf-8"); // 转码
                        JSONObject userInfoJSON = JSON.parseObject(userInfo);
                        ContractMasterVo contractMasterVo1 = new ContractMasterVo();
                        contractMasterVo1.setNickname(userInfoJSON.getString("nickname"));
                        contractMasterVo1.setFaceImg(userInfoJSON.getString("headimgurl"));
                        contractMasterVo1.setWxopenid(openid);
                        contractMasterVo1.setIsActive((byte) 1);
                        contractMasterVo1.setCreateTime(new Date());
                        contractMasterService.save(contractMasterVo1);
                        modelAndView.addObject("id",contractMasterVo1.getId());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        modelAndView.addObject("id",0);
                    }
                }
            } else {
                modelAndView.addObject("id",0);
            }
        } else {
            modelAndView.addObject("id",0);
        }
        modelAndView.setViewName("house/contract");
        return  modelAndView;
    }

    /**
     * 报价系统的微信登录
     * @param code
     * @param session
     * @return

    @RequestMapping(value = "logins", method = RequestMethod.GET)
    public ModelAndView logins(String code, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        MsgInfo msgInfo = new MsgInfo();
        String accessor = msgInfo.authLogin(code);
        if (accessor != null) {
            JSONObject accessorJSON = JSON.parseObject(accessor);
            String accessToken = accessorJSON.getString("access_token");
            if (accessToken != null) {
                // 如果授权登录成功，则通过access_token和openid去获取用户信息
                String openid = accessorJSON.getString("openid");
                //通过openid去查询该微信是否被某个账号所绑定过
                BusinessManVo businessManVo = businessManService.findByOpenId(openid);
                if(businessManVo!=null){
                    modelAndView.addObject("id",businessManVo.getId());
                }else{
                    String userInfo = msgInfo.getUserInfo(accessToken, openid);
                    try {
                        userInfo = new String(userInfo.getBytes("ISO8859-1"), "utf-8"); // 转码
                        JSONObject userInfoJSON = JSON.parseObject(userInfo);
                        BusinessManVo businessManVo1 = new BusinessManVo();
                        businessManVo1.setName(userInfoJSON.getString("nickname"));
                        businessManVo1.setFaceImg(userInfoJSON.getString("headimgurl"));
                        businessManVo1.setWxopenid(openid);
                        businessManVo1.setHotelSinName("未填写");
                        businessManVo1.setHotelName("未填写");
                        businessManVo1.setName(userInfoJSON.getString("nickname"));
                        businessManVo1.setIsActive((byte) 1);
                        businessManVo1.setCreateTime(new Date());
                        businessManVo1.setType(1);
                        businessManService.save(businessManVo1);
                        modelAndView.addObject("id",businessManVo1.getId());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        modelAndView.addObject("id",0);
                    }
                }
            } else {
                modelAndView.addObject("id",0);
            }
        } else {
            modelAndView.addObject("id",0);
        }
        modelAndView.setViewName("business/baojia");
        return  modelAndView;
    }*/
}
