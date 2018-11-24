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
    <title>列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>新增消息</h5><h5 style="margin-left: 20px;color: red" onclick="window.history.go(-1); " id="back">返回列表</h5>
        </div>
        <div class="ibox-content" style="height: auto">
            <div class="panel-body form-group" style="margin-bottom:0px;">
                <form id="formadd">
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label">消息标题</label>
                        <div class="col-sm-11">
                            <input id="name" name="name" type="text" maxlength="30" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label">所属业主</label>
                        <div class="col-sm-11">
                            <select class="form-control" id="master_Id" name="masterId" required>

                            </select>
                        </div>
                    </div>
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label">消息内容</label>
                        <div class="col-sm-11" style="height: 500px">
                            <textarea  name="content" id="editor"  style="height: 400px" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer" style="margin-bottom:0px;">
                        <button type="button" class="btn btn-default" onclick="window.history.go(-1); ">关闭
                        </button>
                        <button type="button" id="add" class="btn btn-primary" >
                            确认发送
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--数据的修改结束--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/contracmasterMsg.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('editor');
    $.post(
        "/houseRentPay/getContractMaster",
        function (data) {

            $("#master_Id").select2({
                data: data
            })
            $("#select2-master_Id-container").remove();
        },
        "json"
    );
</script>
</body>
</html>
