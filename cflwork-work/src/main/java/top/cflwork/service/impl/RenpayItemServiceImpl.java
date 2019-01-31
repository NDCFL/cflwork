package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.dao.RenpayItemDAO;
import top.cflwork.vo.RenpayItemVo;
import top.cflwork.service.RenpayItemService;import javax.annotation.Resource;


@Service
public class RenpayItemServiceImpl implements RenpayItemService {
    @Resource
    private RenpayItemDAO renpayItemDAO;

    @Override
    public void save(RenpayItemVo renpayItemVo) {
        renpayItemDAO.save(renpayItemVo);
    }

    @Override
    public void remove(RenpayItemVo renpayItemVo) {
        renpayItemDAO.remove(renpayItemVo);
    }

    @Override
    public void removeById(Long id) {
        renpayItemDAO.removeById(id);
    }

    @Override
    public void update(RenpayItemVo renpayItemVo) {
        renpayItemDAO.update(renpayItemVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        renpayItemDAO.updateStatus(statusQuery);
    }

    @Override
    public RenpayItemVo getById(Long id) {
        return renpayItemDAO.getById(id);
    }

    @Override
    public List<RenpayItemVo> listAll() {
        return renpayItemDAO.listAll();
    }

    @Override
    public List<RenpayItemVo> listPage(PageQuery pageQuery) {
        return renpayItemDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return renpayItemDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      renpayItemDAO.removeMany(id);
    }

    @Override
    public List<RenpayItemVo> listPages(PageQuery pageQuery, RenpayItemVo renpayItemVo) {
        return renpayItemDAO.listPages(pageQuery, renpayItemVo);
    }

    @Override
    public long counts(PageQuery pageQuery, RenpayItemVo renpayItemVo) {
        return  renpayItemDAO.counts(pageQuery, renpayItemVo);
    }
}
