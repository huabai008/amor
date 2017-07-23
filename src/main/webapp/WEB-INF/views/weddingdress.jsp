<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<head>
<jsp:include page="header.jsp"></jsp:include>
<title>Amor Weddings - The Best Moment Throughout Your Life</title>
</head>
<body class="page-header-fixed">
	<jsp:include page="menu.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container">
        <div class="row margin-top-32">
            <div class="col-lg-10 col-md-offset-1">
            	<div class="thumbnail-borderless text-center">
                    <h3>XXXX 系列</h3>
                    <p>Amor Fashion Collection</p>
                </div>
            </div>
            <div class="col-lg-8 col-md-offset-2">
                <a href="rest/page/weddingdress_detail">
                    <div>
                        <img class="img-responsive img-portfolio img-hover" src="assets/img/gallery/thumb700x450-m.jpg" alt="">
                    </div>
                </a>
            </div>
        </div>
        
        <div class="row">
            <div class="col-lg-10 col-md-offset-1">
            	<div class="thumbnail-borderless text-center">
                    <h3>XXXX 系列</h3>
                    <p>Amor Fashion Collection</p>
                </div>
            </div>
            <div class="col-lg-8 col-md-offset-2">
                <a href="rest/page/weddingdress_detail">
                    <div>
                        <img class="img-responsive img-portfolio img-hover" src="assets/img/gallery/thumb700x450-m.jpg" alt="">
                    </div>
                </a>
            </div>
        </div>
    </div>   

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>

</body>

</html>