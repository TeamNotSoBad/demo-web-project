<html>

<head>
    <title>Sign Up</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/signup-control.js"></script>
    
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    
    <style type = "text/css">
    	body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #993600;
      }
      
      .welcome {
      	max-width: 600px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
       }
       
      .form-signup {
        max-width: 350px;
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
       .form-signin .form-signin-heading{
        margin-bottom: 10px;
      }
      .form-signin input[type="text"]
       {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
      
      .bbanner {
      	background-image:url("http://i.imgur.com/xApJxft.jpg");
    	background-size: cover;
      }

      </style>
</head>

<body>    


    <div class = "welcome">
    	<center><h1><img src ="http://i.imgur.com/q3r2qlw.jpg" width="500" height="200"></font></h1>
    </div>


    <div class= "container">
    		<form class = "form-signup">   			
    			<h7 class = "form-signin-heading">If you wish to join, please input valid information.</h7><br><br>
    			<input type="text" placeholder = "Bronco ID" id = "input_id"><br><br>
    			<input type="text" placeholder = "First Name" id = "input_first"><br><br>
    			<input type="text" placeholder = "Last Name" id = "input_last"><br><br>
    			<div class = "div-majors">
    				<select id = "majorType">
    					<option value="default">Choose Your Major </option>
    					<#list majors as majors>
  							<option value=${majors}>${majors}</option>
  						</#list>
					</select>
					<br><br>
				</div>	
    			<input type="password" placeholder = "Password" id="input_password"><br><br>
    			<input type="password" placeholder = "Confirm Password" id="input_confirmpw"><br><br>
    			<input type="button" value="Sign Up" onclick="addUser()">

    		</form>
   	</div>
</body>
	<banner>
	
	<div style="background-image:url(http://i.imgur.com/xApJxft.jpg); 
    background-size:cover;width:100%;height:300px;">    

</div>
    
    
</html>