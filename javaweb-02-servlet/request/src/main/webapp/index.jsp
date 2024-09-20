<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>登录</title>
    </head>

    <body>
        <div style="text-align: center">
            <form action="/login" method="post">
                用户名:<input type="text" name="username" placeholder="请输入用户名"><br>
                密码:<input type="password" name="password" placeholder="请输入密码"><br>
                身份：
                <input type="checkbox" name="hobby" value="学生">学生
                <input type="checkbox" name="hobby" value="教师">教师
                <input type="checkbox" name="hobby" value="管理员">管理员
                <input type="checkbox" name="hobby" value="开发者">开发者
                <br>
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </form>
        </div>
    </body>

    </html>