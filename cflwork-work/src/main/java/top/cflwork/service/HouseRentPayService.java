package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.HouseRentPayVo;
import top.cflwork.vo.HouseRentVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/24.
 */
public interface HouseRentPayService extends BaseService<HouseRentPayVo>{

    List<Select2Vo> getContractMaster(Long companyId);
    List<Select2Vo> getHotel(Long companyId);
    HouseRentVo notHotelId();
    HouseRentVo haveHotelId(Long hotelId);
    void huankuan(HouseRentPayVo houseRentPayVo);
    HouseRentVo findHotelId(HouseRentPayVo houseRentPayVo);
    List<HouseRentPayVo> pageLists(PageQuery pageQuery, HouseRentPayVo houseRentPayVo);
    Long counts(PageQuery pageQuery, HouseRentPayVo houseRentPayVo);
    Long chaoqicount(PageQuery pageQuery);
    List<HouseRentPayVo> chaoqilistPage(PageQuery pageQuery);
}
