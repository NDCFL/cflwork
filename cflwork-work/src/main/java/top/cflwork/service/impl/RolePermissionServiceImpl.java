package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.RolePermissionService;
import top.cflwork.vo.RolePermissionVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/27.
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionService rolePermissionService;
    @Override
    public void save(RolePermissionVo rolePermissionVo) {

    }

    @Override
    public void remove(RolePermissionVo rolePermissionVo) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(RolePermissionVo rolePermissionVo) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public RolePermissionVo getById(Long id) {
        return null;
    }

    @Override
    public List<RolePermissionVo> listAll() {
        return null;
    }

    @Override
    public List<RolePermissionVo> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count(PageQuery pageQuery) {
        return 0;
    }

    @Override
    public void removeMany(Long[] id) {
    }

    @Override
    public List<String> pageListByRoleId(String roleId) {
        return null;
    }
}
