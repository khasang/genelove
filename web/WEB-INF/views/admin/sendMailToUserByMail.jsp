<jsp:include page="include/header.jsp"/>
<div class="container">
    <br><br><br><br>
    <jsp:include page="include/greeting.jsp"/>
        <div class="row">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-block thumbnail">
                        <h3 class="card-title">Send e-Mail to User</h3>
                        <p class="card-text">Here You can send your mail email to selected user at address:</p>
                        <p class="card-text"><strong>${mailto}</strong></p>
                        <p class="card-text">Please, fill all fields of form that is below:</p>
                        <form method="post" action="/admin/sendMail" class="input-group">
                            <input type="hidden" name="recipient" value="${mailto}"/>
                            <table border="0" align="center">
                                <tr>
                                    <td><label>Subject:</label></td>
                                    <td><input class="form-control" type="text" name="subject"/></td>
                                </tr>
                                <tr>
                                    <td><label>Message:</label></td>
                                    <td><textarea class="form-control" rows="4" name="message"></textarea></td>
                                </tr>
                            </table><br>
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit">Send e-Mail</button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-block thumbnail">
                        <h3 class="card-title">List of Users</h3>
                        <p class="card-text">Goto list of users, where administrators can see all users of Genelove project and can change their roles or delete all their data from DB:</p>
                        <a href="/admin/usersList" class="btn btn-primary">Users List</a>
                        <p></p>
                        <p class="card-text">Also administrators can filter list of users by user login:</p>
                        <form action="/admin/usersList" class="input-group">
                            <input type="text" class="form-control" placeholder="Search By Login" name="filter" id="filter">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit">Search</button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-block thumbnail">
                        <h3 class="card-title">User Card</h3>
                        <p class="card-text">Goto user card, where administrators can modify user profile. Navigation can be performed by user ID: </p>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="ID" id="id">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" onclick="gotoUserById()">Submit</button>
                            </span>
                        </div>
                        <p></p>
                        <p class="card-text">or by user Login: </p>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Login" id="login">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" onclick="gotoUserByLogin()">Submit</button>
                            </span>
                        </div>
                        <p></p>
                        <p class="card-text">If such user is not exist in the database, administrators can add new user with appropriate privileges: </p>
                        <a href="/admin/new" class="btn btn-primary">Add User</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-block thumbnail">
                        <h3 class="card-title">Statitistics</h3>
                        <p class="card-text">Total Users: ${allUsersCount}</p>
                        <p class="card-text">Blocked Users: ${blockedUsersCount}</p>
                        <p class="card-text">Administrators: ${adminUsersCount}</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-block thumbnail">
                        <h3 class="card-title">Logout</h3>
                        <p class="card-text">Logout from the current session of Genelove project:</p>
                        <a href="/logout" class="btn btn-primary">Submit</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

<script type="text/javascript">
    function gotoUserById() {
        var userId = document.getElementById("id").value;
        window.location.href = "/admin/user/id/" + userId;
        return false;
    }
    function gotoUserByLogin() {
        var userLogin = document.getElementById("login").value;
        window.location.href = "/admin/user/login/" + userLogin;
        return false;
    }
</script>

