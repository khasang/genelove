<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Sender</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"></head>
<head>
    <title>Mail Sender</title>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="systemErrorMessage">
    <p>Your request has <strong>NOT</strong> been completed by reason:
    <span class="errorMessage">${errorMessage}</span></p>
</div>
<hr class="hr">
</body>
</html>
