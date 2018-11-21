package top.cflwork.controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.vo.ContracmasterMsgVo;
import top.cflwork.service.ContracmasterMsgService;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.UserVo;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 业主消息表，用于给业主发送消息
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-11-21 10:06:20
 */

@Controller
@RequestMapping("/contracmasterMsg")
public class ContracmasterMsgController {
	@Resource
	private ContracmasterMsgService contracmasterMsgService;

    /**
    *
	* @param pageSize 分页大小
	* @param pageIndex 当前页
	* @param searchVal 搜索条件
	* @param session 当前的登录用户对象
	* @return  返回分页结果
	* @throws Exception
	*/
    @RequestMapping("contracmasterMsgList")
    @ResponseBody
    public PagingBean contracmasterMsgList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(contracmasterMsgService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(contracmasterMsgService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
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
    @RequestMapping("findContracmasterMsgList")
    @ResponseBody
    public PagingBean findContracmasterMsgList(int pageSize, int pageIndex,HttpSession session,ContracmasterMsgVo contracmasterMsgVo) throws  Exception{
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
            pagingBean.setTotal(contracmasterMsgService.counts(pageQuery,contracmasterMsgVo));
            pagingBean.setrows(contracmasterMsgService.listPages(pageQuery,contracmasterMsgVo));
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
    @RequestMapping("/contracmasterMsgAddSave")
    @ResponseBody
    public Message contracmasterMsgAddSave(ContracmasterMsgVo contracmasterMsgVo,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
			contracmasterMsgVo.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
			//发送者编号
			contracmasterMsgVo.setSendId(userVo.getId());
			contracmasterMsgService.save(contracmasterMsgVo);
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
    @RequestMapping("/findContracmasterMsg/{id}")
    @ResponseBody
    public ContracmasterMsgVo findContracmasterMsg(@PathVariable("id") long id){
		ContracmasterMsgVo contracmasterMsgVo = contracmasterMsgService.getById(id);
        return contracmasterMsgVo;
    }

    /**
    * 修改操作
	* param  接受对象
	* @return  返回更新结果集
	* @throws Exception
	*/
    @RequestMapping("/contracmasterMsgUpdateSave")
    @ResponseBody
    public Message contracmasterMsgUpdateSave(ContracmasterMsgVo contracmasterMsgVo) throws  Exception{
        try{
            contracmasterMsgVo.setIsActive((byte)1);
			contracmasterMsgService.update(contracmasterMsgVo);
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
    @RequestMapping("/deleteManyContracmasterMsg")
    @ResponseBody
    public Message deleteManyContracmasterMsg(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
				contracmasterMsgService.updateStatus(new StatusQuery(Long.parseLong(s),status));
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
    @RequestMapping("/deleteContracmasterMsg/{id}")
    @ResponseBody
    public Message deleteContracmasterMsg(@PathVariable("id") long id) throws  Exception{
        try{
			contracmasterMsgService.removeById(id);
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
    @RequestMapping("/contracmasterMsgPage")
    public String table() throws  Exception{
        return "contracmasterMsg/contracmasterMsgList";
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
			contracmasterMsgService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @RequestMapping("add")
    public String add(){
        return "contracmasterMsg/contracmasterMsgAdd";
    }
    @RequestMapping("update/{id}")
    public ModelAndView update(@PathVariable("id") Long id){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("contracmasterMsg/contracmasterMsgUpdate");
        modelAndView.addObject("id",id);
        return modelAndView;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
