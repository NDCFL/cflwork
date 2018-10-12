<%--
  Created bytelliJ IDEA.
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
    <meta name="viewport" content="width=device-width,itial-scale=1.0">
    <title>房租列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
    <style>
        label {
            margin-top: 5px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">当年</span>
                    <h5>所有店面</h5>
                </div>
                <div class="ibox-content">
                    <select class="form-control" id="hotelId_" onchange="getInfo(this.value)" required name="masterId">
                        <option value="">所有店面</option>
                    </select>
                    <div class="stat-percent font-bold text-info">
                    </div>
                    <small>&nbsp;&nbsp;&nbsp;&nbsp;</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">当年</span>
                    <h5>房源总数</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="houseTotal"></h1>
                    <div class="stat-percent font-bold text-info">
                    </div>
                    <small>房源总数</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">当年</span>
                    <h5>待付资金</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="dfPayMoney"></h1>
                    <div class="stat-percent font-bold text-info">
                    </div>
                    <small>待付资金</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">当年</span>
                    <h5>平均每月</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="monthPayMoney"></h1>
                    <div class="stat-percent font-bold text-info">
                    </div>
                    <small>平均每月</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">当年</span>
                    <h5>每间/每月</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="houseMonthPayMoney"></h1>
                    <div class="stat-percent font-bold text-info">
                    </div>
                    <small>每间/每月</small>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">当年</span>
                    <h5>每间/每天</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="houseDayPayMoney"></h1>
                    <div class="stat-percent font-bold text-info">
                    </div>
                    <small>每间/每天</small>
                </div>
            </div>
        </div>
    </div>

</div>
<div class="col-lg-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>房租明细统计</h5>
        </div>
        <div class="ibox-content">
            <div class="row">
                <div class="col-xs-2" id="cq" onclick="chaoqi(0);">
                    <small class="stats-label"><h4>超期未付</h4></small>
                    <h2 id="chaoqiPayMoney"></h2>
                    <hr/>
                    <small class="stats-label">已超期未支付租金总额</small>
                </div>

                <div class="col-xs-2" onclick="chaoqi(1);">
                    <small class="stats-label"><h4>近五日待付</h4></small>
                    <h2 id="fiveDayPayMoney"></h2>
                    <hr/>
                    <small class="stats-label">近五日急付租金总额</small>
                </div>
                <div class="col-xs-2" onclick="chaoqi(2);">
                    <small class="stats-label"><h4>本月应付</h4></small>
                    <h2 id="thisMonthPayMoney"></h2>
                    <hr/>
                    <small class="stats-label">本月应付租金总额</small>
                </div>
                <div class="col-xs-2" onclick="chaoqi(3);">
                    <small class="stats-label"><h4>本月已付租金总额</h4></small>
                    <h2 id="thisMonthPayAll"></h2>
                    <hr/>
                    <small class="stats-label">本月已付租金总额</small>
                </div>
                <div class="col-xs-2" onclick="chaoqi(4);">
                    <small class="stats-label"><h4>本月待付</h4></small>
                    <h2 id="thisMonthNotPay"></h2>
                    <hr/>
                    <small class="stats-label">本月待付租金总额</small>
                </div>
                <div class="col-xs-2"  onclick="chaoqi(5);">
                    <small class="stats-label"><h4>次月应付</h4></small>
                    <h2 id="nextMonthPay"></h2>
                    <hr/>
                    <small class="stats-label">次月应付租金总额</small>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>房租列表</h5>
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
                        <input type="text" class="form-control" id="bankAccountName"
                               name="contractMasterVo.bankAccountName"/>
                    </div>
                    <label class="col-sm-1 control-label">电话</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="phone" name="contractMasterVo.phone"/>
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
                    <label class="col-sm-1 control-label">房号</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="houseName" name="houseName"/>
                    </div>
                    <label class="col-sm-1 control-label">签约年限</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="payTime" id="payTime"/>
                        <%--<select name="payTime" id="payTime" class="form-control"  required >--%>
                        <%--<option value="">全部</option>--%>
                        <%--<option value="1">1年</option>--%>
                        <%--<option value="2">2年</option>--%>
                        <%--<option value="3">3年</option>--%>
                        <%--<option value="4">4年</option>--%>
                        <%--<option value="5">5年</option>--%>
                        <%--<option value="6">6年</option>--%>
                        <%--<option value="7">7年</option>--%>
                        <%--<option value="8">8年</option>--%>
                        <%--<option value="9">9年</option>--%>
                        <%--<option value="10">10年</option>--%>
                        <%--</select>--%>
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
            </div>
            <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                <%--<button id="btn_edit" type="button" class="btn btn-default" style="display: block; border-radius: 0">--%>
                <%--<span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>修改--%>
                <%--</button>--%>
                <%--<button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">--%>
                <%--<span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量删除--%>
                <%--</button>--%>
                <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量修改状态
                </button>
                <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#webAdd">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="remark_modal" tabindex="-1" role="dialog" aria-labelledby="remark_modal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    房源备注
                </h4>
            </div>
            <div class="modal-body" id="remarks">

            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <div class="modal fade" id="updateStatus" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" >
                        批量修改状态
                    </h4>
                </div>
                <form class="form-horizontal" method="post" id="update_status">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房间状态：</label>
                            <div class="col-sm-8">
                                <select class="form-control"  id="statuss" required name="status">
                                    <option value="0">启用</option>
                                    <option value="1">停用</option>
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
        <div class="modal-dialog  modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="webAddTitle">
                        新增房租<span style="color:red;">本合约为多年期合约，系统已为你自动打包成多分整年合约，并依次执行</span>
                    </h4>
                </div>
                <form class="form-horizontal" method="post" id="formadd">
                    <div class="modal-body">
                        <h4 class="modal-title" id="webAddTitle1">
                            签约信息
                        </h4>
                        <hr/>
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
                                <input name="houseName" min="0" id="house_name" placeholder="房间名称" type="text" class="form-control"
                                       required="" aria-required="true">
                            </div>
                            <label class="col-sm-2 control-label">支付总金额：</label>
                            <div class="col-sm-4">
                                <input name="totalPay" id="total_pay" min="0" placeholder="支付总金额" max="100" type="number"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">签约年限：</label>
                            <div class="col-sm-4">
                                <input name="payTime" min="0" id="pay_time" max="100" onchange="addCount(this.value);"
                                       placeholder="签约年限" type="number" class="form-control" required=""
                                       aria-required="true">
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
                                <input name="firstPayTime" minlength="2" id="test2" maxlength="20" type="text" value=""
                                       class="form-control" required="" placeholder="首次支付日期" aria-required="true">
                            </div>
                            <label class="col-sm-2 control-label">合同开始日期：</label>
                            <div class="col-sm-4">
                                <input name="payPeriodStart"  minlength="2" maxlength="20" type="text" id="test1"
                                       value="" class="form-control" required="" placeholder="合同开始日期"  aria-required="true">
                            </div>
                        </div>
                        <div class="form-group" id="house_count">

                        </div>
                        <hr/>
                        <h4 class="modal-title" id="webAddTitle2">
                            房源信息
                        </h4>
                        <hr/>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">面积</label>
                            <div class="col-sm-2">
                                <input name="area" min="0" placeholder="房间面积" max="100" type="text" class="form-control"
                                       required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">楼层</label>
                            <div class="col-sm-2">
                                <input name="houseCount" min="0" placeholder="房间楼层" max="100" type="number"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">装修</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="zhuangxiu">
                                    <option value="0">毛坯</option>
                                    <option value="1">简装</option>
                                    <option value="2">精装</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">水电</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="shuidian">
                                    <option value="0">商水商电</option>
                                    <option value="1">民水民电</option>
                                    <option value="2">商水民电</option>
                                    <option value="3">民水商电</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">空调</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="kongtiao">
                                    <option value="0">有</option>
                                    <option value="1">无</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">供暖</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="gongnuan">
                                    <option value="0">有</option>
                                    <option value="1">无</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">物业</label>
                            <div class="col-sm-2">
                                <input name="wuye" min="0" placeholder="物业费用/平米" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">押金</label>
                            <div class="col-sm-2">
                                <input name="yajin" min="0" placeholder="押金/元" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">布草费</label>
                            <div class="col-sm-2">
                                <input name="bucaofei" min="0" placeholder="布草费/元" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">布置期</label>
                            <div class="col-sm-2">
                                <input name="buzhiqi" min="0" placeholder="布置期/天" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <hr/>
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
                        <button type="button" id="add" class="btn btn-primary" >
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
                        房租详情
                    </h4>
                </div>
                <form class="form-horizontal" method="post" id="updateform">
                    <div class="modal-body">
                        <h4 class="modal-title">
                            签约信息
                        </h4>
                        <hr/>
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
                                <input name="houseName" min="0" placeholder="房间名称" type="text" class="form-control"
                                       required="" aria-required="true">
                            </div>
                            <label class="col-sm-2 control-label">支付总金额：</label>
                            <div class="col-sm-4">
                                <input name="totalPay" min="0" placeholder="支付总金额" max="100" type="number"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">签约年限：</label>
                            <div class="col-sm-4">
                                <input name="payTime" min="0" max="100" onchange="addCount(this.value);"
                                       placeholder="签约年限" type="number" class="form-control" required=""
                                       aria-required="true">
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
                                <input name="firstPayTime" id="test_3" type="text" value="" class="form-control"
                                       required="" aria-required="true">
                            </div>
                            <label class="col-sm-2 control-label">合同开始日期：</label>
                            <div class="col-sm-4">
                                <input name="payPeriodStart" minlength="2" id="test_4" maxlength="20" type="text"
                                       class="form-control" value="" required="" aria-required="true">
                            </div>
                        </div>
                        <h4 class="modal-title" id="">
                            房源信息
                        </h4>
                        <hr/>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">面积</label>
                            <div class="col-sm-2">
                                <input name="area" min="0" placeholder="房间面积" max="100" type="text" class="form-control"
                                       required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">楼层</label>
                            <div class="col-sm-2">
                                <input name="houseCount" min="0" placeholder="房间楼层" max="100" type="number"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">装修</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="zhuangxiu">
                                    <option value="0">毛坯</option>
                                    <option value="1">简装</option>
                                    <option value="2">精装</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">水电</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="shuidian">
                                    <option value="0">商水商电</option>
                                    <option value="1">民水民电</option>
                                    <option value="2">商水民电</option>
                                    <option value="3">民水商电</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">空调</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="kongtiao">
                                    <option value="0">有</option>
                                    <option value="1">无</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">供暖</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="gongnuan">
                                    <option value="0">有</option>
                                    <option value="1">无</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">物业</label>
                            <div class="col-sm-2">
                                <input name="wuye" min="0" placeholder="物业费用/平米" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">押金</label>
                            <div class="col-sm-2">
                                <input name="yajin" min="0" placeholder="押金/元" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">布草费</label>
                            <div class="col-sm-2">
                                <input name="bucaofei" min="0" placeholder="布草费/元" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">布置期</label>
                            <div class="col-sm-2">
                                <input name="buzhiqi" min="0" placeholder="布置期/天" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <hr/>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">备注</label>
                            <div class="col-sm-11">
                                <textarea name="description" placeholder="备注" minlength="2" value=""
                                          class="form-control" required="" aria-required="true"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <!--
                          <button type="button" id="update" class="btn btn-primary" data-dismiss="modal">
                             确认修改
                         </button>
                        -->
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <div class="modal fade" id="myModals" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">
                        修改房租
                    </h4>
                </div>
                <form class="form-horizontal" method="post" id="updateforms">
                    <input type="hidden" name="nid" value=""/>
                    <div class="modal-body form-group">
                        <h4 class="modal-title">
                            签约信息
                        </h4>
                        <hr/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" >业主姓名</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="mid"  required name="masterId">

                                </select>
                            </div>
                            <label class="col-sm-2 control-label" >房源归属</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="hid"  required name="hotelId">

                                </select>
                            </div>
                            <label class="col-sm-2 control-label" >房间名称</label>
                            <div class="col-sm-2">
                                <input name="houseName" min="0"  placeholder="房间名称" type="text" class="form-control"
                                       required="" aria-required="true">
                            </div>
                        </div>
                        <h4 class="modal-title">
                            房源信息
                        </h4>
                        <hr/>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">面积</label>
                            <div class="col-sm-2">
                                <input name="area" min="0" placeholder="房间面积" max="100" type="text" class="form-control"
                                       required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">楼层</label>
                            <div class="col-sm-2">
                                <input name="houseCount" min="0" placeholder="房间楼层" max="100" type="number"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">装修</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="zhuangxiu">
                                    <option value="0">毛坯</option>
                                    <option value="1">简装</option>
                                    <option value="2">精装</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">水电</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="shuidian">
                                    <option value="0">商水商电</option>
                                    <option value="1">民水民电</option>
                                    <option value="2">商水民电</option>
                                    <option value="3">民水商电</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">空调</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="kongtiao">
                                    <option value="0">有</option>
                                    <option value="1">无</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">供暖</label>
                            <div class="col-sm-2">
                                <select class="form-control" required name="gongnuan">
                                    <option value="0">有</option>
                                    <option value="1">无</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">物业</label>
                            <div class="col-sm-2">
                                <input name="wuye" min="0" placeholder="物业费用/平米" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">押金</label>
                            <div class="col-sm-2">
                                <input name="yajin" min="0" placeholder="押金/元" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">布草费</label>
                            <div class="col-sm-2">
                                <input name="bucaofei" min="0" placeholder="布草费/元" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                            <label class="col-sm-1 control-label">布置期</label>
                            <div class="col-sm-2">
                                <input name="buzhiqi" min="0" placeholder="布置期/天" max="100" type="text"
                                       class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <hr/>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">备注</label>
                            <div class="col-sm-11">
                                <textarea name="description" placeholder="备注" minlength="2" value=""
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
        <div class="modal-dialog  modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">房租付款</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" id="fu_kuan">
                        <input type="hidden" name="id" id="id"/>
                        <input type="hidden" name="firstPay" id="firstPay" />
                        <input type="hidden" name="count" id="ids" />
                        <input type="hidden" name="huankuanqishu" id="huankuanqishu"/>
                        <input type="hidden" name="thisPayMoney" id="thisPayMoney">
                        <div class="form-group">
                            <h1 style="color:red" align="center">￥<span id="summoney">0</span></h1>
                            <h3 align="center">本次付款总额</h3>
                        </div>
                        <div id="infohtml">

                        </div>
                        <div class="form-group">
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" id="huankuan" class="btn btn-primary">确认还款</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<div class="modal fade" id="fd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" >
                    房东详情
                </h4>
            </div>
            <form class="form-horizontal" id="fdinfo">
                <div class="modal-body">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房东联系方式：</label>
                            <div class="col-sm-8">
                                <input  name="phone" readonly minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房东姓名：</label>
                            <div class="col-sm-8">
                                <input  name="bankAccountName" readonly minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房东身份证号：</label>
                            <div class="col-sm-8">
                                <input  name="identity" readonly minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">银行名称：</label>
                            <div class="col-sm-8">
                                <input  name="bankName" readonly id="bankName" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">银行卡号：</label>
                            <div class="col-sm-8">
                                <input  name="bankAccountNo" readonly id="bankAccountNo" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/houseRentPay.js"></script>
<script src="<%=path%>/static/js/select2.min.js"></script>
</body>
<script>
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
        , type: 'date'
    });
