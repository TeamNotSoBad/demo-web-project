function addUser() {

	var userId = $('#input_id').val();
	var userFirst = $('#input_first').val();
	var userLast = $('#input_last').val();
	var userMajor = $('#input_major').val();
	var userPW = $('#input_password').val();
	var userConfirmPW = $('#input_confirmpw').val();
	var compare = userPW.localeCompare(userConfirmPW);
	
	
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

function test(){
	
						window.location.assign("http://google.com/");
}
