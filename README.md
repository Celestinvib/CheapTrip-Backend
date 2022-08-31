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
DELETE    /alojamientos/cambiar-estado/{id}
DELETE    /alojamientos/{id}

Chollo
GET       /chollos
GET       /chollos/maxprecio/{precio}
GET       /chollos/{id}
POST      /chollos
PUT       /chollos/{id}
DELETE    /chollos/cambiar-estado/{id}
DELETE    /chollos/{id}

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
DELETE    /vuelos/cambiar-estado/{id}
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

Chollo-Usuario
GET       /chollosfavoritos
GET       /chollosreservados
GET       /chollos-usuario/{id}
PUT       /chollos-usuario/{id}
DELETE    /cholloreservado/cambiar-estado/{id}
DELETE    /chollofavorito/cambiar-estado/{id}
DELETE    /chollos-usuario/{id}
```
