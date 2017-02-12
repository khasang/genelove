<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Menu page</title>
    <jsp:include page="../include/head.jsp"/>
</head>
<body style="background: url(resources/images/bground.jpg) no-repeat fixed center;">

<jsp:include page="../include/header.jsp"/>
<div class="container">
    <jsp:include page="../include/leftmenu.jsp"/>
    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 templatemo-content-wrapper">
        <div class="panel panel-default">
            <div class="panel-body">
                <form:form action="/findProfile" method="get" commandName="findProfile"
                           cssClass="form-inline form-group-sm">
                    <p><label for="ageFrom">Age from:</label><input type="text" id="ageFrom" class="form-control"
                                                                    name="ageFrom"></p>
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
        </div>
    </div>
    <jsp:include page="../include/footer.jsp"/>
</body>
</html>
