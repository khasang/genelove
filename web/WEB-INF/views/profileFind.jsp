<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Menu page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%-- <link href="resources/css/menuPage.css" rel="stylesheet" type="text/css" media="all" /> --%>
    <link href="css/menuPage.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body style="background: url(resources/images/loveFone.jpg) no-repeat fixed center;">

<jsp:include page="header.jsp"/>

<div class="panel panel-default">
    <div class="panel-body">
        <form:form action="/account/findProfile" method="get" commandName="findProfile"
                   cssClass="form-inline form-group-sm">
            <p><label for="ageFrom">Age from:</label><input type="text" id="ageFrom" class="form-control" name="ageFrom"></p>
            <p><label for="ageTo">to:</label><input type="text" id="ageTo" class="form-control"
                                                 name="ageTo"></p>
            <p><label for="gender">Gender:</label>
            <select name="gender" id="gender" class="form-control">
                <option value="FEMALE">female</option>
                <option value="MALE">male</option>
            </select></p>

            <p><label for="marital">Marital Status:</label>
            <select name="marital" id="marital" class="form-control">
                <option value="SINGLE">Single</option>
                <option value="MARRIED">Married</option>
                <option value="SEPARATED">Separated</option>
                <option value="DIVORCED">Divorced</option>
                <option value="WIDOWED">Widowed</option>
            </select></p>


            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="btn btn-success" value="Find">
        </form:form>

    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
