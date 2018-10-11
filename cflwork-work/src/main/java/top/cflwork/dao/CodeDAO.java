package top.cflwork.dao;

import org.springframework.stereotype.Repository;
import top.cflwork.vo.CodeVo;

@Repository
public interface CodeDAO extends BaseDAO<CodeVo> {
    Integer getCode(String phone);
    void updateCode(String phone);
    Integer codeCnt(String phone);
}
