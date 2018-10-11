package top.cflwork.service;


import top.cflwork.query.StatusQuery;
import top.cflwork.vo.Verifcode;

public interface VerifcodeService extends BaseService<Verifcode>{
    String queryByCode(String mobile);
    void updateCodeStatus(StatusQuery statusQuery);
    Verifcode getVerifcode(String mobile);
    Integer cnt(String mobile);
}
