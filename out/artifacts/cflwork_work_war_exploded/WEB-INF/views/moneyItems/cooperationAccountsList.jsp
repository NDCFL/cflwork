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
    <title>分店来往财务列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>账单账目统计</h5>
            <div class="ibox-tools">
            </div>
        </div>
        <div class="ibox-content">
            <div class="wrapper wrapper-content">
                <div class="row">
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right">全部商家</span>
                                    <h5>当前应收</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="sumMoneyIn" style="color: #099000;"></h2>
                                    <div class="stat-percent font-bold text-info">收入
                                        <i class="fa fa-level-up"></i>
                                    </div>
                                    <small>当前未结算账单应收合计</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right">全部商家</span>
                                    <h5>当前应付</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="sumMoneyOut" style="color: #ff0000;"></h2>
                                    <div class="stat-percent font-bold text-info">支出 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small>当前未结算账单应付合计</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right">全部商家</span>
                                    <h5>总结余</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="sumMoneyJieyu" style="color: #0060ff"></h2>
                                    <div class="stat-percent font-bold text-info">结余 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small>当前未结算应收减应付账单结余</small>
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
                                    <small class="findNameIn">当前搜索数据合计总收入</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right findNameOut" >合计支出</span>
                                    <h5 class="findNameOut">搜索统计</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="findout" style="color: #ff0000;">0</h2>
                                    <div class="stat-percent font-bold text-info">支出 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small class="findNameOut">当前搜索数据合计总支出</small>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a style="color:#797979">
                        <div class="col-sm-4">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-info pull-right findNameJieyu" >对冲结余</span>
                                    <h5 class="findNameJieyu">搜索统计</h5>
                                </div>
                                <div class="ibox-content">
                                    <h2 class="no-margins" id="findjieyu" style="color: #0060ff">0</h2>
                                    <div class="stat-percent font-bold text-info">结余 <i class="fa fa-level-up"></i>
                                    </div>
                                    <small class="findNameJieyu">当前搜索数据合计总结余</small>
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
            <h5>分店来往财务列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style=" margin-top:5px">账单日期</label>
                    <div class="col-sm-2" >
                        <input type="text" class="form-control"   name="createTime" id="test_2"/>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">账单类型</label>
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
                    <label class="col-sm-1 control-label" style=" margin-top:5px">来往科目</label>
                    <div class="col-sm-2">
                        <select class="form-control" required  id="subjectId_" name="subjectId">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="margin-top:5px" >账单说明</label>
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
                    <label class="col-sm-1 control-label" style=" margin-top:5px">操作人</label>
                    <div class="col-sm-2">
                        <select class="form-control" required  id="handId" name="handle">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label" style=" margin-top:5px">商家名称</label>
                    <div class="col-sm-2">
                        <select class="form-control" required id="cooperation_company_id_" name="cooperationCompanyId">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label"  style="margin-top:5px" >结算状态</label>
                    <div class="col-sm-2">
                        <select class="form-control" style="" required id="iscash" name="isCash">
                            <option value="">全部</option>
                            <option value="0">未结算</option>
                            <option value="1">已结算</option>
                            <option value="2">有异议</option>
                        </select>
                    </div>
                    <div class="col-sm-3" style="text-align: center;margin: auto" >
                        <button class="btn btn-primary col-sm-12"  id="search_btn">查询</button>
                    </div>
                </div>
            </div>
            <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                <button id="btn_shenhe" type="button" onclick="return getAccounts();" class="btn btn-default" style="display: block; border-radius: 0" data-toggle="modal" data-target="#manayShenhe">
                    <span class="glyphicon glyphicon-import" aria-hidden="true" ></span>批量审核
                </button>
                <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量结算状态
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
</div>
<div class="modal fade" id="updateStatus" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" >
                    批量修改结算状态
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="update_status">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">结算状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control"  id="status" required name="status">
                                <option value="0">未结算</option>
                                <option value="1">已结算</option>
                                <option value="2">有异议</option>
                            </select>
                        </div>
                        <input id="statusId" type="hidden" name="manyId" />
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
                    新增总部来往财务
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <input type="hidden" value="-1" name="hotelId"/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">来往商家：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="cooperation_company_id" name="cooperationCompanyId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">来往科目：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="subject_id" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">财务类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="accountType">
                                <option value="0">收入</option>
                                <option value="1">支出</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">结算状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="isCash">
                                <option value="0">未结算</option>
                                <option value="1">已结算</option>
                                <option value="1">有异议</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">金额：</label>
                        <div class="col-sm-8">
                            <input  name="totalPay" minlength="2" id="money_" maxlength="20" type="text" class="form-control" required aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账单时间：</label>
                        <div class="col-sm-8">
                            <input  type="text" class="form-control" id="test1" required aria-required="true">
                            <input  name="accountTime"  type="hidden" class="form-control" id="accountTime" required aria-required="true">
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
                    <button type="button" id="add" class="btn btn-primary">
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
                    来往财务的修改
                </h4>
            </div>
            <form class="form-horizontal" id="updateform" >
                <input  id="id" type="hidden" name="id" />
                <div class="modal-body">
                    <input type="hidden" value="-1" name="hotelId"></input>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">来往商家：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="cooperation_company_id__" name="cooperationCompanyId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">来往科目：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="subjectId" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">财务类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="accountType">
                                <option value="0">收入</option>
                                <option value="1">支出</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">结算状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="isCash">
                                <option value="0">未结算</option>
                                <option value="1">已结算</option>
                                <option value="1">有异议</option>
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
                        <label class="col-sm-3 control-label">收支时间：</label>
                        <div class="col-sm-8">
                            <input   type="text" id="test21" class="form-control" required="" aria-required="true">
                            <input  name="accountTime"  type="hidden" id="test_21" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账目说明：</label>
                        <div class="col-sm-8">
                            <textarea  name="description" id="description" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">批注：</label>
                        <div class="col-sm-8">
                            <textarea  name="remark" id="remarkes" class="form-control" required="" aria-required="true"></textarea>
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
<div class="modal fade" id="shenheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="shenheModalLabel">
                    分店来往财务的审核
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
                    来往财务的批量审核
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
                    来往财务的批注
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
                    账单说明详情
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
<script src="<%=path%>/static/js/pageJs/cooperationAccounts.js"></script>
</body>
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
    laydate.render({
        elem: '#test1' //指定元素
        ,type: 'date'
    });
    $.post(
        "/cashAccounts/getHotel",
        function(data){
            $("#hotelId").select2({
                data: data
            })
            $("#select2-hotelId-container").remove();
            $("#hotel__Id").select2({
                data: data
            })
            $("#select2-hotel__Id-container").remove();
            $("#hotel_Id").select2({
                data: data
            })
            $("#select2-hotel_Id-container").remove();
            $("#hotel").select2({
                data: data
            })
            $("#select2-hotel-container").remove();

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
    $(function () {
        $.post(
            "/cooperationAccounts/getSubject",
            function(data){
                $("#subjectId").select2({
                    data: data
                })
                $("#select2-subjectId-container").remove();
                $("#subject_id").select2({
                    data: data
                })
                $("#select2-subject_id-container").remove();
                $("#subjectId_").select2({
                    data: data
                })
                $("#select2-subjectId_-container").remove();
            },
            "json"
        );
        $.post(
            "/cooperationAccounts/getHotelCooperationCompany",
            function(data){
                $("#cooperation_company_id").select2({
                    data: data
                })
                $("#cooperation_company_id_").select2({
                    data: data
                })
                $("#select2-cooperation_company_id-container").remove();
                $("#select2-cooperation_company_id_-container").remove();
                $("#cooperation_company_id__").select2({
                    data: data
                })
                $("#select2-cooperation_company_id__-container").remove();
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
            "/cooperationAccounts/getCashVal",
            {
                hotelId:-1
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
