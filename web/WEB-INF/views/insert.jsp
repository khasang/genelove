<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<ul class="navMenu">
    <li><a href="http://localhost:8080">Main page</a></li>
    <li><a href="create">Create table / Entry</a></li>
    <li><a href="insert">Insert data into <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select into <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
    <li><a href="http://localhost:8080/logout">Log Out <strong>${name}</strong></a></li>
</ul>
<div id="container">
    <div id="left"><h2>LEFT MENU</h2><hr>
        <ul class="leftMenu">
            <li><a href="/db/allQuestion">All Question</a></li>
            <li><a href="/">Main</a></li>
            <li><a href="/">Main</a></li>
            <li><a href="/">Main</a></li>
        </ul>
        <hr>
        <p>Advertisment</p>

    </div>
    <div id="main">
        <h1>Insert Example</h1>
        <hr>
        <p>Insert into table <strong>films</strong></p>
        <hr>
    </div></div>
<div id="footer"><h1>Footer</h1></div>
</body>
</html>
