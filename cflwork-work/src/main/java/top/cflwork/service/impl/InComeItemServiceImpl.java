package top.cflwork.service.impl;

import com.xiaoleilu.hutool.date.DateUnit;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import top.cflwork.dao.IncomeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.dao.InComeItemDAO;
import top.cflwork.vo.InComeItemVo;
import top.cflwork.service.InComeItemService;
import top.cflwork.vo.IncomeVo;

import javax.annotation.Resource;


@Service
public class InComeItemServiceImpl implements InComeItemService {
    @Resource
    private InComeItemDAO inComeItemDAO;
    @Resource
    private IncomeDAO incomeDAO;
    @Override
    public void save(InComeItemVo inComeItemVo) {

        inComeItemDAO.save(inComeItemVo);
    }

    @Override
    public void remove(InComeItemVo inComeItemVo) {
        inComeItemDAO.remove(inComeItemVo);
    }

    @Override
    public void removeById(Long id) {
        inComeItemDAO.removeById(id);
    }

    @Override
    public void update(InComeItemVo inComeItemVo) {
        inComeItemDAO.update(inComeItemVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        inComeItemDAO.updateStatus(statusQuery);
    }

    @Override
    public InComeItemVo getById(Long id) {
        return inComeItemDAO.getById(id);
    }

    @Override
    public List<InComeItemVo> listAll() {
        return inComeItemDAO.listAll();
    }

    @Override
    public List<InComeItemVo> listPage(PageQuery pageQuery) {
        return inComeItemDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return inComeItemDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      inComeItemDAO.removeMany(id);
    }

    @Override
    public List<InComeItemVo> listPages(PageQuery pageQuery, InComeItemVo inComeItemVo) {
        return inComeItemDAO.listPages(pageQuery, inComeItemVo);
    }

    @Override
    public long counts(PageQuery pageQuery, InComeItemVo inComeItemVo) {
        return  inComeItemDAO.counts(pageQuery, inComeItemVo);
    }

    @Override
    public void batchSave(List<InComeItemVo> inComeItemVoList) {
        inComeItemDAO.batchSave(inComeItemVoList);
    }

    @Override
    public void deleteByIncomeId(Long id) {
        inComeItemDAO.deleteByIncomeId(id);
    }

    @Override
    @Transactional
    public void generateOrder(Long id) {
        IncomeVo incomeVo = incomeDAO.getById(id);
        incomeVo.setOrderStatus((byte)1);
        incomeDAO.update(incomeVo);
        //计算相差天数
        int days = (int) DateUtil.between(incomeVo.getStartTime(), incomeVo.getEndTime(), DateUnit.DAY);
        List<InComeItemVo> inComeItemVos = new ArrayList<>();
        for (int i = 0; i <=days; i++) {
            InComeItemVo inComeItemVo = new InComeItemVo();
            inComeItemVo.setIncomeId(incomeVo.getId());
            inComeItemVo.setSubjectName(incomeVo.getCashSubjectVo().getTitle());
            inComeItemVo.setMoney(incomeVo.getDayMoney());
            inComeItemVo.setTime(DateUtil.offsetDay(incomeVo.getStartTime(), i));
            inComeItemVo.setHotelId(incomeVo.getHotelId());
            inComeItemVos.add(inComeItemVo);
        }
        inComeItemDAO.batchSave(inComeItemVos);
    }

    @Override
    public List<InComeItemVo> findList(Long id) {
        return inComeItemDAO.findList(id);
    }
}
