package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.vo.CompanyVo;

/**
 * Created by chenfeilong on 2017/11/15.
 */
@Repository
public interface CompanyDAO extends BaseDAO<CompanyVo> {

    int checkName(@Param("name") String name, @Param("id") long id);
}
