package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.common.DozerMapperUtils;
import top.cflwork.common.ExceptionUtils;
import top.cflwork.dao.PermissionDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.AbstractBaseService;
import top.cflwork.service.PermissionService;
import top.cflwork.util.BuildTree;
import top.cflwork.vo.PermissionVo;
import top.cflwork.vo.TreeVo;
import top.cflwork.vo.TreeVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限Service实现类<br />
 * 创建于2017-09-11
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Service
public class PermissionServiceImpl extends AbstractBaseService implements PermissionService {

    @Resource
    private PermissionDAO permissionDAO;
    @Override
    public List<PermissionVo> listByModuleId(String moduleId) {
        return null;
    }

    @Override
    public List<PermissionVo> listByRoleId(String roleId) {
        return null;
    }

    @Override
    public List<PermissionVo> listByRoleIds(List<Long> roleIds) {
        try {
            List<PermissionVo> permissionDOList = permissionDAO.listByRoleIds(roleIds);
            return DozerMapperUtils.map(getDozerMapper(), permissionDOList, PermissionVo.class);
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Override
    public List<PermissionVo> listByAccount(String account) {
        try {
            List<PermissionVo> permissionDOList = permissionDAO.listByAccount(account);
            return DozerMapperUtils.map(getDozerMapper(), permissionDOList, PermissionVo.class);
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Override
    public TreeVo<PermissionVo> getTree() {
        List<TreeVo<PermissionVo>> trees = new ArrayList<TreeVo<PermissionVo>>();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setTemp(16);
        List<PermissionVo> menuDOs = permissionDAO.listPage(pageQuery);
        for (PermissionVo sysPermissionVo : menuDOs) {
            TreeVo<PermissionVo> tree = new TreeVo<PermissionVo>();
            tree.setId(sysPermissionVo.getId().toString());
            tree.setParentId(sysPermissionVo.getParentId().toString());
            tree.setText(sysPermissionVo.getName());
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        TreeVo<PermissionVo> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public TreeVo<PermissionVo> getTree(Long id) {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setTemp(16);
        // 根据roleId查询权限
        List<PermissionVo> menus = permissionDAO.listPage(pageQuery);
        List<Long> menuIds = null;
        List<Long> temp = menuIds;
        for (PermissionVo menu : menus) {
            if (temp.contains(menu.getParentId())) {
                menuIds.remove(menu.getParentId());
            }
        }
        List<TreeVo<PermissionVo>> trees = new ArrayList<TreeVo<PermissionVo>>();
        List<PermissionVo> menuDOs = permissionDAO.listPage(pageQuery);
        for (PermissionVo sysPermissionVo : menuDOs) {
            TreeVo<PermissionVo> tree = new TreeVo<PermissionVo>();
            tree.setId(sysPermissionVo.getId().toString());
            tree.setParentId(sysPermissionVo.getParentId().toString());
            tree.setText(sysPermissionVo.getName());
            Map<String, Object> state = new HashMap<>(16);
            Long menuId = sysPermissionVo.getId();
            if (menuIds.contains(menuId)) {
                state.put("selected", true);
            } else {
                state.put("selected", false);
            }
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        TreeVo<PermissionVo> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public void save(PermissionVo permissionVo) {
        permissionDAO.save(permissionVo);
    }

    @Override
    public void remove(PermissionVo permissionVo) {
        permissionDAO.remove(permissionVo);
    }

    @Override
    public void removeById(Long id) {
        permissionDAO.removeById(id);
    }

    @Override
    public void update(PermissionVo permissionVo) {
        permissionDAO.update(permissionVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        permissionDAO.updateStatus(statusQuery);
    }

    @Override
    public PermissionVo getById(Long id) {
        
        return permissionDAO.getById(id);
    }

    @Override
    public List<PermissionVo> listAll() {
        return permissionDAO.listAll();
    }

    @Override
    public List<PermissionVo> listPage(PageQuery pageQuery) {
        return permissionDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return permissionDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        permissionDAO.removeMany(id);
    }

    @Resource
    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }
}
