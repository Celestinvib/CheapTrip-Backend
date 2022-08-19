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

create table Users(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100),
  surnames varchar(150),
  email varchar(255),
  password varchar(150),
  phone_number varchar(15),
  birth_date date,
  creation_date date,
  status bit(1),
  role_id int ,
  CONSTRAINT FK_RoleUser FOREIGN KEY (role_id) 
  REFERENCES Roles(id)
);

create table Accomodations (
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
    id INT PRIMARY KEY AUTO_INCREMENT,
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
    outbound_flight int NULL,
    return_flight int,
    accomodation_id int,
    status bit(1),
    CONSTRAINT FK_FlightBargainOutbound FOREIGN KEY (outbound_flight)
	REFERENCES Flights (id),
	CONSTRAINT FK_FlightBargainReturn FOREIGN KEY (return_flight)
	REFERENCES Flights (id),
	CONSTRAINT FK_AccomodationBargain FOREIGN KEY (accomodation_id)
	REFERENCES Accomodations (id)
);

create table Accomodations_Features (
    id INT PRIMARY KEY AUTO_INCREMENT,
	accomodation_id int,
    feature_id int,
	CONSTRAINT FK_AccomadationsFeatures FOREIGN KEY (accomodation_id)
	REFERENCES Accomodations (id),
	CONSTRAINT FK_FeaturesAccomadations FOREIGN KEY (feature_id)
	REFERENCES Features (id)
);

create table Bargains_Users (
    id INT PRIMARY KEY AUTO_INCREMENT,
	bargain_id int,
    user_id int,
    booked bit(1),
    bookmarked bit(1),
	CONSTRAINT FK_UsersBargains FOREIGN KEY (bargain_id)
	REFERENCES Bargains (id),
	CONSTRAINT FK_BargainsUsers FOREIGN KEY (user_id)
	REFERENCES Users (id)
);
