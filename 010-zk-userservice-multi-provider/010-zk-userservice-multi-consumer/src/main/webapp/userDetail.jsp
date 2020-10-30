<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/10/12
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<h3>用户1</h3>
<div>用户名：${user.name}</div>
<div>用户id:${user.id}</div>
<h3>用户2</h3>
<div>用户名：${user2.name}</div>
<div>用户id:${user2.id}</div>
</body>
</html>
