package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.CooperationAccountsVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.SumCashVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/3.
 */
@Repository
public interface CooperationAccountsDAO extends BaseDAO<CooperationAccountsVo>{
    void updateCashStatus(CooperationAccountsVo cooperationAccountsVo);
    List<Select2Vo> getSubject(Long companyId);
    List<Select2Vo> getCooperationCompany(PageQuery pageQuery);
    void updateRemark(CooperationAccountsVo cooperationAccountsVo);
    void checkerManyCashAccount(List<CooperationAccountsVo> cooperationAccountsVos);
    List<CooperationAccountsVo> listPages(PageQuery pageQuery);
    Long counts(PageQuery pageQuery);
    SumCashVo sumCash(@Param("companyId") Long companyId, @Param("hotelId") Long hotelId);
    SumCashVo cashSum(CooperationAccountsVo cooperationAccountsVo);
    List<CooperationAccountsVo> listPageBy(@Param("pageQuery") PageQuery pageQuery, @Param("cooperationAccountsVo") CooperationAccountsVo cooperationAccountsVo);
    long countBy(@Param("pageQuery") PageQuery pageQuery, @Param("cooperationAccountsVo") CooperationAccountsVo cooperationAccountsVo);
    List<CooperationAccountsVo> listPageByHotel(@Param("pageQuery") PageQuery pageQuery, @Param("cooperationAccountsVo") CooperationAccountsVo cooperationAccountsVo);
    long countByHotel(@Param("pageQuery") PageQuery pageQuery, @Param("cooperationAccountsVo") CooperationAccountsVo cooperationAccountsVo);
}
