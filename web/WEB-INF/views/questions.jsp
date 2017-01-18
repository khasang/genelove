<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>question</td>
        <td>answer1</td>
        <td>answer2</td>
        <td>answer3</td>
        <td>answer4</td>
        <td>correctanswers</td>
    </tr>
    <c:forEach items="${allQuestion.pageList}" var="question">
        <tr>
                <td>${question.id}</td>
                <td>${question.question}</td>
                <td>${question.answer1}</td>
                <td>${question.answer2}</td>
                <td>${question.answer3}</td>
                <td>${question.answer4}</td>
                <td>${question.correctAnswers}</td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="?page=previous">&lt;</a>
        <td><a href="?page=next">&gt;</a>
    </tr>
</table>
</body>
</html>
