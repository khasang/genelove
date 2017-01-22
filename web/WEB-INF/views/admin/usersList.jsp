<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove Administration: Users List</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <br><br>
        <h3>User List</h3>

        <table class="table-bordered container">
        <thead>
            <tr>
                <th>#</th>
                <th>Login</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-Mail Address</th>
                <th>Send eMail</th>
                <th>Account Status</th>
                <th>Roles</th>
                <th colspan="3">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersList.pageList}" var="user" varStatus="status">
                <tr>
                    <td>${user.id}</td>
                    <td><a href="/admin/user/id/${user.id}">${user.login}</a></td>
                    <td><a href="/admin/user/id/${user.id}">${user.firstName}</a></td>
                    <td><a href="/admin/user/id/${user.id}">${user.lastName}</a></td>
                    <td><a href="/admin/user/id/${user.id}">${user.email}</a></td>
                    <td>
                        <form method="post" action="sendMailToUserByMail">
                            <input type="hidden" name="email" value="${user.email}"/>
                            <input type="submit" value="Send Mail" />
                        </form>
                    </td>
                    <td>${user.accountStatus}</td>
                    <td>
                        <c:forEach var="role" items="${user.roles}">
                            ${role.roleName}&nbsp;
                        </c:forEach>
                    </td>
                    <td align="center">
                        <c:url var="block" value="/admin/block"/>
                        <form:form action="${block}" method="post" modelAttribute="user">
                            <form:input type="hidden" path="id" value="${user.id}"/>
                            <button class="btn btn-info" type="submit">Block/Unblock</button>
                        </form:form>
                    </td>
                    <td align="center">
                        <c:url var="promote" value="/admin/promote"/>
                        <form:form action="${promote}" method="post" modelAttribute="user">
                            <form:input type="hidden" path="id" value="${user.id}"/>
                            <button class="btn btn-info" type="submit">Promote/Demote</button>
                        </form:form>
                    </td>
                    <td align="center">
                        <c:url var="delete" value="/admin/delete"/>
                        <form:form action="${delete}" method="post" modelAttribute="user">
                            <form:input type="hidden" path="id" value="${user.id}"/>
                            <button class="btn btn-danger" type="submit">Delete</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:set var="pageListHolder" value="${usersList}" scope="session" />

        <div align="center">
            <ul class="pagination">
                <li>
                    <%--<a href="?page=previous">&lt;</a>--%>
                    <span style="float:left;">
                    <c:choose>
                        <c:when test="${pageListHolder.firstPage}"> < </c:when>
                        <c:otherwise><a href="?page=previous"> < </a></c:otherwise>
                    </c:choose>
                    </span>
                </li>
                <li>
                    <span>
                    <c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
                        &nbsp;&nbsp;
                        <c:choose>
                            <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                            <c:otherwise><a href="?page=${loop.index}">${loop.index+1}</a></c:otherwise>
                        </c:choose>
                        &nbsp;&nbsp;
                    </c:forEach>
                    </span>
                </li>
                <li>
                    <%--<a href="?page=next">&gt;</a>--%>
                    <span>
                    <c:choose>
                        <c:when test="${pageListHolder.lastPage}"> > </c:when>
                        <c:otherwise><a href="?page=next"> > </a></c:otherwise>
                    </c:choose>
                    </span>
                </li>
            </ul>
        </div>

        <br>

        <h3>Statistics</h3>
        <table class="table-bordered col-lg-4">
            <thead>
            <tr>
                <th>Total Users</th>
                <th>Blocked Users</th>
                <th>Administrators</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${allUsersCount}</td>
                <td>${blockedUsersCount}</td>
                <td>${adminUsersCount}</td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
