<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<ul class="navMenu">
    <li><a href="http://localhost:8080">Main page</a></li>
    <li><a href="create">Create table / Entry</a></li>
    <li><a href="insert">Insert data into <strong>films</strong></a></li>
    <li><a href="simpleSelect">Simple select into <strong>films</strong></a></li>
    <li><a href="multipleSelect">Multiple select into <strong>films</strong></a></li>
    <li><a href="http://localhost:8080/logout">Log Out</a></li>
</ul>
<div id="container">
    <div id="left"><h2>LEFT MENU</h2><hr>
        <ul class="leftMenu">
            <li><a href="/db/allQuestion">All Question</a></li>
            <li><a href="/">Main</a></li>
            <li><a href="/">Main</a></li>
            <li><a href="/">Main</a></li>
        </ul>
        <hr>
        <p>Advertisment</p>
    </div>
    <div id="main">
        <h1>All Questions</h1>
        <hr>
        <p>This is a simple question with four options of answers and Right Answer.</p>
        <hr>
        <table>
            <tr>
                <th>ID</th>
                <th>Question</th>
                <th>Answer 1</th>
                <th>Answer 2</th>
                <th>Answer 3</th>
                <th>Answer 4</th>
                <th>Correct Answers</th>
            </tr>
            <c:forEach items="${allQuestion}" var="question">
                <tr>
                    <td>${question.id}</td>
                    <td>${question.question}</td>
                    <td>${question.answer1}</td>
                    <td>${question.answer2}</td>
                    <td><c:out value="${question.answer3}"/></td>
                    <td><c:out value="${question.answer4}"/></td>
                    <td>${question.correctAnswers}</td>
                </tr>
            </c:forEach>
        </table>
        <hr>
    </div></div>
<div id="footer"><h1>Footer</h1></div>
</body>
</html>
