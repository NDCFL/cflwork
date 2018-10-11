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
import top.cflwork.service.HotelService;
import top.cflwork.vo.HotelVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("hotel")
public class HotelController {
    @Resource
    private HotelService hotelService;
    @RequestMapping("hotelList")
    @ResponseBody
    public PagingBean hotelList(int pageSize, int pageIndex, HttpSession session,String searchVal) throws  Exception{
        UserVo user = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(hotelService.counts(new PageQuery(searchVal),user.getCompanyId()));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(hotelService.listPages(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal),user.getCompanyId()));
        return pagingBean;
    }
    @RequestMapping("findList")
    @ResponseBody
    public PagingBean findList(int pageSize, int pageIndex, HttpSession session,HotelVo hotelVo) throws  Exception{
        UserVo user = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setCompanyId(user.getCompanyId());
        System.out.println(hotelVo+"========");
        pagingBean.setTotal(hotelService.findCount(pageQuery,hotelVo));
        pagingBean.setrows(hotelService.findPages(pageQuery,hotelVo));
        return pagingBean;
    }
    @RequestMapping("/hotelAddSave")
    @ResponseBody
    public Message addSaveHotel(HotelVo hotel, HttpSession session) throws  Exception {
        try{
            UserVo user = (UserVo) session.getAttribute("userVo");
            hotel.setIsActive((byte)0);
            hotel.setCompanyId(user.getCompanyId());
            hotelService.save(hotel);
            return  Message.success("新增成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findHotel/{id}")
    @ResponseBody
    public HotelVo findhotel(@PathVariable("id") long id){
        HotelVo hotel = hotelService.getById(id);
        return hotel;
    }
    @RequestMapping("/hotelUpdateSave")
    @ResponseBody
    public Message updatehotel(HotelVo hotel) throws  Exception{
        try{
            hotelService.update(hotel);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyHotel")
    @ResponseBody
    public Message deleteManyhotel(@Param("manyId") String manyId,@Param("status") int status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                hotelService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteHotel/{id}")
    @ResponseBody
    public Message deletehotel(@PathVariable("id") long id) throws  Exception{
        try{
            hotelService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/hotelListPage")
    public String table() throws  Exception{
        return "hotel/hotelList";
    }
    @RequestMapping("/getContract")
    @ResponseBody
    public List<Select2Vo> getContract(HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        //只能添加本公司自己的签约，其他公司的必须排除
        List<Select2Vo> contractList = hotelService.getContract();
        return contractList;
    }
    @RequestMapping("/getLandlord")
    @ResponseBody
    public List<Select2Vo> getLandlord() throws  Exception{
        List<Select2Vo> landlordList = hotelService.getLandlord();
        return landlordList;
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            hotelService.updateStatus(new StatusQuery(id,status));
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
