<%@ page import="Bean.Product" %>
<%@ page import="Bean.Staff" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 本地账户
  Date: 2024/5/23
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    ArrayList<Staff>allStaff= (ArrayList<Staff>)session.getAttribute("allStaff");
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("UnLogin.jsp");
        return;
    }
%>

<table align="center" width="500">
    <tr>
        <td><a href="lookStaff">员工查询</a></td>
        <td><a href="addStaff.jsp">员工添加</a></td>
    </tr>
</table>
<table align="center" width="700" border="2">
    <tr>
        <th colspan="8">查询员工信息</th>
    </tr>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>学历</th>
        <th>部门</th>
        <th>入职时间</th>
        <th>职务</th>
        <th>工资</th>
    </tr>
    <%
        for (int i = 0; i <allStaff.size(); i++) {
            Staff staff=allStaff.get(i);
    %>
    <tr>
        <td><%= staff.getStaffName()%></td>
        <td><%=staff.getStaffSex()%></td>
        <td><%=staff.getStaffAge()%></td>
        <td><%=staff.getStaffEducation()%></td>
        <td><%=staff.getStaffDepartment()%></td>
        <td><%=staff.getStaffDate()%></td>
        <td><%=staff.getStaffDuty()%></td>
        <td><%=staff.getStaffWage()%></td>
    </tr>
    <% }%>
</table>
</body>
</html>
