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
    <title>知识</title>
</head>
<body>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>知识管理>编辑</h3>
        <input id="newTopic" value="${vi.id}" style="display: none;">
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tbody>
                <tr>
                    <th class="tc"><span>知识点</span></th>
                    <td class="tc"><input id="add_type_name" type="name" value="${vi.title}"></td>
                </tr>
                <tr>
                    <th class="tc"><span>所属方向</span></th>
                    <td class="tc">
                    <select id="topicAdd_selectDepartment">


                        <c:forEach items="${departments}" var="de">

                                <option
                                        <c:if test="${de.id == vi.department.id}">
                                            selected="selected"
                                        </c:if>
                                        value="${de.id}" id="option_departments">${de.name}</option>

                        </c:forEach>

                    </select>
                    </td>
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
        var id = $('#newTopic').val();
        var did = $('#topicAdd_selectDepartment option:selected') .val();
        var topic = {};
        topic['topic.id'] = 0;
        if(id)
            topic['topic.id'] = id;
        topic['topic.title'] = n;
        topic['topic.department.id'] = did;

        $.get("/saveTopic.action",topic,function () {
            alert("修改成功");
            $(".right").load("/manageTopic.action");
        });

    }

    function back() {
        $(".right").load("/manageTopic.action");
    }
</script>
</body>
</html>
