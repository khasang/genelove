<!-------------------------------- from header.jsp -------------------------------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/mail.css" rel="stylesheet">
    <title>Mail Sender</title>
</head>
<!--------------------------------- end header.jsp -------------------------------->
<div class="Messenger">
    <fieldset class="fieldsetMessenger">
        <legend id="numberOfMessages">0</legend>
        <a href="/messenger">Dear <strong>${currentUser}</strong>.<br>You have not new message yet</a>
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
        <h1>List of tables in database Genelove</h1>
        <form class="mailForm" method="post" action="">
            <table class="tableData">
                <tr>
                    <th>N</th>
                    <th>Table</th>
                    <th>Status</th>
                    <th colspan="3">Actions</th>
                </tr>
                <%! private int count = 0; %>
                <c:forEach items="${tables}" var="table">
                    <tr>
                        <td><%= ++count %></td>
                        <td>${table.name}</td>
                        <td>${table.name}</td>
                        <td><a href="DBMain/view/${table.name}">View</a></td>
                        <td><a href="DBMain/save/${table.name}">Save</a></td>
                        <td><a href="DBMain/clear/${table.name}">Clear</a></td>
                    </tr>
                </c:forEach>
                <!-- <%= count=0 %> -->
            </table>
            <input class="submitMail" type="submit" value="No Action" />
        </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>
