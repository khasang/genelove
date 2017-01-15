<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="profile"
             class="io.khasang.genelove.service.ProfileService"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Profile</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/images.css"/>

    </head>

    <body class="background">

    <%@ include file="header.jsp" %><br><br>
    <div>
        <a href="changeFoto.jsp">
            <img src="resources/smile.jpg" alt="Фото" class="profilePageFoto">
        </a><br>

        <div class="leftMargin topMargin">
            <h1 class="heading1">Personal information</h1>
            <a href="${pageContext.request.contextPath}/modifyProfile"
               class="ref leftMargin23em">Edit profile</a><br><br>
            <strong class="leftMargin23em">
                ${profile.firstName} ${profile.lastName}<br><br>
            </strong>
            <strong class="leftMargin23em">
                ${profile.birthDate}<br><br>
            </strong>
            <strong class="leftMargin23em">
                ${profile.region}<br><br>
            </strong>
            <strong class="leftMargin23em">
                <jsp:getProperty name="profile" property="region"/><br><br>
                <br><br>
            </strong>
        </div>
        <a href="${pageContext.request.contextPath}/tree">
            <img src="resources/genealDrevo.jpg" alt="генеалогическое древо" class="profilePageFoto" >
        </a>

        <div>
            <h1 class="heading1">Education: </h1>
            <strong class="leftMargin">School: </strong>
            ${profile.school}<br><br>
            <strong class="leftMargin">University: </strong>
            ${profile.university}<br><br>
        </div>

        <div>
            <h1 class="heading1">Hobby</h1>
            <strong class="leftMargin">Hobby: </strong>
        <${profile.hobby}/><br><br>
        <strong class="leftMargin bottomPadding">Activities: </strong>
    <${profile.activity}/><br><br>
    </div>
    </div>

    <%@ include file="footer_d.jsp" %>

    </body>
</html>