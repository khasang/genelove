<jsp:include page="header_r.jsp"/>
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

