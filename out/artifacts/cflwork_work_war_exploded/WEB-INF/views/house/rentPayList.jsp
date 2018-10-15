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
    <title>分成房租列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
    <style>
        .innerbox {
            height: 150px;
            overflow-x: scroll;
            white-space: nowrap;
        }

        /*滚动条样式*/
        .innerbox::-webkit-scrollbar { /*滚动条整体样式*/
            width: 4px; /*高宽分别对应横竖滚动条的尺寸*/
            height: 4px;
        }

        .innerbox::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
            border-radius: 5px;
            -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
            background: rgba(0, 0, 0, 0.2);
        }

        .innerbox::-webkit-scrollbar-track { /*滚动条里面轨道*/
            -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
            border-radius: 0;
        }

        .innerbox1 {
            height: 100%;
            position: relative;
            display: inline-block;
            width: 120px;
            margin-left: 10px;
        }

        .title1 {
            height: 30%;
            width: 100%;
            text-align: center;
            font-size: 18px;
            line-height: 40px;
            border-bottom: solid 1px #ccc;
        }

        .title2 {
            height: 30%;
            width: 100%;
            text-align: center;
            line-height: 50px;
            font-size: 16px;
        }

        .title3 {
            height: 30%;
            width: 76%;
            color: #908c8c;
            text-align: center;
            font-size: 14px;
            margin: auto;

        }
    </style>
</head>
<body class="gray-bg">
<div class="col-lg-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>分成房租明细统计</h5>
        </div>
        <div class="ibox-content">
            <div class="row" style="height: 260px">
                <div class="col-xs-3" style="height: 100%;border-right: solid 1px #87cbcc">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right"></span>
                            <h5>营收或成本录入</h5>
                        </div>
                        <div class="ibox-content">
                            <div style="height: 40px;width: 100%;line-height: 40px">
                                当前有<span style="color: red">n</span>个店面未录入营收数据<a style="color: #0d8ddb;font-size: 16px;" onclick="otherHotel()">查看</a>
                            </div>
                            <div style="width: 100%;height:120px;">
                                <div class="col-xs-6">
                                    <div style="width: 120px;height: 120px;border: solid 3px #009fed;border-radius: 100%;font-size: 40px;font-weight: bold;color: #009fed;text-align: center;margin: auto">
                                        营收录入
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div style="width: 120px;height: 120px;border: solid 3px #3db901;border-radius: 100%;font-size: 40px;font-weight: bold;color: #3db901;text-align: center;margin: auto">
                                        成本录入
                                    </div>
                                </div>
                            </div>
                            <div style="width: 100%;height:40px;">
                                <div class="col-xs-6"
                                     style="text-align: center;line-height: 45px;color: #009fed;font-size: 16px;cursor: pointer;" onclick="income();">
                                    查看详情
                                </div>
                                <div class="col-xs-6"
                                     style="text-align: center;line-height: 45px;color: #3db901;font-size: 16px;cursor: pointer;"  onclick="outcome();">
                                    查看详情
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-9" style="height: 100%">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right"></span>
                            <h5>营收或成本录入</h5>
                        </div>
                        <div class="ibox-content">
                            <div style="width: 100%;height: 40px;">
                                <div style="height: 40px;width: 40%;text-align: right;margin: auto;float: right">
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <input type="text" id="test5" class="form-control"
                                                   placeholder="选择起始时间">
                                        </div>
                                        <div class="col-sm-6">
                                            <select class="form-control" onchange="getPayList();" id="hotelId__"
                                                    required name="hotelId">

                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div style="width: 100%;height:150px;">
                                <div class="col-xs-10 innerbox" id="payList">
                                    <div class="innerbox1" v-for="site in sites">
                                        <div class="title1">
                                            <b>{{site.title}}</b>
                                        </div>
                                        <div class="title2">
                                            ￥{{site.money}}
                                        </div>
                                        <div class="title3">
                                            <div style="white-space: normal;">
                                                {{site.endTime | formatTime }}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-2" style="height: 100%">
                                    <div class="col-xs-12"
                                         style="height: 40%;text-align: center;font-size: 20px;line-height:40px;font-weight: bold">
                                        合计
                                    </div>
                                    <div class="col-xs-12"
                                         style="height: 40%;text-align: center;color: red;font-size: 30px;line-height: 100px"
                                         id="sumMoney">
                                        0.00
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--统计各项数据--%>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全年</span>
                    <h5>所有店面</h5>
                </div>
                <div class="ibox-content">
                    <select class="form-control" id="hotelId_" onchange="getInfo(this.value)" required name="masterId">
                        <option value="">所有店面</option>
                    </select>
                    <div class="stat-percent font-bold text-info">20%
                        <i class="fa fa-level-up"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全年</span>
                    <h5>分成房源总数/间</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="rentHouseCount"></h1>
                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                    </div>
                    <small>房源总数</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全年</span>
                    <h5>分成房源总面积/平米</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="rentHouseSumArea"></h1>
                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                    </div>
                    <small>总面积/平米</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全年</span>
                    <h5>今日单平营业额/元</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="money"></h1>
                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                    </div>
                    <small>单平收益/元</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全年</span>
                    <h5>当前应结算房源总数/间</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="payMoneyHouse">0</h1>
                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                    </div>
                    <small>结算房源总数/间</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全年</span>
                    <h5>当前可结算分成总额/元</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="sumMoney"></h1>
                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                    </div>
                    <small>分成总额/元</small>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>分成房租列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    搜索条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label">创建时间</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="test11" />
                    </div>
                    <label class="col-sm-1 control-label">姓名</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="bankAccountName"/>
                    </div>
                    <label class="col-sm-1 control-label">电话</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="phone"/>
                    </div>
                    <label class="col-sm-1 control-label">房源状态</label>
                    <div class="col-sm-2">
                        <select name="isActive" class="form-control" id="status" required>
                            <option value="">全部</option>
                            <option value="0">启用</option>
                            <option value="1">禁用</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label">房源归属</label>
                    <div class="col-sm-2">
                        <select class="form-control" id="hotel_Ids" required name="hotelId">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label">房间名称</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="houseName" name="houseName"/>
                    </div>
                    <label class="col-sm-1 control-label">分成方式</label>
                    <div class="col-sm-2">
                        <select class="form-control" required id="payMoneyType">
                            <option value="0">有成本</option>
                            <option value="1">无成本</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label">付款方式</label>
                    <div class="col-sm-2">
                        <select class="form-control" required name="payType" id="payType">
                            <option value="">全部</option>
                            <option value="1">1/月付</option>
                            <option value="2">2/月付</option>
                            <option value="3">3/月付</option>
                            <option value="4">4/月付</option>
                            <option value="6">6/月付</option>
                            <option value="12">12/月付</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label">备注</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="descriptions" name="description"/>
                    </div>
                    <div class="col-sm-3">
                        <button class="btn btn-primary col-sm-12 " id="search_btn">查询</button>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <table id="mytab" name="mytab" class="table table-hover"></table>
                </div>
            </div>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                <button id="btn_edit" type="button" class="btn btn-default" style="display: block; border-radius: 0">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                </button>
                <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default"
                        style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量删除
                </button>
                <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#webAdd">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                </button>
            </div>
        </div>
    </div>
