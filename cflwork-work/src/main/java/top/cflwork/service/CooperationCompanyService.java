package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.CooperationCompanyVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/6.
 */
public interface CooperationCompanyService extends BaseService<CooperationCompanyVo>{
    List<CooperationCompanyVo> listPages(PageQuery pageQuery);
    Long counts(PageQuery pageQuery);
}
