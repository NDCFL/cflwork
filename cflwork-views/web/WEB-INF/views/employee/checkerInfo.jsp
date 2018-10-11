<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/11/12
  Time: 16:13
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
    <title>${userVo.phone}详细信息</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/profile_small.jpg">
                            <div class="m-t-xs font-bold">CEO</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>陈飞龙</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 江西赣州</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:275300091@qq.com<br>
                            QQ:<a href="http://wpa.qq.com/msgrd?v=3&uin=275300091&site=qq&menu=yes">275300091</a><br>
                            <abbr title="Phone">Tel:</abbr>17607975702
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a1.jpg">
                            <div class="m-t-xs font-bold">营销总监</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>灞波儿奔</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 四川·成都</p>
                        <address>
                            <strong>Taobao, Inc.</strong><br>
                            E-mail:xxx@taobao.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a3.jpg">
                            <div class="m-t-xs font-bold">Marketing manager</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>Monica Smith</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a4.jpg">
                            <div class="m-t-xs font-bold">攻城师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>Michael Zimber</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a5.jpg">
                            <div class="m-t-xs font-bold">射鸡师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>作家崔成浩</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a6.jpg">
                            <div class="m-t-xs font-bold">射鸡师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>韩寒</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a1.jpg">
                            <div class="m-t-xs font-bold">CEO</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>郭敬明</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a2.jpg">
                            <div class="m-t-xs font-bold">射鸡师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>马云</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a3.jpg">
                            <div class="m-t-xs font-bold">市场总监</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>范爷</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a4.jpg">
                            <div class="m-t-xs font-bold">攻城师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>李彦宏</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a5.jpg">
                            <div class="m-t-xs font-bold">射鸡师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>小马哥</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a6.jpg">
                            <div class="m-t-xs font-bold">射鸡师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>乔峰</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>

            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a1.jpg">
                            <div class="m-t-xs font-bold">CEO</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>慕容晓晓</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a2.jpg">
                            <div class="m-t-xs font-bold">射鸡师</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>高圆圆</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</html>