package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.VerifcodeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.VerifcodeService;
import top.cflwork.vo.Verifcode;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VerifcodeServiceImpl implements VerifcodeService {
    @Resource
    private VerifcodeDAO verifcodeDAO;

    @Override
    public String queryByCode(String mobile) {
        return verifcodeDAO.queryByCode(mobile);
    }

    @Override
    public void updateCodeStatus(StatusQuery statusQuery) {
        verifcodeDAO.updateCodeStatus(statusQuery);
    }

    @Override
    public Verifcode getVerifcode(String mobile) {
        return verifcodeDAO.getVerifcode(mobile);
    }

    @Override
    public Integer cnt(String mobile) {
        return verifcodeDAO.cnt(mobile);
    }

    @Override
    public void save(Verifcode verifcode) {
        verifcodeDAO.save(verifcode);
    }

    @Override
    public void remove(Verifcode verifcode) {
        verifcodeDAO.remove(verifcode);
    }

    @Override
    public void removeById(Long id) {
        verifcodeDAO.removeById(id);
    }

    @Override
    public void update(Verifcode verifcode) {
        verifcodeDAO.update(verifcode);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        verifcodeDAO.updateStatus(statusQuery);
    }

    @Override
    public Verifcode getById(Long id) {
        return verifcodeDAO.getById(id);
    }

    @Override
    public List<Verifcode> listAll() {
        return verifcodeDAO.listAll();
    }

    @Override
    public List<Verifcode> listPage(PageQuery pageQuery) {
        return verifcodeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return verifcodeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        verifcodeDAO.removeMany(id);
    }
}