</script>
<script>
    $(function () {
        $.post(
            "/houseRentPay/getContractMaster",
            function (data) {

                $("#master_Id").select2({
                    data: data
                })
                $("#mid").select2({
                    data: data
                })
                $("#select2-master_Id-container").remove();
                $("#masterId").select2({
                    data: data
                })
                $("#select2-masterId-container").remove();
                $("#select2-mid-container").remove();
            },
            "json"
        );
        $.post(
            "/houseRentPay/getHotel",
            function (data) {

                $("#hotel_Id").select2({
                    data: data
                })
                $("#hotel_Ids").select2({
                    data: data
                })
                $("#hotelId").select2({
                    data: data
                })
                $("#hotelId_").select2({
                    data: data
                })
                $("#hid").select2({
                    data: data
                })
                $("#select2-hotel_Id-container").remove();
                $("#select2-hotel_Ids-container").remove();
                $("#select2-hotelId-container").remove();
                $("#select2-hotelId_-container").remove();
                $("#select2-hid-container").remove();
            },
            "json"
        );

    });

</script>
<script>
    $(function () {
        getHotelInfo();
    });
    function getInfo(id) {
        getHotelInfo();
    }
    function getHotelInfo() {
        var hotelId = $("#hotelId_").val();
        $.post(
            "<%=path%>/houseRentPay/hotelInfo",
            {
                "hotelId": hotelId
            },
            function (data) {
                $("#houseTotal").html(data.houseTotal == null ? 0 : data.houseTotal);//房源总数
                $("#dfPayMoney").html("￥" + data.dfPayMoney == null ? 0 : data.dfPayMoney);//代付资金
                $("#monthPayMoney").html("￥" + data.monthPayMoney == null ? 0 : data.monthPayMoney);//代付资金
                $("#houseMonthPayMoney").html("￥" + data.houseMonthPayMoney == null ? 0 : data.houseMonthPayMoney);//每间每月
                $("#houseDayPayMoney").html("￥" + data.houseDayPayMoney == null ? 0 : data.houseDayPayMoney);//每间，每天
                $("#chaoqiPayMoney").html("￥" + data.chaoqiPayMoney == null ? 0 : data.chaoqiPayMoney);//超期未付
                $("#fiveDayPayMoney").html("￥" + data.fiveDayPayMoney == null ? 0 : data.fiveDayPayMoney);//近5日待付
                $("#thisMonthPayMoney").html("￥" + data.thisMonthPayMoney == null ? 0 : data.thisMonthPayMoney);//本月应付
                $("#thisMonthPayAll").html("￥" + data.thisMonthPayAll == null ? 0 : data.thisMonthPayAll);//本月已付租金总额
                $("#thisMonthNotPay").html("￥" + data.thisMonthNotPay == null ? 0 : data.thisMonthNotPay);//本月待付
                $("#nextMonthPay").html("￥" + data.nextMonthPay == null ? 0 : data.nextMonthPay);//次月应付
            },
            "json"
        );
    }
</script>
<script>
    function addCount(sum) {
        var info = '<label class="col-sm-1 control-label">第*年</label><div class="col-sm-2"><input  name="count" id="count*" min="0" placeholder="第*年的房租" max="100" type="number" class="form-control" required="required"></div>';
        var allhtml = "";
        for (var i = 0; i < sum; i++) {
            allhtml = allhtml + (info.replace("*", (i + 1)).replace("*", (i + 1)).replace("*", (i + 1)).replace("*", (i + 1)));
        }
        $("#house_count").html(allhtml);
    }
</script>
</html>
