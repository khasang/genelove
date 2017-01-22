<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<table>
    <tr>
        <td>Nickname</td>
        <td>Age</td>
        <td>Gender</td>
        <td>Marital Status</td>
        <td>Hobbies</td>
        <td>Introduction</td>
        <td>Match</td>
    </tr>
        <tr>
            <td>${profile.nickname}</td>
            <td>${profile.age}</td>
            <td>${profile.gender}</td>
            <td>${profile.maritalStatus}</td>
            <td>${profile.hobbies}</td>
            <td>${profile.introduction}</td>
            <td>${profile.match}</td>
            <td></td>
        </tr>
</table>
</body>
</html>

