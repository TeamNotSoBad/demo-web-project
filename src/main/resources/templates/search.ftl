<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/search-control.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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

<body>    
    
    <div class = "header">
            <center><h1>Search Results</h1></center>
    </div>
        
    <hr>
        
    <div class = "form-search">
            <form>
  			Search For: <input type="text" name="userid">
  			<button onclick="search()">Search</button>
  			</form>
    </div>
    
    <hr>
    
    <div class="container">
  <h2>Users Found:</h2>
  <table class="table table-hover">
    <thead>
      <tr>
      	<th>Name</th>
        <th>Major</th>
        <th>Classes currently taking</th>
        <th>Rating</th>
        <th>Message this person</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>CS</td>
        <td>CS480</td>
        <td>5/5</th>
        <th></th>
      </tr>
      <tr>
        <td>Sam</td>
        <td>Mechanical Engi.</td>
        <td>Mat 216</td>
        <td>3/5</th>
        <th></th>
      </tr>
      <tr>
        <td>Joanna</td>
        <td>Math</td>
        <td>Mat 370</td>
        <td>4/5</th>
        <th></th>
      </tr>
    </tbody>
  </table>
</div>

        
</body>

</html>