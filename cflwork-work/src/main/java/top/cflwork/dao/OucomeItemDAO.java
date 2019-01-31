package top.cflwork.dao;

import top.cflwork.vo.OucomeItemVo;

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
public interface OucomeItemDAO extends BaseDAO<OucomeItemVo>{
    List<OucomeItemVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("oucomeItemVo") OucomeItemVo oucomeItemVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("oucomeItemVo") OucomeItemVo oucomeItemVo);
}
