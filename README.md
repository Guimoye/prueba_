# Proyecto de prueba

lista de endpoinds

- Crear commerce

http://localhost:1011/api/v1/prueba/commerce

METODO POST

Payload:

{
"brandId": 1,
"startDate": "2020-06-15T13:49:51.000+00:00",
"endDate": "2020-06-15T00:00:00.000+00:00",
"priceList": 1,
"productId": 3,
"priority": 3,
"price": 3.18,
"curr": "Restaurant payment"
}

- Buscar todos los commerces

METODO GET

http://localhost:1011/api/v1/prueba/commerce/findAll


- Buscar registros de commerce

http://localhost:1011/api/v1/prueba/commerce/find/{date}/{productId}/{brandId}

ejemplo:
http://localhost:1011/api/v1/prueba/commerce/find/2020-06-14/3/1


- Buscar registros de commerce con frase de respuesta

http://localhost:1011/api/v1/prueba/commerce/findString/{date}/{productId}/{brandId}

ejemplo:
http://localhost:1011/api/v1/prueba/commerce/findString/2020-06-14/3/1


NOTA:

1. Se han realizado las pruebas unitarias
2. Se han creado 4 enpoints debido a que no lo tuve claro el requerimiento
   - El 1ro para registrar los commerce
   - El 2do para consultar todos
   - El 3ro para buscarlo por el filtro requerido fecha de aplicación, identificador de producto, identificador de cadena.
   - El 4ro para buscarlo por el filtro requerido fecha de aplicación, identificador de producto, identificador de cadena pero con la queda de texto solicitada de respuesta.
3. link de swagger http://localhost:1011/swagger-ui/index.html
