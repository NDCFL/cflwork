package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.CharVo;

import java.util.List;

@Repository
public interface CharDAO extends BaseDAO<CharVo>{
    List<CharVo> findCharList(@Param("pageQuery") PageQuery pageQuery, @Param("charVo") CharVo charVo);
    long findCharByCount(@Param("pageQuery") PageQuery pageQuery, @Param("charVo") CharVo charVo);
    List<CharVo> myCharList(Long id);
    void deleteChar(Long id);
}
