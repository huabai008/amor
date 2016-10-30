<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="MobileOptimized" content="320">
		<title>Amor登录</title>
		<!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN THEME STYLES -->
        <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages/login-soft.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
		<!-- END THEME STYLES -->
		<link rel="shortcut icon" href="assets/app/img/favicon.ico"/>
	</head>
	<body class="login">
		<div class="logo">
			<img src="assets/img/logo-big.png" alt=""/>
		</div>
		<div class="content">
			<form class="login-form" action="/amor/rest/user/login" method="post">
				<h3 class="form-title">登录</h3>
				<div class="alert alert-danger display-hide">
					<button class="close" data-close="alert"></button>
					<span>
						 <c:out value="${error }"></c:out>
					</span>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">用户名</label>
					<div class="input-icon">
						<i class="fa fa-user"></i>
						<input id="username" name="username" class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input id="password" name="password" type="password" class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码"/> 
					</div>
				</div>
				<div class="form-actions">
					<label class="checkbox">
						<input type="checkbox" name="remember" checked="checked" value="true" />
						下次自动登录
					</label>
					<button type="submit" class="btn blue pull-right">
						登录<i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>
				<div class="create-account">
					<p>
						 <a href="javascript:;" id="register-btn">注册账号</a>
					</p>
				</div>
				<div class="forget-password">
					<p>
						<a href="javascript:;" id="forget-password">忘记密码</a>
					</p>
				</div>
			</form>
			
			<form class="forget-form" action="index.html" method="post">
				<h3>忘记密码 ?</h3>
				<p>
					 请输入您的电子邮箱地址来重置您的密码.
				</p>
				<div class="form-group">
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
						<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email"/>
					</div>
				</div>
				<div class="form-actions">
					<button type="button" id="back-btn" class="btn">
						<i class="m-icon-swapleft"></i> 返回登录 </button>
					<button type="submit" class="btn blue pull-right">
						提交 <i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>
			</form>
			
			<form class="register-form" action="/amor/rest/user/register" method="post">
				<h3 class="form-title">注册</h3>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">用户名</label>
					<div class="input-icon">
						<i class="fa fa-user"></i>
						<input id="username" name="username" class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input id="register_password" name="password" type="password" class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码"/> 
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">再次输入密码</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input id="repassword" name="repassword" type="password" class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="再次输入密码"/> 
					</div>
				</div>
				<div class="form-group">
					<label>
						<input type="checkbox" id="agreement" name="agreement"/> 我同意 <a href="#">服务条款</a> 和 <a href="#">隐私政策</a>
					</label>
					<div id="register_agreement_error"></div>
				</div>
				<div class="form-actions">
					<button type="button" id="register-back-btn" class="btn">
						<i class="m-icon-swapleft"></i> 返回登录 
					</button>
					<button type="submit" class="btn blue pull-right">
						注册 <i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>
			</form>
		</div>
		<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
		<!-- BEGIN CORE PLUGINS -->
		<!--[if lt IE 9]>
			<script src="assets/plugins/respond.min.js"></script>
			<script src="assets/plugins/excanvas.min.js"></script> 
			<![endif]-->
		<script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
		<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
		<!-- END CORE PLUGINS -->
		<!-- BEGIN PAGE LEVEL PLUGINS -->
		<script src="assets/plugins/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
		<script src="assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="assets/plugins/select2/js/select2.min.js"></script>
		<!-- END PAGE LEVEL PLUGINS -->
		<!-- BEGIN PAGE LEVEL SCRIPTS -->
		<script src="assets/scripts/app.js" type="text/javascript"></script>
		<script src="assets/scripts/login-soft.js" type="text/javascript"></script>
		<!-- END PAGE LEVEL SCRIPTS -->
		<script>
				jQuery(document).ready(function() {     
				  App.init();
				  Login.init();
				});
			</script>
		<!-- END JAVASCRIPTS -->
	</body>
</html>