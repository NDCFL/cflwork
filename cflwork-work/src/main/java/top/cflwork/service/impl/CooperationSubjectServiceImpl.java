package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CooperationSubjectDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CooperationSubjectService;
import top.cflwork.vo.CooperationSubjectVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/19.
 */
@Service
public class CooperationSubjectServiceImpl implements CooperationSubjectService {
    @Resource
    private CooperationSubjectDAO cooperationSubjectDAO;

    @Override
    public void save(CooperationSubjectVo cooperationSubjectVo) {
        cooperationSubjectDAO.save(cooperationSubjectVo);
    }

    @Override
    public void remove(CooperationSubjectVo cooperationSubjectVo) {
        cooperationSubjectDAO.remove(cooperationSubjectVo);
    }

    @Override
    public void removeById(Long id) {
        cooperationSubjectDAO.removeById(id);
    }

    @Override
    public void update(CooperationSubjectVo cooperationSubjectVo) {
        cooperationSubjectDAO.update(cooperationSubjectVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        cooperationSubjectDAO.updateStatus(statusQuery);
    }

    @Override
    public CooperationSubjectVo getById(Long id) {
        return cooperationSubjectDAO.getById(id);
    }

    @Override
    public List<CooperationSubjectVo> listAll() {
        return cooperationSubjectDAO.listAll();
    }

    @Override
    public List<CooperationSubjectVo> listPage(PageQuery pageQuery) {
        return cooperationSubjectDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return cooperationSubjectDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        cooperationSubjectDAO.removeMany(id);
    }
}
