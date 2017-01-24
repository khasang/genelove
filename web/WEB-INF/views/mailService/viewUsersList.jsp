<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <title>Mail Sender</title>
</head>
<body>
<jsp:include page="include/navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
        <span class="systemResponce">${message}</span></p>
</div>
<hr>
<div class="sendMailToSelectUsers">
    <fieldset class="fieldset">
        <legend>View all users</legend>
        <h1> Please, select all users that you wanna, and then push button "Select"</h1>
        <form class="mailForm" method="post" action="sendMailToGroupOfUsers">
            <table class="tableData">
                <tr>
                    <th>Select</th>
                    <th>ID</th>
                    <th>Login</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>E-Mail</th>
                    <th>Send E-Mail</th>
                    <th>Send Private Message</th>
                </tr>
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td><input type="checkbox" name="choice" value="${user.id}"/></td>
                        <td>${user.id}</td>
                        <td>${user.login}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td><a href="sendMailById/${user.id}">Send E-Mail</a></td>
                        <td><a href="sendMail?user=${user.id}">Send Private message</a></td>
                    </tr>
                </c:forEach>
            </table>
            <input class="submitMail" type="submit" value="Send Mail" />
        </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>