package top.cflwork.service;

import top.cflwork.vo.OucomeItemVo;
import top.cflwork.query.PageQuery;
import java.util.List;
import java.util.Map;

/**
 * 成本支出明细
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:29:58
 */
public interface OucomeItemService  extends BaseService<OucomeItemVo>{
    List<OucomeItemVo> listPages(PageQuery pageQuery, OucomeItemVo oucomeItemVo);
    long counts(PageQuery pageQuery, OucomeItemVo oucomeItemVo);
}
