<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/27
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">

        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tbody>
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>试题名称</span></th>
                    <th  class="tc" width="300" ><span>试题描述</span></th>
                    <th class="tc"><span>所属方向</span></th>
                    <th class="tc"><span>创建时间</span></th>
                    <th class="tc"><span>答题时间</span></th>
                    <th class="tc"><span>总分</span></th>

                </tr>
                <c:forEach items="${papers}" var="paper">
                <tr id="tr${paper.id}">
                    <td class="tc"><input type="checkbox" id="check${paper.id}" onchange="checkpaper(${paper.id})"></td>
                    <td class="tc">${paper.title}</td>
                    <td class="tc">${paper.description}</td>
                    <td class="tc">${paper.department.name}</td>
                    <td class="tc">${paper.createTime}</td>
                    <td class="tc">${paper.answerQuestionTime}</td>
                    <td class="tc">${paper.totalPoints}</td>
                </tr>
                </c:forEach>
                <%--<tr>--%>
                    <%--<td class="tc"><input type="checkbox"></td>--%>
                    <%--<td class="tc">Html阶段测试试卷</td>--%>
                    <%--<td class="tc">主要测试HTML与DIV,CSS的内容</td>--%>
                    <%--<td class="tc">WebUI方向</td>--%>
                    <%--<td class="tc">2016-3-20</td>--%>
                    <%--<td class="tc">60min</td>--%>
                    <%--<td class="tc">100</td>--%>
                <%--</tr>--%>


                </tbody>
            </table>
        </div>
        <div class="btn_left">
            <span class="btnL"><em class="btnR" onclick="deletepaper()">删除</em></span>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
</div>
<script>
    deletes = new Set();

    function checkpaper(id){
        if($("#check"+id).prop("checked")==true){
            deletes.add(id);
        }
        else{
            deletes.delete(id);
        }
    }

    function deletepaper(){
//        console.log(deletes);
        var str="";
        var i=0;
        deletes.forEach(function(d){
            console.log(d);
            str+="&";
            str+="papers["+i+"].id="+d;
            i=i+1;
            $("#tr"+d).hide();
        });
        console.log("/deletePaper.action?"+str);
        $.get("/deletePaper.action?"+str);
    }

</script>