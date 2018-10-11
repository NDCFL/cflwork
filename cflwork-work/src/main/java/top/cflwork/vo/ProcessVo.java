package top.cflwork.vo;

import java.util.Date;

public class ProcessVo {
    private Long id;

    private String name;

    private String path;

    private String description;

    private Date createTime;

    private Byte isDeploy;

    private Date deployTime;

    private Byte isActive;

    public ProcessVo(Long id, String name, String path, String description, Date createTime, Byte isDeploy, Date deployTime, Byte isActive) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.description = description;
        this.createTime = createTime;
        this.isDeploy = isDeploy;
        this.deployTime = deployTime;
        this.isActive = isActive;
    }

    public ProcessVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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

    public Byte getIsDeploy() {
        return isDeploy;
    }

    public void setIsDeploy(Byte isDeploy) {
        this.isDeploy = isDeploy;
    }

    public Date getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}