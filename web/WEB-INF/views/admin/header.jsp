<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    function aboutPopup() {
        alert("About Form");
    }
</script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin">Genelove: Administration Screen</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/admin">Home</a></li>
                <li><a onclick="aboutPopup()">About</a></li>
                <li><a href="/admin/usersList">Users List</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
            <div class="col-sm-3 col-md-3 pull-right">
                <form action="/admin/usersList" class="navbar-form" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search By Login" name="filter" id="filter">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</nav>
