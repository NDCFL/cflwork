package top.cflwork.common;

import com.xiaoleilu.hutool.captcha.ShearCaptcha;

public class CaptchaUtil {
    public String getCapchaUtil(String path){
        /* 定义图形验证码的长、宽、验证码字符数、干扰线宽度 */
        ShearCaptcha captcha = com.xiaoleilu.hutool.captcha.CaptchaUtil.createShearCaptcha(200, 100);
        //ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(path);
        //验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
        return path;
    }
}
