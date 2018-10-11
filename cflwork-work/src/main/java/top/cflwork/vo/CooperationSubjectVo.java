package top.cflwork.vo;

import java.util.Date;

public class CooperationSubjectVo {
    private Long id;

    private String title;

    private String description;

    private Date createTime;

    private Long companyId;

    private Byte isActive;


    public CooperationSubjectVo(Long id, String title, String description, Date createTime, Long companyId, Byte isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createTime = createTime;
        this.companyId = companyId;
        this.isActive = isActive;
    }

    public CooperationSubjectVo() {
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}