function uploadImage(){
    
    var file = document.getElementById("image");
    
    $.ajax(
        {
        type : "POST",
        url  : "/uploadImageTest1",
        data : {
                 "file" : file
                },
        success : function(result) {
                alert("Did it");
                    alert("It works");
                    window.location.href = "http://broncostudy.com";
                },
        error : function (jqXHR. exception) {
                alert("Didn't work");
                }
        }
    );

}