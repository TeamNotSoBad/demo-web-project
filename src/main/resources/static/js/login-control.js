function login(input_name){
	var userName = $('#input_name').val();
	var userPW = $('#input_password').val();
	
	if(userName){
		window.location.href = "http://broncostudy.com/edit/" + userName;
	}
	else{
		alert("Invalid User.");
	}	
}
