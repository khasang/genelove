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
                        <button id="edit" class="btn btn-raised btn-info">
                            <p><span class="glyphicon glyphicon-send"></span> Send Message</p>
                        </button>
                    </div>
                    <div class="col-sm-8 col-md-8" text-center>
                        <h3>Email : ${currentUser.email}</h3>
                        <hr>
                        <h4>City : Madrid</h4>
                        <h4>Date of birth : 20.03.1974</h4>
                        <h4>Phone : 074-567-32-35</h4>
                        <h4>Roles : USER,ADMINISTRATOR</h4>
                        <h4><a href="#">My Friends</a></h4>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <jsp:include page="include/footer.jsp"/>

</div><!-- /#main-wrapper -->

<script src="${pageContext.request.contextPath}js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}js/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}js/templatemo_script.js"></script>
<!-- templatemo 398 nature -->
</body>
</html>
