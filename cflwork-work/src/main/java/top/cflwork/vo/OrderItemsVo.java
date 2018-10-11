package top.cflwork.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderItemsVo implements Serializable {
    private long id;
    private Long businessManId;
    private BigDecimal money;
    private int status;
    private Date createTime;

    public OrderItemsVo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getBusinessManId() {
        return businessManId;
    }

    public void setBusinessManId(Long businessManId) {
        this.businessManId = businessManId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
