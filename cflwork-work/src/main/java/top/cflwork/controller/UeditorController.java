package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenfeilong on 2017/10/18.
 */
@Controller
@RequestMapping("ueditor")
public class UeditorController {
    @RequestMapping("core")
    public String core(){
        return "ueditor/jsp/controller";
    }


}
