
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>
<ul>
    <li><a href="/sendEmail">Send simple e-mail by form (Denis Guzikov)</a></li>
    <li><a href="/sendEmailToUser">Send simple e-mail (Alexander Pyankov)</a></li>
    <li><a href="/sendEmailToSomeUsers">Send multiple e-mail (Alexander Pyankov)</a></li>
</ul>
<hr>
<h1>Sending e-mail with Spring MVC to User</h1>
<form method="post" action="sendEmailToUser">
    <input type="submit" value="Send E-mail" />
</form>
</body>
</html>
