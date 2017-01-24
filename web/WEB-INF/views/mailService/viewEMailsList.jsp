<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <title>Mail Sender</title>
</head>
<body>
<jsp:include page="include/navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
        <span class="systemResponce">${message}</span></p>
</div>
<hr>
<div>
    <table class="tableData">
        <tr>
            <th>ID</th>
            <th>Recipient</th>
            <th>Sender</th>
            <th>Subject</th>
            <th>Date of creation</th>
            <th>Text</th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td>${eM.id}</td>
                <td>${email.re}</td>
                <td>${user.firstName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="include/footer.jsp"/>