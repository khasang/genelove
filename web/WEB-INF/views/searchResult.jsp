<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/bottons.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../css/images.css"/>
</head>

<body class="background" style="background: url(../images/loveFone.jpg) no-repeat fixed center;">
    <jsp:include page="header.jsp" />
    <div class="wrapper">
        <h1 class="alignCenter" style="color: #f3f3f3;">Search results</h1>
        <div class="container noBackground" >
            <div class="row opacityBackground">
                <div class="col-lg-3 opacityBackground">
                    <form action="${pageContext.request.contextPath}/account/searchResult">
                        <div class="noOpacity border">
                            <label class="text-muted" for="marital">Marital Status:</label>
                            <select name="marital" id="marital" class="form-control">
                                <option value="SINGLE">Single</option>
                                <option value="MARRIED">Married</option>
                                <option value="SEPARATED">Separated</option>
                                <option value="DIVORCED">Divorced</option>
                                <option value="WIDOWED">Widowed</option>
                            </select><<br>

                            <label class="text-muted" for="gender">Gender:</label>
                            <select name="gender" id="gender" class="form-control">
                                <option value="FEMALE">female</option>
                                <option value="MALE">male</option>
                            </select><br>

                            <label class="text-muted" for="age">Age  </label>
                            <input type="checkbox" id="checkBox4"><label for="checkBox4"></label><br>
                            <div id="age" class="italic">
                                <input type="text" id="minAge" name="minAge" placeholder="from">
                                <input type="text" id="maxAge" name="maxAge" placeholder="to"><br>
                            </div>

                            <input type="submit" value="Search">
                        </div>
                    </form>
                </div>
                <div class="col-lg-7 col-lg-offset-1 rowFlexContainer opacityBackground">
                    <c:if test="${empty profiles}">
                        <p class="genericFont">No one have been found:(</p>
                    </c:if>
                    <c:forEach var="item" items="${profiles}">
                        <div class="panel panel-primary flexElement">
                            <div class="panel-heading genericFont">
                                    ${item.nickname} ${item.age}
                            </div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" alt="Image"></div>
                            <div class="panel-footer genericFont">
                                    ${item.maritalStatus}
                                <a href="#">More info</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />

</body>
</html>