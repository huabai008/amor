<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
String productType = request.getParameter("item_type");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>产品信息</title>
		
		<!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN THEME STYLES -->
        <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME STYLES -->
	</head>
	<!-- BEGIN BODY -->
    <body class="page-header-fixed">
        <!-- BEGIN HEADER -->
        <div class="header navbar navbar-inverse navbar-fixed-top">
            <!-- BEGIN TOP NAVIGATION BAR -->
            <div class="header-inner">
                <!-- BEGIN LOGO -->
                <a class="navbar-brand" href="javascript:;">
                    <img src="assets/img/logo.png" alt="logo" class="img-responsive" />
                </a>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <img
                    src="assets/img/menu-toggler.png" alt="" />
                </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN TOP NAVIGATION MENU -->
                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown user">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <img alt="" src="assets/img/avatar1_small.jpg"/>
                            <span class="username"> ${userInfo.username } </span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="javascript:;" id="trigger_fullscreen">
                                    <i class="fa fa-move"></i> 全屏
                                </a>
                            </li>
                            <li>
                                <a href="extra_lock.html">
                                    <i class="fa fa-lock"></i> 锁屏
                                </a>
                            </li>
                            <li>
                                <a href="rest/user/logout">
                                    <i class="fa fa-key"></i> 退出
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- END USER LOGIN DROPDOWN -->
                </ul>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END TOP NAVIGATION BAR -->
        </div>
        <!-- END HEADER -->
        <div class="clearfix"></div>
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            <div class="page-sidebar-wrapper">
                <div class="page-sidebar navbar-collapse collapse">
                    <!-- BEGIN SIDEBAR MENU -->
                    <ul class="page-sidebar-menu" id="page-sidebar-menu">
                        <li class="sidebar-toggler-wrapper">
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                            <div class="sidebar-toggler hidden-phone"></div>
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                        </li>

                        <li class="start active">
                            <a href="rest/page/dashboard" id="btn-dashboard">
                                <i class="fa fa-home"></i><span class="title"> 首页 </span><span
                                class="selected"> </span>
                            </a>
                        </li>

                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-gears"></i><span class="title"> 系统管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;">
                                        用户管理
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        角色管理
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        权限管理
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-user"></i><span class="title"> 个人中心 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;">
                                        信息修改
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        密码修改
                                    </a>
                                </li>
     
                            </ul>
                        </li>

                    </ul>
                    <!-- END SIDEBAR MENU -->
                </div>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <div class="page-content">
                    <!-- BEGIN PAGE HEADER-->
                    <div class="row">
                        <div class="col-md-12">
                            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                            <h3 class="page-title" id="index-page-title">产品信息录入</h3>
                            <ul class="page-breadcrumb breadcrumb">
                                <li>
                                    <i class="fa fa-home"></i>
                                    <a href="javascript:;">
                                        首页
                                    </a>
                                    <i class="fa fa-angle-right"></i>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        Dashboard
                                    </a>
                                </li>
                            </ul>
                            <!-- END PAGE TITLE & BREADCRUMB-->
                        </div>
                    </div>
                    <!-- END PAGE HEADER-->

                    <!-- BEGIN DASHBOARD STATS -->
                    <div id="main-content">
                    	<form action="/amor/rest/product/new" method="POST" role="form" id="product_info">
                    		<div class="row">
                    			<div class="col-xs-6">
									<label><i>*</i>产品类型</label>
									<form:select path="typeMap" items="${typeMap}" class="form-control" id="type" name="type" />
								</div>
								<div class="col-xs-6">
									<label><i>*</i>货号</label>
									<input class="form-control" id="item_no" name="item_no" value=""></input>
								</div>
								<div class="clearfix"></div>
								<% if (productType.compareTo("0") == 0 || productType.compareTo("1") == 0) { %>
								<div class="col-xs-4">
									<label>风格</label>
									<div class="form-control">
										<c:forEach var="t" items="${trendsMap}">
										<div id="trends" class="checkbox-inline">
										  <label>
										    <input name="trends" type="checkbox" value="${t.key}">${t.value}
										  </label>
										</div>
										</c:forEach>
									</div>
									<!-- <form:select path="trendsMap" items="${trendsMap}" class="form-control" id="trends" name="trends" />  
									<input class="form-control" id="trends" name="trends" value=""></input> -->
								</div>
								<div class="col-xs-4">
									<label>裙型</label>
									<form:select path="silhouetteMap" items="${silhouetteMap}" class="form-control" id="silhouette" name="silhouette" />
								</div>
								<div class="col-xs-4">
									<label>领型</label>
									<form:select path="necklineMap" items="${necklineMap}" class="form-control" id="neckline" name="neckline" />
								</div>
								<div class="clearfix"></div>
								<div class="col-xs-4">
									<label>腰部</label>
									<form:select path="waistlineMap" items="${waistlineMap}" class="form-control" id="waistline" name="waistline" />
								</div>
								<div class="col-xs-4">
									<label>袖长</label>
									<form:select path="sleeveMap" items="${sleeveMap}" class="form-control" id="sleeve" name="sleeve" />
								</div>
								<div class="col-xs-2">
									<label>颜色</label>
									<form:select path="colorMap" items="${colorMap}" class="form-control" id="color" name="color" />
								</div>
								<div class="col-xs-2">
									<label>尺码</label>
									<form:select path="sizeMap" items="${sizeMap}" class="form-control" id="size" name="size" />
								</div>
								<div class="clearfix"></div>
								
								<% } %>
								<% if (productType.compareTo("2") == 0) { %>
								<div class="col-xs-4">
									<label>版型</label>
									<form:select path="versionMap" items="${versionMap}" class="form-control" id="version" name="version" />
								</div>
								<div class="col-xs-4">
									<label>门襟</label>
									<form:select path="placketMap" items="${placketMap}" class="form-control" id="placket" name="placket" />
								</div>
								<div class="col-xs-4">
									<label>领撑</label>
									<form:select path="collar_staysMap" items="${collar_staysMap}" class="form-control" id="collar" name="collar" />
								</div>
								<div class="clearfix"></div>
								<div class="col-xs-4">
									<label>白领白袖</label>
									<div class="form-control">
									  <label class="radio-inline">
									    <input type="radio" name="white_collar" value="1" id="white_collar1" autocomplete="off" checked> 是
									  </label>
									  <label class="radio-inline">
									    <input type="radio" name="white_collar" value="0" id="white_collar0" autocomplete="off"> 否
									  </label>
									</div>
								</div>
								<div class="col-xs-4">
									<label>口袋</label>
									<div class="form-control">
									  <label class="radio-inline">
									    <input type="radio" name="pocket" value="1" id="pocket1" autocomplete="off" checked> 有
									  </label>
									  <label class="radio-inline">
									    <input type="radio" name="pocket" value="0" id="pocket0" autocomplete="off"> 无
									  </label>
									</div>
								</div>
								<div class="col-xs-4">
									<label>面料编号</label>
									<input class="form-control" id="material" name="material" value=""></input>
								</div>
								<div class="clearfix"></div>
								<% } %>
								<div class="col-xs-4">
									<label>出厂价</label>
									<input class="form-control" id="price_cost" name="price_cost" value="" required></input>
								</div>
								<div class="col-xs-4">
									<label>代理价</label>
									<input class="form-control" id="price_agent" name="price_agent" value="" required></input>
								</div>
								<div class="col-xs-4">
									<label>租赁价</label>
									<input class="form-control" id="price_rent" name="price_rent" value="" required></input>
								</div>
								<div class="clearfix"></div>
								<div class="col-xs-4">
									<label>零售价</label>
									<input class="form-control" id="price_sell" name="price_sell" value="" required></input>
								</div>
								<div class="col-xs-4">
									<label>加盟商价</label>
									<input class="form-control" id="price_alliance" name="price_alliance" value="" required></input>
								</div>
								<div class="clearfix"></div>
								<div class="col-xs-4">
									<input type="hidden" id="user_no" name="user_no" value="${user_no}000"></input>
									<button type="submit" class="btn btn-success">提交</button>
								</div>
                    		</div>
                    	</form>
                    </div>

                    <!-- END PORTLET-->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <div class="footer">
            <div class="footer-inner">
                2014 &copy; Quick4j By Eliteams.
            </div>
            <div class="footer-tools">
                <span class="go-top"><i class="fa fa-angle-up"></i></span>
            </div>
        </div>
        <!--[if lt IE 9]>
        <script src="assets/plugins/respond.min.js"></script>
        <script src="assets/plugins/excanvas.min.js"></script>
        <![endif]-->
        <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

        <script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>

        <script src="assets/scripts/app.js" type="text/javascript"></script>
        <script type="text/javascript" src="app/js/index.js"></script>
        <script type="text/javascript">
        $( document ).ready(function() {
            console.log( "ready!" );
            $("#product_info").validate();
            $('select#type').val("<%=productType%>");
            //$('select#type').attr("disabled", true);
        });
        </script>

        <!-- <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->
    </body>
</html>