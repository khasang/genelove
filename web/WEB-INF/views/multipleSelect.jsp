<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiple Select Example</title>
    <link href="http://localhost:8080/style.css" rel="stylesheet">
</head>
<p>
<ul id="navMenu">
    <li><a href="">Main page</a></li>
    <li><a href="hello">Hello page</a></li>
    <li><a href="admin/create">Create table <strong>films</strong></a></li>
    <li><a href="insert">Insert data into table <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select from table <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select from table <strong>films</strong></a></li>
</ul>
</p>
<h2>Multiple Select Example</h2>
<p>
    <strong>Here is raw-list:</strong>  ${multipleSelect}
</p>
<hr>
<p>
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
</p>
</body>
</html>
