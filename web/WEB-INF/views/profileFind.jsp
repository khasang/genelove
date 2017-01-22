<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-body">
        <form:form action="/findProfile" method="post" commandName="findProfile"
                   cssClass="form-inline form-group-sm">
            <label for="ageFrom">Age from:</label><input type="text" id="ageFrom" class="form-control" name="ageFrom">
            <label for="ageTo">to:</label><input type="text" id="ageTo" class="form-control"
                                                          name="ageTo">
            <label for="gender">Gender:</label>
            <select name="gender" id="gender" class="form-control">
                <option value="FEMALE">female</option>
                <option value="MALE">male</option>
            </select>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="btn btn-success" value="Find">
        </form:form>

    </div>
</div>
</body>
</html>
