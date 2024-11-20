<%--
  Created by IntelliJ IDEA.
  Bean.User: 本地账户
  Date: 2024/5/19
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String username=(String) session.getAttribute("username");
if (username==null)
    response.sendRedirect("UnLogin.jsp");
%>
<h1>管理员"+username+"登陆成功,点击<a href=lookClient>管理用户信息</a></h1>
</body>
</html>
