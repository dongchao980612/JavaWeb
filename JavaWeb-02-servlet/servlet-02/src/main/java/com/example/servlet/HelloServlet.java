package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet...");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // this.getInitParameter(); //初始化参数
        // this.getServletConfig();// Servlet配置
        // this.getServletContext(); //Servlet上下文


        ServletContext context = this.getServletContext();
        String username="姓名";
        context.setAttribute("username",username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
