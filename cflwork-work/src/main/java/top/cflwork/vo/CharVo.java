package top.cflwork.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CharVo implements Serializable {
    private Long id;
    private Long businessManId;
    private String content;
    private Byte isActive;
    private Date createTime;
    private Date endTime;
    private String imgUrl;
    private BusinessManVo businessManVo;
    private List<CharSayVo> charSayVoList;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<CharSayVo> getCharSayVoList() {
        return charSayVoList;
    }

    public void setCharSayVoList(List<CharSayVo> charSayVoList) {
        this.charSayVoList = charSayVoList;
    }
}
