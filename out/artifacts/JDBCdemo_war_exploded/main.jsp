<%--
  Created by IntelliJ IDEA.
  User: 本地账户
  Date: 2024/5/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        header {
            text-align: center;
            margin-left: 10%;
            margin-top: -5px;
            background-color: #e9ecef;
            height: 60px;
            line-height: 60px;
            font-size: 25px;
        }

        aside {
            position: fixed;
            width: 11%;
            height: 100%;
            top: 0;
            left: 0;
            background-color: #dee2e6;
        }

        aside div {
            height: 55%;
        }

        aside ul {
            list-style-type: none;
        }

        aside ul li {
            padding: 8px 0;
        }

        aside ul li a {
            text-decoration: none;
            color: #333;
        }
    </style>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("UnLogin.jsp");
        return;
    }
%>

<header>欢迎使用企业信息管理平台</header>
<aside>
    <div></div>
    <ul>
        <li><a href="lookClient">客户管理</a></li>
        <li><a href="lookContact">合同管理</a></li>
        <li><a href="lookCs">售后管理</a></li>
        <li><a href="lookProduct">产品管理</a></li>
        <li><a href="lookStaff">员工管理</a></li>
        <li><a href="exit">退出系统</a></li>
    </ul>
</aside>
</body>
</html>
