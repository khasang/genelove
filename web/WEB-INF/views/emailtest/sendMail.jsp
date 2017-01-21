<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Sender</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<head>
    <title>Mail Sender</title>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send simple e-mail by form (Denis Guzikov)</h1>
    <form class="mailForm" method="post" action="sendMail">
        <table border="0" align="center">
            <tr>
                <td><label>To:</label></td>
                <td><input type="text" name="recipient"/></td>
            </tr>
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
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send simple e-mail (Alexander Pyankov)</h1>
    <form method="post" action="sendMailToUser">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send multiple e-mail (Alexander Pyankov)</h1>
    <form method="post" action="sendMailToSomeUsers">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send multiple e-mail for all users</h1>
    <form method="get" action="sendMailToAllUsers">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Empty<br>(For future usage)</h1>
    <form method="post" action="noAction">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
</body>
</html>
