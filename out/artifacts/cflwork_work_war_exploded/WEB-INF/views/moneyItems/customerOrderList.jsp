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
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>客户订单列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>客户订单列表</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#">选项1</a>
                    </li>
                    <li><a href="#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">客户订单名称：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="Name" id="search_name"/>
                    </div>
                    <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">创建时间：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="Name" id="search_tel"/>
                    </div>
                    <div class="col-sm-1 col-sm-offset-4">
                        <button class="btn btn-primary" id="search_btn">查询</button>
                    </div>
                </div>
            </div>
            <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                <button id="btn_shenhe" type="button" onclick="return getAccounts();" class="btn btn-default" style="display: block; border-radius: 0" data-toggle="modal" data-target="#manayShenhe">
                    <span class="glyphicon glyphicon-import" aria-hidden="true" ></span>批量审核
                </button>
                <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量删除
                </button>
                <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#webAdd">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
                </button>
                <button id="order_add" type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-lg">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>订单新增
                </button>
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
                    新增客户订单
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">所属现金流水科目：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required id="subject_id" name="subjectId">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">客户订单类型：</label>
                        <div class="col-sm-8">
                            <select class="form-control" required name="accountType">
                                <option value="0">收入</option>
                                <option value="1">支出</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">客户订单金额：</label>
                        <div class="col-sm-8">
                            <input  name="totalPay" minlength="2" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">收支时间：</label>
                        <div class="col-sm-8 date form_datetime">
                            <input  name="accountTime"  type="datetime" class="form-control" required="" aria-required="true">
                            <span class="add-on"><i class="icon-th"></i></span>
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
<div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    客户订单的修改
                </h4>
            </div>
            <div class="form-horizontal" >
                <div class="modal-body">
                    <form id="updateform" >
                        <div  class="form-horizontal" >
                            <div class="form-group">
                                <label class="col-sm-1 control-label">姓名：</label>
                                <div class="col-sm-3">
                                    <input  name="customerName" minlength="2" required="" aria-required="true" maxlength="20" type="text" value="" class="form-control" >
                                </div>
                                <label class="col-sm-1 control-label">手机：</label>
                                <div class="col-sm-3">
                                    <input  name="customerPhone" minlength="2"  required="" aria-required="true" maxlength="20" type="text"  value="" class="form-control">
                                </div>
                                <label class="col-sm-1 control-label">证件：</label>
                                <div class="col-sm-3">
                                    <input  name="customerIdentity" minlength="2"  required="" aria-required="true"  maxlength="20" type="text" value="" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" class="div">
                            <div class="form-group" >
                                <div class="col-sm-2">
                                    <input  name="checkinTime" minlength="2" maxlength="20" type="datetime" value="" class="form-control  date form_datetime" data-date-format="yyyy-mm-dd hh:ii:ss" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <input  name="checkoutTime" minlength="2" style="margin-left:-10px"  maxlength="20" type="datetime" value="" class="form-control  date form_datetime" onchange="getDays(this.value,0)"  data-date-format="yyyy-mm-dd hh:ii:ss" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <input  name="totalDays" minlength="2" style="margin-left:-20px" readonly maxlength="20" type="text" value="" class="form-control" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <input  name="houseId"  type="number" value="" readonly class="form-control" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <input type="number" class="form-control price" readonly value="0"  name="housePay"  />
                                </div>
                            </div>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                            <hr height="5px"/>
                            <i class="glyphicon glyphicon-usd" style="color:green;float:right;margin-top: -16px">房费总计：<span id="sumMoney1"></span></i>
                            <input type="hidden" id="sum_money1" />
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1">
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="typeId0" name="typeId"  value="0">
                                </label>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">支付类型：</label>
                            <div class="col-sm-2" style="margin-left:-30px">
                                <select class="form-control"  required name="type">
                                    <option value="0">在线预付</option>
                                    <option value="1">担保现付</option>
                                </select>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">渠道选择：</label>
                            <div class="col-sm-2">
                                <select class="form-control"  required id="website_Id" name="websiteId" style="margin-left: -30px">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1">
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="typeId1"  name="typeId" value="1">
                                </label>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">商家送客：</label>
                            <div class="col-sm-2" style="margin-left:-30px">
                                <select class="form-control" id="otherHotel" name="othersHotelId" required >
                                    <option value="-1">请选择来往合作商家</option>
                                </select>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">结算状态：</label>
                            <div class="col-sm-2">
                                <select name="isCash1" class="form-control" required  id="isCash1" style="margin-left: -30px">
                                    <option value="0" id="is_cash_0" >未结算</option>
                                    <option value="1" id="is_cash_1">已结算</option>
                                </select>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">支付类型：</label>
                            <div class="col-sm-2" style="margin-left:-30px">
                                <select class="form-control" required id="payment_Type_Id" name="paymentTypeId">
                                    <option value="-1">请选择支付类型</option>
                                </select>
                            </div>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                            <hr height="5px"/>
                        </div>
                        <div class="form-group">
                            <div  class="form-group col-sm-12">
                                <div class="col-sm-1">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="typeId2" name="typeId" value="2">
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">借房商家：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" id="other_hotel" required name="othersHotelId">
                                        <option value="-1">请选择来往合作商家</option>
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">结算金额：</label>
                                <div class="col-sm-2">
                                    <input  name="otherHotelMoney" minlength="2" style="margin-left:-30px" maxlength="20" type="number" placeholder="结算金额" value="0" class="form-control" required="" aria-required="true">
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">选择房号：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" required name="xnHouse">
                                        <option>虚拟101房间</option>
                                    </select>
                                </div>
                            </div>

                            <div  class="form-group col-sm-12">
                                <div class="col-sm-1">
                                    <label class="checkbox-inline">

                                    </label>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">结算状态：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control"  required name="isCash2">
                                        <option value="0" id="is_cash__0">未结算</option>
                                        <option value="1" id="is_cash__1">已结算</option>
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">结算账户：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" required id="otherType" name="otherHotelMoneyType">
                                        <option value="-1">请选择结算账户</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                            <hr height="5px"/>
                            <i class="glyphicon glyphicon-usd" style="color:red;float:left;margin-top: -16px"><span style="color:red">订单盈亏:</span><span style="color:red">--</span><span style="color:red">（房费-结算金额）</span></i>
                        </div>
                        <div class="form-group">
                            <table name="mytab1" class="table table-striped table-responsive">
                                <thead>
                                    <th>科目</th>
                                    <th>房号</th>
                                    <th>金额</th>
                                    <th>是否结算</th>
                                    <th>创建时间</th>
                                    <th>操作人</th>
                                    <th>操作</th>
                                </thead>
                                <tbody id="infodata">

                                </tbody>
                            </table>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                            <hr height="5px"/>
                            <a data-toggle="modal" data-target="#orderAdd"><i class="glyphicon glyphicon-plus" style="color:green;float:left;margin-top: -16px">新增款项</i></a>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">备注：</label>
                            <div class="col-sm-11">
                                <textarea  name="remark" minlength="2"  maxlength="20" value="" class="form-control" required="" aria-required="true"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" id="updateitem" class="btn btn-primary">
                                确认修改订单
                            </button>
                        </div>
                        <textarea name="firstVal" id="firstVal1" style="display: none;"></textarea>
                    </form>
                </div>
            </div>
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
                    客户订单的审核
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
                    客户订单的批量审核
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
                    客户订单的批注
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
<div class="modal fade bs-example-modal-lg"  id="itemsModule" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="orderModalLabel">
                    订单入住
                </h4>
            </div>
            <div class="form-horizontal" id="updateorderform" >
                <div class="modal-body">
                    <form id="info" onsubmit="return info();">
                        <div id="basedata" class="form-horizontal" >
                            <div class="form-group">
                                <label class="col-sm-1 control-label">姓名：</label>
                                <div class="col-sm-3">
                                    <input  name="customerName" minlength="2" id="customerName"   required="" aria-required="true" maxlength="20" type="text" placeholder="请输入入住人的姓名" value="" class="form-control" >
                                </div>
                                <label class="col-sm-1 control-label">手机：</label>
                                <div class="col-sm-3">
                                    <input  name="customerPhone" minlength="2" id="customerPhone"  required="" aria-required="true" maxlength="20" type="text" placeholder="请输入入住人的联系方式" value="" class="form-control">
                                </div>
                                <label class="col-sm-1 control-label">证件：</label>
                                <div class="col-sm-3">
                                    <input  name="customerIdentity" minlength="2" id="customerIdentity"  required="" aria-required="true" placeholder="请输入入住人的证件号"  maxlength="20" type="text" value="" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" class="div" id="ffid">
                            <div class="form-group" id="fid">
                                <div class="col-sm-2">
                                    <input  name="first" minlength="2" id="checkinTime0"  maxlength="20" type="datetime" value="" class="form-control  date form_datetime" placeholder="入住时间" data-date-format="yyyy-mm-dd hh:ii:ss" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <input  name="first" minlength="2" style="margin-left:-10px" id="checkoutTime0"  maxlength="20" type="datetime" value="" class="form-control  date form_datetime" onchange="getDays(this.value,0)" placeholder="离店时间" data-date-format="yyyy-mm-dd hh:ii:ss" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <input  name="first" minlength="2" style="margin-left:-20px" id="totalDays0" readonly maxlength="20" type="text" value="" class="form-control" required="" aria-required="true">
                                </div>
                                <div class="col-sm-2">
                                    <select class="form-control" style="margin-left:-30px" onchange="getHouse(this.value,0);" id="houseTypeId0" required name="first">
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <select class="form-control" style="margin-left:-40px" onchange="getHousePrice(this.value,0);" id="houseId0" required name="first">
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <div style="float:left;width:120px">
                                        <input type="number" class="form-control price" placeholder="请输入入住房费" value="0" style="margin-left:-50px" name="first" id="housePrice" />
                                    </div>
                                    <div style="float:right;margin-top: -25px">
                                        <a onclick="removeDiv(this);" id="remove0"><span style="margin-left: 5px"><i class="glyphicon glyphicon-minus-sign" style="color:red"></i></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                            <hr height="5px"/>
                            <a onclick="addDiv();"><i class="glyphicon glyphicon-plus" style="color:green;float:left;margin-top: -16px">新增房间</i></a>
                            <i class="glyphicon glyphicon-usd" style="color:green;float:right;margin-top: -16px">房费总计：<span id="sumMoney"></span></i>
                            <input type="hidden" id="sum_money" />
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1">
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="hotelItemType" id="hotel0" value="0">
                                </label>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">支付类型：</label>
                            <div class="col-sm-2" style="margin-left:-30px">
                                <select class="form-control" id="itemType" required name="type">
                                    <option value="0">在线预付</option>
                                    <option value="1">担保现付</option>
                                </select>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">渠道选择：</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="websiteId" required name="websiteId" style="margin-left: -30px">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1">
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="hotelItemType" id="hotel1" value="1">
                                </label>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">商家送客：</label>
                            <div class="col-sm-2" style="margin-left:-30px">
                                <select class="form-control"  name="othersHotelId" required id="othersHotel_id">
                                    <option value="-1">请选择来往合作商家</option>
                                </select>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">结算状态：</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="is_cash" name="isCash1" style="margin-left: -30px">
                                    <option value="0" >未结算</option>
                                    <option value="1">已结算</option>
                                </select>
                            </div>
                            <label class="col-sm-2 control-label" style="margin-left: -40px">支付类型：</label>
                            <div class="col-sm-2" style="margin-left:-30px">
                                <select class="form-control" id="paymentType_Id" required name="paymentTypeId">
                                    <option value="-1">请选择支付类型</option>
                                </select>
                            </div>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                            <hr height="5px"/>
                        </div>
                        <div class="form-group">
                            <div  class="form-group col-sm-12">
                                <div class="col-sm-1">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="hotelItemType" id="hotel2" value="2">
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">借房商家：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" id="othersHotelId" required name="othersHotelId">
                                        <option value="-1">请选择来往合作商家</option>
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">结算金额：</label>
                                <div class="col-sm-2">
                                    <input  name="otherHotelMoney" minlength="2" style="margin-left:-30px" maxlength="20" type="number" placeholder="结算金额" value="0" class="form-control" required="" aria-required="true">
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">选择房号：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" id="houseId" required name="xnHouse">
                                        <option>虚拟101房间</option>
                                    </select>
                                </div>
                            </div>

                            <div  class="form-group col-sm-12">
                                <div class="col-sm-1">
                                    <label class="checkbox-inline">

                                    </label>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">结算状态：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" id="is_cash1" required name="isCash2">
                                        <option value="0">未结算</option>
                                        <option value="1">已结算</option>
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label" style="margin-left: -40px">结算账户：</label>
                                <div class="col-sm-2" style="margin-left:-30px">
                                    <select class="form-control" id="otherHotelMoneyType" required name="otherHotelMoneyType">
                                        <option value="-1">请选择结算账户</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div  class="form-group" style="margin-top: -30px;">
                        <hr height="5px"/>
                        <i class="glyphicon glyphicon-usd" style="color:red;float:left;margin-top: -16px"><span style="color:red">订单盈亏:</span><span style="color:red">--</span><span style="color:red">（房费-结算金额）</span></i>
                    </div>
                        <div class="form-group">
                            <table id="mytab1" name="mytab1" class="table table-hover"></table>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">备注：</label>
                            <div class="col-sm-11">
                                <textarea  name="remark" minlength="2" id="reason1"  maxlength="20" value="" class="form-control" required="" aria-required="true"></textarea>
                            </div>
                        </div>
                        <input type="hidden" name="otherHotel" id="other" />
                        <input type="hidden" name="isCash" id="isCash" />
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" id="additem" class="btn btn-primary">
                                录入订单
                            </button>
                        </div>
                        <input name="typeId" id="typeId" style="display: none;"></input>
                        <textarea name="firstVal" id="firstVal" style="display: none;"></textarea>
                    </form>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="orderAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="otherMoney">
                    新增客户增值业务款项
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="otherMoneyForm">
                    <input type="hidden" name="houseId" value="" id="house_id" />
                    <div class="form-group">
                        <label class="col-sm-3 control-label">科目：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="itemId" required name="itemName">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">客户订单金额：</label>
                        <div class="col-sm-8">
                            <input  name="payMoney" minlength="2" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">支付方式：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="otherHotelMoneyType1" required name="otherHotelMoneyType">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">结算状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control"  required name="isCash">
                                <option value="0">未结算</option>
                                <option value="1">已结算</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账目说明：</label>
                        <div class="col-sm-8">
                            <textarea  name="remark" class="form-control" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" id="otherMoneyAdd" class="btn btn-primary">
                            确认新增
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<div class="modal fade" id="updateHouseHander" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="updateModalLabel">
                    订单的修改
                </h4>
            </div>
            <div class="modal-body">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#home" data-toggle="tab">
                            退房
                        </a>
                    </li>
                    <li><a href="#ios" data-toggle="tab">换房</a></li>

                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="home">
                        <br/>
                        <form class="form-horizontal" method="post" id="tuifang">
                            <input type="hidden" name="id" id="" value=""/>
                            <input type="hidden" name="houseId" value="" />
                            <input type="hidden" name="hotelId" value="" />
                            <div class="form-group">
                                <label class="col-sm-3 control-label">客户姓名：</label>
                                <div class="col-sm-8">
                                    <input  name="customerName" readonly minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">缴纳押金：</label>
                                <div class="col-sm-8">
                                    <input  name="deposit" minlength="2" readonly maxlength="20" type="number" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">退款金额：</label>
                                <div class="col-sm-8">
                                    <input  name="actualReturn" minlength="2" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">退房备注：</label>
                                <div class="col-sm-8">
                                    <textarea  name="remark" class="form-control" required="" aria-required="true"></textarea>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" id="tuikuan" class="btn btn-primary">
                                    确认退房
                                </button>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="ios">
                        <br/>
                        <form class="form-horizontal" method="post" id="huanfang">
                            <input type="hidden" name="id"  value=""/>
                            <input type="hidden" name="houseId" value="" />
                            <input type="hidden" id="lv" name="checkoutTime" value="" />
                            <input type="hidden" name="hotelId" value="" />
                            <div class="form-group">
                                <label class="col-sm-3 control-label">客户姓名：</label>
                                <div class="col-sm-8">
                                    <input  name="customerName" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">原住房间：</label>
                                <div class="col-sm-8">
                                    <input  name="srcHouse" minlength="2" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">新住房间：</label>
                                <div class="col-sm-8">
                                    <select class="form-control" id="newHouse" required name="newHouse">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">换房备注：</label>
                                <div class="col-sm-8">
                                    <textarea  name="remark" class="form-control" required="" aria-required="true"></textarea>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" id="endHouse" class="btn btn-primary">
                                    确认换房
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/customerOrder.js"></script>
<script src="<%=path%>/static/js/pageJs/addHouseMoney.js"></script>
</body>
<script>
    $('#orderAdd').on('hidden.bs.modal', function() {
        $('#itemsModule').css({'overflow-y':'scroll'});
    });
    $("#additem").click(function info(){
        var obj2=document.getElementsByName('hotelItemType');
        var s='';
        var val="";
        for(var i=0; i<obj2.length; i++){
            if(obj2[i].checked){
                s++;
                val=obj2[i].value;
            }
        }
        //商家送客
        if(val==1){
            $("#isCash").val($("#is_cash").val());
            $("#other").val($("#othersHotel_id").val());
        }else if(val==2){
            $("#isCash").val($("#is_cash1").val());
            $("#other").val($("#othersHotelId").val());
        }
        if(s==''){
            layer.msg('请勾选操作类别', {icon:2,time:1500});
            return;
        }
        if(s!=1){
            layer.msg('只允许勾选一个操作类别', {icon:2,time:1500});
            return;
        }
        if(s==1){
            $("#typeId").val(val);
            var first=document.getElementsByName('first');
            var firstVal="";
            var cnt = first.length;
            for(var i=0; i<cnt; i++){
                if((i+1)%6==0 && i!=0){
                    firstVal+= first[i].value+";";
                }else{
                    firstVal+= first[i].value+",";
                }
            }
            $("#firstVal").text(firstVal);
            $.post(
                "/customerOrder/customerOrderAddSave",
                $("#info").serialize(),
                function(data){
                   if(data.message.indexOf("成功")>0){
                       layer.msg(data.message, {icon:1,time:1000});
                   }else{
                       layer.alert(data.message, {icon:6});
                   }
                   refush();
                    $('#itemsModule').modal('hide')
                },"json"
            );
        }
    });
    window.setInterval(function(){
        var moneyVal="0";
        $("#ffid input[id='housePrice']").each(function(){
            moneyVal=parseInt(moneyVal)+parseInt($(this).val());
        });
        $("#sum_money").val(parseInt(moneyVal));
        $("#sumMoney").html(parseInt(moneyVal));
    }, 500);
    $("#otherMoneyAdd").click(function () {
        $.post(
            "/item/houseOthersItemAddSave",
            $("#otherMoneyForm").serialize(),
            function(data){
                if(data.message.indexOf("成功")>0){
                    layer.msg(data.message, {icon:1,time:1000});
                }else{
                    layer.alert(data.message, {icon:6});
                }
                refush();
                $("#orderAdd").modal('hide');
            },"json"
        );
    });
