package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.PriceItemDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.PriceItemService;
import top.cflwork.vo.BusinessVo;
import top.cflwork.vo.PriceItemVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PriceItemServiceImpl implements PriceItemService {
    @Resource
    private PriceItemDAO priceItemDAO;
    @Override
    public void save(PriceItemVo priceItemVo) {
        priceItemDAO.save(priceItemVo);
    }

    @Override
    public void remove(PriceItemVo priceItemVo) {
        priceItemDAO.remove(priceItemVo);
    }

    @Override
    public void removeById(Long id) {
        priceItemDAO.removeById(id);
    }

    @Override
    public void update(PriceItemVo priceItemVo) {
        priceItemDAO.update(priceItemVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        priceItemDAO.updateStatus(statusQuery);
    }

    @Override
    public PriceItemVo getById(Long id) {
        return priceItemDAO.getById(id);
    }

    @Override
    public List<PriceItemVo> listAll() {
        return priceItemDAO.listAll();
    }

    @Override
    public List<PriceItemVo> listPage(PageQuery pageQuery) {
        return priceItemDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return priceItemDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        priceItemDAO.removeMany(id);
    }

    @Override
    public List<PriceItemVo> findPriceItemList(PageQuery pageQuery, PriceItemVo priceItemVo) {
        return priceItemDAO.findPriceItemList(pageQuery, priceItemVo);
    }

    @Override
    public long findPriceItemByCount(PageQuery pageQuery, PriceItemVo priceItemVo) {
        return priceItemDAO.findPriceItemByCount(pageQuery, priceItemVo);
    }

    @Override
    public BusinessVo getInfo(String times) {
        return priceItemDAO.getInfo(times);
    }

    @Override
    public List<BusinessVo> getInfos(String times) {
        return priceItemDAO.getInfos(times);
    }

    @Override
    public int findItems(PriceItemVo priceItemVo) {
        return priceItemDAO.findItems(priceItemVo);
    }

    @Override
    public void updatePriceItem(PriceItemVo priceItemVo) {
        priceItemDAO.updatePriceItem(priceItemVo);
    }

    @Override
    public List<PriceItemVo> priceItems(PriceItemVo priceItemVo) {
        return priceItemDAO.priceItems(priceItemVo);
    }

    @Override
    public List<PriceItemVo> findItemes(PriceItemVo priceItemVo) {
        return priceItemDAO.findItemes(priceItemVo);
    }

    @Override
    public List<PriceItemVo> infos(String times) {
        return priceItemDAO.infos(times);
    }

    @Override
    public List<BusinessVo> priceInfo(String times, Long id) {
        return priceItemDAO.priceInfo(times, id);
    }

    @Override
    public List<BusinessVo> allPriceInfo(String times, Long id) {
        return priceItemDAO.allPriceInfo(times, id);
    }

    @Override
    public void deletePriceItem(Long id) {
        priceItemDAO.deletePriceItem(id);
    }
}
