package top.cflwork.service;

import top.cflwork.vo.EmployeeVo;

/**
 * Created by chenfeilong on 2017/11/27.
 */

public interface EmployeeService extends BaseService<EmployeeVo> {
    EmployeeVo getHotelId(Long employeeId);
}
