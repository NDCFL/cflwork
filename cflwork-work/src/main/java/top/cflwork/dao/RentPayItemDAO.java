package top.cflwork.dao;

import top.cflwork.vo.RentPayItemVo;

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
public interface RentPayItemDAO extends BaseDAO<RentPayItemVo>{
    List<RentPayItemVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("rentPayItemVo") RentPayItemVo rentPayItemVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("rentPayItemVo") RentPayItemVo rentPayItemVo);
    void batchSave(List<RentPayItemVo> rentPayItemVos);
    void deleteByRentPayId(Long id);
    List<RentPayItemVo> findList(Long id);
}
