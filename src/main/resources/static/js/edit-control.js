function search(){
	var userId = $('#input_id').val(); 
	var searchType = $('#searchType').val();
	var userMajor = $('#majorType').val();
	
	alert(userId);
	
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
				url : "/search/classes/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/classes/" + userId;
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

function chooseDepartment(){
	
}



function addClass(){;
	var dep = $('#depType').val();
	var classNum = $('#input_classNumber').val();
	alert("Adding " + dep + classNum);
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

function changeTime(){
}

function changeMajor(){
	var userMajor = $('#majorType').val();
	alert(userMajor);
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
	alert("Trying to create " + groupId + " by " + userId);
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

