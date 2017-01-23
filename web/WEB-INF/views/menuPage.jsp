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
<body style="background: url(resources/images/loveFone.jpg) no-repeat fixed center;">

<jsp:include page="header.jsp"/>

    <div class="row content" id="menuBox">
        <div class="col-sm-10 text-left">
            <div class="container">
                <div class="row">
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Name Surname : Age</div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                            <div class="panel-footer">City :  <a href="#">More info</a></div>
                        </div>
                    </div>
                    <div style="margin:5px;"><a href="${pageContext.request.contextPath}/account/find">
                        <button class="btn btn-success btn-sm">
                            <i class="glyphicon glyphicon-pencil"></i>
                            Find new person
                        </button>
                    </a>
                    </div>

                </div>
            </div>
        </div>

    </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
