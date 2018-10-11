package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CashSubjectDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CashSubjectService;
import top.cflwork.vo.CashSubjectVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Service
public class CashSubjectServiceImpl implements CashSubjectService {
    @Resource
    private CashSubjectDAO cashSubjectDAO;

    @Override
    public void save(CashSubjectVo cashSubjectVo) {
        cashSubjectDAO.save(cashSubjectVo);
    }

    @Override
    public void remove(CashSubjectVo cashSubjectVo) {
        cashSubjectDAO.remove(cashSubjectVo);
    }

    @Override
    public void removeById(Long id) {
        cashSubjectDAO.removeById(id);
    }

    @Override
    public void update(CashSubjectVo cashSubjectVo) {
        cashSubjectDAO.update(cashSubjectVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        cashSubjectDAO.updateStatus(statusQuery);
    }

    @Override
    public CashSubjectVo getById(Long id) {
        return cashSubjectDAO.getById(id);
    }

    @Override
    public List<CashSubjectVo> listAll() {
        return cashSubjectDAO.listAll();
    }

    @Override
    public List<CashSubjectVo> listPage(PageQuery pageQuery) {
        return cashSubjectDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return cashSubjectDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        cashSubjectDAO.removeMany(id);
    }
}
