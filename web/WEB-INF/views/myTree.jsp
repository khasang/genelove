
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Tree page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/myTree.css.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body style="background: url(images/loveFone.jpg) no-repeat fixed center;">
<jsp:include page="header.jsp"/>
<div class="container" id="contentTree" style="min-height:90% ">

        <div class="row content">
            <div class="col-sm-6 text-center">
              <a href="#">
                  <div class="col-sm-6 text-center">
                <div class="panel panel-success" >
                    <div class="panel-heading text-center" >
                        Grandfather
                    </div>
                    <div class="panel-body" >
                        <img  alt="Profile picture" src="images/user-icon.png" width="100" height="100" />
                    </div>
                    <div class="panel-footer">Grand : 87 years</div>
                </div>
                    </div>
                  </a>
                <a href="#">
                <div class="col-sm-6 text-center">
                <div class="panel panel-success" >
                    <div class="panel-heading text-center" >
                        Grandmother
                    </div>
                    <div class="panel-body" >
                        <img  alt="Profile picture" src="images/user-icon.png" width="100" height="100" />
                    </div>
                    <div class="panel-footer">Grand : 84 years</div>
                </div>
                    </div>
                </a>
            </div>
            <div class="col-sm-6 text-center">
                <a href="#">
                <div class="col-sm-6 text-center">
                    <div class="panel panel-danger" >
                        <div class="panel-heading text-center" >
                            Mother
                        </div>
                        <div class="panel-body" >
                            <img  alt="Profile picture" src="images/user-icon.png" width="100" height="100" />
                        </div>
                        <div class="panel-footer">Alice : 64 years</div>
                    </div>
                </div>
                    </a>
                    <a href="#">
                <div class="col-sm-6 text-center">
                    <div class="panel panel-danger" >
                        <div class="panel-heading text-center" >
                            Father
                        </div>
                        <div class="panel-body" >
                            <img  alt="Profile picture" src="images/user-icon.png" width="100" height="100" />
                        </div>
                        <div class="panel-footer">Alex : 66 years</div>
                    </div>
                </div>
                    </a>
            </div>
        </div>


    <div style="margin-left: auto;margin-right: auto;width: 200px">
        <a href="#">
        <div class="panel panel-primary" >
            <div class="panel-heading text-center" >
                Me
            </div>
            <div class="panel-body" >
                <img  alt="Profile picture" src="images/Zidane.jpg" width="150" height="150" />
            </div>
        </div>
            </a>
    </div>

    <div style="background-color: indianred;margin-left: auto;margin-right: auto;">
        children
        </div>

</div>
<jsp:include page="footer.jsp"/>
</body>