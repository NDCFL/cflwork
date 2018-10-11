package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CharSayDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CharSayService;
import top.cflwork.vo.CharSayVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CharSayServiceImpl implements CharSayService{
    @Resource
    private CharSayDAO charSayDAO;

    @Override
    public void save(CharSayVo charSayVo) {
        charSayDAO.save(charSayVo);
    }

    @Override
    public void remove(CharSayVo charSayVo) {
        charSayDAO.remove(charSayVo);
    }

    @Override
    public void removeById(Long id) {
        charSayDAO.removeById(id);
    }

    @Override
    public void update(CharSayVo charSayVo) {
        charSayDAO.update(charSayVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        charSayDAO.updateStatus(statusQuery);
    }

    @Override
    public CharSayVo getById(Long id) {
        return charSayDAO.getById(id);
    }

    @Override
    public List<CharSayVo> listAll() {
        return charSayDAO.listAll();
    }

    @Override
    public List<CharSayVo> listPage(PageQuery pageQuery) {
        return charSayDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return charSayDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        charSayDAO.removeMany(id);
    }

    @Override
    public List<CharSayVo> findCharSayList(PageQuery pageQuery, CharSayVo charSayVo) {
        return charSayDAO.findCharSayList(pageQuery, charSayVo);
    }

    @Override
    public long findCharSayByCount(PageQuery pageQuery, CharSayVo charSayVo) {
        return charSayDAO.findCharSayByCount(pageQuery, charSayVo);
    }
}
