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
import top.cflwork.service.CharSayService;
import top.cflwork.vo.CharSayVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("charSay")
public class CharSayController {

    @Resource
    private CharSayService charSayService;
    @RequestMapping("charSayList")
    @ResponseBody
    public PagingBean charSayList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PageQuery pageQuery = new PageQuery();
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setSearchVal(searchVal);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setTotal(charSayService.count(pageQuery));
        pagingBean.setrows(charSayService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("findCharSayList")
    @ResponseBody
    public PagingBean findCharSayList(int pageSize, int pageIndex, String searchVal, HttpSession session,CharSayVo charSayVo) throws  Exception{
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(pageSize);
            pagingBean.setCurrentPage(pageIndex);
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setHotelId(-1l);
            pageQuery.setCompanyId(userVo.getCompanyId());
            pageQuery.setSearchVal(searchVal);
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(charSayService.findCharSayByCount(pageQuery,charSayVo));
            pagingBean.setrows(charSayService.findCharSayList(pageQuery,charSayVo));
            return pagingBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    @RequestMapping("/charSayAddSave")
    @ResponseBody
    public Message addSavecharSay(CharSayVo charSays, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            charSays.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            charSayService.save(charSays);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findCharSay/{id}")
    @ResponseBody
    public CharSayVo findcharSay(@PathVariable("id") long id){
        CharSayVo charSays = charSayService.getById(id);
        return charSays;
    }
    @RequestMapping("/charSayUpdateSave")
    @ResponseBody
    public Message updatecharSay(CharSayVo charSays) throws  Exception{
        try{
            charSayService.update(charSays);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyCharSay")
    @ResponseBody
    public Message deleteManycharSay(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                charSayService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteCharSay/{id}")
    @ResponseBody
    public Message deletecharSay(@PathVariable("id") long id) throws  Exception{
        try{
            charSayService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/charSayPage")
    public String table() throws  Exception{
        return "business/charSayList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            charSayService.updateStatus(new StatusQuery(id,status));
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
