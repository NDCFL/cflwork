package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.common.Message;
import top.cflwork.service.CompanyService;
import top.cflwork.vo.CompanyVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenfeilong on 2017/11/15.
 */
@Controller
@RequestMapping("company")
public class CompanyController {

    @Resource
    private CompanyService companyService;
    @RequestMapping("updateCompanyPage")
    public String updateCompanyPage(){
        return "company/myCompany";
    }
    @RequestMapping("myCompany")
    @ResponseBody
    public CompanyVo getCompany(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo =(UserVo) session.getAttribute("userVo");
        CompanyVo companyVo = companyService.getById(userVo.getCompanyId());
        return companyVo;
    }
    @RequestMapping("updateCompany")
    @ResponseBody
    public Message updateCompany(CompanyVo companyVo){
        try{
            companyService.update(companyVo);
            return Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }

    }
    @RequestMapping("checkName")
    @ResponseBody
    public Map<String, Boolean> checkName(String name, HttpSession session) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        UserVo userVo =(UserVo) session.getAttribute("userVo");
        try {
            int cnt = companyService.checkName(name,userVo.getCompanyId());
            if (cnt==0) {
                result.put("valid", true);
            } else {
                result.put("valid", false);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("valid", false);
            return result;
        }
    }
}
