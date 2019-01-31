package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.dao.OucomeItemDAO;
import top.cflwork.vo.OucomeItemVo;
import top.cflwork.service.OucomeItemService;import javax.annotation.Resource;


@Service
public class OucomeItemServiceImpl implements OucomeItemService {
    @Resource
    private OucomeItemDAO oucomeItemDAO;

    @Override
    public void save(OucomeItemVo oucomeItemVo) {
        oucomeItemDAO.save(oucomeItemVo);
    }

    @Override
    public void remove(OucomeItemVo oucomeItemVo) {
        oucomeItemDAO.remove(oucomeItemVo);
    }

    @Override
    public void removeById(Long id) {
        oucomeItemDAO.removeById(id);
    }

    @Override
    public void update(OucomeItemVo oucomeItemVo) {
        oucomeItemDAO.update(oucomeItemVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        oucomeItemDAO.updateStatus(statusQuery);
    }

    @Override
    public OucomeItemVo getById(Long id) {
        return oucomeItemDAO.getById(id);
    }

    @Override
    public List<OucomeItemVo> listAll() {
        return oucomeItemDAO.listAll();
    }

    @Override
    public List<OucomeItemVo> listPage(PageQuery pageQuery) {
        return oucomeItemDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return oucomeItemDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      oucomeItemDAO.removeMany(id);
    }

    @Override
    public List<OucomeItemVo> listPages(PageQuery pageQuery, OucomeItemVo oucomeItemVo) {
        return oucomeItemDAO.listPages(pageQuery, oucomeItemVo);
    }

    @Override
    public long counts(PageQuery pageQuery, OucomeItemVo oucomeItemVo) {
        return  oucomeItemDAO.counts(pageQuery, oucomeItemVo);
    }
}
