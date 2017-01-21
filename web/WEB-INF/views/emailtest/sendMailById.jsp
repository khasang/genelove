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
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send simple e-mail by User's Id</h1>
    <form class="mailForm" method="post" action="send">
        <input type="hidden" name="recipient" value="${id}"/>
        <table border="0" align="center">
            <tr>
                <td><label>Subject:</label></td>
                <td><input type="text" name="subject"/></td>
            </tr>
            <tr>
                <td><label>Message:</label></td>
                <td><textarea rows="4" name="message"></textarea></td>
            </tr>
        </table>
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>

</body>
</html>
