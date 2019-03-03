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

    <title>瑞兰酒店房租-单据</title>
    <link rel="shortcut icon" href="favicon.ico">
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-content p-xl">
                <div class="row">
                    <h2 style="text-align: center">资金结算账单</h2>
                </div>
                <div class="row">
                    <div style="text-align: left" class="col-sm-6" id="name"></div>
                    <div style="text-align: right" class="col-sm-6" id="time"></div>
                </div>
                <div class="table-responsive m-t">
                    <table class="table table-bordered">
                        <tr>
                            <th>付款方</th>
                            <th>全称</th>
                            <td>青岛瑞蓝铂悦酒店管理有限公司</td>
                            <th>金额(人民币大写)</th>
                            <td id="money">￥0</td>
                        </tr>
                        <tr>
                            <th rowspan="5">收款方(全称)</th>
                            <th>账户名</th>
                            <td id="bankAccountName"></td>
                            <th rowspan="5">金额(人民币小写)</th>
                            <td rowspan="5" id="xmoney">￥0</td>
                        </tr>
                        <tr>
                            <th>账号</th>
                            <td id="bankAccountNo"></td>
                        </tr>
                        <tr>
                            <th>开户行</th>
                            <td id="bankName"></td>
                        </tr>
                        <tr>
                            <th>分成比例</th>
                            <td id="score"></td>
                        </tr>
                        <tr>
                            <th>分成方式</th>
                            <td id="type"></td>
                        </tr>
                        <tr>
                            <th>账户类型</th>
                            <td colspan="2">人名币</td>
                            <th>交易类型</th>
                            <td>付款</td>
                        </tr>
                        <tr>
                            <th colspan="2">备注</th>
                            <th colspan="3">电子签名</th>
                        </tr>
                        <tr>
                            <td colspan="2" style="height: 80px" id="remark"></td>
                            <td colspan="3" style="height: 80px"></td>
                        </tr>
                        </tr>
                    </table>
                </div>
                <!-- /table-responsive -->

                <table class="table invoice-total">
                    <tbody>
                    <tr>
                        <td><strong>总收入：</strong>
                        </td>
                        <td id="in">&yen;1026.00</td>
                    </tr>
                    <tr>
                        <td><strong>总支出：</strong>
                        </td>
                        <td id="out">&yen;235.98</td>
                    </tr>
                    <tr>
                        <td><strong>总收益：</strong>
                        </td>
                        <td id="moneys">&yen;235.98</td>
                    </tr>
                    </tbody>
                </table>
                <div class="text-right">
                    <button class="btn btn-primary" onclick="dy();"> 去打印</button>
                </div>

                <div class="well m-t"><strong>注意：</strong> 账单的打印可以直接右键浏览器打印。
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
</body>
<script>
    function DX(n) {
        if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(n))
            return "数据非法";
        var unit = "千百拾亿千百拾万千百拾元角分", str = "";
        n += "00";
        var p = n.indexOf('.');
        if (p >= 0)
            n = n.substring(0, p) + n.substr(p + 1, 2);
        unit = unit.substr(unit.length - n.length);
        for (var i = 0; i < n.length; i++)
            str += '零壹贰叁肆伍陆柒捌玖'.charAt(n.charAt(i)) + unit.charAt(i);
        return str.replace(/零(千|百|拾|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "元整");
    }
    $("#money").html("${rentPayItemVo.payMoney}"==0?"零元":DX("${rentPayItemVo.payMoney}"));
    $("#xmoney").html("&yen;"+${rentPayItemVo.payMoney});
    $("#in").html("&yen;"+${rentPayItemVo.inMoney});
    $("#out").html("&yen;"+${rentPayItemVo.outMoney});
    $("#moneys").html("&yen;"+${rentPayItemVo.payMoney});
    $("#score").html(""+parseFloat("${rentPayItemVo.payProportion}")*100+"%");
    $("#type").html(""+"${rentPayItemVo.payType}"=="0"?"有成本":"无成本");
    $("#bankName").html("${masterVo.bankName}");
    $("#bankAccountName").html("${masterVo.bankAccountName}");
    $("#bankAccountNo").html("${masterVo.bankAccountNo}");
    $("#time").html("交易时间:"+formattime("${rentPayItemVo.createTime}"));
    $("#name").html("交易名称:"+"${masterVo.bankAccountName}业主的房租收益");
    $("#remark").html("交易名称:"+"${rentPayItemVo.outTime}青岛瑞蓝铂悦酒店管理有限公司支付给${masterVo.bankAccountName}的房租");
    function formattime(value) {
        var date = new Date(value);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        var h = date.getHours();
        var mi = date.getMinutes();
        var ss = date.getSeconds();
        return y + '-' + (m < 10 ? "0" + m : m) + '-' + (d < 10 ? "0" + d : d) + ' ' + (h < 10 ? "0" + h : h) + ':' + (mi < 10 ? "0" + mi : mi) + ':' + (ss < 10 ? "0" + ss : ss);
    }
    function dy() {
        window.print();
    }
</script>
</html>