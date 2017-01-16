<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email with Spring MVC</title>
</head>
<body>
<center>
    <h1>Sending e-mail with Spring MVC</h1>
    <form method="post" action="sendEmail.do">
        <table border="0" width="80%">
            <tr>
                <td>To:</td>
                <td><input type="text" name="recipient" size="65" /></td>
            </tr>
            <tr>
                <td>Subject:</td>
                <td><input type="text" name="subject" size="65" /></td>
            </tr>
            <tr>
                <td>Message:</td>
                <td><textarea cols="50" rows="10" name="message"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Send E-mail" />
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
