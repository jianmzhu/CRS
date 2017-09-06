<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约系统</title>
<%
	/********** 保存网站的基本路径 ***********/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	//将该路径地址缓存到 session中 ,例如：http://localhost:8090/tjnu_ssh_1128/
	session.setAttribute("mybasePath", basePath);
	out.write(basePath);
%>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
<link rel="stylesheet"
	href="${mybasePath}/resources/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${mybasePath}/resources/css/form-elements.css">
<link rel="stylesheet" href="${mybasePath}/resources/css/style.css">
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- <br />
					<br />
					<h2>预留页面标题</h2>
					<h5>预留内容小标题.</h5> -->
					<div id="tip" class="jumbotron text-left" style="padding-left: 45px; background-color: #ffffff">
						<div class="modal-header" style="padding-left: 45px;background-color: #ffffff">
							<button id="close" name = "close" type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
						</div>
						<h2>	
							公司资源管理系统
							</h1>
							<p>预约车辆</p>
							<p>
								<a class="btn btn-primary btn-lg" href="/ssm_pro/help/" >了解公司资源管理系统</a>
							</p>
					</div>

				</div>
			</div>
			<!-- /. ROW  -->
			<hr />
			<div class="carousel slide" id="carousel-630453">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-630453" class="active"></li>
					<li data-slide-to="1" data-target="#carousel-630453"></li>
					<li data-slide-to="2" data-target="#carousel-630453"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="" src="${mybasePath}/resources/img/1.jpg" />
						<div class="carousel-caption">
							<p>公司资源管理系统上线</p>
							<p>热烈庆祝预约系统上线。</p>
						</div>
					</div>
					<div class="item active">
						<img alt="" src="${mybasePath}/resources/img/2.jpg" />
						<div class="carousel-caption">
							<p>车辆预约查询功能</p>
							<p>支持车辆信息查询，助您准确查询车辆信息。</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="${mybasePath}/resources/img/3.jpg" />
						<div class="carousel-caption">
							<p>车辆信息</p>
							<p>车辆信息，助您提前了解。</p>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-630453"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="right carousel-control" href="#carousel-630453"
					data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
		<!-- /. PAGE INNER  -->

	</div>
	<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="${mybasePath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}/resources/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}/resources/js/jquery.backstretch.min.js"></script>
<!--不需要背景 <script src="resources/js/scripts.js"></script> -->
<!-- <script type="text/javascript">
	jQuery(document).ready(function() {
	
    $.backstretch("resources/img/backgrounds/1.jpg");
    
    });
    </script> -->
    <script type="text/javascript">
    $("#close").click(function(){
    	 /*  $("#tip").remove();  */
    	  $("#tip").fadeTo("slow", 0.01, function(){//fade
    		    $(this).slideUp("slow", function() {//slide up
    		      $(this).remove();//then remove from the DOM
    		    });
    		  }); 
    });
    </script>
</html>