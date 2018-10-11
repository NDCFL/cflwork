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
    <title>分店管理</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>分店管理</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="width:90px;line-height: 30px">创建时间</label>
                    <div class="col-sm-1" style="width: 360px;margin-left: -20px" >
                        <input type="text" class="form-control" style="width: 360px" name="createTime" id="test1"/>
                    </div>
                    <label class="col-sm-1 control-label" style="margin-left:60px;line-height: 30px;width:100px">分店名称</label>
                    <div class="col-sm-1" style="width: 120px" >
                        <input type="text" class="form-control" style="width: 160px;margin-left: -20px" id="hotelTitle" name="title"/>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="line-height: 30px;width:60px">店长</label>
                    <div class="col-sm-1" style="width: 120px" >
                        <select class="form-control"  id="landlordid_" style="width: 160px" required name="hotelManagerId">
                            <option value="">全部</option>

                        </select>
                    </div>
                    <label class="col-sm-1 control-label" style="width:100px;line-height: 30px;margin-left: 60px">分店电话</label>
                    <div class="col-sm-1" style="width: 120px" >
                        <input type="text" class="form-control" style="width: 160px;margin-left: -20px" id="hotelTel" name="tel"/>
                    </div>
                    <label class="col-sm-1 control-label" style="margin-left:60px;line-height: 30px;width:100px;margin-left: 40px">营业状态</label>
                    <div class="col-sm-1" style="width: 120px" >
                        <select style="width: 160px;margin-left: -20px" class="form-control" id="hotelStatus" name="isActive">
                            <option value="">全部</option>
                            <option value="0">启用</option>
                            <option value="1">停用</option>
                        </select>
                    </div>
                    <div class="col-sm-1" style="width: 120px;margin-left: 100px" >
                        <button class="btn btn-primary" id="search_btn" style="width: 100px">查询</button>
                    </div>
                </div>
            </div>
            <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                <!--<button id="btn_edit" type="button" class="btn btn-default" style="display: block; border-radius: 0">
                   <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>批量修改状态
               </button>-->
               <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                   <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量修改状态
               </button>
                <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#webAdd">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
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
                    新增酒店
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">酒店店长：</label>
                        <div class="col-sm-8">
                            <select class="form-control"  id="landlord_Id" required name="hotelManagerId">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">酒店名称：</label>
                        <div class="col-sm-8">
                            <input  name="title" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">酒店热线：</label>
                        <div class="col-sm-8">
                            <input  name="tel" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">详细地址：</label>
                        <div class="col-sm-8" data-toggle="distpicker" id="distpicker1">
                            <select class="form-control col-sm-2" name="provice"  style="width: 33%;margin-left: -1%" id="province1"></select>
                            <select class="form-control col-sm-2" name="city"   style="width: 31%;margin-left: 3%" id="city1"></select>
                            <select class="form-control col-sm-2" name="town"   style="width: 31%;margin-left: 3%" id="district1"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">酒店地址：</label>
                        <div class="col-sm-8">
                            <input  name="address" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
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
                        <label class="col-sm-3 control-label">经营状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control"  id="status" required name="status">
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
                    酒店的修改
                </h4>
            </div>
            <form class="form-horizontal" id="updateform" >
                <div class="modal-body">
                    <input type="hidden" name="id" id="id" value="">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">酒店店长：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="landlordId" required name="hotelManagerId">

                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">酒店名称：</label>
                            <div class="col-sm-8">
                                <input  name="title" id="title" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">酒店热线：</label>
                            <div class="col-sm-8">
                                <input  name="tel" id="tel" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">详细地址：</label>
                            <div class="col-sm-8" data-toggle="distpicker" id="distpicker_2">
                                <select class="form-control col-sm-2" name="provice" style="width: 33%;margin-left: -1%" id="province2"></select>
                                <select class="form-control col-sm-2" name="city"  style="width: 31%;margin-left: 3%" id="city2"></select>
                                <select class="form-control col-sm-2" name="town"  style="width: 31%;margin-left: 3%" id="district2"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">酒店地址：</label>
                            <div class="col-sm-8">
                                <input  name="address" minlength="2" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" id="update" class="btn btn-primary" data-dismiss="modal">
                                确认修改
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
<script src="<%=path%>/static/js/select2.min.js"></script>
<script src="<%=path%>/static/js/distpicker.data.js"></script>
<script src="<%=path%>/static/js/distpicker.js"></script>
<script src="<%=path%>/static/js/pageJs/hotel.js"></script>
</body>
<script>
    $('#distpicker1').distpicker({
        province: '山东省',
        city: '青岛市',
        district: '市南区',
        autoSelect: true,
        placeholder: false
    });
</script>
<script>
    lay('#version').html('-v'+ laydate.v);
    var checkDate = "";
    //执行一个laydate实例
    laydate.render({
        elem: '#test1'//指定元素，
        ,type: 'datetime'
        ,range: true
    });
    laydate.render({
        elem: '#test2' //指定元素
        ,type: 'datetime'
        ,min: checkDate
        ,done: function(value, date){
            var data1 = new Date($("#test1").val());
            var data2 = new Date(value);
            if(data1>data2){
                layer.alert("请选择正确的时间",{icon: 6});
                $("#search_btn").attr("disabled","disabled");
            }else{
                $("#search_btn").removeAttrs("disabled");
            }
        }
    });

</script>
<script>
    $(function() {
        $.post(
            "/hotel/getContract",
            function (data) {

                $("#contract_Id").select2({
                    data: data,
                    placeholder: '请选择签约编号',
                    allowClear: false
                })
                $("#select2-contract_Id-container").remove();
                $("#contractId").select2({
                    data: data,
                    placeholder: '请选择房东请选择签约编号',
                    allowClear: false
                })
                $("#select2-contract_Id-container").remove();
            },
            "json"
        );
        $.post(
            "/hotel/getLandlord",
            function (data) {

                $("#landlord_Id").select2({
                    data: data
                });
                $("#select2-landlord_Id-container").remove();
                $("#landlordId").select2({
                    data: data
                });
                $("#select2-landlordId-container").remove();
                $("#landlordid_").select2({
                    data: data
                });
                $("#select2-landlordid_-container").remove();
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

</script>
</html>
