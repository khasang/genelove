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
        <h1>Output of all PMs</h1>
            <table class="tableData">
                <tr>
                    <th>N</th>
                    <th>ID</th>
                    <th>Sender ID</th>
                    <th>Sender Name, Lastname</th>
                    <th>Receiver ID</th>
                    <th>Receiver Name, Lastname</th>
                    <th>Time of create</th>
                    <th>Time of sent</th>
                    <th>Time of receive</th>
                    <th>Status of PM's</th>
                    <th>Private Message</th>
                </tr>
            <%! private int count = 0; %>
            <c:forEach items="${allPrivateMessages}" var="privateMessage">
                <tr>
                    <td><%= ++count %></td>
                    <td>${privateMessage.id}</td>
                    <td>${privateMessage.sender.id}</td>
                    <td>${privateMessage.sender.firstName} ${privateMessage.sender.lastName}</td>
                    <td>${privateMessage.receiver.id}</td>
                    <td>${privateMessage.receiver.firstName} ${privateMessage.receiver.lastName}</td>
                    <td>${privateMessage.createdDate}</td>
                    <td>${privateMessage.sentDate}</td>
                    <td>${privateMessage.receivedDate}</td>
                    <td>${privateMessage.messageStatus}</td>
                    <td>${privateMessage.text}</td>
                </tr>
            </c:forEach>
            <!-- <%= count=0 %> -->
            <br>
         </table>
    </fieldset>

</div>
<jsp:include page="include/footer.jsp"/>