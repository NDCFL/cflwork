package top.cflwork.service;

import top.cflwork.query.PageQuery;
import top.cflwork.vo.UserVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/3.
 */
public interface LandlordService extends BaseService<UserVo> {
    List<UserVo> listPages(PageQuery pageQuery);
    List<UserVo> listAlls(long companyId);
    void initPwd(String password, Long id);
}
