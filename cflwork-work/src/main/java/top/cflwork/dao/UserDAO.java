package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.query.UserAccountPasswordQuery;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import java.util.List;

/**
 * UserDAO接口<br />
 * 创建于2017-09-05
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Repository
public interface UserDAO extends BaseDAO<UserVo> {

    /**
     * 根据用户账号及密码查询用户
     * @param userAccountPasswordQuery 用户账号及密码组成的查询对象，账号可以是邮箱，手机号，账户名
     * @return 指定账号及密码的用户对象
     */
    UserVo getByAccountPassword(UserAccountPasswordQuery userAccountPasswordQuery);
    int checkReg(String phone);
    int checkLogin(String account);
    void updatePwd(@Param("id") long id, @Param("pwd") String pwd);
    void updatePhone(@Param("id") long id, @Param("phone") String phone);
    String getPassword(long id);
    List<Select2Vo> getUserIdAndName();
    int landlordCount(String title);
    UserVo findByPhone(String phone);
    List<UserVo> landlordListPage(@Param("pageQuery") PageQuery pageQuery, @Param("title") String title);
    List<Select2Vo> getUser(Long companyId);
    void updateHeadIcon(UserVo userVo);
    UserVo findUserById(Long id);

}