</div>
<%--网站数据的新增--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="webAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog  modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="webAddTitle">
                    新增分成房租
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">业主姓名：</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="master_Id" required name="masterId">

                            </select>
                        </div>
                        <label class="col-sm-2 control-label">房源归属：</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="hotel_Id" required name="hotelId">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房间名称：</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="house_Id" required name="houseId">

                            </select>
                        </div>
                        <label class="col-sm-2 control-label">分成方式：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required name="payMoneyType">
                                <option value="0">有成本</option>
                                <option value="1">无成本</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">签约年限：</label>
                        <div class="col-sm-4">
                            <input name="payTime" min="0" max="100" placeholder="签约年限" type="number"
                                   class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">支付类型：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required name="payType">
                                <option value="1">1/月付</option>
                                <option value="2">2/月付</option>
                                <option value="3">3/月付</option>
                                <option value="4">4/月付</option>
                                <option value="6">6/月付</option>
                                <option value="12">12/月付</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">首次支付日期：</label>
                        <div class="col-sm-4">
                            <input name="payPeriodStart" minlength="2" id="test2" maxlength="20" placeholder="请输入首次支付时间"
                                   type="text" value="" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">合同开始日期：</label>
                        <div class="col-sm-4">
                            <input name="factPayTimeStart" minlength="2" maxlength="20" type="text"
                                   placeholder="请输入合同开始日期" id="test1" value="" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">结算状态：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required name="isCash">
                                <option value="0">未结算</option>
                                <option value="1">已结算</option>
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">房间面积：</label>
                        <div class="col-sm-4">
                            <input name="area" min="0" placeholder="房间面积" max="100" type="text" class="form-control"
                                   required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">

                        <label class="col-sm-2 control-label">分成比例</label>
                        <div class="col-sm-4">
                            <input name="payProportion" min="0" placeholder="分成比例" max="1" type="number"
                                   class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">备注</label>
                        <div class="col-sm-11">
                            <textarea name="description" placeholder="备注" minlength="2" id="reason1" value=""
                                      class="form-control" required="" aria-required="true"></textarea>
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
<%--网站新增结束--%>
<%--网站信息的修改--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog  modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    修改分成房租
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="updateform">
                <input type="hidden" name="id">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">业主姓名：</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="masterId" required name="masterId">

                            </select>
                        </div>
                        <label class="col-sm-2 control-label">房源归属：</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="hotelId" required name="hotelId">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房间名称：</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="houseId" required name="houseId">

                            </select>
                        </div>
                        <label class="col-sm-2 control-label">分成方式：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required name="payMoneyType">
                                <option value="0">有成本</option>
                                <option value="1">无成本</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">签约年限：</label>
                        <div class="col-sm-4">
                            <input name="payTime" min="0" max="100" placeholder="签约年限" type="number"
                                   class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">支付类型：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required name="payType">
                                <option value="1">1/月付</option>
                                <option value="2">2/月付</option>
                                <option value="3">3/月付</option>
                                <option value="4">4/月付</option>
                                <option value="6">6/月付</option>
                                <option value="12">12/月付</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">首次支付日期：</label>
                        <div class="col-sm-4">
                            <input name="payPeriodStart" minlength="2" id="test3" maxlength="20" placeholder="请输入首次支付时间"
                                   type="text" value="" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">合同开始日期：</label>
                        <div class="col-sm-4">
                            <input name="factPayTimeStart" minlength="2" maxlength="20" type="text"
                                   placeholder="请输入合同开始日期" id="test4" value="" class="form-control" required=""
                                   aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">结算状态：</label>
                        <div class="col-sm-4">
                            <select class="form-control" required name="isCash">
                                <option value="0">未结算</option>
                                <option value="1">已结算</option>
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">房间面积：</label>
                        <div class="col-sm-4">
                            <input name="area" min="0" placeholder="房间面积" max="100" type="text" class="form-control"
                                   required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">

                        <label class="col-sm-2 control-label">分成比例</label>
                        <div class="col-sm-4">
                            <input name="payProportion" min="0" placeholder="分成比例" max="1" type="number"
                                   class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">备注</label>
                        <div class="col-sm-11">
                            <textarea name="description" placeholder="备注" minlength="2" id="description" value=""
                                      class="form-control" required="" aria-required="true"></textarea>
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
<!-- 模态框（Modal） -->
<div class="modal fade" id="fukuan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">分成房租付款</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="fu_kuan">
                    <input type="hidden" name="id" id="id"/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">本期应还金额</label>
                        <div class="col-sm-8">
                            <input id="first_pay" name="firstPay" min="0" max="100" type="text" class="form-control"
                                   required="" value="" aria-required="true">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" id="huankuan" class="btn btn-primary">确认还款</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/rentPay.js"></script>
