package top.cflwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping(value="/TestExcelFast")
@Api(value = "restful", description = "测试")
@EnableWebMvc
public class TestExcelFastController {

    @ApiOperation(value = "测试专用")
    @RequestMapping(value="/test",method= RequestMethod.GET)
    @ResponseBody
    public String test(){
        String str = "123";
        System.out.println(1);
        return str;
    }


}