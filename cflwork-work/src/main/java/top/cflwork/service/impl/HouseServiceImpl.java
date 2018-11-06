package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.HouseDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HouseService;
import top.cflwork.vo.HouseVo;
import top.cflwork.vo.Select2Vo;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Resource
    private HouseDAO houserDAO;
    @Override
    public void save(HouseVo userVo) {
        houserDAO.save(userVo);
    }

    @Override
    public void remove(HouseVo userVo) {
        houserDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        houserDAO.removeById(id);
    }

    @Override
    public void update(HouseVo userVo) {
        houserDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        houserDAO.updateStatus(statusQuery);
    }

    @Override
    public HouseVo getById(Long id) {
        return houserDAO.getById(id);
    }

    @Override
    public List<HouseVo> listAll() {
        return houserDAO.listAll();
    }

    @Override
    public List<HouseVo> listPage(PageQuery pageQuery) {
        return houserDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return houserDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        houserDAO.removeMany(id);
    }

    @Override
    public List<Select2Vo> houseTypeList(long companyId, Long id) {
        return houserDAO.houseTypeList(companyId,id);
    }

    @Override
    public List<Select2Vo> hotelList(long companyId) {
        return houserDAO.hotelList(companyId);
    }

    @Override
    public List<Select2Vo> userList(long companyId) {
        return houserDAO.userList(companyId);
    }

    @Override
    public String getHouseCardTitle(long companyId) {
        return houserDAO.getHouseCardTitle(companyId);
    }

    @Override
    public Long findCount(PageQuery pageQuery, HouseVo houseVo) {
        return houserDAO.findCount(pageQuery, houseVo);
    }

    @Override
    public List<HouseVo> findPages(PageQuery pageQuery, HouseVo houseVo) {
        return houserDAO.findPages(pageQuery, houseVo);
    }

    @Override
    public void updateHouseStatus(StatusQuery statusQuery,Date leaveTitle) {
        houserDAO.updateHouseStatus(statusQuery,leaveTitle);
    }

    @Override
    public List<Select2Vo> getHouseList(Integer type,Long hotelId) {
        return houserDAO.getHouseList(type,hotelId);
    }
}
