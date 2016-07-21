<html>

<head>
    <title>CS480 Demo Web Service</title>
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
		
		.div-major {
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
        
        .div-currentclasses {
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
        
        .div-previousclasses {
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
        
        .div-friends {
        position: relative;
        right: 700px;
        bottom: 350px;
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
        position: relative;
        right: 700px;
        bottom: 350px;
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
            <center><h1>Viewing ${user.firstName} ${user.lastName}'s Profile</h1></center>

    <div style="background-image:url(http://i.imgur.com/VCpnBOv.jpg); 
    background-size:cover;">


<body>    
    
    <div>
    
    </div>
        
    <div align = "right">
    	 	<form>
  				Search User: <input type="text" name="userid">
  				<button onclick="search()">Search</button>
  			</form>
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
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
    	</table>
    </div>
    
    <div class = "div-previousclasses">
    	<table class =  "table table-hover">
    			<tr>
    				<td> Completed Classes </td>
    			<tr>
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
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
    				<td>PLACEHOLDER</td>
    			</tr>
    	</table>
    </div>
	
	<div class = "div-messages">
    	<table class =  "table table-hover">
    			<tr>
    				<td> Messages </td>
    			<tr>
    			<tr>
    				<td>PLACEHOLDER</td>
    			</tr>
    	</table>
    </div>
    
    <div style="background-image:url(http://i.imgur.com/TAWBsxN.jpg); 
    background-size:cover;width:100%;height:300px;">
        
</body>

</html>