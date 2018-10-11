package top.cflwork.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.Message;
import top.cflwork.service.CodeService;
import top.cflwork.util.HttpClientUtil;
import top.cflwork.vo.CodeVo;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RequestMapping("code")
public class CodeController {
    @Resource
    private CodeService codeService;
    //用户名
    private static String Uid = "絮落锦乡";
    //接口安全秘钥
    private static String Key = "7dc6e6e7cf7ca510a6a4";
    public static void main(String[] args) {
        HttpClientUtil client = HttpClientUtil.getInstance();
        Integer code = new Random().nextInt(899999)+100000;
        String smsText = "【瑞蓝管理】您的验证码是"+code+"，请在30分钟内按页面提示提交验证码，切勿将验证码泄露于他人。";
        String smsMob = "18370940755";
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob+"");
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }
    @RequestMapping("add")
    @ResponseBody
    public Message add(String phone){
        try{
            Integer cnt = codeService.codeCnt(phone);
            if(cnt<=10){
                HttpClientUtil client = HttpClientUtil.getInstance();
                Integer code = codeService.getCode(phone);
                Integer codeValue;
                if(code==null){
                    codeValue= new Random().nextInt(899999)+100000;
                }else{
                    //不用发送验证码，直接从数据库中读取
                    codeValue = code;
                }
                //code为空，则发送验证码
                String smsText = "【瑞蓝管理】您的验证码是"+codeValue+"，请在30分钟内按页面提示提交验证码，切勿将验证码泄露于他人。";
                String smsMob = phone;
                int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob+"");
                if(result>0){
                    CodeVo codeVo = new CodeVo();
                    codeVo.setCode(codeValue);
                    codeVo.setMsg(smsText);
                    codeVo.setEndTime(new Date());
                    codeVo.setStatus(0);
                    codeVo.setCreateTime(new Date());
                    //新增记录
                    codeService.save(codeVo);
                    System.out.println("UTF8成功发送条数=="+result);
                    return  Message.success("验证码发送成功");
                }else{
                    System.out.println(client.getErrorMsg(result));
                    return  Message.success("验证码发送失败");
                }
            }else{
                return Message.fail("你的操作过于频繁，请明天再试");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("操作失败");
        }
    }
    @RequestMapping("update")
    @ResponseBody
    public Message update(String phone){
        try{
            codeService.updateCode(phone);
            return Message.success("操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("操作失败");
        }
    }
    @RequestMapping("checkCode")
    @ResponseBody
    public Message checkCode(String phone,Integer inCode){
        try{
            Integer code = codeService.getCode(phone);
            if(code.equals(inCode)){
                //code为空，则发送验证码
                return  Message.success("验证码输入正确");
            }else{
                //不用发送验证码，直接从数据库中读取
                return  Message.fail("验证码输入错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("验证码已失效");
        }
    }
}
