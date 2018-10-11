package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.CooperationAccountsVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.SumCashVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/3.
 */
public interface CooperationAccountsService extends BaseService<CooperationAccountsVo>{
    void updateCashStatus(CooperationAccountsVo cooperationAccountsVo);
    List<Select2Vo> getSubject(Long companyId);
    List<Select2Vo> getCooperationCompany(PageQuery pageQuery);
    void updateRemark(CooperationAccountsVo cooperationAccountsVo);
    void checkerManyCashAccount(List<CooperationAccountsVo> cooperationAccountsVos);
    List<CooperationAccountsVo> listPages(PageQuery pageQuery);
    Long counts(PageQuery pageQuery);
    SumCashVo sumCash(Long companyId, Long hotelId);
    List<CooperationAccountsVo> listPageBy(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo);
    long countBy(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo);
    List<CooperationAccountsVo> listPageByHotel(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo);
    long countByHotel(PageQuery pageQuery, CooperationAccountsVo cooperationAccountsVo);
    SumCashVo cashSum(CooperationAccountsVo cooperationAccountsVo);

}
