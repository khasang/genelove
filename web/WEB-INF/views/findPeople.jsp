<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Find new friends</title>
        <link rel="stylesheet" href="css/bottons.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/images.css"/>

    </head>
    <body class="background">
        <jsp:include page="header_r.jsp" />
        <h1 class="alignCenter">My Friends</h1>
        <div class="opacityBackground rowFlexContainer">
            <div class="toCenter flexElement quaterWidth fixedPosition">
                <form action="${pageContext.request.contextPath}/searchResult" class="width noOpacity">
                    <div class="noOpacity">
                        <label for="fname" class="genericFont">First Name</label><br>
                        <input class="inputText" type="text" id="fname" name="firstName">

                        <label for="lname" class="genericFont">Last Name</label><br>
                        <input class="inputText"  type="text" id="lname" name="lastName"><br>

                        <label for="region" class="genericFont">State</label><br>
                        <input class="inputText" type="text" id="region" name="Region"><br>

                        <label for="age" class="genericFont">Age</label><br>
                        <input class="inputText" type="range" id="age" name="Age"><br>

                        <input type="submit" value="Search">
                    </div>
                </form>
            </div>

            <div class="quaterWidth righAlign flexElement rowFlexContainer leftPadding40">
                <c:if test="${empty friends.friendsList}">
                    <p class="genericFont">You have no friends yet:(</p>
                </c:if>
                <c:forEach var="item" items="${friends.friendsList}">
                    <div class="panel panel-primary righAlign flexElement">
                        <div class="panel-heading genericFont">
                            ${item.firstName} ${item.lastName} ${item.birthDate}
                        </div>
                        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" alt="Image"></div>
                        <div class="panel-footer genericFont">${item.region} <a href="#">More info</a></div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="footer_d.jsp" />
    </body>
</html>