package top.cflwork.controller;


import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FilterController implements HandlerInterceptor {

    private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed", "1");
        String requestUri = request.getRequestURI();
        if (requestUri.startsWith(request.getContextPath())) {
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
        }
        //系统根目录
        if (StringUtils.equals("/", requestUri)) {
            return true;
        }
        //放行exceptUrls中配置的url
        for (String url : exceptUrls ) {
            if (url.endsWith("/**")) {
                if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
                    return true;
                }
            } else if (requestUri.startsWith(url)) {
                return true;
            }
        }
        UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
        //如果没有登录
        if (null == userVo) {
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect("/user/loginPage");
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

    }
}
