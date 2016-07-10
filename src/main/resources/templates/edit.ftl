<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/edit-control.js"></script>
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
    		<center><h1>${user.name}'s Profile</h1></center>
            <center><h3>Edit Page</h3></center>
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
    
    <hr>
    
    
    
    
    <div class = "container">
    	<form class = "form-edit">
    	Your username is currently ${user.name}. <br>
		Name: <br><input type="text" name ="username">
		<button onclick="changeName()">Save</button><br><br>
	
		Your classes are currently . . . <br>
		Classes: <br><input type="text" name ="userclasses">
		<button onclick="changeClasses()">Save</button><br><br>
		
		Your times available are currently . . . <br>
		Times Available: <br><input type="text" name ="usertime">
		<button onclick="changeTime()">Save</button><br><br>
		
		Your major is currently ${user.major}.<br>
		Major: <br><input type="text" name ="usermajor">
		<button onclick="changeMajor()">Save</button><br><br>
    	</form>
    </div>

        
</body>

</html>