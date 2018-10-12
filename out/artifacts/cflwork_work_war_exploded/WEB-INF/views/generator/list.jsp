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
<meta charset="utf-8">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>代码自动生成</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content ">
    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="exampleToolbar" role="group">
                    <button type="button" class="btn  btn-primary"
                            onclick="batchCode()">
                        <i class="" aria-hidden="true"></i>批量生成
                    </button>
                    <button type="button" class="btn  btn-success" data-toggle="modal" data-target="#checkerUpdate" onclick="info();">
                        <i class="" aria-hidden="true"></i>生成策略
                    </button>
                </div>
                <table id="mytab" data-mobile-responsive="true">
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="checkerUpdate" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="update">
                    修改生成策略
                </h4>
            </div>
            <form class="form-horizontal m-t" id="signupForm">
                <div class="form-group">
                    <label class="col-sm-3 control-label">作者：</label>
                    <div class="col-sm-8">
                        <input id="author" name="author" type="text" value="${property.author}" class="form-control"
                               required=""
                               aria-required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">邮箱：</label>
                    <div class="col-sm-8">
                        <input id="email" name="email" class="form-control" type="text" value="${property.email}"
                               readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">包名：</label>
                    <div class="col-sm-8">
                        <input id="package" name="packagename" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">自动去掉表前缀：</label>
                    <div class="col-sm-8">
                        <input id="autoRemovePre" name="autoRemovePre" style="width: 30px;height: 30px"
                               class="form-control" type="checkbox"
                               value="true"
                               checked="${property.autoRemovePre}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button type="button" class="btn btn-primary" onclick="updates();" data-dismiss="modal">提交</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--商家信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/static/js/pageJs/list.js"></script>
<script type="text/javascript">
    function info(){
        $.post("/generator/edit/",
            function (data) {
                console.log(JSON.stringify(data)+'==============');
                $("#signupForm").autofill(data);
            },
            "json"
        );
    }
    function updates() {
        $.ajax({
            cache : true,
            type : "POST",
            url : "/generator/update",
            data : $('#signupForm').serialize(),// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("网络连接超时");
            },
            success : function(data) {
                if (data.code == 0) {
                    parent.layer.msg(data.msg);
                } else {
                    parent.layer.msg(data.msg);
                }

            }
        });

    }
</script>
</body>
</html>