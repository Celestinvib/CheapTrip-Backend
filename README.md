# CheapTrip-Backend

![image](https://user-images.githubusercontent.com/55434881/189713243-1e098854-2b36-49b9-a5a1-4c15346db806.png)

## 📑 About
#### Cheaptrip Backend
The best trips at incredible prices!<br>
Built with the Spring Framework uses an external mySQL database designed, implemented and deployed by us.

The spring app and the database are deployed on<a href="https://www.heroku.com/home"> heroku</a>.
## ⚙Features 
* MVC structure
* Basic CRUD + Personalized methods & endpoints
#### Security: 
* JWT 
* Roles system

## 🛸 Technologies & Versions

* Java 1.8 
* Spring Tool Suite 4 
* Clear DB MySQL 
* Heroku 

## 🚀 Deploy:
 ·CheapTrip-Backend: https://pcn-cheaptrip-api.herokuapp.com
## 🔗URIs endpoints: 

```
Alojamiento
GET       /alojamientos
GET       /alojamientos/categorias/{categoria}
GET       /alojamientos/valoracion-minima/{valoracion}
GET       /alojamientos/ciudades/{ciudad}  
GET       /alojamientos/{id}
POST      /alojamientos
PUT       /alojamientos/{id}
PUT       /alojamientos/cambiar-estado/{id}
DELETE    /alojamientos/{id}

Chollo
GET       /chollos
GET       /todos/chollos
GET       /chollos/maxprecio/{precio}
GET       /chollos/expiran-pronto
GET       /chollos/alojamiento/{id-alojamiento}
GET       /chollos/ciudad/{id-ciudad}
GET       /chollos/alojamientos/categoria/{categoria}
GET       /chollos/{id}
POST      /chollos
PUT       /chollos/{id}
PUT       /chollos/cambiar-estado/{id}
DELETE    /chollos/{id}

Cuentas
GET       /cuentas
GET       /cuenta/{id}
GET       /cuentas/{email}
GET       /obtener-rol
POST      /registrar
POST      /cuentas/admin
PUT       /cuentas/{id}
PUT       /cuentas/cambiar-estado/{id}
DELETE    /cuentas/{id}

Ciudad
GET       /ciudades
GET       /ciudades/{id}
POST      /ciudades
PUT       /ciudades/{id}
DELETE    /ciudades/{id}

Vuelo
GET       /vuelos
GET       /vuelos/{id}
POST      /vuelos
PUT       /vuelos/{id}
PUT       /vuelos/cambiar-estado/{id}
DELETE    /vuelos/{id}

Rol
GET       /roles

Rasgo
GET       /rasgos
GET       /rasgos/{id}
POST      /rasgos
PUT       /rasgos/{id}
DELETE    /rasgos/{id}

Rasgos-Alojamientos
GET       /rasgos-alojamientos
GET       /rasgos-alojamientos/{id}
GET       /rasgos-alojamiento/{id-alojamiento}
GET       /rasgo-alojamientos/{id-rasgo}
POST      /rasgos-alojamientos
PUT       /rasgos-alojamientos/{id}
DELETE    /rasgos-alojamientos/{id}

Chollo-Cuenta
GET       /reservas
GET       /chollo-cuenta/{id}
GET       /reservas/{id_cuenta}
GET       /chollos-favoritos/{id_cuenta}
GET       /chollos-cuentas/{id}
POST      /reservas/
POST      /chollos-favoritos/
PUT       /chollos-cuentas/{id}
PUT       /chollo-reservado/cambiar-estado/{id}
PUT       /chollo-favorito/cambiar-estado/{id}
DELETE    /chollos-cuentas/{id}
```

