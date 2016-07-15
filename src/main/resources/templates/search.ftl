<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/search-control.js"></script>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	 <style type="text/css">
	 body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #993600;
      }
      .header{
      	max-width: 500px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
      	}
      .form-search{
      	max-width: 300px;
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
      .container{
      	max-width: 900px;
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
      </style>
</head>

<body>    
    
    <div class = "header">
            <center><h1>Search</h1></center>
    </div>
        
    <div class = "form-search">
            <form>
  			Search For: <input type="text" Placeholder = "ID" id="input_id">
  			<select>
  				<option value="user">User ID</option>
  				<option value="major">Major</option>
  				<option value="firstName">First name</option>
  				<option value="lastName">Last name</option>
  				<option value="course">Course</option>
  				<option value="commonCourses">Common Courses</option>
  				<option value="groupName">Group Name</option>
  				<option value="groupID">Group ID</option>
			</select>
  			<input type = "button" value = "Search" onclick="search()">
  			</form>
    </div>
    
    <div class="container">
  <h2>Users Found:</h2>
  <table class="table table-hover">
   		<tr class="success">	                    
	        <td>ID</td>
	        <td>First Name</td>
	        <td>Last Name</td>
	        <td>Major</td>
	        <td>Current Courses/td>
	        <td>Message This person</td>
	     </tr>
	     <tr ng-repeat="s in foundUsers">
	        <td>{{s.id}}</td>
	        <td>{{s.firstname}}</td>
	        <td>{{s.lastname}}</td>
	        <td>{{s.major}}</td>
	        <td>{{s.courses}}</td>
	        <td>Message placeholder</td>
	     </tr>  
  </table>
</div>

        
</body>

</html>