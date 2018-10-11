package top.cflwork.dao;

import org.springframework.stereotype.Repository;
import top.cflwork.vo.HotelTypeVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

@Repository
public interface HotelTypeDAO extends BaseDAO<HotelTypeVo>{
    List<Select2Vo> hotelTypeList();
}
