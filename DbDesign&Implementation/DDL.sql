insert into Roles (name) values
	('ROLE_ADMIN'),
	('ROLE_USER');

insert into Features (name) values
	('wifi'),
	('sala de juegos'),
	('piscina');

insert into Cities (name) values
	('Gante'),
	('Tallin'),
    ('Barcelona'),
    ('Reus'),
    ('Tarragona');
    
insert into Accommodations (name, address, category, latitude, longitude, rating, city_id, status) values
	('Pestana CR7', 'Rua do Comercio', 'Hotel', '38.70919', '-9.13596', '8.8', 1, 1),
    ('Chiado Luxury', 'Rua das Flores', 'Hotel', '38.70876', '-9.14357', '10', 1, 1),
    ('Uppelink', 'Saint-Michielsplein Strasse', 'Hostal', '51.05393', '3.71986', '8.3', 11, 1),
    ('Fat Margaret Hotel', 'Pohja pst', 'Hostal', '59.44421', '24.74892', '8.6', 21, 1),
    ('Hestia Hotel', 'Uus-Sadama', 'Hotel', '59.44283', '24.76767', '8.6', 21, 1);
    
    
insert into Flights (id, origin, destination, departure_date, arrival_date, status) values
	('LK5632_Iberia', 31, 1, '2022-10-10', '2022-10-14', 1),
    ('VY1593_Vueling', 41, 11, '2022-10-03', '2022-10-06', 1),
    ('VY2293_Vueling', 31, 21, '2022-10-22', '2022-10-24', 1);
    
insert into Bargains (title, image, price, description, expiration_date, outbound_flight, return_flight, accommodation_id, status) values
	('Estancia por las Ruas Portuguesas', 'https://images.unsplash.com/photo-1579971030646-263a0ef4aa34?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', '150', 'una descripcion', '2022-09-27', 'LK5632_Iberia', 'LK5632_Iberia', 11, 1),
    ('Gante y su magia', 'https://images.unsplash.com/photo-1579971030646-263a0ef4aa34?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', '200', 'una descripcion', '2022-09-28', 'VY1593_Vueling', 'VY2293_Vueling', 31, 1),
    ('Tallin, vida de castillos', 'https://images.unsplash.com/photo-1650701520938-8e3429bf6c41?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', '300', 'una descripcion', '2022-09-29', 'VY2293_Vueling', 'VY1593_Vueling', 51, 1);

insert into Accommodations_Features (accommodation_id, feature_id) values
	(11, 1),
    (31, 11),
    (41, 21);
    
insert into Bargains_Accounts (bargain_id, account_id, booked, bookmarked) values
	(31, 1, 0, 1),
    (41, 21, 1, 0);
    
INSERT INTO `heroku_8d815fbd277b0f2`.`accounts` (`birth_date`, `creation_date`, `email`, `name`, `phone_number`, `status`, `surnames`) VALUES ('2001-03-23 01:50:55', '2022-09-25 19:15:55', 'nicolasgarcia@gmail.com', 'Nicolas', '608534015', '1', 'Garcia-Vallaure Conte');
