package com.example.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如何让浏览器3秒刷新一次
        resp.setHeader("refresh","3");

        //创建图片
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

        // 得到图片
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);

        // 给图片写数据
        graphics.setColor(Color.blue);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNum(),0,20);

        // 使用图片格式打开
        resp.setContentType("image/jpeg");

        //网站不缓存
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");

        //图片返回浏览器
        // 图片返回浏览器
        try (OutputStream os = resp.getOutputStream()) {
            ImageIO.write(bufferedImage, "jpg", os);
        } catch (IOException e) {
            e.printStackTrace();
            // 可以在这里处理错误，例如设置错误响应状态码
        }


    }
    private  String makeNum(){
        Random random=new Random();
        String num=random.nextInt(9999999)+"";
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 7-num.length(); i++) {
            stringBuffer.append("0");
        }
        num = stringBuffer +num;
        return num;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
