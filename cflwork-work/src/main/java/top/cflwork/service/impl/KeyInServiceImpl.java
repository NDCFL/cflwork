package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.KeyInDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.KeyInService;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Service
public class KeyInServiceImpl implements KeyInService {
    @Resource
    private KeyInDAO keyInDAO;
    @Override
    public void save(UserVo userVo) {
        keyInDAO.save(userVo);
    }

    @Override
    public void remove(UserVo userVo) {
        keyInDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        keyInDAO.removeById(id);
    }

    @Override
    public void update(UserVo userVo) {
        keyInDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        keyInDAO.updateStatus(statusQuery);
    }

    @Override
    public UserVo getById(Long id) {
        return keyInDAO.getById(id);
    }

    @Override
    public List<UserVo> listAll() {
        return keyInDAO.listAll();
    }

    @Override
    public List<UserVo> listPage(PageQuery pageQuery) {
        return keyInDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return keyInDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        keyInDAO.removeMany(id);
    }

    @Override
    public long counts(PageQuery pageQuery) {
        return keyInDAO.counts(pageQuery);
    }

    @Override
    public void initPwd(String password, Long id) {
        keyInDAO.initPwd(password, id);
    }


    @Override
    public List<UserVo> listPages(PageQuery pageQuery) {
        return keyInDAO.listPages(pageQuery);
    }
}
