package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.EmployeeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.EmployeeService;
import top.cflwork.vo.EmployeeVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/27.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDAO employeeDAO;
    @Override
    public void save(EmployeeVo employeeVo) {
        employeeDAO.save(employeeVo);
    }

    @Override
    public void remove(EmployeeVo employeeVo) {
        employeeDAO.remove(employeeVo);
    }

    @Override
    public void removeById(Long id) {
        employeeDAO.removeById(id);
    }

    @Override
    public void update(EmployeeVo employeeVo) {
        employeeDAO.update(employeeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        employeeDAO.updateStatus(statusQuery);
    }

    @Override
    public EmployeeVo getById(Long id) {
        return employeeDAO.getById(id);
    }

    @Override
    public List<EmployeeVo> listAll() {
        return employeeDAO.listAll();
    }

    @Override
    public List<EmployeeVo> listPage(PageQuery pageQuery) {
        return employeeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return employeeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        employeeDAO.removeMany(id);
    }

    @Override
    public EmployeeVo getHotelId(Long employeeId) {
        return employeeDAO.getHotelId(employeeId);
    }
}
