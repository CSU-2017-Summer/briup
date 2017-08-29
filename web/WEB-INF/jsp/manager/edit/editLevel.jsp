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
    <title>难度</title>
</head>
<body>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>难度管理>编辑</h3>
        <input id="newSubjectLevel" value="${vi.id}" style="display: none;">
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tbody>
                <tr>
                    <th class="tc"><span>名称（英文）</span></th>
                    <td class="tc"><input id="add_type_name" type="name" value="${vi.name}"></td>
                </tr>
                <tr>
                    <th  class="tc"><span>真实名称（中文）</span></th>
                    <td class="tc" ><input id="add_type_r_name" type="realName" value="${vi.realName}"></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="btn_left">
            <span class="btnL"><em class="btnR" onclick="add()">保存</em></span>
            <span class="btnL"><em class="btnR" onclick="back()">取消</em></span>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
</div>
<script>
    function add() {
        var n = $('#add_type_name').val();
        var rn = $('#add_type_r_name').val();
        var id = $('#newSubjectLevel').val();
        var subjectLevel = {};
        subjectLevel['subjectLevel.id'] = 0;
        if(id)
            subjectLevel['subjectLevel.id'] = id;
        subjectLevel['subjectLevel.name'] = n;
        subjectLevel['subjectLevel.realName'] = rn;


        $.get("/saveLevel.action",subjectLevel,function (data) {
            alert("修改成功");
            $(".right").load("/manageLevel.action");
        });

    }

    function back() {
        $(".right").load("/manageLevel.action");
    }
</script>
</body>
</html>
