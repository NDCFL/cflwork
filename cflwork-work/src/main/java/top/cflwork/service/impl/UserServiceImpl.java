package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.common.ExceptionUtils;
import top.cflwork.dao.UserDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.query.UserAccountPasswordQuery;
import top.cflwork.service.UserService;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类<br />
 * 创建于2017-09-05
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Service
public class UserServiceImpl  implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public UserVo getByAccountPassword(UserAccountPasswordQuery userAccountPasswordQuery) {
        try {
            UserVo userVo = userDAO.getByAccountPassword(userAccountPasswordQuery);
            return userVo;
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Override
    public int checkReg(String phone) {
        return userDAO.checkReg(phone);
    }

    @Override
    public int checkLogin(String account) {
        return userDAO.checkLogin(account);
    }

    @Override
    public void updatePwd(long id, String pwd) {
        userDAO.updatePwd(id,pwd);
    }

    @Override
    public void updatePhone(long id, String phone) {
        userDAO.updatePhone(id, phone);
    }

    @Override
    public String getPassword(long id) {
        return userDAO.getPassword(id);
    }

    @Override
    public List<Select2Vo> getUserIdAndName() {
        return userDAO.getUserIdAndName();
    }

    @Override
    public int landlordCount(String title) {
        return userDAO.landlordCount(title);
    }

    @Override
    public List<UserVo> landlordListPage(PageQuery pageQuery, String title) {
        return userDAO.landlordListPage(pageQuery,title);
    }

    @Override
    public UserVo findByPhone(String phone) {
        return userDAO.findByPhone(phone);
    }

    @Override
    public List<Select2Vo> getUser(Long companyId) {
        return userDAO.getUser(companyId);
    }

    @Override
    public void updateHeadIcon(UserVo userVo) {
        userDAO.updateHeadIcon(userVo);
    }

    @Override
    public UserVo findUserById(Long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public void save(UserVo userVo) {
        userDAO.save(userVo);
    }

    @Override
    public void remove(UserVo userVo) {
        userDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        userDAO.removeById(id);
    }

    @Override
    public void update(UserVo userVo) {
        userDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        userDAO.updateStatus(statusQuery);
    }

    @Override
    public UserVo getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public List<UserVo> listAll() {
        return userDAO.listAll();
    }

    @Override
    public List<UserVo> listPage(PageQuery pageQuery) {
        return userDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return userDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        userDAO.removeMany(id);
    }

}
