package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.ContractVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/17.
 */
@Repository
public interface ContractDAO extends BaseDAO<ContractVo>{
    List<ContractVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("companyId") long companyId);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("companyId") long companyId);
    long countsByMaster(@Param("companyId") long companyId, @Param("masterId") long masterId);
    List<ContractVo> listPagesByMaster(@Param("pageQuery") PageQuery pageQuery, @Param("companyId") long companyId, @Param("masterId") long masterId);
}
