function search(){
	var userId = $('#input_id').val(); 
	var searchType = $('#searchType').val();
	
	alert(userId);
	
	if(searchType === "id"){
		$.ajax(
			{
				type : "GET",
				url : "/search/id/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://localhost:8080/results/id/" + userId;
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
				url : "/search/major/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://localhost:8080/results/major/" + userId;
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
					window.location.href = "http://broncostudy.com/results/course/" + userId;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
	}
	if(searchType === "commonCourses"){
		$.ajax(
			{
				type : "GET",
				url : "/search/commoncourses/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/commoncourses/" + userId;
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
	if(searchType === "groupID"){
		$.ajax(
			{
				type : "GET",
				url : "/search/groupid/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/groupid/" + userId;
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



function addClass(){

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
