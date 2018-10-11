package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.HotelTypeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HotelTypeService;
import top.cflwork.vo.HotelTypeVo;
import top.cflwork.vo.Select2Vo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelTypeServiceImpl implements HotelTypeService {
    @Resource
    private HotelTypeDAO hotelTypeDAO;
    @Override
    public void save(HotelTypeVo hotelTypeVo) {
        hotelTypeDAO.save(hotelTypeVo);
    }

    @Override
    public void remove(HotelTypeVo hotelTypeVo) {
        hotelTypeDAO.remove(hotelTypeVo);
    }

    @Override
    public void removeById(Long id) {
        hotelTypeDAO.removeById(id);
    }

    @Override
    public void update(HotelTypeVo hotelTypeVo) {
        hotelTypeDAO.update(hotelTypeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        hotelTypeDAO.updateStatus(statusQuery);
    }

    @Override
    public HotelTypeVo getById(Long id) {
        return hotelTypeDAO.getById(id);
    }

    @Override
    public List<HotelTypeVo> listAll() {
        return hotelTypeDAO.listAll();
    }

    @Override
    public List<HotelTypeVo> listPage(PageQuery pageQuery) {
        return hotelTypeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return hotelTypeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        hotelTypeDAO.removeMany(id);
    }

    @Override
    public List<Select2Vo> hotelTypeList() {
        return hotelTypeDAO.hotelTypeList();
    }
}
