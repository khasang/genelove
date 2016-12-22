<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 22.12.16
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Encode page</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<div>
    <ul id="navMenu">
        <li><a href="">Main page</a></li>
        <li><a href="hello">Hello page</a></li>
        <li><a href="create">Create table <strong>films</strong></a></li>
        <li><a href="insert">Insert data into table <strong>films</strong></a></li>
        <li><a href="simpleSelect">Simple select from table <strong>films</strong></a></li>
        <li><a href="multipleSelect">Multiple select from table <strong>films</strong></a></li>
    </ul>
</div>

<div>
    <h2>Spring Security Page</h2>
    <p>Page: ${name}<br>Password: ${crypt}</p>
</div>
<div>
    <a href="http://localhost:8080/logout">Do you wish logOut this session ?</a>
</div>
</body>
</html>
