CREATE TABLE IF NOT EXISTS `notice` (
`notice_id`  int(16) NOT NULL AUTO_INCREMENT COMMENT '通知ID',
`notice_name`  varchar(255)  NULL DEFAULT NULL COMMENT '通知标题' ,
`notice_description`  text  NULL DEFAULT NULL COMMENT '通知详细' ,
`notice_type`  varchar(255) NULL DEFAULT NULL COMMENT '类型' ,
`create_time`  timestamp NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`is_del`  int(1) NOT NULL DEFAULT 0 COMMENT '是否使用 0-未删除，1-已删除' ,
PRIMARY KEY (`notice_id`)
);
