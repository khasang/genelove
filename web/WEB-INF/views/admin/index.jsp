<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove Administration: Home</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <br><br>
        <h3>Administration Screen</h3>

        <c:url var="usersList" value="/admin/usersList"/>
        <form:form action="${usersList}" method="get">
            Users List:
            <button class="btn btn-default" type="submit">Submit</button>
        </form:form>

        <c:url var="userId" value="/admin/user/id/"/>
        <form:form class="col-lg-4" action="${userId}" method="get">
            Search User By Id:
            <input class="form-control" type="text" name="id"/>
            <button class="btn btn-default" type="submit">Submit</button>
        </form:form>

        <c:url var="userLogin" value="/admin/user/login/"/>
        <form:form class="col-lg-4" action="${userId}" method="get">
            Search User By Login:
            <input class="form-control" type="text" name="login"/>
            <button class="btn btn-default" type="submit">Submit</button>
        </form:form>

        <c:url var="logout" value="/logout"/>
        <form:form action="${logout}" method="get">
            Logout:
            <button class="btn btn-default" type="submit">Submit</button>
        </form:form>
    </div>
</body>
</html>
