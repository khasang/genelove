<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html class="no-js">
<head>
    <title>Home</title>
    <jsp:include page="include/head.jsp"/>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/bground.jpg) no-repeat fixed center;">
<%--<div id="main-wrapper">--%>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <jsp:include page="include/leftmenu.jsp"/>
    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 templatemo-content-wrapper">
        <div class="templatemo-content">
            <section id="home-text" class="active templatemo-content-section">
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <h2>${currentUser.firstName} ${currentUser.lastName}
                        <button type="button" class="btn btn-default" aria-label="Left Align">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </button>
                    </h2>
                    <hr>
                    <div class="col-sm-4 col-md-4">
                        <div id="Photo">
                            <img id="picture" class="img-thumbnail" alt="Profile picture"
                                 src="${pageContext.request.contextPath}/images/Zidane.jpg" width="200" height="200"/>
                        </div>
                        <hr>
                    </div>
                    <div class="col-sm-8 col-md-8" text-center>
                        <h3>Email : ${currentUser.email}</h3>
                        <hr>
                        <h4>City : Madrid</h4>
                        <h4>Date birth : 20.03.1974</h4>
                        <h4>Age : 44</h4>
                        <h4>Phone : 074-567-32-35</h4>
                        <h4>Roles : USER,ADMINISTRATOR</h4>
                        <h4><a href="#">My Friends</a></h4>
                        <h3>About Me: </h3>
                        <div id="description" class="content">
                            <p>I was named the FIFA World Player of the Year three times, in 1998, 2000 and 2003, and
                                won the 1998 Ballon d'Or.
                                He was Ligue 1 Player of the Year in 1996, Serie A Footballer of the Year in 2001 and La
                                Liga Best Foreign Player in 2002
                            <p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <jsp:include page="include/footer.jsp"/>

</div><!-- /#main-wrapper -->

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}/js/templatemo_script.js"></script>
<!-- templatemo 398 nature -->

</body>
</html>
