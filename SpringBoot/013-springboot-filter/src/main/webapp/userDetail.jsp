<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/10/28
  Time: 15:49
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
<h3>用户id:${id}</h3>
<h3>用户名字:${username}</h3>
</body>
</html>
