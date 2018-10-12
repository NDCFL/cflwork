<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2018/2/5
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/H-ui.reset.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/H-ui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/base.css" >
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/test.css">
</head>
<body>
<div class="q-main q-remote">
    <div class="q-main-wrap clear">
        <div class="q-remote-roomstatus f-l" style="height: 2000px">
            <!-- 筛选与排序，日期控件开始 -->
            <div class="head-cell">
                <div class="select-panel-wrap">
                    <div class="date-select fn-clear h30" id="spacing-date">
                        <span class="icon-arrow fn-vam i-icon f14 prev" title="向前一个月"></span>
                        <span class="date-picker fn-vam date" id="date">
							    	<span class="space-date" id="star_date" data-date="">01-04</span> 至 <span class="space-date" data-date="" id="end_date">02-02</span>
                            <input type="text" name="" id="star_date_input" data-val="" value="" style="opacity:0;    position: relative; left: 0px; top: -20px; width: 100px;">
                            </span>
                        <input type="hidden" id="my_hidden_input">
                        <span class="icon-arrow fn-vam i-icon f14 next" title="向后一个月"></span>
                    </div>
                    <div class="filter-sort" id="filterSort">
                        <div class="filter-sort-head">筛选与排序 <i class="arrow-icon fn-vam f14 ml5 i-icon"></i></div>
                        <div class="filter-sort-main fn-hide">
                            <!--ms-include-->
                            <div class="search-wrap ui-textbox-warp">
                                <input type="text" class="input-room-search" id="j_input_room_search" placeholder="请输入房间号查询" maxlength="15">
                                <i class="i-icon icon-room-search"></i>
                                <!--ms-if-->
                            </div>
                            <!--ms-if-->
                            <!--ms-include-end-->
                            <!--ms-include-->
                            <div class="ranklist-wrap" id="rankListWrapper">
                                <div class="rs-rank-terms">
                                    <h4>排序方式</h4>
                                    <ul class="rs-ranklist">
                                        <!--repeat677244193913-->
                                        <li>
                                            <label class="label-radio" onselectstart="return false;">
                                                <input type="radio" name="rank_radio" id="rank_roomType" value="roomType">
                                                <i class="i-radio mr5"></i>房型名排序
                                            </label>
                                        </li>
                                        <!--repeat677244193913-->
                                        <li>
                                            <label class="label-radio" onselectstart="return false;">
                                                <input type="radio" name="rank_radio" id="rank_doorNo" value="doorNo">
                                                <i class="i-radio mr5"></i>房间号排序
                                            </label>
                                        </li>
                                        <!--repeat677244193913-->
                                        <li>
                                            <label class="label-radio" onselectstart="return false;">
                                                <input type="radio" name="rank_radio" id="rank_dirtyRoom" value="dirtyRoom">
                                                <i class="i-radio mr5"></i>脏房优先
                                            </label>
                                        </li>
                                        <!--repeat677244193913-->
                                        <!--repeat677244193913:end-->
                                    </ul>
                                </div>
                                <div class="rs-rank-terms">
                                    <h4>房型筛选</h4>
                                    <ul class="rs-ranklist min-scroller">
                                        <li>
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>全部房型
                                            </label>
                                        </li>
                                        <!--repeat073825417478-->
                                        <li title="豪华大房">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>豪华大房
                                            </label>
                                        </li>
                                        <!--repeat073825417478-->
                                        <li title="豪华大床房">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>豪华大床房
                                            </label>
                                        </li>
                                        <!--repeat073825417478-->
                                        <li title="普通房">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>普通房
                                            </label>
                                        </li>
                                        <!--repeat073825417478-->
                                        <li title="普通房1">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>普通房1
                                            </label>
                                        </li>
                                        <!--repeat073825417478-->
                                        <li title="普通房2">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>普通房2
                                            </label>
                                        </li>
                                        <!--repeat073825417478-->
                                        <li title="普通房3">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>普通房3
                                            </label>
                                        </li>
                                        <!--repeat073825417478:end-->
                                        <!--repeat073825417478-->
                                        <li title="普通房3">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>普通房3
                                            </label>
                                        </li>
                                        <!--repeat073825417478:end-->
                                        <!--repeat073825417478-->
                                        <li title="普通房3">
                                            <label class="label-checkbox" onselectstart="return false;">
                                                <input type="checkbox">
                                                <i class="i-checkbox mr5"></i>普通房3
                                            </label>
                                        </li>
                                        <!--repeat073825417478:end-->
                                    </ul>
                                </div>
                                <div class="rs-panel-btns">
                                    <button type="button" class="btn btn-default btn-xs ml5">取消</button>
                                    <button type="button" class="btn btn-success btn-xs">确认</button>
                                </div>
                            </div>
                            <!--ms-include-end-->
                        </div>
                    </div>
                </div>
            </div>
            <!-- 筛选与排序，日期控件结束 -->
            <!-- 房间列表开始 -->
            <div class="room-type-wrap y-style" style="">
                <div id="yRoomList" class="room-list" style="top: 0px;">
                    <table class="table text-center mb0" data-index="5">
                        <tbody>
                        <tr class="room-type-item">
                            <td rowspan="1" class="item-type">
                                <p class="type-name-item" title="普通房3">普通房3</p>
                            </td>
                            <td class="item-room j-item-room item-room-first room17222294827514" data-index="0" data-doorno="204" data-roomno="room17222294827514" data-hasroomcontrol="false" data-islinklock="" data-roomtypename="普通房3">
                                <p class="door-no" title="204">204</p>
                                <div class="room-state">
                                    <i class="action-icon i-icon color-green fn-vam room-state50 fn-hide"></i>
                                    <i class="action-icon i-icon color-blue fn-vam j-option-icon fn-hide"></i>
                                </div>
                                <div class="dirty-clean j-dirty-clean" data-outindex="5" data-index="0">
                                    <span class="dirty-clean50">置为脏房</span>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- 房间列表结束 -->
        </div>
        <div class="q-room-detail f-l">
            <div class="room-order-wrap j-room-order-wrap windows-originsize-scrollbar theme-default" style="">
                <div class="date-list-wrap x-style" style="">
                    <ul class="date-list" style="width: 3000px; left: 0px;">

                    </ul>
                    <ul class="roomcount-list" style="width: 3000px; left: 0px;">

                    </ul>
                </div>
                <div class="empty-room ui-selectable" id="emptyCell">
                    <div id="emptyRoomBox" class="empty-room-box">
                        <div id="fadeLayar">
                            <div class="fade-layar fade-vertical" style="height: 366px; left: 700px; display: none;"></div>
                            <div class="fade-layar fade-horizontal" style="width: 3000px; top: 305px; display: none;"></div>
                        </div>
                        <ul style="width: 3000px">
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222293080214" data-roomname="" data-roomtypeno="roomType17222239120714" data-roomtypename="普通房" data-doorno="201" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房</p>
                                    <p class="fn-text-overflow">201</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul style="width: 3000px">
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222223146214" data-roomname="" data-roomtypeno="roomType17222263493514" data-roomtypename="普通房1" data-doorno="202" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房1</p>
                                    <p class="fn-text-overflow">202</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul style="width: 3000px">
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222252301614" data-roomname="" data-roomtypeno="roomType17222255817614" data-roomtypename="普通房2" data-doorno="203" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房2</p>
                                    <p class="fn-text-overflow">203</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul style="width: 3000px">
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222294827514" data-roomname="" data-roomtypeno="roomType17222281299214" data-roomtypename="普通房3" data-doorno="204" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房3</p>
                                    <p class="fn-text-overflow">204</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222294827514" data-roomname="" data-roomtypeno="roomType17222281299214" data-roomtypename="普通房3" data-doorno="204" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房3</p>
                                    <p class="fn-text-overflow">204</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                            <li class="j-empty-cell" data-date="2018-01-15" data-roomno="room17222294827514" data-roomname="" data-roomtypeno="roomType17222281299214" data-roomtypename="普通房3" data-doorno="204" data-weekendprice="" data-regularprice="">
                                <div class="room-info" style="display:none">
                                    <p class="fn-text-overflow">普通房3</p>
                                    <p class="fn-text-overflow">204</p>
                                    <p class="fn-text-overflow">¥<span class="js-dayPrice"></span></p>
                                </div>
                                <div class="select-cell">
                                    <i class="i-icon"></i>
                                    <ul class="action-btn">
                                        <li class="bd-top j-add-order">新增</li>
                                        <li class="j-check-in">入住</li>
                                        <li class="j-close-room">关房</li>
                                        <li class="bd-bottom j-cancel">取消</li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="room-order" id="roomOrder">
                        <div class="cell-border" id="cellBorder">
                            <div class="order-stay j-stay-daily">
                                <p></p>
                                <p></p>
                            </div>
                            <div class="order-stay stay-hourly stay-out j-stay-hourly">
                                <p class="hour-mark-len">
                                    <span class="order-count"></span>
                                    <i class="hour-mark i-icon"></i>
                                </p>
                            </div>
                        </div>
                        <div class="cell-shadow" id="cellShadow"></div>
                        <div class="cell-split" id="cellSplit">
                            <div class="order-stay-plural stay-not-in">
                                <p class="fn-text-overflow"></p>
                                <p class="fn-text-overflow"></p>
                            </div>
                        </div>
                        <div class="order-cell j-order-cell order-cell-3317259202252814 j-daily-order ui-draggable ui-draggable-handle" data-index="0" style="left:300px;top:0px;" data-top="0" data-left="300" data-width="95" data-height="56" data-staystate="not_arrived" data-type="daily" data-repeat-rendered="stayRendered">
                            <div class="order-stay stay-not-in" style="width:95px;height:56px;">
                                <i class="channel-color x "></i>
                                <p>
                                    <label class="channel-name fn-text-overflow fn-vam wm65">线下客人</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <p>
                                    <label class="customer-name fn-text-overflow fn-vam wm85">张三</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <!--ms-if-->
                            </div>
                        </div>
                        <div class="order-cell j-order-cell order-cell-3317259202252814 j-daily-order ui-draggable ui-draggable-handle" data-index="1" style="left:300px;top:61px;" data-top="61" data-left="300" data-width="95" data-height="56" data-staystate="not_arrived" data-type="daily" data-repeat-rendered="stayRendered">
                            <div class="order-stay stay-not-in" style="width:95px;height:56px;">
                                <i class="channel-color x "></i>
                                <p>
                                    <label class="channel-name fn-text-overflow fn-vam wm65">线下客人</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <p>
                                    <label class="customer-name fn-text-overflow fn-vam wm85">张三</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <!--ms-if-->
                            </div>
                        </div>
                        <div class="order-cell j-order-cell order-cell-3317259238794915 j-daily-order ui-draggable ui-draggable-handle" data-index="2" style="left:300px;top:122px;" data-top="122" data-left="300" data-width="95" data-height="56" data-staystate="not_arrived" data-type="daily" data-repeat-rendered="stayRendered">
                            <div class="order-stay stay-not-in" style="width:95px;height:56px;">
                                <i class="channel-color x "></i>
                                <p>
                                    <label class="channel-name fn-text-overflow fn-vam wm65">线下客人</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <p>
                                    <label class="customer-name fn-text-overflow fn-vam wm85">李四</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <!--ms-if-->
                            </div>
                        </div>
                        <div class="order-cell j-order-cell order-cell-3317259202252814 j-daily-order ui-draggable ui-draggable-handle" data-index="3" style="left:200px;top:122px;" data-top="122" data-left="200" data-width="95" data-height="56" data-staystate="not_arrived" data-type="daily" data-repeat-rendered="stayRendered">
                            <div class="order-stay stay-not-in" style="width:95px;height:56px;">
                                <i class="channel-color x "></i>
                                <p>
                                    <label class="channel-name fn-text-overflow fn-vam wm65">线下客人</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <p>
                                    <label class="customer-name fn-text-overflow fn-vam wm85">张三</label>
                                    <!--ms-if-->
                                    <!--ms-if-->
                                </p>
                                <!--ms-if-->
                            </div>
                        </div>
                        <div class="cell-tips" id="cellTips">
                            <div class="smui-tip top">
                                <span class="smui-tip-arrow"></span>
                                <div class="smui-tip-inner">仅可以换到相同时间的房间</div>
                            </div>
                        </div>
                    </div>
                    <div class="close-room-list" id="closeRoomCell"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=path%>/static/js/jquery.3.2.1.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/room.js"></script>
<script type="text/javascript">
    $(function() {
        $("#filterSort").on('click', '.rs-panel-btns .btn-success', function(event) {
            /* 筛选与排序确认操作 */
            $(this).closest("#filterSort").toggleClass('unfold').find('.filter-sort-main').toggleClass('fn-hide fn-show');
            event.preventDefault();
            /* Act on the event */
        })
    })
</script>
</body>

</html>
