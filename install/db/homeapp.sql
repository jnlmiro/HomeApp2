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
  id           INT                   AUTO_INCREMENT PRIMARY KEY,
  place        VARCHAR(256) NULL,
  geo_name_id  INT          NOT NULL UNIQUE,
  population   INT          NULL,
  latitude     DOUBLE       NOT NULL,
  longitude    DOUBLE       NOT NULL,
  municipality VARCHAR(256) NULL,
  country      VARCHAR(256) NOT NULL,
  district     VARCHAR(256) NULL,
  current      BOOLEAN      NOT NULL DEFAULT FALSE
);


CREATE TABLE IF NOT EXISTS zwave_sensors
(
  id           INT AUTO_INCREMENT PRIMARY KEY,
  sensor_ha_id VARCHAR(256) NOT NULL,
  name         VARCHAR(256) NOT NULL,
  state        INT          NOT NULL
);


CREATE TABLE IF NOT EXISTS pincodes
(
  id   INT AUTO_INCREMENT PRIMARY KEY,
  code INT NOT NULL
);
