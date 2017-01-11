<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of  Users</title>
</head>
<body>

<ul>
    <c:forEach var="user" items="${users}">
    <li>
            ${user.id}
            ${user.login}
                <ul>
                    <c:forEach var="role" items="${user.roles}">
                        <li>
                            ${role.roleName}
                        </li>
                    </c:forEach>
                </ul>
    </li>
    </c:forEach>
</ul>

</body>
</html>
