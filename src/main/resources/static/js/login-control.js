function login(){

	var userId = $('#input_id').val();
	var userPW = $('#input_password').val();
	
	alert(document.cookie);
	
	if(document.cookie != null){
		alert("Hi");
		var usedId = document.cookie.split("user=").pop();
		window.location.href = "http://localhost:8080/edit/"+usedId;
	}
	
	if(userId){
		document.cookie = "user="+userId+"; expires= Wed, 20 July 2017 00:00:00 GMT";
		window.location.href = "http://localhost:8080/edit/" + userId;
	}
	else{
		alert("Invalid User.");
	}	
}
