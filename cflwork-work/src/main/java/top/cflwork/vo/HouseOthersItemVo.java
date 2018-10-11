package top.cflwork.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/12/12.
 */
public class HouseOthersItemVo implements Serializable{
    private Long id;
    private Long companyId;
    private Long hotelId;
    private Long houseId;
    private String itemName;
    private BigDecimal payMoney;
    private Date payTime;
    private Byte isCash;
    private Long hander;
    private String remark;
    private Date createTime;
    private CompanyVo companyVo;
    private HouseVo houseVo;
    private HotelVo hotelVo;
    private ServiceSubjectVo serviceSubjectVo;
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

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Byte getIsCash() {
        return isCash;
    }

    public void setIsCash(Byte isCash) {
        this.isCash = isCash;
    }

    public Long getHander() {
        return hander;
    }

    public void setHander(Long hander) {
        this.hander = hander;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CompanyVo getCompanyVo() {
        return companyVo;
    }

    public void setCompanyVo(CompanyVo companyVo) {
        this.companyVo = companyVo;
    }

    public HouseVo getHouseVo() {
        return houseVo;
    }

    public void setHouseVo(HouseVo houseVo) {
        this.houseVo = houseVo;
    }

    public HotelVo getHotelVo() {
        return hotelVo;
    }

    public void setHotelVo(HotelVo hotelVo) {
        this.hotelVo = hotelVo;
    }

    public ServiceSubjectVo getServiceSubjectVo() {
        return serviceSubjectVo;
    }

    public void setServiceSubjectVo(ServiceSubjectVo serviceSubjectVo) {
        this.serviceSubjectVo = serviceSubjectVo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
