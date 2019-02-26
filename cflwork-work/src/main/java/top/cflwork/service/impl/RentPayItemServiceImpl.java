package top.cflwork.service.impl;

import com.xiaoleilu.hutool.date.DateUnit;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import top.cflwork.dao.RentPayDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.dao.RentPayItemDAO;
import top.cflwork.vo.RentPayItemVo;
import top.cflwork.service.RentPayItemService;
import top.cflwork.vo.RentPayVo;
import top.cflwork.vo.TodayPayVo;

import javax.annotation.Resource;


@Service
public class RentPayItemServiceImpl implements RentPayItemService {
    @Resource
    private RentPayItemDAO rentPayItemDAO;
    @Resource
    private RentPayDAO rentPayDAO;
    @Override
    public void save(RentPayItemVo rentPayItemVo) {
        rentPayItemDAO.save(rentPayItemVo);
    }

    @Override
    public void remove(RentPayItemVo rentPayItemVo) {
        rentPayItemDAO.remove(rentPayItemVo);
    }

    @Override
    public void removeById(Long id) {
        rentPayItemDAO.removeById(id);
    }

    @Override
    public void update(RentPayItemVo rentPayItemVo) {
        rentPayItemDAO.update(rentPayItemVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        rentPayItemDAO.updateStatus(statusQuery);
    }

    @Override
    public RentPayItemVo getById(Long id) {
        return rentPayItemDAO.getById(id);
    }

    @Override
    public List<RentPayItemVo> listAll() {
        return rentPayItemDAO.listAll();
    }

    @Override
    public List<RentPayItemVo> listPage(PageQuery pageQuery) {
        return rentPayItemDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return rentPayItemDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      rentPayItemDAO.removeMany(id);
    }

    @Override
    public List<RentPayItemVo> listPages(PageQuery pageQuery, RentPayItemVo rentPayItemVo) {
        return rentPayItemDAO.listPages(pageQuery, rentPayItemVo);
    }

    @Override
    public long counts(PageQuery pageQuery, RentPayItemVo rentPayItemVo) {
        return  rentPayItemDAO.counts(pageQuery, rentPayItemVo);
    }

    @Override
    public void batchSave(List<RentPayItemVo> rentPayItemVos) {
        rentPayItemDAO.batchSave(rentPayItemVos);
    }

    @Override
    public void deleteByRentPayId(Long id) {
        rentPayItemDAO.deleteByRentPayId(id);
    }

    @Override
    public List<RentPayItemVo> findList(Long id) {
        return rentPayItemDAO.findList(id);
    }
    @Override
    @Transactional
    public void generateOrder(Long id) {
        RentPayVo rentPayVo = rentPayDAO.getById(id);
        rentPayVo.setOrderStatus((byte)1);
        rentPayDAO.update(rentPayVo);
        //计算相差月数/分成时间计算得出
        int days = rentPayVo.getPayTime()*12/rentPayVo.getPayTime();
        List<RentPayItemVo> rentPayItemVos = new ArrayList<>();
        for (int i = 0; i <=days; i++) {
            RentPayItemVo rentPayItemVo = new RentPayItemVo();
            rentPayItemVo.setRentPayId(rentPayVo.getId());
            rentPayItemVo.setPayTime(DateUtil.offsetMonth(rentPayVo.getFactPayTimeStart(), i*rentPayVo.getPayTime()));
            rentPayItemVo.setPayType(rentPayVo.getPayMoneyType());
            rentPayItemVo.setIsActive((byte)0);
            rentPayItemVo.setPayProportion(rentPayVo.getPayProportion());
            rentPayItemVo.setMasterId(rentPayVo.getMasterId());
            rentPayItemVo.setHotelId(rentPayVo.getHotelId());
            rentPayItemVo.setEndTime(DateUtil.offsetMonth(rentPayVo.getFactPayTimeStart(), (i+1)*rentPayVo.getPayTime()));
            rentPayItemVos.add(rentPayItemVo);
        }
        rentPayItemDAO.batchSave(rentPayItemVos);
    }

    @Override
    public TodayPayVo getPayInfo(RentPayItemVo rentPayItemVo) {
        return rentPayItemDAO.getPayInfo(rentPayItemVo);
    }
}
