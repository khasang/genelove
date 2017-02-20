<header>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}home">Genelove</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}myProfile">Hello, Dear
                            <strong>${currentUser.firstName} ${currentUser.lastName}</strong></a></li>
                        <li><a href="${pageContext.request.contextPath}find"><span
                                class="glyphicon glyphicon-heart"></span> Find Love </a></li>
                        <li><a href="${pageContext.request.contextPath}myMessages"><span
                                class="glyphicon glyphicon-envelope"></span> Messages <span
                                class="badge">10</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}logout"><span
                                class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <%--<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 affix text-center" style="z-index: 1;">--%>
    <%--<h1 class="templatemo-site-title">--%>
    <%--${currentUser.firstName} ${currentUser.lastName}--%>
    <%--<img src="resources/images/btn-menu.png" alt="main menu" id="m-btn"--%>
    <%--class="pull-right visible-xs visible-sm">--%>
    <%--</h1>--%>
    <%--<ul id="responsive" style="display:none" class="hidden-lg hidden-md"></ul><!-- /.responsive -->--%>
    <%--</div>--%>

</header>

