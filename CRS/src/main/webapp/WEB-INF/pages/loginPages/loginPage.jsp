<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
    <style>
		.loginscreen.middle-box {
		  width: 350px
		}
	</style>
   
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">CRS</h1>

            </div>
            <h3>欢迎使用公司资源管理系统</h3>

            <form class="m-t" role="form" method="post" action="${mybasePath}/login">
                <div class="form-group">
                    <input type="text" class="form-control" name="userJobNo" id="userJobNo" placeholder="工号" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="密码" required="">
                </div>
                <div class="form-group">
					<p class="text-danger"	id="errorTip">${error}</p>
				</div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            </form>
        </div>
    </div>
</body>
</html>
