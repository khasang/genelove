<jsp:include page="testViews/head.jsp"/>
<body style="background: url(../resources/images/loveFone.jpg) no-repeat fixed center;" >
<jsp:include page="header.jsp"/>
<div class="container" id="myProfile">
    <div class="left">
        <div id="Photo">
            <a href="resources/images/Zidane.jpg">
                <img id="picture" alt="Profile picture" src="resources/images/Zidane.jpg" width="200" height="200" />
            </a>
        </div>
        <label class="btn btn-raised btn-success glyphicon glyphicon-folder-open">
            Select Photo
        </label>
        <input id="file-submit" style="display: none;" type="submit" value="Load Photo">
        <p id="image-msg" style="display: none;">
    </div>
    <hr>
    <h2>${currentUser.firstName} ${currentUser.lastName}</h2>
    <hr>
    <h4>Birth : 23 June 1972</h4>
    <h4>Age : 44</h4>
    <h4>My e-Mail: ${currentUser.email}</h4>
    <h4>My Account Status: ${currentUser.accountStatus}</h4>

    <h3>About Me: </h3>
    <div id="description" class="content">
                <p>I was named the FIFA World Player of the Year three times, in 1998, 2000 and 2003, and won the 1998 Ballon d'Or.
                    He was Ligue 1 Player of the Year in 1996, Serie A Footballer of the Year in 2001 and La Liga Best Foreign Player in 2002<p>
            </div>

            <button id="edit" class="btn btn-raised btn-info glyphicon glyphicon-pencil">
                edit
            </button>
</div>

    <jsp:include page="footer.jsp"/>

</body>
</html>
