<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiple Select Example</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<ul class="navMenu">
    <li><a href="">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="create">Create table / Entry</a></li>
    <li><a href="insert">Insert data into <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select into <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
    <li><a href="http://localhost:8080/logout">Log Out</a></li>
</ul>
<div>
<hr>
<h2>Multiple Select Example</h2>
    <strong>Here is raw-list:</strong>  ${multipleSelect}


    <table border="1">
    <tr>
        <th>Code</th>
        <th>Title</th>
        <th>Date</th>
    </tr>
    <c:forEach items = "${multipleSelect}" var = "films">
        <tr>
            <td><c:out value="${films.code}"/></td>
            <td><c:out value="${films.title}"/></td>
            <td><c:out value="${films.date_prod}"/></td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
