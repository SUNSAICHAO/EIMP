<%@ page import="com.ichao.entity.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  Empolyee: 本地账户
  Date: 2024/5/23
  Time: 18:12
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
            border-spacing: 10px;
            border: 1px solid;
            margin: 0 auto 10px 26%;
            text-align: center;
        }

        tr td {
            padding: 10px;
        }

        form {
            align-items: center;
            text-align: center;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        form {
            align-items: center;
            margin-bottom: 10px;
        }

        form label {
            width: 150px;
            display: inline-block;
            text-align: right;
            margin-right: 10px;
        }

        form input[type="text"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ced4da;
            border-radius: 3px;
        }

        form input[type="submit"],
        form input[type="reset"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        form input[type="submit"]:hover,
        form input[type="reset"]:hover {
            background-color: #0056b3;
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
        <li><a href="client">客户管理</a></li>
        <li><a href="contact">合同管理</a></li>
        <li><a href="clientService">售后管理</a></li>
        <li><a href="product">产品管理</a></li>
        <li><a href="employee">员工管理</a></li>
        <li><a href="exit">退出系统</a></li>
    </ul>
</aside>

<table align="center" width="500">
    <tr>
        <td><a href="product">产品查询</a></td>
        <td><a href="addProduct.jsp">产品添加</a></td>
    </tr>
</table>
<form action="product" method="post">
    <h1>${requestScope.get("msg")}</h1>
    <h1>添加产品信息</h1>
    <label>产品名称</label><input type="text" name="name"><br>
    <label>产品型号</label><input type="text" name="model"><br>
    <label>产品数量</label><input type="text" name="number"><br>
    <label>产品价格</label><input type="text"name="price"><br>
    <input type="submit" value="确认">
    <input type="reset" value="取消">
</form>
</body>
</html>