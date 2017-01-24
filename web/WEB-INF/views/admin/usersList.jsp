<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove Administration: Users List</title>
</head>
<body>
<!-- ************************** from header.jsp ************************************** -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin">Genelove: Administration Screen</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/admin">Home</a></li>
                <li><a onclick="aboutPopup()">About</a></li>
                <li><a href="/admin/usersList">Users List</a></li>
                <li><a href="/admin/new">Add User</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
            <div class="col-sm-3 col-md-3 pull-right">
                <form action="/admin/usersList" class="navbar-form" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search By Login" name="filter" id="filter">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</nav>

<script type="text/javascript">
    var url = window.location.toString();
    var elem = document.querySelectorAll('ul.nav li');
    if(url.indexOf("/admin/user")>0)
        elem.item(2).classList.add("active");
    else if(url.indexOf("/admin/new")>0)
        elem.item(3).classList.add("active");
    else
        elem.item(0).classList.add("active");
    function aboutPopup() {
        alert("About Form");
    }
</script>
<!-- ************************** from header.jsp ************************************** -->


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
                        <button class="btn btn-info" type="submit">Send Mail</button>
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

    <%@ include file="/WEB-INF/views/pagination.jsp" %>

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