package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.OrderItemsDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.OrderItemsService;
import top.cflwork.vo.OrderItemsVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {
    @Resource
    private OrderItemsDAO orderItemsDAO;

    @Override
    public void save(OrderItemsVo orderItemsVo) {
        orderItemsDAO.save(orderItemsVo);
    }

    @Override
    public void remove(OrderItemsVo orderItemsVo) {
        orderItemsDAO.remove(orderItemsVo);
    }

    @Override
    public void removeById(Long id) {
        orderItemsDAO.removeById(id);
    }

    @Override
    public void update(OrderItemsVo orderItemsVo) {
        orderItemsDAO.update(orderItemsVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        orderItemsDAO.updateStatus(statusQuery);
    }

    @Override
    public OrderItemsVo getById(Long id) {
        return orderItemsDAO.getById(id);
    }

    @Override
    public List<OrderItemsVo> listAll() {
        return orderItemsDAO.listAll();
    }

    @Override
    public List<OrderItemsVo> listPage(PageQuery pageQuery) {
        return orderItemsDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return orderItemsDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        orderItemsDAO.removeMany(id);
    }
}
