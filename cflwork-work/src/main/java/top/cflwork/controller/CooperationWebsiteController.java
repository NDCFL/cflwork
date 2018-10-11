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
import top.cflwork.service.CooperationWebsiteService;
import top.cflwork.vo.CooperationWebsiteVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/19.
 */
@Controller
@RequestMapping("web")
public class CooperationWebsiteController  {
    @Resource
    private CooperationWebsiteService cooperationWebsiteService;
    @RequestMapping("webList")
    @ResponseBody
    public PagingBean webList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(cooperationWebsiteService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(cooperationWebsiteService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    @RequestMapping("/webAddSave")
    @ResponseBody
    public Message addSaveWeb(CooperationWebsiteVo web, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            web.setCompanyId(userVo.getCompanyId());
            web.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            cooperationWebsiteService.save(web);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findWeb/{id}")
    @ResponseBody
    public CooperationWebsiteVo findweb(@PathVariable("id") long id){
        CooperationWebsiteVo web = cooperationWebsiteService.getById(id);
        return web;
    }
    @RequestMapping("/webUpdateSave")
    @ResponseBody
    public Message updateWeb(CooperationWebsiteVo web) throws  Exception{
        try{
            cooperationWebsiteService.update(web);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyWeb")
    @ResponseBody
    public Message deleteManyWeb(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                cooperationWebsiteService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改状态失败!");
        }
    }
    @RequestMapping("/deleteWeb/{id}")
    @ResponseBody
    public Message deleteWeb(@PathVariable("id") String id) throws  Exception{
        try{
            cooperationWebsiteService.removeById(Long.parseLong(id));
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/webPage")
    public String table() throws  Exception{
        return "web/webList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            cooperationWebsiteService.updateStatus(new StatusQuery(id,status));
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
