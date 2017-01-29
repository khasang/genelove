<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bottons.css"/>
<link rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" href="css/images.css"/>

<jsp:include page="testViews/head.jsp"/>
<body style="background: url(images/loveFone.jpg) no-repeat fixed center;" >
    <jsp:include page="header.jsp"/>
        <div class="container noBackground" >
            <div class="row opacityBackground">
                <div class="col-lg-3 opacityBackground">
                    <form action="${pageContext.request.contextPath}/searchResult">
                        <div class="noOpacity border">
                            <label class="text-muted" for="fname">First Name  </label>
                            <input type="checkbox" id="checkBox1"><label for="checkBox1"></label><br>
                            <input class="inputText" type="text" id="fname" name="firstName"><br>


                            <label class="text-muted" for="lname">Last Name  </label>
                            <input type="checkbox" id="checkBox2"><label for="checkBox2"></label><br>
                            <input class="inputText"  type="text" id="lname" name="lastName"><br>

                            <label class="text-muted" for="age">Age  </label>
                            <input type="checkbox" id="checkBox4"><label for="checkBox4"></label><br>
                            <div id="age" class="italic">
                                <input type="text" id="minAge" name="from" placeholder="from">
                                <input type="text" id="maxAge" name="to" placeholder="to"><br>
                            </div>

                            <input type="submit" value="Search">
                        </div>
                    </form>
                </div>
                <div class="col-lg-7 col-lg-offset-1 rowFlexContainer opacityBackground">
                    <c:if test="${empty friends.friendsList}">
                        <p class="genericFont">You have no friends yet:(</p>
                    </c:if>
                    <c:forEach var="item" items="${friends.friendsList}">
                        <div class="panel panel-primary flexElement">
                            <div class="panel-heading genericFont">
                                    ${item.firstName} ${item.lastName} ${item.age}
                            </div>
                            <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" alt="Image"></div>
                            <div class="panel-footer genericFont">${item.accountStatus} <a href="#">More info</a></div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>