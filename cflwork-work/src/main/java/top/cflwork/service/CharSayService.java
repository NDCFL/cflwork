package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.CharSayVo;

import java.util.List;

public interface CharSayService extends BaseService<CharSayVo>{
    List<CharSayVo> findCharSayList(PageQuery pageQuery, CharSayVo charSayVo);
    long findCharSayByCount(PageQuery pageQuery, CharSayVo charSayVo);

}
