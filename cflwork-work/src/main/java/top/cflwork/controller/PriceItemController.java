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
import top.cflwork.service.PriceItemService;
import top.cflwork.vo.BusinessVo;
import top.cflwork.vo.PriceItemVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("priceItem")
public class PriceItemController {

    @Resource
    private PriceItemService priceItemService;
    @RequestMapping("priceItemList")
    @ResponseBody
    public PagingBean priceItemList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(priceItemService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(priceItemService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }
    @RequestMapping("findPriceItemList")
    @ResponseBody
    public PagingBean findPriceItemList(int pageSize, int pageIndex, String searchVal, HttpSession session,PriceItemVo priceItemVo) throws  Exception{
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(pageSize);
            pagingBean.setCurrentPage(pageIndex);
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setCompanyId(userVo.getCompanyId());
            pageQuery.setSearchVal(searchVal);
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(priceItemService.findPriceItemByCount(pageQuery,priceItemVo));
            pagingBean.setrows(priceItemService.findPriceItemList(pageQuery,priceItemVo));
            return pagingBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    @RequestMapping("/priceItemAddSave")
    @ResponseBody
    public Message addSavepriceItem(PriceItemVo priceItem, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            priceItem.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            priceItemService.save(priceItem);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/priceItemAddSaves")
    @ResponseBody
    public Message priceItemAddSaves(PriceItemVo priceItem) throws  Exception {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(int i=0;i<priceItem.getTime().length;i++){
                priceItem.setCreateTime(sdf.parse(priceItem.getTime()[i]));
                int cnt = priceItemService.findItems(priceItem);
                if(cnt==0){
                    priceItem.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
                    priceItem.setCreateTime(priceItem.getCreateTime());
                    priceItemService.save(priceItem);
                }else{
                    priceItemService.updatePriceItem(priceItem);
                }
            }
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }
    }
    @RequestMapping("/priceItemInfo")
    @ResponseBody
    public Map<Integer,Object> priceItemInfo(BusinessVo businessVo) throws  Exception {
        try{
            Map<Integer,Object> businessVos = new HashMap<>();
            businessVos.put(0,priceItemService.getInfo(businessVo.getTimes()));
            businessVos.put(1,priceItemService.getInfos(businessVo.getTimes()));
            return businessVos;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    @RequestMapping("/priceInfo")
    @ResponseBody
    public Map<Integer,Object> priceInfo(String times,Long id) throws  Exception {
        try{
            Map<Integer,Object> businessVos = new HashMap<>();
            businessVos.put(0,priceItemService.priceInfo(times, id));
            businessVos.put(1,priceItemService.allPriceInfo(times, id));
            return businessVos;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    @RequestMapping("/priceItems")
    @ResponseBody
    public List<PriceItemVo> priceItems(PriceItemVo priceItemVo) throws  Exception {
        return  priceItemService.priceItems(priceItemVo);
    }
    @RequestMapping("/priceItemes")
    @ResponseBody
    public List<PriceItemVo> priceItemes(PriceItemVo priceItemVo) throws  Exception {
        return  priceItemService.findItemes(priceItemVo);
    }
    @RequestMapping("/findPriceItem/{id}")
    @ResponseBody
    public PriceItemVo findpriceItem(@PathVariable("id") long id){
        PriceItemVo priceItem = priceItemService.getById(id);
        return priceItem;
    }
    @RequestMapping("/infos")
    @ResponseBody
    public List<PriceItemVo> infos(String times){
        return priceItemService.infos(times);
    }
    @RequestMapping("/priceItemUpdateSave")
    @ResponseBody
    public Message updatepriceItem(PriceItemVo priceItem) throws  Exception{
        try{
            priceItemService.update(priceItem);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyPriceItem")
    @ResponseBody
    public Message deleteManypriceItem(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                priceItemService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deletePriceItem/{id}")
    @ResponseBody
    public Message deletepriceItem(@PathVariable("id") long id) throws  Exception{
        try{
            priceItemService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/priceItemPage")
    public String table() throws  Exception{
        return "business/priceItemList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            priceItemService.updateStatus(new StatusQuery(id,status));
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
