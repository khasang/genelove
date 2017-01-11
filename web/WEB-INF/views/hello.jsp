<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<p>hello</p>
<blockquote>
   <div class="container">
     <div class="row">
        <div class="col-lg-4"> </div>
        <div class="col-lg-4"> </div>
        <div class="col-lg-4"> </div>
        <p>${hello}</p>
     </div>
   </div>
</blockquote>
<jsp:include page="footer.jsp"/>
</body>
</html>