package top.cflwork.service;

import top.cflwork.query.StatusQuery;
import top.cflwork.vo.ContracmasterMsgVo;
import top.cflwork.query.PageQuery;
import java.util.List;
import java.util.Map;

/**
 * 业主消息表，用于给业主发送消息
 * 
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-11-21 10:06:20
 */
public interface ContracmasterMsgService  extends BaseService<ContracmasterMsgVo>{
    List<ContracmasterMsgVo> listPages(PageQuery pageQuery, ContracmasterMsgVo contracmasterMsgVo);
    long counts(PageQuery pageQuery, ContracmasterMsgVo contracmasterMsgVo);
    long cnt(StatusQuery statusQuery);
}
