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
import top.cflwork.service.EmployeeService;
import top.cflwork.service.HotelService;
import top.cflwork.service.HouseOthersItemService;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/12.
 */
@Controller
@RequestMapping("item")
public class HouseOthersItemController {
    @Resource
    private HouseOthersItemService houseOthersItemService;
    @Resource
    private HotelService hotelService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping("houseOthersItemList")
    @ResponseBody
    public PagingBean houseOthersItemList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setSearchVal(searchVal);
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setPageNo(pagingBean.getStartIndex());
        if(userRoleVo.getRoleVo().getTitle().equals("店长")){
            HotelVo hotelVo = hotelService.findHotel(userVo.getId());
            pageQuery.setHotelId(hotelVo.getId());
        }else{
            EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
            pageQuery.setHotelId(employeeVo.getId());
        }
        pagingBean.setTotal(houseOthersItemService.counts(pageQuery));
        pagingBean.setrows(houseOthersItemService.listPages(pageQuery));
        return pagingBean;
    }
    @RequestMapping("orderList/{houseId}")
    @ResponseBody
    public List<HouseOthersItemVo> orderList(@PathVariable("houseId") Long houseId, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setHouseId(houseId);
        UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
        if(userRoleVo.getRoleVo().getTitle().equals("店长")){
            HotelVo hotelVo = hotelService.findHotel(userVo.getId());
            pageQuery.setHotelId(hotelVo.getId());
        }else if(userRoleVo.getRoleVo().getTitle().equals("总管理员")){
            EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
            pageQuery.setHotelId(employeeVo.getHotelId());
        }else {
            EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
            pageQuery.setHotelId(employeeVo.getHotelId());
        }
        List<HouseOthersItemVo> houseOthersItemVoList= houseOthersItemService.listPage(pageQuery);
        return houseOthersItemVoList;
    }
    @RequestMapping("/getSubject")
    @ResponseBody
    public List<Select2Vo> getSubject(HttpSession session) throws  Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> subjectList = houseOthersItemService.subjectList(userVo.getCompanyId());
        return  subjectList;
    }
    @RequestMapping("/houseOthersItemAddSave")
    @ResponseBody
    public Message addSavehouseOthersItem(HouseOthersItemVo houseOthersItem, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            UserRoleVo userRoleVo = (UserRoleVo) session.getAttribute("userRole");
            houseOthersItem.setCompanyId(userVo.getCompanyId());
            if(userRoleVo.getRoleVo().getTitle().equals("店长")){
                HotelVo hotelVo = hotelService.findHotel(userVo.getId());
                houseOthersItem.setHotelId(hotelVo.getId());
            }else if(userRoleVo.getRoleVo().getTitle().equals("录入员")){
                EmployeeVo employeeVo = employeeService.getHotelId(userVo.getId());
                houseOthersItem.setHotelId(employeeVo.getHotelId());
            }

            houseOthersItemService.save(houseOthersItem);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findHouseOthersItem/{id}")
    @ResponseBody
    public HouseOthersItemVo findhouseOthersItem(@PathVariable("id") long id){
        HouseOthersItemVo houseOthersItem = houseOthersItemService.getById(id);
        return houseOthersItem;
    }
    @RequestMapping("/houseOthersItemUpdateSave")
    @ResponseBody
    public Message updatehouseOthersItem(HouseOthersItemVo houseOthersItem) throws  Exception{
        try{
            houseOthersItemService.update(houseOthersItem);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyHouseOthersItem")
    @ResponseBody
    public Message deleteManyhouseOthersItem(@Param("manyId") String manyId) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                houseOthersItemService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("删除失败!");
        }
    }
    @RequestMapping("/deleteHouseOthersItem/{id}")
    @ResponseBody
    public Message deletehouseOthersItem(@PathVariable("id") long id) throws  Exception{
        try{
            houseOthersItemService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/houseOthersItemPage")
    public String table() throws  Exception{
        return "houseOthersItem/houseOthersItemList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            houseOthersItemService.updateStatus(new StatusQuery(id,status));
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
