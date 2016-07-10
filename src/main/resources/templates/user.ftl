<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/user-control.js"></script>
	<style type = "text/css">
		body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #9999ff;
      }
		
		.form-edit {
        max-width: 400px;
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
      
      .form-edit input[type="text"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
      
	</style>
</head>

<body>    
    
    <div>
            <center><h1>Viewing #{user.name}'s Profile</h1></center>
    </div>
        
    <div align = "right">
    	 	<form>
  				Search User: <input type="text" name="userid">
  				<button onclick="search()">Search</button>
  			</form>
    </div>
    
    <hr>
    
    <div>
    	<center><a href=" ">Save Profile</a><br><br></center>
    	<center><a href=" ">Upload New Picture</a><br></center>
    </div>
    <div>
    <br>
    <center>
    <table border="1">            
                <tr>
                    <td>Name</td>
                    <td>Major</td> 
                    <td>Password</td> 
                </tr>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.major}</td>
                    <td>${user.password}</td>
                </tr>
      </table>
      </center>
      </div>
    
    <hr>
    
    <div class = "container">
    	<form class = "form-edit">
		Name: <br><input type="text" name ="username">
		<button onclick="changeName()">Save</button><br><br>
	
		Classes: <br><input type="text" name ="userclasses">
		<button onclick="changeClasses()">Save</button><br><br>
		
		Times Available: <br><input type="text" name ="usertime">
		<button onclick="changeTime()">Save</button><br><br>
		
		Major: <br><input type="text" name ="usermajor">
		<button onclick="changeMajor()">Save</button><br><br>
    	</form>
    </div>

        
</body>

</html>