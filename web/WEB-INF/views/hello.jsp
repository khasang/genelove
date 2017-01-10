<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<ul class="navMenu">
    <li><a href="http://localhost:8080">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="db/create">Create table / Entry<strong>films</strong></a></li>
    <li><a href="insert">Insert data<strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select<strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
</ul>
<div id="container">
    <div id="left"><h2>LEFT MENU</h2><hr>
        <ul id="leftMenu">
            <li>Item 1</li>
            <li>Item 2</li>
            <li>Item 3</li>
            <li>Item 4</li>
        </ul>
        <hr>
        <p>Advertisment</p>

    </div>
    <div id="main">
        <h1>${hello}</h1>
        <hr>
        If you want get the access to security zone, please use 'db' as login & password:<br>
        <br>
        <strong>Login: </strong><cite>db</cite><br>
        <strong>Password: </strong><cite>db</cite>
        <hr>
        <p>This is a place for your text</p>
        <hr>
    </div></div>
<div id="footer"><h1>Footer</h1></div>
</body>
</html>
