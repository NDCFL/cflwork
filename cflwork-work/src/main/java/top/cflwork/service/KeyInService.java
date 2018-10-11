package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.UserVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
public interface KeyInService extends BaseService<UserVo>{
    long counts(PageQuery pageQuery);
    void initPwd(String password, Long id);
    List<UserVo> listPages(PageQuery pageQuery);

}
