function uploadImage(){

    var picture = $('#test')
    
    $.ajax(
        type : "POST",
        url  : "/uploadImageTest1",
        data : {
                        "picture" : file
                }
        success : function(result) {
                alert("Did it");
                    location.reload();
                }
        error: function (exception) {
                alert("Didn't work");
                }
    );

}