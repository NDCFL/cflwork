package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CooperationAccountsDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CooperationAccountsService;
import top.cflwork.vo.CooperationAccountsVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.SumCashVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/6.
 */
@Service
public class CooperationAccountsServiceImpl implements CooperationAccountsService{
    @Resource
    private CooperationAccountsDAO cooperationAccountsDAO;
    @Override
    public void updateCashStatus(CooperationAccountsVo cooperationAccountsVo) {
        cooperationAccountsDAO.updateCashStatus(cooperationAccountsVo);
    }

    @Override
    public List<Select2Vo> getSubject(Long companyId) {
        return cooperationAccountsDAO.getSubject(companyId);
    }

    @Override
    public List<Select2Vo> getCooperationCompany(PageQuery pageQuery) {
        return cooperationAccountsDAO.getCooperationCompany(pageQuery);
    }

    @Override
    public void updateRemark(CooperationAccountsVo cooperationAccountsVo) {
        cooperationAccountsDAO.updateRemark(cooperationAccountsVo);
    }

    @Override
    public void checkerManyCashAccount(List<CooperationAccountsVo> cooperationAccountsVos) {
        cooperationAccountsDAO.checkerManyCashAccount(cooperationAccountsVos);
    }

    @Override
    public List<CooperationAccountsVo> listPages(PageQuery pageQuery) {
        return cooperationAccountsDAO.listPages(pageQuery);
    }

    @Override
    public Long counts(PageQuery pageQuery) {
        return cooperationAccountsDAO.counts(pageQuery);
    }

    @Override
    public SumCashVo sumCash(Long companyId, Long hotelId) {
        return cooperationAccountsDAO.sumCash(companyId, hotelId);
    }

    @Override
    public List<CooperationAccountsVo> listPageBy(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo) {
        return cooperationAccountsDAO.listPageBy(pageQuery, cooperationAccountsVo);
    }

    @Override
    public long countBy(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo) {
        return cooperationAccountsDAO.countBy(pageQuery, cooperationAccountsVo);
    }

    @Override
    public List<CooperationAccountsVo> listPageByHotel(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo) {
        return cooperationAccountsDAO.listPageByHotel(pageQuery, cooperationAccountsVo);
    }

    @Override
    public long countByHotel(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo) {
        return cooperationAccountsDAO.countByHotel(pageQuery, cooperationAccountsVo);
    }

    @Override
    public SumCashVo cashSum(CooperationAccountsVo cooperationAccountsVo) {
        return cooperationAccountsDAO.cashSum(cooperationAccountsVo);
    }

    @Override
    public void save(CooperationAccountsVo cooperationAccountsVo) {
        cooperationAccountsDAO.save(cooperationAccountsVo);
    }

    @Override
    public void remove(CooperationAccountsVo cooperationAccountsVo) {
        cooperationAccountsDAO.remove(cooperationAccountsVo);
    }

    @Override
    public void removeById(Long id) {
        cooperationAccountsDAO.removeById(id);
    }

    @Override
    public void update(CooperationAccountsVo cooperationAccountsVo) {
        cooperationAccountsDAO.update(cooperationAccountsVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        cooperationAccountsDAO.updateStatus(statusQuery);
    }

    @Override
    public CooperationAccountsVo getById(Long id) {
        return cooperationAccountsDAO.getById(id);
    }

    @Override
    public List<CooperationAccountsVo> listAll() {
        return cooperationAccountsDAO.listAll();
    }

    @Override
    public List<CooperationAccountsVo> listPage(PageQuery pageQuery) {
        return cooperationAccountsDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return cooperationAccountsDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        cooperationAccountsDAO.removeMany(id);
    }
}
