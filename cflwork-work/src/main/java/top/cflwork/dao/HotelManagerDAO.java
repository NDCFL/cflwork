package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.UserVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/3.
 */
@Repository
public interface HotelManagerDAO extends  BaseDAO<UserVo> {
    List<UserVo> listPages(PageQuery pageQuery);
    List<UserVo> listAlls(long companyId);
    void initPwd(@Param("password") String password, @Param("id") Long id);
}
