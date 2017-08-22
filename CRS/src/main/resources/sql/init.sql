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
