<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove Administration: User Overview</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <br><br>
        <h3>User ${user.login}</h3>
        <form:form action="" method="post" modelAttribute="user">
            <table>
                <tr>
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input class="form-control" path="id" value="${user.id}"/></td>
                </tr>

                <tr>
                    <td><form:label path="login">Login</form:label></td>
                    <td><form:input class="form-control" path="login" value="${user.login}"/></td>
                </tr>

                <tr>
                    <td><form:label path="firstName">First name</form:label></td>
                    <td><form:input class="form-control" path="firstName" value="${user.firstName}"/></td>
                </tr>

                <tr>
                    <td><form:label path="lastName">Last name</form:label></td>
                    <td><form:input class="form-control" path="lastName" value="${user.lastName}"/></td>
                </tr>

                <tr>
                    <td><form:label path="email">e-mail</form:label></td>
                    <td><form:input class="form-control" path="email" value="${user.email}"/></td>
                </tr>

                <tr>
                    <td><form:label path="gender">Gender</form:label></td>
                    <td><form:input class="form-control" path="gender" value="${user.gender}"/></td>
                </tr>

                <tr>
                    <td><form:label path="roles">Roles</form:label></td>
                    <td>
                        <c:forEach var="role" items="${user.roles}">
                            <form:input class="form-control" path="roles" value="${role.roleName}"/>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            <br>
            <input class="btn btn-success" type="submit" value="Submit"/>
        </form:form>
    </div>
</body>
</html>
