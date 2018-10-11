package top.cflwork.vo;

import java.io.Serializable;

public class MsgVo implements Serializable {

    //短信发送手机号
    private String phoneNumber;
    //签名
    private String signName;
    //短信模板Id
    private String templateCode;
    //替换的变量
    private String setTemplateParam;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getSetTemplateParam() {
        return setTemplateParam;
    }

    public void setSetTemplateParam(String setTemplateParam) {
        this.setTemplateParam = setTemplateParam;
    }
}
