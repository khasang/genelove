<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Profile</title>
    <jsp:include page="../include/head.jsp"/>
</head>
<body>

<jsp:include page="../include/header.jsp"/>

<div class="row content" id="menuBox">
    <div class="col-sm-10 text-left">
        <div class="container">
            <form:form action="${pageContext.request.contextPath}/updateProfile/${profile.id}" method="post" commandName="updateProfile"
                       cssClass="form-inline form-group-sm">

                <p><label for="nickname">Nickname:</label><input type="text" id="nickname" class="form-control" name="nickname" value="${profile.nickname}"></p>
                <p><label for="dateOfBirth">Date of birth:</label><input type="date" id="dateOfBirth" class="form-control" name="dateOfBirth" value="${profile.dateOfBirth}"></p>
                <p><label for="hobbies">Your hobbies:</label><input type="text" id="hobbies" class="form-control" name="hobbies" value="${profile.hobbies}"></p>
                <p><label for="introduction">About yourself:</label><input type="text" id="introduction" class="form-control" name="introduction" value="${profile.introduction}"></p>
                <p><label for="match">You want to find:</label><input type="text" id="match" class="form-control" name="match" value="${profile.match}"></p>

                <p><label for="gender">Your gender:</label>
                    <select name="gender" id="gender" class="form-control">
                        <option selected hidden>${profile.gender}</option>
                        <option hidden disabled>Choose gender</option>
                        <option value="FEMALE">FEMALE</option>
                        <option value="MALE">MALE</option>
                        <option value="OTHER">OTHER</option>
                    </select></p>

                <p><label for="maritalStatus">Your marital status:</label>
                    <select name="maritalStatus" id="maritalStatus" class="form-control">
                        <option selected hidden>${profile.maritalStatus}</option>
                        <option hidden disabled>Choose your status</option>
                        <option value="SINGLE">SINGLE</option>
                        <option value="MARRIED">MARRIED</option>
                        <option value="SEPARATED">SEPARATED</option>
                        <option value="DIVORCED">DIVORCED</option>
                        <option value="WIDOWED">WIDOWED</option>
                    </select></p>


                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="btn btn-success" value="Update profile">
            </form:form>

        </div>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>