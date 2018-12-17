package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by chenfeilong on 2017/11/16.
 */
@Data
public class ContractMasterVo{
    @ApiModelProperty(value = "编号", required = true)
    private long id;
    private String bankName;
    private String bankAccountName;
    private String bankAccountNo;
    private String phone;
    private Date createTime;
    private int isActive;
    private String password;
    private String codeType;
    private String identity;
    private long companyId;
    private String wxopenid;//'微信的openid',
    private String faceImg;
    private String nickname;
    private Integer msg;
    private String code;//验证码
}
