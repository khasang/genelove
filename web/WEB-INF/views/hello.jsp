<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<p>hello</p>
<blockquote>
    <p>${hello}</p>
</blockquote>
<h2>${message}</h2>
<hr>
<ul>
    <li><a href="/sendEmail">Send simple e-mail by form (Denis Guzikov)</a></li>
    <li><a href="/sendEmailToUser">Send simple e-mail (Alexander Pyankov)</a></li>
    <li><a href="/sendEmailToSomeUsers">Send multiple e-mail (Alexander Pyankov)</a></li>
</ul>
<hr>
<jsp:include page="footer.jsp"/>
</body>
</html>
