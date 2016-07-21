<html>

<head>
    <title>User Page</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/user-control.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	
    
	<style type = "text/css">
		body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #993600;
      }
		
		.div-major {
		position: absolute;
		right: 300px;
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
        
        .div-currentclasses {
      	position: relative;
      	left: 500px;
      	top: 200px;
      	width: 500px;
      	height: 300px;
      	max-width: 500px;
      	max-height: 300px;
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
        
        .form-search{
      	position: absolute;
      	right: 300px;
      	top: -50px;
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
        
        
        .div-friends {
        position: absolute;
		margin-left: auto;
		margin-right: auto;
		left: 0;
		right: 0;
		bottom: 200px;
      	max-width: 400px;
      	height: 300px;
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
        
        .div-groups {
        position: absolute;
        left: 300px;
        bottom: 150px;
        width: 400px;
      	max-width: 400px;
      	height: 300px;
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
        
        .messages{
        position: absolute;
        left: 300px;
        top: 200px;
        
        width: 400px;
      	max-width: 400px;
      	height: 300px;
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
        .profile-picture{
    	position: absolute;
    	bottom: 100px;
    	}
      
	</style>
</head>
            <center><h1>Viewing ${user.firstName} ${user.lastName}'s Profile</h1></center>

    <div style="background-image:url(http://i.imgur.com/VCpnBOv.jpg); 
    background-size:cover;">


<body>    
    
    <div class = "messages">
    	<input type="text" placeholder = "Message to" id = "input_receiverId"><br><br>
    	<input type="text" placeholder = "Send Message" id = "input_message"><br><br>
		<button onclick="sendMessage()" class="btn btn-primary btn-md" input type ="button">Send Message</button><br><br>
    </div>
    <div>
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
    
    <center><div = "profile-picture">
    	<h3> Profile Picture </h3>
    	<img src="https://www.drupal.org/files/profile_default.jpg" alt="ProfPic">
    </div></center>
    
    </div>
    
    <div class = "div-major">
    	<table class =  "table table-hover">
    		<tr>
    			<td> Major </td>
    		<tr>
    		<tr>
    			<td>${user.major}</td>
    		</tr>
    	</table>
    </div>

    <div class = "div-currentclasses">
    	<table class =  "table table-hover">
    			<tr>
    				<td> Current Classes </td>
    			<tr>
    			<#list user.classes as class>
    			<tr>
    				<td>${class}</td>
    			</tr>
    			</#list>
    	</table>
    </div>
    
    
    <div class = "div-friends">
    	<table class =  "table table-hover">
    			<tr>
    				<td> Friends </td>
    			<tr>
    			<tr>
    				<#if friends??>
    					<#list friends as friend>
    						<#if friend??>
    							<td><a href = "http://broncostudy.com/user/${friend}">${friend}</a></td>
    						</#if>	
    					</#list>
    					<#else>
    						<td>No Users</td>
    				</#if>
    			</tr>
    	</table>
    </div>
    
    <div class = "div-groups">
    	<table class =  "table table-hover">
    			<tr>
    				<td> Groups </td>
    			<tr>
    			<tr>
    				<#if groups??>
    					<#list groups as group>
    						<#if group??>
    							<td><a href = "http://broncostudy.com/user/${group}">${group}</a></td>
    						</#if>	
    					</#list>
    					<#else>
    						<td>No Users</td>
    				</#if>
    			</tr>
    	</table>
    </div>
	
    
    <div style="background-image:url(http://i.imgur.com/TAWBsxN.jpg); 
    background-size:cover;width:100%;height:300px;">
        
</body>

</html>