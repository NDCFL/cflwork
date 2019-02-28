package top.cflwork.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.ContractMasterService;
import top.cflwork.service.OutComeItemService;
import top.cflwork.service.OutcomeService;
import top.cflwork.service.RentPayService;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 成本支出明细
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:29:58
 */

@Controller
@RequestMapping("/outComeItem")
public class OutComeItemController {
	@Resource
	private OutComeItemService outComeItemService;
    @Resource
    private RentPayService rentPayService;
    @Resource
    private ContractMasterService contractMasterService;
    @Resource
    private OutcomeService outcomeService;
    /**
    *
	* @param pageSize 分页大小
	* @param pageIndex 当前页
	* @param searchVal 搜索条件
	* @param session 当前的登录用户对象
	* @return  返回分页结果
	* @throws Exception
	*/
    @PostMapping("outComeItemList")
    @ResponseBody
    @ApiOperation(value = "分页获取数据列表", notes = "返回响应对象", response = OutComeItemVo.class)
    public PagingBean outComeItemList(
            @ApiParam(value = "每页记录数", required = true)int pageSize,
            @ApiParam(value = "当前页", required = true)int pageIndex,
            @ApiParam(value = "搜索参数")String searchVal,
            HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(outComeItemService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(outComeItemService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    /**
        *
        * param  搜索条件
        * @param session 当前的登录用户对象
        * @return  返回分页结果
        * @throws Exception
        */
    @PostMapping("findOutComeItemList")
    @ResponseBody
    @ApiOperation(value = "分页并搜索获取数据列表，只需要传入业主编号就行", notes = "返回响应对象", response = OutComeItemVo.class)
    public PagingBean findOutComeItemList(
            HttpSession session,
            @ApiParam(value = "参数对象，只要传入master_id ，以及必传的分页参数，其他参数不传")OutComeItemVo outComeItemVo) throws  Exception{
        try{
            if(outComeItemVo.getMasterId()==null){
                return  null;
            }
            Long hotelId = rentPayService.getHotelId(outComeItemVo.getMasterId());
            outComeItemVo.setHotelId(hotelId);
            ContractMasterVo contractMasterVo = contractMasterService.getById(outComeItemVo.getMasterId());
            //分页参数
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(outComeItemVo.getPageSize());
            pagingBean.setCurrentPage(outComeItemVo.getPageIndex());
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setCompanyId(contractMasterVo.getCompanyId());
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(outComeItemService.counts(pageQuery,outComeItemVo));
            pagingBean.setrows(outComeItemService.listPages(pageQuery,outComeItemVo));
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
    @PostMapping("/outComeItemAddSave")
    @ResponseBody
    @ApiOperation(value = "保存数据", notes = "返回响应对象", response = OutComeItemVo.class)
    public Message outComeItemAddSave(
            @ApiParam(value = "参数对象", required = true)OutComeItemVo outComeItemVo,
            HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
			outComeItemService.save(outComeItemVo);
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
    @PostMapping("/outComeItemUpdateSave")
    @ResponseBody
    public Message outComeItemUpdateSave(OutComeItemVo outComeItemVo) throws  Exception{
        try{
			outComeItemService.update(outComeItemVo);
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
    @PostMapping("/deleteManyOutComeItem")
    @ResponseBody
    public Message deleteManyOutComeItem(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
				outComeItemService.updateStatus(new StatusQuery(Long.parseLong(s),status));
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
    @PostMapping("/findOutComeItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号获取对象记录", notes = "返回响应对象", response = OutComeItemVo.class)
    public OutComeItemVo findOutComeItem(
            @ApiParam(value = "编号", required = true)@PathVariable("id") long id){
            OutComeItemVo outComeItemVo = outComeItemService.getById(id);
        return outComeItemVo;
    }

    /**
    * 根据编号删除数据
	* @param id 编号
	* @return 返回删除的结果集
	* @throws Exception
	*/
    @PostMapping("/deleteOutComeItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号删除对象记录", notes = "返回响应对象", response = OutComeItemVo.class)
    public Message deleteOutComeItem(
            @ApiParam(value = "参数编号", required = true)@PathVariable("id") long id) throws  Exception{
        try{
			outComeItemService.removeById(id);
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
    @GetMapping("/outComeItemPage")
    public String table() throws  Exception{
        return "outComeItem/outComeItemList";
    }

    /**
    * 修改状态
	* @param id 编号
	* @param status 状态
	* @return 返回结果
	* @throws Exception
	*/
    @PostMapping("updateStatus/{id}/{status}")
    @ResponseBody
    @ApiOperation(value = "根据编号状态修改对象的状态", notes = "返回响应对象", response = OutComeItemVo.class)
    public Message updateStatus(
            @ApiParam(value = "参数编号", required = true)@PathVariable("id") long id,
            @ApiParam(value = "对象", required = true)@PathVariable("status") int status) throws  Exception{
        try{
			outComeItemService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }

    /**
     * 生成订单
     *
     * @param id 编号
     * @return 返回删除的结果集
     * @throws Exception
     */
    @PostMapping("/generateOrder/{id}")
    @ResponseBody
    @ApiOperation(value = "根据订单编号生成订单明细记录", notes = "返回响应对象", response = OutComeItemVo.class)
    public Message GenerateOrder(
            @ApiParam(value = "参数编号", required = true) @PathVariable("id") long id) throws Exception {
        try {
            outComeItemService.generateOrder(id);
            return Message.success("订单生成成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("订单生成失败!");
        }
    }
    /**
     * @return 返回分页结果
     * @throws Exception
     */
    @PostMapping("outComeItemLists/{id}")
    @ResponseBody
    @ApiOperation(value = "根据订单编号，获取订单详情", notes = "返回响应对象", response = OutComeItemVo.class)
    public List<OutComeItemVo> inComeItemLists(@ApiParam(value = "编号") @PathVariable("id")Long id) throws Exception {
        try {
            List<OutComeItemVo> orderItemsVos = outComeItemService.findList(id);
            return orderItemsVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return 返回分页结果
     * @throws Exception
     */
    @PostMapping("getOutComeItemList")
    @ResponseBody
    @ApiOperation(value = "根据业主编号获取支出的详细信息", notes = "返回响应对象", response = OutcomeVo.class)
    public List<OutcomeVo> getOutComeItemList(@ApiParam(value = "编号") Long id) throws Exception {
        try {
            Long hotelId = rentPayService.getHotelId(id);
            List<OutcomeVo> outcomeVos = outcomeService.getList(hotelId);
            return outcomeVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @return 返回分页结果
     * @throws Exception
     */
    @PostMapping("getListBySubjectId")
    @ResponseBody
    @ApiOperation(value = "根据业主编号获取支出的详细信息", notes = "返回响应对象", response = OutcomeVo.class)
    public List<OutcomeVo> getListBySubjectId(@ApiParam(value = "科目编号") @RequestParam("subjectId") Long subjectId,@ApiParam(value = "酒店编号")@RequestParam("hotelId") Long hotelId) throws Exception {
        try {
            OutcomeVo outcomeVo = new OutcomeVo();
            outcomeVo.setSubjectId(subjectId);
            outcomeVo.setHotelId(hotelId);
            List<OutcomeVo> outcomeVos = outcomeService.getListBySubjectId(outcomeVo);
            return outcomeVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
