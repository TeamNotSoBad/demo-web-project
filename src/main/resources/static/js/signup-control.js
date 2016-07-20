function addUser() {

	var userId = $('#input_id').val();
	var userFirst = $('#input_first').val();
	var userLast = $('#input_last').val();
	var userMajor = $('#majorType').val();
	var userPW = $('#input_password').val();
	var userConfirmPW = $('#input_confirmpw').val();
	var compare = userPW.localeCompare(userConfirmPW);
	
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
					window.location.href = "http://broncostudy.com/edit/" + userId;
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
