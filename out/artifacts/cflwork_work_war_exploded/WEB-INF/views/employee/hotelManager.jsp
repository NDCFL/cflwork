<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/11/26
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>酒店店长列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <c:forEach items="${hotelList}" var="u">
            <div class="col-sm-4">
                <div class="contact-box">
                    <a href="<%=path%>/hotel/listAll/${u.id}">
                        <div class="col-sm-4">
                            <div class="text-center">
                                <img alt="image" class="img-circle m-t-xs img-responsive" src="<%=path%>/${u.headicon}">
                                <div class="m-t-xs font-bold">店长</div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <h3><strong>${u.nickname}</strong></h3>
                            <p><i class="fa fa-map-marker"></i>${u.address}</p>
                            <address>
                                <strong>${u.phone}</strong><br>
                                E-mail:${u.email}<br>
                                QQ:<a href="http://wpa.qq.com/msgrd?v=3&uin=${u.qq}&site=qq&menu=yes">${u.qq}</a><br>
                                <abbr title="Phone">Tel:</abbr>${u.phone}
                            </address>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
</html>