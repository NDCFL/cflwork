package top.cflwork.vo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CashAccountsVo {
    private Long id;

    private Long companyId;

    private Long hotelId;

    private Byte accountType;

    private Date accountTime;

    private Date accountTimeEnd;

    private BigDecimal totalPay;

    private Long subjectId;

    private String description;

    private String remark;

    private Date createTime;

    private Byte isActive;

    private Double dayPay;

    private Long payTypeId;

    private double outSum;

    private Double inSum;

    private Double yu;

    private CompanyVo companyVo;

    private HotelVo hotelVo;

    private UserVo userVo;

    private PaymentTypeVo paymentTypeVo;

    private Byte isCash;//是否结算
    private Byte cashStatus;//支付审核状态
    private String reason;//审核备注
    private Long hander;//操作人
    private String hand;
    private CashSubjectVo cashSubjectVo;

    private Date endTime;
    private Date loopTime;
    private Integer sumCount;
    private Double inMoneySum;//搜索总收入金额
    private Double outMoneySum;//搜索总支出金额
    private Double jieyuMoneySum;//搜索总结余金额
    private String en;

    public CashAccountsVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public CompanyVo getCompanyVo() {
        return companyVo;
    }

    public void setCompanyVo(CompanyVo companyVo) {
        this.companyVo = companyVo;
    }

    public HotelVo getHotelVo() {
        return hotelVo;
    }

    public void setHotelVo(HotelVo hotelVo) {
        this.hotelVo = hotelVo;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Byte getIsCash() {
        return isCash;
    }

    public void setIsCash(Byte isCash) {
        this.isCash = isCash;
    }

    public Byte getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(Byte cashStatus) {
        this.cashStatus = cashStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getHander() {
        return hander;
    }

    public void setHander(Long hander) {
        this.hander = hander;
    }

    public CashSubjectVo getCashSubjectVo() {
        return cashSubjectVo;
    }

    public void setCashSubjectVo(CashSubjectVo cashSubjectVo) {
        this.cashSubjectVo = cashSubjectVo;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public Date getAccountTimeEnd() {
        return accountTimeEnd;
    }

    public void setAccountTimeEnd(Date accountTimeEnd) {
        this.accountTimeEnd = accountTimeEnd;
    }

    public Double getDayPay() {
        return dayPay;
    }

    public void setDayPay(Double dayPay) {
        this.dayPay = dayPay;
    }

    public Long getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Long payTypeId) {
        this.payTypeId = payTypeId;
    }

    public PaymentTypeVo getPaymentTypeVo() {
        return paymentTypeVo;
    }

    public void setPaymentTypeVo(PaymentTypeVo paymentTypeVo) {
        this.paymentTypeVo = paymentTypeVo;
    }

    public double getOutSum() {
        return outSum;
    }

    public void setOutSum(double outSum) {
        this.outSum = outSum;
    }

    public Double getInSum() {
        return inSum;
    }

    public void setInSum(Double inSum) {
        this.inSum = inSum;
    }

    public Double getYu() {
        return yu;
    }

    public void setYu(Double yu) {
        this.yu = yu;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLoopTime() {
        return loopTime;
    }

    public void setLoopTime(Date loopTime) {
        this.loopTime = loopTime;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }

    public Double getInMoneySum() {
        return inMoneySum;
    }

    public void setInMoneySum(Double inMoneySum) {
        this.inMoneySum = inMoneySum;
    }

    public Double getOutMoneySum() {
        return outMoneySum;
    }

    public void setOutMoneySum(Double outMoneySum) {
        this.outMoneySum = outMoneySum;
    }

    public Double getJieyuMoneySum() {
        return jieyuMoneySum;
    }

    public void setJieyuMoneySum(Double jieyuMoneySum) {
        this.jieyuMoneySum = jieyuMoneySum;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public  String getLoop(){
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return  format1.format(accountTime)+"起"+format1.format(accountTimeEnd)+"止";
    }
}