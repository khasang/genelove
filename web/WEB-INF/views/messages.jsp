<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js">
<head>
    <title>My message</title>
    <jsp:include page="include/head.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/message/myMessage.css">
</head>
<body style="background: url(${pageContext.request.contextPath}/images/bground.jpg) no-repeat fixed center;">
<%--<div id="main-wrapper">--%>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <jsp:include page="include/leftmenu.jsp"/>
    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 templatemo-content-wrapper">
        <div class="templatemo-content">
            <section id="home-text" class="active templatemo-content-section">
               <h1>My messages : </h1>
                <hr>
<c:forEach items="${messageList}" var="message" >
                <div class="container" id="messageContent">
                    <img src="${pageContext.request.contextPath}/images/Zidane.jpg" alt="Avatar" style="width:60px">
                    <p><strong><span>${message}</span></strong></p><hr>
                    <p>Some message....</p>
                </div>
    </c:forEach>
            </section>
        </div>
    </div>
    <jsp:include page="include/footer.jsp"/>

</div><!-- /#main-wrapper -->



</body>
</html>
