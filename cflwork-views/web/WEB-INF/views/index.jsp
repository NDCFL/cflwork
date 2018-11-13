<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/10/19
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>瑞蓝酒店后台管理系统</title>
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <jsp:include page="common/css.jsp"></jsp:include>

</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element" style="text-align: center">
                        <span><img alt="image" id="updateHeadIcon" class="img-circle" src="${userVo.headicon}" style="width: 60px;height: 60px" /></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs">${userRole.roleVo.title}</span>
                                <span class="text-muted text-xs block">${userVo.nickname}<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <shiro:hasAnyRoles name="总管理员,管理员">
                                <li>
                                    <a class="J_menuItem" href="<%=path%>/company/updateCompanyPage">公司资料</a>
                                </li>
                            </shiro:hasAnyRoles>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/user/bossInfoPage">个人资料</a>
                            </li>
                            <li>
                                <a id="update_headIcon">修改头像</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="<%=path%>/user/exit">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">蓝
                    </div>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="glyphicon glyphicon-user"></i>
                        <span class="nav-label">基本信息</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <shiro:hasAnyRoles name="总管理员,管理员">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/updateCompanyPage">公司信息</a>
                            </li>
                        </shiro:hasAnyRoles>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/user/bossInfoPage">个人信息</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="<%=path%>/user/exit">安全退出</a>
                        </li>
                    </ul>
                </li>
                    <li>
                        <a href="javascript:void(0);">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">房态订单</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/house/housePage">房态查看</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customerOrder/customerOrderPage">订单列表</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/item/houseOthersItemPage">增值业务账目</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/house/housePageList">房态</a>
                            </li>
                        </ul>
                    </li>
                <shiro:hasAnyRoles name="总管理员,管理员">
                    <li>
                        <a href="javascript:void(0);">
                            <i class="glyphicon glyphicon-cutlery"></i>
                            <span>店铺管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/hotel/hotelListPage">分店管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/houseType/houseTypePage">房型管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/house/housePage">房间管理</a>
                            </li>
                        </ul>
                    </li>
                </shiro:hasAnyRoles>
                <li>
                    <a href="javascript:void(0);">
                        <i class="glyphicon glyphicon-glass"></i>
                        <span class="nav-label">角色管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <shiro:hasAnyRoles name="总管理员,管理员">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/landlord/landlordListPage">店长管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/checker/checkerListPage">公司审核员管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/keyIn/keyInListPage">公司录入员管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/hotelManager/hotelManagerListPage">高管管理</a>
                            </li>
                        </shiro:hasAnyRoles>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/checker/hotelCheckerListPage">酒店审核员管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/keyIn/hotelKeyInListPage">酒店录入员管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="glyphicon glyphicon-credit-card"></i>
                        <span class="nav-label">财务管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cashAccounts/hotelCashAccountsPage">分店收支流水统计</a>
                        </li>
                        <shiro:hasAnyRoles name="总管理员,管理员">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/cashAccounts/cashAccountsPage">总部收支流水统计</a>
                            </li>
                        </shiro:hasAnyRoles>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/serviceSubject/serviceSubjectPage">增值业务科目</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/paymentType/paymentTypePage">收支账户管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cashSubject/cashSubjectPage">收支流水科目</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a class="J_menuItem" href="<%=path%>/cashAccounts/cashAccountsPage">
                        <i class="glyphicon glyphicon-star"></i>
                        <span class="nav-label"> 营业数据统计</span>
                        <span class="fa arrow"></span>
                    </a>
                </li>
                <li>
                    <a class="J_menuItem" href="<%=path%>/cashSubject/cashSubjectPage">
                        <i class="glyphicon glyphicon-star"></i>
                        <span class="nav-label"> 酒店总科目</span>
                        <span class="fa arrow"></span>
                    </a>
                </li>
                <shiro:hasAnyRoles name="总管理员,管理员">
                    <li>
                        <a href="javascript:void(0);">
                            <i class="	glyphicon glyphicon-th-large"></i>
                            <span class="nav-label">OTA平台管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/web/webPage">OTA平台管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#" style="color:red">OTA订单统计</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#" style="color:red">OTA财务对账</a>
                            </li>
                        </ul>
                    </li>
                </shiro:hasAnyRoles>
                <li>
                    <a href="javascript:void(0);">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <span class="nav-label">合作商家管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cooperationCompany/hotelCooperationCompanyPage">分店商家管理</a>
                        </li>
                        <shiro:hasAnyRoles name="总管理员,管理员">
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cooperationCompany/cooperationCompanyPage">总部商家管理</a>
                        </li>
                        </shiro:hasAnyRoles>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cooperationSubject/cooperationSubjectPage">来往科目管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cooperationAccounts/hotelCooperationAccountsPage">分店来往财务统计</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=path%>/cooperationAccounts/cooperationAccountsPage">总部来往财务统计</a>
                        </li>
                    </ul>
                </li>
                <shiro:hasAnyRoles name="总管理员,管理员">
                    <li>
                        <a href="javascript:void(0);">
                            <i class="glyphicon glyphicon-flag"></i>
                            <span class="nav-label">房租管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/houseRentPay/houseRentPayPage">房租管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/houseFactPay/houseFactPayPage">房租明细</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);">
                            <i class="glyphicon glyphicon-book"></i>
                            <span class="nav-label">分成管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/contractMaster/contractMasterListPage">房东管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/rentPay/rentPayPage">分成管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/income/incomePage">酒店收入管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/outcome/outcomePage">酒店支出管理</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);">
                            <i class="glyphicon glyphicon-list-alt"></i>
                            <span class="nav-label">商会管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/businessMan/businessManPage">商会管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/hotelType/hotelTypePage">商会房型管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/priceItem/priceItemPage">商会报价管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/char/charPage">商会论坛管理</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">权限管理 </span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="/role/rolePage">角色管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="/userRole/userRolePage">用户角色管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="/permission/permissionPage">系统菜单</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-time"></i> <span class="nav-label">任务操作 </span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="/druid/index.html">系统监控</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="/generator/table">代码生成</a>
                            </li>
                            <%--<li>--%>
                                <%--<a class="J_menuItem" href="/online/onlinePage">在线用户</a>--%>
                            <%--</li>--%>
                            <li>
                                <a class="J_menuItem" href="/log/logPage">在线日志</a>
                            </li>
                        </ul>
                    </li>
                </shiro:hasAnyRoles>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li class="m-t-xs">
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="<%=path%>/static/img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46小时前</small>
                                        <strong>小四</strong> 这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？
                                        <br>
                                        <small class="text-muted">3天前 2014.11.8</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="<%=path%>/static/img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">25小时前</small>
                                        <strong>国民岳父</strong> 如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶
                                        <br>
                                        <small class="text-muted">昨天</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-qq fa-fw"></i> 3条新回复
                                        <span class="pull-right text-muted small">12分钟钱</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="notifications.html">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!--<li class="hidden-xs">
                        <a href="index_v1.html" class="J_menuItem" data-index="0"><i class="fa fa-cart-arrow-down"></i> 购买</a>
                    </li>-->
                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> 主题
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="<%=path%>/user/exit" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=path%>/landlord/landlordAllList" frameborder="0" data-id="index_v2.html" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2017-2018 <a href="http://www.zi-han.net/" target="_blank">瑞蓝酒店</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">

                <li class="active">
                    <a data-toggle="tab" href="#tab-1">
                        <i class="fa fa-gear"></i> 主题
                    </a>
                </li>
                <li class=""><a data-toggle="tab" href="#tab-2">
                    通知
                </a>
                </li>
                <li><a data-toggle="tab" href="#tab-3">
                    项目进度
                </a>
                </li>
            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                        <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                        </div>
                    </div>
                </div>
                <div id="tab-2" class="tab-pane">

                    <div class="sidebar-title">
                        <h3> <i class="fa fa-comments-o"></i> 最新通知</h3>
                        <small><i class="fa fa-tim"></i> 您当前有10条未读信息</small>
                    </div>

                    <div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a1.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">

                                    据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。
                                    <br>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a2.jpg">
                                </div>
                                <div class="media-body">
                                    HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！
                                    <br>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    写的好！与您分享
                                    <br>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a4.jpg">
                                </div>

                                <div class="media-body">
                                    国外极限小子的炼成！这还是亲生的吗！！
                                    <br>
                                    <small class="text-muted">昨天 8:37</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a8.jpg">
                                </div>
                                <div class="media-body">

                                    一只流浪狗被收留后，为了减轻主人的负担，坚持自己觅食，甚至......有些东西，可能她比我们更懂。
                                    <br>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a7.jpg">
                                </div>
                                <div class="media-body">
                                    这哥们的新视频又来了，创意杠杠滴，帅炸了！
                                    <br>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    最近在补追此剧，特别喜欢这段表白。
                                    <br>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="<%=path%>/static/img/a4.jpg">
                                </div>
                                <div class="media-body">
                                    我发起了一个投票 【你认为下午大盘会翻红吗？】
                                    <br>
                                    <small class="text-muted">星期一 8:37</small>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>
                <div id="tab-3" class="tab-pane">

                    <div class="sidebar-title">
                        <h3> <i class="fa fa-cube"></i> 最新任务</h3>
                        <small><i class="fa fa-tim"></i> 您当前有14个任务，10个已完成</small>
                    </div>

                    <ul class="sidebar-list">
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>市场调研</h4> 按要求接收教材；

                                <div class="small">已完成： 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>可行性报告研究报上级批准 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">已完成： 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>立项阶段</h4> 东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司

                                <div class="small">已完成： 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary pull-right">NEW</span>
                                <h4>设计阶段</h4>
                                <!--<div class="small pull-right m-t-xs">9小时以后</div>-->
                                项目进度报告(Project Progress Report)
                                <div class="small">已完成： 22%</div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>拆迁阶段</h4> 科研项目研究进展报告 项目编号: 项目名称: 项目负责人:

                                <div class="small">已完成： 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>建设阶段 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">已完成： 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>获证开盘</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">已完成： 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>

                    </ul>

                </div>
            </div>

        </div>
    </div>
    <!--右侧边栏结束-->
    <!--mini聊天窗口开始-->
    <div class="small-chat-box fadeInRight animated">

        <div class="heading" draggable="true">
            <small class="chat-date pull-right">
                2015.9.1
            </small> 与 Beau-zihan 聊天中
        </div>

        <div class="content">

            <div class="left">
                <div class="author-name">
                    Beau-zihan <small class="chat-date">
                    10:02
                </small>
                </div>
                <div class="chat-message active">
                    你好
                </div>

            </div>
            <div class="right">
                <div class="author-name">
                    游客
                    <small class="chat-date">
                        11:24
                    </small>
                </div>
                <div class="chat-message">
                    你好，请问H+有帮助文档吗？
                </div>
            </div>
            <div class="left">
                <div class="author-name">
                    Beau-zihan
                    <small class="chat-date">
                        08:45
                    </small>
                </div>
                <div class="chat-message active">
                    有，购买的H+源码包中有帮助文档，位于docs文件夹下
                </div>
            </div>
            <div class="right">
                <div class="author-name">
                    游客
                    <small class="chat-date">
                        11:24
                    </small>
                </div>
                <div class="chat-message">
                    那除了帮助文档还提供什么样的服务？
                </div>
            </div>
            <div class="left">
                <div class="author-name">
                    Beau-zihan
                    <small class="chat-date">
                        08:45
                    </small>
                </div>
                <div class="chat-message active">
                    1.所有源码(未压缩、带注释版本)；
                    <br> 2.说明文档；
                    <br> 3.终身免费升级服务；
                    <br> 4.必要的技术支持；
                    <br> 5.付费二次开发服务；
                    <br> 6.授权许可；
                    <br> ……
                    <br>
                </div>
            </div>


        </div>
        <div class="form-chat">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control"> <span class="input-group-btn"> <button
                    class="btn btn-primary" type="button">发送
                </button> </span>
            </div>
        </div>

    </div>
    <div id="small-chat">
        <span class="badge badge-warning pull-right">5</span>
        <a class="open-small-chat">
            <i class="fa fa-comments"></i>

        </a>
    </div>
</div>
<jsp:include page="common/js.jsp"></jsp:include>
<script>
    refushFaceImg();
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#updateHeadIcon'
            , url: '/user/updateHeadIcon'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#updateHeadIcon').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }else{
                    layer.msg("修改成功");
                    refushFaceImg();
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        var $ = layui.jquery
            , upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#update_headIcon'
            , url: '/user/updateHeadIcon'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#update_headIcon').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }else{
                    layer.msg("修改成功");
                    refushFaceImg();
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
    function refushFaceImg() {
        $.post(
            "/user/findUser/${userVo.id}",
            function (data) {
                $("#updateHeadIcon").attr("src",rootPath+data.headicon);
            },"json"
        );
    }
    <%--console.log(JSON.stringify(${permissionList})+'===============');--%>
</script>
</body>
</html>