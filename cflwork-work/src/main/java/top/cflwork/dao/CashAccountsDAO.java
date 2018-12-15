package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.CashAccountsVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.SumCashVo;

import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/3.
 */
@Repository
public interface CashAccountsDAO extends BaseDAO<CashAccountsVo>{
    List<Select2Vo> getSubject(Long companyId);
    void checkerManyCashAccount(List<CashAccountsVo> cashAccountsVoList);
    List<Select2Vo> getHotel(Long companyId);
    List<Select2Vo> getPayType(Long companyId);
    SumCashVo sumCash(@Param("dateVal") Date dateVal, @Param("companyId") Long companyId, @Param("hotelId") Long hotelId);
    List<CashAccountsVo> listPages(PageQuery pageQuery);
    long counts(PageQuery pageQuery);
    List<CashAccountsVo> listPageBy(PageQuery pageQuery);
    long countBy(PageQuery pageQuery);
    List<CashAccountsVo> listPageBys(@Param("pageQuery") PageQuery pageQuery, @Param("cashAccountsVo") CashAccountsVo cashAccountsVo);
    long countBys(@Param("pageQuery") PageQuery pageQuery, @Param("cashAccountsVo") CashAccountsVo cashAccountsVo);
    SumCashVo cashSum(CashAccountsVo cashAccountsVo);
    List<CashAccountsVo> listPageByHotel(@Param("pageQuery") PageQuery pageQuery, @Param("cashAccountsVo") CashAccountsVo cashAccountsVo);
    long countByHotel(@Param("pageQuery") PageQuery pageQuery, @Param("cashAccountsVo") CashAccountsVo cashAccountsVo);
}
