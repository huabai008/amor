<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品信息</title>

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN THEME STYLES -->
<link href="assets/css/style-metronic.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/style.css" rel="stylesheet" type="text/css" />
<link href="assets/css/style-responsive.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/bootstrap-fileupload/bootstrap-fileupload.css"
	rel="stylesheet" type="text/css" />
<link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
<link href="assets/css/themes/default.css" rel="stylesheet"
	type="text/css" id="style_color" />
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
			<a class="navbar-brand" href="javascript:;"> <img
				src="assets/img/logo.png" alt="logo" class="img-responsive" />
			</a>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse"> <img
				src="assets/img/menu-toggler.png" alt="" />
			</a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" data-hover="dropdown"
					data-close-others="true"> <img alt=""
						src="assets/img/avatar1_small.jpg" /> <span class="username">
							${userInfo.username } </span> <i class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:;" id="trigger_fullscreen"> <i
								class="fa fa-move"></i> 全屏
						</a></li>
						<li><a href="extra_lock.html"> <i class="fa fa-lock"></i>
								锁屏
						</a></li>
						<li><a href="rest/user/logout"> <i class="fa fa-key"></i>
								退出
						</a></li>
					</ul></li>
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
						<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					</li>

					<li class="start active"><a href="rest/page/dashboard"
						id="btn-dashboard"> <i class="fa fa-home"></i><span
							class="title"> 首页 </span><span class="selected"> </span>
					</a></li>

					<li class=""><a href="javascript:;"> <i
							class="fa fa-gears"></i><span class="title"> 系统管理 </span><span
							class="arrow "> </span>
					</a>
						<ul class="sub-menu">
							<li><a href="javascript:;"> 用户管理 </a></li>
							<li><a href="javascript:;"> 角色管理 </a></li>
							<li><a href="javascript:;"> 权限管理 </a></li>
						</ul></li>

					<li class=""><a href="javascript:;"> <i class="fa fa-user"></i><span
							class="title"> 个人中心 </span><span class="arrow "> </span>
					</a>
						<ul class="sub-menu">
							<li><a href="javascript:;"> 信息修改 </a></li>
							<li><a href="javascript:;"> 密码修改 </a></li>

						</ul></li>

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
							<li><i class="fa fa-home"></i> <a href="#"> 首页 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="/rest/product/"> 产品信息 </a> <i
								class="fa fa-angle-right"></i></li>
							<li class="active"><c:choose>
									<c:when test="${product != null}">更新产品信息</c:when>
									<c:otherwise>新增产品信息</c:otherwise>
								</c:choose></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->

				<!-- BEGIN DASHBOARD STATS -->
				<div id="main-content">
					<c:choose>
						<c:when test="${ product == null }">
							<form action="/amor/rest/product/new" method="POST" role="form" enctype="multipart/form-data"
								id="product_info">
						</c:when>
						<c:otherwise>
							<form action="/amor/rest/product/update" method="POST" enctype="multipart/form-data"
								role="form" id="product_info">
						</c:otherwise>
					</c:choose>
					<div class="row bottom-buffer">
						<div class="col-xs-6">
							<label><i>*</i>产品类型</label>
							<form:select path="typeMap" class="form-control" id="type"
								name="type">
								<c:forEach items="${typeMap}" var="s">
									<c:choose>
										<c:when
											test="${(product != null && s.key == product.itemType) || s.key == item_type}">
											<option value="${s.key}" selected="true">${s.value}</option>
										</c:when>
										<c:otherwise>
											<option value="${s.key}">${s.value}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
						</div>
						<div class="col-xs-6">
							<label><i>*</i>货号</label>
							<c:if test="${product == null}">
								<input class="form-control" id="item_no" name="item_no" value=""></input>
							</c:if>
							<c:if test="${product != null}">
								<input class="form-control" id="item_no" name="item_no"
									value="${product.itemCode}"></input>
							</c:if>
						</div>
						<div class="clearfix"></div>
						<c:if
							test="${(product != null && product.itemType == 0 || product.itemType == 1) || item_type == 0 || item_type == 1 }">
							<div class="col-xs-4">
								<label>风格</label>
								<div class="form-control">
									<c:forEach var="t" items="${trendsMap}">
										<div id="trends" class="checkbox-inline">
											<label> <c:choose>
													<c:when test="${product != null && prod_trds[t.key] == 1}">
														<input name="trends" type="checkbox" value="${t.key}"
															checked>${t.value}
										    </c:when>
													<c:otherwise>
														<input name="trends" type="checkbox" value="${t.key}">${t.value}
										    </c:otherwise>
												</c:choose>
											</label>
										</div>
									</c:forEach>
								</div>
								<!-- <form:select path="trendsMap" items="${trendsMap}" class="form-control" id="trends" name="trends" />  
									<input class="form-control" id="trends" name="trends" value=""></input> -->
							</div>
							<div class="col-xs-4">
								<label>裙型</label>
								<form:select path="silhouetteMap" class="form-control"
									id="silhouette" name="silhouette">
									<c:forEach items="${silhouetteMap}" var="s">
										<c:choose>
											<c:when
												test="${product != null && s.key == product.silhouette}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-xs-4">
								<label>领型</label>
								<form:select path="necklineMap" class="form-control"
									id="neckline" name="neckline">
									<c:forEach items="${necklineMap}" var="s">
										<c:choose>
											<c:when
												test="${product != null && s.key == product.neckline}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="clearfix"></div>
							<div class="col-xs-4">
								<label>腰部</label>
								<form:select path="waistlineMap" class="form-control"
									id="waistline" name="waistline">
									<c:forEach items="${waistlineMap}" var="s">
										<c:choose>
											<c:when
												test="${product != null && s.key == product.waistline}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-xs-4">
								<label>袖长</label>
								<form:select path="sleeveMap" class="form-control" id="sleeve"
									name="sleeve">
									<c:forEach items="${sleeveMap}" var="s">
										<c:choose>
											<c:when test="${product != null && s.key == product.sleeve}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-xs-2">
								<label>颜色</label>
								<form:select path="colorMap" class="form-control" id="color"
									name="color">
									<c:forEach items="${colorMap}" var="s">
										<c:choose>
											<c:when test="${product != null && s.key == product.color}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-xs-2">
								<label>尺码</label>
								<form:select path="sizeMap" class="form-control" id="size"
									name="size">
									<c:forEach items="${sizeMap}" var="s">
										<c:choose>
											<c:when
												test="${product != null && s.key.toString() == product.size}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="clearfix"></div>
						</c:if>
						<c:if
							test="${(product != null && product.itemType == 2) || item_type  == 2}">
							<div class="col-xs-4">
								<label>版型</label>
								<form:select path="versionMap" class="form-control" id="version"
									name="version">
									<c:forEach items="${versionMap}" var="s">
										<c:choose>
											<c:when test="${product != null && s.key == product.version}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-xs-4">
								<label>门襟</label>
								<form:select path="placketMap" class="form-control" id="placket"
									name="placket">
									<c:forEach items="${placketMap}" var="s">
										<c:choose>
											<c:when test="${product != null && s.key == product.placket}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-xs-4">
								<label>领撑</label>
								<form:select path="collar_staysMap" class="form-control"
									id="collar" name="collar">
									<c:forEach items="${collar_staysMap}" var="s">
										<c:choose>
											<c:when
												test="${product != null && s.key == product.collarStays}">
												<option value="${s.key}" selected="true">${s.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${s.key}">${s.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="clearfix"></div>
							<div class="col-xs-4">
								<label>白领白袖</label>
								<div class="form-control">
									<label class="radio-inline"> <c:choose>
											<c:when
												test="${product == null || product.whiteCollarSleeve == 1}">
												<input type="radio" name="white_collar" value="1"
													id="white_collar1" autocomplete="off" checked> 是
									    </c:when>
											<c:otherwise>
												<input type="radio" name="white_collar" value="1"
													id="white_collar1" autocomplete="off"> 是
									    </c:otherwise>
										</c:choose>
									</label> <label class="radio-inline"> <c:choose>
											<c:when
												test="${product != null && product.whiteCollarSleeve == 0}">
												<input type="radio" name="white_collar" value="0"
													id="white_collar0" autocomplete="off" checked> 否
									    </c:when>
											<c:otherwise>
												<input type="radio" name="white_collar" value="0"
													id="white_collar0" autocomplete="off"> 否
									    </c:otherwise>
										</c:choose>
									</label>
								</div>
							</div>
							<div class="col-xs-4">
								<label>口袋</label>
								<div class="form-control">
									<label class="radio-inline"> <c:choose>
											<c:when test="${product == null || product.pocket == '1'}">
												<input type="radio" name="pocket" value="1" id="pocket1"
													autocomplete="off" checked> 有
									    </c:when>
											<c:otherwise>
												<input type="radio" name="pocket" value="1" id="pocket1"
													autocomplete="off"> 有
									    </c:otherwise>
										</c:choose>
									</label> <label class="radio-inline"> <c:choose>
											<c:when test="${product != null && product.pocket == '0'}">
												<input type="radio" name="pocket" value="0" id="pocket0"
													autocomplete="off" checked> 无
									    </c:when>
											<c:otherwise>
												<input type="radio" name="pocket" value="0" id="pocket0"
													autocomplete="off"> 无
									    </c:otherwise>
										</c:choose>
									</label>
								</div>
							</div>
							<div class="col-xs-4">
								<label>面料编号</label> <input class="form-control" id="material"
									name="material" value="${ product.material }"></input>
							</div>
							<div class="clearfix"></div>
						</c:if>
						<div class="col-xs-4">
							<label>出厂价</label> <input class="form-control" id="price_cost"
								name="price_cost" value="${ product.priceCost }" required></input>
						</div>
						<div class="col-xs-4">
							<label>租赁价</label> <input class="form-control" id="price_rent"
								name="price_rent" value="${ product.priceRent }" required></input>
						</div>
						<div class="col-xs-4">
							<label>零售价</label> <input class="form-control" id="price_sell"
								name="price_sell" value="${ product.priceSell }" required></input>
						</div>
						<div class="clearfix"></div>
						<div class="col-xs-4">
							<label>代理价</label> <input class="form-control" id="price_agent"
								name="price_agent" value="${ product.priceAgent }" required></input>
						</div>
						<div class="col-xs-4">
							<label>加盟商价</label> <input class="form-control"
								id="price_alliance" name="price_alliance"
								value="${ product.priceAlliance }" required></input>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="row bottom-buffer">
					  <c:forEach items="${prod_imgs}" var="img">
						<div class="col-xs-12 col-lg-3">
							<div class="fileupload fileupload-exists" data-provides="fileupload" data-picid="${img.id}">
								<div class="fileupload-preview thumbnail"
									data-trigger="fileupload" style="width: 200px; height: 150px;">
									<img src="${img.imgPath}" height="150px" />
								</div>
								<div>
									<span class="btn btn-default btn-file"><span
										class="fileupload-new">Select image</span><span
										class="fileupload-exists">Change</span><input type="file"
										name="file"></span> <a href="#"
										class="btn btn-default fileupload-exists"
										data-dismiss="fileupload">Remove</a>
								</div>
								<input type="hidden" name="del" value="" />
							</div>
						</div>
					  </c:forEach>
						<div class="col-xs-12 col-lg-3">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-preview thumbnail"
									data-trigger="fileupload" style="width: 200px; height: 150px;"></div>
								<div>
									<span class="btn btn-default btn-file"><span
										class="fileupload-new">Select image</span><span
										class="fileupload-exists">Change</span><input type="file"
										name="file"></span> <a href="#"
										class="btn btn-default fileupload-exists"
										data-dismiss="fileupload">Remove</a>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-lg-3">
							<button type="button" class="btn btn-lg btn-primary" id="btn-add-image">添加图片</button>
						</div>
					</div>
					<div class="row bottom-buffer">
						<div class="col-xs-4">
							<input type="hidden" id="create_uid" name="create_uid" value="${ product.createUid }"></input>
							<input type="hidden" id=user_no " name="user_no" value="${ product.updateUid }000"></input>
							<input type="hidden" id="create_time" name="create_time" value="${ createDate }"></input>
							<input type="hidden" id="prod_id" name="prod_id" value="${ product.id }"></input>
							<input type="hidden" id="page" name="page" value="${param['page']}"></input>
							<button type="submit" class="btn btn-success">提交</button>
							<a href="javascript:history.back()" class="btn btn-danger">取消</a>
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
		<div class="footer-inner">2014 &copy; Quick4j By Eliteams.</div>
		<div class="footer-tools">
			<span class="go-top"><i class="fa fa-angle-up"></i></span>
		</div>
	</div>
	<!--[if lt IE 9]>
        <script src="assets/plugins/respond.min.js"></script>
        <script src="assets/plugins/excanvas.min.js"></script>
        <![endif]-->
    <script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
	<script src="assets/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>

	<script
		src="assets/plugins/jquery-validation/dist/jquery.validate.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="assets/plugins/select2/select2.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/bootstrap-fileupload/bootstrap-fileupload.js"></script>

	<script src="assets/scripts/app.js" type="text/javascript"></script>
	<script type="text/javascript" src="app/js/record-page-custom.js"></script>

	<!-- <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->
	<r:require modules="bootstrap-file-upload" />
</body>
</html>