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
import top.cflwork.service.LogService;
import top.cflwork.vo.LogVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统日志
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-09-29 09:36:57
 */

@Controller
@RequestMapping("/log")
public class LogController {
	@Resource
	private LogService logService;

    /**
    *
	* @param pageSize 分页大小
	* @param pageIndex 当前页
	* @param searchVal 搜索条件
	* @param session 当前的登录用户对象
	* @return  返回分页结果
	* @throws Exception
	*/
    @RequestMapping("logList")
    @ResponseBody
    public PagingBean logList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(logService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(logService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    /**
        *
        * @param pageSize 分页大小
        * @param pageIndex 当前页
        * param  搜索条件
        * @param session 当前的登录用户对象
        * @return  返回分页结果
        * @throws Exception
        */
    @RequestMapping("findLogList")
    @ResponseBody
    public PagingBean findLogList(int pageSize, int pageIndex,HttpSession session,LogVo logVo) throws  Exception{
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            //分页参数
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(pageSize);
            pagingBean.setCurrentPage(pageIndex);
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setCompanyId(userVo.getCompanyId());
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(logService.counts(pageQuery,logVo));
            pagingBean.setrows(logService.listPages(pageQuery,logVo));
            return pagingBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    /**
    *
	* param  接收前段的组件
	* @param session 当前用户的对象
	* @return  返回操作结果
	* @throws Exception
	*/
    @RequestMapping("/logAddSave")
    @ResponseBody
    public Message logAddSave(LogVo logVo, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
			logService.save(logVo);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }

    /**
    * 按编号去查找用户
	* @param id 编号
	* @return  返回查询结果
	*/
    @RequestMapping("/findLog/{id}")
    @ResponseBody
    public LogVo findLog(@PathVariable("id") long id){
		LogVo logVo = logService.getById(id);
        return logVo;
    }

    /**
    * 修改操作
	* param  接受对象
	* @return  返回更新结果集
	* @throws Exception
	*/
    @RequestMapping("/logUpdateSave")
    @ResponseBody
    public Message logUpdateSave(LogVo logVo) throws  Exception{
        try{
			logService.update(logVo);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }

    /**
    * 批量删除
	* @param manyId 多选的编号
	* @param status 状态
	* @return  返回删除的结果集
	* @throws Exception
	*/
    @RequestMapping("/deleteManyLog")
    @ResponseBody
    public Message deleteManyLog(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
				logService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }

    /**
    * 根据编号删除数据
	* @param id 编号
	* @return 返回删除的结果集
	* @throws Exception
	*/
    @RequestMapping("/deleteLog/{id}")
    @ResponseBody
    public Message deleteLog(@PathVariable("id") long id) throws  Exception{
        try{
			logService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    /**
    * 跳转到列表页面
	* @return 文件地址
	* @throws Exception
	*/
    @RequestMapping("/logPage")
    public String table() throws  Exception{
        return "log/logList";
    }

    /**
    * 修改状态
	* @param id 编号
	* @param status 状态
	* @return 返回结果
	* @throws Exception
	*/
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
			logService.updateStatus(new StatusQuery(id,status));
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
