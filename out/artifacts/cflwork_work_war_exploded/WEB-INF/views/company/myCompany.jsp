<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/3/28
  Time: 3:33
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
    <title>公司详情</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h3>公司详情 </h3>
                    <div class="ibox-tools">
                       <!--
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
                        -->
                    </div>
                </div>
                <div class="ibox-content">
                    <form method="post" id="form" role="form" class="form-horizontal" action="<%=path%>/company/updateCompany">
                        <input type="hidden" class="form-control" id="id" name="id">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司名称</label>

                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司代表</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="represent" id="represent"> <span class="help-block m-b-none">多个代表用','号分割</span>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司代表联系方式</label>

                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="phone" id="phone">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司固定电话</label>
                            <div class="col-sm-3">
                                <input type="text" name="tel" id="tel" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司地址</label>

                            <div class="col-sm-3">
                                <input type="text" name="address" id="address"  class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司描述</label>
                            <div class="col-sm-3">
                                <textarea class="form-control" id="description" name="description" id="description"></textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-3 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">修改</button>
                                <button class="btn btn-white" type="submit">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>

<script>
    $(function() {
        refush();
    });
</script>
<script>
    $('#form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: '公司名称验证失败',
                validators: {
                    notEmpty: {
                        message: '公司名称不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 20,
                        message: '公司名称长度必须在2到20位之间'
                    }
                    ,
                    threshold: 2,
                    remote: {
                        url: '<%=path%>/company/checkName/'+$("#id").val(),
                        message: '公司名称已被使用!',
                        delay: 2000,
                        type: 'POST'
                    }

                }
            },
            phone: {
                message: '手机账号验证失败',
                validators: {
                    notEmpty: {
                        message: '手机账号不能为空'
                    },
                    stringLength: {
                        min: 11,
                        max: 11,
                        message: '手机账号长度必须为11位'
                    },
                    regexp: {
                        regexp: /^1[3|5|8|7]{1}[0-9]{9}$/,
                        message: '请输入正确的手机号码'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator');
        $.post(
            $form.attr('action'),
            $form.serialize(),
            function(result) {
                if(result.message=="修改成功!"){
                    layer.alert(result.message, {icon: 6});
                }else{
                    layer.alert(result.message, {icon: 6});
                }
                refush();
            },
            "json"
        );
    });
    function refush(){
        $.post("<%=path%>/company/myCompany",
            function (data) {
                $("#form").autofill(data);
            },
            "json"
        );
    }
</script>
</body>

</html>