package top.cflwork.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerServiceVo {
    private Long id;

    private Long orderId;

    private Long companyId;

    private Long hotelId;

    private Long houseId;

    private String houseCardTitle;

    private Long subjectId;

    private Byte accountType;

    private Date accountTime;

    private BigDecimal totalPay;

    private Byte isPay;

    private Date createTime;

    private Byte isCheck;

    private String checkRemark;

    private Byte isActive;

    public CustomerServiceVo(Long id, Long orderId, Long companyId, Long hotelId, Long houseId, String houseCardTitle, Long subjectId, Byte accountType, Date accountTime, BigDecimal totalPay, Byte isPay, Date createTime, Byte isCheck, String checkRemark, Byte isActive) {
        this.id = id;
        this.orderId = orderId;
        this.companyId = companyId;
        this.hotelId = hotelId;
        this.houseId = houseId;
        this.houseCardTitle = houseCardTitle;
        this.subjectId = subjectId;
        this.accountType = accountType;
        this.accountTime = accountTime;
        this.totalPay = totalPay;
        this.isPay = isPay;
        this.createTime = createTime;
        this.isCheck = isCheck;
        this.checkRemark = checkRemark;
        this.isActive = isActive;
    }

    public CustomerServiceVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getHouseCardTitle() {
        return houseCardTitle;
    }

    public void setHouseCardTitle(String houseCardTitle) {
        this.houseCardTitle = houseCardTitle == null ? null : houseCardTitle.trim();
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public Byte getIsPay() {
        return isPay;
    }

    public void setIsPay(Byte isPay) {
        this.isPay = isPay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}