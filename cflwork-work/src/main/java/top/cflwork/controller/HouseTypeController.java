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
import top.cflwork.service.HouseService;
import top.cflwork.service.HouseTypeService;
import top.cflwork.vo.HouseTypeVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("houseType")
public class HouseTypeController {
    @Resource
    private HouseTypeService houseTypeService;
    @Resource
    private HouseService houseService;
    @RequestMapping("houseTypeList")
    @ResponseBody
    public PagingBean houseTypeList(int pageSize, int pageIndex,String searchVal,HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(houseTypeService.count(pageQuery));
        pagingBean.setrows(houseTypeService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("findHouseTypeList")
    @ResponseBody
    public PagingBean findHouseTypeList(int pageSize, int pageIndex,HttpSession session,HouseTypeVo houseTypeVo) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setCompanyId(userVo.getCompanyId());
        pagingBean.setTotal(houseTypeService.findCount(pageQuery,houseTypeVo));
        pagingBean.setrows(houseTypeService.findPage(pageQuery,houseTypeVo));
        return pagingBean;
    }
    @RequestMapping("/houseTypeAddSave")
    @ResponseBody
    public Message addSavehouseType(HouseTypeVo houseType, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            houseType.setCompanyId(userVo.getCompanyId());
            houseType.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            int cnt = houseTypeService.getHouseType(houseType.getTitle(),houseType.getHotelId());
            if(cnt>0){
                return  Message.fail("请不要新增重复的房型");
            }else{
                houseTypeService.save(houseType);
                return  Message.success("新增成功!");
            }
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("getHotelList")
    @ResponseBody
    public List<Select2Vo> getHotelList(HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> hotelList=houseService.hotelList(userVo.getCompanyId());
        return  hotelList;
    }
    @RequestMapping("/findHouseType/{id}")
    @ResponseBody
    public HouseTypeVo findhouseType(@PathVariable("id") long id){
        HouseTypeVo houseType = houseTypeService.getById(id);
        return houseType;
    }
    @RequestMapping("/houseTypeUpdateSave")
    @ResponseBody
    public Message updatehouseType(HouseTypeVo houseType) throws  Exception{
        try{
            houseTypeService.update(houseType);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyHouseType")
    @ResponseBody
    public Message deleteManyhouseType(@Param("manyId") String manyId) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                houseTypeService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("删除失败!");
        }
    }
    @RequestMapping("/updateManyHouseType")
    @ResponseBody
    public Message updateManyHouseType(@Param("manyId") String manyId,@Param("status") int status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                houseTypeService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteHouseType/{id}")
    @ResponseBody
    public Message deletehouseType(@PathVariable("id") long id) throws  Exception{
        try{
            houseTypeService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/houseTypePage")
    public String table() throws  Exception{
        return "house/houseTypeList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            houseTypeService.updateStatus(new StatusQuery(id,status));
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
