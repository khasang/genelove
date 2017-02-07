
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />

    <meta name="viewport" content="width=device-width">

    <!-- Google Web Font Embed -->
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,600,500,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/home_main.css">
</head>
<body>
<div id="main-wrapper">
  <jsp:include page="layout/header.jsp"/>
      <div class="row">
          <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-4 col-md-offset-4 templatemo-content-wrapper">
              <div class="templatemo-content">

                  <section id="home-text" class="active templatemo-content-section">
    <div class="col-sm-12 col-md-12 col-lg-12">
        <h2>Zinadine Zidane <button type="button" class="btn btn-default" aria-label="Left Align">
            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
        </button></h2>
        <hr>
        <div class="col-sm-4 col-md-4">
            <div id="Photo">
                    <img id="picture" class="img-thumbnail" alt="Profile picture" src="resources/images/Zidane.jpg" width="200" height="200" />
            </div>
            <hr>
            <button id="edit" class="btn btn-raised btn-info">
              <p><span class="glyphicon glyphicon-send"></span> Send Message</p>
            </button>
        </div>
        <div class="col-sm-8 col-md-8" text-center>
            <h3>Email : test@mail.com</h3>
            <hr>
            <h4>City : Madrid</h4>
            <h4>Date birth : 20.03.1974</h4>
            <h4>Phone : 074-567-32-35</h4>
            <h4>Roles : USER,ADMINISTRATOR</h4>
            <h4><a href="#">My Friends</a></h4>


        </div>
    </div>
</section>
                  </div>
              </div>
          </div>


    <jsp:include page="layout/footer.jsp"/>

</div><!-- /#main-wrapper -->


<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery.backstretch.min.js"></script>
<script src="resources/js/templatemo_script.js"></script>
<!-- templatemo 398 nature -->
</body>
</html>
