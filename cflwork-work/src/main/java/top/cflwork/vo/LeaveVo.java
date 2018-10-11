package top.cflwork.vo;

import java.util.Date;

public class LeaveVo {
    private Long id;

    private Long companyId;

    private Long hotelId;

    private Long hotelManagerId;

    private Long userId;

    private Byte totalDays;

    private String reason;

    private Date createTime;

    private Date checkTime;

    private Byte isActive;

    public LeaveVo(Long id, Long companyId, Long hotelId, Long hotelManagerId, Long userId, Byte totalDays, String reason, Date createTime, Date checkTime, Byte isActive) {
        this.id = id;
        this.companyId = companyId;
        this.hotelId = hotelId;
        this.hotelManagerId = hotelManagerId;
        this.userId = userId;
        this.totalDays = totalDays;
        this.reason = reason;
        this.createTime = createTime;
        this.checkTime = checkTime;
        this.isActive = isActive;
    }

    public LeaveVo() {
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

    public Long getHotelManagerId() {
        return hotelManagerId;
    }

    public void setHotelManagerId(Long hotelManagerId) {
        this.hotelManagerId = hotelManagerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Byte totalDays) {
        this.totalDays = totalDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}