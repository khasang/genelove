<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="profile"
             class="io.khasang.genelove.dao.UserProfileDao"/>
<jsp:useBean id="friends"
             class="io.khasang.genelove.dao.FriendListDao"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Имя пользователя</title>
        <link rel="stylesheet" type="text/css" href="css/userPage.css"/>
    </head>
    
    <body>
        <
        <%@ include file="header.jsp"%>
        
        <a href="changeFoto.jsp">
           <img src="images/smile.jpg" alt="Фото" class="foto"> 
        </a>
        <h1 class="heading1">
            Личная информация
            <a href="modifyProfile.jsp" class="textInfo1">Изменить анкету</a>
            <a class="horizontalSpace"></a>
            <a href="mainPage.jsp" class="textInfo1">Выйти</a>
        </h1>
        <p class="textInfo"> 
            Имя, фамилия пользователя:
            <jsp:getProperty name="profile" property="name"/><br><br>
            дата рождения:
            <jsp:getProperty name="profile" property="birthDate"/><br><br>
            регион поиска: 
            <jsp:getProperty name="profile" property="region"/><br><br>
            <!--подумать откуда брать статус-->
            статус <br><br> 
            <a href="frinendList.jsp" class="ref">
                друзья: 
                <jsp:getProperty name="friends" property="friends"/><br><br>
            </a>
            <br><br>
        </p>
        <a href="genealogicTree.jsp">
            <img src="images/genealDrevo.jpg" alt="генеалогическое древо" class="drevo"
             href="genealogicTree.jsp">
        </a>
        
        <h1 class="heading1">Место учебы</h1>
        <p class="textInfo">
            школа: 
            <jsp:getProperty name="profile" property="school"/><br><br>
            университет: 
            <jsp:getProperty name="profile" property="university"/><br><br>
        </p>
        
        <h1 class="heading1">Хобби</h1>
        <p class="textInfo">
            увлечения: 
            <jsp:getProperty name="profile" property="hobby"/><br><br>
            любимые занятия:
            <jsp:getProperty name="profile" property="actions"/><br><br>
        </p>
        
         <%@ include file="footer.jsp" %>
    </body>
</html>
