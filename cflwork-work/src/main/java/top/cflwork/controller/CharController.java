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
import top.cflwork.service.CharService;
import top.cflwork.vo.CharVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("char")
public class CharController {

    @Resource
    private CharService charService;
    @RequestMapping("charList")
    @ResponseBody
    public PagingBean charList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PageQuery pageQuery = new PageQuery();
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setSearchVal(searchVal);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setTotal(charService.count(pageQuery));
        pagingBean.setrows(charService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("myCharList")
    @ResponseBody
    public List<CharVo> myCharList(Long id) throws  Exception{
        return charService.myCharList(id);
    }
    @RequestMapping("findCharList")
    @ResponseBody
    public PagingBean findCharList(int pageSize, int pageIndex, String searchVal, HttpSession session,CharVo charVo) throws  Exception{
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
            pagingBean.setTotal(charService.findCharByCount(pageQuery,charVo));
            pagingBean.setrows(charService.findCharList(pageQuery,charVo));
            return pagingBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    @RequestMapping("/charAddSave")
    @ResponseBody
    public Message addSavechar(CharVo chars,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            chars.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            charService.save(chars);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/deleteFile")
    @ResponseBody
    public Message deleteFile(String url, HttpServletRequest request) throws  Exception {
        try{
            String path = request.getSession().getServletContext().getRealPath("upload");
            File file = new File(path+"/"+url);
            file.delete();
            return  Message.success("删除成功!");
        }catch (Exception E){
            return Message.fail("删除失败!");
        }

    }
    @RequestMapping("/findChar/{id}")
    @ResponseBody
    public CharVo findchar(@PathVariable("id") long id){
        CharVo chars = charService.getById(id);
        return chars;
    }
    @RequestMapping("/charUpdateSave")
    @ResponseBody
    public Message updatechar(CharVo chars) throws  Exception{
        try{
            charService.update(chars);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyChar")
    @ResponseBody
    public Message deleteManychar(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                charService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteChar/{id}")
    @ResponseBody
    public Message deletechar(@PathVariable("id") long id) throws  Exception{
        try{
            charService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/charPage")
    public String table() throws  Exception{
        return "business/charList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            charService.updateStatus(new StatusQuery(id,status));
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
