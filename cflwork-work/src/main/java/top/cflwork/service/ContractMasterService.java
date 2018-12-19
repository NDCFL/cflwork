package top.cflwork.service;

import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.*;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/16.
 */
public interface ContractMasterService extends BaseService<ContractMasterVo> {
    List<ContractMasterVo> listPages(PageQuery pageQuery, long companyId);
    long counts(long companyId, PageQuery pageQuery);
    List<Select2Vo> listAlls(long companyId);
    ContractMasterVo findContractMaster(ContractMasterVo contractMasterVo);
    TodayPayVo getPayInfo(Long id,String time);
    int checkPhone(String phone);
    List<Select2Vo> getHotelList(Long id);
    ContractHouseListVo getHotelInfo(StatusQuery statusQuery);
    List<HouseVo> getHouseList(StatusQuery statusQuery);
    List<RentPayVo> getRentPayList(Long id);
    Long checkPhones(ContractMasterVo contractMasterVo);
}
