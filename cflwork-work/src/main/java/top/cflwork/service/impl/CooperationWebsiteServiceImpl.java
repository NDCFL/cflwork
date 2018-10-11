package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CooperationWebsiteDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CooperationWebsiteService;
import top.cflwork.vo.CooperationWebsiteVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/19.
 */
@Service
public class CooperationWebsiteServiceImpl implements CooperationWebsiteService {
    @Resource
    private CooperationWebsiteDAO cooperationWebsiteDAO;

    @Override
    public void save(CooperationWebsiteVo cooperationWebsiteVo) {
        cooperationWebsiteDAO.save(cooperationWebsiteVo);
    }

    @Override
    public void remove(CooperationWebsiteVo cooperationWebsiteVo) {
        cooperationWebsiteDAO.remove(cooperationWebsiteVo);
    }

    @Override
    public void removeById(Long id) {
        cooperationWebsiteDAO.removeById(id);
    }

    @Override
    public void update(CooperationWebsiteVo cooperationWebsiteVo) {
        cooperationWebsiteDAO.update(cooperationWebsiteVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        cooperationWebsiteDAO.updateStatus(statusQuery);
    }

    @Override
    public CooperationWebsiteVo getById(Long id) {
        return cooperationWebsiteDAO.getById(id);
    }

    @Override
    public List<CooperationWebsiteVo> listAll() {
        return cooperationWebsiteDAO.listAll();
    }

    @Override
    public List<CooperationWebsiteVo> listPage(PageQuery pageQuery) {
        return cooperationWebsiteDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return cooperationWebsiteDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        cooperationWebsiteDAO.removeMany(id);
    }
}