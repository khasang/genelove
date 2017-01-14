<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>message</td>





    </tr>
    <c:forEach items="${message}" var="message">
        <tr>

            <td>${message.text}</td>
            <td>${message.id}</td>
            <td>${message.date}</td>
            <td>${message.parentMessage}</td>
            <td>${message.conversation}</td>
            <td>${message.fromUser}</td>
            <td>${message.toUser}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>