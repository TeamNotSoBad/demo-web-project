
function search(){
	var clientID = $('#userid').val();
	$a.jax(
		{
			type : "GET",
			url : "/search/by-id/" + clientID,
			data : {
			},
			success : function(result) {
				window.location.replace("http://broncostudy.com/search/by-id/" + clientID);
			},
			error : function(result){
				alert("User ID doesn't exist");
			}
			
		}
	);
}

function sendMessage(){
}
