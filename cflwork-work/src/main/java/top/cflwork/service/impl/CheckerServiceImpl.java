package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CheckerDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CheckerService;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Service
public class CheckerServiceImpl implements CheckerService {
    @Resource
    private CheckerDAO checkerDAO;
    @Override
    public void save(UserVo userVo) {
        checkerDAO.save(userVo);
    }

    @Override
    public void remove(UserVo userVo) {
        checkerDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        checkerDAO.removeById(id);
    }

    @Override
    public void update(UserVo userVo) {
        checkerDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        checkerDAO.updateStatus(statusQuery);
    }

    @Override
    public UserVo getById(Long id) {
        return checkerDAO.getById(id);
    }

    @Override
    public List<UserVo> listAll() {
        return checkerDAO.listAll();
    }

    @Override
    public List<UserVo> listPage(PageQuery pageQuery) {
        return checkerDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return checkerDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        checkerDAO.removeMany(id);
    }

    @Override
    public long counts(PageQuery pageQuery) {
        return checkerDAO.counts(pageQuery);
    }

    @Override
    public void initPwd(String password, Long id) {
        checkerDAO.initPwd(password, id);
    }

    @Override
    public List<UserVo> listPages(PageQuery pageQuery) {
        return checkerDAO.listPages(pageQuery);
    }
}
