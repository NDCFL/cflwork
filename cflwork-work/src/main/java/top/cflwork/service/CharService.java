package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.CharVo;

import java.util.List;

public interface CharService extends BaseService<CharVo>{
    List<CharVo> findCharList(PageQuery pageQuery, CharVo charVo);
    long findCharByCount(PageQuery pageQuery, CharVo charVo);
    List<CharVo> myCharList(Long id);
    void deleteChar(Long id);
}
