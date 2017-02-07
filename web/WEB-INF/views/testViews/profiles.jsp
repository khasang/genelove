<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%-- <link href="/css/menuPage.css" rel="stylesheet" type="text/css" media="all" /> --%>
    <link href="../css/menuPage.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body style="background: url(../resources/images/loveFone.jpg) no-repeat fixed center;">

<jsp:include page="header_r.jsp"/>

<div class="row content" id="menuBox">
    <div class="col-sm-10 text-left">
        <div class="container" style="color: azure">
            <p>Hello, Dear <strong>${currentUser.firstName} ${currentUser.lastName}</strong>
                Welcome to your personal cabinet!</p>
        </div>
    </div>


    <div class="col-sm-10 text-left">
        <div class="container">
            <table class="table-bordered container" style="background-color: azure">
                <tr>
                    <td>Nickname</td>
                    <td>Age</td>
                    <td>Gender</td>
                    <td>Marital Status</td>
                    <td>Hobbies</td>
                    <td>Introduction</td>
                    <td>Match</td>
                </tr>
                <c:forEach items="${profiles}" var="profile">
                    <tr>
                        <td>${profile.nickname}</td>
                        <td>${profile.age}</td>
                        <td>${profile.gender}</td>
                        <td>${profile.maritalStatus}</td>
                        <td>${profile.hobbies}</td>
                        <td>${profile.introduction}</td>
                        <td>${profile.match}</td>
                        <td>
                            <div>
                            <a href="${pageContext.request.contextPath}/editProfile/${profile.id}">
                                <button class="btn btn-success btn-xs">Edit Profile</button>
                            </a>
                            </div>
                        </td>
                    </tr>

                </c:forEach>
            </table>
            <div style="margin:5px;"><a href="${pageContext.request.contextPath}/profileNew">
                <button class="btn btn-success btn-sm">
                    <i class="glyphicon glyphicon-pencil"></i>
                    Add new profile
                </button>
            </a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer_d.jsp"/>
</body>
</html>
