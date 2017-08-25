


$(document).ready(function () {
    $("#a").click(function () {
        console.log("test");
        $.post("/exam/manager/getAllSubjectType.action",null,function(data){
            console.log("send success");
            console.log(data);
        })
    });
    }
);