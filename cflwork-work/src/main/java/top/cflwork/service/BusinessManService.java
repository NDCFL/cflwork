package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.BusinessManVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

public interface BusinessManService extends BaseService<BusinessManVo>{
    List<Select2Vo> businessManList();
    void updateType(StatusQuery statusQuery);
    List<BusinessManVo> findBusinessManList(PageQuery pageQuery, BusinessManVo businessManVo);
    long findBusinessByCount(PageQuery pageQuery, BusinessManVo businessManVo);
    BusinessManVo getByAccountPassword(String phone, String password);
    Integer checkPhone(String phone);
    void updatePwd(String phone, String password);
    void updateFaceImg(Long id, String url);
    BusinessManVo findByOpenId(String openId);
    List<BusinessManVo> getBusinessManList(BusinessManVo businessManVo);
    Integer checkName(BusinessManVo businessManVo);
    Integer checkPhones(BusinessManVo businessManVo);
}
