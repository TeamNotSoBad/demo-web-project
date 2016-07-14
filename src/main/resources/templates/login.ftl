<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/login-control.js"></script>
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #993600;
      }
      
      .hero-unit {
        max-width: 750px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;

      }
      
	.form-signin {
      	position: relative;
      	top: 175px;
        max-width: 500px;
        max-height: 650px;
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
      .div-horse{
		position: absolute;
		top: 500px;
		right: 350px;
		z-index: -1;
		}
      
      .form-signin .form-signin-heading,{
        margin-bottom: 20px;
      }
      .form-signin .checkbox {
      	position: relative;
      	left: 30px;
      	bottom: 90px;
      	font-size: 20px;
      }
      .form-signin-heading{
      	position: relative;
      	bottom: 130px;
      	margin-bottom: 15px;
      	padding: 7px 9px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        position: relative;
        bottom: 130px;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
      
      .div-login{
      	position: relative;
      	bottom: 140px;
      	left: 250px;
      	}

	.div-signup{
        position: relative;
        bottom: 10px;
		}
		
    </style>
 
    </head>

<body>    
    
    <div class = "hero-unit"> 
          <img src = "http://imgur.com/bvw2ROM.png" alt = "logo" align = "left" width="850" height="200">
    </div>
          
          	
    
        
    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in!</h2>
        <input type="text" class="input-block-level" placeholder="Username" id="input_name">
        <input type="password" class="input-block-level" placeholder="Password" id ="input_password"><br>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>    			
        <div class = "div-login">
        	<input type="button" value="Log-in" onclick="login()" class = "btn btn-primary btn-lg">
        </div>
      </form>

    </div>

	<br><br>
	<div class = "div-signup">
	<center><a href="http://broncostudy.com/signup">Sign Up For A Study Buddy Account Now!</a></center>
    <br><br><br><br>    
    <center> <h7><font color = #000000>By Mark Ilog, Henry Hu, Kevin Liu, Thomas Nguyen</font></h7></center>
    </div>
    
    <div class = "div-horse">
    	<center><img src = "http://imgur.com/OCDbKGs.png" alt = "logo" align = "left" width="1400" height="750"></center>
   	</div>
    	
</body>

</html>
