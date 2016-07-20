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
  	
	<script>	
	var userId = ${user.id};
	if(document.cookie != "user="+userId){
		alert("Invalid Location");
		window.location.href = "http://broncostudy.com/";
	}
	</script>
	<style type = "text/css">
		body {
        padding-top: 10px;
        padding-bottom: 10px;
        background-color: #993600;
      }
      
      .form-search{
      	max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        margin-top: 200px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
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
      
      .nametitle {
      }
	</style>
</head>

<body>

    <div style="background-image:url(http://i.imgur.com/bevNIx6.jpg); 
    background-size:cover;width:100%;height:300px;">    
    
    <div class = "nametitle">
    		<center><h1>${user.firstName} ${user.lastName}'s Profile</h1></center>
    		<center><h3># ${user.id}</h3></center>
            <center><h3>Edit Page</h3></center>
    </div>
        
   <div class = "form-search">
            <form>
  			Search For: <input type="text" id="input_id">
  			<br>
  			<select id = "searchType">
  				<option value="id">User ID</option>
  				<option value="major">Major</option>
  				<option value="firstName">First name</option>
  				<option value="lastName">Last name</option>
  				<option value="course">Course</option>
  				<option value="commonCourses">Common Courses</option>
  				<option value="groupName">Group Name</option>
  				<option value="groupID">Group ID</option>
			</select>
			<button onclick="search()" class="btn btn-primary btn-md" input type ="button">Search</button><br><br>
  			</form>
    </div>
    
    
    <div>
    	<h3>
    	<center><a href=" ">Upload New Picture</a><br></center>
    </div>
    
    
    <br><br>
    
    
    <div class = "container">
    	<form class = "form-edit">
    	<h3>Your name is ${user.firstName} ${user.lastName}. </h3><br>
    	<h5>First Name</h5><br>
    	<input type="text" placeholder = "First Name" id = "input_firstName"><br><br>
    	<input type="text" placeholder = "Last Name" id = "input_lastName"><br><br>
		<button onclick="changeName()" class="btn btn-primary btn-md" input type = "button">Change Name</button><br><br>
	
		Your classes are . . . <br>
		<div class = "div-class">
		<button onclick="changeClasses()"class="btn btn-primary btn-md">Add Classes</button>
    		<select id = "depType">
    			<option value="default">Choose Department</option>
    			<#list majors as majors>
  					<option value=${majors}>${majors}</option>
  				</#list>
			</select>
			<select id = "class">
				<option value="default">Choose your class</option>
    			<#list classes as classes>
  					<option value=${classes}>${classes}</option>
  				</#list>
			</select>
			<br><br>
		</div>
		
		Your times available are . . . <br>
		<button onclick="changeTime()"class="btn btn-primary btn-md">Change Time Available</button><br><br>
		
		<h5>Your major is ${user.major}.<h5><br>
		<div class = "div-majors">
    		<select id = "majorType">
    			<#list majors as majors>
  					<option value=${majors}>${majors}</option>
  				</#list>
			</select>
			<br><br>
		</div>
		<button onclick="changeMajor()" class="btn btn-primary btn-md" input type ="button">Change Major</button><br><br>
    	
    	<button onclick="changePassword()"class="btn btn-primary btn-md">Change Password</button><br><br>
    	</form>
    	
    </div>

    <div style="background-image:url(http://i.imgur.com/zfC3jXW.jpg); 
    background-size:cover;width:100%;height:300px;">
        
</body>

</html>