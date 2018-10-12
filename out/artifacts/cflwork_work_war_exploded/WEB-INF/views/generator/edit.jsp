<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/10/19
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="modal-body">
    <form class="form-horizontal m-t" id="signupForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">作者：</label>
            <div class="col-sm-8">
                <input id="author" name="author" type="text" value="${property.author}" class="form-control" required=""
                       aria-required="true">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">邮箱：</label>
            <div class="col-sm-8">
                <input id="email" name="email" class="form-control" type="text" value="${property.email}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">包名：</label>
            <div class="col-sm-8">
                <input id="package" name="package" class="form-control" type="text" value="${property.packagename}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">自动去掉表前缀：</label>
            <div class="col-sm-8">
                <input id="autoRemovePre" name="autoRemovePre" style="width: 30px;height: 30px"
                       class="form-control" type="checkbox"
                       value="true"
                       checked="${property.autoRemovePre}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
    </form>

    <jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
    <script type="text/javascript" src="<%=path%>/static/js/pageJs/edit.js"></script>
</body>
</html>
