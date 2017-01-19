<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<ul>
    <li><a href="/sendMail">Mail Sender</a></li>
</ul>
<hr>
<div class="systemErrorMessage">
    <p>Your Mail was <strong>NOT</strong> successfully delivered to Recipient(s) by reason:<br>
    ${errorMessage}</p>
</div>
</body>
</html>
