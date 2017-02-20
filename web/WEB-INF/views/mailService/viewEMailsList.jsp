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
<div>
    <table class="tableData">
        <tr>
            <th>ID</th>
            <th>Recipient</th>
            <th>Sender</th>
            <th>Subject</th>
            <th>Date of creation</th>
            <th>Text</th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td>${eM.id}</td>
                <td>${email.re}</td>
                <td>${user.firstName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="include/footer.jsp"/>