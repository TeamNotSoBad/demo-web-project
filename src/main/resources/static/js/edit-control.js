function search(){
	var userId = $('#input_id').val(); 
	var searchType = $('#searchType').val();
	var userMajor = $('#majorType').val();
	
	if(searchType === "id"){
		$.ajax(
			{
				type : "GET",
				url : "/search/id/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/id/" + userId;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}
	if(searchType === "major"){
		$.ajax(
			{
				type : "GET",
				url : "/search/major/" + userMajor,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/major/" + userMajor;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}
	if(searchType === "firstName"){
		$.ajax(
			{
				type : "GET",
				url : "/search/first/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/first/" + userId;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}
	if(searchType === "lastName"){
		$.ajax(
			{
				type : "GET",
				url : "/search/last/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/last/" + userId;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}
	if(searchType === "course"){
		$.ajax(
			{
				type : "GET",
				url : "/search/course/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/courses/" + userId;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}
	if(searchType === "groupName"){
		$.ajax(
			{
				type : "GET",
				url : "/search/groupname/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/groupname/" + userId;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}	
}

function changeName(){
	
	var userFirst = $('#input_firstName').val();
	var userLast = $('#input_lastName').val();
	if(userFirst.length > 1 && userFirst.length < 15 && userLast.length > 1 && userLast.length < 15){
		$.ajax(
					{
						type : "GET",
						url  : "/user/id/" + userId,
						data : {
							"userFirst" : userFirst,
							"userLast" : userLast
						},
						success : function(result) {
						alert("Changed Name");
						location.reload();
						},
						error: function (jqXHR, exception) {
						alert("Invalid Info");
						}
					}
					);
		}
	else if(userFirst.length <= 1 || userFirst.length >= 15 || userLast.length <= 1 || userLast.length >= 15){
		alert("User first/last name must be 2-14 characters long");
	}
}


function addClass(){;
	var dep = $('#depType').val();
	var classNum = $('#input_classNumber').val();
	alert("Adding " + dep + classNum);
	if(classNum.length == 3){
	$.ajax(
				{
					type : "GET",
					url  : "/user/classes/" + userId,
					data : {
						"dep" : dep,
						"classNum" : classNum
					},
					success : function(result) {
					alert("Added Class");
					location.reload();
					},
					error: function (jqXHR, exception) {
					alert("Invalid Info");
					}
				}
				);
	}
	else if(classNum != 3){
		alert("Class number invalid");
	}
}

function changeMajor(){
	var userMajor = $('#majorType').val();
	$.ajax(
				{
					type : "GET",
					url  : "/user/major/" + userId,
					data : {
						"userMajor" : userMajor
					},
					success : function(result) {
					alert("Changed Major");
					location.reload();
					},
					error: function (jqXHR, exception) {
					alert("Invalid Info");
					}
				}
				);
}

function createGroup(){
	var groupId = $('#input_groupId').val();
	if(groupId.length >= 8 && groupId.length <= 20){
	$.ajax(
				{
					type : "POST",
					url  : "/group/" + groupId,
					data : {
						"userId" : userId
					},
					success : function(result) {
					alert("Created Group " + groupId);
					window.location.href = "http://broncostudy.com/group/" + groupId;
					},
					error: function (jqXHR, exception) {
					alert("Invalid Info");
					}
				}
				);
	}
	else if(groupId.length < 8 || groupId.length > 20){
		alert("Group name must be between 8 and 20 characters long");
	}
}

function changePassword(){
	var password= $('#input_PW').val();
	var confirmPW = $('#input_confirmPW').val();
	var compare = password.localeCompare(confirmPW);
	
	if(compare == 0 && password.length >= 4){
		$.ajax(
				{
					type : "POST",
					url  : "/password/" + userId,
					data : {
						"password" : password
					},
					success : function(result) {
					alert("Password Changed");
					location.reload();
					},
					error: function (jqXHR, exception) {
					}
				}
				);
		}
	else if(compare != 0){
		alert("Passwords do match.");
	}
	else if(password.length <= 4){
		alert("Passwords need to be at least of length 4");
	}
}
