package top.cflwork.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CashSubjectService;
import top.cflwork.vo.CashSubjectVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("cashSubject")
public class CashSubjectController {

    @Resource
    private CashSubjectService cashSubjectService;
    @RequestMapping("cashSubjectList")
    @ResponseBody
    public List<CashSubjectVo> cashSubjectList(String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return cashSubjectService.listPage(new PageQuery(0,0,null,userVo.getCompanyId()));
    }
    @RequestMapping("/cashSubjectAddSave")
    @ResponseBody
    public Message addSavecashSubject(CashSubjectVo cashSubject, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            cashSubject.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            cashSubject.setCompanyId(userVo.getCompanyId());
            cashSubjectService.save(cashSubject);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findCashSubject/{id}")
    @ResponseBody
    public CashSubjectVo findcashSubject(@PathVariable("id") long id){
        CashSubjectVo cashSubject = cashSubjectService.getById(id);
        return cashSubject;
    }
    @RequestMapping("/cashSubjectUpdateSave")
    @ResponseBody
    public Message updatecashSubject(CashSubjectVo cashSubject) throws  Exception{
        try{
            cashSubjectService.update(cashSubject);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyCashSubject")
    @ResponseBody
    public Message deleteManycashSubject(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                cashSubjectService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteCashSubject/{id}")
    @ResponseBody
    public Message deletecashSubject(@PathVariable("id") long id) throws  Exception{
        try{
            cashSubjectService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/cashSubjectPage")
    public String table() throws  Exception{
        return "cashSubject/cashSubjectList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            cashSubjectService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
