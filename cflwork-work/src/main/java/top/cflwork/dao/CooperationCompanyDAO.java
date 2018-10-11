package top.cflwork.dao;

import org.springframework.stereotype.Repository;
import top.cflwork.query.PageQuery;
import top.cflwork.vo.CooperationCompanyVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/12/6.
 */
@Repository
public interface CooperationCompanyDAO extends BaseDAO<CooperationCompanyVo>{
    List<CooperationCompanyVo> listPages(PageQuery pageQuery);
    Long counts(PageQuery pageQuery);
}
