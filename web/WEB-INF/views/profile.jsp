<jsp:include page="testViews/head.jsp"/>
<body style="background: url(images/loveFone.jpg) no-repeat fixed center;" >
<jsp:include page="header.jsp"/>
<div class="container" id="myProfile">
    <div class="left">
        <div id="Photo">
                <img id="picture" alt="Profile picture" src="/images/Zidane.jpg" width="200" height="200" />
        </div>
        <button id="edit" class="btn btn-raised btn-success glyphicon glyphicon-tree-deciduous">
            Gender Tree
        </button>
    </div>
    <hr>
    <h2>Zinedine Zidane</h2>
    <hr>
    <h3>Birth : 23 June 1972</h3>
        <h3>Age : 44</h3>
    <h3>City : Madrid</h3>
            <h3>About Me: </h3>
            <div id="description" class="content">
                <p>I was named the FIFA World Player of the Year three times, in 1998, 2000 and 2003, and won the 1998 Ballon d'Or.
                    He was Ligue 1 Player of the Year in 1996, Serie A Footballer of the Year in 2001 and La Liga Best Foreign Player in 2002<p>
            </div>


</div>

    <jsp:include page="footer.jsp"/>

</body>
</html>
