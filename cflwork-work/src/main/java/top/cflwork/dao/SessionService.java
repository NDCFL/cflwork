package top.cflwork.dao;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import top.cflwork.vo.UserOnlineVo;

import java.util.Collection;
import java.util.List;

@Service
public interface SessionService{
	List<UserOnlineVo> list();

	List<UserOnlineVo> listOnlineUser();

	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}
