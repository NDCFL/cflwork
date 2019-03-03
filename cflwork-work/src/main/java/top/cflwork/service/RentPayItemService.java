package top.cflwork.service;

import top.cflwork.vo.RentPayItemInfoVo;
import top.cflwork.vo.RentPayItemVo;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.TodayPayVo;

import java.util.List;
import java.util.Map;

/**
 * 分成房租，每个合同每期分成明细
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:44:21
 */
public interface RentPayItemService  extends BaseService<RentPayItemVo>{
    List<RentPayItemVo> listPages(PageQuery pageQuery, RentPayItemVo rentPayItemVo);
    long counts(PageQuery pageQuery, RentPayItemVo rentPayItemVo);
    void batchSave(List<RentPayItemVo> rentPayItemVos);
    void deleteByRentPayId(Long id);
    List<RentPayItemVo> findList(Long id);
    void generateOrder(Long id);
    RentPayItemInfoVo getPayInfo(RentPayItemVo rentPayItemVo);
    List<Integer> checkInSubject(RentPayItemVo rentPayItemVo);
    List<Integer> checkOutSubject(RentPayItemVo rentPayItemVo);
    int checkOutCnt(RentPayItemVo rentPayItemVo);
    int checkInCnt(RentPayItemVo rentPayItemVo);
    byte[] down(Long id);
}
