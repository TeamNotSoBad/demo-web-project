function addFriend(user){

$.ajax(
			{
				type : "POST",
				url  : "/cs480/user/" + user,
				data : {
				},
				success : function(result) {
					location.reload();
				},
				error: function (jqXHR, exception) {
					alert("Failed to delete the photo.");
				}
			});
}