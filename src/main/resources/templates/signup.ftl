<html>

<head>
    <title>Sign Up</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/signup-control.js"></script>
    
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
      </style>
</head>

<body>    


    <div class = "welcome">
    	<center><h1><font color = #000000>Sign Up Now!</font></h1>
    </div>

	<hr>

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

</html>