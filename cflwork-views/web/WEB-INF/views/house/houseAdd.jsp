<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/10/28
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增房间</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>新增房间 <small>瑞蓝酒店版权所有</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form method="post" id="form" role="form" class="form-horizontal">
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属酒店：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="hotelId" onchange="getCardTitle(this.value);"  name="hotelId" required>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房号</label>
                            <div class="col-sm-10">
                                <input type="text" id="cardTitle" name="cardTitle" placeholder="请输入房号多个房号用','号分割" required class="form-control"> <span class="help-block m-b-none" id="card_title"></span>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房间面积</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" placeholder="请输入房间的面积" required name="area" id="area">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房间单价</label>
                            <div class="col-sm-10">
                                <input type="number" name="unitPrice" placeholder="请输入房间的单价" required id="unitPrice" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房间促销价</label>

                            <div class="col-sm-10">
                                <input type="number" name="salePrice" placeholder="请输入房间的促销价" required id="salePrice"  class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房间类型：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="type" name="type" onchange="getInfo(this.value);"  required>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房间描述</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="description" name="description" required></textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">酒店店长：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="shopManagerId" onchange="getShopManager(this.value);" name="shopManagerId" required>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">酒店代理店长：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="shopAgentId" name="shopAgentId" required>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">房间状态：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="houseStatus" name="houseStatus" required>
                                    <option value="0">未入住</option>
                                    <option value="1">已入住</option>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary"  type="submit">新增</button>
                                <button class="btn btn-white" type="button">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/static/js/pageJs/addHouse.js"></script>
<%--<script>--%>
    <%--$(function () {--%>
        <%--$.post(--%>
            <%--"/house/getTypeList",--%>
            <%--function(data){--%>
                <%--$("#type").select2({--%>
                    <%--data: data,--%>
                    <%--placeholder:'请选择房间类型',--%>
                    <%--allowClear:false--%>
                <%--})--%>
                <%--$.post(--%>
                    <%--"/houseType/findHouseType/"+data[0].id,--%>
                    <%--function(data){--%>
                        <%--$("#description").text(data.description);--%>
                    <%--},--%>
                    <%--"json"--%>
                <%--);--%>
            <%--},--%>
            <%--"json"--%>
        <%--);--%>
        <%--$.post(--%>
            <%--"/house/getHotelList",--%>
            <%--function(data){--%>
                <%--$("#hotelId").select2({--%>
                    <%--data: data,--%>
                    <%--placeholder:'请选择所属酒店',--%>
                    <%--allowClear:false--%>
                <%--})--%>
                <%--var text = data[0].text;--%>
                <%--$.post(--%>
                    <%--"/house/getHouseCardTitle/"+data[0].id,--%>
                    <%--function(data) {--%>
                        <%--if (data.cardTitle == null || data.cardTitle == "") {--%>
                            <%--$("#card_title").html(text + "酒店还没有添加房号");--%>
                            <%--$("#card_title").css("color", "red");--%>
                        <%--} else {--%>
                            <%--$("#card_title").html(text + "酒店现已有如下房号，请不要重复房号:" + data.cardTitle);--%>
                            <%--$("#card_title").css("color", "red");--%>
                        <%--}--%>
                    <%--},--%>
                    <%--"json"--%>
                <%--);--%>
            <%--},--%>
            <%--"json"--%>
        <%--);--%>
        <%--$.post(--%>
            <%--"/house/getUserList",--%>
            <%--function(data){--%>
                <%--$("#shopManagerId").select2({--%>
                    <%--data: data,--%>
                    <%--placeholder:'请选择酒店店长',--%>
                    <%--allowClear:false--%>
                <%--})--%>
                <%--$("#shopAgentId").select2({--%>
                    <%--data: data,--%>
                    <%--placeholder:'请选择酒店代理店长',--%>
                    <%--allowClear:false--%>
                <%--})--%>
            <%--},--%>
            <%--"json"--%>
        <%--);--%>

    <%--});--%>
