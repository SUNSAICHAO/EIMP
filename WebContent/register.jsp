<%@ page import="com.ichao.entity.Employee" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  Empolyee: 本地账户
  Date: 2024/5/20
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-size: 100% 100%;
            background: papayawhip url("images/b4.jpg") no-repeat fixed;
        }

        .bigbox {
            width: 50%;
            margin-top: 10%;
            margin-left: 25%;
            height: 260px;
            overflow: hidden;
        }

        img {
            float: left;
            width: 60%;
            height: 260px;
        }

        form {
            padding-top: 1px;
            width: 40%;
            text-align: center;
            margin-left: 60%;
            margin-bottom: 0px;
            height: 260px;
            background-color: aquamarine;
        }

        form h1 {
            font-size: 20px;
            color: black;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
    </style>
    <script src="js/register.js"></script>
</head>
<body>
<%--接收从后端传递的消息，如果接收到success_msg,弹窗跳转登录页面，如果接收到err_msg,弹窗提示错误信息--%>
<%--<% String success_msg = (String) session.getAttribute("success_msg");
    if (success_msg != null) {
        out.println("<script> alert('注册成功，去登录');window.document.location.href='LoginServlet.jsp';</script>");
    }%>
<%String err_msg=(String) request.getAttribute("err_msg");
if (err_msg!=null){
    out.println("<script>alert('注册失败用户已存在')</script>");
}--%>
<%--
%>--%>
<div class="bigbox">
    <img src="images/a2.jpg" alt="">
    <form id="form" action="register" method="post" tabindex="-1" onsubmit="return checkForm()">
        <h1>注册</h1>
        <p>已有账号?<a href="login.jsp">登录</a></p>
        <h1>${requestScope.get("msg")}</h1>
        <input type="text" name="username" id="username" placeholder="用户名" onblur="checkUsername()"
               onfocus="clearUerr()">
        <%-- 用户名的错误提示信息，当输入框失去焦点时，调用函数判断，设置错误信息内容并把提示框显示出来--%>
        <%-- div的visibility属性能够盒子隐藏的时候占位置--%>
        <div id="username_err" class="err_msg">&nbsp;</div>
        <input type="text" name="password" id="password" placeholder="密码" onblur="checkPassword()"
               onfocus="clearPerr()">
        <%-- 密码的错误提示信息，当输入框失去焦点时，调用函数判断，设置错误信息并把提示框显示出来--%>
        <div id="password_err" class="err_msg">&nbsp;</div>
        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
