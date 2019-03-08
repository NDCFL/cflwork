package top.cflwork.dao;

import top.cflwork.vo.InComeItemVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import org.springframework.stereotype.Repository;
import top.cflwork.vo.Select2Vo;

/**
 * 收入明细
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:37:31
 */
@Repository
public interface InComeItemDAO extends BaseDAO<InComeItemVo>{
    List<InComeItemVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("inComeItemVo") InComeItemVo inComeItemVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("inComeItemVo") InComeItemVo inComeItemVo);
    void batchSave(List<InComeItemVo> inComeItemVoList);
    void deleteByIncomeId(Long id);
    List<InComeItemVo> findList(Long id);
    List<Select2Vo> inComeItemPayList(@Param("hotelId") long hotelId,@Param("time") String time);
}
