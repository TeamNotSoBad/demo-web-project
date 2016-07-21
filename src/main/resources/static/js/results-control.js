function joinGroup(groupName){
	var userId = document.cookie.split("user=").pop();
	alert(userId + " wants to join " + groupName);
	
	
	$.ajax(
			{
				type : "POST",
				url : "/join/" + groupName,
				data : {
					"userId" : userId
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/group/" + groupName;
				},
				error : function(exception){
					alert("Invalid Input.");
				}
			}
		);
}

function addFriend(userFriend){
	var userId = document.cookie.split("user=").pop();
	alert(userId + " friends " + userFriend);
$.ajax(
			{
				type : "GET",
				url  : "/user/friends/" + userId,
				data : {
					"userFriend" : userFriend
				},
				success : function(result) {
					alert("Friend request sent.");
				},
				error: function (jqXHR, exception) {
					alert("Failed.");
				}
			});
}



function search(){
	var userId = $('#input_id').val(); 
	var searchType = $('#searchType').val();
	
	alert($('#searchType').val());
	
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
				url : "/search/major/" + userId,
				data : {
				},
				success : function(result) {
					window.location.href = "http://broncostudy.com/results/major/" + userId;
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