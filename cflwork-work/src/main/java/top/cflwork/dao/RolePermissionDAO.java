package top.cflwork.dao;

import org.springframework.stereotype.Repository;
import top.cflwork.vo.RolePermissionVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/10/27.
 */
@Repository
public interface RolePermissionDAO extends  BaseDAO<RolePermissionVo>{
    List<Long> pageListByRoleId(long roleId);
    void batchSave(List<RolePermissionVo> rolePermissionVoList);
    void removeByRoleId(Long id);
}
