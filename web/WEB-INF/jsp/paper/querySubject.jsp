<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/27
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
        <tbody>
        <tr>
            <th  class="tc" width="300" ><span>试题描述</span></th>
            <th class="tc"><span>题型</span></th>
            <th class="tc"><span>考核知识点</span></th>
            <th class="tc"><span>认知水平</span></th>
            <th class="tc"><span>分数</span></th>
            <th class="tc"><span>操作</span></th>
        </tr>
        <c:forEach items="${subjects}" var="s">
        <tr >

            <td class="tc">${s.stem}</td>
            <td class="tc">${s.subjectType.realName}</td>
            <td class="tc">${s.topic.title}</td>
            <td class="tc">${s.subjectLevel.realName}</td>
            <td class="tc"><input type="text" id="point${s.id}"/></td>
            <td class="tc"><div class="Onlinee"><a href="#" class="jians" onclick="addSub(${s.id})" id="add${s.id}">天假</a><a href="#" class="yioan" onclick="removeSub(${s.id})" id="remove${s.id}">天假</a></div></td>

        </tr>
        </c:forEach>

        </tbody>
    </table>

<script>
    subjects = new Set();

    function addSub(id) {
        console.log("click add "+id);
        subjects.add(id);
        console.log($("#add"+id).length);
        console.log(subjects);
        $("#add"+id).css({"background-img":"briup\\web\\exam\\theme\\1\\images\\icon\\addsub.ico"});

    }

    function removeSub(id){
        console.log("click remove "+id);
        subjects.delete(id);
        console.log(subjects);
        //TODO return to unadded status
        $("$add"+id).css({"background-img":"briup\\web\\exam\\theme\\1\\images\\zy\\vdvd.png"});
    }

</script>
