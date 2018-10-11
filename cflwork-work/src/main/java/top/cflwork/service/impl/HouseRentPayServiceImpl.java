package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.HouseRentPayDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HouseRentPayService;
import top.cflwork.vo.HouseRentPayVo;
import top.cflwork.vo.HouseRentVo;
import top.cflwork.vo.Select2Vo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/24.
 */
@Service
public class HouseRentPayServiceImpl implements HouseRentPayService {
    @Resource
    private HouseRentPayDAO houseRentPayDAO;
    @Override
    public void save(HouseRentPayVo houseRentPayVo) {
        houseRentPayDAO.save(houseRentPayVo);
    }

    @Override
    public void remove(HouseRentPayVo houseRentPayVo) {
        houseRentPayDAO.remove(houseRentPayVo);
    }

    @Override
    public void removeById(Long id) {
        houseRentPayDAO.removeById(id);
    }

    @Override
    public void update(HouseRentPayVo houseRentPayVo) {
        houseRentPayDAO.update(houseRentPayVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        houseRentPayDAO.updateStatus(statusQuery);
    }

    @Override
    public HouseRentPayVo getById(Long id) {
        return houseRentPayDAO.getById(id);
    }

    @Override
    public List<HouseRentPayVo> listAll() {
        return houseRentPayDAO.listAll();
    }

    @Override
    public List<HouseRentPayVo> listPage(PageQuery pageQuery) {
        return houseRentPayDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return houseRentPayDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        houseRentPayDAO.removeMany(id);
    }

    @Override
    public List<Select2Vo> getContractMaster(Long companyId) {
        return houseRentPayDAO.getContractMaster(companyId);
    }

    @Override
    public List<Select2Vo> getHotel(Long companyId) {
        return houseRentPayDAO.getHotel(companyId);
    }

    @Override
    public HouseRentVo notHotelId() {
        return houseRentPayDAO.notHotelId();
    }

    @Override
    public HouseRentVo haveHotelId(Long hotelId) {
        return houseRentPayDAO.haveHotelId(hotelId);
    }

    @Override
    public void huankuan(HouseRentPayVo houseRentPayVo) {
        houseRentPayDAO.huankuan(houseRentPayVo);
    }

    @Override
    public HouseRentVo findHotelId(HouseRentPayVo houseRentPayVo) {
        return houseRentPayDAO.findHotelId(houseRentPayVo);
    }

    @Override
    public List<HouseRentPayVo> pageLists(PageQuery pageQuery, HouseRentPayVo houseRentPayVo) {
        return houseRentPayDAO.pageLists(pageQuery, houseRentPayVo);
    }

    @Override
    public Long counts(PageQuery pageQuery, HouseRentPayVo houseRentPayVo) {
        return houseRentPayDAO.counts(pageQuery, houseRentPayVo);
    }

    @Override
    public Long chaoqicount(PageQuery pageQuery) {
        return houseRentPayDAO.chaoqicount(pageQuery);
    }

    @Override
    public List<HouseRentPayVo> chaoqilistPage(PageQuery pageQuery) {
        return houseRentPayDAO.chaoqilistPage(pageQuery);
    }
}
