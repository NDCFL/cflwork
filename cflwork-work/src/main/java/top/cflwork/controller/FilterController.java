package top.cflwork.controller;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterController implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed", "1");
        Object user = request.getSession().getAttribute("userVo");
        String path = request.getRequestURL().toString();
        if (user == null) {
            if(path.contains("/index") ||
                    path.contains("user/loginPage") ||
                    path.contains("user/getInfo") ||
                    path.contains("static") ||
                    path.contains("captcha") ||
                    path.contains("/logins") ||
                    path.contains("house/contract")||
                    path.contains("contractMaster") ||
                    path.contains("file")||
                    path.contains("upload")){
                return true;
            }
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect("/user/loginPage");
            return false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Object user = request.getSession().getAttribute("userVo");
        String path = request.getRequestURL().toString();
        if (user == null) {
            if(path.contains("/index") ||
                    path.contains("user/loginPage") ||
                    path.contains("user/getInfo") ||
                    path.contains("static") ||
                    path.contains("captcha") ||
                    path.contains("/logins") ||
                    path.contains("house/contract")||
                    path.contains("contractMaster") ||
                    path.contains("file")||
                    path.contains("upload")){

            }else{
                System.out.println("尚未登录，调到登录页面");
                request.getRequestDispatcher("/user/loginPage").forward(request,response);
            }
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        Object user = request.getSession().getAttribute("userVo");
        String path = request.getRequestURL().toString();
        if (user == null) {
            if(
                    path.contains("/index") ||
                    path.contains("user/loginPage") ||
                    path.contains("user/getInfo") ||
                    path.contains("static") ||
                    path.contains("captcha") ||
                    path.contains("/logins") ||
                    path.contains("house/contract")||
                    path.contains("contractMaster") ||
                    path.contains("file")||
                    path.contains("upload")){

            }else{
                System.out.println("尚未登录，调到登录页面");
                request.getRequestDispatcher("/user/loginPage").forward(request,response);
            }
        }
    }
}