</script>
<script>
    //退房
    $("#tuikuan").click(function () {
        $.post(
            "/customerOrder/endHouse",
            $("#tuifang").serialize(),
            function (data) {
                if(data.message=="ok"){
                    layer.msg("退房成功!", {icon:1,time:1000});
                }else{
                    layer.msg("退房失败", {icon:2,time:1000});
                }
                refush();
                $("#updateHouseHander").modal('hide');
            },
            "json"
        );
    });
    //换房
    $("#endHouse").click(function () {
        $.post(
            "/customerOrder/changeHouse",
            $("#huanfang").serialize(),
            function (data) {
                if(data.message=="ok"){
                    layer.msg("换房成功!", {icon:1,time:1000});
                }else{
                    layer.msg("换房失败", {icon:2,time:1000});
                }
                refush();
                $("#updateHouseHander").modal('hide');
            },
            "json"
        );
    });

</script>
<%--
<script>
    var cnt = 0;
    function addDiv(){
        cnt++;
        var divHtml = '<div class="form-group" id="fid"> \n' +
            '\t<div class="col-sm-2">\n' +
            ' <input  name="checkinTime" minlength="2" id="checkinTime'+cnt+'"  maxlength="20" type="datetime" value="" class="form-control  date form_datetime" placeholder="入住时间" data-date-format="yyyy-mm-dd hh:ii:ss" required="" aria-required="true">\n' +
            '     </div>\n' +
            '     <div class="col-sm-2">\n' +
            '         <input  name="checkoutTime" minlength="2" id="checkoutTime'+cnt+'"  maxlength="20" type="datetime" value="" class="form-control  date form_datetime" onchange="getDays(this.value,cnt)" placeholder="离店时间" data-date-format="yyyy-mm-dd hh:ii:ss" required="" aria-required="true">\n' +
            '     </div>\n' +
            '     <div class="col-sm-2">\n' +
            '         <input  name="totalDays" minlength="2" id="totalDays'+cnt+'" readonly maxlength="20" type="text" value="" class="form-control" required="" aria-required="true">\n' +
            '     </div>\n' +
            '     <div class="col-sm-2">\n' +
            '         <select class="form-control" onchange="getHouse(this.value,cnt);" id="houseTypeId'+cnt+'" required name="houseTypeId">\n' +
            '         </select>\n' +
            '     </div>\n' +
            '     <div class="col-sm-2">\n' +
            '         <select class="form-control" onchange="getHousePrice(this.value,cnt);" id="houseId'+cnt+'" required name="houseId">\n' +
            '         </select>\n' +
            '     </div>\n' +
            '     <div class="col-sm-2">\n' +
            '         <button type="button" style="background-color: inherit;border: 0" class="btn btn-default"><span class="glyphicon glyphicon-usd" name="houseP" style="color:blue" id="houseP'+cnt+'"></span></button>\n' +
            '         <a onclick="removeDiv(this);" id="remove'+cnt+'"><span style="margin-left: 5px"><i class="glyphicon glyphicon-minus-sign" style="color:red"></i></span></a>\n' +
            '     </div>\n' +
            ' </div>';
        $("#ffid").append(divHtml);
        addDivHouse(cnt);
        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            language: 'zh-CN',
            autoclose: true,
            todayHighlight: true
        });
    }
    $(function () {
        $.post(
            "/customerOrder/getTypeList",
            function(data){
                $("#houseTypeId0").select2({
                    data: data
                });
                $.post(
                    "/customerOrder/getHouse/"+data[0].id,
                    function(data){
                        $("#houseId0").select2({
                            data: data
                        });
                        $.post(
                            "/house/findHouse/"+data[0].id,
                            function(data){
                                $("#houseP0").html(data.unitPrice);
                                $("#sumMoney").html(parseInt($("#houseP0").html()));
                            },
                            "json"
                        );
                    },
                    "json"
                );
            },
            "json"

        );
        //支付类型列表
        $.post(
            "/customerOrder/getSubject",
            function(data){
                $("#paymentTypeId").select2({
                    data: data
                });
                $("#paymentType_Id").select2({
                    data: data
                })
            },
            "json"

        );
        //网站列表
        $.post(
            "/customerOrder/getWeb",
            function(data){
                $("#websiteId").select2({
                    data: data
                })
            },
            "json"

        );
        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            language: 'zh-CN',
            autoclose: true,
            todayHighlight: true
        });
    });
    function getHouse(id,cnt){
        $.post(
            "/customerOrder/getHouse/"+id,
            function(data){
                if(data==null || data==""){
                    $("#houseId"+cnt).html("<option value='-1'>无数据</option>");
                    $("#houseP"+cnt).html(0.0);
                }else{
                    $("#houseId"+cnt).html("");
                    $("#houseId"+cnt).select2({
                        data: data
                    });
                    $.post(
                        "/house/findHouse/"+data[0].id,
                        function(data){
                            $("#houseP"+cnt).html(data.unitPrice);
                            var number = "0";
                            for(var i=0;i<=cnt;i++){
                                number=parseInt(number)+parseInt($("#houseP"+i).html());
                            }
                            $("#sumMoney").html(parseInt(number));
                        },
                        "json"
                    );
                }
            },
            "json"
        );
    }
    function getHousePrice(id,cnt){
        if(id==-1){
            layer.msg('房间不存在', {icon:2,time:1000});
        }else{
            $.post(
                "/house/findHouse/"+id,
                function(data){
                    var days = $("#totalDays"+cnt).val();
                    if(days==""){
                        $("#houseP"+cnt).html(data.unitPrice);
                        var number = "0";
                        for(var i=0;i<=cnt;i++){
                            number+=parseInt($("#houseP"+i).html());
                        }
                        $("#sumMoney").html(parseInt(number));
                    }else{
                        $("#houseP"+cnt).html(parseInt(days.substring(0,days.length-1))*parseInt(data.unitPrice));
                        var number = "0";
                        for(var i=0;i<=cnt;i++){
                            number=parseInt(number)+parseInt($("#houseP"+i).html());
                        }
                        $("#sumMoney").html(parseInt(number));
                    }

                },
                "json"
            );
        }
    }
    function getDays(val,cnt) {
        var src = $("#checkinTime"+cnt).val();
        if(src==""){
            layer.msg('入住时间不能为空', {icon:2,time:1000});
        }else{
            var num = dateDiff(src.substring(0,10),val.substring(0,10))+"天";
            var numberVal = dateDiff(src.substring(0,10),val.substring(0,10))
            $("#totalDays"+cnt).val(num);
            $("#houseP"+cnt).html(parseInt($("#houseP"+cnt).html())*numberVal);
            var number = "0";
            for(var i=0;i<=cnt;i++){
                number=parseInt(number)+parseInt($("#houseP"+i).html());
            }
            $("#sumMoney").html(parseInt(number));
        }
    }
    function getSum(num){
        alert(num);
    }
    function dateDiff(startDateString, endDateString){
        var separator = "-"; //日期分隔符
        var startDates = startDateString.split(separator);
        var endDates = endDateString.split(separator);
        var startDate = new Date(startDates[0], startDates[1]-1, startDates[2]);
        var endDate = new Date(endDates[0], endDates[1]-1, endDates[2]);
        return parseInt(Math.abs(endDate - startDate ) / 1000 / 60 / 60 /24);//把相差的毫秒数转换为天数
    };
    function addDivHouse(id){
        $.post(
            "/customerOrder/getTypeList",
            function(data){
                $("#houseTypeId"+id).select2({
                    data: data
                });
                $.post(
                    "/customerOrder/getHouse/"+data[0].id,
                    function(data){
                        $("#houseId"+id).select2({
                            data: data
                        });
                        $.post(
                            "/house/findHouse/"+data[0].id,
                            function(data){
                                $("#houseP"+id).html(data.unitPrice);
                                $("#sumMoney").html(parseInt($("#sumMoney").html())+parseInt($("#houseP"+id).html()));
                            },
                            "json"
                        );
                    },
                    "json"
                );
            },
            "json"

        );
    }
    function removeDiv(e){
        $(e).parent().parent().remove();
        var num="0";
        var obj = document.getElementsByName("houseP");
        for(i=0;i<obj.length;i++){
            num = parseInt(num)+parseInt($("#"+obj[i].id).html());
        }
        $("#sumMoney").html(parseInt(num));
    }
</script>
--%>
</html>
