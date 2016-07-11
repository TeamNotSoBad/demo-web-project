function addUser() {

	var userName = $('#input_name').val();
	var userMajor = $('#input_major').val();
	var userPW = $('#input_password').val();
	var userConfirmPW = $('#input_confirmpw').val();
	var compare = userPW.localeCompare(userConfirmPW);
	
	
	if (userName && compare != -1) {
		$.ajax(
				{
					type : "POST",
					url  : "/user/" + userName,
					data : {
						"userName" : userName,
						"userMajor" : userMajor,
						"userPW" : userPW
					},
					success : function(result) {
					alert("Valid User");
					window.location.replace("http://broncostudy.com/edit/" + userName);
					},
					error: function (jqXHR, exception) {
					alert("Invalid Info");
					}
				}
				);
	} 
	else if(compare == -1){
		alert("Passwords do not match");
	}
	else {
		alert("Invalid user");
	}
				
}

function test(){
	
						window.location.assign("http://google.com/");
}
