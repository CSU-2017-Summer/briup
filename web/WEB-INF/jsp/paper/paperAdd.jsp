<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/26
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--{{pmodel}}-->
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="Topictitle">添加试卷</div>
    <div class="c_editview">
        <div class="information">
            <div class="informationtop">
                <b style="float:left">试卷名称：</b>
                <b><input type="text" class="paper_title" style="width: 310px"/></b>
            </div>
            <div class="informationdown">
                <div class="informationdownleft">
                    <b style="float:left">试卷说明：</b>
                    <b><textarea class="paper_description" ></textarea></b>
                </div>

                <div class="clear"></div>
            </div>
            <div class="informationtop">
                <b style="float:left">所属方向：</b>
                <b>
                    <select id="paperAdd_selectDepartment">
                        <option value="0">请选择</option>
                        <c:forEach items="${departments}" var="vi">
                            <option value="${vi.id}" id="paperoption_departments">${vi.name}</option>
                        </c:forEach>
                    </select>
                </b>
            </div>
            <div class="informationtop">
                <b style="float:left">考试时间：</b>
                <b>
                    <input type="text" class="paper_time"  >小时
                </b>
            </div>
        </div>
        <div class="c_condition">
            <b style="float: right">
                <span class="pl5">试卷总分：</span>
                <span class="pl5">
                    <input type="text" class="paper_total" /></span>
            </b>
            <span class="icon_add" style="float: left">
                <em class="icon_r" style="float: left">
                    <a href="javascript:void(0)" onclick="addProblem()">添加题目</a>
                </em>
            </span>
            <span class="icon_add" style="float: left"><em class="icon_r" style="float: left">试卷预览</em></span>
        </div>
        <div class="divtable">

        </div>
        <div class="btn_left">
            <span class="btnL"><em class="btnR" onclick="savePaper()">保存</em></span>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
</div>

<script>
    departmentid=0;
    $("#paperAdd_selectDepartment").change(function () {
        var de = $("#paperAdd_selectDepartment").val();
        departmentid = de;
        if(de!=0)
//        $(".querysubject").load("/querySubject.action?subject.department.id="+de);
//        $(".right").load("/paperAdd.action?subject.department.id="+de);
        $.get("/querySubject.action?subject.department.id="+de,function (data) {
            $(".divtable").html(data);
        })
    });

    function addProblem() {
        var path="parentdir=paperAdd&file=paperAdd.jsp";
        console.log("/addSubject.action?"+path);
        $(".right").load("/addSubject.action?"+path);
    }

    function savePaper() {
        var i=0;
        var str = "";
        var description = $(".paper_description").val();
        var title = $(".paper_title").val();
        var time = $(".paper_time").val();
        var total = $(".paper_total").val();

        subjects.forEach(function (s) {
            var point = $("#point"+s).val();
            str+="&";
            str+="paperSubjects["+i+"].score="+point+"&paperSubjects["+i+"].subject.id="+s;
            i=i+1;
        });



        var param = "paper.title="+title+"&paper.description="+description+"&paper.totalPoints="+total+"&paper.answerQuestionTime="+time+"&paper.department.id="+departmentid;
        console.log("/saveExampaper.action?"+param+str);
        $.get("/saveExampaper.action?"+param+str,function () {
            $(".right").load("paperManager.action");
        });

    }
</script>
