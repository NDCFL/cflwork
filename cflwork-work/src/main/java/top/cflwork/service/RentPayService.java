package top.cflwork.service;

import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.*;

import java.util.List;

public interface RentPayService extends BaseService<RentPayVo>{
    List<Select2Vo> getContractMaster(Long companyId);
    List<Select2Vo> getHotel(Long companyId);
    RentVo notHotelId();
    RentVo haveHotelId(Long hotelId);
    void huankuan(Long id);
    List<Select2Vo> getHouse(PageQuery pageQuery);
    List<RentPayMoneyVo> getSubjectMoney(RentPayMoneyVo rentPayMoneyVo);
    /**
     * 获取没有在分成录入数据的酒店
     * @return
     */
    List<HotelVo> getOtherHotel(UserVo userVo);
    /**
     * 搜索分页
     * @param pageQuery
     * @param rentPayVo
     * @return
     */
    List<RentPayVo> listPages(PageQuery pageQuery,RentPayVo rentPayVo);

    /**
     * 搜索记录条数
     * @param pageQuery
     * @param rentPayVo
     * @return
     */
    Long counts(PageQuery pageQuery,RentPayVo rentPayVo);

    Long getHotelId(Long id);

}
