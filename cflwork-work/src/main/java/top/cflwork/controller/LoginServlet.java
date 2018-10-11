package top.cflwork.controller;

import top.cflwork.util.MsgInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenfeilong on 2018/3/18.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")

public class LoginServlet  extends HttpServlet {
    private static final long serialVersionUID = 8396947386749296795L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(MsgInfo.ACCESS_LOGIN_URL);
    }
}
