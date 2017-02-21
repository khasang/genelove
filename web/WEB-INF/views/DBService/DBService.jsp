<!-------------------------------- from header.jsp -------------------------------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}css/mail.css" rel="stylesheet">
    <title>Mail Sender</title>
</head>
<!--------------------------------- end header.jsp -------------------------------->
<div class="Messenger">
    <fieldset class="fieldsetMessenger">
        <legend id="numberOfMessages">0</legend>
        <a href="${pageContext.request.contextPath}/messenger">Dear <strong>${currentUser}</strong>.<br>You have not new message yet</a>
    </fieldset>
</div>
<!-------------------------------- from title.jsp -------------------------------->
<div id="head"><a id="headLink" href="${pageContext.request.contextPath}">
    <span id="gene">GENE</span><span id="love">LOVE</span><br>Meeting Service</a>
</div>
<!--------------------------------- end title.jsp -------------------------------->
<body>
<jsp:include page="../mailService/include/navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
        <span class="systemResponse">${message}<br>${response}</span></p>
</div>
<c:if test="${  (hiddenAction ne 'saveTable') and
                (hiddenAction ne 'loadTable') and
                (hiddenAction ne 'reloadTable') and
                (hiddenAction ne 'clearTable') and
                (hiddenAction ne 'deleteTable') and
                (hiddenAction ne 'updateRecord') and
                (hiddenAction ne 'deleteRecord')}">
    <hr>
    <div class="sendMailToSelectUsers">
    <fieldset class="fieldset">
        <legend>DB Service</legend>
        <h1>${tableTitle}</h1>
        <%! private int counter = 0; %>

        <c:if test="${hiddenAction eq 'addRecord'}">


                <h1>Add record in table "${table}"</h1>
                <form class="mailForm" method="post" action="addRecord">
                    <input type="hidden" name="hiddenValue" value="-1"/>
                    <table border="0" align="center">
                        <tr>
                            <td><label>Field:</label></td>
                            <td><textarea rows="4" name="privateMessage"></textarea></td>
                        </tr>
                    </table>
                    <input class="submitMail" type="submit" value="Add Record" />
                </form>
            </fieldset>

        </c:if>

        <c:if test="${hiddenAction eq 'viewTablesList'}">
            <form class="mailForm" method="get" action="">
                <table class="tableData">
                    <tr>
                       <th>N</th>
                        <th>Table</th>
                        <th>Records</th>
                        <th colspan="6">Actions</th>
                    </tr>
                    <c:forEach items="${tables}" var="table">
                        <tr>
                            <td class="number"><%= ++counter %></td>
                            <td>${table.name}</td>
                            <td>
                                <c:if test="${table.records eq '0'}">
                                    <div class="empty">${table.records}</div>
                                </c:if>
                                <c:if test="${table.records ne '0'}">
                                    ${table.records}
                                </c:if>
                            </td>
                            <td class="link"><a href="${pageContext.request.contextPath}/DBService/view/${table.name}">View</a></td>
                            <td class="link"><a href="${pageContext.request.contextPath}/DBService/save/${table.name}">Save</a></td>
                            <td class="link"><a href="${pageContext.request.contextPath}/DBService/load/${table.name}">Load</a></td>
                            <td class="link"><a href="${pageContext.request.contextPath}/DBService/reload/${table.name}">Clear/Reload</a></td>
                            <td class="link caution"><a href="${pageContext.request.contextPath}/DBService/clear/${table.name}">Clear</a></td>
                            <td class="link caution"><a href="${pageContext.request.contextPath}/DBService/delete/${table.name}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    <!-- <%= counter = 0 %> -->
                </table>
                <input class="submitMail" type="submit" value="No Action" />
            </form>
        </c:if>
        <c:if test="${hiddenAction eq 'viewTable'}">
            <form class="mailForm" method="get" action="${pageContext.request.contextPath}/DBService/addRecord/${table}">
                <table class="tableData">
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
                            <th colspan="2">Actions</th>
                        </tr>
                        <c:forEach items="${tableData}" var="map">
                            <tr>
                                <td class="number"><%= ++counter %></td>
                                <c:forEach items="${keys}" var="key">
                                    <td>${map.get(key)}</td>
                                </c:forEach>
                                <td class="link"><a href="${pageContext.request.contextPath}/DBService/update/${table}/1">Update</a></td>
                                <td class="link caution"><a href="${pageContext.request.contextPath}/DBService/delete/${table}/1">Delete</a></td>
                            </tr>
                        </c:forEach>
                        <!-- <%= counter=0 %> -->
                    </c:if>
                </table>
                <input class="submitMail" type="submit" value="Add Record" />
            </form>
        </c:if>
    </fieldset>
    </div>
</c:if>
<jsp:include page="../mailService/include/footer.jsp"/>
