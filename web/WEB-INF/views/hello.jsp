<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<div>
<ul id="navMenu">
    <li><a href="">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="db/create">Create table <strong>films</strong></a></li>
    <li><a href="insert">Insert data into table <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select from table <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select from table <strong>films</strong></a></li>
</ul>
<hr>
<h2>${hello}</h2>
    If you want  get the access to security zone, please use 'db' as login & password:<br>
    <strong>Login: </strong><cite>db</cite><br>
    <strong>Password: </strong><cite>db</cite>
</div>

</body>
</html>
