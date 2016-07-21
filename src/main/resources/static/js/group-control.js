function sendMessage(){
	var userId = document.cookie.split("user=").pop();
	var userMessage = $('#input_message').val();
	var receiverId = $('group.groupName').val();
	
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