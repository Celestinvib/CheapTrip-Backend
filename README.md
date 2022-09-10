# CheapTrip-Backend
### URIs endpoints: 

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
GET       /chollos/maxprecio/{precio}
GET       /chollos/{id}
POST      /chollos
PUT       /chollos/{id}
PUT       /chollos/cambiar-estado/{id}
DELETE    /chollos/{id}

Cuentas
GET       /cuentas
GET       /cuentas/{email}
POST      /registrar
POST      /cuentas
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
GET       /roles/{id}
POST      /roles
PUT       /roles/{id}
DELETE    /roles/{id}


Rasgo
GET       /rasgos
GET       /rasgos/{id}
POST      /rasgos
PUT       /rasgos/{id}
DELETE    /rasgos/{id}

Rasgos-Alojamientos
GET       /rasgos-alojamientos
GET       /rasgos-alojamientos/{id}
POST      /rasgos-alojamientos
PUT       /rasgos-alojamientos/{id}
DELETE    /rasgos-alojamientos/{id}

Chollo-Cuenta
GET       /reservas
GET       /reservas/{id}
GET       /chollos-reservados/{id_cuenta}
GET       /chollos-favoritos/{id_cuenta}
GET       /chollos-cuentas/{id}
PUT       /chollos-cuentas/{id}
PUT       /chollo-reservado/cambiar-estado/{id}
PUT       /chollo-favorito/cambiar-estado/{id}
DELETE    /chollos-cuentas/{id}
```
