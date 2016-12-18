<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<p>
<ul id="navMenu">
    <li><a href="">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="create">Create table <strong>films</strong></a></li>
    <li><a href="insert">Insert data into table <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select from table <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select from table <strong>films</strong></a></li>
</ul>
</p>
<h2>Create table Example</h2>
<p>Table creation status</p>
<p>${create}</p>
<p>
    <a href="http://localhost:8080/logout">Do you wish logOut this session ?</a>
</p>
</body>
</html>
