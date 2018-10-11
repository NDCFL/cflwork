package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.HotelDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HotelService;
import top.cflwork.vo.HotelVo;
import top.cflwork.vo.Select2Vo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Resource
    private HotelDAO hotelDAO;
    @Override
    public long counts(PageQuery pageQuery,long companyId) {
        return hotelDAO.counts(pageQuery,companyId);
    }

    @Override
    public List<HotelVo> listPages(PageQuery pageQuery, long companyId) {
        return hotelDAO.listPages(pageQuery,companyId);
    }

    @Override
    public List<Select2Vo> getContract() {
        return hotelDAO.getContract();
    }

    @Override
    public List<Select2Vo> getLandlord() {
        return hotelDAO.getLandlord();
    }

    @Override
    public HotelVo findHotel(long hotelManagerId) {
        return hotelDAO.findHotel(hotelManagerId);
    }

    @Override
    public List<HotelVo> findPages(PageQuery pageQuery, HotelVo hotelVo) {
        return hotelDAO.findPages(pageQuery, hotelVo);
    }

    @Override
    public Long findCount(PageQuery pageQuery, HotelVo hotelVo) {
        return hotelDAO.findCount(pageQuery, hotelVo);
    }

    @Override
    public void save(HotelVo hotelVo) {
        hotelDAO.save(hotelVo);
    }

    @Override
    public void remove(HotelVo hotelVo) {
        hotelDAO.remove(hotelVo);
    }

    @Override
    public void removeById(Long id) {
        hotelDAO.removeById(id);
    }

    @Override
    public void update(HotelVo hotelVo) {
        hotelDAO.update(hotelVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        hotelDAO.updateStatus(statusQuery);
    }

    @Override
    public HotelVo getById(Long id) {
        return hotelDAO.getById(id);
    }

    @Override
    public List<HotelVo> listAll() {
        return hotelDAO.listAll();
    }

    @Override
    public List<HotelVo> listPage(PageQuery pageQuery) {
        return hotelDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return hotelDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        hotelDAO.removeMany(id);
    }
}
