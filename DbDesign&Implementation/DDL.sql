insert into Roles (name) values
	('ROLE_ADMIN'),
	('ROLE_USER');

insert into Features (name) values
	('Wifi'),
	('Sala de juegos'),
	('Piscina'),
	('Desayuno incluido'),
    	('Late check out'),
    	('Vistas a los canales'),
    	('Desayuno y comida'),
    	('Entrada a Caldea'),
    	('Gimnasio'),
    	('Botella de vino');

insert into Cities (name) values
	('Lisboa'),
	('Gante'),
	('Tallin'),
    	('Barcelona'),
    	('Reus'),
   	('Tarragona'),
	('Paris'),
    	('Sevilla'),
    	('China'),
    	('New York'),
    	('Amsterdam'),
    	('Venecia'),
    	('Granada'),
    	('Madrid');
    
insert into Accommodations (name, address, category, latitude, longitude, rating, city_id, status) values
	('Pestana CR7', 'Rua do Comercio', 'Hotel', '38.70919', '-9.13596', '8.8', 1, 1),
    	('Chiado Luxury', 'Rua das Flores', 'Hotel', '38.70876', '-9.14357', '10', 1, 1),
    	('Uppelink', 'Saint-Michielsplein Strasse', 'Hostal', '51.05393', '3.71986', '8.3', 11, 1),
    	('Fat Margaret Hotel', 'Pohja pst', 'Hostal', '59.44421', '24.74892', '8.6', 21, 1),
    	('Hestia Hotel', 'Uus-Sadama', 'Hotel', '59.44283', '24.76767', '8.6', 21, 1);
	('Innside Madrid Gran Vía', 'Calle de Mesonero Romanos, 13', 'Hotel4', '40.42058520047044', '-3.703881307264552', '8.4', 151, 1),
    	('Timhotel Montmartre', 'Place Emile Godeu, 11', 'Hotel3', '48.88599448726617', '2.3376619768515003', '8.6', 81, 1),
    	('Hotel Alfonso XIII', 'Calle San Fernando, 2', 'Hotel5', '37.381660099298585', '-5.992611982084022', '10', 91, 1),
    	('Jinjiang Business Hotel', 'Youyi Rd', 'Hotel2', '43.65101734037345', '111.98840344974265', '9.6', 101, 1),
    	('Martinique', 'Calle de Mesonero Romanos, 13', 'Hotel4', '40.74831970675963', '-73.98778248586746', '8.4', 111, 1),
    	('Conservatorium Hotel', 'Calle de Mesonero Romanos, 13', 'Hotel5', '52.35891303451569', '4.879631662626067', '9.2', 121, 1),
    	('Aman Venice', 'Palazzo Papadopoli, 1364', 'Hotel5', '45.437217618345514', '12.33178229264448', '9.6', 131, 1), 
    	('Palacio De Santa Paula', 'Calle de Gran Vía de Colón, 31', 'Hotel5', '37.17957373738918', '-3.5997858699269267', '9.2', 141, 1);
    
    
insert into Flights (id, origin, destination, departure_date, arrival_date, status) values
	('LK5632_Iberia', 31, 1, '2022-10-10', '2022-10-14', 1),
    ('VY1593_Vueling', 41, 11, '2022-10-03', '2022-10-06', 1),
    ('VY2293_Vueling', 31, 21, '2022-10-22', '2022-10-24', 1),
    ('MG4591_Ryanair', 31, 81, '2022-11-10', '2022-11-16', 1),
    ('XV2357_Qatar-Airways', 21, 101, '2022-12-23', '2022-12-28', 1),
    ('ZT9373_American-Airways', 21, 111, '2022-10-30', '2022-11-05', 1),
    ('WM8856_Lufthansa', 31, 121, '2022-11-27', '2022-12-01', 1),
    ('PF1172_Iberia', 21, 131, '2022-11-20', '2022-11-24', 1);
    
