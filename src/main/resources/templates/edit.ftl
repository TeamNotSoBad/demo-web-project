<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/edit-control.js"></script>
 	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<style type = "text/css">
		body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #9999ff;
      }
		
		.form-edit {
        max-width: 500px;
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
    		<center><h1>${user.id}'s Profile</h1></center>
            <center><h3>Edit Page</h3></center>
    </div>
        
    <div align = "right">
    	 	<form>
  				<h4>Search User: <input type="text" name="userid">
  				<button onclick="search()">Search</button>
  			</form>
    </div>
    
    
    <div>
    	<h3>
    	<center><a href=" ">Save Profile</a><br><br></center>
    	<center><a href=" ">Upload New Picture</a><br></center>
    </div>
    
    
    <br><br>
    
    
    <div class = "container">
    	<form class = "form-edit">
    	<h3>Your name is ${user.firstName} ${user.lastName}. <br>
		<button onclick="changeName()" class="btn btn-primary btn-md">Change Name</button><br><br>
	
		Your classes are . . . <br>
		<button onclick="changeClasses()"class="btn btn-primary btn-md">Change Classes</button><br><br>
		
		Your times available are . . . <br>
		<button onclick="changeTime()"class="btn btn-primary btn-md">Change Time Available</button><br><br>
		
		Your major is ${user.major}.<br>
		<button onclick="changeMajor()"class="btn btn-primary btn-md">Change Major</button><br><br>
    	
    	<button onclick="changePassword()"class="btn btn-primary btn-md">Change Password</button><br><br>
    	</form>
    	
    </div>

        
</body>

</html>