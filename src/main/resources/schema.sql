DROP DATABASE IF EXISTS localhost_db;

CREATE DATABASE localhost_db;

USE localhost_db;

CREATE TABLE IF NOT EXISTS products
(
  id            int auto_increment primary key,
  current_price double       null,
  last_update   bigint       null,
  name          varchar(255) null
);
