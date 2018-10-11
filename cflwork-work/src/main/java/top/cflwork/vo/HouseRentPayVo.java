package top.cflwork.vo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HouseRentPayVo {
    private Long id;

    private Long masterId;

    private Long hotelId;

    private Long companyId;

    private Long contractId;

    private BigDecimal totalPay;

    private Date factPayTimeStart;//实际支付开始时间

    private Date factPayTimeEnd;//时间支付结束时间

    private Date factedPayTimeStart;//当前合同支付开始时间

    private Date factedPayTimeEnd;//当前合同支付结束时间

    private Double factPay;//实际支付金额

    private Integer payTime;//签约年限

    private Integer payType;//支付类别

    private Date payPeriodStart;//总支付开始时间

    private Date payPeriodEnd;//总支付结束时间

    private String description;//说明

    private Double spareMoney;//剩余支付金额

    private Integer payFactTime;//实际支付期限

    private Integer isCash;//是否支付

    private Date createTime;//创建时间

    private Byte isActive;//是否激活

    private Double firstPay;//每期支付金额

    private Date firstPayTime;//首次支付时间

    private double sumPay;//已经支付金额

    private Integer payCount;//已经支付到第几期了

    private Double dayPay;//日付金额

    private Double monthPay;//月付金额

    private String houseName;//房间名称

    private ContractMasterVo contractMasterVo;

    private HotelVo hotelVo;

    private Double area;//房间面积

    private Integer houseCount;//楼层

    private Integer shuidian;//水电

    private Integer kongtiao;//空调

    private Integer gongnuan;//供暖

    private Double wuye;//物业费用单位为平米

    private String qixian;//期限

    private Integer zhaungxiu;

    private Integer[] count;

    private String loopTime;

    private Date endTime;

    private String name;

    private String phone;

    private Float thisMoney;//本期需要支付的金额

    private Float thisPayMoney;

    private Integer thisCount;//本次还款总期数

    private Double yajin;

    private Double bucaofei;

    private Integer buzhiqi;

    private String nid;

    private Integer zhuangxiu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public Date getFactPayTimeStart() {
        return factPayTimeStart;
    }

    public void setFactPayTimeStart(Date factPayTimeStart) {
        this.factPayTimeStart = factPayTimeStart;
    }

    public Date getFactPayTimeEnd() {
        return factPayTimeEnd;
    }

    public void setFactPayTimeEnd(Date factPayTimeEnd) {
        this.factPayTimeEnd = factPayTimeEnd;
    }

    public Date getFactedPayTimeStart() {
        return factedPayTimeStart;
    }

    public void setFactedPayTimeStart(Date factedPayTimeStart) {
        this.factedPayTimeStart = factedPayTimeStart;
    }

    public Date getFactedPayTimeEnd() {
        return factedPayTimeEnd;
    }

    public void setFactedPayTimeEnd(Date factedPayTimeEnd) {
        this.factedPayTimeEnd = factedPayTimeEnd;
    }

    public Double getFactPay() {
        return factPay;
    }

    public void setFactPay(Double factPay) {
        this.factPay = factPay;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getPayPeriodStart() {
        return payPeriodStart;
    }

    public void setPayPeriodStart(Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public Date getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public void setPayPeriodEnd(Date payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }

    public String getDescription() {
        return description==""?"暂无说明":description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSpareMoney() {
        return spareMoney;
    }

    public void setSpareMoney(Double spareMoney) {
        this.spareMoney = spareMoney;
    }

    public Integer getPayFactTime() {
        return payFactTime;
    }

    public void setPayFactTime(Integer payFactTime) {
        this.payFactTime = payFactTime;
    }

    public Integer getIsCash() {
        int cnt = monthCnt();
        if(cnt<0){
            return 1;
        }else{
            return  0;
        }
    }

    public void setIsCash(Integer isCash) {
        this.isCash = isCash;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Double getFirstPay() {
        return firstPay;
    }

    public void setFirstPay(Double firstPay) {
        this.firstPay = firstPay;
    }

    public Date getFirstPayTime() {
        return firstPayTime;
    }

    public void setFirstPayTime(Date firstPayTime) {
        this.firstPayTime = firstPayTime;
    }

    public double getSumPay() {
        return sumPay;
    }

    public void setSumPay(double sumPay) {
        this.sumPay = sumPay;
    }

    public Integer getPayCount() {
        return payCount;
    }

    public void setPayCount(Integer payCount) {
        this.payCount = payCount;
    }

    public Double getDayPay() {
        return dayPay;
    }

    public void setDayPay(Double dayPay) {
        this.dayPay = dayPay;
    }

    public Double getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(Double monthPay) {
        this.monthPay = monthPay;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public ContractMasterVo getContractMasterVo() {
        return contractMasterVo;
    }

    public void setContractMasterVo(ContractMasterVo contractMasterVo) {
        this.contractMasterVo = contractMasterVo;
    }

    public HotelVo getHotelVo() {
        return hotelVo;
    }

    public void setHotelVo(HotelVo hotelVo) {
        this.hotelVo = hotelVo;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    public Integer getShuidian() {
        return shuidian;
    }

    public void setShuidian(Integer shuidian) {
        this.shuidian = shuidian;
    }

    public Integer getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(Integer kongtiao) {
        this.kongtiao = kongtiao;
    }

    public Integer getGongnuan() {
        return gongnuan;
    }

    public void setGongnuan(Integer gongnuan) {
        this.gongnuan = gongnuan;
    }

    public Double getWuye() {
        return wuye;
    }

    public void setWuye(Double wuye) {
        this.wuye = wuye;
    }

    public Integer[] getCount() {
        return count;
    }

    public void setCount(Integer[] count) {
        this.count = count;
    }

    public String getLoopTime() {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(factPayTimeStart)+"至"+format1.format(factPayTimeEnd);
    }

    public void setLoopTime(String loopTime) {
        this.loopTime = loopTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //计算本期应付多少钱
    public Float getThisMoney() {
        int cnt = monthCnt();
        System.out.println(cnt+"====????");
        if(cnt<0){
            return 0.0f;
        }else{
            return  Float.parseFloat(firstPay+"");
        }
    }

    public void setThisMoney(Float thisMoney) {
        this.thisMoney = thisMoney;
    }
    public Integer monthCnt(){
       try{
           if(factPayTimeStart.getYear()!=new Date().getYear()){
               return 1;
           }else{
               Calendar bef = Calendar.getInstance();
               Calendar aft = Calendar.getInstance();
               bef.setTime(factPayTimeEnd);
               aft.setTime(new Date());
               int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
               int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
               //计算当前是第几期
               int monthCount = Math.abs(month + result);
               return payCount-((int)Math.ceil((float)monthCount/payType));
           }
       }catch (Exception e){
           System.out.println("计算相隔期数出错");
           e.printStackTrace();
            return 0;
       }
    }
    public static void main(String [] arg){
        try{
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(format1.parse("2020-02-01"));
            aft.setTime(new Date());
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            //计算当前是第几期
            int monthCount = Math.abs(month + result);
            System.out.println(monthCount+"====>>>");
        }catch (Exception e){
            System.out.println("计算相隔期数出错");
            e.printStackTrace();
        }
    }
    public Float getThisPayMoney() {
        return thisPayMoney;
    }

    public void setThisPayMoney(Float thisPayMoney) {
        this.thisPayMoney = thisPayMoney;
    }

    public Integer getThisCount() {
        return thisCount;
    }

    public void setThisCount(Integer thisCount) {
        this.thisCount = thisCount;
    }

    public Double getYajin() {
        return yajin;
    }

    public void setYajin(Double yajin) {
        this.yajin = yajin;
    }

    public Double getBucaofei() {
        return bucaofei;
    }

    public void setBucaofei(Double bucaofei) {
        this.bucaofei = bucaofei;
    }

    public Integer getBuzhiqi() {
        return buzhiqi;
    }

    public void setBuzhiqi(Integer buzhiqi) {
        this.buzhiqi = buzhiqi;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Integer getZhaungxiu() {
        return zhaungxiu;
    }

    public void setZhaungxiu(Integer zhaungxiu) {
        this.zhaungxiu = zhaungxiu;
    }

    public Integer getZhuangxiu() {
        return zhuangxiu;
    }

    public void setZhuangxiu(Integer zhuangxiu) {
        this.zhuangxiu = zhuangxiu;
    }

    public String getQixian() {
        return qixian;
    }

    public void setQixian(String qixian) {
        this.qixian = qixian;
    }
}