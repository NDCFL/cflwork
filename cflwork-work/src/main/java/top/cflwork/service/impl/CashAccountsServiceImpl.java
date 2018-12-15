package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CashAccountsDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CashAccountsService;
import top.cflwork.vo.CashAccountsVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.SumCashVo;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/3.
 */
@Service
public class CashAccountsServiceImpl implements CashAccountsService{

    @Resource
    private CashAccountsDAO cashAccountsDAO;
    @Override
    public void save(CashAccountsVo cashAccountsVo) {
        cashAccountsDAO.save(cashAccountsVo);
    }

    @Override
    public void remove(CashAccountsVo cashAccountsVo) {
        cashAccountsDAO.remove(cashAccountsVo);
    }

    @Override
    public void removeById(Long id) {
        cashAccountsDAO.removeById(id);
    }

    @Override
    public void update(CashAccountsVo cashAccountsVo) {
        cashAccountsDAO.update(cashAccountsVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        cashAccountsDAO.updateStatus(statusQuery);
    }

    @Override
    public CashAccountsVo getById(Long id) {
        return cashAccountsDAO.getById(id);
    }

    @Override
    public List<CashAccountsVo> listAll() {
        return cashAccountsDAO.listAll();
    }

    @Override
    public List<CashAccountsVo> listPage(PageQuery pageQuery) {
        return cashAccountsDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return cashAccountsDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        cashAccountsDAO.removeMany(id);
    }


    @Override
    public List<Select2Vo> getSubject(Long companyId) {
        return cashAccountsDAO.getSubject(companyId);
    }

        @Override
    public void checkerManyCashAccount(List<CashAccountsVo> cashAccountsVoList) {
        cashAccountsDAO.checkerManyCashAccount(cashAccountsVoList);
    }

    @Override
    public List<Select2Vo> getHotel(Long companyId) {
        return cashAccountsDAO.getHotel(companyId);
    }

    @Override
    public List<Select2Vo> getPayType(Long companyId) {
        return cashAccountsDAO.getPayType(companyId);
    }

    @Override
    public SumCashVo sumCash(Date dateVal, Long companyId,Long hotelId) {
        return cashAccountsDAO.sumCash(dateVal, companyId,hotelId);
    }

    @Override
    public List<CashAccountsVo> listPages(PageQuery pageQuery) {
        return cashAccountsDAO.listPages(pageQuery);
    }

    @Override
    public long counts(PageQuery pageQuery) {
        return cashAccountsDAO.counts(pageQuery);
    }

    @Override
    public List<CashAccountsVo> listPageBy(PageQuery pageQuery) {
        return cashAccountsDAO.listPageBy(pageQuery);
    }

    @Override
    public long countBy(PageQuery pageQuery) {
        return cashAccountsDAO.countBy(pageQuery);
    }

    @Override
    public List<CashAccountsVo> listPageBys(PageQuery pageQuery, CashAccountsVo cashAccountsVo) {
        return cashAccountsDAO.listPageBys(pageQuery, cashAccountsVo);
    }

    @Override
    public long countBys(PageQuery pageQuery, CashAccountsVo cashAccountsVo) {
        return cashAccountsDAO.countBys(pageQuery, cashAccountsVo);
    }

    @Override
    public SumCashVo cashSum(CashAccountsVo cashAccountsVo) {
        return cashAccountsDAO.cashSum(cashAccountsVo);
    }

    @Override
    public List<CashAccountsVo> listPageByHotel(PageQuery pageQuery, CashAccountsVo cashAccountsVo) {
        return cashAccountsDAO.listPageByHotel(pageQuery, cashAccountsVo);
    }

    @Override
    public long countByHotel(PageQuery pageQuery, CashAccountsVo cashAccountsVo) {
        return cashAccountsDAO.countByHotel(pageQuery, cashAccountsVo);
    }
}
