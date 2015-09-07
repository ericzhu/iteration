DROP DATABASE IF EXISTS ecomv1;
CREATE DATABASE ecomv1;
use ecomv1;

DROP TABLE IF EXISTS category;
CREATE TABLE category (
	id bigint not null auto_increment,
	version bigint(20) NOT NULL,
	create_date datetime not null, 
	update_date datetime not null, 
	sort_order integer, 
	grade integer not null, 
	name varchar(255) not null, 
	seo_description varchar(255), 
	seo_keywords varchar(255), 
	seo_title varchar(255), 
	tree_path varchar(255) not null, 
	parent_id bigint,
	KEY FK_parent_category (parent_id),
  	CONSTRAINT FK_parent_category FOREIGN KEY (parent_id) REFERENCES category (id),
	primary key (id)) 
	ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS brand;
CREATE TABLE brand (
	id bigint not null auto_increment,
	version bigint(20) NOT NULL,
	create_date datetime not null, 
	update_date datetime not null, 
	sort_order integer, 
	introduction longtext, 
	logo varchar(255), 
	name varchar(255) not null, 
	type integer not null, 
	url varchar(255), 
	primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS promotion;
CREATE TABLE promotion (
	id bigint not null auto_increment,
	version bigint(20) NOT NULL,
	create_date datetime not null, 
	update_date datetime not null, 
	sort_order integer, 
	begin_date datetime, 
	end_date datetime, 
	introduction longtext, 
	is_coupon_allowed bit not null, 
	is_free_shipping bit not null, 
	maximum_price decimal(21,6), 
	maximum_quantity integer, 
	minimum_price decimal(21,6), 
	minimum_quantity integer, 
	name varchar(255) not null, 
	point_expression varchar(255), 
	price_expression varchar(255), 
	title varchar(255) not null, 
	primary key (id)) 
	ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS category_brand;
CREATE TABLE category_brand (
	category_id bigint not null, 
	brand_id bigint not null,
  	CONSTRAINT FK_category_brand_category FOREIGN KEY (category_id) REFERENCES category (id),
  	CONSTRAINT FK_category_brand_brand FOREIGN KEY (brand_id) REFERENCES brand (id),
	primary key (category_id, brand_id)) 
	ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS category_promotion;
CREATE TABLE category_promotion (
	category_id bigint not null, 
	promotion_id bigint not null, 
  	CONSTRAINT FK_category_promotion_category FOREIGN KEY (category_id) REFERENCES category (id),
  	CONSTRAINT FK_category_promotion_promotion FOREIGN KEY (promotion_id) REFERENCES promotion (id),
	primary key (category_id, promotion_id)) 
	ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(1, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 0, '时尚女装', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(2, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 0, '精品男装', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(3, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 0, '精致内衣', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(4, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 0, '服饰配件', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(5, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, 0, '时尚女鞋', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(6, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, 0, '流行男鞋', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(7, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, 0, '潮流女包', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(8, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, 0, '精品男包', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(9, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 9, 0, '童装童鞋', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(10, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 10, 0, '时尚饰品', NULL, NULL, NULL, ',', NULL);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(11, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '连衣裙', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(12, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '针织衫', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(13, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '短外套', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(14, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '小西装', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(15, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, 1, '牛仔裤', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(16, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, 1, 'T恤', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(17, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, 1, '衬衫', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(18, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, 1, '风衣', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(19, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 9, 1, '卫衣', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(20, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 10, 1, '裤子', NULL, NULL, NULL, ',1,', 1);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(21, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '针织衫', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(22, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, 'POLO衫', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(23, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '休闲裤', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(24, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '牛仔裤', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(25, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, 1, 'T恤', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(26, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, 1, '衬衫', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(27, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, 1, '西服', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(28, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, 1, '西裤', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(29, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 9, 1, '风衣', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(30, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 10, 1, '卫衣', NULL, NULL, NULL, ',2,', 2);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(31, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '女式内裤', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(32, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '男式内裤', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(33, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '保暖内衣', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(34, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '塑身衣', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(35, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, 1, '连裤袜', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(36, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, 1, '打底袜', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(37, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, 1, '文胸', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(38, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, 1, '睡衣', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(39, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 9, 1, '泳装', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(40, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 10, 1, '浴袍', NULL, NULL, NULL, ',3,', 3);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(41, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '女士腰带', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(42, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '男士皮带', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(43, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '女士围巾', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(44, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '男士围巾', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(45, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, 1, '帽子', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(46, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, 1, '手套', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(47, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, 1, '领带', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(48, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, 1, '领结', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(49, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 9, 1, '发饰', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(50, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 10, 1, '袖扣', NULL, NULL, NULL, ',4,', 4);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(51, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '高帮鞋', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(52, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '雪地靴', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(53, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '中筒靴', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(54, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '单鞋', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(55, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, 1, '凉鞋', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(56, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, 1, '靴子', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(57, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, 1, '短靴', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(58, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, 1, '雨靴', NULL, NULL, NULL, ',5,', 5);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(59, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '低帮鞋', NULL, NULL, NULL, ',6,', 6);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(60, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '高帮鞋', NULL, NULL, NULL, ',6,', 6);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(61, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '休闲鞋', NULL, NULL, NULL, ',6,', 6);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(62, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '正装鞋', NULL, NULL, NULL, ',6,', 6);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(63, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '单肩包', NULL, NULL, NULL, ',7,', 7);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(64, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '双肩包', NULL, NULL, NULL, ',7,', 7);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(65, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '手提包', NULL, NULL, NULL, ',7,', 7);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(66, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '手拿包', NULL, NULL, NULL, ',7,', 7);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(67, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '单肩男', NULL, NULL, NULL, ',8,', 8);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(68, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '双肩包', NULL, NULL, NULL, ',8,', 8);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(69, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '手提包', NULL, NULL, NULL, ',8,', 8);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(70, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '手拿包', NULL, NULL, NULL, ',8,', 8);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(71, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '运动鞋', NULL, NULL, NULL, ',9,', 9);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(72, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '牛仔裤', NULL, NULL, NULL, ',9,', 9);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(73, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '套装', NULL, NULL, NULL, ',9,', 9);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(74, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '裤子', NULL, NULL, NULL, ',9,', 9);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(75, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, 1, '项链', NULL, NULL, NULL, ',10,', 10);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(76, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, 1, '手链', NULL, NULL, NULL, ',10,', 10);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(77, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, 1, '戒指', NULL, NULL, NULL, ',10,', 10);
insert category (id, version, create_date, update_date, sort_order, grade, name, seo_description, seo_keywords, seo_title, tree_path, parent_id) values(78, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, 1, '耳饰', NULL, NULL, NULL, ',10,', 10);


insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(1, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, '<img src="${demoImageUrl}/201301/32937deb-f9c7-4baf-87ec-9d7c140e6f56.jpg" />', '${demoImageUrl}/brand/vimly.gif', '梵希蔓', 1, NULL);
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(2, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, '<img src="${demoImageUrl}/201301/4a43f5da-bd99-4e73-8a45-c3cf97df5bc1.jpg" />', '${demoImageUrl}/brand/eifini.gif', '伊芙丽', 1, 'http://www.eifini.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(3, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 3, '<img src="${demoImageUrl}/201301/393335cd-fa85-4697-9a35-be7920533923.jpg" />', '${demoImageUrl}/brand/sentubila.gif', '尚都比拉', 1, 'http://www.shangdubila.net');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(4, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 4, '森马，国内休闲服行业迅速崛起的领军品牌。森马集团有限公司以“创大众服饰名牌”为发展宗旨，积极推行特许经营发展模式，休闲装和童装品牌连锁网点遍布全国二十九个省、市、自治区、直辖市，形成了完整的市场网络格局。集团公司现有休闲装 “semir”及童装“balabala”等两个知名服装品牌。森马集团有限公司于1996年12月18日创立于浙江省温州市，是一家以虚拟经营模式为特色，以系列休闲服饰为主导产业的无区域集团。公司注册资本为人民币2.38亿元，总资产达10多亿元，是温州市大企业大集团之一。', '${demoImageUrl}/brand/semir.gif', '森马', 1, 'http://www.semir.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(5, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 5, '<img src="${demoImageUrl}/201301/84a3cc7a-c43b-4efc-8ed1-ba104cfb9a62.jpg" />', '${demoImageUrl}/brand/yishion.gif', '以纯', 1, 'http://www.yishion.com.cn');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(6, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 6, '李宁公司是中国家喻户晓的“体操王子”李宁先生在1990年创立的体育用品公司。经过二十多年的探索，李宁公司已逐步成为代表中国的、国际领先的运动品牌公司。从成立初期率先在全国建立特许专卖营销体系到持续多年赞助中国体育代表团参加国内外各种赛事；从成为国内第一家实施ERP的体育用品企业到不断进行品牌定位的调整，再到2004年6月在香港的上市，李宁公司经历了中国民族企业的发展与繁荣。<br />\r\n李宁公司拥有品牌营销、研发、设计、制造、经销及零售能力，产品主要包括自有李宁品牌生产的运动及休闲鞋类、服装、器材和配件产品。主要采用外包生产和特许分销商模式，在中国已经建立庞大的供应链管理体系以及分销和零售网络，截止2011年末，李宁品牌店铺在中国境内总数达到8255间，并且在东南亚、中亚、欧洲等地区开拓业务。<br />\r\n李宁公司还采取多品牌业务发展的策略，在聚焦自有核心李宁品牌的同时，还(i)与Aigle International S.A成立合资经营，并获授予专营权在中国生产、推广、分销及销售法国AIGLE（艾高）品牌户外运动用品；(ii)透过附属公司从事生产、研发、推广及销售红双喜品牌乒乓球及其它体育器材；(iii)获Lotto Sport Italia S.p.A旗下公司授予独家特许权，在中国开发、制造、推广、分销及销售意大利运动时尚Lotto（乐途）品牌特许产品；及(iv)从事Kason（凯胜）品牌羽毛球专业产品的研发、制造及销售。<br />\r\n创新是李宁品牌发展的根本。李宁公司自成立之初就非常重视原创设计。1998年建立了中国第一家服装与鞋产品设计开发中心，率先成为自主开发的中国体育用品公司。2004年8月，香港设计研发中心成立，集中负责设计李宁品牌服装产品。并且与国内外各大知名高校和研究机构保持密切合作。<br />', '${demoImageUrl}/brand/lining.gif', '李宁', 1, 'http://www.li-ning.com.cn');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(7, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 7, '耐克是全球著名的体育用品制造商，总部位于美国俄勒冈州，生产的体育用品包罗万象：服装、鞋类、运动器材等。<br />\r\n耐克一直将激励全世界的每一位运动员并为其献上最好的产品视为光荣的任务。耐克的语言就是运动的语言。耐克公司投入了大量的人力、物力用于新产品的开发和研制。耐克首创的气垫技术给体育界带来了一场革命。运用这项技术制造出的运动鞋可以很好地保护运动员的脚踝，防止其在作剧烈运动时扭伤。<br />\r\n耐克 (Nike) 被誉为是“近20年世界新创建的最成功的消费品公司”。耐克 (Nike) 运动鞋除了强化高科技运动性能，如今更讲究时尚的外形设计，频频与各国各界潮流达人合作推出联名限量版。2009年初陈冠希的Clot品牌与耐克 (Nike) 的联名新款红色中国鞋 Clot×Nike AIR FORCE 1 在上海一上市，即成为疯抢对象。在美国，有高达七成的青少年的梦想是有一双耐克 (Nike) 鞋。<br />', '${demoImageUrl}/brand/nike.gif', '耐克', 1, 'http://www.nike.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(8, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 8, '阿迪达斯的目标是协调与员工的私人和家庭需要的阿迪达斯集团的商业利益。提出工作与生活平衡方案：面向家庭的服务，灵活的工作时间和地点，人的发展和领导能力相关的工作与生活的平衡。<br />\r\n阿迪达斯目前分为三个系列，分别为：运动表现系列（三条纹LOGO）、运动传统系列（三叶草LOGO)、运动时尚系列(球状内含三条纹LOGO)。<br />\r\n运动表现系列专门致力于大众体育运动事业，其定位是大众化的运动风潮，采用阿迪三条纹LOGO，价格较易大众所接受。<br />\r\n运动传统系列是阿迪达斯的经典系列，其定位是复古经典风潮，较之运动表现系列更为时尚、高端一些。运动传统系列采用阿迪三叶草LOGO（也是阿迪较早之前的LOGO），因该系列推出的多为限量产品所以价格较易为中高收入人群所接受。<br />', '${demoImageUrl}/brand/adidas.gif', '阿迪达斯', 1, 'http://www.adidas.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(9, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 9, 'Jack &amp; Jones是针对年龄在18岁到30岁之间的喜欢穿着随意、流行和时尚的男士们设计的。Jack &amp; Jones的设计迎合了国际大都市男士的生活品位，他们喜欢一种独特、轮廓鲜明而朴实的风格，同时采用高品质、时兴和新颖的面料制作的服装。<br />\r\nJack &amp; Jones品牌诞生于1975年，以其简洁纯粹的风格吸引全球追求时尚男性的目光，代表了欧洲时尚潮流的男装品牌，同时也是都市风格服装的典范品牌。<br />\r\nJack &amp; Jones是时尚男装里非常流行的品牌，与女装的ONLY、VERO MODA和男装SELECTED同属丹麦的BESTSELLER公司。他们经营各种男装，有休闲，正装等，还有各种配饰。<br />\r\n杰克琼斯(Jack &amp; Jones) 男装是设计给机敏，明智，受过良好教育，热衷社会活动的都市轻熟男。穿着杰克琼斯(Jack &amp; Jones) 的男人是对现代服装有着自己独特的感受，同时关注国际时装市场趋势的现代人。<br />', '${demoImageUrl}/brand/jackjones.gif', 'Jack Jones', 1, 'http://www.jackjones.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(10, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 10, '七匹狼男装是中国男装行业开创性品牌，始终致力于为消费者提供满足现代多元化生活需求的高品质服装产品。“男人不只一面”，七匹狼以“品格男装”突显国际化品质和中西兼容的文化格调，以时尚传承经典，以中国面向世界。', '${demoImageUrl}/brand/septwolves.gif', '七匹狼', 1, 'http://www.septwolves.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(11, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 11, '恒源祥，创立于1927年的中国上海，产品涵盖绒线、针织、服饰、家纺等大类，绒线、羊毛衫综合销量常年保持同行业第一。<br />\r\n恒源祥既是中国进入市场经济后最早实施品牌运营的企业（1991年），又是中国最早进行特许经营的企业（1999年）。目前拥有98家加盟工厂，400多家加盟销售商、分销商以及5000多个加盟销售网点。中国省级市场销售网点涵盖率为100%，地、市级市场网点覆盖率超过90%，县级市场网点覆盖率超过60%。<br />\r\n品牌经营20年以来，恒源祥品牌获得了巨大的发展，品牌的价值得到了显著的提升。1999年，恒源祥获得“中国驰名商标”称号；2006年，在中国最有价值的100个老字号中，恒源祥位居第二；同年，恒源祥荣膺行业首家全国质量奖；2007年，由世界品牌实验室发布的中国500最具价值品牌排行榜中，恒源祥位列64位，品牌价值94.58亿元；2008年，恒源祥进入“亚洲品牌500强”，位列336位；2010年恒源祥再次入选《亚洲品牌500强》，排名跃升为203位。恒源祥集团做了大量的社会责任工作，所有的活动都是围绕着我们是国家的一员、我们是社会的一员，为社会创造价值为基本出发点，是恒源祥集团勇于承担社会责任的具体表现。未来，我们还将坚定不移地践行使命、精神、价值观，勇于承担社会责任，向成为历史的一部分的目的而持续奋斗。<br />', '${demoImageUrl}/brand/hengyuanxiang.gif', '恒源祥', 1, 'http://www.g8888.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(12, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 12, '圣得西（集团）有限公司始创于1989年，公司主要从事西服、西裤、休闲上衣、茄克、T恤、休闲裤、毛衫、衬衣、皮具等男士正装和商务休闲系列化产品的开发、生产和销售，目前拥有“圣得西”、“圣奥威斯”等品牌。公司先后在巴黎、上海建立研发设计中心，引进意大利、日本、德国等国家20余条顶级生产线，聚结世界前沿的服装技术，为中国男士量身打造优雅、舒展的圣得西。历年来，圣得西以其款式新颖、面料精美、工艺精湛而著称，是目前国内高级男士正装和休闲装的代表。', '${demoImageUrl}/brand/sundance.gif', '圣得西', 1, 'http://www.sundance.com.cn');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(13, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 13, '品牌介绍：	猫人集团旗下成熟女性内衣品牌，其前身是以"Maoren"为英文名称的猫人品牌。"猫人经典"融合猫人品牌与产品十年历炼精髓，以成熟、品位、性感、经典传承为核心设计风格， 针对35-45岁女性人群身理特点，主力开发高端暖衣、调整型塑身内衣产品，致力于提升都市成熟女性的高品质生活。<br />\r\n品牌定位：	成熟、品位、经典、性感<br />\r\n目标人群：	35-45岁为主的都市成熟女性。成熟、自信，有较好的经济基础，追求高品质生活。在生命的成熟阶段，准备释放全部的魅力，捍卫自己的家庭、事业以及对青春的美好留念。<br />', '${demoImageUrl}/brand/maoren.gif', '猫人', 1, 'http://www.maoren.net');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(14, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 14, '"北极绒"属上海赛洋集团旗下品牌，诞生于1998年，是中国最早的保暖内衣龙头品牌之一。产品一经问世，依靠先进的科技理念、优良的品质、大众化消费，以一骑绝尘之势迅速占领市场。赵本山代言广告语"怕冷就穿北极绒，地球人都知道"，更是迅速传遍全国各地、街头巷尾，成为人们茶余饭后的谈资。北极绒也借此迅速蹿升为中国保暖内衣行业的重要领导品牌之一。<br />\r\n"千淘万漉虽辛苦，吹尽黄沙始到金"。十四年，梦想引领北极绒一直向前，在前进的道路上，北极绒不断实施产品创新改革、营销模式改革。目前，其发展已经涵盖内衣、家纺、男装三大类共计几千个品类，销售渠道网络覆盖全国28个省、市、自治区6000多个终端，产品品质和声誉赢得了消费者的一致认可。十四年发展历程中，北极绒先后荣获"中国驰名商标"、"国家免检产品"、"2007—2011年中国最具价值500强品牌"、"2001-2010年连续十年全国同类产品销量第一"、"中国内衣十大影响力品牌"、"中国保暖内衣十强品牌"、"生态纺织品认证"、"保暖内衣国家标准主要起草单位"、"中国针织工业协会标准保温率唯一认证"等累累殊荣，以唯一持续十四年长青、十四年辉煌的业绩，成为内衣行业无可争议的领袖品牌。目前，北极绒的品牌价值被世界品牌实验室评估为47.35亿元人民币。北极绒公司拥有20多项专利和5000多家由各级代理商组成的庞大完善的销售网络，产品覆盖除港澳台外的全国所有省、市、自治区，截止目前，仅保暖内衣一个品类就创造了累计销售近4000万套的经营神话，被誉为中国保暖内衣的领袖企业。<br />\r\n2008年开始，公司秉承"合作•分享•共赢"的价值观，进行多方位资源整合，实施品牌联合大发展。"百年梦圆，大国崛起"，北极绒正以领袖风范，高扛民族大旗，引领中国纺织服装企业走向国际舞台，立于世界品牌之林！<br />', '${demoImageUrl}/brand/beijirong.gif', '北极绒', 1, 'http://www.beijirong.com.cn');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(15, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 15, '美特斯邦威是周成建创立于温州的一家民营企业，1995年4月22日温州解放剧院第一家专卖店的开业标志着“美特斯邦威”品牌的正式面世。创牌以来，企业坚持走品牌连锁经营的可持续发展道路，在国内服装行业率先采取“虚拟经营”的业务模式，依靠品牌营销、设计、信息化和人才队伍建设在激烈的市场竞争中形成了自己的核心竞争力，获得了令世人瞩目的成就。2004 年，“美特斯邦威 ”全系统销售额突破了25亿元。截止2005年11月30日，集团在中国已拥有上海、温州、北京、杭州、重庆、成都、广州、沈阳、西安 、天津、济南十一家分公司，近1500家加盟和直营店铺（其中面积超过500平米的旗舰店有15家），公司直营体系员工达到了4000多人，全系统员工超过了数万人，成为中国休闲服饰行业的龙头企业之一。', '${demoImageUrl}/brand/metersbonwe.gif', '美特斯·邦威', 1, 'http://www.metersbonwe.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(16, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 16, '1993年，真维斯进军中国内地市场，在上海开设了第一间JEANSWEST真维斯专卖店。多年来，真维斯以“名牌大众化”的经营理念，“物超所值”的市场策略，稳占休闲装市场的领袖地位。现今，真维斯已在国内20多个省市开设了2000多间专卖店，拥有现时中国最大的休闲服饰销售网络。&nbsp;<br />\r\n<br />\r\n真维斯的经营理念是“名牌大众化”——少数人拥有的物品，令大众都能拥有；市场策略是“物超所值”——高价值的物品，低价钱销售。<br />\r\n真维斯服装是为广大年轻人设计的，将每季最新的潮流元素融入服装当中，以易穿易搭配的款式来吸引顾客。多年来，真维斯以大众潮流的休闲风格，深受年轻人的喜爱，已经成为年轻一代的时尚必需品。<br />\r\n<br />\r\n真维斯为了维护和加强品牌的形象，从连锁店铺的购物环境、店内布置、商品陈列、耐心的微笑服务、全面到位的售后服务、营业员的招聘选拔和工作培训及指导等方面入手，提升服务水平。<br />\r\n<br />\r\n“穷则独善其身，达则兼善天下”是真维斯企业文化的体现。目前在国内贫困地区以真维斯命名的希望小学共有36间。2008年真维斯为“希望小学快乐运动会”捐助130多万元。同年，捐资220万修建55个贫困小学操场为贫困小学建设贡献力量。此外，真维斯还分别斥资2700万元和600万元，设立了“真维斯大学生助学基金”和“真维斯希望教师基金”，为教育事业出一份力。面对灾情时，真维斯向四川汶川和青海玉树共计捐出超过1000万元人民币的善款。并通过举办“大爱中华行——真维斯·真的更精彩”慈善歌会行动，将慈善与娱乐相结合，呼吁更多年轻人关注慈善、奉献爱心。同时真维斯还通过开展“中国真维斯杯休闲装设计大赛”这一活动，给年轻人提供一个展示潜能、相互交流的平台。以体现社会价值为核心的品牌理念已深深牵动每一位真维斯顾客。<br />\r\n<br />\r\n“真维斯”是一个年轻﹑健康﹑向上的服饰品牌。“真维斯”倡导一种真诚﹑乐观的生活态度。真维斯为渴望被关注﹑被认可的年轻人打造最真的生活态度。做回真我，穿回真我，分享真我。 “真的·更精彩” 真维斯！<br />', '${demoImageUrl}/brand/jeanswest.gif', '真维斯', 1, 'http://www.jeanswest.com');
insert into brand (id, version, create_date, update_date, sort_order, introduction, logo, name, type, url) values(17, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 17, '唐狮“TONLION”直属于宁波博洋服饰有限公司，成立于1994年，以经营男女大众休闲服饰为主。10多年来，“唐狮”服饰长期坚持不断改善产品品质和提供专业优质的服务造福大众。<br />\r\n唐狮坚持“我有我的方式”的品牌信念，为中国的年轻潮人度身打造专属于他们的服饰品牌。2005年以来，连续三年被世界品牌实验室评定为“中国500最具价值品牌”，品牌价值31.92亿元；之后，唐狮又接连尽揽“中国驰名商标”、“中国青年最喜爱的休闲服饰品牌”、“中国服饰品牌年度大奖”等多项傲人荣誉于一身。<br />\r\n2009年初，唐狮顺应潮流，快人一步加入电子商务市场，不仅为品牌成功打开“网销化”布局的第一步，更为热火朝天的网购服装市场添了一笔佳绩。09年底便成功挤入淘宝商城男装分类销量前三名，至今一直保持领先。<br />\r\n2011年，唐狮的目标是突玻2个亿，全方位的打造电子商务第一品牌。在原有淘宝平台的基础上，又积极将营销领域延伸到拍拍、京东、趣点等国内其它网销平台，力求多方面、多层次的发展。通过各平台不同的营销模式，不同的销售群体，在反复的对比中，唐狮积累到更多关于电子商务的宝贵经验，为今后平台的不断完善和壮大，莫定了坚实的基础。<br />\r\n从曾经的服饰品牌新人王，到今天的潮流品牌星势力。每一天，唐狮都在飞速成长，每一年，唐狮都在撰写全新的篇章。唐潮盛狮崛起，辉煌未完待续。<br />', '${demoImageUrl}/brand/tonlion.gif', '唐狮', 1, 'http://www.tonlion.com');

insert into promotion (id, version, create_date, update_date, sort_order, begin_date, end_date, introduction, is_coupon_allowed, is_free_shipping, maximum_price, maximum_quantity, minimum_price, minimum_quantity, name, point_expression, price_expression, title) values(1, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1, NOW(), '2015-01-01 00:00:00', '<p>\r\n	活动内容：订单商品金额满300元立减10元\r\n</p>\r\n<p>\r\n	参与商品分类：连衣裙、针织衫\r\n</p>\r\n<p>\r\n	说明：参与该活动商品不允许使用优惠券\r\n</p>', 0, 0, NULL, NULL, NULL, NULL, '限时抢购', NULL, 'price * 0.9', '限时抢购');
insert into promotion (id, version, create_date, update_date, sort_order, begin_date, end_date, introduction, is_coupon_allowed, is_free_shipping, maximum_price, maximum_quantity, minimum_price, minimum_quantity, name, point_expression, price_expression, title) values(2, 0, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 2, NULL, NULL, '<p>\r\n	<span style="white-space:normal;">活动内容：</span>订单商品价格满200元赠送双倍<span style="white-space:normal;">积分</span> \r\n</p>\r\n<p>\r\n	<span style="white-space:normal;">参与商品分类：服饰配件、小西装</span> \r\n</p>', 0, 0, NULL, NULL, NULL, NULL, '双倍积分', 'point * 2', NULL, '双倍积分');

