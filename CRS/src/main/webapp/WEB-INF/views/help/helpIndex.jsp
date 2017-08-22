<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助中心</title>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
<link rel="stylesheet"
	href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
<link rel="stylesheet" href="${mybasePath}assets/css/style.css">
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-left">帮助中心</h3>
				</div>
			</div>
			<hr />
			<ul class="nav nav-tabs">
				<li class="active"><a href="#common" data-toggle="tab">常见问题</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade active in text-left" id="common">
					<div class="col-md-12 ">
						<div class="col-md-2">
							<p class="text-left">问题列表</p>
						</div>
					</div>
					<br /> <br />
					<div style="border-bottom: 1px solid #ccc;"></div>

					<dl id="idl">
						<c:forEach var="commonQA" items="${commonQA }" varStatus="status">
							<dt id="dt${commonQA.id }" style="margin: 10px 0px 10px 20px;">${commonQA.question }</dt>
							<dd style="display: none; margin-left: 40px;">${commonQA.answer }</dd>
							<div
								style="border-bottom: 1px dashed #ccc; width: 1300px; margin-left: 20px;"></div>
						</c:forEach>
					</dl>
				</div>
			</div>
		</div>

		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
<script type="text/javascript">
	$("#idl dt").click(function() {
		var me = $(this);
		me.nextUntil("dt").toggle();
	});
</script>
</html>