<%--</script>--%>
<%--<script>--%>
    <%--function getInfo(id){--%>
        <%--$.post(--%>
            <%--"/houseType/findHouseType/"+id,--%>
            <%--function(data){--%>
                <%--$("#description").text(data.description);--%>
            <%--},--%>
            <%--"json"--%>
        <%--);--%>
    <%--}--%>
    <%--function getShopManager(id){--%>
        <%--var shopAgent = $("#shopAgentId").select2();--%>
        <%--//选中某一行--%>
        <%--shopAgent.val(id).trigger("change");--%>
        <%--//刷新列表--%>
        <%--shopAgent.change();--%>
    <%--}--%>
    <%--function getCardTitle(val) {--%>
        <%--$.post(--%>
            <%--"/house/getHouseCardTitle/"+val,--%>
            <%--function(data){--%>
                <%--if(data.cardTitle==null || data.cardTitle==""){--%>
                    <%--$("#card_title").html($("#hotelId").find("option:selected").text()+"酒店还没有添加房号");--%>
                    <%--$("#card_title").css("color","red");--%>
                <%--}else{--%>
                    <%--$("#card_title").html($("#hotelId").find("option:selected").text()+"酒店现已有如下房号，请不要重复房号:"+data.cardTitle);--%>
                    <%--$("#card_title").css("color","red");--%>
                <%--}--%>

            <%--},--%>
            <%--"json"--%>
        <%--);--%>
    <%--}--%>
    <%--$('#form').bootstrapValidator({--%>
        <%--message: 'This value is not valid',--%>
        <%--feedbackIcons: {--%>
            <%--valid: 'glyphicon glyphicon-ok',--%>
            <%--invalid: 'glyphicon glyphicon-remove',--%>
            <%--validating: 'glyphicon glyphicon-refresh'--%>
        <%--},--%>
        <%--fields: {--%>
            <%--cardTitle: {--%>
                <%--message: '房号验证失败',--%>
                <%--validators: {--%>
                    <%--notEmpty: {--%>
                        <%--message: '房号不能为空'--%>
                    <%--}--%>
                <%--}--%>
            <%--},--%>
            <%--area: {--%>
                <%--message: '房间面积验证失败',--%>
                <%--validators: {--%>
                    <%--notEmpty: {--%>
                        <%--message: '房间面积不能为空'--%>
                    <%--}--%>
                <%--}--%>
            <%--},--%>
            <%--unitPrice: {--%>
                <%--message: '房间单价验证失败',--%>
                <%--validators: {--%>
                    <%--notEmpty: {--%>
                        <%--message: '房间单价不能为空'--%>
                    <%--}--%>
                <%--}--%>
            <%--},--%>
            <%--salePrice: {--%>
                <%--message: '房间促销价验证失败',--%>
                <%--validators: {--%>
                    <%--notEmpty: {--%>
                        <%--message: '房间促销价不能为空'--%>
                    <%--}--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>
    <%--}).on('success.form.bv', function(e) {//点击提交之后--%>
        <%--e.preventDefault();--%>
        <%--var oldcard = new Array();--%>
        <%--var newcard = new Array();--%>
        <%--var title = $("#card_title").text();--%>
        <%--var title1=title.substring((title.indexOf(":")+1),title.length);--%>
        <%--oldcard = title1.split(",");--%>
        <%--newcard = $("#cardTitle").val().split(",");--%>
        <%--for(var i=0;i<oldcard.length;i++){--%>
            <%--for(var j=0;j<newcard.length;j++){--%>
                <%--if(oldcard[i]==newcard[j]){--%>
                    <%--layer.msg($("#hotelId").find("option:selected").text()+"的"+newcard[j]+"房号已存在", {icon:2,time:1000});--%>
                    <%--return;--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>
        <%--$.post(--%>
            <%--"/house/houseAddSave",--%>
            <%--$("#form").serialize(),--%>
            <%--function(data){--%>
                <%--if(data.message=="新增成功!"){--%>
                    <%--layer.alert(data.message, {icon:6});--%>
                    <%--location.href="<%=path%>/house/housePage";--%>
                <%--}else {--%>
                    <%--layer.alert(data.message, {icon:6});--%>
                <%--}--%>

            <%--},--%>
            <%--"json"--%>
        <%--);--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>