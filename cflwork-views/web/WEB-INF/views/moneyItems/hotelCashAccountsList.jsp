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
    <title>收支账目列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>收支账目统计</h5>
             <div class="ibox-tools">
                 <%--<div style="float:right;">--%>
                     <%--<button type="button" style="float: right;margin-top: -10px;margin-left: 5px" id="getDval" class="btn btn-primary" data-dismiss="modal">--%>
                         <%--查询--%>
                     <%--</button>--%>
                 <%--</div>--%>
                 <%--<div style="float:right;">--%>
                     <%--<input  name="dateVal" style="width:100%;padding-top: -5%;margin-top: -10px;float: right"  type="text" id="test21"  class="form-control" required="required" aria-required="true">--%>
                 <%--</div>--%>
                 <%--<div style="float:right;margin-right: 20px">--%>
                     <%--<span>账单月份</span>--%>
                 <%--</div>--%>
                 <%--<div style="float:right;margin-right: 20px">--%>
                     <%--<select class="form-control" style="width:100%;padding-top: -5%;margin-top: -10px;float: right" required id="hotelid_" name="hotelId">--%>
                        <%--<option value="">全部</option>--%>
                     <%--</select>--%>
                 <%--</div>--%>
                 <%--<div style="float:right;margin-right: 20px">--%>
                     <%--<span>店面名称</span>--%>
                 <%--</div>--%>
             </div>
        </div>
        <div class="ibox-content">
            <div class="wrapper wrapper-content">
                <div class="row">
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right">全部账户</span>
                                    <h5>总收入</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="sumMoneyIn" style="color: #099000;"></h2>
                                    <div class="stat-percent font-bold text-info">收入
                                        <i class="fa fa-level-up"></i>
                                    </div>
                                    <small>全部账户总收入</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right">全部账户</span>
                                    <h5>总支出</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="sumMoneyOut" style="color: #ff0000;"></h2>
                                    <div class="stat-percent font-bold text-info">支出 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small>全部账户总支出</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right">全部账户</span>
                                    <h5>总结余</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="sumMoneyJieyu" style="color: #0060ff"></h2>
                                    <div class="stat-percent font-bold text-info">结余 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small>全部账户总结余</small>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="wrapper wrapper-content">
                <div class="row">
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right findNameIn" >合计收入</span>
                                    <h5 class="findNameIn">搜索统计</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="findin" style="color: #099000;">0</h2>
                                    <div class="stat-percent font-bold text-info">收入 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small class="findNameIn">搜索数据合计总收入</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right findNameOut" >合计总支出</span>
                                    <h5 class="findNameOut">搜索统计</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="findout" style="color: #ff0000;">0</h2>
                                    <div class="stat-percent font-bold text-info">支出 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small class="findNameOut">搜索数据合计总支出</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right findNameJieyu" >合计结余</span>
                                    <h5 class="findNameJieyu">搜索统计</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="findjieyu" style="color: #0060ff">0</h2>
                                    <div class="stat-percent font-bold text-info">结余 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small class="findNameJieyu">搜索数据合计总结余</small>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>收支账目列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询列表
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style=" margin-top:5px">创建时间</label>
                    <div class="col-sm-2" >
                        <input type="text" class="form-control"   name="createTime" id="test_2"/>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">收支类型</label>
                    <div class="col-sm-2"  >
                        <select  class="form-control" id="accountType_" style="" name="accountType">
                            <option value="">全部</option>
                            <option value="0">收入</option>
                            <option value="1">支出</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label"  style=" margin-top:5px;">金额</label>
                    <div class="col-sm-2" >
                        <input type="number" class="form-control" style="" name="totalPay" id="totalPay_"/>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">收支科目</label>
                    <div class="col-sm-2">
                        <select class="form-control" required  id="subjectId_" name="subjectId">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="margin-top:5px" >收支说明</label>
                    <div class="col-sm-2"  >
                        <input type="text" id="description_" style=""  class="form-control"  name="description"/>
                    </div>
                    <label class="col-sm-1 control-label" style="margin-top: 5px">审核状态</label>
                    <div class="col-sm-2"  >
                        <select class="form-control" style="" id="cashStatus_" name="cashStatus">
                            <option value="">全部</option>
                            <option value="0">未审核</option>
                            <option value="1">审核通过</option>
                            <option value="2">审核不通过</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label"  style="margin-top:5px" >收支账户</label>
                    <div class="col-sm-2"  >
                        <select class="form-control"  required id="payTypeId_"  name="payTypeId">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label"  style="margin-top:5px" >收支周期</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" style=""   name="zhouqi" id="zhouqi_"/>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">

                    <label class="col-sm-1 control-label" style="margin-top: 5px">店面名称</label>
                    <div class="col-sm-2"  >
                        <select class="form-control" style="" required id="hotel" name="hotel">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">操作人</label>
                    <div class="col-sm-2">
                        <select class="form-control" required  id="handId" name="handle">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <div class="col-sm-3" >
                        <button class="btn btn-primary col-sm-12"  id="search_btn">查询</button>
                    </div>
                </div>
            </div>
        </div>
        <table id="mytab" name="mytab" class="table table-hover"></table>
        <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
            <button id="btn_shenhe" type="button" onclick="return getAccounts();" class="btn btn-default" style="display: block; border-radius: 0" data-toggle="modal" data-target="#manayShenhe">
                <span class="glyphicon glyphicon-import" aria-hidden="true" ></span>批量审核
            </button>
            <%--<button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">--%>
                <%--<span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量删除--%>
            <%--</button>--%>
            <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#webAdd">
                <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
            </button>
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
                    新增收支账目
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <input type="hidden" name="accountTime" id="accountTime" />
                <input type="hidden" name="accountTimeEnd" id="accountTimeEnd" />
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">店面名称：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="hotel_id" name="hotelId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支科目：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="subject_id" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="accountType">
                                <option value="0">收入</option>
                                <option value="1">支出</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">选择账户：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="payType_Id" name="payTypeId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">金额：</label>
                        <div class="col-sm-8">
                            <input  name="totalPay" minlength="2" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支周期：</label>
                        <div class="col-sm-8">
                            <input  type="datetime" id="test2" class="form-control" required="required" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账目说明：</label>
                        <div class="col-sm-8">
                            <textarea  name="description" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" id="add" class="btn btn-primary">
                        确认新增
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<input type="hidden" value=""  id="deleteId"/>
<%--网站新增结束--%>
<%--网站信息的修改--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    收支账目修改
                </h4>
            </div>
            <form class="form-horizontal" id="updateform" >
                <input  id="id" type="hidden" name="id" />
                <input type="hidden" name="accountTime" id="accountTime_" />
                <input type="hidden" name="accountTimeEnd" id="accountTimeEnd_" />
                <input type="hidden" name="totalPay"/>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">店面名称：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="hotelId" name="hotelId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支科目：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="subjectId" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="accountType">
                                <option value="0">收入</option>
                                <option value="1">支出</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">金额：</label>
                        <div class="col-sm-8">
                            <input  name="totalPay" minlength="2" id="totalPay" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">选择方式：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="payTypeId" name="payTypeId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支周期：</label>
                        <div class="col-sm-8">
                            <input  type="datetime" name="loop" id="test2_" class="form-control" required="required" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账目说明：</label>
                        <div class="col-sm-8">
                            <textarea  name="description" id="description" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账目批注：</label>
                        <div class="col-sm-8">
                            <textarea  name="remark" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="update" class="btn btn-primary" >
                        确认修改
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="shenheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="shenheModalLabel">
                    收支账目的审核
                </h4>
            </div>
            <form class="form-horizontal" id="shenheform" >
                <input  id="accountid" type="hidden" name="id" />
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审核操作：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="cashStatus">
                                <option value="0">未审核</option>
                                <option value="1">审核通过</option>
                                <option value="2">审核不通过</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审核备注：</label>
                        <div class="col-sm-8">
                            <textarea  name="reason" id="reason" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="shenhe" class="btn btn-primary" data-dismiss="modal">
                        确认审核
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="manayShenhe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="manyShenheModalLabel">
                    收支账目的批量审核
                </h4>
            </div>
            <form class="form-horizontal" id="manyshenheform" >
                <input  id="manyId" type="hidden" name="manyId" />
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审核操作：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="cashStatus">
                                <option value="0">未审核</option>
                                <option value="1">审核通过</option>
                                <option value="2">审核不通过</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审核备注：</label>
                        <div class="col-sm-8">
                            <textarea  name="reason" class="form-control" id="accountsReason" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="accountsshenhe" class="btn btn-primary" data-dismiss="modal">
                        确认批量审核
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="remarkModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="remarkModalLabel">
                    收支账目的批注
                </h4>
            </div>
            <form class="form-horizontal" id="remarkform" >
                <input  id="remarkid" type="hidden" name="id" />
                <div class="modal-body">

                    <div class="form-group">
                        <label class="col-sm-3 control-label">批注：</label>
                        <div class="col-sm-8">
                            <textarea  name="remark" id="remark" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="remarkAdd" class="btn btn-primary" data-dismiss="modal">
                        确认批注
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
                    收支账目说明详情
                </h4>
            </div>
            <div class="modal-body" id="remarks">

            </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
    <div class="modal fade" id="remarks_modal" tabindex="-1" role="dialog" aria-labelledby="remark_modal" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">
                        批注详情
                    </h4>
                </div>
                <div class="modal-body" id="remarkss">

                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        <div class="modal fade" id="check_modal" tabindex="-1" role="dialog" aria-labelledby="remark_modal" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title">
                            审核详情
                        </h4>
                    </div>
                    <div class="modal-body" id="checks">

                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

        <%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/plugins/laydate/laydate.js"></script>
