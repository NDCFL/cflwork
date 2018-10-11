package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.CustomerOrderVo;
import top.cflwork.vo.Select2Vo;

import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/12/9.
 */
@Repository
public interface CustomerOrderDAO extends BaseDAO<CustomerOrderVo>{

    List<Select2Vo> getSubject(Long companyId);
    List<Select2Vo> getWeb(Long companyId);
    List<Select2Vo> getHouse(@Param("pageQuery") PageQuery pageQuery, @Param("type") Long type, @Param("leaveTime") Date leaveTime, @Param("status") int status);
    void updateCashStatus(CustomerOrderVo customerOrderVo);
    void updateRemark(CustomerOrderVo customerOrderVo);
    void checkerManyCashAccount(List<CustomerOrderVo> customerOrderVoList);
    List<Select2Vo> getOthersHotel(PageQuery pageQuery);
    void saveList(List<CustomerOrderVo> customerOrderVoList);
    void changeHouse(CustomerOrderVo customerOrderVo);
    void endHouse(CustomerOrderVo customerOrderVo);
}
