package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.ContractDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.ContractService;
import top.cflwork.vo.ContractVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/17.
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractDAO contractDAO;
    @Override
    public void save(ContractVo contractVo) {
        contractDAO.save(contractVo);
    }

    @Override
    public void remove(ContractVo contractVo) {
        contractDAO.remove(contractVo);
    }

    @Override
    public void removeById(Long id) {
        contractDAO.removeById(id);
    }

    @Override
    public void update(ContractVo contractVo) {
        contractDAO.update(contractVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        contractDAO.updateStatus(statusQuery);
    }

    @Override
    public ContractVo getById(Long id) {
        return contractDAO.getById(id);
    }

    @Override
    public List<ContractVo> listAll() {
        return contractDAO.listAll();
    }

    @Override
    public List<ContractVo> listPage(PageQuery pageQuery) {
        return contractDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return contractDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        contractDAO.removeMany(id);
    }

    @Override
    public List<ContractVo> listPages(PageQuery pageQuery, long companyId) {
        return contractDAO.listPages(pageQuery,companyId);
    }

    @Override
    public long counts(PageQuery pageQuery,long companyId) {
        return contractDAO.counts(pageQuery,companyId);
    }

    @Override
    public List<ContractVo> listPagesByMaster(PageQuery pageQuery, long companyId, long masterId) {
        return contractDAO.listPagesByMaster(pageQuery,companyId,masterId);
    }

    @Override
    public long countsByMaster(long companyId, long masterId) {
        return contractDAO.countsByMaster(companyId, masterId);
    }
}
