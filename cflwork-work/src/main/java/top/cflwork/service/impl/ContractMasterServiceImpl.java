package top.cflwork.service.impl;

import org.springframework.stereotype.Service;
import top.cflwork.dao.ContractMasterDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.ContractMasterService;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/16.
 */
@Service
public class ContractMasterServiceImpl implements ContractMasterService {
    @Resource
    private ContractMasterDAO contractMasterDAO;
    @Override
    public void save(ContractMasterVo contractMasterVo) {
        contractMasterDAO.save(contractMasterVo);
    }

    @Override
    public void remove(ContractMasterVo contractMasterVo) {
        contractMasterDAO.remove(contractMasterVo);
    }

    @Override
    public void removeById(Long id) {
        contractMasterDAO.removeById(id);
    }

    @Override
    public void update(ContractMasterVo contractMasterVo) {
        contractMasterDAO.update(contractMasterVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        contractMasterDAO.updateStatus(statusQuery);
    }

    @Override
    public ContractMasterVo getById(Long id) {
        return contractMasterDAO.getById(id);
    }

    @Override
    public List<ContractMasterVo> listAll() {
        return contractMasterDAO.listAll();
    }

    @Override
    public List<ContractMasterVo> listPage(PageQuery pageQuery) {
        return contractMasterDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return contractMasterDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
        contractMasterDAO.removeMany(id);
    }

    @Override
    public List<ContractMasterVo> listPages(PageQuery pageQuery, long companyId) {
        return contractMasterDAO.listPages(pageQuery,companyId);
    }

    @Override
    public long counts(long companyId,PageQuery pageQuery) {
        return contractMasterDAO.counts(companyId,pageQuery);
    }

    @Override
    public List<Select2Vo> listAlls(long companyId) {
        return contractMasterDAO.listAlls(companyId);
    }

    @Override
    public ContractMasterVo findContractMaster(ContractMasterVo contractMasterVo) {
        return contractMasterDAO.findContractMaster(contractMasterVo);
    }

    @Override
    public TodayPayVo getPayInfo(Long id,String time,Long hotelId) {
        return contractMasterDAO.getPayInfo(id,time,hotelId);
    }

    @Override
    public int checkPhone(String phone) {
        return contractMasterDAO.checkPhone(phone);
    }

    @Override
    public List<Select2Vo> getHotelList(Long id) {
        return contractMasterDAO.getHotelList(id);
    }

    @Override
    public ContractHouseListVo getHotelInfo(StatusQuery statusQuery) {
        return contractMasterDAO.getHotelInfo(statusQuery);
    }

    @Override
    public List<HouseVo> getHouseList(StatusQuery statusQuery) {
        return contractMasterDAO.getHouseList(statusQuery);
    }

    @Override
    public List<RentPayVo> getRentPayList(Long id) {
        return contractMasterDAO.getRentPayList(id);
    }

    @Override
    public Long checkPhones(ContractMasterVo contractMasterVo) {
        return contractMasterDAO.checkPhones(contractMasterVo);
    }

}
