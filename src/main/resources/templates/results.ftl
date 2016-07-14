<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/results-control.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	 <style type="text/css">
	 body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #9999ff;
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

<body ng-controller = "ResultsCtrl">    
    
    <div class = "header">
            <center><h1>Results</h1></center>
    </div>
        
    <div class = "form-search">
            <form>
  			Search For: <input type="text" name="input_id">
  			<button onclick="search()">Search</button>
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
	     <#list users as user>
	     	<tr>
	       		<td><a href = "http://broncostudy.com/edit/${user.id}">${user.id}</a></td>
	        	<td>${user.firstName}</td>
	        	<td>${user.lastName}</td>
	        	<td>${user.major}</td>
	        	<td>Place Holder</td>
	        	<td>Message placeholder</td>
	        </tr>
	      </#list>  
  </table>
</div>

        
</body>

</html>