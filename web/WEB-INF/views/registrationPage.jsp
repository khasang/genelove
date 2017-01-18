<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="register" class="animate form" >
    <form:form  action="/postRegistration" method="post" modelAttribute="user" accept-charset="UTF-8">
        <h2> Sign up </h2>
        <p>
            <label for="login" class="form-control" data-icon="u"><span>Login</span></label>
            <input id="login" name="login" required="required" type="text" placeholder="Login name" />
        </p>
        <p>
            <label for="email" class="form-control" data-icon="e" ><span>Your email</span></label>
            <input id="email" name="email" required="required" type="email" placeholder="example@mail.com"/>
        </p>
        <p>
            <label for="password" class="form-control" data-icon="p"><span>Your password</span></label>
            <input id="password" name="password" required="required" type="password" placeholder=""/>
        </p>
        <p>
            <label for="firstName" class="form-control" data-icon="u"><span>First name</span></label>
            <input id="firstName" name="firstName" required="required" type="text" placeholder="Name" />
        </p>
        <p>
            <label for="lastName" class="form-control" data-icon="u"><span>Last name</span></label>
            <input id="lastName" name="lastName" required="required" type="text" placeholder="Last name" />
        </p>

        <p class="signin button">
            <input type="submit" value="Sign up"/>
        </p>

    </form:form>
</div>

</body>
</html>
