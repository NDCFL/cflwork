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
    <title>列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label">业主编号</label>
                        <div class="col-sm-2">
                            <input id="masterId__" name="masterId" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-1 control-label">消息标题</label>
                        <div class="col-sm-2">
                            <input id="name__" name="name" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-1 control-label">消息内容</label>
                        <div class="col-sm-2">
                            <input id="content__" name="content" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-1 control-label">创建时间</label>
                        <div class="col-sm-2">
                            <input id="createTime__" name="createTime" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label">状态</label>
                        <div class="col-sm-2">
                            <input id="isActivce__" name="isActivce" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <button class="btn btn-primary" id="search_btn" style="width: 100px">查询</button>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <table id="mytab" name="mytab" class="table table-hover"></table>
                    <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                        <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default"
                                style="display: block;">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量修改状态
                        </button>
                        <a id="btn_add" type="button" class="btn btn-default" href="/contracmasterMsg/add">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--数据的新增--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="webAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="webAddTitle">
                    新增
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">业主编号：</label>
                        <div class="col-sm-8">
                            <input id="masterId" name="masterId" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">发送者编号：</label>
                        <div class="col-sm-8">
                            <input id="sendId" name="sendId" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">消息标题：</label>
                        <div class="col-sm-8">
                            <input id="name" name="name" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">消息内容：</label>
                        <div class="col-sm-8">
                            <input id="content" name="content" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">创建时间：</label>
                        <div class="col-sm-8">
                            <input id="createTime" name="createTime" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">状态,0：已读状态，1：未读状态：</label>
                        <div class="col-sm-8">
                            <input id="isActivce" name="isActivce" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
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
<%--新增结束--%>
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
                        <label class="col-sm-3 control-label">状态：</label>
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
<%--数据的修改--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改
                </h4>
            </div>
            <form class="form-horizontal" id="updateform">
                <div class="modal-body">
                    <input id="id" name="id" th:value="${contracmasterMsg.id}" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">业主编号：</label>
                        <div class="col-sm-8">
                            <input id="masterId_" name="masterId" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">发送者编号：</label>
                        <div class="col-sm-8">
                            <input id="sendId_" name="sendId" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">消息标题：</label>
                        <div class="col-sm-8">
                            <input id="name_" name="name" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">消息内容：</label>
                        <div class="col-sm-8">
                            <input id="content_" name="content" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">创建时间：</label>
                        <div class="col-sm-8">
                            <input id="createTime_" name="createTime" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">状态,0：已读状态，1：未读状态：</label>
                        <div class="col-sm-8">
                            <input id="isActivce_" name="isActivce" class="form-control" type="text">
                        </div>
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
<%--数据的修改结束--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/contracmasterMsg.js"></script>
</body>
</html>
