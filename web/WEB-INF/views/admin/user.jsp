<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Genelove: User Overview</title>
</head>

<body>

    <h2>User ${user.login}</h2>
    <c:url var="addUser" value="/admin/user/add"/>
    <form:form action="${addUser}" method="post" modelAttribute="user">
        <table>
            <%--<tr>
                <td><form:label path="id">ID</form:label></td>
                <td><form:input path="id" value="${user.id}"/></td>
            </tr>--%>

            <tr>
                <td><form:label path="login">Login</form:label></td>
                <td><form:input placeholder="Login" path="login" value="${user.login}"/></td>
            </tr>

            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:password placeholder="Password" path="password" value="${user.password}"/></td>
            </tr>

            <tr>
                <td><form:label path="firstName">First name</form:label></td>
                <td><form:input placeholder="First name" path="firstName" value="${user.firstName}"/></td>
            </tr>

            <tr>
                <td><form:label path="lastName">Last name</form:label></td>
                <td><form:input placeholder="Last name" path="lastName" value="${user.lastName}"/></td>
            </tr>

            <tr>
                <td><form:label path="lastName">E-Mail address</form:label></td>
                <td><form:input placeholder="E-Mail address" path="email" value="${user.email}"/></td>
            </tr>

            <tr>
                <td><form:label path="accountStatus">Account status</form:label></td>
                <td>
                   <form:select multiple="false" path="accountStatus">
                        <form:options items="${accountStatusList}"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td><form:label path="roles">Roles</form:label></td>
                <td>
                    <form:select multiple="true" path="roles">
                        <form:options items="${roleList}" itemValue="id" itemLabel="roleName"/>
                    </form:select>
                </td>
            </tr>

        </table>
        <br>
        <button type="submit">Save</button>

    </form:form>

</body>
</html>
