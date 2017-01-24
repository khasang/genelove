<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove Administration: User Data Update</title>
</head>
<body>
    <jsp:include page="include/header.jsp"/>
    <div class="container">
        <br><br><br><br>
        <jsp:include page="include/greeting.jsp"/>
        <h3>User ${user.login}</h3>
        Your data updated
    </div>
</body>
</html>
