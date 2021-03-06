package top.cflwork.vo;

import lombok.Data;

import java.util.Date;
@Data
public class PermissionVo {
    private static final long serialVersionUID = 1L;
    //
    private Long id;
    // 父菜单ID，一级菜单为0
    private Long parentId;
    // 菜单名称
    private String name;
    // 菜单URL
    private String url;
    // 授权(多个用逗号分隔，如：user:list,user:create)
    private String perms;
    // 类型 0：目录 1：菜单 2：按钮
    private Integer type;
    // 菜单图标
    private String icon;
    // 排序
    private Integer orderNum;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date updateTime;
    //父菜单
    private String pName;
}