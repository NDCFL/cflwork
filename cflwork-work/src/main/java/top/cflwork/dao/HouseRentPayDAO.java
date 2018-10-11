package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.HouseRentPayVo;
import top.cflwork.vo.HouseRentVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/24.
 */
@Repository
public interface HouseRentPayDAO extends BaseDAO<HouseRentPayVo>{

    List<Select2Vo> getContractMaster(Long companyId);
    List<Select2Vo> getHotel(Long companyId);
    HouseRentVo notHotelId();
    HouseRentVo haveHotelId(Long hotelId);
    HouseRentVo findHotelId(HouseRentPayVo houseRentPayVo);
    void huankuan(HouseRentPayVo houseRentPayVo);
    Long chaoqicount(PageQuery pageQuery);
    List<HouseRentPayVo> chaoqilistPage(PageQuery pageQuery);
    List<HouseRentPayVo> pageLists(@Param("pageQuery") PageQuery pageQuery, @Param("houseRentPayVo") HouseRentPayVo houseRentPayVo);
    Long counts(@Param("pageQuery") PageQuery pageQuery, @Param("houseRentPayVo") HouseRentPayVo houseRentPayVo);
}
