package top.cflwork.vo;

import java.util.Date;

public class CashSubjectVo {
    private Long id;

    private String title;

    private String description;

    private Date createTime;

    private Byte isActive;

    private Long companyId;

    private Long parentId;//父节点



    public CashSubjectVo(Long id, String title, String description, Date createTime, Byte isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createTime = createTime;
        this.isActive = isActive;
    }

    public CashSubjectVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}