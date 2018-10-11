package top.cflwork.dto;

import java.util.Date;

/**
 * 权限DTO<br />
 * 创建于2017-09-11
 *
 * @author 陈飞龙
 * @version 1.0
 */
public class PermissionDTO extends BaseDTO {
    private static final long serialVersionUID = -6442922602180183519L;

    private String title;
    private String permission;
    private String description;
    private Date createTime;
    private Integer isActive;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}
