package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.CashAccountsVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.SumCashVo;

import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/3.
 */
public interface CashAccountsService extends BaseService<CashAccountsVo>{
    List<Select2Vo> getSubject(Long companyId);
    void checkerManyCashAccount(List<CashAccountsVo> cashAccountsVoList);
    List<Select2Vo> getHotel(Long companyId);
    List<Select2Vo> getPayType(Long companyId);
    SumCashVo sumCash(Date dateVal, Long companyId, Long hotelId);
    List<CashAccountsVo> listPages(PageQuery pageQuery);
    long counts(PageQuery pageQuery);
    List<CashAccountsVo> listPageBy(PageQuery pageQuery);
    long countBy(PageQuery pageQuery);
    List<CashAccountsVo> listPageBys(PageQuery pageQuery, CashAccountsVo cashAccountsVo);
    long countBys(PageQuery pageQuery, CashAccountsVo cashAccountsVo);
    SumCashVo cashSum(CashAccountsVo cashAccountsVo);
    List<CashAccountsVo> listPageByHotel(PageQuery pageQuery, CashAccountsVo cashAccountsVo);
    long countByHotel(PageQuery pageQuery, CashAccountsVo cashAccountsVo);
}
