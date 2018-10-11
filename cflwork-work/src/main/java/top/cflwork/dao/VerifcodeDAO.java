package top.cflwork.dao;


import org.springframework.stereotype.Repository;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.Verifcode;

/**
 * Created by aQiu.
 */
@Repository
public interface VerifcodeDAO extends  BaseDAO<Verifcode> {
    String queryByCode(String mobile);
    void updateCodeStatus(StatusQuery statusQuery);
    Verifcode getVerifcode(String mobile);
    Integer cnt(String mobile);
}
