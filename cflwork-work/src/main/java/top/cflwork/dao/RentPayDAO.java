package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.*;

import java.util.List;

@Repository
public interface RentPayDAO extends BaseDAO<RentPayVo>{
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
    List<RentPayVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("rentPayVo") RentPayVo rentPayVo);

    /**
     * 搜索记录条数
     * @param pageQuery
     * @param rentPayVo
     * @return
     */
    Long counts(@Param("pageQuery") PageQuery pageQuery, @Param("rentPayVo") RentPayVo rentPayVo);



}
