package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter  out = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        if (cookies!=null){
            out.print("本次访问的时间是:");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastLoginTime")) {
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date data = new Date(lastLoginTime);
                    out.print(data.toLocaleString());
                }

            }
        }else{
            out.print("这是第一此访问");
        }

        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);

        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
