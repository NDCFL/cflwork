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
<html lang="zh_CN" xmlns:th="http://www.thymeleaf.org"
	xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>在线用户</title>
	<jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="row">
			
			<div class="col-sm-11">
				<div class="ibox">
					<div class="ibox-body">
						<div class="fixed-table-toolbar">
							<div class="columns pull-left">
								
							</div>
							<div class="columns pull-right">
								<button class="btn btn-success" onclick="reLoad()">查询</button>
							</div>

							<div class="columns pull-right col-md-2 nopadding">
								<input id="searchName" type="text" class="form-control"
									placeholder="">
							</div>
						</div>
						<table id="exampleTable" data-mobile-responsive="true">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%--网站信息的修改--%>
	<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
	<script src="<%=path%>/static/js/pageJs/online.js"></script>
</body>
</html>