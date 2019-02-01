package top.cflwork.service;

import top.cflwork.vo.OutComeItemVo;
import top.cflwork.query.PageQuery;
import java.util.List;
import java.util.Map;

/**
 * 成本支出明细
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:29:58
 */
public interface OutComeItemService  extends BaseService<OutComeItemVo>{
    List<OutComeItemVo> listPages(PageQuery pageQuery, OutComeItemVo oucomeItemVo);
    long counts(PageQuery pageQuery, OutComeItemVo oucomeItemVo);
    void batchSave(List<OutComeItemVo> oucomeItemVoList);
    void deleteByOutcomeId(Long id);
    void generateOrder(Long id);
    List<OutComeItemVo> findList(Long id);
}
