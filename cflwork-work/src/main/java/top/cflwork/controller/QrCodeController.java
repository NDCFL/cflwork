package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.Message;
import top.cflwork.util.QRCodeUtil;

@RequestMapping("qrcode")
@Controller
public class QrCodeController {
    @RequestMapping("qrcode")
    @ResponseBody
    public Message qrcode(){
        //不含Logo
        try{
            QRCodeUtil.encode("001012018122500001", null,"测试名称","001012018122500001",true);
            return Message.success("二维码生成成功");
        }catch (Exception e){
            return Message.fail("二维码生成失败");
        }
    }
}
