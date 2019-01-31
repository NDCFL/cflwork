package top.cflwork.dao;

import top.cflwork.vo.RenpayItemVo;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.cflwork.dao.BaseDAO;

/**
 * 分成房租，每个合同每期分成明细
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:44:21
 */
@Repository
public interface RenpayItemDAO extends BaseDAO<RenpayItemVo>{
    List<RenpayItemVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("renpayItemVo") RenpayItemVo renpayItemVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("renpayItemVo") RenpayItemVo renpayItemVo);
}
