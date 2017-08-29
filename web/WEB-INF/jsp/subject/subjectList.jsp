<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/24
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<style>
    .Catalogcontentup ul{
        margin: 15px;
    }
    .Catalogcontentup ul li{
        line-height: 22px;
    }
    .chose a.active3{
        color:#ffffff;
        border:1px solid #41810a;
        background-color: #6ca620;
        -moz-border-radius:2px;
        -webkit-border-radius:2px;
        border-radius:2px;  }

    #submit-query{
        color:#ffffff;
        border:1px solid #41810a;
        background-color: #6ca620;
        -moz-border-radius:2px;
        -webkit-border-radius:2px;
        border-radius:2px;  }

    a:hover{
        cursor:pointer;
        text-decoration: none !important;
    }

    #submit-query:hover{
        cursor:pointer;
    }


</style>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <div class="c_condition">
            <span><select><option>题干</option></select></span>
            <span class="pl5 " ><input type="text" class="inputstem"></span>
            <span class="icon_add">
                <em class="icon_r">
                    <a href="javascript:void(0)" onclick="addProblem()">单个添加题目</a>
                </em>
            </span>
        </div>
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tablea">
                <tr>
                    <td align="center" style="width: 50px;">题型</td>
                    <td align="left">
                        <div class="chose">
                            <a href="javascript:void(0)"
                               class="a-types active3 alltypes">全部</a>
                            <c:forEach items="${types}" var="vi">
                                <a class="a-types" href="javascript:void(0)" onclick="getType(${vi.id})">${vi.realName}</a>
                            </c:forEach>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center">难度</td>
                    <td align="left">
                        <div class="chose">
                            <a href="javascript:void(0)"
                               class="a-levels active3 alllevels">全部</a>
                            <c:forEach items="${levels}" var="vi">
                                <a class="a-levels" id="type_${vi.id}" onclick="getLevel(${vi.id})">${vi.realName}</a>
                            </c:forEach>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center">方向</td>
                    <td align="left">
                        <div class="chose">
                            <a href="javascript:void(0)"
                               class="a-departments active3 alldepartments">全部</a>
                            <c:forEach items="${departments}" var="vi">
                                <a class="a-departments" onclick="getDepartment(${vi.id})">${vi.name}</a>
                            </c:forEach>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center">知识点</td>
                    <td align="left">
                        <div class="chose">
                            <a href="javascript:void(0)"
                               class="a-topics active3 alltopics">全部</a>
                            <%--<a href="#/AllSubject/a/{{params.a}}/b/{{params.b}}/c/{{params.c}}/d/{{topic.id}}"--%>
                               <%--class="{{params.d==topic.id?'active3':''}}" ng-repeat="topic in topics">{{topic.title}}</a>--%>
                            <c:forEach items="${topics}" var="vi">
                                <a class="a-topics" onclick="getTopic(${vi.id})">${vi.title}</a>
                            </c:forEach>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2" class="active3" ><input type="submit" value="确定" id="submit-query"></td>
                </tr>
            </table>
        </div>
        <div class="Catalog">


            <div class="clear"></div>
        </div>
    </div>
</div>

<script>
    var typeid;
    var departmentid;
    var levelid;
    var topicid;

    console.log("reload");

    //console.log("test:"+ ${typeid});

    if(typeid==undefined) typeid=0;
    if(departmentid==undefined) departmentid=0;
    if(levelid==undefined) levelid=0;
    if(topicid==undefined) topicid=0;



    function addProblem() {
        var path = "parentdir=subjectList&file=subjectAdd.jsp";
        $(".right").load("/addSubject.action?"+path);
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
        console.log("in list page "+"type:"+typeid+" level"+levelid+" department:"+departmentid+" topic:"+topicid);
        var stem = $(".inputstem").val();
        stem = encodeURIComponent(stem);
        var url="subject.department.id="+departmentid+"&subject.subjectLevel.id="+levelid+"&subject.subjectType.id="+typeid+"&subject.topic.id="+topicid+"&subject.stem="+stem;
        console.log(url);
        $.post("/subjectDetail.action?"+url,function(){
            $(".Catalog").load("/getDetail.action");
        });
    })

</script>
