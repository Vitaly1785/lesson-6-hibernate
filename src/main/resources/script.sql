CREATE TABLE web_shop.person (id serial, first_name varchar(128), last_name varchar(128), PRIMARY KEY (id));


CREATE TABLE web_shop.product (id serial, title varchar(128), price int(128), PRIMARY KEY (id));


CREATE TABLE web_shop.person_product (product_id integer REFERENCES product (id), person_id integer REFERENCES person (id));

INSERT INTO `web_shop`.`person` (`first_name`, `last_name`) VALUES ('John', 'Simons');

INSERT INTO `web_shop`.`person` (`first_name`, `last_name`) VALUES ('William', 'Rabbit');

INSERT INTO `web_shop`.`person` (`first_name`, `last_name`) VALUES ('Jack', 'Daniels');

INSERT INTO `web_shop`.`person` (`first_name`, `last_name`) VALUES ('Chakky', 'Lucky');

INSERT INTO `web_shop`.`person` (`first_name`, `last_name`) VALUES ('Rob', 'Potatos');

INSERT INTO `web_shop`.`product` (`title`, `price`) VALUES ('Sugar', '10');

INSERT INTO `web_shop`.`product` (`title`, `price`) VALUES ('Cucumber', '5');

INSERT INTO `web_shop`.`product` (`title`, `price`) VALUES ('Tomato', '8');

INSERT INTO `web_shop`.`product` (`title`, `price`) VALUES ('Butter', '7');

INSERT INTO `web_shop`.`product` (`title`, `price`) VALUES ('Bread', '4');

insert into person_product(product_id, person_id) values('1', '1');
insert into person_product(product_id, person_id) values('2', '1');

insert into person_product(product_id, person_id) values('2', '3');

insert into person_product(product_id, person_id) values('3', '2');

insert into person_product(product_id, person_id) values('3', '4');

insert into person_product(product_id, person_id) values('3', '5');

insert into person_product(product_id, person_id) values('4', '1');

insert into person_product(product_id, person_id) values('4', '2');

insert into person_product(product_id, person_id) values('4', '4');

insert into person_product(product_id, person_id) values('5', '5');

insert into person_product(product_id, person_id) values('5', '3');