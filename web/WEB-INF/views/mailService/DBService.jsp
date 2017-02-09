<!-------------------------------- from header.jsp -------------------------------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/mail.css" rel="stylesheet">
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
        <h1>${tableTitle}</h1>
        <form class="mailForm" method="get" action="">
            <table class="tableData">
                <%! private int counter = 0; %>
                <c:if test="${hiddenAction eq 'viewTablesList'}">
                    <tr>
                        <th>N</th>
                        <th>Table</th>
                        <th>Status</th>
                        <th>Records</th>
                        <th colspan="4">Actions</th>
                    </tr>
                    <c:forEach items="${tables}" var="table">
                        <tr>
                            <td><%= ++counter %></td>
                            <td>${table.name}</td>
                            <td>${table.name}</td>
                            <td>${table.name}</td>
                            <td><a href="DBService/view/${table.name}">View</a></td>
                            <td><a href="DBService/save/${table.name}">Save</a></td>
                            <td><a href="DBService/clear/${table.name}">Clear/Reload</a></td>
                            <td><a href="DBService/clear/${table.name}">Clear</a></td>
                        </tr>
                    </c:forEach>
                    <!-- <%= counter=0 %> -->
                </c:if>
                <c:if test="${hiddenAction eq 'viewTable'}">
                    <c:if test="${keys eq null}">
                        <div class="systemErrorMessage">
                            <p>This table is empty...</p>
                        </div>
                    </c:if>
                    <c:if test="${keys != null}">
                        <tr>
                            <th>N</th>
                            <c:forEach items="${keys}" var="key">
                                <th>${key}</th>
                            </c:forEach>
                        </tr>
                        <c:forEach items="${tableData}" var="map">
                            <tr>
                                <td><%= ++counter %></td>
                                <c:forEach items="${keys}" var="key">
                                    <td>${map.get(key)}</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        <!-- <%= counter=0 %> -->
                    </c:if>
                </c:if>
            </table>
            <input class="submitMail" type="submit" value="No Action" />
        </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>
