<%--
  Created by IntelliJ IDEA.
  User: Wang Genshen
  Date: 2017-07-04
  Time: 22:25
  To change this template use File | Settinfz | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>一卡通充值支付</title>
</head>
<body>
</body>
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/js/main.js"></script>
<script>
    var res = "${status}";
    if(res!='1'){
        alert("充值机连接失败，请联系管理员");
        history.back();
    }
    $(function() {
        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent) {
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
    });

    function onBridgeReady() {
        WeixinJSBridge.invoke(
            'getBrandWCPayRequest', {
                "appId": "${appId}",
                "timeStamp": "${timeStamp}",
                "nonceStr": "${nonceStr}",
                "package": "${packages}",
                "signType": "MD5",
                "paySign": "${paySign}"
            }, function (res) {
                if (res.err_msg == "get_brand_wcpay_request:ok") {
                    $.post(
                        "<%=path%>/login/answerCom",
                        {
                            "money":"${userMoney}",
                            "cardid":"${cardid}"
                        },
                        function(data){
                            if(data==1){
                                alert("充值成功，请到充值机刷卡后到账！");
                            }else{
                                alert("支付成功，但充值机连接失败，请联系管理员!");
                            }
                            location.href="<%=path%>/items/itemsPage/${cardid}";
                        },
                        "json"
                    );
                } else if (res.err_msg == "get_brand_wcpay_request:cancel") {
                    alert("您取消了支付！");
                    location.href="<%=path%>/index";
                } else if (res.err_msg == "get_brand_wcpay_request:fail") {
                    alert("支付失败，请重试！");
                    location.href="<%=path%>/index";
                }
            });
    }
</script>
</html>
