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
            <div class="col-lg-5 vcenter text-right">
                <a href="#">
                    <h3>XXXX 店</h3>
                    <p>XXXXdafadxxxx地区 xxxx路 门牌号</p>
                    <p>TEL:123456778</p>
                </a>
            </div><!--             
             --><div class="col-lg-6 vcenter">
                <div class="thumbnail-borderless text-center">
                	<div class="col-lg-10">
                        <img class="img-responsive img-portfolio img-hover" src="assets/img/gallery/media700x450.jpg" alt="">
	                </div>
                </div>
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