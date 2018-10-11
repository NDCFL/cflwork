package top.cflwork.dao;

import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.HouseOthersItemVo;
import top.cflwork.vo.Select2Vo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/12.
 */
@Repository
public interface HouseOthersItemDAO extends BaseDAO<HouseOthersItemVo> {
    List<Select2Vo> subjectList(Long companyId);
    List<HouseOthersItemVo> listPages(PageQuery pageQuery);
    Long counts(PageQuery pageQuery);
}
