package top.cflwork.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HouseService;
import top.cflwork.vo.HouseVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Controller
@RequestMapping("house")
public class HouseController {
    @Resource
    private HouseService houseService;
    @RequestMapping("houseList")
    @ResponseBody
    public PagingBean houseList(int pageSize, int pageIndex,String searchVal,HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(houseService.count(pageQuery));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(houseService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("findHouseList")
    @ResponseBody
    public PagingBean findHouseList(int pageSize, int pageIndex,HouseVo houseVo,HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pagingBean.setTotal(houseService.findCount(pageQuery,houseVo));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(houseService.findPages(pageQuery,houseVo));
        return pagingBean;
    }
    @RequestMapping("/houseAddSave")
    @ResponseBody
    public Message addSaveHouse(HouseVo house,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            String card[] = house.getCardTitle().split(",");
            for (String str: card) {
                house.setCardTitle(str);
                house.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
                house.setCompanyId(userVo.getCompanyId());
                house.setHouseStatus((byte)0);
                houseService.save(house);
            }
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findHouse/{id}")
    @ResponseBody
    public HouseVo findhouse(@PathVariable("id") long id){
        HouseVo house = houseService.getById(id);
        return house;
    }
    @RequestMapping("/houseUpdateSave")
    @ResponseBody
    public Message updatehouse(HouseVo house) throws  Exception{
        try{
            houseService.update(house);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyHouse")
    @ResponseBody
    public Message deleteManyhouse(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                houseService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("状态修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("状态修改失败!");
        }
    }
    @RequestMapping("/deleteHouse/{id}")
    @ResponseBody
    public Message deletehouse(@PathVariable("id") long id) throws  Exception{
        try{
            houseService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/housePage")
    public String table() throws  Exception{
        return "house/houseList";
    }
    @RequestMapping("/housePageList")
    public String housePageList() throws  Exception{
        return "house/room";
    }
    @RequestMapping("/getHouseCardTitle/{id}")
    @ResponseBody
    public HouseVo getHouseCardTitle(@PathVariable("id") long id) throws  Exception{
        String card = houseService.getHouseCardTitle(id);
        HouseVo houseVo = new HouseVo();
        houseVo.setCardTitle(card);
        return houseVo;
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            houseService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @RequestMapping("addHousePage")
    public String addHousePage(){

        return  "house/houseAdd";
    }
    @RequestMapping("updateHouse/{id}")
    public ModelAndView updateHouse(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("house/houseUpdate");
        modelAndView.addObject("id",id);
        return  modelAndView;
    }
    //获取房间类型列表，返回select2对象的数据
    @RequestMapping("getTypeList/{id}")
    @ResponseBody
    public List<Select2Vo> getTypeList(@PathVariable("id")long id, HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> typeList=houseService.houseTypeList(userVo.getCompanyId(),id);
        return  typeList;
    }
    @RequestMapping("getHotelList")
    @ResponseBody
    public List<Select2Vo> getHotelList(HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> hotelList=houseService.hotelList(userVo.getCompanyId());
        return  hotelList;
    }
    @RequestMapping("getUserList")
    @ResponseBody
    public List<Select2Vo> getUserList(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> userList = houseService.userList(userVo.getCompanyId());
        return userList;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
