package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.dao.BaseDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.IncomeVo;

import java.util.List;

/**
 * 酒店的收入表，记录哪个公司旗下的哪个酒店，的收入明细

 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-09-17 15:50:17
 */
@Repository
public interface IncomeDAO extends BaseDAO<IncomeVo>{
    List<IncomeVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("incomeVo") IncomeVo incomeVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("incomeVo") IncomeVo incomeVo);
}
