/*setは更新処理*/
set names utf8;
/*外部キー規約違反
1. 存在しない値の外部キーは登録できない
2. 親テーブルに外部キーが登録されている子テーブルのリソースは削除できない
を防ぐため*/
set foreign_key_checks=0;
drop database if exists ecsite2;

create database if not exists ecsite2;
use ecsite2;

/*transition=推移*/
drop table if exists login_user_transaction;

create table login_user_transaction(
/*increment=増加*/
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
update_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("ノートBook", 500000, 5);

INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");