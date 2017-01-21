<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Sender</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"></head>
<head>
    <title>Private Message Service</title>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
    <span class="systemResponce">${message}</span></p>
</div>
<hr class="hr">
</body>
</html>
