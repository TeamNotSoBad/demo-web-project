<html>

<head>
    <title>Edit Page</title>
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
      	position: absolute;
      	right: 380px;
      	top: 100px;
      	width: 500px;
      	max-width: 500px;
        padding: 20px 29px 29px;
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
		position: absolute;
		left: 300px;
		top: 200px;
		width: 500px;
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
      
      .message-container{
      	position: absolute;
      	right: 380px;
      	bottom: 100px;
      	width:800px;
      	max-width: 1000px;
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
      }
      table {
        width: 100%;
    }
    
    .profile-picture{
    	position: absolute;
    	bottom: 100px;
    	}
    
    .majors{
    	position: absolute;
    	right: 1px;
    	bottom: 100px;
    }
    

thead, tbody, tr, td, th { display: block; }

tr:after {
    content: ' ';
    display: block;
    visibility: hidden;
    clear: both;
}

thead th {
    height: 30px;

    /*text-align: left;*/
}

tbody {
    height: 300px;
    overflow-y: auto;
}

thead {
    /* fallback */
}


tbody td, thead th {
    width: 19.2%;
    float: left;
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
    <center><div = "profile-picture">
    	<h3> Profile Picture </h3>
    	<img src="https://www.drupal.org/files/profile_default.jpg" alt="ProfPic">
    </div></center>
        
   <div class = "form-search">
            <form>
  			Search For: <input type="text" id="input_id"><br><br>
  			Choose Major:
    				<select id = "majorType">
    					<#list majors as majors>
  							<option value=${majors}>${majors}</option>
  						</#list>
					</select>
					<br><br>
			Search By:
  			<select id = "searchType">
  				<option value="id">User ID</option>
  				<option value="major">Major</option>
  				<option value="firstName">First name</option>
  				<option value="lastName">Last name</option>
  				<option value="course">Course</option>
  				<option value="groupName">Group Name</option>
			</select>
			
			<button onclick="search()" class="btn btn-primary btn-lg" input type ="button">Search</button><br><br>
  			</form>
    </div>
    
    
    <br><br>
    
    
    <div class = "container">
    	<form class = "form-edit">
    	<h3>Your name is ${user.firstName} ${user.lastName}. </h3>
    	<h5>First Name</h5>
    	<input type="text" placeholder = "First Name" id = "input_firstName"><br>
    	<input type="text" placeholder = "Last Name" id = "input_lastName"><br>
		<button onclick="changeName()" class="btn btn-primary btn-md" input type = "button">Change Name</button><br><br>
		Your classes are 
			<#list classes as class> 
				<h7>${class}</h7>,
			</#list>
		<div class = "div-class">
    		<select id = "depType">
    			<#list majors as majors>
  					<option value=${majors}>${majors}</option>
  				</#list>
			</select>
			<input type="text" placeholder = "Class Number" id = "input_classNumber"><br>
			<button onclick="addClass()"class="btn btn-primary btn-md">Add Classes</button>
			<br>
		</div>
		
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
    	
    	
		<input type="password" placeholder = "Password" id = "input_PW"><br><br>
		<input type="password" placeholder = "Confirm Password" id = "input_confirmPW"><br><br>
    	<button onclick="changePassword()"class="btn btn-primary btn-md">Change Password</button><br><br>

    	<h5> Create group </h5>
    	<input type="text" placeholder = "Group Name" id = "input_groupId"><br>
		<button onclick="createGroup()" class="btn btn-primary btn-md" input type = "button">Create Group</button>

    	</form>
    	
    </div>

<div class = "message-container">
 <table class="table table-hover">
 		<thead>
   		<tr class = "success">
   			<th>Sent From</th>
   			<th>Sent To</th>	
   			<th>Time Sent</th>                    
	        <th>Message</th>
	     </tr>
	     </thead>
	     <tbody>
	     	<#if messages??>
	     		<#list messages as message>
	     			<#if message??>
	     			<tr>
	     				<td class = "filterable-cell">${message.from}</td>
	     				<td class = "filterable-cell">${message.to}</td>
	     				<td class = "filterable-cell">${message.time}</td>
	     				<td class = "filterable-cell">${message.message}</td>
	     			</tr>
	     			</#if>
	      		</#list>
			</#if>
		</tbody> 
  </table>
  </div>

        
</body>

</html>