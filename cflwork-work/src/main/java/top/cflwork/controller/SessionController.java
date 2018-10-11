package top.cflwork.controller;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.cflwork.util.R;
import top.cflwork.util.ShiroUtils;
import top.cflwork.vo.UserOnlineVo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequestMapping("online")
@Controller
public class SessionController {
	@RequestMapping("onlinePage")
	public String online() {
		return "/online/online";
	}
	@ResponseBody
	@RequestMapping("/list")
	public List<UserOnlineVo> list() {
		List<UserOnlineVo> list = new ArrayList<>();
		Collection<Session> sessions = ShiroUtils.getSessions();
		System.out.println(sessions+"==============");
		for (Session session : sessions) {
			UserOnlineVo userOnline = new UserOnlineVo();
			if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
				continue;
			} else {
				SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) session
						.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
				UserOnlineVo userDO = (UserOnlineVo) principalCollection.getPrimaryPrincipal();
				userOnline.setUsername(userDO.getUsername());
			}
			userOnline.setId((String) session.getId());
			userOnline.setHost(session.getHost());
			userOnline.setStartTimestamp(session.getStartTimestamp());
			userOnline.setLastAccessTime(session.getLastAccessTime());
			userOnline.setTimeout(session.getTimeout());
			list.add(userOnline);
		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/forceLogout/{sessionId}")
	public R forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
		try {
//			Session session = sessionDAO.readSession(sessionId);
//			session.setTimeout(0);
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}

	}



}
