package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.IncomeVo;

import java.util.List;

/**
 * 酒店的收入表，记录哪个公司旗下的哪个酒店，的收入明细

 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-09-17 15:50:17
 */
public interface IncomeService  extends BaseService<IncomeVo>{
    List<IncomeVo> listPages(PageQuery pageQuery, IncomeVo incomeVo);
    long counts(PageQuery pageQuery, IncomeVo incomeVo);
}
