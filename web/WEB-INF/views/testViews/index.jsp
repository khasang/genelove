
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>create users : ${sqlResultInsertUsers}</h3>
<a href="${pageContext.request.contextPath}adm-sql">Admin page</a><p style="color: red">LOGIN : admin,PASSWORD : admin</p>

<a href="${pageContext.request.contextPath}mng-lemberg">Manager page</a><p style="color: red">LOGIN : manager,PASSWORD : manager</p>
</body>
</html>
