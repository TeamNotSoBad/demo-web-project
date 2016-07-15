function search(){
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

function changeClasses(){
}

function changeTime(){
}

function changeMajor(){
}