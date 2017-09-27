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
<meta name="description"
	content="公司资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<!-- 公共页面元素 -->
<jsp:include page="../headPages/head_common.jsp" />

<!-- Data Tables -->
<link
	href="${mybasePath}/static/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="${mybasePath}/static/css/animate.min.css"
	rel="stylesheet">
<link href="${mybasePath}/static/css/style.min862f.css?v=4.1.0"
	rel="stylesheet">
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							基本 <small>分类，查找</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">

						<table id="tablelist"
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>预约日期</th>
									<th>预约时间</th>
									<th>工号</th>
									<th>约车时间段</th>
									<th>约车摘要</th>
									<th>操作</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>预约日期</th>
									<th>预约时间</th>
									<th>工号</th>
									<th>约车时间段</th>
									<th>约车摘要</th>
									<th>操作</th>
								</tr>
							</tfoot>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Data Tables -->
	<script src="${mybasePath}/static/js/jquery.min.js?v=2.1.4"></script>
	<script src="${mybasePath}/static/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="${mybasePath}/static/js/plugins/jeditable/jquery.jeditable.js"></script>
	<script
		src="${mybasePath}/static/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script
		src="${mybasePath}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="${mybasePath}/static/js/content.min.js?v=1.0.0"></script>

	<script type="text/javascript">
		//获取当前项目的路径
	    var urlRootContext = (function () {
	        var strPath = window.document.location.pathname;
	        var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	        return postPath;
	    })();
	
		$(function() {
			var url =  urlRootContext + "/getBookCarDtl/list"; //请求的网址
			
			$(document).ready(function() {
					$('#tablelist').DataTable({
						"sAjaxSource" : url,
						"bPaginate": true, //开关，是否显示分页器  默认为true 是否开启分页功能,即使设置为false,仍然会有一个默认的<前进,后退>分页组件 
						"bInfo": true, //开关，是否显示表格的一些信息 条数、目前第几条等信息 默认为true 是否显示表格信息，是指当前页面上显示的数据的信息，如果有过滤操作执行，也会显示过滤操作的信息 
						//是否对数据进行过滤，数据过滤是十分灵活的，允许终端用户输入多个用空格分隔开的关键字  
						//匹配包含这些关键字的行，即使关键字的顺序不是用户输入的顺序，过滤操作会跨列进行匹配，关键字可以分布在一行中不同的列  
						//要注意的是如果你想在DataTable中使用过滤，该选项必须设置为true，如果想移除默认过滤输入框但是保留过滤功能，请设置为false(API没写，推测是false) 
						"bFilter": false, //开关，是否启用客户端过滤器 全体字段过滤查询框 默认为true
						"bProcessing" : true,//开启处理中提示 当表格在处理的时候（比如排序操作）是否显示“处理中...” 当表格的数据中的数据过多以至于对其中的记录进行排序时会消耗足以被察觉的时间的时候，该选项会有些用处
						//"sDom": "<>lfrtip<>",
						//"bAutoWith": false,//自动列宽 默认为true  是否自动计算列宽，计算列宽会花费一些时间，如果列宽通过aoColumns传递，可以关闭该属性作为优化 
						//"bJQueryUI": true, //开关，是否启用JQueryUI风格 默认为fasle 是否开启jQuery UI ThemeRoller支持，需要一些ThemeRoller使用的标记，这些标记有些与DataTable传统使用的有轻微的差异，有些是额外附加的
						"bLengthChange": true, //开关，是否显示每页大小的下拉框  默认为true 是否允许终端用户从一个选择列表中选择分页的页数，页数为10，25，50和100，需要分页组件bPaginate的支持
						//是否开启不限制长度的滚动条（和sScrollY属性结合使用），不限制长度的滚动条意味着当用户拖动滚动条的时候DataTable会不断加载数据  当数据集十分大的时候会有些用处，该选项无法和分页选项同时使用，分页选项会被自动禁止，注意，额外推荐的滚动条会优先与该选项 
						//"bScrollInfinite": true,//是否开启不限制长度的滚动条（和sScrollY属性结合使用）默认为false 
						"sProcessing" : "正在加载数据中，请稍候...",//处理中提示
						"bServerSide" : true,// 默认为false 配置DataTable使用服务器端处理，注意，sAjaxSource参数必须指定，以便给DataTable一个为每一行获取数据的数据源 
						//是否开启水平滚动，当一个表格过于宽以至于无法放入一个布局的时候，或者表格有太多列的时候，你可以开启该选项 从而在一个可横向滚动的视图里面展示表格，该属性可以是css设置，或者一个数字（作为像素量度来使用）
						//"sScrollX":"100%",//默认为空字符串，即：无效
						// 是否开启垂直滚动，垂直滚动会驱使DataTable设置为给定的长度，任何溢出到当前视图之外的数据可以通过垂直滚动进行察看 当在小范围区域中显示大量数据的时候，可以在分页和垂直滚动中选择一种方式，该属性可以是css设置，或者一个数字（作为像素量度来使用）
						//"sScrollY": "800px", //是否开启垂直滚动，以及指定滚动区域大小,可设值：'disabled','2000px' 默认为空字符串，即：无效
		                "bSort": true, //开关，是否启用各列具有按列排序的功能 默认为true  是否开启列排序，对单独列的设置在每一列的bSortable选项中指定 
		                //默认为true 是否在当前被排序的列上额外添加sorting_1,sorting_2,sorting_3三个class，当该列被排序的时候，可以切换其背景颜色 该选项作为一个来回切换的属性会增加执行时间（当class被移除和添加的时候） 
		                //"bSortClasses":true, //当对大数据集进行排序的时候你或许希望关闭该选项 
		                //"bStateSave":true,//开关，是否打开客户端状态记录功能。这个数据是记录在cookies中的，	例如分页信息，展示长度，过滤和排序等 		打开了这个记录后，即使刷新一次页面，或重新打开浏览器，之前的状态都是保存下来的-			------当值为true时aoColumnDefs不能隐藏列
						//"aaSorting": [[1, "asc"],[2,"desc"]],//多列排序
						"aLengthMenu":[[5,20,50,100],[5,20,50,100]],//这个为选择每页的条目数，当使用一个二维数组时，二维层面只能有两个元素，第一个为显示每页条目数的选项，第二个是关于这些选项的解释
						// /*TODO*/"aoSearchCols":[null, {"sSearch": "My filter"}, null,{"sSearch": "^[0-9]", "bEscapeRegex": false}],//给每个列单独定义其初始化搜索列表特性（这一块还没搞懂）
		                //"sPaginationType":"full_numbers",
						"fnServerData" : function(sSource, aoData, fnCallback) {
							$.ajax({
								"dataType" : 'json',
								//"async":false,//如果为false的话，只有火狐才能显示效果，改为true全部都可以显示
								"type" : "POST",
								"url" : sSource,
								"contentType":"application/json",
								"data" : JSON.stringify(aoData),
								"success" : fnCallback
							});
						},
						"bDeferRender" : true,// 是否延迟渲染，当用Ajax或者js方式加载数据时开启延迟渲染会带来很大的速度提升，当该属性设置为true时，表格每一行新增的元素只有在需要被画出来时才会被DataTable创建出来。默认值：False
						"bDestory" : true,
						"columns" : [ {
							"data" : "bookDate"
						}, {
							"data" : "bookTimestamp"
						}, {
							"data" : "bookUserJobno"
						}, {
							"data" : "bookTimes"
						}, {
							"data" : "bookSumm"
						}, {
							"data": null,"width":"120px"
						} ],
						"columnDefs": [{
				            "targets": -1,//del
				            "data": null,
				            "bSortable": false,
				            "defaultContent": "<button id='edit' class='btn btn-primary' type='button'>编辑</button>" +
				            "<button id='del' class='btn btn-primary' type='button'>删除</button>"
				        }, {
				            "targets": 0,//hide one cell
				            "visible": true,
				            "searchable": true
				        }],
				        
				        /* "oLanguage":{  //自定义语言设置 
				            "oAria":{  
				                "sSortAscending": " - click/return to sort ascending",//默认值为activate to sort column ascending 当一列被按照升序排序的时候添加到表头的ARIA标签，注意列头是这个字符串的前缀（？） 
				                "sSortDescending": " - click/return to sort descending"  //默认值为activate to sort column ascending 当一列被按照升序降序的时候添加到表头的ARIA标签，注意列头是这个字符串的前缀（？） 
				            },  
				            "oPaginate": {  
				                "sFirst": "First page",  //默认值为First 当使用全数字类型的分页组件的时候，到第一页按钮上的文字
				                "sLast": "Last page", //默认值为Last 当使用全数字类型的分页组件的时候，到最后一页按钮上的文字 
				                "sNext": "Next page",//默认值为Next  当使用全数字类型的分页组件的时候，到下一页按钮上的文字 
				                "sPrevious": "Previous page"  //默认值为Previous 当使用全数字类型的分页组件的时候，到前一页按钮上的文字 
				            },   
				            //默认值activate to sort column ascending为 
				            //当表格中没有数据（无视因为过滤导致的没有数据）时，该字符串年优先与sZeroRecords显示 
				            //注意这是个可选参数，如果没有指定，sZeroRecrods会被使用（既不是默认值也不是给定的值） 
				            "sEmptyTable": "No data available in table",  
				            //默认值为Showing _START_ to _END_ of _TOTAL_ entries  
				            //该属性给终端用户提供当前页面的展示信息，字符串中的变量会随着表格的更新被动态替换，而且可以被任意移动和删除 
				            "sInfo": "Got a total of _TOTAL_ entries to show (_START_ to _END_)",  
				            //默认值为Showing 0 to 0 of 0 entries  
				            //当表格中没有数据时展示的表格信息，通常情况下格式会符合sInfo的格式 
				            "sInfoEmpty": "No entries to show",  
				            //默认值为(filtered from _MAX_ total entries)  
				            //当用户过滤表格中的信息的时候，该字符串会被附加到信息字符串的后面，从而给出过滤器强度的直观概念 
				            "sInfoFiltered": " - filtering from _MAX_ records",  
				            //默认值为空字符串 
				            //使用该属性可以很方便的向表格信息字符串中添加额外的信息，被添加的信息在任何时候都会被附加到表格信息组件的后面 
				            //sInfoEmpty和sInfoFiltered可以以任何被使用的方式进行结合 
				            "sInfoPostFix": "All records shown are derived from real information.",  
				            //默认值为‘,‘ 
				            //DataTable有内建的格式化数字的工具，可以用来格式化表格信息中较大的数字 
				            //默认情况下会自动调用，可以使用该选项来自定义分割的字符  
				            "sInfoThousands": "‘",  
				            //默认值为Show _MENU_ entries  
				            //描述当分页组件的下拉菜单的选项被改变的时候发生的动作，‘_MENU_‘变量会被替换为默认的10，25，50，100 
				            //如果需要的话可以被自定义的下拉组件替换 
				            "sLengthMenu": "Display _MENU_ records",  
				            //默认值为Loading... 
				            //当使用Ajax数据源和表格在第一次被加载搜集数据的时候显示的字符串，该信息在一个空行显示 
				            //向终端用户指明数据正在被加载，注意该参数在从服务器加载的时候无效，只有Ajax和客户端处理的时候有效 
				            "sLoadingRecords": "Please wait - loading...",  
				            //默认值为Processing... 
				            //当表格处理用户动作（例如排序或者类似行为）的时候显示的字符串 
				            "sProcessing": "DataTables is currently busy",  
				            //默认为Search: 
				            //描述用户在输入框输入过滤条件时的动作，变量‘_INPUT_‘,如果用在字符串中 
				            //DataTable会使用用户输入的过滤条件替换_INPUT_为HTML文本组件，从而可以支配它（即用户输入的过滤条件）出现在信息字符串中的位置  
				            //如果变量没有指定，用户输入会自动添加到字符串后面 
				            "sSearch": "Apply filter _INPUT_ to table",  
				            //默认值为空字符串，即：无效 
				            //所有语言信息可以被存储在服务器端的文件中，DataTable可以根据该参数指定的URL去寻找 
				            //必须保存语言文件的URL信息，必须是JSON格式，对象和初始化中使用的oLanguage对象具有相同的属性 
				            //请参考示例文件来了解该参数是如何工作的 
				            "sUrl": "http://www.sprymedia.co.uk/dataTables/lang.txt",  
				            //默认值为No matching records found 
				            //当对数据进行过滤操作后，如果没有要显示的数据，会在表格记录中显示该字符串 
				            //sEmptyTable只在表格中没有数据的时候显示，忽略过滤操作 
				            "sZeroRecords": "No records to display"  
				         } */
					});
				});
		});
	</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:45 GMT -->
</html>