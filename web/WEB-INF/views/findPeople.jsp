<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Find new friends</title>
        <jsp:include page="include/head.jsp"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}css/bottons.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}css/style.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}css/images.css"/>

    </head>
    <body style="background: url(${pageContext.request.contextPath}/resources/images/bground.jpg) no-repeat fixed center;">
        <jsp:include page="include/header.jsp" />
        <h1 class="alignCenter">My Friends</h1>
        <div class="opacityBackground rowFlexContainer">
            <div class="toCenter flexElement quaterWidth fixedPosition">
                <form action="${pageContext.request.contextPath}searchResult" class="width noOpacity">
                    <div class="noOpacity">
                        <label for="fname" class="genericFont">First Name  </label>
                        <input type="checkbox" id="checkBox1" class="checkBoxStyle"><label for="checkBox1"></label><br>
                        <input class="inputText" type="text" id="fname" name="firstName"><br>


                        <label for="lname" class="genericFont">Last Name  </label>
                        <input type="checkbox" id="checkBox2" class="checkBoxStyle"><label for="checkBox2"></label><br>
                        <input class="inputText"  type="text" id="lname" name="lastName"><br>

                        <label for="region" class="genericFont">Region  </label>
                        <input type="checkbox" id="checkBox3" class="checkBoxStyle"><label for="checkBox3"></label><br>
                        <input class="inputText" type="text" id="region" name="region"><br>

                        <label for="age" class="genericFont">Age  </label>
                        <input type="checkbox" id="checkBox4" class="checkBoxStyle"><label for="checkBox4"></label><br>
                        <div id="age" class="italic">
                            <input type="text" id="minAge" name="minAge" placeholder="from">
                            <input type="text" id="maxAge" name="maxAge" placeholder="to"><br>
                        </div>

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
        <jsp:include page="include/footer.jsp" />
    </body>
</html>