package top.cflwork.controller;

import com.xiaoleilu.hutool.date.DateUtil;
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
import top.cflwork.service.HouseFactPayService;
import top.cflwork.service.RentPayService;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 分成房租板块
 *  统计酒店的总收入，总支出，
 */
@RequestMapping("rentPay")
@Controller
public class RentPayController {
    @Resource
    private RentPayService rentPayService;
    @Resource
    private HouseFactPayService houseFactPayService;

    @RequestMapping("rentPayList")
    @ResponseBody
    public PagingBean houseList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(rentPayService.count(pageQuery));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(rentPayService.listPage(pageQuery));
        return pagingBean;
    }

    @RequestMapping("findRentPayList")
    @ResponseBody
    public PagingBean findRentPayList(int pageSize, int pageIndex, String searchVal, HttpSession session,RentPayVo rentPayVo) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCompanyId(userVo.getCompanyId());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(rentPayService.counts(pageQuery,rentPayVo));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(rentPayService.listPages(pageQuery,rentPayVo));
        return pagingBean;
    }

    @RequestMapping("/getContractMaster")
    @ResponseBody
    public List<Select2Vo> getContractMaster(HttpSession session) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return rentPayService.getContractMaster(userVo.getCompanyId());

    }

    @RequestMapping("/getHotel")
    @ResponseBody
    public List<Select2Vo> getHotel(HttpSession session) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return rentPayService.getHotel(userVo.getCompanyId());

    }

    @RequestMapping("/getHouse/{id}")
    @ResponseBody
    public List<Select2Vo> getHouse(HttpSession session, @PathVariable("id") Long id) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PageQuery pageQuery = new PageQuery();
        pageQuery.setHotelId(id);
        pageQuery.setCompanyId(userVo.getCompanyId());
        return rentPayService.getHouse(pageQuery);

    }

    @RequestMapping("/rentPayAddSave")
    @ResponseBody
    public Message addSaveRentPay(RentPayVo rentPayVo, HttpSession session) throws Exception {
        try {
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            rentPayVo.setCompanyId(userVo.getCompanyId());
            rentPayVo.setIsActive((byte) 0);
            rentPayVo.setSumPay(0);
            //保存当前期的最后一天还款时间
            rentPayVo.setPayPeriodEnd(DateUtil.offsetMonth(rentPayVo.getPayPeriodStart(), rentPayVo.getPayType()));
            //保存合同的最后一天
            rentPayVo.setFactPayTimeEnd(DateUtil.offsetMonth(rentPayVo.getFactPayTimeStart(),rentPayVo.getPayTime()*12));
            rentPayVo.setBaodiPay(BigDecimal.valueOf(0));
            rentPayService.save(rentPayVo);
            return Message.success("新增成功!");
        } catch (Exception E) {
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }

    @RequestMapping("/huankuan")
    @ResponseBody
    public Message huankuan(RentPayVo rentPayVo, HttpSession session) {
        try {
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            RentPayVo house = rentPayService.getById(rentPayVo.getId());
            //准备还款事项
            rentPayService.huankuan(rentPayVo.getId());
            HouseFactPayVo houseFactPayVo = new HouseFactPayVo();
            houseFactPayVo.setPayMoney(rentPayVo.getFirstPay());
            houseFactPayVo.setCompanyId(userVo.getCompanyId());
            houseFactPayVo.setStatus((byte) 0);
            //新增还款记录
            houseFactPayService.save(houseFactPayVo);
            //还款明细表中加入一条数据
            return Message.success("还款成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("还款失败!");
        }
    }

    @RequestMapping("/findRentPay/{id}")
    @ResponseBody
    public RentPayVo findRentPay(@PathVariable("id") long id) {
        RentPayVo house = rentPayService.getById(id);
        return house;
    }

    @RequestMapping("/hotelInfo")
    @ResponseBody
    public RentVo hotelInfo(Long hotelId) {
        if (hotelId == null) {
            return rentPayService.notHotelId();
        } else {
            return rentPayService.haveHotelId(hotelId);
        }

    }

    @RequestMapping("/rentPayUpdateSave")
    @ResponseBody
    public Message updateRentPay(RentPayVo rentPayVo) throws Exception {
        try {
            //保存当前期的最后一天还款时间
            rentPayVo.setPayPeriodEnd(DateUtil.offsetMonth(rentPayVo.getPayPeriodStart(), rentPayVo.getPayType()));
            //保存合同的最后一天
            rentPayVo.setFactPayTimeEnd(DateUtil.offsetMonth(rentPayVo.getFactPayTimeStart(),rentPayVo.getPayTime()*12));
            rentPayVo.setBaodiPay(BigDecimal.valueOf(0));
            rentPayService.update(rentPayVo);
            return Message.success("修改成功!");
        } catch (Exception e) {
            return Message.fail("修改失败!");
        }
    }

    @RequestMapping("/deleteManyRentPay")
    @ResponseBody
    public Message deleteManyhouse(@Param("manyId") String manyId) throws Exception {
        try {
            String str[] = manyId.split(",");
            for (String s : str) {
                rentPayService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/deleteRentPay/{id}")
    @ResponseBody
    public Message deleteRentPay(@PathVariable("id") long id) throws Exception {
        try {
            rentPayService.removeById(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/rentPayPage")
    public String table() throws Exception {
        return "house/rentPayList";
    }

    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id, @PathVariable("status") int status) throws Exception {
        try {
            rentPayService.updateStatus(new StatusQuery(id, status));
            return Message.success("ok");
        } catch (Exception e) {
            return Message.fail("fail");
        }
    }

    /**
     *
     * @param rentPayMoneyVo 参数对象
     * @return 返回列表值
     * @throws Exception 异常
     */
    @RequestMapping("getSubjectMoney")
    @ResponseBody
    public List<RentPayMoneyVo> getSubjectMoney(RentPayMoneyVo rentPayMoneyVo) throws Exception {
        try {
            //如果没有选择时间，则采取默认的一个季度时间为准
            if(rentPayMoneyVo.getTime1()==null || rentPayMoneyVo.getTime2()==null){
                rentPayMoneyVo.setTime1(DateUtil.offsetMonth(new Date(),-3));
                rentPayMoneyVo.setTime2(new Date());
            }
            List<RentPayMoneyVo> rentPayMoneyVoList = rentPayService.getSubjectMoney(rentPayMoneyVo);
            Double sumMoney = rentPayMoneyVoList.stream().mapToDouble(RentPayMoneyVo::getMoney).sum();//和
            rentPayMoneyVoList.get(0).setSumMoney(sumMoney);
            return rentPayMoneyVoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param session 获取用户的基本信息，比对所在的公司
     * @return 返回除分成房租里面包含的酒店
     * @throws Exception
     */
    @RequestMapping("getOtherHotel")
    @ResponseBody
    public List<HotelVo> getOtherHotel(HttpSession session) throws Exception {
        try {
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            return rentPayService.getOtherHotel(userVo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("otherHotelPage")
    public String otherHotelPage() throws Exception {
        return "/moneyItems/otherHotelList";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public Date getDate(Date date, Integer cnt) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.YEAR, cnt);
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return sdf.parse(reStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Date getDateByMonth(Date date, Integer cnt) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH, cnt);
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return sdf.parse(reStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int datediffDay(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    public int monthCount(Date date1, Date date2) {
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
