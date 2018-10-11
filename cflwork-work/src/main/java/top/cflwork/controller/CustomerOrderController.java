package top.cflwork.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.DateParseUtils;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CustomerOrderService;
import top.cflwork.service.EmployeeService;
import top.cflwork.service.HotelService;
import top.cflwork.service.HouseService;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("customerOrder")
public class CustomerOrderController {

    @Resource
    private CustomerOrderService customerOrderService;
    @Resource
    private HotelService hotelService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private HouseService houseService;
    @RequestMapping("customerOrderList")
    @ResponseBody
    public PagingBean customerOrderList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        //获取该用户所属的酒店id
        HotelVo hotelVo = hotelService.findHotel(userVo.getId());
        //分页参数
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        //赋值给pagequery对象
        PageQuery pageQuery = new PageQuery();
        pageQuery.setHotelId(hotelVo.getId());
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pagingBean.setTotal(customerOrderService.count(pageQuery));
        pagingBean.setrows(customerOrderService.listPage(pageQuery));
        return pagingBean;
    }

    @RequestMapping("/customerOrderAddSave")
    @ResponseBody
    public Message addSavecustomerOrder(String firstVal,CustomerOrderVo customerOrder,HttpSession session) throws  Exception {
        try{
            List<CustomerOrderVo> customerOrderVoList = new ArrayList<>();
            String order[] = firstVal.replace("天","").split(";");
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
            for (String str:order) {
                String item[] = str.split(",");
                if(userRoleVo.getRoleVo().getTitle().equals("店长")){
                    HotelVo hotelVo = hotelService.findHotel(userVo.getId());
                    customerOrder.setHotelId(hotelVo.getId());
                    customerOrder.setShopManagerId(userVo.getId());
                }else if(userRoleVo.getRoleVo().getTitle().equals("录入员")){
                    EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
                    customerOrder.setHotelId(employeeVo.getHotelId());
                    customerOrder.setShopManagerId(employeeVo.getUserId());
                    HotelVo hotelVo = hotelService.getById(employeeVo.getHotelId());
                }
                customerOrder.setCheckinTime(DateParseUtils.parseDate(item[0]));
                customerOrder.setCheckoutTime(DateParseUtils.parseDate(item[1]));
                customerOrder.setTotalDays(Byte.parseByte(item[2]));
                customerOrder.setHouseId(Long.parseLong(item[4]));
                customerOrder.setHousePay(BigDecimal.valueOf(Long.parseLong(item[5])));
                customerOrder.setIsCheck((byte) 0);
                customerOrder.setOrderStatus((byte)0);
                customerOrder.setCheckRemark("未审核");
                customerOrder.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
                customerOrder.setCompanyId(userVo.getCompanyId());
                customerOrderVoList.add(customerOrder);
                try{
                    //入住过的房状态改为已入住，同时更新该房间空出来的时间这样就方便后期的排房系统
                    houseService.updateHouseStatus(new StatusQuery(1,customerOrder.getHotelId(),Long.parseLong(item[4])),customerOrder.getCheckoutTime());
                }catch (Exception e){
                    e.printStackTrace();
                    return Message.fail("房间状态更新失败!");
                }
            }
            customerOrderService.saveList(customerOrderVoList);
            return  Message.success("订单录入成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("订单录入失败!");
        }

    }
    //获取房间类型列表，返回select2对象的数据
    @RequestMapping("getOthersHotel")
    @ResponseBody
    public List<Select2Vo> getOthersHotel(HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        if(userRoleVo.getRoleVo().getTitle().equals("店长")){
            HotelVo hotelVo = hotelService.findHotel(userVo.getId());
            pageQuery.setHotelId(hotelVo.getId());
        }else if(userRoleVo.getRoleVo().getTitle().equals("录入员")){
            EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
            pageQuery.setHotelId(employeeVo.getHotelId());
        }
        List<Select2Vo> typeList=customerOrderService.getOthersHotel(pageQuery);
        return  typeList;
    }
    //获取房间类型列表，返回select2对象的数据
    @RequestMapping("getTypeList")
    @ResponseBody
    public List<Select2Vo> getTypeList(HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> typeList=houseService.houseTypeList(userVo.getCompanyId(),0l);
        return  typeList;
    }
    @RequestMapping("getHouse/{id}")
    @ResponseBody
    public List<Select2Vo> getHouse(HttpSession session, @PathVariable("id") Long id){
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        if(userRoleVo.getRoleVo().getTitle().equals("店长")){
            HotelVo hotelVo = hotelService.findHotel(userVo.getId());
            pageQuery.setHotelId(hotelVo.getId());
        }else if(userRoleVo.getRoleVo().getTitle().equals("录入员")){
            EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
            pageQuery.setHotelId(employeeVo.getHotelId());
        }
        List<Select2Vo> typeList=customerOrderService.getHouse(pageQuery,id,new Date(),0);
        return  typeList;
    }
    @RequestMapping("/getSubject")
    @ResponseBody
    public List<Select2Vo> getSubject(HttpSession session) throws  Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> subjectList = customerOrderService.getSubject(userVo.getCompanyId());
        return  subjectList;
    }
    @RequestMapping("/getWeb")
    @ResponseBody
    public List<Select2Vo> getWeb(HttpSession session) throws  Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> webList = customerOrderService.getWeb(userVo.getCompanyId());
        return  webList;
    }
    @RequestMapping("/findCustomerOrder/{id}")
    @ResponseBody
    public CustomerOrderVo findcustomerOrder(@PathVariable("id") long id){
        CustomerOrderVo customerOrder = customerOrderService.getById(id);
        return customerOrder;
    }
    @RequestMapping("/customerOrderShenHe")
    @ResponseBody
    public Message customerOrderShenHe(CustomerOrderVo customerOrder,HttpSession session) throws  Exception{
        try{
            UserVo user = (UserVo) session.getAttribute("userVo");
            UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
            if(userRoleVo.equals("录入员")){
                return Message.fail("审核失败，你无权限!");
            }else{
                customerOrder.setHander(user.getId());
                customerOrderService.updateCashStatus(customerOrder);
                return  Message.success("审核成功!");
            }

        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("审核失败!");
        }
    }
    @RequestMapping("/checkerCustomerOrder")
    @ResponseBody
    public Message checkerCustomerOrder(CustomerOrderVo customerOrder,HttpSession session,String manyId) throws  Exception{
        try{
            List<CustomerOrderVo> customerOrderVoList = new ArrayList<>();
            UserVo user = (UserVo) session.getAttribute("userVo");
            UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
            String accounts[] =  manyId.split(",");
            if(userRoleVo.equals("录入员")){
                return Message.fail("审核失败，你无权限!");
            }else{
                for (String str:accounts) {
                    CustomerOrderVo customerOrderVo = new CustomerOrderVo();
                    customerOrderVo.setCheckRemark(customerOrder.getCheckRemark());
                    customerOrderVo.setIsCheck(customerOrder.getIsCheck());
                    customerOrderVo.setHander(user.getId());
                    if(!str.equals("")){
                        customerOrderVo.setId(Long.parseLong(str));
                    }
                    customerOrderVoList.add(customerOrderVo);
                }
                customerOrderService.checkerManyCashAccount(customerOrderVoList);
                return  Message.success("批量审核成功!");
            }

        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("批量审核失败!");
        }
    }
    @RequestMapping("/customerOrderUpdateSave")
    @ResponseBody
    public Message updatecustomerOrder(CustomerOrderVo customerOrder) throws  Exception{
        try{
            customerOrderService.update(customerOrder);
            return  Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/customerOrderUpdateRemark")
    @ResponseBody
    public Message customerOrderUpdateRemark(CustomerOrderVo customerOrder) throws  Exception{
        try{
            customerOrderService.updateRemark(customerOrder);
            return  Message.success("批注成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("批注失败!");
        }
    }
    @RequestMapping("/deleteManyCustomerOrder")
    @ResponseBody
    public Message deleteManycustomerOrder(@Param("manyId") String manyId) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                customerOrderService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("删除失败!");
        }
    }
    @RequestMapping("/deleteCustomerOrder/{id}")
    @ResponseBody
    public Message deletecustomerOrder(@PathVariable("id") long id) throws  Exception{
        try{
            customerOrderService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/customerOrderPage")
    public String table() throws  Exception{
        return "moneyItems/customerOrderList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            customerOrderService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    //退房操作,更改原先住的房间为未入住的状态，并结算押金，退款金额，新增到现金流水表中
    @RequestMapping("endHouse")
    @ResponseBody
    public Message endHouse(CustomerOrderVo customerOrderVo) throws  Exception{
        try{
            customerOrderService.endHouse(customerOrderVo);
            //修改房间状态
            houseService.updateHouseStatus(new StatusQuery(0,customerOrderVo.getHotelId(),customerOrderVo.getHouseId()),new Date());
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    //换房操作，更改当前房间为未入住的房间，修改新入住的房间的状态为未入住
    @RequestMapping("changeHouse")
    @ResponseBody
    public Message changeHouse(CustomerOrderVo customerOrderVo,Long newHouse) throws  Exception{
        try{
            Long houseId = customerOrderVo.getHouseId();
            customerOrderVo.setHouseId(newHouse);
            customerOrderService.changeHouse(customerOrderVo);
            houseService.updateHouseStatus(new StatusQuery(0,customerOrderVo.getHotelId(),houseId),new Date());
            houseService.updateHouseStatus(new StatusQuery(0,customerOrderVo.getHotelId(),customerOrderVo.getHouseId()),customerOrderVo.getCheckoutTime());
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
