<html>

<head>
    <title>Results Page</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/results-control.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	 <style type="text/css">
	 body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-repeat: no-repeat;
        background-size: cover;
        background-image: url("http://i.imgur.com/YpFPz3W.jpg");
        background-color: #993600;
      }

      .form-search{
      	position: absolute;
		margin-left: auto;
		margin-right: auto;
		left: 0;
		right: 0;
		top: 100px;
      	max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        margin-top: 160px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      
      .groupcontainer{
      	position: absolute;
		margin-left: auto;
		margin-right: auto;
		left: 0;
		right: 0;
		top:300px;
      	max-width: 900px;
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
      
      .container{
      	position: absolute;
		margin-left: auto;
		margin-right: auto;
		left: 0;
		right: 0;
		top:300px;
      	max-width: 900px;
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
      }
      </style>
</head>

<body> 

        
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
    <#if groups??>
    	<#list groups as group>
    	<div class="groupcontainer">
  			<h2>Groups Found:</h2>
  			<table class="table table-hover">
   			<tr class="success">	                    
	    	    <td>Group Name</td>
	    	    <td>Owner</td>
	        	<td>Members</td>
	     	</tr>
	     			<tr>
	     				<td><a href = "http://broncostudy.com/group/${group.groupName}">${group.groupName}</a>
	     				<button onclick="joinGroup('${group.groupName}')" class="btn btn-primary btn-md" input type = "button">Join Group</button>
	     	  			</td>
	     			   	<td><a href = "http://broncostudy.com/group/${group.owner}">${group.owner}</a></td>
	     			    
	     						<td>
	     							 <#list group.members as member>
	     								<#if member??>
	     									<a href = "http://broncostudy.com/group/${member}">${member}</a>
	     								</#if>
	     							</#list>		
	     						</td>
	     						
	     					</tr>
 			 </table>
	</div>
	</#list>
    </#if>	
    <#if users??>
    <div class="container">
  	<h2>Users Found:</h2>
  	<table class="table table-hover">
   		<tr class="success">	                    
	        <td>ID</td>
	        <td>First Name</td>
	        <td>Last Name</td>
	        <td>Major</td>
	        <td>Current Courses</td>
	     </tr>
	     
	     	<#list users as user>
	     		<#if user??>
	     			<tr>
	     	  			<td><a href = "http://broncostudy.com/user/${user.id}">${user.id}</a></td>
	     			   	<td>${user.firstName}</td>
	     			   	<td>${user.lastName}</td>
	     	   			<td>${user.major}</td>
	     	   					<td><#list user.classes as class> 
	     	   						<#if class??>
	     	   							<p>${class}</p>
	     	   						</#if>
	     	   						</#list>
	     	   					</td>
	        			<td><button onclick="addFriend(${user.id})" class="btn btn-primary btn-md" input type = "button">Add Friend</button></td>
	        		</tr>
	        	<#else>
	        	</#if>	
	      	</#list>
 	 </table>
	</div>
	</#if>

        
</body>

</html>