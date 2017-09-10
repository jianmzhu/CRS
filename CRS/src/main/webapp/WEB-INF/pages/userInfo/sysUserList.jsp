<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>公司资源管理系统主页</title>

    <meta name="keywords" content="公司资源管理系统">
    <meta name="description" content="公司资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <!-- 公共页面元素 -->
    <jsp:include page="../headPages/head_common.jsp" />
    
    <!-- Data Tables -->
    <link href="${mybasePath}/bootstrapUI/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${mybasePath}/bootstrapUI/css/animate.min.css" rel="stylesheet">
    <link href="${mybasePath}/bootstrapUI/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>基本 <small>分类，查找</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table id="sysUserList" class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                	<th>行号</th>
                                    <th>用户工号</th>
                                    <th>用户姓名</th>
                                    <th>电话</th>
                                    <th>用户权限</th>
                                    <th>创建时间</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                   	<th>行号</th>
                                    <th>用户工号</th>
                                    <th>用户姓名</th>
                                    <th>电话</th>
                                    <th>用户权限</th>
                                    <th>创建时间</th>
                                </tr>
                            </tfoot>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Data Tables -->
    <script src="${mybasePath}/bootstrapUI/js/jquery.min.js?v=2.1.4"></script>
    <script src="${mybasePath}/bootstrapUI/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${mybasePath}/bootstrapUI/js/plugins/jeditable/jquery.jeditable.js"></script>
    <script src="${mybasePath}/bootstrapUI/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${mybasePath}/bootstrapUI/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="${mybasePath}/bootstrapUI/js/content.min.js?v=1.0.0"></script>
	
	<script type="text/javascript">
		//获取当前项目的路径
	    var urlRootContext = (function () {
	        var strPath = window.document.location.pathname;
	        var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	        return postPath;
	    })();
	
		$(function() {
			var url =  urlRootContext + "/getSysUser/list"; //请求的网址
			//var reqParams = {'userName':userName, 'pageNumber':pageNumber,'pageSize':pageSize};//请求数据
			var reqParams = {'userName':'', 'pageNumber':1,'pageSize':10};//请求数据
			
			$(document).ready(function() {
					$('#sysUserList').DataTable({
						"processing" : true,
						"serverSide" : true,
						"ajax" : {
							"type" : "POST",
							"url" : url,
							"data" : reqParams,
							"async" : false
						},
						"columns" : [ {
							"data" : "userId"
						}, {
							"data" : "userJobno"
						}, {
							"data" : "userName"
						}, {
							"data" : "userPhone"
						}, {
							"data" : "userEmail"
						}, {
							"data" : "createTime"
						} ]
					});
				});
			});
	</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:45 GMT -->
</html>