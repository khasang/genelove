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
    <c:forEach items="${allQuestion}" var="question">
        <tr>
                <%--<td><c:out value="${question.id}"/></td>--%>
                <%--<td><c:out value="${question.question}"/></td>--%>
                <%--<td><c:out value="${question.answer1}"/></td>--%>
                <%--<td><c:out value="${question.answer2}"/></td>--%>
                <%--<td><c:out value="${question.answer3}"/></td>--%>
                <%--<td><c:out value="${question.answer4}"/></td>--%>
                <%--<td><c:out value="${question.correctAnswers}"/></td>--%>
            <td>${question.id}</td>
            <td>${question.question}</td>
            <td>${question.answer1}</td>
            <td>${question.answer2}</td>
            <td>${question.answer3}</td>
            <td>${question.answer4}</td>
            <td>${question.correctAnswers}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
