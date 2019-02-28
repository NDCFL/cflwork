package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.OutcomeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.OutcomeService;
import top.cflwork.vo.OutcomeVo;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OutcomeServiceImpl implements OutcomeService {
    @Resource
    private OutcomeDAO outcomeDAO;

    @Override
    public void save(OutcomeVo outcomeVo) {
        outcomeDAO.save(outcomeVo);
    }

    @Override
    public void remove(OutcomeVo outcomeVo) {
        outcomeDAO.remove(outcomeVo);
    }

    @Override
    public void removeById(Long id) {
        outcomeDAO.removeById(id);
    }

    @Override
    public void update(OutcomeVo outcomeVo) {
        outcomeDAO.update(outcomeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        outcomeDAO.updateStatus(statusQuery);
    }

    @Override
    public OutcomeVo getById(Long id) {
        return outcomeDAO.getById(id);
    }

    @Override
    public List<OutcomeVo> listAll() {
        return outcomeDAO.listAll();
    }

    @Override
    public List<OutcomeVo> listPage(PageQuery pageQuery) {
        return outcomeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return outcomeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      outcomeDAO.removeMany(id);
    }

    @Override
    public List<OutcomeVo> listPages(PageQuery pageQuery, OutcomeVo outcomeVo) {
        return outcomeDAO.listPages(pageQuery, outcomeVo);
    }

    @Override
    public long counts(PageQuery pageQuery, OutcomeVo outcomeVo) {
        return  outcomeDAO.counts(pageQuery, outcomeVo);
    }

    @Override
    public List<OutcomeVo> getList(Long hotelId) {
        return outcomeDAO.getList(hotelId);
    }

    @Override
    public List<OutcomeVo> getListBySubjectId(OutcomeVo outcomeVo) {
        return outcomeDAO.getListBySubjectId(outcomeVo);
    }
}
