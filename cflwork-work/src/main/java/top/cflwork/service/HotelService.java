package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.HotelVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

public interface HotelService extends BaseService<HotelVo>{
    long counts(PageQuery pageQuery, long companyId);
    List<HotelVo> listPages(PageQuery pageQuery, long companyId);
    List<Select2Vo> getContract();
    List<Select2Vo> getLandlord();
    HotelVo findHotel(long hotelManagerId);
    List<HotelVo> findPages(PageQuery pageQuery, HotelVo hotelVo);
    Long findCount(PageQuery pageQuery, HotelVo hotelVo);

}
