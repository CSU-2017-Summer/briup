<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
        <script src="/exam/frameworks/jquery-2.1.4/jquery.min.js"></script>
        <script src="/exam/frameworks/angular-1.4.0/angular.min.js"></script>
        <script src="/exam/frameworks/angular-1.4.0/angular-route.min.js"></script>
</head>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="Topictitle">添加题目</div>
    <div class="c_editview">
        <div class="Problem">
            <div class="Attributetit">题目属性</div>
            题目类型
            <select class="subjectAdd_select" id="subjectAdd_selectType" onchange="changeSubjectType()">
                <!-- test -->
                <c:forEach items="${types}" var="vi">
                    <option value="${vi.id}" id="option_types">${vi.realName}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
            难度级别
            <select id="subjectAdd_selectLevel">
                <c:forEach items="${levels}" var="vi">
                    <option value="${vi.id}" id="option_levels">${vi.realName}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
            所属方向
            <select id="subjectAdd_selectDepartment">
                <c:forEach items="${departments}" var="vi">
                    <option value="${vi.id}" id="option_departments">${vi.name}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
            所属知识点
            <select id="subjectAdd_selectTopic">
                <c:forEach items="${topics}" var="vi">
                    <option value="${vi.id}" >${vi.title}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
        </div>
        <div class="Problem">
            <div class="Attributetit">题目题干</div>
            <div class="Problemcontent">
                <textarea ng-model="subject.stem"
                          id = "textarea_stem"
                          cols="60" rows="4"></textarea>
            </div>
        </div>
        <!--单选视图-->
        <div class="Answeroptions" id="oneselect" ng-show="subject.typeId==1">
            <div class="Attributetit">答案选项<em>(通过勾选每个选项下面的框难吃时间点咳嗽打开)</em></div>
            <div class="c_condition"><span class="icon_add"><em class="icon_r" style="float: left">添加选项</em></span></div>
            <div class="Answercontent">
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>A</p><span>
                        <input value="0" name="correct" type="radio" class="oneselect-check" /></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea cols="40" rows="4" class="oneselect-input"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>B</p><span>
                        <input  value="1" name="correct" type="radio" class="oneselect-check" /></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="oneselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>C</p><span>
                        <input value="2" name="correct" type="radio" class="oneselect-check" /></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="oneselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>

                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>D</p><span>
                        <input value="3" name="correct" type="radio"  class="oneselect-check"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="oneselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <!--多选视图-->
        <div class="Answeroptions" id="multiselect" ng-show="subject.typeId==2">
            <div class="Attributetit">答案选项<em>(通过勾选每个选项下面的框难吃时间点咳嗽打开)</em></div>
            <div class="c_condition"><span class="icon_add"><em class="icon_r" style="float: left">添加选项</em></span></div>
            <div class="Answercontent">
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>A</p><span>
                        <input  value="0" name="correct" type="checkbox" class="multiselect-check"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="multiselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>B</p><span>
                        <input select-option  value="1" name="correct" type="checkbox" class="multiselect-check" /></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="multiselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>C</p><span>
                        <input  value="2" name="correct" type="checkbox"  class="multiselect-check"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="multiselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>

                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>D</p><span>
                        <input  value="3" name="correct" type="checkbox" class="multiselect-check" /></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="multiselect-input"
                                  cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <div class="Problem" ng-show="subject.typeId==3" id="div-answer">
            <div class="Attributetit">标准答案</div>
            <div class="Problemcontent">
                <textarea id = "textarea-answer"
                          cols="60" rows="4"></textarea>
            </div>
        </div>

        <div class="Problem">
            <div class="Attributetit">答案解析</div>
            <div class="Problemcontent">
                <textarea ng-model="subject.fx"
                          id = "textarea-problemcontent"
                          cols="60" rows="4"></textarea>
            </div>
        </div>

        <div class="btn_left">
            <span class="btnL">
                <em class="btnR" ng-click="submit()" onclick="saveSubject()">保存并继续</em>
            </span>
            <span class="btnL">
                <em class="btnR" ng-click="submitAndClose()">保存并关闭</em>
            </span>
        </div>
    </div>
