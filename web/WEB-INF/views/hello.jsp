<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--
<p>hello</p>
--%>
<blockquote>
    <p>${hello}</p>
</blockquote>
<jsp:include page="footer.jsp"/>
</body>
</html>