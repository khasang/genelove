<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Genelove</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="menuPage"><span class="glyphicon glyphicon-home"></span>Home</a></li>
                <li><a href="menuPage"><span class="glyphicon glyphicon-tree-deciduous"></span>My Tree</a></li>
                <li><a href="myProfile"><span class="glyphicon glyphicon-user"></span>My profiles</a></li>
               <li><a href="#"><span class="glyphicon glyphicon-envelope"></span>Messages <span class="badge">10</span></a></li>
                <li><a href="${pageContext.request.contextPath}/account/find">
                    <span class="glyphicon glyphicon-heart"></span>Find Love
                </a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>
</head>