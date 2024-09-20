package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response-FileServlet");

        // 1、获取下载文件的饿位置
        // String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/cloud.png");
        String realPath = "C:\\Users\\dongchao\\Desktop\\JavaWeb\\javaweb-02-servlet\\response\\target\\classes\\cloud.png";
        System.out.println("下载文件的路径是："+realPath);

        // 2、下载文件名字
        String fileName = realPath.substring(realPath.lastIndexOf('\\')+1);

        // 3、设置浏览器支持下载
        resp.setHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));

        // 4、获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);

        // 5、创建缓存区
        int len=0;
        byte[] buffer = new byte[1024];

        // 6、获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();

        // 7、将FileOutStream写入buffer缓存区，使用OutputStream将缓存区中的数据输入出到客户端
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);

        }

        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
