
use cardmanage;

CREATE TABLE `tb_card` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `card_name` varchar(32) DEFAULT NULL COMMENT '卡名',
  `card_number` varchar(20) DEFAULT NULL COMMENT '卡号',
  `quota` decimal(10,2) DEFAULT NULL COMMENT '总额度',
  `already_quota` decimal(10,2) DEFAULT NULL COMMENT '已用额度',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '0：未删除； 1：已删除',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `sex` tinyint(1) DEFAULT '1' COMMENT '性别：1男，2女',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '0：未删除； 1：已删除',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

commit;
