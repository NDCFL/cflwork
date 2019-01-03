package top.cflwork.dao;

import top.cflwork.query.StatusQuery;
import top.cflwork.vo.ContracmasterMsgVo;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import top.cflwork.query.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.cflwork.dao.BaseDAO;

/**
 * 业主消息表，用于给业主发送消息
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-11-21 10:06:20
 */
@Repository
public interface ContracmasterMsgDAO extends BaseDAO<ContracmasterMsgVo>{
    List<ContracmasterMsgVo> listPages(@Param("pageQuery") PageQuery pageQuery, @Param("contracmasterMsgVo") ContracmasterMsgVo contracmasterMsgVo);
    long counts(@Param("pageQuery") PageQuery pageQuery, @Param("contracmasterMsgVo") ContracmasterMsgVo contracmasterMsgVo);
    long cnt(StatusQuery statusQuery);
}
