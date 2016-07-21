<html>

<head>
    <title>Group Page</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/user-control.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet">
    
	<style type = "text/css">
		body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #993600;
      }
		
		.div-owner {
		position: relative;
		left: 500px;
      	max-width: 700px;
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
        
        .div-admins {
        position: relative;
        left: 500px;
      	max-width: 700px;
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
        
        .div-members {
        position: relative;
        left: 500px;
      	max-width: 700px;
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

        .div-messages {
        position: relative;
        bottom: 990px;
        right: 200px;
      	max-width: 500px;
      	height: 600px;
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
      
      
	</style>
</head>

<body>    
    
    <div>
            <center><h1>Viewing ${group.groupName}'s Page</h1></center>
    </div>
        
    <div align = "right">
    	 	<form>
  				Search User: <input type="text" name="userid">
  				<button onclick="search()">Search</button>
  			</form>
    </div>
    
    <div class = "div-owner">
    	<table class =  "table table-hover">
    		<tr>
    			<td> owner </td>
    		<tr>
    		<tr>
    			<td>${group.owner}</td>
    		</tr>
    	</table>
    </div>

    
    <div class = "div-members">
    	<table class =  "table table-hover">
    			<tr>
    				<td> Members list </td>
    			<tr>
    			<#list group.members as member>
    			<tr>
    				<td><a href = "http://broncostudy.com/user/${member}">${member}</a></td>
    			</tr>
    			</#list>
    	</table>
    </div>


</body>



</html>