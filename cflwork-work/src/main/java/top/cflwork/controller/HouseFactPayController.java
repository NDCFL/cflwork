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
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HouseFactPayService;
import top.cflwork.vo.HouseFactPayVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("houseFactPay")
public class HouseFactPayController {
    @Resource
    private HouseFactPayService houseFactPayService;
    @RequestMapping("houseFactPayList")
    @ResponseBody
    public PagingBean houseFactPayList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(houseFactPayService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(houseFactPayService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    @RequestMapping("/houseFactPayAddSave")
    @ResponseBody
    public Message addSavehouseFactPay(HouseFactPayVo houseFactPayVo, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            houseFactPayVo.setCompanyId(userVo.getCompanyId());
            houseFactPayService.save(houseFactPayVo);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findCashSubject/{id}")
    @ResponseBody
    public HouseFactPayVo findhouseFactPay(@PathVariable("id") long id){
        HouseFactPayVo houseFactPay = houseFactPayService.getById(id);
        return houseFactPay;
    }
    @RequestMapping("/houseFactPayUpdateSave")
    @ResponseBody
    public Message updatehouseFactPay(HouseFactPayVo houseFactPay) throws  Exception{
        try{
            houseFactPayService.update(houseFactPay);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyCashSubject")
    @ResponseBody
    public Message deleteManyhouseFactPay(@Param("manyId") String manyId) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                houseFactPayService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("删除失败!");
        }
    }
    @RequestMapping("/deleteCashSubject/{id}")
    @ResponseBody
    public Message deletehouseFactPay(@PathVariable("id") long id) throws  Exception{
        try{
            houseFactPayService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/houseFactPayPage")
    public String table() throws  Exception{
        return "moneyItems/houseFactPayList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            houseFactPayService.updateStatus(new StatusQuery(id,status));
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
