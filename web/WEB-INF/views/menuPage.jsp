<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Menu page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%-- <link href="resources/css/menuPage.css" rel="stylesheet" type="text/css" media="all" /> --%>
    <link href="css/menuPage.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body style="background: url(images/loveFone.jpg) no-repeat fixed center;">

<jsp:include page="include/header.jsp"/>



<div class="row content">
    <div class="col-sm-1 sidenav">
        </div>

        <div class="col-sm-10 text-left">
<c:forEach items="${list}" var="list">
    <div class="content" id="boxContent">
            <a href=#>
                <div class="panel panel-primary" id="userBox">
                    <div class="panel-body" >
                        <img id="picture" alt="Profile picture" src="images/Zidane.jpg" width="200" height="200" />
                        Zinedine : 37 years
                    </div>
                </div>
            </a>
</div>
</c:forEach>
        </div>
    <div class="col-sm-1 sidenav">
    </div>


</div>
<jsp:include page="include/footer.jsp"/>
</body>
</html>
