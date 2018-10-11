package top.cflwork.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.cflwork.dao.LogDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.LogService;
import top.cflwork.vo.LogVo;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogDAO logDAO;

    @Override
    @Async
    public void save(LogVo logVo) {
        logDAO.save(logVo);
    }

    @Override
    public void remove(LogVo logVo) {
        logDAO.remove(logVo);
    }

    @Override
    public void removeById(Long id) {
        logDAO.removeById(id);
    }

    @Override
    public void update(LogVo logVo) {
        logDAO.update(logVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        logDAO.updateStatus(statusQuery);
    }

    @Override
    public LogVo getById(Long id) {
        return logDAO.getById(id);
    }

    @Override
    public List<LogVo> listAll() {
        return logDAO.listAll();
    }

    @Override
    public List<LogVo> listPage(PageQuery pageQuery) {
        return logDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return logDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      logDAO.removeMany(id);
    }

    @Override
    public List<LogVo> listPages(PageQuery pageQuery, LogVo logVo) {
        return logDAO.listPages(pageQuery, logVo);
    }

    @Override
    public long counts(PageQuery pageQuery, LogVo logVo) {
        return  logDAO.counts(pageQuery, logVo);
    }
}
