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
    <title>酒店收入列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>酒店收入列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style=" margin-top:5px">创建时间</label>
                    <div class="col-sm-2" >
                        <input type="text" class="form-control"  placeholder="请选择时间" name="createTime" id="test__2"/>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">所属酒店</label>
                    <div class="col-sm-2">
                        <select class="form-control" required  id="hotel_id" name="hotelId">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">结算状态</label>
                    <div class="col-sm-2"  >
                        <select  class="form-control" id="incomeStatus__" style="" name="incomeStatus">
                            <option value="">全部</option>
                            <option value="0">已支付</option>
                            <option value="1">未支付</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">收支科目</label>
                    <div class="col-sm-2">
                        <select class="form-control" required  id="subjectId" name="subjectId">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="margin-top: 5px">状态</label>
                    <div class="col-sm-2"  >
                        <select class="form-control" style="" id="isActive__" name="isActive">
                            <option value="">全部</option>
                            <option value="0">启用</option>
                            <option value="1">禁用</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label"  style=" margin-top:5px;">收入备注</label>
                    <div class="col-sm-2" >
                        <input type="text" class="form-control" placeholder="请输入收入备注" style="" name="remark" id="remark__"/>
                    </div>
                    <div class="col-sm-3" style="text-align: center;margin: auto" >
                        <button class="btn btn-primary"  id="search_btn" style="width: 200px" >查询</button>
                    </div>
                </div>
                <table id="mytab" name="mytab" class="table table-hover"></table>
                <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                    <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default"
                            style="display: block;">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量修改状态
                    </button>
                    <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal"
                            data-target="#webAdd">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--数据的新增--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="webAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
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
                        <label class="col-sm-2 control-label">酒店编号：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required id="hotelId" name="hotelId">
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">收支科目：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required id="subject_id" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收入名称：</label>
                        <div class="col-sm-4">
                            <input id="incommeName" name="incommeName" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">支付状态：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required  id="incomeStatus" name="incomeStatus">
                                <option value="0">已支付</option>
                                <option value="1">未支付</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收入总额：</label>
                        <div class="col-sm-4">
                            <input id="money" name="money" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">收入时间：</label>
                        <div class="col-sm-4">
                            <input id="test_2" name="temp" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收入备注：</label>
                        <div class="col-sm-10">
                            <textarea id="remark" name="remark" type="text" class="form-control" required=""
                                      aria-required="true"></textarea>
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
    <div class="modal-dialog modal-lg">
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
                <input type="hidden" name="id">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">酒店编号</label>
                        <div class="col-sm-4">
                            <select class="form-control" required id="hotelId_" name="hotelId">
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">收支科目：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required id="subjectId_" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收入名称：</label>
                        <div class="col-sm-4">
                            <input id="incommeName_" name="incommeName" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">支付状态：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required  id="incomeStatus_" name="incomeStatus">
                                <option value="0">已支付</option>
                                <option value="1">未支付</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收入总额：</label>
                        <div class="col-sm-4">
                            <input id="money_" name="money" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">收入时间：</label>
                        <div class="col-sm-4">
                            <input id="test_2_" name="temp" type="text" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收入备注：</label>
                        <div class="col-sm-10">
                            <textarea id="remark_" name="remark" type="text" class="form-control" required=""
                                      aria-required="true"></textarea>
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
<div class="modal fade" id="remark_modal" tabindex="-1" role="dialog" aria-labelledby="remark_modal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    收入备注
                </h4>
            </div>
            <div class="modal-body" id="remarks">

            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>

<div class="modal fade  bs-example-modal-lg" id="order_item_list" tabindex="-1" role="dialog" aria-labelledby="remark_modal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    收入明细
                </h4>
            </div>
            <div class="modal-body">
                <table id="mytab2" name="mytab2" class="table table-hover"></table>
                <div id="toolbar1" class="btn-group pull-right" style="margin-right: 20px;">
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<%--数据的修改结束--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/income.js"></script>
</body>
<script>
    laydate.render({
        elem: '#test__2'//指定元素，
        ,type: 'date'
        ,range: true
    });
    laydate.render({
        elem: '#test2' //指定元素
        ,type: 'date'
        ,range: true
    });
    laydate.render({
        elem: '#test_2'//指定元素，
        ,type: 'date'
        ,range: true
    });
    laydate.render({
        elem: '#test21'
    });
    laydate.render({
        elem: '#zhouqi_'
    });
    $(function () {
        $.post(
            "/cashAccounts/getSubject",
            function (data) {
                $("#subjectId").select2({
                    data: data
                });
                $("#select2-subjectId-container").remove();
                $("#subject_id").select2({
                    data: data
                });
                $("#select2-subject_id-container").remove();
                $("#subjectId_").select2({
                    data: data
                });
                $("#select2-subjectId_-container").remove();
                $("#subjectId_").select2({
                    data: data
                });
                $("#select2-subjectId_-container").remove();
            },
            "json"
        );
        $.post(
            "/cashAccounts/getHotel",
            function(data){
                $("#hotelId").select2({
                    data: data
                })
                $("#hotel_id").select2({
                    data: data
                })
                $("#hotelId_").select2({
                    data: data
                })
                $("#select2-hotelId-container").remove();
                $("#select2-hotel_id-container").remove();
                $("#select2-hotelId_-container").remove();
            },
            "json"

        );
    });
</script>
</html>