</div>
<script>
    $(function(){
        $("#multiselect").hide();
        $("#div-answer").hide();
        $("#oneselect").show();
    });

    function changeSubjectType(){
//        console.log("type changed...");
        var type = $("#subjectAdd_selectType").val();
//        console.log("type:"+type);
        switch (type){
            case "1":
//                console.log("case 1");
                $("#div-answer").hide();
                $("#multiselect").hide();
                $("#oneselect").show();
                break;
            case "2":
//                console.log("case 2");
                $("#div-answer").hide();
                $("#oneselect").hide();
                $("#multiselect").show();
                break;
            case "3":
//                console.log("case 3");
                $("#div-answer").show();
                $(".Answeroptions").hide();
                break;
        }
    }

    function saveSubject(){
        var type = $("#subjectAdd_selectType").val();
        var topic = $("#subjectAdd_selectTopic").val();
        var department = $("#subjectAdd_selectDepartment").val();
        var level = $("#subjectAdd_selectLevel").val();
        var stem = $("#textarea_stem").val();
        var answer = $("#textarea-answer").val();
        var problemcontent = $("#textarea-problemcontent").val();

        var choicecontent=new Array();
        var choicecorrect=new Array();
        var i = 0;
        var j = 0;
        if(type == 1) {
            $(".oneselect-input").each(function () {
//                console.log($(this).val());
                choicecontent[i++] = ($(this).val());
            })
//            console.log("choicecontent:"+choicecontent);

            var val = $('.oneselect-check:radio[name="correct"]:checked').val();
//            console.log("val:"+val);
            var size = $(".oneselect-check").size();
//            console.log("size:"+size);
            for(var i=0;i<size;i++){
                if(i!=val){
                    choicecorrect[i]=false;
                }
                else{
                    choicecorrect[i]=true;
                }
            }
//            console.log("choicecorrect:"+choicecorrect);
        }
        else if(type==2){
            $(".multiselect-input").each(function(){
//                console.log($(this).val());
                choicecontent[i++] = ($(this).val());
            })
//            console.log("choicecontent:"+choicecontent);

            var i = 0;
            $(".multiselect-check").each(function () {
                if($(this).is(':checked')) {
                    choicecorrect[i++]=true;
                }
                else
                    choicecorrect[i++]=false;
            })
//            console.log("choicecorrect:"+choicecorrect);
        }
        else{
            choicecontent=null;
            choicecorrect=null;
//            console.log("select jiandati");
//            console.log("choicecontent:"+choicecontent);
        }


        var obj = {}
        obj['subject.subjectType.id']=type;
        obj['subject.subjectLevel.id'] = level;
        obj['subject.department.id'] = department;
        obj['subject.topic.id'] = topic;
        obj['subject.stem'] = stem;
        obj['subject.analysis'] = problemcontent;
        obj['subject.answer'] = answer;
        obj['choiceContent'] = choicecontent;
        obj['choiceCorrect'] = choicecorrect;

        console.log("type:"+type+" "+"level:"+level+" "+"department:"+department+" "+"topic:"+topic);
        console.log("stem:"+" "+stem+" "+" answer:"+answer+" "+" problemconten:"+problemcontent);
        console.log("choiceContent:"+choicecontent);
        console.log("choiceCorrect:"+choicecorrect);

        var url="";
        if(type!=3) {
            for (var i = 0; i < choicecorrect.length; i++) {
                url += "choices["+i+"].correct=" + choicecorrect[i] +"&choices["+i+"].content="+choicecontent[i];
                url += "&";
            }
        }
        url+="subject.analysis="+problemcontent+"&subject.answer="+answer+"&subject.department.id="+department+"&subject.stem="+stem+"&subject.subjectLevel.id="+level+"&subject.subjectType.id="+type+"&subject.topic.id="+topic;
        console.log(url);
        $.get("/saveSubject.action?"+url,
            function () {
            console.log("submit data...");
        })

    }




</script>