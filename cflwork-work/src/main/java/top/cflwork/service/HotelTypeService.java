package top.cflwork.service;

import top.cflwork.vo.HotelTypeVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

public interface HotelTypeService extends BaseService<HotelTypeVo>{
    List<Select2Vo> hotelTypeList();
}
