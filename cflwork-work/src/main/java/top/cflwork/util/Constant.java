package top.cflwork.util;

public interface Constant {
    //自动去除表前缀
    public static String AUTO_REOMVE_PRE = "true";
    public static String UPLOAD_AVATAR="upload/avatar";
    public static String RES_PRE="http://mykefang.com";
    public static String JWT_SECRET="7786df7fc3a34e26a61c034d5ec8245d";
    public static String TOKEN="token";//登录的请求令牌名称
    interface Redis {
        String OSP_TEACHER_ID_HEADER = "adminLogin";
    }
    interface Upload{
        String ZC_QRCODE="qrcode/qrcode";
    }
}
