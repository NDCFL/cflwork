package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.HouseTypeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.HouseTypeService;
import top.cflwork.vo.HouseTypeVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseTypeServiceImpl implements HouseTypeService {
    @Resource
    private HouseTypeDAO houseTypeDAO;

    @Override
    public void save(HouseTypeVo houseTypeVo) {
        houseTypeDAO.save(houseTypeVo);
    }

    @Override
    public void remove(HouseTypeVo houseTypeVo) {
        houseTypeDAO.remove(houseTypeVo);
    }

    @Override
    public void removeById(Long id) {
        houseTypeDAO.removeById(id);
    }

    @Override
    public void update(HouseTypeVo houseTypeVo) {
        houseTypeDAO.update(houseTypeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        houseTypeDAO.updateStatus(statusQuery);
    }

    @Override
    public HouseTypeVo getById(Long id) {
        return houseTypeDAO.getById(id);
    }

    @Override
    public List<HouseTypeVo> listAll() {
        return houseTypeDAO.listAll();
    }

    @Override
    public List<HouseTypeVo> listPage(PageQuery pageQuery) {
        return houseTypeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return houseTypeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        houseTypeDAO.removeMany(id);
    }

    @Override
    public Long findCount(PageQuery pageQuery, HouseTypeVo houseTypeVo) {
        return houseTypeDAO.findCount(pageQuery, houseTypeVo);
    }

    @Override
    public List<HouseTypeVo> findPage(PageQuery pageQuery, HouseTypeVo houseTypeVo) {
        return houseTypeDAO.findPage(pageQuery, houseTypeVo);
    }

    @Override
    public Integer getHouseType(String name, Long hotelId) {
        return houseTypeDAO.getHouseType(name, hotelId);
    }
}
