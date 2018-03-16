CREATE SCHEMA IF NOT EXISTS homeapp
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS stations (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  name    VARCHAR(100) NOT NULL,
  site_id INT          NOT NULL,
  type    VARCHAR(45)  NOT NULL,
  x       INT          NOT NULL,
  y       INT          NOT NULL
);


CREATE TABLE IF NOT EXISTS weather_locations
(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  place VARCHAR(256) NULL ,
  geo_name_id INT NOT NULL UNIQUE,
  population INT NULL ,
  latitude DOUBLE NOT NULL ,
  longitude DOUBLE NOT NULL ,
  municipality VARCHAR(256) NULL ,
  country varchar(256) NOT NULL ,
  district varchar(256) NULL,
  current BOOLEAN NOT NULL DEFAULT FALSE
);

