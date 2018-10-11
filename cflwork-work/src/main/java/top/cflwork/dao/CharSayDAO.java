package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.CharSayVo;

import java.util.List;

@Repository
public interface CharSayDAO extends BaseDAO<CharSayVo>{
    List<CharSayVo> findCharSayList(@Param("pageQuery") PageQuery pageQuery, @Param("charVo") CharSayVo charSayVo);
    long findCharSayByCount(@Param("pageQuery") PageQuery pageQuery, @Param("charVo") CharSayVo charSayVo);

}
