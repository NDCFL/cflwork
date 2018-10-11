package top.cflwork.service;

import top.cflwork.dao.BaseDAO;
import top.cflwork.vo.RolePermissionVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/10/27.
 */
public interface RolePermissionService extends BaseDAO<RolePermissionVo>{
    List<String> pageListByRoleId(String roleId);
}