<script src="<%=path%>/static/js/select2.min.js"></script>
<script src="<%=path%>/static/js/vue.js"></script>
</body>
<script>
    lay('#version').html('-v' + laydate.v);
    //执行一个laydate实例
    laydate.render({
        elem: '#test1' //指定元素
    });
    laydate.render({
        elem: '#test2' //指定元素
    });
    laydate.render({
        elem: '#test3' //指定元素
    });
    laydate.render({
        elem: '#test4' //指定元素
    });
    laydate.render({
        elem: '#test11' //指定元素
        , range: true
    });
    laydate.render({
        elem: '#test5' //指定元素
        , type: 'date'
        , range: true
        ,done: function(value, date, endDate){
            $("#test5").val(value);
            getPayList();
        }
    });
    $(function () {
        $.post(
            "/houseRentPay/getContractMaster",
            function (data) {

                $("#master_Id").select2({
                    data: data
                })
                $("#masterId").select2({
                    data: data
                })
                $("#select2-master_Id-container").remove();
                $("#select2-masterId-container").remove();
            },
            "json"
        );
        $.post(
            "/houseRentPay/getHotel",
            function (data) {

                $("#hotel_Id").select2({
                    data: data
                })
                $("#hotelId").select2({
                    data: data
                })
                $("#hotelId_").select2({
                    data: data
                })
                $("#hotelId__").select2({
                    data: data
                })
                $("#select2-hotel_Id-container").remove();
                $("#select2-hotelId-container").remove();
                $("#select2-hotelId_-container").remove();
                $("#select2-hotelId__-container").remove();
                $.post(
                    "/rentPay/getHouse/" + data[0].id,
                    function (data) {
                        $("#houseId").select2({
                            data: data
                        })
                        $("#house_Id").select2({
                            data: data
                        })
                        $("#select2-houseId-container").remove();
                        $("#select2-house_Id-container").remove();
                    },
                    "json"
                );
            },
            "json"
        );
    });

    function getHouse(id) {
        $.post(
            "/rentPay/getHouse/" + id,
            function (data) {
                $("#houseId").select2({
                    data: data
                })
                $("#house_Id").select2({
                    data: data
                })
                $("#select2-houseId-container").remove();
                $("#select2-house_Id-container").remove();
            },
            "json"
        );
    }

    $(function () {
        getHotelInfo();
    });

    function getInfo(id) {
        getHotelInfo();
    }

    function getHotelInfo() {
        var hotelId = $("#hotelId_").val();
        $.post(
            "<%=path%>/rentPay/hotelInfo",
            {
                "hotelId": hotelId
            },
            function (data) {
                $("#rentHouseCount").html(data.rentHouseCount);//房源总数
                $("#rentHouseSumArea").html("￥" + data.rentHouseSumArea);//分成房源总面积
                $("#money").html("￥" + data.money);//单平收益
                $("#payMoneyHouse").html("￥" + data.payMoneyHouse);//待结算的房间
                $("#sumMoney").html("￥" + data.sumMoney);//总金额
            },
            "json"
        );
    }

    getPayList();
    var vm = new Vue({
        el: '#payList',
        data: {
            sites: ''
        }
    })

    function getPayList() {
        var times = $("#test5").val();
        var timeArray = times.split(" - ");
        $.post(
            "/rentPay/getSubjectMoney",
            {
                "time1": timeArray[0],
                "time2": timeArray[1],
                "hotelId": $("#hotelId__").val()
            },
            function (data) {
                console.log(data);
                vm.$data.sites = data;
                var moneys = 0.0;
                for (var i = 0; i < data.length; i++) {
                    moneys = parseFloat(moneys) + parseFloat(data[i].money);
                }
                $("#sumMoney").text("￥"+moneys);
            }, "json"
        );
    }

    Vue.filter('formatTime', function (value) {
        var times = $("#test5").val();
        var timeArray = times.split(" - ");
        var date = new Date(value);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        var h = date.getHours();
        var mi = date.getMinutes();
        var ss = date.getSeconds();
        if(!timeArray[0]){
            if(value<new Date().getTime()){
                return getTimes()+"起"+y + '-' + (m<10?"0"+m:m) + '-' + (d<10?"0"+d:d)+"止";
            }else if(value>new Date().getTime()){
                return getTimes()+"起"+formattimes(new Date())+"止";
            }
        }else{
            if(value<new Date(timeArray[1]).getTime()){
                return timeArray[0]+"起"+y + '-' + (m<10?"0"+m:m) + '-' + (d<10?"0"+d:d)+"止";
            }else if(value>new Date(timeArray[1]).getTime()){
                return timeArray[0]+"起"+timeArray[1]+"止";
            }
        }

    });
    function  getTimes() {
        var date = new Date();
        var y = date.getFullYear();
        var m = date.getMonth() -2;
        var d = date.getDate();
        var h = date.getHours();
        var mi = date.getMinutes();
        var ss = date.getSeconds();
        return y + '-' + (m<10?"0"+m:m) + '-' + (d<10?"0"+d:d) ;

    }
    $("#test5").val(getTimes()+" - "+formattimes(new Date()));
    function  defauleTime() {
        var date = new Date();
        var y = date.getFullYear();
        var m = date.getMonth() -2;
        var d = date.getDate();
        var h = date.getHours();
        var mi = date.getMinutes();
        var ss = date.getSeconds();
        var mm = date.getMonth()+1;
        return y + '-' + (m<10?"0"+m:m) + '-' + (d<10?"0"+d:d)+" - "+y + '-' + (mm+3<10?"0"+mm:mm) + '-' + (d<10?"0"+d:d) ;

    }
    $('#test5').bind('input propertychange', function() {
        alert("-------------");
    });

    function income(){
        layer.open({
            type : 2,
            title : '收入列表',
            maxmin : true,
            shadeClose : false,
            area : [ '1000px', '520px' ],
            content : '/income/incomePage'
        });
    }

    function outcome(){
        layer.open({
            type : 2,
            title : '支出列表',
            maxmin : true,
            shadeClose : false,
            area : [ '1000px', '520px' ],
            content : '/outcome/outcomePage'
        });
    }
    function otherHotel() {
        layer.open({
            type : 2,
            title : '支出列表',
            maxmin : true,
            shadeClose : false,
            area : [ '1000px', '520px' ],
            content : '/rentPay/otherHotelPage'
        });
    }
</script>
</html>
