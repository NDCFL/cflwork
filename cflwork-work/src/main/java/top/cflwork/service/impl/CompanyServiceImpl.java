package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.CompanyDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.CompanyService;
import top.cflwork.vo.CompanyVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/15.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    protected CompanyDAO companyDAO;
    @Override
    public void save(CompanyVo companyVo) {
        companyDAO.save(companyVo);
    }

    @Override
    public void remove(CompanyVo companyVo) {
        companyDAO.remove(companyVo);
    }

    @Override
    public void removeById(Long id) {
        companyDAO.removeById(id);
    }

    @Override
    public void update(CompanyVo companyVo) {
        companyDAO.update(companyVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        companyDAO.updateStatus(statusQuery);
    }

    @Override
    public CompanyVo getById(Long id) {
        return companyDAO.getById(id);
    }

    @Override
    public List<CompanyVo> listAll() {
        return companyDAO.listAll();
    }

    @Override
    public List<CompanyVo> listPage(PageQuery pageQuery) {
        return companyDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return companyDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        companyDAO.removeMany(id);
    }

    @Override
    public int checkName(String name,long id) {
        return companyDAO.checkName(name,id);
    }
}
