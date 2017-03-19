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
<title>Amor search</title>
</head>
<body class="page-header-fixed">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container">
		<!-- BEGIN CONTENT BODY -->
		<div class="row">
			<div class="col-lg-6">
				<form action="/amor/rest/product/search/" method="post" class="form-horizontal">
					<div class="input-group search-box">
						<input id="pageNum" name="pageNum" type="hidden" value="${page.pageNum}" /> 
						<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" /> 
						<input id="facettext" name="facettext" type="hidden" value="${page.facetFields}" />
						<input id="filtertext" name="filtertext" type="hidden" value="${filterFields}" /> 
						<input id="searchtext" name="searchtext" type="text" class="form-control" value="${searchtext}" placeholder="Search for..."> 
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">检索</button>
						</span>
					</div>
				</form>
			</div>
		</div>
		<div class="row facet-wrapper">
				<c:if test="${page != null && fn:length(page.facetResult) > 0}">
					<c:forEach var="facet" items="${page.facetResult}">
						<div class="col-lg-12">
						<h4>
							<c:choose>
								<c:when test="${facet.name == 'itemType' }">
									类型
								</c:when>
								<c:when test="${facet.name == 'trends' }">
									风格
								</c:when>
								<c:when test="${facet.name == 'color' }">
									颜色
								</c:when>
							</c:choose>
							<c:forEach var="item" items="${facet.values}">
								<span class="label label-default"><c:out value="${item.name}(${item.count })"></c:out></span>
							</c:forEach>
						</h4>
						</div>
					</c:forEach>
				</c:if>
		</div>
		<div class="row">
				<c:if test="${page != null && fn:length(page.list) > 0}">
					<c:forEach var="product" items="${page.list}">
					<div class="col-md-4 img-portfolio">
		                <a href="${pageContext.request.contextPath}/rest/product/detail?id=${product.id}">
		                    <img class="img-responsive img-hover" src="assets/img/test/1.jpg" alt="">
		                </a>
		                <h3>
		                    <a href="${pageContext.request.contextPath}/rest/product/detail?id=${product.id}">
		                    	<c:out value="${product.itemCode}"></c:out>
		                    </a>
		                </h3>
		                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
		            </div>
						
					</c:forEach>
				</c:if>
			</div>
			
		<!-- END CONTENT BODY -->
		<!-- END CONTENT -->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>