insert into Bargains (title, image, price, description, expiration_date, outbound_flight, return_flight, accommodation_id, status) values
	('Estancia por las Ruas Portuguesas', 'https://images.unsplash.com/photo-1579971030646-263a0ef4aa34?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', '150', 'una descripcion', '2022-09-27', 'LK5632_Iberia', 'LK5632_Iberia', 11, 1),
    ('Gante y su magia', 'https://images.unsplash.com/photo-1579971030646-263a0ef4aa34?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', '200', 'una descripcion', '2022-09-28', 'VY1593_Vueling', 'VY2293_Vueling', 31, 1),
    ('Tallin, vida de castillos', 'https://images.unsplash.com/photo-1650701520938-8e3429bf6c41?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', '300', 'una descripcion', '2022-09-29', 'VY2293_Vueling', 'VY1593_Vueling', 51, 1);
	('Barcelona y La Sagrada Família', 
    'https://images.unsplash.com/photo-1557700055-b354bee54b69?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 
    '55', 'Barcelona es una gran ciudad, y un gran encanto, ¡Acércate a descubrirla!', '2022-10-10', 'null', 'null', 131, 1),
    ('Viaje del amor en Paris', 
    'https://images.unsplash.com/photo-1545721264-afab304e89d9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 
    '200', 'Disfruta con tu pareja de un finde de semana por la ciudad del amor', '2022-10-10', 'MG4591_Ryanair', 'MG4591_Ryanair', 61, 1),
    ('Fin de semana en la capital', 
    'https://images.unsplash.com/photo-1601069610970-5a14a9c2787a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=850&q=80', 
    '75', 'Disfruta de la estancia en la área metropolitana', '2022-10-30', 'null', 'null', 51, 1),
    ('Asómbrate en Amsterdam', 
    'https://images.unsplash.com/photo-1559722746-9faf25bfa805?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 
    '250', 'Ve por ti mismo lo que muchos llaman la "Venecia del Norte"', '2022-10-26', 'WM8856_Lufthansa', 'WM8856_Lufthansa', 121, 1),
    ('Venecia', 
    'https://images.unsplash.com/photo-1518945756765-f8641d60fc0b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=876&q=80', 
    '300', 'La ciudad más bella del mundo a un click , Es una ciudad que vas a amar, pero sobre todo te va a seducir', '2022-11-05', 'PF1172_Iberia', 'PF1172_Iberia', 131, 1),
    ('Estancia en la Alhambra', 
    'https://images.unsplash.com/photo-1564697546537-e71eb2aaad1b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 
    '110', 'El sur de España, en la ladera de las montañas de la sierra Nevada', '2022-09-24', 'null', 'null', 121, 1),
    ('Fascínate en Sevilla', 
    'https://images.unsplash.com/photo-1640799309728-cf8c79dc7a3c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=829&q=80', 
    '95', 'Tiene un color especial todo el mundo lo dice hora de lo pruebes o confirmes por ti mismo', '2022-09-27', 'null', 'null', 71, 1),
    ('New York', 
    'https://images.unsplash.com/photo-1553605607-21e496a1c865?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=897&q=80', 
    '340', 'La ciudad que nunca duerme a un precio increíble, Vive una experiencia inolvidable en la ciudad que nunca duerma', '2022-10-15', 'ZT9373_American-Airways', 'ZT9373_American-Airways', 11, 1),
    ('Descubriendo en Pekín', 
    'https://images.unsplash.com/photo-1510332981392-36692ea3a195?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 
    '575', 'Conoce la cultura occidental de Pekín mientras te relejas y asombras en sus calles', '2022-11-23', 'XV2357_Qatar-Airways', 'XV2357_Qatar-Airways', 81, 1),
    ('Escapada en Tallin', 
    'https://images.unsplash.com/photo-1609263336456-f88bc1639957?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80', 
    '330', 'Descubre la ciudad más poblada de Estonia y su principal puerto', '2022-11-03', 'LK5632_Iberia', 'LK5632_Iberia', 11, 1);
    
insert into Accommodations_Features (accommodation_id, feature_id) values
	(11, 1),
    (31, 11),
    (41, 21);
    
insert into Bargains_Accounts (bargain_id, account_id, booked, bookmarked) values
	(31, 1, 0, 1),
    (41, 21, 1, 0);
    
INSERT INTO `heroku_8d815fbd277b0f2`.`accounts` 

	(`birth_date`, `creation_date`, `email`, `name`, `phone_number`, `status`, `surnames`) VALUES ('2001-03-23 01:50:55', '2022-09-25 19:15:55', 'nicolasgarcia@gmail.com', 'Nicolas', '608534015', '1', 'Garcia-Vallaure Conte');
