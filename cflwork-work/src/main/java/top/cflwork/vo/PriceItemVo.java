package top.cflwork.vo;

import java.io.Serializable;
import java.util.Date;

public class PriceItemVo implements Serializable {
    private Long id;
    private Long businessManId;
    private Long hotelTypeId;
    private Long price;
    private Integer number;
    private Byte isActive;
    private Date createTime;
    private Date endTime;
    private BusinessManVo businessManVo;
    private HotelTypeVo hotelTypeVo;
    private String hotelName;
    private String time[];
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessManId() {
        return businessManId;
    }

    public void setBusinessManId(Long businessManId) {
        this.businessManId = businessManId;
    }

    public Long getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(Long hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BusinessManVo getBusinessManVo() {
        return businessManVo;
    }

    public void setBusinessManVo(BusinessManVo businessManVo) {
        this.businessManVo = businessManVo;
    }

    public HotelTypeVo getHotelTypeVo() {
        return hotelTypeVo;
    }

    public void setHotelTypeVo(HotelTypeVo hotelTypeVo) {
        this.hotelTypeVo = hotelTypeVo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }
}
