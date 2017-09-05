<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>车辆预约系统主页</title>

    <meta name="keywords" content="车辆预约系统">
    <meta name="description" content="车辆预约系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    
    <!-- 公共页面元素 -->
    <jsp:include page="../headPages/head_common.jsp" />
	<jsp:include page="../headPages/head_calendar_common.jsp" />
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInDown">
            <div class="col-lg-12 col-md-12 col-sm-12 col-sx-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>约车日程表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <!-- 日历不可以关闭，只可以收起，展开 -->
                            <!-- <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a> -->
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div id="calendar"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${mybasePath}/bootstrapUI/js/jquery.min.js?v=2.1.4"></script>
    <script src="${mybasePath}/bootstrapUI/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${mybasePath}/bootstrapUI/js/content.min.js?v=1.0.0"></script>
	<script src="${mybasePath}/bootstrapUI/js/jquery-ui.custom.min.js"></script>
	<script src="${mybasePath}/bootstrapUI/js/plugins/iCheck/icheck.min.js"></script>
	<script src="${mybasePath}/bootstrapUI/js/plugins/fullcalendar/fullcalendar.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green",
			});
			$("#external-events div.external-event").each(function() {
				var d = {
					title : $.trim($(this).text())
				};
				$(this).data("eventObject", d);
				$(this).draggable({
					zIndex : 999,
					revert : true,
					revertDuration : 0
				})
			});
			var b = new Date();
			var c = b.getDate();
			var a = b.getMonth();
			var e = b.getFullYear();
			$("#calendar").fullCalendar({
				header : {
					/* left : "prevYear,prev,next,nextYear", */
					left : "prev,next",
					center : "title",
					right : "month,agendaWeek,agendaDay"// /* ,basicWeek,basicDay */month（月视图），basicWeek（基本周视图，左侧不显示具体时间），basicDay（基本日视图，左侧不显示具体时间），agendaWeek（周视图），agendaDay（日视图）
				},
				theme : false,//是否允许使用jquery的ui主题，如果设置为true，则需要加载jquery ui相关css和js文件。
				buttonIcons : false,//设置header中使用的prev, next等变量对应按钮的样式，只有当theme为true时才有效，如果你调用了jQuery ui样式但又不想使用它的图标样式，可以将此属性设置为false
				/* firstDay:0, //设置一周中显示的第一天是哪天，周日是0，周一是1，类推。*/
				/* isRTL : true,//设置为ture时则日历从右往左显示，貌似是针对阿拉伯人设计的。 */
				/* editable : false,//日历设置为不可以编辑 */
				/* weekNumbers : true,//是否在日历中显示周次(一年中的第几周)，如果设置为true，则会在月视图的左侧、周视图和日视图的左上角显示周数。 */
				droppable : true,
				drop : function(g, h) {
					var f = $(this).data("eventObject");
					var d = $.extend({}, f);
					d.start = g;
					d.allDay = h;
					$("#calendar").fullCalendar("renderEvent", d, true);
					if ($("#drop-remove").is(":checked")) {
						$(this).remove()
					}
				},
				events: '${mybasePath}/calendarPage/getCalendarData', 
				/* events : [ {
					title : "日事件",
					start : new Date(e, a, 1)
				}, {
					title : "长事件",
					start : new Date(e, a, c - 5),
					end : new Date(e, a, c - 2),
				}, {
					id : 999,
					title : "重复事件",
					start : new Date(e, a, c - 3, 16, 0),
					allDay : false,
				}, {
					id : 999,
					title : "重复事件",
					start : new Date(e, a, c + 4, 16, 0),
					allDay : false
				}, {
					title : "会议",
					start : new Date(e, a, c, 10, 30),
					allDay : false
				}, {
					title : "午餐",
					start : new Date(e, a, c, 12, 0),
					end : new Date(e, a, c, 14, 0),
					allDay : false
				}, {
					title : "生日",
					start : new Date(e, a, c + 1, 19, 0),
					end : new Date(e, a, c + 1, 22, 30),
					allDay : false
				}, {
					title : "打开百度",
					start : new Date(e, a, 28),
					end : new Date(e, a, 29),
					url : "http://baidu.com/"
				} ], */
			})
		});
	</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:45 GMT -->
</html>