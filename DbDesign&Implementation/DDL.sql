insert into Roles (name) values
	('ROLE_ADMIN'),
	('ROLE_USER');

insert into Features (name) values
	('wifi'),
	('sala de juegos'),
	('piscina');

insert into Cities (name) values
	('Lisboa'),
	('Gante'),
	('Tallin'),
    ('Barcelona'),
    ('Reus');

insert into Accounts (name, surnames, email, password, phone_number, birth_date, creation_date, status) values
	('NCP', 'Admin', 'admin', '$2a$12$z/VXZDxQrPjXdjG2Sul.H.4NM76MKwsbcewCx8mZo1qXDmlP3TsTm', '111222333', '1997-04-22', '1900-01-01', 1),
	('Juan José', 'Rodriguez Goes', 'juanjrogo@gmail.com', '$2a$12$0GGJEBdiLAyq8hUrNkLXy.O8lLOBpwkMLfR1V5WFYNiSwAZmdpBKO', '533567123', '1997-04-22', '2020-04-25', 1),
    ('Esmeralda', 'Goes de la Cruz', 'esmecruz@gmail.com', '$2a$12$8zEYGdf2tubyf5nB63YX8eutmswkjbWtNnj/pmGz4FpyOjG1PIk.q', '963582471', '1986-11-06', '2021-07-15', 1),
    ('Ylenia', 'Almeria Ballesteros', 'vallesT@gmail.com', '$2a$12$SK6kaGW1qhbJ/nr/HSJBRufW7GewxLxUxKTAAgsgmCSlJlCyTVOkW', '642057952', '1978-01-16', '2022-05-10', 1),
    ('Pedro', 'De la Rosa Lobato', 'laF1yAlonso@gmail.com', '$2a$12$ktNMx1UwJRqxH2aqQ.odLuiBVpOMrJ8pVFnxGZkyzsJjUGvPjvgmG', '456789123', '2001-01-23', '2021-04-22', 1);

insert into AccountsRoles(account_id, role_id) values
	(1, 1),
    (11, 11),
    (21, 11),
    (31, 11),
    (41, 11);

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
	('Estancia por las Ruas Portuguesas', 'https://images.unsplash.com/photo-1588535684923-900727736ac0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80', '150', 'una descripcion', '2022-09-27', 'LK5632_Iberia', 'LK5632_Iberia', 1, 1),
    ('Gante y su magia', 'https://images.unsplash.com/photo-1604588839462-ce749d26fc2b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80', '200', 'una descripcion', '2022-09-28', 'VY1593_Vueling', 'VY2293_Vueling', 1, 1),
    ('Tallin, vida de castillos', 'https://images.unsplash.com/photo-1601297830297-738d875c18c8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=351&q=80', '300', 'una descripcion', '2022-09-29', 'VY2293_Vueling', 'VY1593_Vueling', 1, 1);

insert into Accommodations_Features (accommodation_id, feature_id) values
	(1, 1),
    (11, 11),
    (21, 21);
    
insert into Bargains_Accounts (bargain_id, account_id, booked, bookmarked) values
	(1, 11, 0, 1),
    (21, 21, 1, 0);
