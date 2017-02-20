<!-------------------------------- from header.jsp -------------------------------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}css/mail.css" rel="stylesheet">
    <title>Mail Sender</title>
</head>
<!--------------------------------- end header.jsp -------------------------------->
<div class="Messenger">
    <fieldset class="fieldsetMessenger">
        <legend id="numberOfMessages">0</legend>
        <a href="${pageContext.request.contextPath}/messenger">Dear <strong>${currentUser}</strong>.<br>You have not new message yet</a>
    </fieldset>
</div>
<!-------------------------------- from title.jsp -------------------------------->
<div id="head"><a id="headLink" href="/">
    <span id="gene">GENE</span><span id="love">LOVE</span><br>Meeting Service</a>
</div>
<!--------------------------------- end title.jsp -------------------------------->
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
        <h1>Please, select all users that you wanna, and then push button "Select"</h1>
        <form class="mailForm" method="post" action="${pageContext.request.contextPath}sendMailToGroupOfUsers">
            <table class="tableData">
                <tr>
                    <th>Select</th>
                    <th>N</th>
                    <th>ID</th>
                    <th>Login</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>E-Mail</th>
                    <th>Send E-Mail</th>
                    <th>Send Private Message</th>
                </tr>
                <%! private int count = 0; %>
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td><input type="checkbox" name="choice" value="${user.id}"/></td>
                        <td><%= ++count %></td>
                        <td>${user.id}</td>
                        <td>${user.login}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td><a href="sendMailById/${user.id}">Send E-Mail</a></td>
                        <td><a href="sendMessageById/${user.id}">Send Private Message</a></td>
                    </tr>
                </c:forEach>
                <!-- <%= count=0 %> -->
            </table>
            <input class="submitMail" type="submit" value="Send Mail" />
        </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>