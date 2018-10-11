package top.cflwork.vo;

import java.io.Serializable;
import java.util.Date;

public class HouseFactPayVo implements Serializable {

    private Long id;
    private Long houseRentId;
    private double payMoney;
    private Date createTime;
    private Byte status;
    private Long companyId;
    private String houseName;
    private HouseRentPayVo houseRentPayVo;

    public Long getHouseRentId() {
        return houseRentId;
    }

    public void setHouseRentId(Long houseRentId) {
        this.houseRentId = houseRentId;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public HouseRentPayVo getHouseRentPayVo() {
        return houseRentPayVo;
    }

    public void setHouseRentPayVo(HouseRentPayVo houseRentPayVo) {
        this.houseRentPayVo = houseRentPayVo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
