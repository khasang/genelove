<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>My Favourites</title>
</head>

<body>

<div class="container">

    <h3>My Favourites</h3>

    <table class="table-bordered container">

        <thead>
        <tr>
            <th>Login</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-Mail Address</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${favouriteList}" var="favourite" varStatus="status">
            <tr>
                <td><a href="/admin/user/id/${favourite.favouriteKey.favourite.id}">${favourite.favouriteKey.favourite.login}</a></td>
                <td><a href="/admin/user/id/${favourite.favouriteKey.favourite.id}">${favourite.favouriteKey.favourite.firstName}</a></td>
                <td><a href="/admin/user/id/${favourite.favouriteKey.favourite.id}">${favourite.favouriteKey.favourite.lastName}</a></td>
                <td>${favourite.favouriteKey.favourite.email}</td>

                <td align="center">
                    <c:url var="remove" value="/removeFavourite"/>
                    <form:form action="${remove}" method="post" modelAttribute="favourite">
                        <form:input type="hidden" path="favouriteKey.user.id" value="${favourite.favouriteKey.user.id}"/>
                        <form:input type="hidden" path="favouriteKey.favourite.id" value="${favourite.favouriteKey.favourite.id}"/>
                        <button class="btn btn-danger" type="submit">Remove from My Favourites</button>
                    </form:form>
                </td>

            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>
