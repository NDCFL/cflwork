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
import top.cflwork.service.HouseFactPayService;
import top.cflwork.service.HouseRentPayService;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenfeilong on 2017/12/24.
 */
@Controller
@RequestMapping("houseRentPay")
public class HouseRentPayController  {
    @Resource
    private HouseRentPayService houseRentPayService;
    @Resource
    private HouseFactPayService houseFactPayService;
    @RequestMapping("houseRentPayList")
    @ResponseBody
    public PagingBean houseList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(houseRentPayService.count(pageQuery));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(houseRentPayService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("chaoqiPayList/{temp}")
    @ResponseBody
    public PagingBean chaoqiPayList(@PathVariable("temp") Integer temp,int pageSize, int pageIndex, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setTemp(temp);
        pagingBean.setTotal(houseRentPayService.chaoqicount(pageQuery));
        pagingBean.setrows(houseRentPayService.chaoqilistPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("findHouseRentPayList")
    @ResponseBody
    public PagingBean findHouseRentPayList(int pageSize, int pageIndex, HouseRentPayVo houseRentPayVo, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setTotal(houseRentPayService.counts(pageQuery,houseRentPayVo));
        pagingBean.setrows(houseRentPayService.pageLists(pageQuery,houseRentPayVo));
        return pagingBean;
    }
    @RequestMapping("/getContractMaster")
    @ResponseBody
    public List<Select2Vo> getContractMaster(HttpSession session) throws  Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return  houseRentPayService.getContractMaster(userVo.getCompanyId());

    }
    @RequestMapping("/getHotel")
    @ResponseBody
    public List<Select2Vo> getHotel(HttpSession session) throws  Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return  houseRentPayService.getHotel(userVo.getCompanyId());
    }
    @RequestMapping("/houseRentPayAddSave")
    @ResponseBody
    public Message addSaveHouseRentPay(HouseRentPayVo houseRentPayVo,HttpSession session) throws  Exception {
        try{
            List<HouseRentPayVo> houseRentPayVoList = new ArrayList<>();
            houseRentPayVo.setPayPeriodEnd(getDate(houseRentPayVo.getPayPeriodStart(),houseRentPayVo.getPayTime()));
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            houseRentPayVo.setCompanyId(userVo.getCompanyId());
            houseRentPayVo.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            Integer countInfo[] = houseRentPayVo.getCount();
            houseRentPayVo.setNid(UUID.randomUUID().toString());
            houseRentPayVo.setIsCash(0);
            int cnt = countInfo.length;
            for (int i=0;i<cnt;i++){
                houseRentPayVo.setSpareMoney(Double.parseDouble(countInfo[i]+""));//当前合同剩余支付金额，默认初始化为未支付状态
                houseRentPayVo.setPayFactTime(1);//最小单位为1年
                BigDecimal b = new BigDecimal(Double.parseDouble(countInfo[i]+""));
                houseRentPayVo.setFactPay(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());//每个合同所需支付的全年金额总和
                houseRentPayVo.setFirstPay(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()/(12/houseRentPayVo.getPayType()));//首付租金，根据选择的付款状态来决定
                houseRentPayVo.setPayCount(12/houseRentPayVo.getPayType());//分多少期付款
                houseRentPayVo.setFactPayTimeStart(getDate(houseRentPayVo.getPayPeriodStart(),i));//第一期合同开始时间
                houseRentPayVo.setFactPayTimeEnd(getDate(houseRentPayVo.getPayPeriodStart(),(i+1)));//第一期合同结束时间
                houseRentPayVo.setFactedPayTimeStart(getDate(houseRentPayVo.getFirstPayTime(),i));//第一个合同首付租金日期
                houseRentPayVo.setFactedPayTimeEnd(getDateByMonth(houseRentPayVo.getFactedPayTimeStart(),houseRentPayVo.getPayType()));//第一个合同首付结束时间
                houseRentPayVo.setDayPay(houseRentPayVo.getFactPay()/(datediffDay(getDate(houseRentPayVo.getFirstPayTime(),i),getDate(houseRentPayVo.getPayPeriodStart(),(i+1)))));//每天付款金额总金额/总天数
                houseRentPayVo.setMonthPay(houseRentPayVo.getFactPay()/(monthCount(getDate(houseRentPayVo.getFirstPayTime(),i),getDate(houseRentPayVo.getPayPeriodStart(),(i+1)))));//每月的租金总和
                houseRentPayVo.setFirstPayTime(getDate(houseRentPayVo.getFirstPayTime(),i));
                houseRentPayVoList.add(houseRentPayVo);
                String qixian = "";
                for(int j=0;j<houseRentPayVo.getPayCount();j++){
                    if(j!=(houseRentPayVo.getPayCount()-1)){
                        qixian +=getDateByString(houseRentPayVo.getFirstPayTime(),j)+",";
                    }else{
                        qixian +=getDateByString(houseRentPayVo.getFirstPayTime(),j);
                    }
                }
                houseRentPayVo.setQixian(qixian);
                houseRentPayService.save(houseRentPayVo);
            }
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/huankuan")
    @ResponseBody
    public Message huankuan(HouseRentPayVo houseRentPayVo,HttpSession session){
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            houseRentPayVo.setThisCount(houseRentPayVo.getCount().length);
            // /准备还款事项
            houseRentPayService.huankuan(houseRentPayVo);
            HouseFactPayVo houseFactPayVo = new HouseFactPayVo();
            houseFactPayVo.setHouseRentId(houseRentPayVo.getId());
            //本次付款总额
            houseFactPayVo.setPayMoney(houseRentPayVo.getThisPayMoney());
            houseFactPayVo.setCompanyId(userVo.getCompanyId());
            houseFactPayVo.setStatus((byte)0);
            //新增还款记录
            houseFactPayService.save(houseFactPayVo);
            //还款明细表中加入一条数据
            return Message.success("还款成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("还款失败!");
        }
    }
    @RequestMapping("/findHouseRentPay/{id}")
    @ResponseBody
    public HouseRentPayVo findHouseRentPay(@PathVariable("id") long id){
        HouseRentPayVo house = houseRentPayService.getById(id);
        return house;
    }
    @RequestMapping("/hotelInfo")
    @ResponseBody
    public HouseRentVo hotelInfo(Long hotelId){
        HouseRentVo houseRentVo = new HouseRentVo();
        if(hotelId==null){
            houseRentVo = houseRentPayService.notHotelId();
            if(houseRentVo==null){
                houseRentVo = new HouseRentVo();
            }
            return houseRentVo;
        }else{
            houseRentVo = houseRentPayService.haveHotelId(hotelId);
            if(houseRentVo==null){
                houseRentVo = new HouseRentVo();
            }
            return houseRentVo;
        }

    }
    @RequestMapping("/findHotelInfo")
    @ResponseBody
    public HouseRentVo findHotelInfo(HouseRentPayVo houseRentPayVo){
        return  houseRentPayService.findHotelId(houseRentPayVo);
    }
    @RequestMapping("/houseRentPayUpdateSave")
    @ResponseBody
    public Message updateHouseRentPay(HouseRentPayVo houseRentPayVo) throws  Exception{
        try{
            houseRentPayService.update(houseRentPayVo);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyHouseRentPay")
    @ResponseBody
    public Message deleteManyhouse(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                houseRentPayService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteHouseRentPay/{id}")
    @ResponseBody
    public Message deleteHouseRentPay(@PathVariable("id") long id) throws  Exception{
        try{
            houseRentPayService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/houseRentPayPage")
    public String table() throws  Exception{
        return "house/houseRentPayList";
    }

    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            houseRentPayService.updateStatus(new StatusQuery(id,status));
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
    public Date getDate(Date date, Integer cnt){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.YEAR,cnt);
            Date dt1=rightNow.getTime();
            String reStr = sdf.format(dt1);
            return  sdf.parse(reStr);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public String getDateByString(Date date, Integer cnt){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH,cnt);
            Date dt1=rightNow.getTime();
            String reStr = sdf.format(dt1);
            return  reStr;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public Date getDateByMonth(Date date, Integer cnt){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH,cnt);
            Date dt1=rightNow.getTime();
            String reStr = sdf.format(dt1);
            return  sdf.parse(reStr);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public int datediffDay(Date date1,Date date2){
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
    public int monthCount(Date date1,Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(date1);
        aft.setTime(date2);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }
}
