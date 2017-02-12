<html>
<head>
    <title>Profile</title>
    <jsp:include page="../include/head.jsp"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>

<table>
    <tr>
        <td>Nickname</td>
        <td>Date of Birth</td>
        <td>Gender</td>
        <td>Marital Status</td>
        <td>Hobbies</td>
        <td>Introduction</td>
        <td>Match</td>
    </tr>
    <tr>
        <td>${profile.nickname}</td>
        <td>${profile.dateOfBirth}</td>
        <td>${profile.gender}</td>
        <td>${profile.maritalStatus}</td>
        <td>${profile.hobbies}</td>
        <td>${profile.introduction}</td>
        <td>${profile.match}</td>
        <td></td>
    </tr>
</table>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>

