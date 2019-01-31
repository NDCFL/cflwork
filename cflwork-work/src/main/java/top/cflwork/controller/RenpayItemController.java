package top.cflwork.controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import top.cflwork.vo.RenpayItemVo;
import top.cflwork.service.RenpayItemService;
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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 分成房租，每个合同每期分成明细
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:44:21
 */

@Controller
@RequestMapping("/renpayItem")
public class RenpayItemController {
	@Resource
	private RenpayItemService renpayItemService;

    /**
    *
	* @param pageSize 分页大小
	* @param pageIndex 当前页
	* @param searchVal 搜索条件
	* @param session 当前的登录用户对象
	* @return  返回分页结果
	* @throws Exception
	*/
    @RequestMapping("renpayItemList")
    @ResponseBody
    @ApiOperation(value = "分页获取数据列表", notes = "返回响应对象", response = RenpayItemVo.class)
    public PagingBean renpayItemList(
            @ApiParam(value = "每页记录数", required = true)int pageSize,
            @ApiParam(value = "当前页", required = true)int pageIndex,
            @ApiParam(value = "搜索参数")String searchVal,
            HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(renpayItemService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(renpayItemService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
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
    @RequestMapping("findRenpayItemList")
    @ResponseBody
    @ApiOperation(value = "分页并搜索获取数据列表", notes = "返回响应对象", response = RenpayItemVo.class)
    public PagingBean findRenpayItemList(
            @ApiParam(value = "每页记录数", required = true)int pageSize,
            @ApiParam(value = "当前页", required = true)int pageIndex,
            HttpSession session,
            @ApiParam(value = "参数对象")RenpayItemVo renpayItemVo) throws  Exception{
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
            pagingBean.setTotal(renpayItemService.counts(pageQuery,renpayItemVo));
            pagingBean.setrows(renpayItemService.listPages(pageQuery,renpayItemVo));
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
    @RequestMapping("/renpayItemAddSave")
    @ResponseBody
    @ApiOperation(value = "保存数据", notes = "返回响应对象", response = RenpayItemVo.class)
    public Message renpayItemAddSave(
            @ApiParam(value = "参数对象", required = true)RenpayItemVo renpayItemVo,
            HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
			renpayItemVo.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
			renpayItemService.save(renpayItemVo);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }

    /**
    * 修改操作
	* param  接受对象
	* @return  返回更新结果集
	* @throws Exception
	*/
    @RequestMapping("/renpayItemUpdateSave")
    @ResponseBody
    public Message renpayItemUpdateSave(RenpayItemVo renpayItemVo) throws  Exception{
        try{
			renpayItemService.update(renpayItemVo);
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
    @RequestMapping("/deleteManyRenpayItem")
    @ResponseBody
    public Message deleteManyRenpayItem(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
				renpayItemService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }

    /**
    * 按编号去查找用户
	* @param id 编号
	* @return  返回查询结果
	*/
    @RequestMapping("/findRenpayItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号获取对象记录", notes = "返回响应对象", response = RenpayItemVo.class)
    public RenpayItemVo findRenpayItem(
            @ApiParam(value = "编号", required = true)@PathVariable("id") long id){
            RenpayItemVo renpayItemVo = renpayItemService.getById(id);
        return renpayItemVo;
    }

    /**
    * 根据编号删除数据
	* @param id 编号
	* @return 返回删除的结果集
	* @throws Exception
	*/
    @RequestMapping("/deleteRenpayItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号删除对象记录", notes = "返回响应对象", response = RenpayItemVo.class)
    public Message deleteRenpayItem(
            @ApiParam(value = "参数编号", required = true)@PathVariable("id") long id) throws  Exception{
        try{
			renpayItemService.removeById(id);
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
    @RequestMapping("/renpayItemPage")
    public String table() throws  Exception{
        return "renpayItem/renpayItemList";
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
    @ApiOperation(value = "根据编号状态修改对象的状态", notes = "返回响应对象", response = RenpayItemVo.class)
    public Message updateStatus(
            @ApiParam(value = "参数编号", required = true)@PathVariable("id") long id,
            @ApiParam(value = "对象", required = true)@PathVariable("status") int status) throws  Exception{
        try{
			renpayItemService.updateStatus(new StatusQuery(id,status));
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
