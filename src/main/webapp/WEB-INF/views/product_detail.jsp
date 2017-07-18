<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<title>Amor detail</title>
</head>
<body class="page-header-fixed">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container">
		<!-- BEGIN CONTENT BODY -->
		<div class="row search-box">

			<div class="col-md-8">
				<div id="carousel-example-generic" class="carousel slide detail-slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img class="img-responsive" src="assets/img/test/1.jpg" alt="">
						</div>
						<div class="item">
							<img class="img-responsive" src="assets/img/test/2.jpg" alt="">
						</div>
						<div class="item">
							<img class="img-responsive" src="assets/img/test/3.jpg" alt="">
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
			<div class="col-md-4 detail-info">
				<h3>Project Description</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus.
					Mauris ultricies, justo eu convallis placerat, felis enim.</p>
				<h3>Project Details</h3>
				<ul>
					<li>Lorem Ipsum</li>
					<li>Dolor Sit Amet</li>
					<li>Consectetur</li>
					<li>Adipiscing Elit</li>
				</ul>
			</div>
		</div>
		<!-- END CONTENT -->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>