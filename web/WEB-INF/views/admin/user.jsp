<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Genelove: User Overview</title>
</head>

<body>

<h2>User ${user.login}</h2>
    <form:form action="" method="post" modelAttribute="user">
        <table>
            <tr>
                <td><form:label path="id">ID</form:label></td>
                <td><form:input path="id" value="${user.id}"/></td>
            </tr>

            <tr>
                <td><form:label path="login">Login</form:label></td>
                <td><form:input path="login" value="${user.login}"/></td>
            </tr>

            <tr>
                <td><form:label path="firstName">First name</form:label></td>
                <td><form:input path="firstName" value="${user.firstName}"/></td>
            </tr>

            <tr>
                <td><form:label path="lastName">Last name</form:label></td>
                <td><form:input path="lastName" value="${user.lastName}"/></td>
            </tr>

            <tr>
                <td><form:label path="roles">Roles</form:label></td>
                <td>
                    <c:forEach var="role" items="${user.roles}">
                        <form:input path="roles" value="${role.roleName}"/><br>
                    </c:forEach>
                </td>
            </tr>

        </table>
        <br>
        <input type="submit" value="Submit"/>

    </form:form>

</body>
</html>
