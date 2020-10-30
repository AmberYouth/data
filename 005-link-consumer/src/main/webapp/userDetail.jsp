<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/10/11
  Time: 12:25
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
    <title>用户详情</title>
</head>
<body>
<h3>用户详情</h3>
<div>
    用户标识:${user.id}
</div>
<div>
    用户名称:${user.name}
</div>
<div>
    用户人数:${allStudentCount}
</div>
</body>
</html>
