package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.UserVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Repository
public interface KeyInDAO extends BaseDAO<UserVo>{
    long counts(PageQuery pageQuery);
    void initPwd(@Param("password") String password, @Param("id") Long id);
    List<UserVo> listPages(PageQuery pageQuery);

}
