package top.cflwork.service;

import top.cflwork.vo.InComeItemVo;
import top.cflwork.query.PageQuery;
import java.util.List;
import java.util.Map;

/**
 * 收入明细
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:37:31
 */
public interface InComeItemService  extends BaseService<InComeItemVo>{
    List<InComeItemVo> listPages(PageQuery pageQuery, InComeItemVo inComeItemVo);
    long counts(PageQuery pageQuery, InComeItemVo inComeItemVo);
    void batchSave(List<InComeItemVo> inComeItemVoList);
    void deleteByIncomeId(Long id);
}
