<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Genelove: Administration Screen</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Administration Screen</h3>
<c:url var="usersList" value="/admin/usersList"/>
<form:form action="${usersList}" method="get">
    Users List: 
    <button type="submit">Submit</button>
</form:form>
<c:url var="userId" value="/admin/user/id/"/>
<form:form action="${userId}" method="get">
    Search User By Id:
    <input type="text" name="id"/>
    <button type="submit">Submit</button>
</form:form>
<c:url var="userLogin" value="/admin/user/login/"/>
<form:form action="${userId}" method="get">
    Search User By Login:
    <input type="text" name="login"/>
    <button type="submit">Submit</button>
</form:form>
<c:url var="logout" value="/logout"/>
<form:form action="${logout}" method="get">
    Logout:
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
