package top.cflwork.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.Message;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.ContractMasterService;
import top.cflwork.service.VerifcodeService;
import top.cflwork.util.HttpClientUtil;
import top.cflwork.util.MsgInfo;
import top.cflwork.vo.Verifcode;

import javax.annotation.Resource;
import java.util.Random;

@Controller
@RequestMapping("code")
public class VerifcodeController {

    @Resource
    private VerifcodeService verifcodeService;
    @Resource
    private ContractMasterService contractMasterService;
    /**
     * 发送手机短信验证码
     * @param verifcode
     * @return
     */
    @RequestMapping("sendCode")
    @ResponseBody
    public Message addCode(Verifcode verifcode){
        try{
            //查询改手机号在有效期5分钟之内是否还有未使用的短信，如果有则返回code如果没有则返回-1
            String dbCode = verifcodeService.queryByCode(verifcode.getMobile());
            Integer cnts = verifcodeService.cnt(verifcode.getMobile());
            if(cnts>=10){
                return Message.fail("今天操作过于频繁");
            }
            if(dbCode==null || dbCode.equals("")){
                //生成6位数的验证码
                int code = new Random().nextInt(888888)+100000;
                //执行注册发送的验证码
                if(verifcode.getCodeType().equals("register")){
                    //保存到数据库中并且发送到手机上
                    verifcode.setCode(code+"");
                    verifcode.setMsg("【瑞蓝酒店】注册验证码，你的验证码是："+code);
                    System.out.println(code+"====注册发送的验证码==>>>");
                }else if(verifcode.getCodeType().equals("findPwd")){
                    int cnt = contractMasterService.checkPhone(verifcode.getMobile());
                    if(cnt==0){
                        return  Message.fail("账号不存在!");
                    }else{
                        //保存到数据库中并且发送到手机上
                        verifcode.setCode(code+"");
                        verifcode.setMsg("【瑞蓝酒店】找回密码，你的验证码是："+code);
                        System.out.println(code+"====找回密码注册发送的验证码==>>>");
                    }
                }
                verifcodeService.save(verifcode);
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, verifcode.getMsg(), verifcode.getMobile());
                if(result>0){
                    return  Message.fail("短信发送成功!");
                }else{
                    return  Message.fail(client.getErrorMsg(result));
                }
            }else{
                //发送数据库原来就有的验证码dbcode
                //模拟接收验证码
                Verifcode verifcode1 = verifcodeService.getVerifcode(verifcode.getMobile());
                System.out.println(dbCode+"====来自于数据库的验证码====>>>");
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, verifcode1.getMsg(), verifcode1.getMobile());
                if(result>0){
                    return  Message.fail("短信发送成功!");
                }else{
                    return  Message.fail(client.getErrorMsg(result));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("验证码发送失败!");
        }
    }

    /**
     * 验证手机验证码是否输入正确
     * @param verifcode
     * @return
     *
     */
    @RequestMapping("validateCode")
    @ResponseBody
    public Message validateCode(Verifcode verifcode){
        try{
            //查询改手机号在有效期5分钟之内是否还有未使用的短信，如果有则返回code如果没有则返回-1
            String dbCode = verifcodeService.queryByCode(verifcode.getMobile());
            System.out.println(verifcode.getCode()+"==========>>>");
            if(!dbCode.equals(verifcode.getCode())){
                return  Message.fail("验证码输入错误!");
            }else{
                System.out.println("==================");
                verifcodeService.updateCodeStatus(new StatusQuery(1,verifcode.getMobile()));
                return  Message.success("验证码输入正确!");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("验证码已失效!");
        }
    }
    @RequestMapping("updateCodeStatus")
    @ResponseBody
    public Message updateCodeStatus(Verifcode verifcode){
        try{
            //状态为1代表使用过的或者已经作废的，0代表的是未使用过
            verifcodeService.updateCodeStatus(new StatusQuery(1,verifcode.getMobile()));
            return  Message.success("验证码校验成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("验证码校验失败!");
        }
    }
}
