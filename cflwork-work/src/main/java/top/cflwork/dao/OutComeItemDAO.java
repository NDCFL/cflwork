package top.cflwork.dao;

import top.cflwork.vo.OutComeItemVo;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.cflwork.dao.BaseDAO;

/**
 * 成本支出明细
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:29:58
 */
@Repository
public interface OutComeItemDAO extends BaseDAO<OutComeItemVo>{
    List<OutComeItemVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("outComeItemVo") OutComeItemVo outComeItemVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("outComeItemVo") OutComeItemVo outComeItemVo);
    void batchSave(List<OutComeItemVo> oucomeItemVos);
    void deleteByOutcomeId(Long id);
    List<OutComeItemVo> findList(Long id);
}
