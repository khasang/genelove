<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Select</title>
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
<hr>
    <h2>Simple Select Example</h2>
    ${simpleSelect}
<hr>
    <a href="http://localhost:8080/logout">Do you wish logOut this session ?</a>
</div>
</body>
</html>
