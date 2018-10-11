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
import top.cflwork.service.CooperationSubjectService;
import top.cflwork.vo.CooperationSubjectVo;
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
@RequestMapping("cooperationSubject")
public class CooperationSubjectController {
    @Resource
    private CooperationSubjectService cooperationSubjectService;
    @RequestMapping("cooperationSubjectList")
    @ResponseBody
    public PagingBean cooperationSubjectList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo =(UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(cooperationSubjectService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(cooperationSubjectService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    @RequestMapping("/cooperationSubjectAddSave")
    @ResponseBody
    public Message addSavecooperationSubject(CooperationSubjectVo web, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            web.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            web.setCompanyId(userVo.getCompanyId());
            cooperationSubjectService.save(web);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findCooperationSubject/{id}")
    @ResponseBody
    public CooperationSubjectVo findcooperationSubject(@PathVariable("id") long id){
        CooperationSubjectVo cooperationSubject = cooperationSubjectService.getById(id);
        return cooperationSubject;
    }
    @RequestMapping("/cooperationSubjectUpdateSave")
    @ResponseBody
    public Message updatecooperationSubject(CooperationSubjectVo cooperationSubject) throws  Exception{
        try{
            cooperationSubjectService.update(cooperationSubject);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyCooperationSubject")
    @ResponseBody
    public Message deleteManyWeb(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                cooperationSubjectService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改失败!");
        }
    }
    @RequestMapping("/deleteCooperationSubject/{id}")
    @ResponseBody
    public Message deleteWeb(@PathVariable("id") long id) throws  Exception{
        try{
            cooperationSubjectService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/cooperationSubjectPage")
    public String table() throws  Exception{
        return "cooperationSubject/cooperationSubjectList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            cooperationSubjectService.updateStatus(new StatusQuery(id,status));
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
