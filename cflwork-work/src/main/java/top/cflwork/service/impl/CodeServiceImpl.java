package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CodeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CodeService;
import top.cflwork.vo.CodeVo;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {
    private CodeDAO codeDAO;
    @Override
    public void save(CodeVo codeVo) {
        codeDAO.save(codeVo);
    }

    @Override
    public void remove(CodeVo codeVo) {
        codeDAO.remove(codeVo);
    }

    @Override
    public void removeById(Long id) {
        codeDAO.removeById(id);
    }

    @Override
    public void update(CodeVo codeVo) {
        codeDAO.update(codeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        codeDAO.updateStatus(statusQuery);
    }

    @Override
    public CodeVo getById(Long id) {
        return codeDAO.getById(id);
    }

    @Override
    public List<CodeVo> listAll() {
        return codeDAO.listAll();
    }

    @Override
    public List<CodeVo> listPage(PageQuery pageQuery) {
        return codeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return codeDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        codeDAO.removeMany(id);
    }

    @Override
    public Integer getCode(String phone) {
        return codeDAO.getCode(phone);
    }

    @Override
    public void updateCode(String phone) {
        codeDAO.updateCode(phone);
    }

    @Override
    public Integer codeCnt(String phone) {
        return codeDAO.codeCnt(phone);
    }
}
