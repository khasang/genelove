<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--СТРАНИЦА НЕ ИСПОЛЬЗУЕТСЯ--%>

<div class="panel panel-default">
      <div class="panel-body">
        <form:form action="/register" method="post" commandName="registerUser"
                   cssClass="form-inline form-group-sm">
            <label for="login">Login:</label><input type="text" id="login" class="form-control" name="login">
            <label for="password">Password:</label><input type="text" id="password" class="form-control"
                                                          name="password">
            <label for="firstName">Your First Name:</label><input type="text" id="firstName" class="form-control" name="firstName">
            <label for="lastName">Your Last Name:</label><input type="text" id="lastName" class="form-control" name="lastName">
            <label for="email">Your E-mail:</label><input type="text" id="email" class="form-control" name="email">
            <%--<label for="role">Role:</label>--%>
            <%--<select name="role" id="role" class="form-control">--%>
                <%--<option value="ROLE_ADMIN">admin</option>--%>
                <%--<option value="ROLE_USER">user</option>--%>
                <%--<option value="ROLE_DB">db</option>--%>
            <%--</select>--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="btn btn-success" value="Add user">
        </form:form>

    </div>

</body>
</html>
