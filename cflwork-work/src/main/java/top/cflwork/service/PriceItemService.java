package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.BusinessVo;
import top.cflwork.vo.PriceItemVo;

import java.util.List;

public interface PriceItemService extends BaseService<PriceItemVo>{
    List<PriceItemVo> findPriceItemList(PageQuery pageQuery, PriceItemVo priceItemVo);
    long findPriceItemByCount(PageQuery pageQuery, PriceItemVo priceItemVo);
    BusinessVo getInfo(String times);
    List<BusinessVo> getInfos(String times);
    int findItems(PriceItemVo priceItemVo);
    void updatePriceItem(PriceItemVo priceItemVo);
    List<PriceItemVo>  priceItems(PriceItemVo priceItemVo);
    List<PriceItemVo> findItemes(PriceItemVo priceItemVo);
    List<PriceItemVo> infos(String times);
    List<BusinessVo> priceInfo(String times, Long id);
    List<BusinessVo> allPriceInfo(String times, Long id);
    void deletePriceItem(Long id);
}
