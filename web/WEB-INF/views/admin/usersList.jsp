<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove Administration: Users List</title>
</head>
<body>
    <jsp:include page="include/header.jsp"/>
    <div class="container">
        <br><br><br><br>
        <jsp:include page="include/greeting.jsp"/>
        <h3>User List</h3>

        <table class="table-bordered container">
            <thead>
            <tr>
                <th>#</th>
                <th>Login</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-Mail Address</th>
                <th>Send Message</th>
                <th>Send eMail</th>
                <th>Inspection</th>
                <th>Inspection Status</th>
                <th>Account Status</th>
                <th>Roles</th>
                <th>Actions</th>
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
                            <button class="btn btn-info" type="submit">Send Mail</button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="sendMessageToUserById">
                            <input type="hidden" name="receiver" value="${user.id}"/>
                            <button class="btn btn-info" type="submit">Send Message</button>
                        </form>
                    </td>
                    <td align="center">
                        <c:url var="inspectUser" value="/admin/inspectUser"/>
                        <form:form action="${inspectUser}" method="post" modelAttribute="user">
                            <form:input type="hidden" path="id" value="${user.id}"/>
                            <button class="btn btn-info" type="submit">Inspect</button>
                        </form:form>
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

        <%@ include file="/WEB-INF/views/addViews/pagination.jsp" %>

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
>>>>>>> parent of df306d5... Realization of sending e-Mail and Private Message
