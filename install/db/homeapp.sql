CREATE SCHEMA IF NOT EXISTS homeapp
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS stations (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  name    VARCHAR(100) NOT NULL,
  site_id INT          NOT NULL,
  type    VARCHAR(45)  NOT NULL,
  x       INT          NOT NULL,
  y       INT          NOT NULL,
  enabled BOOLEAN DEFAULT FALSE NOT NULL
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
  id                  INT     AUTO_INCREMENT PRIMARY KEY,
  ha_id               VARCHAR(256) NOT NULL,
  node_id             VARCHAR(256) NOT NULL,
  name                VARCHAR(256) NOT NULL,
  state               INT          NOT NULL,
  alarming            BOOLEAN DEFAULT FALSE,
  sensor_type         VARCHAR(256),
  unit_of_measurement VARCHAR(256),
  enabled             BOOLEAN DEFAULT FALSE
);


CREATE TABLE IF NOT EXISTS alarm_groups (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(256) NOT NULL ,
  enabled BOOLEAN DEFAULT FALSE NOT NULL ,
  fired BOOLEAN DEFAULT FALSE NOT NULL
);


CREATE TABLE IF NOT EXISTS pincodes
(
  id   INT AUTO_INCREMENT PRIMARY KEY,
  code INT NOT NULL,
  alarm_group INT NOT NULL,
  FOREIGN KEY fk_alarm_group_pincode(alarm_group) REFERENCES pincodes(id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);


