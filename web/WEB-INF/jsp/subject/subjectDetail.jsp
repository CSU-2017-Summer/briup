<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/24
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


</style>

            <div class="Catalog_right">
                <div class="Catalogtitle">
                    总计<em>15552</em>道题&nbsp;&nbsp;
                    提示：单击体面可显示答案和解析&nbsp;&nbsp;
                    <input type="checkbox" ng-model="isShow"/><b>显示答案和解析</b>&nbsp;&nbsp;
                    <div><i>1</i><a href="#" class="pageone">前</a><a href="#" class="pagetwo">后</a></div></div>

                <!-- start here  -->

                <c:set var="index" value="0" scope="request"></c:set>
                <c:forEach items="${subjects}" var="subject">
                    <div class="Catalog_rightnei" id="${subject.id}">
                        <div class="Catalogtitwo">
                            <b>题号：</b>${subject.id}&nbsp;&nbsp;
                            <b>题型：</b>${subject.subjectType.realName}&nbsp;&nbsp;
                            <b>难度：</b>${subject.subjectLevel.realName}&nbsp;&nbsp;
                            <b>审核状态：</b><span style="color:red" class="checkit">${subject.checkState}</span>&nbsp;&nbsp;
                            <b>上传人：</b>${subject.user}&nbsp;&nbsp;
                            <b>上传时间:</b>${subject.uploadTime}&nbsp;&nbsp;
                        </div>
                        <div class="Catalogcontent">
                            <div class="Catalogcontentup">
                                <!--题干-->
                                    ${index=index+1} 、${subject.stem}
                                <!--题目选项-->
                                <c:if test="${subject.subjectType.id!=3}">
                                    <ul>
                                            <%--<c:forTokens var="i" delims="," items="A,B,C,D"></c:forTokens>--%>
                                            <%--<c:set var="array" value="A,B,C,D"></c:set>--%>
                                        <c:forEach items="${subject.getChoices()}" var="choice">
                                            <!-- TODO add ABCD prefix -->
                                            <li>
                                                    ${choice.content}
                                            </li>

                                        </c:forEach>
                                    </ul>
                                </c:if>
                                <div ng-show="isShow">
                                    <b>正确答案：</b>
                                        ${subject.answer}
                                    <br>
                                    <b>答案解析：</b>
                                        ${subject.analysis}
                                </div>
                            </div>
                            <div class="Catalogcontentdown">
                                <a href="javascript:void(0)" onclick="pass(${subject.id})">审核通过</a>
                                <a href="javascript:void(0)" onclick="notpass(${subject.id})">审核不通过</a>
                                <a href="javascript:void(0)" onclick="deleteit(${subject.id})">删除题目</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="clear"></div>

<script>
    var typeid = 0;
    var departmentid = 0;
    var levelid = 0;
    var topicid = 0;


    function addProblem() {
        $(".right").load("/addSubject.action");
    }


    function pass(id){
        $("#"+id+" .checkit").html("已审核");
        var url = "subject.id="+id+"&subject.checkState=已审核";
        console.log("changeCheckState.action?"+url);
        $.post("changeCheckState.action?"+url);
    }

    function notpass(id){
        $("#"+id).hide();
    }

    function deleteit(id){
        $("#"+id).hide();
        var url = "subject.id="+id;
        $.post("deleteSubject.action?"+url);
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


    <%--$("#submit-query").click(function () {--%>
        <%--typeid=${typeid};--%>
        <%--levelid=${levelid};--%>
        <%--departmentid = ${departmentid};--%>
        <%--topicid=${topicid};--%>
        <%--console.log("in detail page "+"type:"+typeid+" level"+levelid+" department:"+departmentid+" topic:"+topicid);--%>
        <%--var url="subject.department.id="+departmentid+"&subject.subjectLevel.id="+levelid+"&subject.subjectType.id="+typeid+"&subject.topic.id="+topicid;--%>
        <%--$.post("/subjectDetail.action?"+url,function(){--%>
<%--//            $(".Catalog").load("getDetail.action");--%>
        <%--});--%>
    <%--});--%>


</script>
