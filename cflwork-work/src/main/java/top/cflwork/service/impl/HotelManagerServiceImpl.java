package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.HotelManagerDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HotelManagerService;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/3.
 */
@Service
public class HotelManagerServiceImpl implements HotelManagerService {
    @Resource
    private HotelManagerDAO hotelManagerDAO;

    @Override
    public void save(UserVo userVo) {
        hotelManagerDAO.save(userVo);
    }

    @Override
    public void remove(UserVo userVo) {
        hotelManagerDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        hotelManagerDAO.removeById(id);
    }

    @Override
    public void update(UserVo userVo) {
        hotelManagerDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        hotelManagerDAO.updateStatus(statusQuery);
    }

    @Override
    public UserVo getById(Long id) {
        return hotelManagerDAO.getById(id);
    }

    @Override
    public List<UserVo> listAll() {
        return hotelManagerDAO.listAll();
    }

    @Override
    public List<UserVo> listPage(PageQuery pageQuery) {
        return hotelManagerDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return hotelManagerDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        hotelManagerDAO.removeMany(id);
    }

    @Override
    public List<UserVo> listPages(PageQuery pageQuery) {
        return hotelManagerDAO.listPages(pageQuery);
    }

    @Override
    public void initPwd(String password, Long id) {
        hotelManagerDAO.initPwd(password, id);
    }


    @Override
    public List<UserVo> listAlls(long companyId) {
        return hotelManagerDAO.listAlls(companyId);
    }
}
