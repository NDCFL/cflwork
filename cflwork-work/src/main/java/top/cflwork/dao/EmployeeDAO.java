package top.cflwork.dao;

import org.springframework.stereotype.Repository;
import top.cflwork.vo.EmployeeVo;

/**
 * Created by chenfeilong on 2017/11/27.
 */
@Repository
public interface EmployeeDAO extends BaseDAO<EmployeeVo>{
    EmployeeVo getHotelId(Long employeeId);
}
