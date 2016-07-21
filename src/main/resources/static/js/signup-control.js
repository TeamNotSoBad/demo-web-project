function addUser() {

	var userId = $('#input_id').val();
	var userFirst = $('#input_first').val();
	var userLast = $('#input_last').val();
	var userMajor = $('#majorType').val();
	var userPW = $('#input_password').val();
	var userConfirmPW = $('#input_confirmpw').val();
	var compare = userPW.localeCompare(userConfirmPW);
	
	if(userId.length == 9 && userFirst.length > 1 && userFirst.length < 15 && userLast.length > 1 && userLast.length < 15 && userPW.length > 3){
	if(userMajor != "default"){
	alert($('#majorType').val());
		if (userId && userFirst && userLast && userMajor && userPW && userConfirmPW && compare === 0) {
		$.ajax(
				{
					type : "POST",
					url  : "/user/" + userId,
					data : {
						"userFirst" : userFirst,
						"userLast" : userLast,
						"userMajor" : userMajor,
						"userPW" : userPW
					},
					success : function(result) {
					alert("Valid User");
					document.cookie = "user="+userId+"; expires= Wed, 20 July 2017 00:00:00 GMT";
					window.location.href = "http://localhost:8080/edit/" + userId;
					},
					error: function (jqXHR, exception) {
					alert("Invalid Info");
					}
				}
				);
	} 
	else if(compare != 0){
		alert("Passwords do not match");
	}
	else {
		alert("Invalid user");
	}
	}
	else{
		alert("Input Major");
	}
	}
	else if(userId.length != 9){
		alert("Bronco ID is 9 digits in length.");
	}
	else if(userFirst.length <= 1 || userFirst.length >= 15 || userLast.length <= 1 || userLast.length >= 15){
		alert("User first/last name must be 2-14 characters long");
	}
	else if(userPW.length <= 3){
		alert("Password must be at least 4 characters long");
	}
}
