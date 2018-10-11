package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cflwork.dao.CustomerOrderOTADAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CustomerOrderOTAService;
import top.cflwork.vo.CustomerOrderOTAVO;

import java.util.List;

@Service
public class CustomerOrderOTAServiceImpl implements CustomerOrderOTAService {

    @Autowired
    private CustomerOrderOTADAO customerOrderOTADAO;

    @Override
    public void save(CustomerOrderOTAVO customerOrderOTAVO) {
        customerOrderOTADAO.save(customerOrderOTAVO);
    }

    @Override
    public void remove(CustomerOrderOTAVO customerOrderOTAVO) {
        customerOrderOTADAO.remove(customerOrderOTAVO);
    }

    @Override
    public void removeById(Long id) {
        customerOrderOTADAO.removeById(id);
    }

    @Override
    public void update(CustomerOrderOTAVO customerOrderOTAVO) {
        customerOrderOTADAO.update(customerOrderOTAVO);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        customerOrderOTADAO.updateStatus(statusQuery);
    }

    @Override
    public CustomerOrderOTAVO getById(Long id) {
        return customerOrderOTADAO.getById(id);
    }

    @Override
    public List<CustomerOrderOTAVO> listAll() {
        return customerOrderOTADAO.listAll();
    }

    @Override
    public List<CustomerOrderOTAVO> listPage(PageQuery pageQuery) {
        return customerOrderOTADAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return customerOrderOTADAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        customerOrderOTADAO.removeMany(id);
    }

    @Transactional
    @Override
    public void batchSave(List<Object> orders) {
        customerOrderOTADAO.batchSave(orders);
    }
}
