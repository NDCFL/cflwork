package top.cflwork.service;

import top.cflwork.vo.CodeVo;

public interface CodeService extends BaseService<CodeVo> {

    Integer getCode(String phone);
    void updateCode(String phone);
    Integer codeCnt(String phone);
}
