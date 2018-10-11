package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.BusinessVo;
import top.cflwork.vo.PriceItemVo;

import java.util.List;

@Repository
public interface PriceItemDAO extends BaseDAO<PriceItemVo>{
    List<PriceItemVo> findPriceItemList(@Param("pageQuery") PageQuery pageQuery, @Param("priceItemVo") PriceItemVo priceItemVo);
    long findPriceItemByCount(@Param("pageQuery") PageQuery pageQuery, @Param("priceItemVo") PriceItemVo priceItemVo);
    BusinessVo getInfo(String times);
    List<BusinessVo> getInfos(String times);
    int findItems(PriceItemVo priceItemVo);
    void updatePriceItem(PriceItemVo priceItemVo);
    List<PriceItemVo>  priceItems(PriceItemVo priceItemVo);
    List<PriceItemVo> findItemes(PriceItemVo priceItemVo);
    List<PriceItemVo> infos(String times);
    List<BusinessVo> priceInfo(@Param("times") String times, @Param("id") Long id);
    List<BusinessVo> allPriceInfo(@Param("times") String times, @Param("id") Long id);
    void deletePriceItem(Long id);
}
