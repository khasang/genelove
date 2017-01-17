<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email with Spring MVC</title>
    <link href="http://localhost:8080/css/style.css" rel="stylesheet">
</head>
<body>
<div id="header"><h1><span id="gene">GENE</span><span id="love">LOVE</span></h1>
    <ul class="navMenu">
        <li><a href="/" id="activeMenu">Main page</a></li>
        <li><a href="hello">Hello page</a></li>
        <li><a href="db/create">Create table / Entry</a></li>
        <li><a href="db/insert">Insert data into <strong>films</strong></a></li>
        <li><a href="simpleSelect">Simple select into <strong>films</strong></a></li>
        <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
    </ul></div>
<div id="left"><h2>LEFT MENU</h2><hr>
    <ul class="leftMenu">
        <li><a href="/">Main</a></li>
        <li><a href="/accountTest/">Account Test Info</a></li>
        <li><a href="/account/info">User Info</a></li>
        <li><a href="/sendEmail" class="active">Send e-mail</a></li>
        <li><a href="/">Main</a></li>
    </ul>
    <hr>
    <p>Advertisment</p>

</div>
<div id="main">
    <h1>Sending e-mail with Spring MVC</h1>
    <form method="post" action="sendEmail.do">
        <table>
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
        </table>
        <input id="button" type="submit" value="Send" />
    </form>
</div>
<div id="footer"><h1>Footer</h1>
    <div id="copyright">Created by Khasang Student Development Team, 2017</div></div>
</body>
</html>
