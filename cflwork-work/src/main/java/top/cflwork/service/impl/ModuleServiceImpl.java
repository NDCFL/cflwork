package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.common.ExceptionUtils;
import top.cflwork.dao.ModuleDAO;
import top.cflwork.exception.DAOException;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.AbstractBaseService;
import top.cflwork.service.ModuleService;
import top.cflwork.vo.ModuleVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模块服务实现类<br />
 * 创建于2017-09-12
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Service
public class ModuleServiceImpl extends AbstractBaseService implements ModuleService {

    private ModuleDAO moduleDAO;

    @Override
    public void save(ModuleVo moduleVo) {

    }

    @Override
    public void remove(ModuleVo moduleVo) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(ModuleVo moduleVo) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public ModuleVo getById(Long id) {
        try {
            return getDozerMapper().map(moduleDAO.getById(id), ModuleVo.class);
        } catch (DAOException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Override
    public List<ModuleVo> listAll() {
        return null;
    }

    @Override
    public List<ModuleVo> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count(PageQuery pageQuery) {
        return 0;
    }

    @Override
    public void removeMany(Long[] id) {
        moduleDAO.removeMany(id);
    }

    @Resource
    public void setModuleDAO(ModuleDAO moduleDAO) {
        this.moduleDAO = moduleDAO;
    }
}
