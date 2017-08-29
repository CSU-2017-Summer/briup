<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/24
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

    .c已审核{
        color:green;
    }

    .c未审核{
        color:red;
    }


</style>

            <div class="Catalog_right">
                <div class="Catalogtitle">
                    总计<em>${count}</em>道题&nbsp;&nbsp;
                    提示：单击显示答案和解析&nbsp;&nbsp;
                    <input type="checkbox" class="showanswer"/><b>显示答案和解析</b>&nbsp;&nbsp;
                    <div><i>1</i><a href="#" class="pageone">前</a><a href="#" class="pagetwo">后</a></div></div>

                <!-- start here  -->

                <c:set var="index" value="0" scope="request"></c:set>
                <c:forEach items="${subjects}" var="subject">
                    <div class="Catalog_rightnei" id="${subject.id}">
                        <div class="Catalogtitwo">
                            <b>题号：</b>${subject.id}&nbsp;&nbsp;
                            <b>题型：</b>${subject.subjectType.realName}&nbsp;&nbsp;
                            <b>难度：</b>${subject.subjectLevel.realName}&nbsp;&nbsp;
                            <b>审核状态：</b><span class="c${subject.checkState}" id="${subject.id}checkit">${subject.checkState}</span>&nbsp;&nbsp;
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
                                        <c:forEach items="${subject.choices}" var="choice">
                                            <li>
                                                    ${choice.getContent()}
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                                <div class="answerpart">
                                    <b>正确答案：</b>
                                    <c:if test="${subject.subjectType.id==3}">
                                        ${subject.answer}
                                    </c:if>

                                    <c:set var="arrayvalue" value="A,B,C,D,E,F,G,H" />
                                    <c:set var="delim" value="," />
                                    <c:set var="array" value="${fn:split(arrayvalue,delim)}" />

                                    <c:set var="i" value="0"></c:set>
                                    <c:if test="${subject.subjectType.id!=3}">
                                        <c:forEach items="${subject.getChoices()}" var="c">
                                            <%--${c.correct},${array[i]},,--%>
                                            <c:if test="${c.correct== 'true' }">
                                                ${array[i]}
                                            </c:if>
                                            <span style="visibility: hidden">${i=i+1}</span>
                                        </c:forEach>
                                    </c:if>
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

//    function addProblem() {
//        $(".right").load("/addSubject.action");
//    }
    $(function () {
       $(".answerpart").hide();
    });


    function pass(id){
        var url = "subject.id="+id+"&subject.checkState=已审核";
        console.log("changeCheckState.action?"+url);
        $.post("changeCheckState.action?"+url,function () {
            $("#"+id+"checkit").html("已审核");
            $("#"+id+"checkit").removeClass("c未审核");
            $("#"+id+"checkit").addClass("c已审核");
        });
    }

    function notpass(id){
        var url = "subject.id="+id+"&subject.checkState=未审核";
        console.log("changeCheckState.action?"+url);
        $.post("changeCheckState.action?"+url,function () {
            $("#"+id+"checkit").html("未审核");
            $("#"+id+"checkit").removeClass("c已审核");
            $("#"+id+"checkit").addClass("c未审核");
        });
    }

    function deleteit(id){
        $("#"+id).hide();
        var url = "subject.id="+id;
        alert("删除题目"+id+"?");
        $.post("deleteSubject.action?"+url);
    }

    $(".showanswer").change(function () {
       if($(".showanswer").prop("checked")==true){
           console.log("checked");
           $(".answerpart").show();
       }
       else{
           console.log("unchecked");
           $(".answerpart").hide();
       }
    });


</script>
