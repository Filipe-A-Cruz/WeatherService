create database if not exists weatherservice;

use weatherservice;

create table if not exists InstantTemperature
(
    idInstantTemperatureApiKey           int,
    valueWSInstantTemperatureMeasurement double,
    valueWSInstantTemperatureUnit        varchar(255),
    valueWSInstantTemperatureInfo        varchar(255),
    primary key (idInstantTemperatureApiKey)
);

create table if not exists InstantWind
(
    idInstantWindApiKey           int,
    valueWSInstantWindMeasurement double,
    valueWSInstantWindUnit        varchar(255),
    valueWSInstantWindInfo        varchar(255),
    primary key (idInstantWindApiKey)
);

create table if not exists MaxWindOverPeriod
(
    idMaxWindOverPeriodApiKey           int,
    valueWSMaxWindOverPeriodMeasurement double,
    valueWSMaxWindOverPeriodUnit        varchar(255),
    valueWSMaxWindOverPeriodInfo        varchar(255),
    primary key (idMaxWIndOverPeriodApiKey)
);

create table if not exists SunriseOrSunset
(
    idSunriseOrSunsetApiKey           int,
    valueWSSunriseOrSunsetMeasurement double,
    valueWSSunriseOrSunsetUnit        varchar(255),
    valueWSSunriseOrSunsetInfo        varchar(255),
    primary key (idSunriseOrSunsetApiKey)
);