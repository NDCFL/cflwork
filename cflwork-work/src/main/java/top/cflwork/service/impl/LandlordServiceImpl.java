package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.LandlordDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.LandlordService;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/3.
 */
@Service
public class LandlordServiceImpl implements LandlordService {
    @Resource
    private LandlordDAO landlordDAO;

    @Override
    public void save(UserVo userVo) {
        landlordDAO.save(userVo);
    }

    @Override
    public void remove(UserVo userVo) {
        landlordDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        landlordDAO.removeById(id);
    }

    @Override
    public void update(UserVo userVo) {
        landlordDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        landlordDAO.updateStatus(statusQuery);
    }

    @Override
    public UserVo getById(Long id) {
        return landlordDAO.getById(id);
    }

    @Override
    public List<UserVo> listAll() {
        return landlordDAO.listAll();
    }

    @Override
    public List<UserVo> listPage(PageQuery pageQuery) {
        return landlordDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return landlordDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        landlordDAO.removeMany(id);
    }

    @Override
    public List<UserVo> listPages(PageQuery pageQuery) {
        return landlordDAO.listPages(pageQuery);
    }

    @Override
    public void initPwd(String password, Long id) {
        landlordDAO.initPwd(password, id);
    }


    @Override
    public List<UserVo> listAlls(long companyId) {
        return landlordDAO.listAlls(companyId);
    }
}
