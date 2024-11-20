<%@ page import="Bean.User" %>
<%@ page import="javax.script.ScriptContext" %>
<%@ page import="com.sun.net.httpserver.Request" %>
<%@ page import="java.awt.font.ImageGraphicAttribute" %><%--
  Created by IntelliJ IDEA.
  Bean.User: 本地账户
  Date: 2024/5/19
  Time: 17:47
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
            text-align: center;
            margin-left: 60%;
            padding-top: 20px;
            height: 260px;
            background-color: aquamarine;
        }

        form h1 {
            margin-top: 0px;
            font-size: 20px;
            color: black;
        }
    </style>
</head>
<body>
<div class="bigbox">
    <img src="images/a2.jpg">
    <form action="login" method="post">
        <h1>登录</h1>
        <h1>
            <% String msg = (String) request.getAttribute("msg");
                if (msg != null)
                    out.println("<h1>" + msg + "<h1>");
            %>
            <%
                User newUser = (User) session.getAttribute("newUser");
                if (newUser == null) {
                    newUser = new User("", "");
                }
                String username = newUser.getUsername();
                String password = newUser.getPassword();
            %>
        </h1>
        <h1>还没账号，<a href="register.jsp">去注册</a></h1>
        <input type="text" placeholder="用户名" name="username" id="username" value=<%=username%>><br><br>
        <input type="text" placeholder="密码" name="password" id="password" value=<%=password%>><br><br>
        <%session.invalidate();%>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>