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
        <c:forEach items="${allQuestion.pageList}" var="question" varStatus="status">
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
    </table>
    <c:set var="pageListHolder" value="${allQuestion}" scope="session" />
    <div>
    <span style="float:left;">
    <c:choose>
        <c:when test="${pageListHolder.firstPage}">Prev</c:when>
        <c:otherwise><a href="?page=previous">Prev</a></c:otherwise>
    </c:choose>
    </span>
        <span>
    <c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
        &nbsp;&nbsp;
        <c:choose>
            <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
            <c:otherwise><a href="?page=${loop.index}">${loop.index+1}</a></c:otherwise>
        </c:choose>
        &nbsp;&nbsp;
    </c:forEach>
    </span>
        <span>
    <c:choose>
        <c:when test="${pageListHolder.lastPage}">Next</c:when>
        <c:otherwise><a href="?page=next">Next</a></c:otherwise>
    </c:choose>
    </span>
    </div>
    </body>
    </html>
