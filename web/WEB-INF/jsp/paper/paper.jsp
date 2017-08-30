<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/29
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <title>4-2练习批阅</title>
    <link rel="stylesheet" type="text/css" href="/exam/theme/1/css/common.css">
    <link rel="stylesheet" type="text/css" href="/exam/theme/1/css/style.css">
    <link rel="stylesheet" type="text/css" href="/exam/theme/1/css/EditingArea.css">
    <link rel="stylesheet" type="text/css" href="/exam/theme/1/css/table.css">
    <link rel="stylesheet" type="text/css" href="/exam/theme/1/css/icon.css">
    <link rel="stylesheet" type="text/css" href="/exam/theme/1/css/zy.css">
    <script type="text/javascript" src="/exam/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="/exam/js/jquery.easyui.min.js"></script>
    <script type="text/javascript"  src="/exam/theme/1/js/base.js"></script>
    <style>
        body{ background: #ffffff;}
    </style>
</head>

<body>
<div class="main">
    <div class="editingarea">
        <div class="PaperPreview">
            <%--<div class="PaperPreviewtop">--%>
                <%--<div class="PaperPreviewlogo"></div>--%>
            <%--</div>--%>
            <div class="PaperPreviewtitle">${exampaper.description}</div>
        </div>
        <div class="c_editview">
            <div class="Previewpage">
                <%--<div class="Previewpage_leftwo">--%>
                    <%--shu--%>
                <%--</div>--%>
                <div class="Previewpage_right" style="margin-right: 50px;">
                    <div class="Previewpage_rightwo"  style="margin-left: 0px;">
                        <div class="Previewpagebox">${exampaper.title}</div>
                        <div class="Previewpagebox3">
                            <h4>总分：${exampaper.totalPoints} 时间：${exampaper.answerQuestionTime} 小时</h4>
                        </div>
                        <div class="Previewpagebox3">
                            <h3>第一卷选择题</h3>
                            <c:if test="${types[0]==1}">
                                <h4>单选题<h4/>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${examsubjects}" var="subject">
                                    <c:if test="${subject.subjectType.id == 1}">
                                    <div class="Previewpagecontentwo">
                                    <div class="Prev_tit">${i=i+1}、${subject.stem}</div>
                                    <c:set var="j" value="1"></c:set>
                                    <c:forEach items="${subject.choices}" var="choice">
                                    <div class="Prev_answer">
                                        <c:if test="${j == 1}">
                                            <div class="Prev_answer_ac"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <c:if test="${j == 2}">
                                            <div class="Prev_answer_bd"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <DIV class="clear"></DIV>
                                    </div>
                                    <div class="Prev_answer">
                                        <c:if test="${j == 3}">
                                            <div class="Prev_answer_ac"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <c:if test="${j == 4}">
                                            <div class="Prev_answer_bd"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <DIV class="clear"></DIV>
                                    </div>
                                    </c:forEach>
                                </div>
                            </c:if>
                            </c:forEach>
                            </c:if>
                            <c:if test="${types[1]==1}">
                                <h4>多选题</h4>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${examsubjects}" var="subject">
                                    <c:if test="${subject.subjectType.id == 2}">
                                    <div class="Previewpagecontentwo">
                                    <div class="Prev_tit">${i=i+1}、${subject.stem}</div>
                                    <c:set var="j" value="1"></c:set>
                                    <c:forEach items="${subject.choices}" var="choice">
                                    <div class="Prev_answer">
                                        <c:if test="${j == 1}">
                                            <div class="Prev_answer_ac"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <c:if test="${j == 2}">
                                            <div class="Prev_answer_bd"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <DIV class="clear"></DIV>
                                    </div>
                                    <div class="Prev_answer">
                                        <c:if test="${j == 3}">
                                            <div class="Prev_answer_ac"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <c:if test="${j == 4}">
                                            <div class="Prev_answer_bd"><div class=""></div>${choice.content}</div>
                                        </c:if>
                                        <DIV class="clear"></DIV>
                                    </div>
                                </c:forEach>
                                </div>
                            </c:if>
                            </c:forEach>
                            </c:if>
                        </div>



                        <div class="Previewpagebox3">
                            <c:if test="${types[2]==1}">
                                <h3>第二卷简答题</h3>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${examsubjects}" var="subject">
                                    <c:if test="${subject.subjectType.id == 3}">
                                        <div class="Previewpagecontentwo">
                                            <div class="Prev_tit">${i=i+1}、${subject.stem}</div>
                                            <div class="Prev_answertwo"><em>学生答题：</em><div class="Prev_answerthree">  </div></div>
                                            <div class="Prev_answertwo"><b>老师批阅：</b><div class="Prev_answerthree"></div></div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="btn_left" style="float: right">
                            <span class="btnL"><em class="btnR">提交</em></span><span class="btnL"><em class="btnR">取消</em></span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(".btnR").click(function () {
//        alert("提交试卷成功！");
        window.location.href="/indexAction.action";
    })
</script>

