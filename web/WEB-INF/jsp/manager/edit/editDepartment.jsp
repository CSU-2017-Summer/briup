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
    <title>方向</title>
</head>
<body>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>方向管理>编辑</h3>
        <c:out value="${vi.id}+${vi.name}..."></c:out>
        <input id="newDepartment" value="${vi.id}" style="display: none;">
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tbody>
                <tr>
                    <th class="tc"><span>部门名称</span></th>
                    <td class="tc"><input id="add_type_name" type="name" value="${vi.name}"></td>
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
        var id = $('#newDepartment').val();
        var department = {};
        department['department.id'] = 0;
        if(id)
            department['department.id'] = id;
        department['department.name'] = n;

        $.get("/saveDepartment.action",department,function () {
            alert("修改成功");
            $(".right").load("/manageDepartment.action");
        });

    }

    function back() {
        $(".right").load("/manageDepartment.action");
    }
</script>
</body>
</html>
