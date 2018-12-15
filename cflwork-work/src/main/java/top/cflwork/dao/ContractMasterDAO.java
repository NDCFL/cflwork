package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.*;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/16.
 */
@Repository
public interface ContractMasterDAO extends  BaseDAO<ContractMasterVo> {
    List<ContractMasterVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("companyId") long companyId);
    long counts(@Param("companyId") long companyId, @Param("pageQuery") PageQuery pageQuery);
    List<Select2Vo> listAlls(long companyId);
    int checkPhone(String phone);
    ContractMasterVo findContractMaster(ContractMasterVo contractMasterVo);
    TodayPayVo getPayInfo(@Param("id") Long id,@Param("time") String time);
    List<Select2Vo> getHotelList(Long id);
    ContractHouseListVo getHotelInfo(StatusQuery statusQuery);
    List<HouseVo> getHouseList(StatusQuery statusQuery);
    List<RentPayVo> getRentPayList(Long id);
}
