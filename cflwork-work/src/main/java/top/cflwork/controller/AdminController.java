package top.cflwork.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.enums.AppControllerStatusEnum;
import top.cflwork.vo.AdminLoginVO;
import top.cflwork.vo.ControllerStatusVO;

/**
 * 管理员控制器<br />
 * 创建于2017-09-12
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    /**
     * 显示登录页
     * @return 登录页面
     */
    @GetMapping("login_page")
    public String loginPage() {
        return "admin/login";
    }

    /**
     * 登录操作
     * @return 登录操作结果对应的json字符串
     */
    @PostMapping("login")
    @ResponseBody
    public ControllerStatusVO login(AdminLoginVO loginVO) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getAccount(), loginVO.getPassword());
        ControllerStatusVO statusVO = ControllerStatusVO.okStatus(AppControllerStatusEnum.USER_LOGIN_OK.getCode(),
                AppControllerStatusEnum.USER_LOGIN_OK.getMessage());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            logger.info("用户登录失败，登录名或密码错误");
            statusVO = ControllerStatusVO.errorStatus(AppControllerStatusEnum.USER_LOGIN_ERROR.getCode(),
                    AppControllerStatusEnum.USER_LOGIN_ERROR.getMessage());
        }
        return statusVO;
    }

}
