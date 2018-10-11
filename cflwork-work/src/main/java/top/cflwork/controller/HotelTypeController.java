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
import top.cflwork.service.HotelTypeService;
import top.cflwork.vo.HotelTypeVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("hotelType")
public class HotelTypeController {

    @Resource
    private HotelTypeService hotelTypeService;
    @RequestMapping("hotelTypeList")
    @ResponseBody
    public PagingBean hotelTypeList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(hotelTypeService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(hotelTypeService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    @RequestMapping("/hotelTypeAddSave")
    @ResponseBody
    public Message addSavehotelType(HotelTypeVo hotelType, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            hotelType.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            hotelTypeService.save(hotelType);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findHotelType/{id}")
    @ResponseBody
    public HotelTypeVo findhotelType(@PathVariable("id") long id){
        HotelTypeVo hotelType = hotelTypeService.getById(id);
        return hotelType;
    }
    @RequestMapping("/hotelTypeUpdateSave")
    @ResponseBody
    public Message updatehotelType(HotelTypeVo hotelType) throws  Exception{
        try{
            hotelTypeService.update(hotelType);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyHotelType")
    @ResponseBody
    public Message deleteManyhotelType(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                hotelTypeService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteHotelType/{id}")
    @ResponseBody
    public Message deletehotelType(@PathVariable("id") long id) throws  Exception{
        try{
            hotelTypeService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/hotelTypePage")
    public String table() throws  Exception{
        return "business/hotelTypeList";
    }
    @RequestMapping("/getHotelTypeList")
    @ResponseBody
    public List<Select2Vo> getHotelTypeList() throws  Exception{
        return hotelTypeService.hotelTypeList();
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            hotelTypeService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
