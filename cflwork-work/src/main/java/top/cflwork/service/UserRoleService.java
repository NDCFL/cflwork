package top.cflwork.service;

import top.cflwork.dao.BaseDAO;
import top.cflwork.vo.UserRoleVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/10/27.
 */
public interface UserRoleService extends BaseDAO<UserRoleVo>{
    List<String> pageListByUserId(String userId);
    UserRoleVo getRole(Long userId);
}
