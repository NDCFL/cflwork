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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>权限管理</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>权限列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;margin-bottom: 20px">
                        <button class="btn btn-default" type="button" onclick="refush()" title="刷新"><i class="glyphicon glyphicon-refresh icon-refresh"></i></button>
                        <button id="btn_add" type="button"  class="btn btn-default"  data-toggle="modal"  data-target="#webAdd" onclick="return  addPermission('0');">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
                        </button>
                    </div>
                    <table id="mytab" name="mytab" class="table table-hover"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<%--网站数据的新增--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="webAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="webAddTitle">
                    新增权限
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <input id="parentId" name="parentId" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">上级菜单：</label>
                        <div class="col-sm-8">
                            <input id="pName" name="pName" class="form-control" type="text" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">菜单类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="type">
                                <option value="0">目录</option>
                                <option value="1">菜单</option>
                                <option value="2">按钮</option>
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
                            <input id="orderNum" name="orderNum" class="form-control"
                                   type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">图标：</label>
                        <div class="col-sm-6">
                            <input id="icon" name="icon" class="form-control" type="text"
                                   placeholder="例如：fa fa-circle-o">
                        </div>
                        <input id="ico-btn" class="btn btn-primary" type="button" value="选择图标">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="add" class="btn btn-primary" data-dismiss="modal">
                        确认新增
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<input type="hidden" value="" id="deleteId"/>
<%--网站新增结束--%>
<div class="modal fade" id="updateStatus" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    批量修改状态
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="update_status">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">科目状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="status" required name="status">
                                <option value="0">启用</option>
                                <option value="1">停用</option>
                            </select>
                        </div>
                        <input id="statusId" type="hidden" name="manyId"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="updateSta" class="btn btn-primary" data-dismiss="modal">
                        确认修改
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    权限的修改
                </h4>
            </div>
            <form class="form-horizontal" id="updateform">
                <div class="modal-body">
                    <input type="hidden" name="id" id="id" value="">
                    <input  name="parentId" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">上级菜单：</label>
                        <div class="col-sm-8">
                            <input name="pname" class="form-control" type="text" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">菜单类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="type">
                                <option value="0">目录</option>
                                <option value="1">菜单</option>
                                <option value="2">按钮</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">菜单名称：</label>
                        <div class="col-sm-8">
                            <input name="name" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">链接地址：</label>
                        <div class="col-sm-8">
                            <input name="url" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">权限标识：</label>
                        <div class="col-sm-8">
                            <input name="perms" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">排序号：</label>
                        <div class="col-sm-8">
                            <input  name="orderNum" class="form-control"
                                   type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">图标：</label>
                        <div class="col-sm-6">
                            <input id="icons" name="icon" class="form-control" type="text"
                                   placeholder="例如：fa fa-circle-o">
                        </div>
                        <input id="ico-btns" class="btn btn-primary" type="button" value="选择图标">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="update" class="btn btn-primary" data-dismiss="modal">
                        确认修改
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/plugins/jqTreeGrid/jquery.treegrid.min.js"></script>
<script src="<%=path%>/static/js/plugins/jqTreeGrid/jquery.treegrid.extension.js"></script>
<script src="<%=path%>/static/js/plugins/jqTreeGrid/jquery.treegrid.bootstrap3.js"></script>
<script src="<%=path%>/static/js/pageJs/permission.js"></script>
</body>
<%--<script>--%>
<%--$(function () {--%>
<%--alert("asdflsfa");--%>
<%--layer.msg('已发布', {icon:1,time:1000});--%>
<%--layer.msg('已发布', {icon:2,time:1000});--%>
<%--layer.msg('已发布', {icon:3,time:1000});--%>
<%--layer.msg('已发布', {icon:4,time:1000});--%>
<%--layer.msg('已发布', {icon:5,time:1000});--%>
<%--layer.msg('已发布', {icon:6,time:1000});--%>
<%--layer.msg('已发布', {icon:7,time:1000});--%>
<%----%>
<%--});--%>

</html>
