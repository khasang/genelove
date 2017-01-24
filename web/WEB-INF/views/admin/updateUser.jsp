<jsp:include page="include/header.jsp"/>
<div class="container">
    <br><br><br><br>
    <jsp:include page="include/greeting.jsp"/>
    <h3>User: <b>${user.login}</b></h3>
    <c:url var="updateUser" value="/admin/update"/>
    <form:form action="${updateUser}" method="post" modelAttribute="user">
        <table>
            <tr>
                <td><form:label path="id">ID</form:label></td>
                <td><form:input class="form-control" placeholder="ID" path="id" value="${user.id}" readonly="true"/></td>
            </tr>
            <tr>
                <td><form:label path="login">Login</form:label></td>
                <td><form:input class="form-control" placeholder="Login" path="login" value="${user.login}" readonly="true"/></td>
            </tr>

            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:password class="form-control" placeholder="Password" path="password" value="${user.password}" readonly="${not param.changePassword}"/></td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <td><a href="?changePassword=true">Change password</a></td>
            </tr>

            <tr>
                <td><form:label path="firstName">First name</form:label></td>
                <td><form:input class="form-control" placeholder="First name" path="firstName" value="${user.firstName}"/></td>
            </tr>

            <tr>
                <td><form:label path="lastName">Last name</form:label></td>
                <td><form:input class="form-control" placeholder="Last name" path="lastName" value="${user.lastName}"/></td>
            </tr>

            <tr>
                <td><form:label path="email">E-Mail address</form:label></td>
                <td><form:input class="form-control" placeholder="E-Mail address" path="email" value="${user.email}"/></td>
            </tr>

            <tr>
                <td><form:label path="accountStatus">Account status</form:label></td>
                <td>
                    <form:select class="form-control" multiple="false" path="accountStatus">
                        <form:options items="${accountStatusList}"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td><form:label path="roles">Roles</form:label></td>
                <td>
                    <form:select class="form-control" multiple="true" path="roles">
                        <form:options items="${roleList}" itemValue="id" itemLabel="roleName"/>
                    </form:select>
                </td>
            </tr>
        </table>
        <br>
        <a href="/admin/usersList">Back to list</a>
        <input class="btn btn-success" type="submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>
