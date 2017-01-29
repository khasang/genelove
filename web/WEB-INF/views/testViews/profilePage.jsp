<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Profile</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../css/images.css"/>
    <script src="//code.jquery.com/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>

<body class="background">

<%@ include file="header_r.jsp" %><br><br>

    <div class="container genericFont">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <a href="changeFoto.jsp">
                    <img src="resources/images/smile.jpg" alt="Фото" class="profilePageFoto">
                </a><br>
            </div>
            <div class="col-lg-6 col-lg-offset-1 col-md-6 col-md-offset-1">
                <div>
                    <h1 class="muted">Personal information</h1>
                    <a href="${pageContext.request.contextPath}/modifyProfile">Edit profile</a><br><br>
                    <strong>
                        ${profile.firstName} ${profile.lastName}<br><br>
                    </strong>
                    <strong>
                        ${profile.age}<br><br>
                    </strong>
                    <strong>
                        ${profile.accountStatus}<br><br>
                    </strong>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <a href="${pageContext.request.contextPath}/tree">
                    <img src="resources/images/drevo.jpg" alt="генеалогическое древо" class="profilePageFoto">
                </a>
            </div>
            <div class="col-lg-6 col-lg-offset-1 col-md-6 col-md-offset-1">
                <div>
                    <h1 class="muted">Education </h1>
                    <strong>School: ${profile.school}</strong><br><br>
                    <strong>University: ${profile.university}</strong><br><br>
                </div>

                <div>
                    <h1 class="muted">Hobby</h1>
                    <strong>Hobby: ${profile.hobby}</strong><br><br>
                    <strong>Activities: ${profile.activity}</strong><br><br>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    <%@ include file="footer_d.jsp" %>

</body>
</html>
