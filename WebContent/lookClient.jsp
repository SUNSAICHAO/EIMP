<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ichao.entity.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  Bean.Empolyee: 本地账户
  Date: 2024/5/19
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用户信息</title>
    <style>
        body {
            background-color: #cccccc;
            font-family: Arial, sans-serif;
        }

        table {
            background-color: antiquewhite;
            width: 700px;
            border-spacing: 10px;
            border: 1px solid;
            margin: 0 auto 10px 26%;
            text-align: center;
        }

        tr td {
            padding: 10px;
        }

        th {
            background-color: #f8f9fa;
            padding: 10px;
        }

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
<header>欢迎使用企业信息管理平台</header>
<aside>
    <div></div>
    <ul>
        <li><a href="client">客户管理</a></li>
        <li><a href="contact">合同管理</a></li>
        <li><a href="clientService">售后管理</a></li>
        <li><a href="product">产品管理</a></li>
        <li><a href="employee">员工管理</a></li>
        <li><a href="exit">退出系统</a></li>
    </ul>
</aside>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("unLogin.jsp");
        return;
    }
%>

<table align="center" width="500">
    <tr>
        <td><a href="client">客户查询</a></td>
        <td><a href="addClient.jsp">客户添加</a></td>
        <td><a href="updateClient.jsp">客户修改</a></td>
        <td><a href="deleteClient.jsp">客户删除</a></td>
    </tr>
</table>
<table align="center" width="700" border="2">
    <tr>
        <th colspan="4">查看客户信息</th>
    </tr>
    <tr>
        <th>姓名</th>
        <th>电话</th>
        <th>地址</th>
        <th>邮箱</th>
    </tr>
    <c:forEach var="client" items="${requestScope.get('clientList')}">
        <tr>
            <td>${client.name}</td>
            <td>${client.phone}</td>
            <td>${client.address}</td>
            <td>${client.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>