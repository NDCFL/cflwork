package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.LogVo;

import java.util.List;

/**
 * 系统日志
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-09-29 09:36:57
 */
public interface LogService  extends BaseService<LogVo>{
    List<LogVo> listPages(PageQuery pageQuery, LogVo logVo);
    long counts(PageQuery pageQuery, LogVo logVo);
}
