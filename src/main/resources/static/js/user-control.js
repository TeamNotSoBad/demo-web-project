function sendMessage(){
	var userId = document.cookie.split("user=").pop();
	var userMessage = $('#input_message').val();
	var receiverId = $('#input_receiverId').val();
	
	
	$.ajax(
			{
				type : "GET",
				url  : "/messages/send/" + userId,
				data : {
					"userMessage" : userMessage,
					"receiverId" : receiverId
				},
				success : function(result) {
				alert("From: " + userId + " To: " + receiverId + "Message: " + userMessage);
				},
				error: function (jqXHR, exception) {
				alert("Invalid Input");
				}
			}
			);
}

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
