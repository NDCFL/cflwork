package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.HotelVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

@Repository
public interface HotelDAO extends BaseDAO<HotelVo>{
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("companyId") long companyId);
    List<HotelVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("companyId") long companyId);
    List<Select2Vo> getContract();
    List<Select2Vo> getLandlord();
    HotelVo findHotel(long hotelManagerId);
    List<HotelVo> findPages(@Param("pageQuery") PageQuery pageQuery, @Param("hotelVo") HotelVo hotelVo);
    Long findCount(@Param("pageQuery") PageQuery pageQuery, @Param("hotelVo") HotelVo hotelVo);
}
