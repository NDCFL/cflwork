package top.cflwork.controller;
import com.xiaoleilu.hutool.date.DateUnit;
import com.xiaoleilu.hutool.date.DateUtil;
import io.swagger.models.auth.In;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.service.ContractMasterService;
import top.cflwork.service.RentPayService;
import top.cflwork.vo.*;
import top.cflwork.service.RentPayItemService;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

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
@RequestMapping("/rentPayItem")
public class RentPayItemController {
	@Resource
	private RentPayItemService rentPayItemService;
    @Resource
    private ContractMasterService contractMasterService;
    @Resource
    private RentPayService rentPayService;
    /**
    *
	* @param pageSize 分页大小
	* @param pageIndex 当前页
	* @param searchVal 搜索条件
	* @param session 当前的登录用户对象
	* @return  返回分页结果
	* @throws Exception
	*/
    @PostMapping("rentPayItemList")
    @ResponseBody
    @ApiOperation(value = "分页获取数据列表", notes = "返回响应对象", response = RentPayItemVo.class)
    public PagingBean rentPayItemList(
            @ApiParam(value = "每页记录数", required = true)int pageSize,
            @ApiParam(value = "当前页", required = true)int pageIndex,
            @ApiParam(value = "搜索参数")String searchVal,
            HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(rentPayItemService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(rentPayItemService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    /**
        *
        * param  搜索条件
        * @param session 当前的登录用户对象
        * @return  返回分页结果
        * @throws Exception
        */
    @PostMapping("findRentPayItemList")
    @ResponseBody
    @ApiOperation(value = "分页并搜索获取数据列表，只需要传入业主编号就行", notes = "返回响应对象", response = RentPayItemVo.class)
    public PagingBean findRentPayItemList(
            HttpSession session,
            @ApiParam(value = "参数对象")RentPayItemVo rentPayItemVo) throws  Exception{
        try{
            ContractMasterVo contractMasterVo = contractMasterService.getById(rentPayItemVo.getMasterId());
            //分页参数
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(rentPayItemVo.getPageSize());
            pagingBean.setCurrentPage(rentPayItemVo.getPageIndex());
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setCompanyId(contractMasterVo.getCompanyId());
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(rentPayItemService.counts(pageQuery,rentPayItemVo));
            pagingBean.setrows(rentPayItemService.listPages(pageQuery,rentPayItemVo));
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
    @PostMapping("/rentPayItemAddSave")
    @ResponseBody
    @ApiOperation(value = "保存数据", notes = "返回响应对象", response = RentPayItemVo.class)
    public Message rentPayItemAddSave(
            @ApiParam(value = "参数对象", required = true)RentPayItemVo rentPayItemVo,
            HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
			rentPayItemVo.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
			rentPayItemVo.setOrderStatus((byte)0);
			rentPayItemService.save(rentPayItemVo);
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
    @PostMapping("/rentPayItemUpdateSave")
    @ResponseBody
    public Message rentPayItemUpdateSave(RentPayItemVo rentPayItemVo) throws  Exception{
        try{
			rentPayItemService.update(rentPayItemVo);
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
    @PostMapping("/deleteManyRentPayItem")
    @ResponseBody
    public Message deleteManyRentPayItem(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
				rentPayItemService.updateStatus(new StatusQuery(Long.parseLong(s),status));
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
    @PostMapping("/findRentPayItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号获取对象记录", notes = "返回响应对象", response = RentPayItemVo.class)
    public RentPayItemVo findRentPayItem(
            @ApiParam(value = "编号", required = true)@PathVariable("id") long id){
            RentPayItemVo rentPayItemVo = rentPayItemService.getById(id);
        return rentPayItemVo;
    }

    /**
    * 根据编号删除数据
	* @param id 编号
	* @return 返回删除的结果集
	* @throws Exception
	*/
    @PostMapping("/deleteRentPayItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号删除对象记录", notes = "返回响应对象", response = RentPayItemVo.class)
    public Message deleteRentPayItem(
            @ApiParam(value = "参数编号", required = true)@PathVariable("id") long id) throws  Exception{
        try{
			rentPayItemService.removeById(id);
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
    @GetMapping("/rentPayItemPage")
    public String table() throws  Exception{
        return "rentPayItem/rentPayItemList";
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
    @ApiOperation(value = "根据编号状态修改对象的状态", notes = "返回响应对象", response = RentPayItemVo.class)
    public Message updateStatus(
            @ApiParam(value = "参数编号", required = true)@PathVariable("id") long id,
            @ApiParam(value = "对象", required = true)@PathVariable("status") int status) throws  Exception{
        try{
			rentPayItemService.updateStatus(new StatusQuery(id,status));
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
    @ApiOperation(value = "根据订单编号生成订单明细记录", notes = "返回响应对象", response = RentPayItemVo.class)
    public Message GenerateOrder(
            @ApiParam(value = "参数编号", required = true) @PathVariable("id") long id) throws Exception {
        try {
            rentPayItemService.generateOrder(id);
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
    @PostMapping("rentPayItemLists/{id}")
    @ResponseBody
    @ApiOperation(value = "根据订单编号，获取订单详情", notes = "返回响应对象", response = RentPayItemVo.class)
    public List<RentPayItemVo> inComeItemLists(@ApiParam(value = "编号") @PathVariable("id")Long id) throws Exception {
        try {
            List<RentPayItemVo> rentPayItemVos = rentPayItemService.findList(id);
            return rentPayItemVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @return 返回分页结果
     * @throws Exception
     */
    @PostMapping("pay/{id}")
    @ResponseBody
    @ApiOperation(value = "开始付款，参数为编号", notes = "返回响应对象", response = RentPayItemVo.class)
    public Message pay(@ApiParam(value = "编号") @PathVariable("id")Long id) throws Exception {
        try {
            //获取当前周期的时间
            RentPayItemVo rentPayItemVo = rentPayItemService.getById(id);
            //获取本期还没有生成明细的支出账单
            int checkOutCnt = rentPayItemService.checkOutCnt(rentPayItemVo);
            //获取本期还没有生成明细的收入账单
            int checkInCnt = rentPayItemService.checkInCnt(rentPayItemVo);
            if(checkInCnt>0 || checkOutCnt>0){
                return Message.fail("系统检测你还有收入或支出的明细未生成，请先生成");
            }
            //获取本期的时间
            int days = (int) DateUtil.between(rentPayItemVo.getPayTime(), rentPayItemVo.getEndTime(), DateUnit.DAY);
            System.out.println(days+"================");
            //获取本期所有的收入科目是否都已经出账
            List<Integer> checkInSubject = rentPayItemService.checkInSubject(rentPayItemVo);
            //获取本期所有的支出科目是否都已经出账
            List<Integer> checkOutSubject = rentPayItemService.checkInSubject(rentPayItemVo);
            for (int cnt:checkInSubject) {
                if(cnt<days){
                    return Message.fail("付款失败,收入账单未出账");
                }
            }
            for (int cnt1:checkOutSubject) {
                if(cnt1<days){
                    return Message.fail("付款失败,支出账单未出账");
                }
            }
            //本期时间范围中的总成本，总支出
            RentPayItemInfoVo rentPayItemInfoVo= rentPayItemService.getPayInfo(rentPayItemVo);
            RentPayItemVo rentPayItemVo1 = new RentPayItemVo();
            rentPayItemVo1.setId(rentPayItemVo.getId());
            rentPayItemVo1.setInMoney(rentPayItemInfoVo.getHotelInSumMoney());
            rentPayItemVo1.setOutMoney(rentPayItemInfoVo.getHotelOutSumMoney());
            rentPayItemVo1.setRealityPayTime(DateUtil.date());
            rentPayItemVo1.setInTime(DateUtil.format(rentPayItemVo.getPayTime(),"yyyy-MM-dd")+"-"+DateUtil.format(rentPayItemVo.getEndTime(),"yyyy-MM-dd"));
            rentPayItemVo1.setOutTime(rentPayItemVo1.getInTime());
            //计算本期应付金额，用总收入减去总支出
            if(rentPayItemVo.getPayType()==0){
                rentPayItemVo1.setPayMoney(haveOutPayType(rentPayItemInfoVo));
            }else{
                rentPayItemVo1.setPayMoney(noHaveOutPayType(rentPayItemInfoVo));
            }
            rentPayItemVo1.setIsActive((byte)1);
            rentPayItemService.update(rentPayItemVo1);
            return Message.success("付款成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("付款失败");
        }
    }

    /**
     * 有成本支付方式
     * 本期总营业额/总面积*业主面积-本期总成本/总面积*业主面积
     * （本期总营业额-本期总成本）/总面积*业主面积*分成比例
     * @param rentPayItemInfoVo
     * @return
     */
    public Double haveOutPayType(RentPayItemInfoVo rentPayItemInfoVo) {
        Double sumMoney = (rentPayItemInfoVo.getHotelInSumMoney()-rentPayItemInfoVo.getHotelOutSumMoney())/rentPayItemInfoVo.getHotelSumArea()*rentPayItemInfoVo.getMasterSumArea()*rentPayItemInfoVo.getRentPayScale();
        return sumMoney;
    }
    /**
     * 无成本支付方式
     * 本期总营业额/总面积*业主面积*分成比例
     * @param rentPayItemInfoVo
     * @return
     */
    public Double noHaveOutPayType(RentPayItemInfoVo rentPayItemInfoVo) {
        Double sumMoney = rentPayItemInfoVo.getHotelInSumMoney()/rentPayItemInfoVo.getHotelSumArea()*rentPayItemInfoVo.getMasterSumArea()*rentPayItemInfoVo.getRentPayScale();
        return sumMoney;
    }

    @RequestMapping("/down/{id}")
    public void code(HttpServletRequest request, HttpServletResponse response,
                     @PathVariable("id") Long id) throws IOException {
        byte[] data = rentPayItemService.down(id);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"bootdo.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
    @RequestMapping("/look/{id}")
    public ModelAndView look(@PathVariable("id") Long id){
        RentPayItemVo rentPayItemVo = rentPayItemService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/house/invoice");
        modelAndView.addObject("id",id);
        modelAndView.addObject("rentPayItemVo",rentPayItemVo);
        modelAndView.addObject("masterVo",contractMasterService.getById(rentPayItemVo.getMasterId()));
        return modelAndView;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
