<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Message by ID</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>${message.text}</h2>
<jsp:include page="footer.jsp"/>
</body>
</html>
