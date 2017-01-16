<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>message</td>
        <td>date</td>
        <td>from</td>
    </tr>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.text}</td>
            <td>${message.date}</td>
            <td></td>
         </tr>
    </c:forEach>
</table>
</body>
</html>

