<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Message by ID</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<tr>
    <td>ID</td>
    <td>message</td>
    <td>date</td>
</tr>

<tr>
<td>${message.id}</td>
<td>${message.text}</td>
<td>${message.date}</td>
</tr>

<jsp:include page="footer.jsp"/>
</body>
</html>
