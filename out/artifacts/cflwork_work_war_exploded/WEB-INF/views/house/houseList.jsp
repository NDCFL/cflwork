<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 3017/6/19
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
    <title>房型列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
    <style>
        label{
            margin-top: 5px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>房型列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label">分店名称</label>
                    <div class="col-sm-2"  >
                        <select class="form-control"  id="hotelId_" onchange="getCardTitle(this.value);" required name="hotelId">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label">房型名称</label>
                    <div class="col-sm-2">
                        <select class="form-control"  id="houseType_"  required name="houseType">
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label" >房型状态</label>
                    <div class="col-sm-2">
                        <select class="form-control"  id="isActive"  required name="isActive">
                            <option value="">全部</option>
                            <option value="0">启用</option>
                            <option value="1">停用</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label" >房型类别</label>
                    <div class="col-sm-2">
                        <select class="form-control"  id="house__Type" required name="type">
                            <option value="">全部</option>
                            <option value="0">真实房间</option>
                            <option value="1">虚拟房间</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" >房号</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="title" placeholder="请输入房间名称" name="title"/>
                    </div>
                    <div class="col-sm-3" >
                        <button class="btn btn-primary col-sm-12" id="search_btn">查询</button>
                    </div>
                </div>
            </div>
            <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 30px;">
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
                                <option value="">全部</option>
                                <option value="0">启用</option>
                                <option value="1">停用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">所属模式：</label>
                        <div class="col-sm-8">
                            <select class="form-control"  id="house_typess" required name="houseTypes">
                                <option value="">全部</option>
                                <option value="0">分成模式</option>
                                <option value="1">房租模式</option>
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
                    新增房型
                </h4>
            </div>
            <form method="post" id="form" role="form" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3 control-label">所属酒店：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="hotelId" onchange="getCardTitle(this.value);"  name="hotelId" required>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">酒店房号：</label>
                    <div class="col-sm-6" style="width: 300px">
                        <input type="text" id="cardTitle" name="cardTitle" placeholder="请输入房号多个房号用','号分割" required class="form-control"> <span class="help-block m-b-none" id="card_title"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间类型：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="type" name="type" required>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间类别：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="houseType" name="houseType" required>
                            <option value="0">真实房间</option>
                            <option value="1">虚拟房间</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">所属模式：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="houseTypes" name="houseTypes" required>
                            <option value="0">分成模式</option>
                            <option value="1">房租模式</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间描述：</label>
                    <div class="col-sm-6">
                        <textarea class="form-control" name="description" ></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <button class="btn btn-primary"  type="button" id="add" >新增</button>
                        <button class="btn btn-white" type="button" data-dismiss="modal">取消</button>
                    </div>
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
                    房型的修改
                </h4>
            </div>
            <form method="post" id="form1" role="form" class="form-horizontal">
                <input type="hidden"  id="id" name="id" value="">
                <input type="hidden"  id="ca" name="ca" value="">
                <div class="form-group">
                    <label class="col-sm-3 control-label">所属酒店：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="hotel_Id"  onchange="getCardTitle(this.value);"
                                name="hotelId" required>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                    <div class="col-sm-6">
                        <input type="text" name="cardTitle" id="cardTitle_" required class="form-control"> <span
                            class="help-block m-b-none" id="card"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间类型：</label>
                    <div class="col-sm-6">
                        <select class="form-control" name="type" id="house_Type"
                                required>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间类别：</label>
                    <div class="col-sm-6">
                        <select class="form-control" name="houseType" required>
                            <option value="0">真实房间</option>
                            <option value="1">虚拟房间</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">所属模式：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="house_types" name="houseTypes" required>
                            <option value="0">分成模式</option>
                            <option value="1">房租模式</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间状态：</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="houseStatus" name="houseStatus" required>
                            <option value="0" id="status0">未入住</option>
                            <option value="1" id="status1">已入住</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">房间描述</label>
                    <div class="col-sm-6">
                        <textarea class="form-control" id="description" name="description" required></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <button class="btn btn-primary" type="button"  id="update">修改</button>
                        <button class="btn btn-white" type="button" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/house.js"></script>
</body>
<%--<script>--%>
    <%--$(function () {--%>
        <%--alert("asdflsfa");--%>
        <%--layer.msg('已发布', {icon:1,time:200});--%>
        <%--layer.msg('已发布', {icon:3,time:200});--%>
        <%--layer.msg('已发布', {icon:3,time:200});--%>
        <%--layer.msg('已发布', {icon:4,time:200});--%>
        <%--layer.msg('已发布', {icon:5,time:200});--%>
        <%--layer.msg('已发布', {icon:6,time:200});--%>
        <%--layer.msg('已发布', {icon:7,time:200});--%>
        <%----%>
    <%--});--%>
<%--</script>--%>
<script>
    $.post(
        "/house/getHotelList",
        function(data){
            $("#hotelId").select2({
                data: data
            });
            $("#hotel_Id").select2({
                data: data
            })
            $("#hotelId_").select2({
                data: data
            })
            $("#select2-hotelId-container").remove();
            $("#select2-hotel_Id-container").remove();
            $("#select2-hotelId_-container").remove();
            var id = data[0].id;
            $.post(
                "/house/getTypeList/"+id,
                function(data){
                    $("#type").select2({
                        data: data
                    })
                    $("#house_Type").select2({
                        data: data
                    })
                    $("#houseType_").select2({
                        data: data
                    })
                    $("#select2-type-container").remove();
                    $("#select2-house_Type-container").remove();
                    $("#select2-houseType_-container").remove();
                },
                "json"
            );
            var text = data[0].text;
            $.post(
                "/house/getHouseCardTitle/"+data[0].id,
                function(data) {
                    if (data.cardTitle == null || data.cardTitle == "") {
                        $("#card_title").html(text + "酒店还没有添加房号");
                        $("#card_title").css("color", "red");
                        $("#card").html(text + "酒店还没有添加房号");
                        $("#card").css("color", "red");
                    } else {
                        $("#card_title").html(text + "酒店现已有如下房号，请不要重复房号:" + data.cardTitle);
                        $("#card_title").css("color", "red");
                        $("#card").html(text + "酒店现已有如下房号，请不要重复房号:" + data.cardTitle);
                        $("#card").css("color", "red");
                    }
                },
                "json"
            );
        },
        "json"
    );
    function getCardTitle(val) {
        $.post(
            "/house/getHouseCardTitle/"+val,
            function(data){
                if(data.cardTitle==null || data.cardTitle==""){
                    $("#card_title").html($("#hotelId").find("option:selected").text()+"酒店还没有添加房号");
                    $("#card_title").css("color","red");
                    $("#card").html($("#hotelId").find("option:selected").text()+"酒店还没有添加房号");
                    $("#card").css("color","red");
                }else{
                    $("#card_title").html($("#hotelId").find("option:selected").text()+"酒店现已有如下房号，请不要重复房号:"+data.cardTitle);
                    $("#card_title").css("color","red");
                    $("#card").html($("#hotelId").find("option:selected").text()+"酒店现已有如下房号，请不要重复房号:"+data.cardTitle);
                    $("#card").css("color","red");
                }

            },
            "json"
        );
        $.post(
            "/house/getTypeList/"+val,
            function(data){
                $("#type").html("");
                $("#house_Type").html("");
                $("#houseType_").html('<option value="">全部</option>');
                $("#type").select2({
                    data: data
                })
                $("#house_Type").select2({
                    data: data
                })
                $("#houseType_").select2({
                    data: data
                })
                $("#select2-type-container").remove();
                $("#select2-house_Type-container").remove();
                $("#select2-houseType_-container").remove();

            },
            "json"
        );
    }
</script>
</html>
