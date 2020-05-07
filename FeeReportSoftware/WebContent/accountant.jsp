<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accountant Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="bootstrap.min.css"/>
    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- <nav class="navbar navbar-inverse"> -->
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">FeeReport</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="admin.html" class="active">Admin</a></li>
        <li><a href="accountant.html" class="active">Accountant</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
<!-- </nav> -->

<div class="main">
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Accountant Login</h2>
                        <form action="AccountantLogin" method="post" class="register-form" id="register-form">
					            <div class="form-group">
					              <label for="email"><i class="zmdi zmdi-email"></i></label>
					              <input type="email" name="email" id="email" placeholder="Your Email" required />
					            </div>
					            <div class="form-group">
					              <label for="pass"><i class="zmdi zmdi-lock"></i></label>
					              <input type="password" name="password" id="pass" placeholder="Password"  required />
					            </div>
					            <div class="form-group form-button">
					              <input type="submit" name="signup" id="signup" class="form-submit" value="Login"/>
					            </div>
					      </form>
                    </div>
                </div>
            </div>   
        </section>   
</div>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="js/main.js"></script>
  <script src="jquery.min.js"></script>
  <script src="bootstrap.min.js"></script>
</body>
</html>