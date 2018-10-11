package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.HouseTypeVo;

import java.util.List;

@Repository
public interface HouseTypeDAO extends BaseDAO<HouseTypeVo>{

    Long findCount(@Param("pageQuery") PageQuery pageQuery, @Param("houseTypeVo") HouseTypeVo houseTypeVo);
    List<HouseTypeVo> findPage(@Param("pageQuery") PageQuery pageQuery, @Param("houseTypeVo") HouseTypeVo houseTypeVo);
    Integer getHouseType(@Param("name") String name, @Param("hotelId") Long hotelId);
}
