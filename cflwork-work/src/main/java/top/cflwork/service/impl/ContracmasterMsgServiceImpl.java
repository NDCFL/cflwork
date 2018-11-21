package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.dao.ContracmasterMsgDAO;
import top.cflwork.vo.ContracmasterMsgVo;
import top.cflwork.service.ContracmasterMsgService;import javax.annotation.Resource;


@Service
public class ContracmasterMsgServiceImpl implements ContracmasterMsgService {
    @Resource
    private ContracmasterMsgDAO contracmasterMsgDAO;

    @Override
    public void save(ContracmasterMsgVo contracmasterMsgVo) {
        contracmasterMsgDAO.save(contracmasterMsgVo);
    }

    @Override
    public void remove(ContracmasterMsgVo contracmasterMsgVo) {
        contracmasterMsgDAO.remove(contracmasterMsgVo);
    }

    @Override
    public void removeById(Long id) {
        contracmasterMsgDAO.removeById(id);
    }

    @Override
    public void update(ContracmasterMsgVo contracmasterMsgVo) {
        contracmasterMsgDAO.update(contracmasterMsgVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        contracmasterMsgDAO.updateStatus(statusQuery);
    }

    @Override
    public ContracmasterMsgVo getById(Long id) {
        return contracmasterMsgDAO.getById(id);
    }

    @Override
    public List<ContracmasterMsgVo> listAll() {
        return contracmasterMsgDAO.listAll();
    }

    @Override
    public List<ContracmasterMsgVo> listPage(PageQuery pageQuery) {
        return contracmasterMsgDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return contracmasterMsgDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      contracmasterMsgDAO.removeMany(id);
    }

    @Override
    public List<ContracmasterMsgVo> listPages(PageQuery pageQuery, ContracmasterMsgVo contracmasterMsgVo) {
        return contracmasterMsgDAO.listPages(pageQuery, contracmasterMsgVo);
    }

    @Override
    public long counts(PageQuery pageQuery, ContracmasterMsgVo contracmasterMsgVo) {
        return  contracmasterMsgDAO.counts(pageQuery, contracmasterMsgVo);
    }
}
