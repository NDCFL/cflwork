<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/10/16
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>新增权限</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="signupForm">
                        <input id="parentId" name="parentId" type="hidden" value="${pId}">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">上级菜单：</label>
                            <div class="col-sm-8">
                                <input id="" name="" class="form-control" type="text" value="${pName}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">菜单类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control">
                                    <option name="type" value="0">目录</option>
                                    <option name="type" value="1">菜单</option>
                                    <option name="type" value="2">按钮</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">菜单名称：</label>
                            <div class="col-sm-8">
                                <input id="name" name="name" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">链接地址：</label>
                            <div class="col-sm-8">
                                <input id="url" name="url" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">权限标识：</label>
                            <div class="col-sm-8">
                                <input id="perms" name="perms" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">排序号：</label>
                            <div class="col-sm-8">
                                <input id="orderNum" name="orderNum" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">图标：</label>
                            <div class="col-sm-6">
                                <input id="icon" name="icon" class="form-control" type="text"
                                       placeholder="例如：fa fa-circle-o">
                            </div>
                            <input id="ico-btn" class="btn btn-warning" type="button" value="选择图标">
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button type="button" id="add" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script>
    $("#add").click(function () {
        $.ajax({
            type : "POST",
            url : "/permission/save",
            data : $('#signupForm').serialize(),
            async : false,
            error : function(request) {
                laryer.alert("数据异常");
            },
            success : function(data) {
                if (data.result=="success") {
                    parent.layer.msg("保存成功");
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);
                } else {
                    layer.alert(data.msg)
                }
            }
        });
    });
</script>
</html>
