package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CooperationCompanyDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CooperationCompanyService;
import top.cflwork.vo.CooperationCompanyVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/6.
 */
@Service
public class CooperationCompanyServiceImpl implements CooperationCompanyService {
    @Resource
    private CooperationCompanyDAO cooperationCompanyDAO;
    @Override
    public void save(CooperationCompanyVo cooperationCompanyVo) {
        cooperationCompanyDAO.save(cooperationCompanyVo);
    }

    @Override
    public  void remove(CooperationCompanyVo cooperationCompanyVo) {
        cooperationCompanyDAO.remove(cooperationCompanyVo);
    }

    @Override
    public void removeById(Long id) {
        cooperationCompanyDAO.removeById(id);
    }

    @Override
    public void update(CooperationCompanyVo cooperationCompanyVo) {
        cooperationCompanyDAO.update(cooperationCompanyVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        cooperationCompanyDAO.updateStatus(statusQuery);
    }

    @Override
    public CooperationCompanyVo getById(Long id) {
        return cooperationCompanyDAO.getById(id);
    }

    @Override
    public List<CooperationCompanyVo> listAll() {
        return cooperationCompanyDAO.listAll();
    }

    @Override
    public List<CooperationCompanyVo> listPage(PageQuery pageQuery) {
        return cooperationCompanyDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return cooperationCompanyDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        cooperationCompanyDAO.removeMany(id);
    }

    @Override
    public List<CooperationCompanyVo> listPages(PageQuery pageQuery) {
        return cooperationCompanyDAO.listPages(pageQuery);
    }

    @Override
    public Long counts(PageQuery pageQuery) {
        return cooperationCompanyDAO.counts(pageQuery);
    }
}
