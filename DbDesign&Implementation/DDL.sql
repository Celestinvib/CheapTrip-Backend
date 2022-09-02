insert into Roles (name) values
	('client'),
	('employee'),
	('admin');

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

insert into Accomodations (name, surnames, email, password, phone_number, birth_date, creation_date, status, role_id) values
	('Juan José', 'Rodriguez Goes', 'juanjrogo@gmail.com', 'yonosoyJuan1#', '533567123', '1997-04-22', '2020-04-25', 1, 1),
    ('Esmeralda', 'Goes de la Cruz', 'esmecruz@gmail.com', 'goesEsme(9', '963582471', '1986-11-06', '2021-07-15', 1, 1),
    ('Ylenia', 'Almeria Ballesteros', 'vallesT@gmail.com', 'yosiganeaBnet23/', '642057952', '1978-01-16', '2022-05*10', 1, 11),
    ('Pedro', 'De la Rosa Lobato', 'laF1yAlonso@gmail.com', 'fernandoelnano02&', '456789123', '2001-01-23', '2021-04-22', 1, 21);

insert into Accommodations (name, address, category, latitude, longitude, rating, city_id, status) values
	('Pestana CR7', 'Rua do Comercio', 'Hotel', '38.70919', '-9.13596', '8.8', 1, 1),
    ('Chiado Luxury', 'Rua das Flores', 'Hotel', '38.70876', '-9.14357', '10', 1, 1),
    ('Uppelink', 'Sint-Michielsplein Strasse', 'Hostal', '51.05393', '3.71986', '8.3', 11, 1),
    ('Fat Margaret Hotel', 'Pohja pst', 'Hostal', '59.44421', '24.74892', '8.6', 21, 1),
    ('Hestia Hotel', 'Uus-Sadama', 'Hotel', '59.44283', '24.76767', '8.6', 21, 1);
    
insert into Flights (origin, destination, departure_date, arrival_date, status) values
	(31, 1, '2022-10-10', '2022-10-14', 1),
    (41, 11, '2022-10-03', '2022-10-06', 1),
    (31, 21, '2022-10-22', '2022-10-24', 1);
    
insert into Bargains (title, image, price, description, expiration_date, outbound_flight, return_flight, accommodation_id, status) values
	('Estancia por las Ruas Portuguesas', 'url(img)', '150', 'una descripcion', '2022-09-27', 1, 1, 1, 1),
    ('Gante y su magia', 'url(img)', '200', 'una descripcion', '2022-09-28', 11, 11, 1, 1),
    ('Tallin, vida de castillos', 'url(img)', '300', 'una descripcion', '2022-09-29', 21, 21, 1, 1);

insert into Accommodations_Features (accommodation_id, feature_id) values
	(1, 1),
    (11, 11),
    (21, 21);
    
insert into Bargains_Accomodations (bargain_id, accomodations_id, booked, bookmarked) values
	(1, 11, 0, 1),
    (21, 21, 1, 0);
