package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.RolePermissionDAO;
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
    private RolePermissionDAO rolePermissionDAO;
    @Override
    public void save(RolePermissionVo rolePermissionVo) {
        rolePermissionDAO.save(rolePermissionVo);
    }

    @Override
    public void remove(RolePermissionVo rolePermissionVo) {
        rolePermissionDAO.remove(rolePermissionVo);
    }

    @Override
    public void removeById(Long id) {
        rolePermissionDAO.removeById(id);
    }

    @Override
    public void update(RolePermissionVo rolePermissionVo) {
        rolePermissionDAO.update(rolePermissionVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        rolePermissionDAO.updateStatus(statusQuery);
    }

    @Override
    public RolePermissionVo getById(Long id) {
        return rolePermissionDAO.getById(id);
    }

    @Override
    public List<RolePermissionVo> listAll() {
        return rolePermissionDAO.listAll();
    }

    @Override
    public List<RolePermissionVo> listPage(PageQuery pageQuery) {
        return rolePermissionDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return rolePermissionDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        rolePermissionDAO.removeMany(id);
    }

    @Override
    public List<Long> pageListByRoleId(Long roleId) {
        return rolePermissionDAO.pageListByRoleId(roleId);
    }

    @Override
    public void batchSave(List<RolePermissionVo> rolePermissionVoList) {
        rolePermissionDAO.batchSave(rolePermissionVoList);
    }

    @Override
    public void removeByRoleId(Long id) {
        rolePermissionDAO.removeByRoleId(id);
    }
}
