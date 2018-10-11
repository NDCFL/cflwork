package top.cflwork.vo;

import java.io.Serializable;
import java.util.Date;

public class CharSayVo implements Serializable {
    private Long id;
    private Long charId;
    private Long businessManId;
    private String content;
    private Byte isActive;
    private Date createTime;
    private String  name;
    private BusinessManVo businessManVo;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCharId() {
        return charId;
    }

    public void setCharId(Long charId) {
        this.charId = charId;
    }

    public Long getBusinessManId() {
        return businessManId;
    }

    public void setBusinessManId(Long businessManId) {
        this.businessManId = businessManId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
