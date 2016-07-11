<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/login-control.js"></script>
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #9999ff;
      }
      
      .hero-unit {
        max-width: 600px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;

      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

		.sign_up{
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
		}
    </style>
 
    </head>

<body>    
    
    <div class = "hero-unit"> 
           <center> <h1><font color = #000000>Welcome to Study Buddy Finder</font></h1></center>
    </div>
           
    <center><img src="http://imgur.com/2jQYmP7.png" alt="logo"></center><br><br><br>
    
    <hr>
        
    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in!</h2>
        <input type="text" class="input-block-level" placeholder="Username" id="input_name">
        <input type="password" class="input-block-level" placeholder="Password" id ="input_password"><br>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>    			
        <input type="button" value="Log-in" onclick="login()">
      </form>

    </div>

	<br><br>
	<div class = "sign_up">
	<a href="http://localhost:8080/signup">Sign Up For A Study Buddy Account Now!</a>
    </div>    
</body>

</html>