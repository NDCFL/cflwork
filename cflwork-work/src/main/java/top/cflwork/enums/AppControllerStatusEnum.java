package top.cflwork.enums;

/**
 * 项目控制器响应状态枚举<br />
 * 创建于2017-09-12
 *
 * @author 陈飞龙
 * @version 1.0
 */
public enum AppControllerStatusEnum {

    // 用户登录
    USER_LOGIN_OK(1001, "登录成功"),
    USER_LOGIN_ERROR(1002, "登录名或密码错误"),

    // 用户注册
    USER_REG_OK(1003, "注册成功"),
    USER_REG_ERROR(1004, "注册失败"),
    USER_REG_ACCOUNT_EXIST(1005, "账号已存在");

    private Integer code;
    private String message;

    AppControllerStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
