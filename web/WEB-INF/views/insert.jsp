<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<div id="header"><h1><span id="gene">GENE</span><span id="love">LOVE</span></h1>
<ul class="navMenu">
    <li><a href="/">Main page</a></li>
    <li><a href="/db/create">Create table / Entry</a></li>
    <li><a href="/db/insert" id="activeMenu">Insert data into <strong>films</strong></a></li>
    <li><a href="/db/simpleSelect">Simple select into <strong>films</strong></a></li>
    <li><a href="/db/multipleSelect">Multiple select into <strong>films</strong></a></li>
    <li><a href="/logout">Log Out <strong>${name}</strong></a></li>
</ul></div>
<div id="container">
    <div id="left"><h2>LEFT MENU</h2><hr>
        <ul class="leftMenu">
            <li><a href="/db/allQuestion">All Question</a></li>
            <li><a href="/db/getQuestionById/1">Get Question by Id #1</a></li>
            <li><a href="/db/deleteQuestionById/2">Get Question by Id #2</a></li>
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
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
