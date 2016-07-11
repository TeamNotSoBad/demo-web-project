function login(input_name){
	var userName = $('#input_name').val();
	var userPW = $('#input_password').val();
	
	if(userName){
		window.location.replace("http://localhost:8080/edit/" + userName);
	}
	else{
		alert("Invalid User.");
	}	
}