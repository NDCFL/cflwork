package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.IncomeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.IncomeService;
import top.cflwork.vo.IncomeVo;

import javax.annotation.Resource;
import java.util.List;


@Service
public class IncomeServiceImpl implements IncomeService {
    @Resource
    private IncomeDAO incomeDAO;

    @Override
    public void save(IncomeVo incomeVo) {
        incomeDAO.save(incomeVo);
    }

    @Override
    public void remove(IncomeVo incomeVo) {
        incomeDAO.remove(incomeVo);
    }

    @Override
    public void removeById(Long id) {
        incomeDAO.removeById(id);
    }

    @Override
    public void update(IncomeVo incomeVo) {
        incomeDAO.update(incomeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        incomeDAO.updateStatus(statusQuery);
    }

    @Override
    public IncomeVo getById(Long id) {
        return incomeDAO.getById(id);
    }

    @Override
    public List<IncomeVo> listAll() {
        return incomeDAO.listAll();
    }

    @Override
    public List<IncomeVo> listPage(PageQuery pageQuery) {
        return incomeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return incomeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      incomeDAO.removeMany(id);
    }

    @Override
    public List<IncomeVo> listPages(PageQuery pageQuery, IncomeVo incomeVo) {
        return incomeDAO.listPages(pageQuery, incomeVo);
    }

    @Override
    public long counts(PageQuery pageQuery, IncomeVo incomeVo) {
        return  incomeDAO.counts(pageQuery, incomeVo);
    }
}
