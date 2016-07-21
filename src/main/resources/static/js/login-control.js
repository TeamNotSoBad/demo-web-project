function login(){

	var userId = $('#input_id').val();
	var userPW = $('#input_password').val();
	
	if(userId){
		document.cookie = "user="+userId+"; expires= Wed, 20 July 2017 00:00:00 GMT";
		window.location.href = "http://broncostudy.com/edit/" + userId;
	}
	else{
		alert("Invalid User.");
	}	
}
