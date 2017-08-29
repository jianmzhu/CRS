drop table `t_user`;
#用户表
CREATE TABLE IF NOT EXISTS `t_user` (
`user_id`  int(16) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`user_name`  varchar(24) NOT  NULL COMMENT '用户名称' ,
`user_password`  varchar(32) NULL DEFAULT NULL COMMENT '用户密码' ,
`user_description`  text  NULL DEFAULT NULL COMMENT '用户备注' ,
`user_phone`  varchar(32) NOT NULL  COMMENT '用户手机号码' ,
`user_email`  varchar(32) NULL DEFAULT NULL COMMENT '用户邮箱号码' ,
`user_weixin`  varchar(32) NOT NULL COMMENT '用户微信号码' ,
`user_qq`  varchar(32) NULL DEFAULT NULL COMMENT '用户QQ号码' ,
`user_jobno`  varchar(32) NOT NULL  COMMENT '用户工号' ,
`user_post`  varchar(32) NULL DEFAULT NULL COMMENT '用户职位' ,
`create_time`  timestamp NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`status`  int(1) NOT NULL DEFAULT 1 COMMENT '是否可用 0-未激活不可用，1-已激活可用 默认1' ,
`is_lock`  int(1) NOT NULL DEFAULT 0 COMMENT '是否锁定 0-未锁定，1-已锁定 默认0' ,
PRIMARY KEY (`user_id`)
);
drop table `t_role`;
#权限表
CREATE TABLE IF NOT EXISTS `t_role` (
`role_id`  int(16) NOT NULL AUTO_INCREMENT COMMENT '权限岗位ID',
`role_name`  varchar(24) NOT  NULL COMMENT '权限岗位名称' ,
`role_type`  int(3) NOT  NULL  COMMENT '权限类型 0-匿名用户，1-普通用户，888-管理员，999-超级管理员' ,
`role_description`  text  NULL DEFAULT NULL COMMENT '权限岗位备注' ,
`create_time`  timestamp NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`status`  int(1) NOT NULL DEFAULT 1 COMMENT '是否可用 0-未激活不可用，1-已激活可用 默认1' ,
PRIMARY KEY (`role_id`)
);

drop table `t_user_role_relat`;
#用户、权限关联表
CREATE TABLE IF NOT EXISTS `t_user_role_relat` (
`user_id` int(16) NOT NULL COMMENT '用户ID',
`role_id`  int(16) NOT NULL COMMENT '权限岗位ID',
PRIMARY KEY (`user_id`,`role_id`)
);

drop table `t_notice`;
--公告表
CREATE TABLE IF NOT EXISTS `t_notice` (
`notice_id`  int(16) NOT NULL AUTO_INCREMENT COMMENT '通知ID',
`notice_name`  varchar(255)  NULL DEFAULT NULL COMMENT '通知标题' ,
`notice_description`  text  NULL DEFAULT NULL COMMENT '通知详细' ,
`notice_type`  varchar(255) NULL DEFAULT NULL COMMENT '类型' ,
`create_time`  timestamp NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`is_del`  int(1) NOT NULL DEFAULT 0 COMMENT '是否使用 0-未删除，1-已删除' ,
PRIMARY KEY (`notice_id`)
);


