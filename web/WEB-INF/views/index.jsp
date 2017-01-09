<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<ul class="navMenu">
    <li><a href="">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="db/create">Create table / Entry</a></li>
    <li><a href="insert">Insert data into <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select into <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
</ul>
<div>
<hr>
<h2>${index}</h2>
    If you want  get the access to security zone, please use 'db' as login & password:<br>
    <strong>Login: </strong><cite>db</cite><br>
    <strong>Password: </strong><cite>db</cite>
</div>
</body>
</html>
