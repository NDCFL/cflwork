package top.cflwork.util;

import java.util.Random;

public class SendMsg {
    public static void main(String[] args) {
        //用户名
        String Uid = "絮落锦乡";

        //接口安全秘钥
        String Key = "7dc6e6e7cf7ca510a6a4";

        //手机号码，多个号码如13800000000,13800000001,13800000002
        String smsMob = "18370940755";
        Integer code = new Random().nextInt(8999)+1000;
        //短信内容
        String smsText = "【瑞蓝酒店】找回密码，你的验证码是："+code;
        HttpClientUtil client = HttpClientUtil.getInstance();

        //UTF发送
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }
}
