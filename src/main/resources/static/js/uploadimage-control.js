function uploadImage(){
    
    var pic = document.getElementsByName("test");
    
    $.ajax(
        {
        type : "POST",
        url  : "/uploadImageTest1",
        data : {
                 "pic" : file
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