<%
	/********** 保存网站的基本路径 ***********/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	//将该路径地址缓存到 session中 ,例如：http://localhost:8080/CRS/
	session.setAttribute("mybasePath", basePath);
	//out.write(basePath);
%>

<!-- CSS部分引用开始 -->
<link href="${mybasePath}/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="${mybasePath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="${mybasePath}/static/css/animate.min.css" rel="stylesheet">
<link href="${mybasePath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
<!-- CSS部分引用结束 -->

<!-- JS部分引用开始  各自页面进行引用-->
<%-- <script src="${mybasePath}/static/js/jquery.min.js?v=2.1.4"></script>
<script src="${mybasePath}/static/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${mybasePath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${mybasePath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${mybasePath}/static/js/plugins/layer/layer.min.js"></script>
<script src="${mybasePath}/static/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="${mybasePath}/static/js/contabs.min.js"></script>
<script src="${mybasePath}/static/js/plugins/pace/pace.min.js"></script> --%>

<!-- JS部分引用结束 -->

<!-- 其他资源部分引用开始 -->
<link rel="shortcut icon" href="${mybasePath}/static/favicon.ico"><!-- 系统图标 -->
<!-- 其他资源部分引用结束 -->