drop table `t_times_list`;
#时间段列表
CREATE TABLE IF NOT EXISTS `t_times_list` (
`times_id`  varchar(11) NOT NULL COMMENT '时间段id',
`times_name`  varchar(255) NOT NULL COMMENT '时间段名字' ,
`times_parent_id`  varchar(11) COMMENT '父级时间段id', 
`level_no` INT(2) NOT NULL COMMENT '级数',
PRIMARY KEY (`times_id`)
);
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('00:00-24:00','全天','','1');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('00:00-06:00','凌晨','00:00-24:00','2');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('06:00-12:00','上午','00:00-24:00','2');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('12:00-18:00','下午','00:00-24:00','2');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('18:00-24:00','夜间','00:00-24:00','2');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('00:00-01:00','零点','00:00-06:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('01:00-02:00','一点','00:00-06:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('02:00-03:00','两点','00:00-06:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('03:00-04:00','三点','00:00-06:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('04:00-05:00','四点','00:00-06:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('05:00-06:00','五点','00:00-06:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('06:00-07:00','六点','06:00-12:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('07:00-08:00','七点','06:00-12:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('08:00-09:00','八点','06:00-12:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('09:00-10:00','九点','06:00-12:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('10:00-11:00','十点','06:00-12:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('11:00-12:00','十一点','06:00-12:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('12:00-13:00','十二点','12:00-18:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('13:00-14:00','十三点','12:00-18:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('14:00-15:00','十四点','12:00-18:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('15:00-16:00','十五点','12:00-18:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('16:00-17:00','十六点','12:00-18:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('17:00-18:00','十七点','12:00-18:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('18:00-19:00','十八点','18:00-24:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('19:00-20:00','十九点','18:00-24:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('20:00-21:00','二十点','18:00-24:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('21:00-22:00','二十一点','18:00-24:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('22:00-23:00','二十二点','18:00-24:00','3');
insert into t_times_list (times_id,times_name,times_parent_id,level_no) values ('23:00-24:00','二十三点','18:00-24:00','3');

drop table `t_car`;
#车辆信息表
CREATE TABLE IF NOT EXISTS `t_car` (
`car_id`  int(16) NOT NULL AUTO_INCREMENT COMMENT '车辆ID',
`car_no`  varchar(16) NOT NULL COMMENT '车牌号码' ,
`car_diver_name`  varchar(16) NOT NULL COMMENT '司机名字' ,
`car_diver_phone`  varchar(16) COMMENT '司机电话' ,
`car_type` int(2) COMMENT '车型 0-小轿车；1-SUV；' ,
PRIMARY KEY (`car_id`)
);

insert into t_car (car_id,car_no,car_diver_name,car_diver_phone,car_type)
values (1,'测试车牌号xxxx','测试司机xxxx','15889924339',0);

drop table `t_book_car_dtl`;
#车辆申请预约信息表(显示用户约车记录数据)
CREATE TABLE IF NOT EXISTS `t_book_car_dtl` (
`book_id`  int(16) NOT NULL AUTO_INCREMENT COMMENT '预约流水号',
`car_id`  int(16) NOT NULL COMMENT '车辆ID',
`book_times`  varchar(512) NOT NULL COMMENT '预约车的时间段，用逗号做分隔符' ,
`book_user_jobno`  varchar(32) NOT NULL COMMENT '约车用户工号' ,
`book_summ`  varchar(1024) NOT NULL COMMENT '约车摘要备注' ,
`book_from`  varchar(256) NOT NULL COMMENT '约车起点' ,
`book_to`  varchar(256) NOT NULL COMMENT '约车目的地' ,
`check_user_jobno`  varchar(32) COMMENT '审核用户工号，如果审核通过或者审核不通过，该值不为空' ,
`check_flag` int(1) NOT NULL DEFAULT 0 COMMENT '0-未审核，1-审核通过，2-审核不通过' ,
PRIMARY KEY (`book_id`)
);

drop table `t_car_times_dtl`;
#车辆日程信息表(显示在首页日历栏上的查询数据，已审核通过)
CREATE TABLE IF NOT EXISTS `t_car_times_dtl` (
`car_id`  int(16) NOT NULL COMMENT '车辆ID',
`times_id`  varchar(11) NOT NULL COMMENT '时间段id,只能为三级的时间段id',
`book_id`  int(16) NOT NULL COMMENT '预约流水号',
`book_user_jobno`  varchar(32) NOT NULL COMMENT '约车用户工号' ,
`book_summ`  varchar(1024) NOT NULL COMMENT '约车摘要备注' ,
`book_from`  varchar(256) NOT NULL COMMENT '约车起点' ,
`book_to`  varchar(256) NOT NULL COMMENT '约车目的地' ,
`book_times`  varchar(512) NOT NULL COMMENT '预约车的时间段，用逗号做分隔符' ,
`check_user_jobno`  varchar(32) COMMENT '审核用户工号，如果审核通过或者审核不通过，该值不为空' ,
`check_flag` int(1) NOT NULL DEFAULT 2 COMMENT '0-未审核，1-审核通过，2-审核不通过' ,
PRIMARY KEY (`car_id`,`times_id`)
);