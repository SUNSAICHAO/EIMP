<%@ page import="Bean.Contact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.Cs" %><%--
  Created by IntelliJ IDEA.
  User: 本地账户
  Date: 2024/5/23
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        body {
            background-color: #cccccc;
            font-family: Arial, sans-serif;
        }

        table {
            background-color: antiquewhite;
            width: 700px;
            margin: 0 auto;
            margin-left: 26%;
            border-spacing: 10px;
            border: 1px solid;
            margin-bottom:10px;
            text-align:center;
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
            margin-left:10%;
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
        aside div{
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
        <li><a href="lookClient">客户管理</a></li>
        <li><a href="lookContact">合同管理</a></li>
        <li><a href="lookCs">售后管理</a></li>
        <li><a href="lookProduct">产品管理</a></li>
        <li><a href="lookStaff">员工管理</a></li>
        <li><a href="exit">退出系统</a></li>
    </ul>
</aside>
<%
    ArrayList<Cs>allCs= (ArrayList< Cs >)session.getAttribute("allCs");
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("UnLogin.jsp");
        return;
    }
%>
<table align="center" width="500">
    <tr>
        <td><a href="lookCs">售后查询</a></td>
        <td><a href="addCs.jsp">售后添加</a></td>
    </tr>
</table>

<table align="center" width="700" border="2">
    <tr>
        <th colspan="3">查售后信息</th>
    </tr>
    <tr>
        <th>客户姓名</th>
        <th>客户反馈意见</th>
        <th>业务员</th>
    </tr>
    <%
        for (int i = 0; i <allCs.size(); i++) {
            Cs cs=allCs.get(i);
    %>
    <tr>
        <td><%=cs.getClientName()%></td>
        <td><%=cs.getClientOpinion()%></td>
        <td><%=cs.getStaffName()%></td>
    </tr>
    <% }%>
</table>
</body>
</html>
