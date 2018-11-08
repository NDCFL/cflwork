package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.BusinessManVo;
import top.cflwork.vo.ContractMasterVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/16.
 */
public interface ContractMasterService extends BaseService<ContractMasterVo> {
    List<ContractMasterVo> listPages(PageQuery pageQuery, long companyId);
    long counts(long companyId, PageQuery pageQuery);
    List<Select2Vo> listAlls(long companyId);
    int checkPhone(String phone);
    ContractMasterVo getInfo(String phone);
    void updatePwd(String phone, String password);
    ContractMasterVo findByOpenId(String openId);
}
