package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.PaymentTypeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.PaymentTypeService;
import top.cflwork.vo.PaymentTypeVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    @Resource
    private PaymentTypeDAO paymentTypeDAO;

    @Override
    public void save(PaymentTypeVo paymentTypeVo) {
        paymentTypeDAO.save(paymentTypeVo);
    }

    @Override
    public void remove(PaymentTypeVo paymentTypeVo) {
        paymentTypeDAO.remove(paymentTypeVo);
    }

    @Override
    public void removeById(Long id) {
        paymentTypeDAO.removeById(id);
    }

    @Override
    public void update(PaymentTypeVo paymentTypeVo) {
        paymentTypeDAO.update(paymentTypeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        paymentTypeDAO.updateStatus(statusQuery);
    }

    @Override
    public PaymentTypeVo getById(Long id) {
        return paymentTypeDAO.getById(id);
    }

    @Override
    public List<PaymentTypeVo> listAll() {
        return paymentTypeDAO.listAll();
    }

    @Override
    public List<PaymentTypeVo> listPage(PageQuery pageQuery) {
        return paymentTypeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return paymentTypeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        paymentTypeDAO.removeMany(id);
    }
}
