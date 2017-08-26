var typeid = 0;
var departmentid = 0;
var levelid = 0;
var topicid = 0;


function addProblem() {
    $(".right").load("/addSubject.action");
}

function getType(id){
//        console.log(id);
    typeid = id;
}

function getTopic(id) {
//        console.log(id);
    topicid = id;
}

function getDepartment(id) {
//        console.log(id);
    departmentid = id;
}

function getLevel(id) {
//        console.log(id);
    levelid = id;
}

$(".alldepartments").click(function () {
    departmentid = 0;
})

$(".alltopics").click(function () {
    topicid = 0;
})

$(".alllevels").click(function () {
    levelid = 0;
})

$(".alltypes").click(function () {
    typeid = 0;
})

$(".a-types").click(function () {
//        console.log($(this).text());
    $(".a-types").removeClass("active3");
    $(this).addClass("active3");
});

$(".a-levels").click(function () {
//        console.log($(this).text());
    $(".a-levels").removeClass("active3");
    $(this).addClass("active3");
});

$(".a-departments").click(function () {
//        console.log($(this).text());
    $(".a-departments").removeClass("active3");
    $(this).addClass("active3");
});

$(".a-topics").click(function () {
//        console.log($(this).text());
    $(".a-topics").removeClass("active3");
    $(this).addClass("active3");
});


$("#submit-query").click(function () {
    console.log("type:"+typeid+" level"+levelid+" department:"+departmentid+" topic:"+topicid);
    var url="subject.department.id="+departmentid+"&subject.subjectLevel.id="+levelid+"&subject.subjectType.id="+typeid+"&subject.topic.id="+topicid;
    $.post("/subjectDetail.action?"+url,function(){
        $(".Catalog").load("getDetail.action");
    });
})
