package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.HouseVo;
import top.cflwork.vo.Select2Vo;

import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
public interface HouseService extends  BaseService<HouseVo>{
    List<Select2Vo> houseTypeList(long companyId, Long id);
    List<Select2Vo> hotelList(long companyId);
    List<Select2Vo> userList(long companyId);
    String getHouseCardTitle(long companyId);
    Long findCount(PageQuery pageQuery, HouseVo houseVo);
    List<HouseVo> findPages(PageQuery pageQuery, HouseVo houseVo);
    void updateHouseStatus(StatusQuery statusQuery, Date leaveTitle);
}
