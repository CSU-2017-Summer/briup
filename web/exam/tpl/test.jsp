<%--
  Created by IntelliJ IDEA.
  User: Liuqi
  Date: 2017/8/23
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script type="text/javascript" src="/exam/frameworks/jquery-2.1.4/jquery.js"></script>
    <script type="text/javascript" src="/exam/js/test.js"></script>
    <title>test</title>
</head>
<body>
    <%--<a href="javascript:void(0)" id="a">test</a>--%>

    <div>
        <select>
            <!-- test -->
            <c:forEach items="${types}" var="vi">
                <option value="${vi.id}">${vi.realName}</option>
            </c:forEach>
        </select>
    </div>
    <button id="a">aaaaa</button>
</body>
</html>
