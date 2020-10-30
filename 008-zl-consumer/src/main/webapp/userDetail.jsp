<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/10/11
  Time: 17:15
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
    <title>UserDetail的yemian</title>
</head>
<body>
    用户名字:${user.name}
    用户id:${user.id}
</body>
</html>
