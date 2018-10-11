package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.HouseOthersItemVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/12.
 */
public interface HouseOthersItemService extends BaseService<HouseOthersItemVo> {
    List<Select2Vo> subjectList(Long companyId);
    List<HouseOthersItemVo> listPages(PageQuery pageQuery);
    Long counts(PageQuery pageQuery);
}
