package top.cflwork.service;

import top.cflwork.vo.RenpayItemVo;
import top.cflwork.query.PageQuery;
import java.util.List;
import java.util.Map;

/**
 * 分成房租，每个合同每期分成明细
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:44:21
 */
public interface RenpayItemService  extends BaseService<RenpayItemVo>{
    List<RenpayItemVo> listPages(PageQuery pageQuery, RenpayItemVo renpayItemVo);
    long counts(PageQuery pageQuery, RenpayItemVo renpayItemVo);
}
