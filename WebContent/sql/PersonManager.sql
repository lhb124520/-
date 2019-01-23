-- 建数据库
create database PersonManager character set 'utf8';

use PersonManager;

-- 员工表

CREATE TABLE employee (
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `em_name` varchar(10) DEFAULT NULL,
  `em_sex` varchar(2) DEFAULT NULL,
  `em_departmentId` int(11) DEFAULT NULL,
  `em_typeWork` varchar(10) DEFAULT NULL,
  `em_culture` varchar(10) DEFAULT NULL,  
  `em_creatime` varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  foreign key (em_departmentId) REFERENCES employee(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert  into employee(`id`,`em_name`,`em_sex`,`em_departmentId`,`em_typeWork`,`em_culture`,`em_creatime`) values (1,'刘红','女',1,'程序员','研究生','2016-12-12');



-- 部门表
CREATE TABLE department (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt_name` varchar(10) DEFAULT NULL,
  `dt_createTime` varchar(20) DEFAULT NULL,
  `dt_bz` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert  into department(`id`,`dt_name`,`dt_createTime`,`dt_bz`) values (1,'Java WEB','2007-11-21','负责JSP网页');

-- 管理员
CREATE TABLE manager (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert  into manager(`id`,`account`,`password`) values (1,'张三','111');