<script src="<%=path%>/static/js/pageJs/hotelCashAccounts.js"></script>
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

<%--</script>--%>
<script>
    //执行一个laydate实例
    laydate.render({
        elem: '#test1' //指定元素
        ,type: 'date'
    });
    laydate.render({
        elem: '#test2' //指定元素
        ,type: 'date'
        ,range: true
    });
    laydate.render({
        elem: '#test21'
    });
    laydate.render({
        elem: '#test_2'//指定元素，
        ,type: 'date'
        ,range: true
    });
    laydate.render({
        elem: '#test2_'//指定元素，
        ,type: 'date'
        ,range: true
    });
    laydate.render({
        elem: '#zhouqi_'
    });
</script>
<script>
    $(function () {
        $.post(
            "/cashAccounts/getSubject",
            function(data){
                $("#subjectId").select2({
                    data: data
                })
                $("#subject_id").select2({
                    data: data
                })
                $("#select2-subjectId-container").remove();
                $("#select2-subject_id-container").remove();
                $("#subject__id").select2({
                    data: data
                });
                $("#select2-subject__id-container").remove();
                $("#subjectId_").select2({
                    data: data
                });
                $("#select2-subjectId_-container").remove();

            },
            "json"

        );
        $.post(
            "/user/getUser",
            function(data){
                $("#handId").select2({
                    data: data
                })
                $("#select2-handId-container").remove();
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
                $("#hotelid_").select2({
                    data: data
                })
                $("#hotel").select2({
                    data: data
                })
                $("#select2-hotelId-container").remove();
                $("#select2-hotel_id-container").remove();
                $("#select2-hotelid_-container").remove();
                $("#select2-hotel-container").remove();
            },
            "json"

        );
        $.post(
            "/cashAccounts/getPayType",
            function(data){
                $("#payType_Id").select2({
                    data: data
                })
                $("#payTypeId").select2({
                    data: data
                })
                $("#select2-payType_Id-container").remove();
                $("#select2-payTypeId-container").remove();
                $("#payTypeId_").select2({
                    data: data
                })
                $("#select2-payTypeId_-container").remove();
            },
            "json"

        );
    });
</script>
<script>
    $(function () {
        getVal();
    });
    $("#getDval").click(function () {
        getVal($("#test21").val());
    });
    function getVal(val) {
        $.post(
            "/cashAccounts/getCashVal",
            {
                dateVal:val,
                hotelId:$("#hotelid_").val()
            },
            function(data){
                $("#sumMoneyIn").html("￥"+data.sumMoneyIn);
                $("#sumMoneyOut").html("￥"+data.sumMoneyOut);
                $("#sumMoneyJieyu").html("￥"+data.sumMoneyJieyu);
            },
            "json"

        );
    }
</script>
</html>
