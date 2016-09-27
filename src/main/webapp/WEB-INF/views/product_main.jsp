<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
        <link href="assets/plugins/bootstrap-modal/css/simple-modal.css" rel="stylesheet" type="text/css" />
        <!-- END THEME STYLES -->
        <style type="text/css">
        .theme-popover-mask { z-index: 9998; position:fixed; top:0; left:0; width:100%; height:100%; background:#000; opacity:0.4; filter:alpha(opacity=40); display:none }
		.theme-popover { z-index:9999; position:fixed; top:50%; left:50%; width:660px; height:360px; margin:-180px 0 0 -330px; border-radius:5px; border:solid 2px #666; background-color:#fff; display:none; box-shadow: 0 0 10px #666; }
        </style>
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
                                    <a href="javascript;;">首页</a>
                                  <i class="fa fa-angle-right"></i>
                                </li>
                                <li class="active">产品信息</li>
                            </ul>
                            <!-- END PAGE TITLE & BREADCRUMB-->
                        </div>
                    </div>
                    <!-- END PAGE HEADER-->

                    <!-- BEGIN DASHBOARD STATS -->
                    <div id="main-content">
                    	<div class="row">
                    		<div class="col-xs-12">
                    		<c:choose>
                    			<c:when test="${param['success'] == 0 || param['error'] != null}">
                    			<div class="alert alert-danger alert-dismissible" role="alert">
                    				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    				<strong>Error:</strong>${error}
                    			</div>
                    			</c:when>
                    			<c:when test="${param['success'] == 1}">
                    			<div class="alert alert-success alert-dismissible" role="alert">
                    				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    				<strong>Sucess!</strong>
                    			</div>
                    			</c:when>
                    		</c:choose>
                    		</div>
                    	</div>
                    	<div class="row">
                    	  <div class="col-xs-12">
                    		<form action="/amor/rest/product/record" method="post" class="form-horizontal">
                    			<div class="form-group">
									<label for="item_type" class="col-sm-2 control-label">产品类型</label>
									<div  class="col-sm-8">
										<form:select path="typeMap" items="${typeMap}" class="form-control" id="item_type" name="item_type" />
									</div>
									<div  class="col-sm-2">
										<button type="submit" class="btn btn-success">
										  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
										</button>
									</div>
								</div>
                    		</form>
                    	  </div>
                    	</div>
					    <div class="row">
					      <div class="col-xs-12">
					        <div class="panel panel-default">
					          <div class="panel-heading">产品列表</div>
					          <c:if test="${page!=null}">
					          <table class="table table-striped" style="width:100%;">
					                <thead>
					                  <tr>
					                    <th>ID</th>
					                    <th>货号</th>
					                    <th>商品类型</th>
					                    <th>操作</th>
					                  </tr>
					                </thead>
					                <tbody>
					                <c:forEach items="${page.list}" var="product">
					                    <tr>
					                        <td>${product.id}</td>
					                        <td>${product.itemCode}</td>
					                        <td>${typeMap[product.itemType]}</td>
					                        <td>
					                          <a href="${pageContext.request.contextPath}/rest/product/edit?id=${product.id}" role="button" class="btn btn-primary btn-sm">
											    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改
											  </a>
											  <a rel="rs-dialog" data-target="myModal" role="button" class="btn btn-danger btn-sm" target="${product.id}">
											    <span class="glyphicon glyphicon-minus" aria-hidden="true"></span> 删除
											  </a>
					                        </td>
					                    </tr>
					                </c:forEach>
					                </tbody>
					            </table>
					          </c:if>
					        </div>
					      </div>
                    	</div>
                    	<div class="row">
                    	  <c:if test="${page!=null}">
                    	  <div class="col-xs-12 text-center">
                    	    <nav aria-label="Page navigation">
							  <ul class="pagination">
							   <c:choose>
							    <c:when test="${page.hasPreviousPage}">
							    <li>
							      <a href="${pageContext.request.contextPath}/rest/product/?pageNum=${page.prePage}&pageSize=${page.pageSize}" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
							    </c:when>
							    <c:otherwise>
							    <li class="disabled">
							      <a href="#" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
							    </c:otherwise>
							   </c:choose>
							   <c:forEach items="${page.navigatepageNums}" var="nav">
		                        <c:if test="${nav == page.pageNum}">
		                        <li class="active">
		                          <a href="#">${nav}
		                            <span class="sr-only">(current)</span>
		                          </a>
		                        </li>
		                        </c:if>
		                        <c:if test="${nav != page.pageNum}">
		                          <li>
		                            <a href="${pageContext.request.contextPath}/rest/product/?pageNum=${nav}&pageSize=${page.pageSize}">${nav}
		                            </a>
		                          </li>
		                        </c:if>
			                   </c:forEach>
			                   <c:choose>
							    <c:when test="${page.hasNextPage}">
							    <li>
							      <a href="${pageContext.request.contextPath}/rest/product/?pageNum=${page.nextPage}&pageSize=${page.pageSize}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							    </c:when>
							    <c:otherwise>
							    <li class="disabled">
							      <a href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							    </c:otherwise>
							   </c:choose>
							  </ul>
							</nav>
						  </div>
						  </c:if>
                    	</div>
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
        <div class="rs-dialog" id="myModal"> 
        <form method="post" action="/amor/rest/product/delete">
          <div class="rs-dialog-box"> 
            <a class="close" href="#">&times;</a> 
            <div class="rs-dialog-header"> 
              <h3>删除</h3> 
            </div> 
            <div class="rs-dialog-body"> 
              <p>请确认是否要删除该条记录</p> 
              <input type="hidden" value="" name="prod_id" id="prod_id" />
            </div> 
            <div class="rs-dialog-footer">
              <input type="button" class="btn btn-default rs-close" value="关闭" />
              <button type="submit" class="btn btn-danger">删除</button>
            </div>
          </div>
        </form>
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
		<script src="assets/plugins/bootstrap-modal/js/simple-modal.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>

        <script src="assets/scripts/app.js" type="text/javascript"></script>
        <!-- <script type="text/javascript" src="app/js/index.js"></script>
        <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->
    </body>
</html>