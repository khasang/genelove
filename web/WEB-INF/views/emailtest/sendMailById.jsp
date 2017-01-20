<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Sender</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<head>
    <title>Mail Sender</title>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
    <span class="systemResponce">${message}</span></p>
</div>
<hr class="hr">
<div class="sendMailById">
    <h1>Send simple e-mail by User's Id</h1>
    <form class="mailForm" method="post" action="sendMailById">
        <input type="hidden" name="recipient" value="${id}"/>
        <table border="0" align="center">
            <tr>
                <td>Subject:</td>
                <td><input type="text" name="subject"/></td>
            </tr>
            <tr>
                <td>Message:</td>
                <td><textarea rows="4" name="message"></textarea></td>
            </tr>
        </table>
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
</div>

</body>
</html>
