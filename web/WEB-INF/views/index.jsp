<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<div id="header"><h1><span id="gene">GENE</span><span id="love">LOVE</span></h1>
<ul class="navMenu">
    <li><a href="/" id="activeMenu">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="db/create">Create table / Entry</a></li>
    <li><a href="db/insert">Insert data into <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select into <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
</ul></div>
<div id="left"><h2>LEFT MENU</h2><hr>
    <ul class="leftMenu">
        <li><a href="/" class="active">Main</a></li>
        <li><a href="/">Main</a></li>
        <li><a href="/">Main</a></li>
    </ul>
    <hr>
    <p>Advertisment</p>

</div>
<div id="main">
<h1>${index}</h1>
    <hr>
    If you want get the access to security zone, please use 'db' as login & password:<br>
<br>
    <strong>Login: </strong><cite>db</cite><br>
    <strong>Password: </strong><cite>db</cite>
    <hr>
    <p>This is a place for your text</p>
    <hr>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
