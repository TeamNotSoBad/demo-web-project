function sendMessage(){
	var userId = document.cookie.split("user=").pop();
	var userMessage = $('#input_message').val();
	alert(receiverId);
	
	$.ajax(
			{
				type : "GET",
				url  : "/groupMessages/send/" + receiverId,
				data : {
					"userMessage" : userMessage,
					"userId" : userId
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