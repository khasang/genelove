<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Sender</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<head>
    <title>Mail Sender</title>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
        <span class="systemResponce">${message}</span></p>
</div>
<hr>
<div>
    <table class="usersList">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>E-Mail</th>
            <th>Send E-Mail</th>
            <th>Send Private Message</th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td><a href="sendMail?user=${user.id}">Send E-Mail</a></td>
                <td><a href="sendMail?user=${user.id}">Send Private message</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
