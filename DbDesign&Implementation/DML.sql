
drop table if exists Bargains_Accounts;
drop table if exists Accommodations_Features;
drop table if exists Features;
drop table if exists Bargains;
drop table if exists Flights;
drop table if exists Accommodations;
drop table if exists Cities;
drop table if exists Accounts_Roles;
drop table if exists Accounts;
drop table if exists Roles;


create table Roles(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100)
);

create table Features(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100)
);

create table Cities(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100)
);

create table Accounts(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100),
  surnames varchar(150),
  email varchar(255) UNIQUE,
  password varchar(150),
  phone_number varchar(15),
  birth_date date,
  creation_date date,
  status bit(1)
);

create table Accounts_Roles(
	id int PRIMARY KEY AUTO_INCREMENT,
    account_id int,
    role_id int,
    CONSTRAINT FK_RoleAccRoles FOREIGN KEY (role_id) 
	REFERENCES Roles(id),
	CONSTRAINT FK_AccountAccRoles FOREIGN KEY (account_id) 
	REFERENCES Accounts(id)
);

create table Accommodations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(100),
    address varchar(255),
    category varchar(100),
    latitude double,
	longitude double,
    rating double,
    city_id INT,
    status bit(1),
    CONSTRAINT FK_CityAccomodation FOREIGN KEY (city_id)
	REFERENCES Cities (id)
);

create table Flights (
    id VARCHAR(150) PRIMARY KEY,
    origin int,
    destination int,
    departure_date date,
    arrival_date date,
    status bit(1),
    CONSTRAINT FK_CityFlightOrigin FOREIGN KEY (origin)
	REFERENCES Cities (id),
	CONSTRAINT FK_CityFlightDestination FOREIGN KEY (destination)
	REFERENCES Cities (id)
);

create table Bargains (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title varchar(100),
    image varchar(255),
    price double,
    description varchar(250),
	expiration_date date NULL,
    outbound_flight VARCHAR(150),
    return_flight VARCHAR(150),
    accommodation_id int,
    status bit(1),
    CONSTRAINT FK_FlightBargainOutbound FOREIGN KEY (outbound_flight)
	REFERENCES Flights (id),
	CONSTRAINT FK_FlightBargainReturn FOREIGN KEY (return_flight)
	REFERENCES Flights (id),
	CONSTRAINT FK_AccommodationBargain FOREIGN KEY (accommodation_id)
	REFERENCES Accommodations (id)
);

create table Accommodations_Features (
    id INT PRIMARY KEY AUTO_INCREMENT,
	accommodation_id int,
    feature_id int,
	CONSTRAINT FK_AccommadationsFeatures FOREIGN KEY (accommodation_id)
	REFERENCES Accommodations (id),
	CONSTRAINT FK_FeaturesAccommadations FOREIGN KEY (feature_id) 
	REFERENCES Features (id) ON DELETE CASCADE
);

create table Bargains_Accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
	bargain_id int,
    account_id int,
    booked bit(1),
    bookmarked bit(1),
	CONSTRAINT FK_UsersBargains FOREIGN KEY (bargain_id)
	REFERENCES Bargains (id),
	CONSTRAINT FK_BargainsAccounts FOREIGN KEY (account_id)
	REFERENCES Accounts (id)
);