package top.cflwork.service;

import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.OutcomeVo;

import java.util.List;

/**
 * 酒店的支出表，记录哪个公司旗下的哪个酒店，的支出明细
 * 
 * @author chglee
 * @email xljx_888888@163.com
 * @date 2018-09-11 16:00:27
 */
public interface OutcomeService  extends BaseService<OutcomeVo>{
    List<OutcomeVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("outcomeVo") OutcomeVo outcomeVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("outcomeVo") OutcomeVo outcomeVo);
    List<OutcomeVo> getList(Long hotelId);
    List<OutcomeVo> getListBySubjectId(OutcomeVo outcomeVo);
}
