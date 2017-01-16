<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<div id="header"><h1><span id="gene">GENE</span><span id="love">LOVE</span></h1>
    <ul class="navMenu">
        <li><a href="/">Main page</a></li>
        <li><a href="create">Create table / Entry</a></li>
        <li><a href="insert">Insert data into <strong>films</strong></a></li>
        <li><a href="simpleSelect" id="activeMenu">Simple select into <strong>films</strong></a></li>
        <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
        <li><a href="/logout">Log Out</a></li>
    </ul></div>
<div id="container">
    <div id="left"><h2>LEFT MENU</h2><hr>
        <ul class="leftMenu">
            <li><a href="/">Main</a></li>
            <li><a href="/db/allQuestion">All Question</a></li>
            <li><a href="/account/info" class="active">User Info</a></li>
            <li><a href="/">Main</a></li>
            <li><a href="/">Main</a></li>
        </ul>
        <hr>
        <p>Advertisment</p>

    </div>
    <div id="main">
        <h1>User Info</h1>
        <hr>
        <p>${userInfo}</p>
        <hr>
    </div></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
