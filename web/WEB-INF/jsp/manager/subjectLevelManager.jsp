<%--
  Created by IntelliJ IDEA.
  User: xfeif
  Date: 2017/8/26
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>难度管理</title>
</head>
<body>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>难度管理</h3>
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tbody>
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>名称（英文）</span></th>
                    <th  class="tc" width="300" ><span>真实名称（中文）</span></th>
                </tr>
                <c:forEach items="${levels}" var="vi">
                <tr>
                    <td class="tc"><input name="manId" type="checkbox" value="${vi.id}"></td>
                    <td class="tc">${vi.name}</td>
                    <td class="tc">${vi.realName}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="btn_left">
            <span class="btnL"><em class="btnR" onclick="editLevel(0)">添加</em></span>
            <span class="btnL"><em class="btnR" onclick="editLevel(1)">修改</em></span>
            <span class="btnL"><em class="btnR" onclick="deleteLevel()">删除</em></span>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
</div>
</body>
<script>
    function editLevel(id){
        if(id>0){
            var cd = document.getElementsByName('manId');
            var value = new Array();
            for(var i = 0; i < cd.length; i++){
                if(cd[i].checked)
                    value.push(cd[i].value);
            }
            id = value[0];
        }
        if(id!=null){
            $(".right").load("/toEditLevel.action?subjectLevel.id="+id);
        } else {
            alert("请选择修改项");
        }

    }

    function deleteLevel(){
        var cd = document.getElementsByName('manId');
        var value = new Array();
        for(var i = 0; i < cd.length; i++){
            if(cd[i].checked)
                value.push(cd[i].value);
        }

        var id = value[0];
        if(id!=null){

            var y = confirm("确认删除"+id +"?");
            var param = "";
            var i=0;
            value.forEach(function(s){
                param+="&";
                param+="subjectLevels["+i+"].id="+s;
                i=i+1;
            });
            if(y){
                $.get("/delLevel.action?"+param,function () {
                    alert("删除成功");
                    $(".right").load("/manageLevel.action");
                });
            }
        } else {
            alert("请选择删除项");
        }

    }
</script>
</html>
