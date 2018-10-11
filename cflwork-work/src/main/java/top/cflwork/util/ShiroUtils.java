package top.cflwork.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import top.cflwork.vo.UserVo;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static UserVo getUser() {
        Object object = SecurityUtils.getSubject().getSession().getAttribute("userVo");
        return (UserVo)object;
    }
    public static Long getUserId() {
        return getUser().getId();
    }
    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
    public static Collection<Session> getSessions() {
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return sessions;
    }
}
