CREATE SCHEMA IF NOT EXISTS homeapp
  DEFAULT CHARACTER SET utf8;


CREATE TABLE IF NOT EXISTS stations
(
  id      INT AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(100) NOT NULL,
  site_id INT          NOT NULL,
  type    VARCHAR(45)  NOT NULL,
  x       INT          NOT NULL,
  y       INT          NOT NULL
);


CREATE TABLE IF NOT EXISTS weather_locations
(
  id        INT AUTO_INCREMENT PRIMARY KEY,
  place      VARCHAR(256),
  population INT,
  latitude  DOUBLE,
  longitude DOUBLE,
  municipality VARCHAR(256),
  country VARCHAR(256),
  district VARCHAR(256)
);

