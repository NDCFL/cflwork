package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.HouseVo;
import top.cflwork.vo.Select2Vo;

import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Repository
public interface HouseDAO extends  BaseDAO<HouseVo> {
    List<Select2Vo> houseTypeList(@Param("companyId") long companyId, @Param("id") Long id);
    List<Select2Vo> hotelList(long companyId);
    List<Select2Vo> userList(long companyId);
    String getHouseCardTitle(long companyId);
    Long findCount(@Param("pageQuery") PageQuery pageQuery, @Param("houseVo") HouseVo houseVo);
    List<HouseVo> findPages(@Param("pageQuery") PageQuery pageQuery, @Param("houseVo") HouseVo houseVo);
    void updateHouseStatus(@Param("statusQuery") StatusQuery statusQuery, @Param("leaveTime") Date leaveTime);
    List<Select2Vo> getHouseList(@Param("type") Integer type,@Param("hotelId") Long hotelId);
}
