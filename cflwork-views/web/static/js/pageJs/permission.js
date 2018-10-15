//生成用户数据
$('#mytab').bootstrapTreeTable({
    id: 'id',
    code: 'id',
    parentCode: 'parentId',
    type: "GET", // 请求数据的ajax类型
    url: '/permission/list', // 请求数据的ajax的url
    expandColumn: '1',// 在哪一列上面显示展开按钮
    striped: true, // 是否各行渐变色
    bordered: true, // 是否显示边框
    expandAll: false, // 是否全部展开
    showRefresh: true,//刷新按钮
    showColumns: true,
    clickToSelect: true,//是否启用点击选中行
    columns: [
            {
                title: '编号',
                field: 'id',
                visible: false,
                align: 'center',
                valign: 'center',
                width: '5%'
            },
            {
                title: '名称',
                valign: 'center',
                field: 'name',
                width: '20%'
            },

            {
                title: '图标',
                field: 'icon',
                align: 'center',
                valign: 'center',
                width : '5%',
                formatter: function (item, index) {
                    return item.icon == null ? ''
                        : '<i class="' + item.icon
                        + ' fa-lg"></i>';
                }
            },
            {
                title: '类型',
                field: 'type',
                align: 'center',
                valign: 'center',
                width : '10%',
                formatter: function (item, index) {
                    if (item.type === 0) {
                        return '<span class="label label-primary">目录</span>';
                    }
                    if (item.type === 1) {
                        return '<span class="label label-success">菜单</span>';
                    }
                    if (item.type === 2) {
                        return '<span class="label label-warning">按钮</span>';
                    }
                }
            },
            {
                title: '地址',
                valign: 'center',
                width : '20%',
                field: 'url'
            },
            {
                title: '权限标识',
                valign: 'center',
                width : '20%',
                field: 'perms'
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                valign: 'center',
                formatter: function (item, index) {
                    var e = '<a class="btn btn-primary btn-sm '
                        + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                        + item.id
                        + '\')"><i class="fa fa-edit"></i></a> ';
                    var p = '<a class="btn btn-primary btn-sm '
                        + '" href="#" mce_href="#" title="添加下级" onclick="add(\''
                        + item.id
                        + '\')"><i class="fa fa-plus"></i></a> ';
                    var d = '<a class="btn btn-warning btn-sm '
                        + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                        + item.id
                        + '\')"><i class="fa fa-remove"></i></a> ';
                    return e + d + p;
                }
            }]
    });

//请求服务数据时所传参数
function queryParams(params) {
    var title = "";
    $(".search input").each(function () {
        title = $(this).val();
    });
    return {
        //每页多少条数据
        pageSize: this.pageSize,
        //请求第几页
        pageIndex: this.pageNumber,
        searchVal: title
    }
}
function del(cashSubjectid, status) {
    if (status == 0) {
        layer.msg("删除失败，已经启用的不允许删除!", {icon: 2, time: 1000});
        return;
    }
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/cashSubject/deleteCashSubject/' + cashSubjectid,
            dataType: 'json',
            success: function (data) {
                if (data.message == '删除成功!') {
                    layer.alert(data.message, {icon: 6});
                } else {
                    layer.alert(data.message, {icon: 6});
                }
                refush();
            },
            error: function (data) {
                console.log(data.msg);
            },
        });
    });
}
function edit(name) {
    $.post("/cashSubject/findCashSubject/" + name,
        function (data) {
            $("#updateform").autofill(data);
        },
        "json"
    );
}
function updatestatus(id, status) {
    $.post("/cashSubject/updateStatus/" + id + "/" + status,
        function (data) {
            if(status==0){
                if(data.message=="ok"){
                    layer.alert("已启用", {icon:6});
                }else{
                    layer.alert("操作失败", {icon:6});
                }
            }else{
                if(data.message=="ok"){
                    layer.alert("已停用", {icon:5});
                }else{
                    layer.alert("操作失败", {icon:5});
                }
            }
            refush();
        },
        "json"
    );
}
//查询按钮事件
$('#search_btn').click(function () {
    $('#mytab').bootstrapTable('refresh', {url: '/cashSubject/cashSubjectList'});
})
function refush() {
    $('#mytab').bootstrapTable('refresh', {url: '/cashSubject/cashSubjectList'});
}
$("#update").click(function () {
    $.post(
        "/cashSubject/cashSubjectUpdateSave",
        $("#updateform").serialize(),
        function (data) {
            if (data.message == "修改成功!") {
                layer.alert(data.message, {icon: 6});
                refush();
            } else {
                layer.alert(data.message, {icon: 6});
                refush();
            }
        }, "json"
    );
});
$("#add").click(function () {
    $.post(
        "/cashSubject/cashSubjectAddSave",
        $("#formadd").serialize(),
        function (data) {
            if (data.message == "新增成功!") {
                layer.alert(data.message, {icon: 6});
                refush();
            } else {
                layer.alert(data.message, {icon: 6});
                refush();
            }
        }, "json"
    );
});
function add(pId) {
    layer.open({
        type: 2,
        title: '增加菜单',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/permission/add/' + pId // iframe的url
    });
}

function deleteMany11() {
    var isactivity = "";
    var row = $.map($("#mytab").bootstrapTable('getSelections'), function (row) {
        if (row.isActive == 0) {
            isactivity += row.isActive;
        }
        return row.id;
    });
    if (row == "") {
        layer.msg('删除失败，请勾选数据!', {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (isactivity != "") {
        layer.msg('删除失败，已经启用的不允许删除!', {
            icon: 2,
            time: 2000
        });
        return;

    }
    $("#deleteId").val(row);
    layer.confirm('确认要执行批量删除网站信息数据吗？', function (index) {
        $.post(
            "/cashSubject/deleteManyCashSubject",
            {
                "manyId": $("#deleteId").val()
            },
            function (data) {
                if (data.message == "删除成功!") {
                    layer.alert(data.message, {icon: 6});
                    refush();
                } else {
                    layer.alert(data.message, {icon: 6});
                    refush();
                }
            }, "json"
        );
    });
}
function deleteMany(){
    var isactivity="";
    var row=$.map($("#mytab").bootstrapTable('getSelections'),function(row){
        if(row.isActive==0){
            isactivity+=row.isActive;
        }
        return row.id ;
    });
    if(row==""){
        layer.msg('修改失败，请勾选数据!', {
            icon : 2,
            time : 3000
        });
        return ;
    }
    $("#statusId").val(row);
    $("#updateStatus").modal('show');

}
$("#updateSta").click(function () {
    layer.confirm('确认要执行批量修改收支科目状态吗？',function(index){
        $.post(
            "/cashSubject/deleteManyCashSubject",
            {
                "manyId":$("#statusId").val(),
                "status":$("#status").val()
            },
            function(data){
                if(data.message=="修改成功!"){
                    layer.alert(data.message, {icon:6});
                    refush();
                }else{
                    layer.alert(data.message, {icon:6});
                    refush();
                }
            },"json"
        );
    });
});