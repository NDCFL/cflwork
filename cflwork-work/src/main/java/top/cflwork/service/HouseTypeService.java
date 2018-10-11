package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.HouseTypeVo;

import java.util.List;

public interface HouseTypeService extends  BaseService<HouseTypeVo>{
    Long findCount(PageQuery pageQuery, HouseTypeVo houseTypeVo);
    List<HouseTypeVo> findPage(PageQuery pageQuery, HouseTypeVo houseTypeVo);
    Integer getHouseType(String name, Long hotelId);
}
