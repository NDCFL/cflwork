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
    @ApiModelProperty(value = "银行用户名",dataType = "String")
    private String bankName;
    @ApiModelProperty(value = "银行开户用户名",dataType = "String")
    private String bankAccountName;
    @ApiModelProperty(value = "银行卡号",dataType = "String")
    private String bankAccountNo;
    @ApiModelProperty(value = "手机号",dataType = "String")
    private String phone;
    @ApiModelProperty(value = "创建时间",dataType = "Date")
    private Date createTime;
    @ApiModelProperty(value = "状态 0：启用，1：禁用",dataType = "int")
    private int isActive;
    @ApiModelProperty(value = "密码",dataType = "String")
    private String password;
    @ApiModelProperty(value = "code类型",dataType = "String")
    private String codeType;
    @ApiModelProperty(value = "身份证号",dataType = "String")
    private String identity;
    @ApiModelProperty(value = "公司id",dataType = "long")
    private long companyId;
    @ApiModelProperty(value = "微信openid",dataType = "String")
    private String wxopenid;//'微信的openid',
    @ApiModelProperty(value = "头像",dataType = "String")
    private String faceImg;
    @ApiModelProperty(value = "微信昵称",dataType = "long")
    private String nickname;
    @ApiModelProperty(value = "消息",dataType = "Integer")
    private Integer msg;
    private String code;//验证码
}
