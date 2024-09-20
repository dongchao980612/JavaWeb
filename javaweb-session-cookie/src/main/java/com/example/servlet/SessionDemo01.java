package com.example.servlet;

import com.example.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        session.setAttribute("name",new Person("姓名",26));
        String id = session.getId();

        if(session.isNew()){
            resp.getWriter().print("session创建成功，id = "+id);
        }else{
            resp.getWriter().print("session已经存在了,id = "+id);
        }

//        Cookie cookie = new Cookie("JSESSIONID", id);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
