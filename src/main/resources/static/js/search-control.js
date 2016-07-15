function search(){
	var userId = $('#input_id').val(); 
	
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
