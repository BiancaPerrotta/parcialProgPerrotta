# PARCIAL DETECCION DE MUTANTES

Este proyecto implementa una API REST que analiza secuencias de ADN para determinar si una persona es mutante o humana, según las reglas establecidas por Magneto. La API recibe las secuencias en formato JSON y utiliza un algoritmo que busca más de una secuencia de cuatro letras iguales consecutivas (horizontal, vertical o diagonal) para identificar mutaciones.

El sistema es escalable e incluye pruebas automáticas para garantizar su correcto funcionamiento. Las secuencias analizadas se almacenan en una base de datos H2, indicando si pertenecen a mutantes o humanos. Además, el proyecto proporciona un endpoint para estadísticas , permitiendo consultar la cantidad total de secuencias procesadas y la proporción entre mutantes y humanos.

## Funcionamiento

El programa recibirá un arreglo de cadenas (Strings), donde cada elemento del arreglo representa una fila de una tabla de 6x6 que contiene la secuencia de ADN. Las letras en las cadenas pueden ser únicamente: **A**, **T**, **C**, **G**, que corresponden a las bases nitrogenadas del ADN.

Un humano será identificado como mutante si se encuentran **más de una secuencia** de cuatro letras iguales, ya sea de forma oblicua, horizontal o vertical.

Las filas de la matriz se ingresarán por teclado.

### Ejemplo de entrada:

- Una entrada típica sería algo como: `'ATCGTA'` 

## Tecnologías Implementadas:
Java 17
Spring Boot
H2 Console
JPA
Postman
Render 

## Instrucciones de ejecución
## 1. POSTMAN
Se puede enviar una REQUEST a traves de POSTMAN para probar los endpoints.

### Endpoint -> /"stats"
- GET:
  Colocar como URL: https://parcialprogperrotta.onrender.com/stats/list y presionar SEND para acceder a la lista de estadisticas
- GET seguido del ID:
  Colocar como URL: https://parcialprogperrotta.onrender.com/stats/list/ID y presionar SEND para acceder a la estadistica buscada por ID
### Endpoint -> /"mutant"
- GET:
  Colocar como URL: https://parcialprogperrotta.onrender.com/mutant/list y presionar SEND para acceder a la lista de ADNS cargados
- GET:
  Colocar como URL: https://parcialprogperrotta.onrender.com/mutant/detail/ID y presionar SEND para acceder a los datos detallados de un ADN especifico por ID
- GET:
  Colocar como URL: https://parcialprogperrotta.onrender.com/mutant/short/ID y presionar SEND para acceder a una version resumida de los datos de un ADN especifico por ID
- POST:
  Colocar como URL: https://parcialprogperrotta.onrender.com/mutant para crear una nueva cadena de ADNS...
  En el apartado de "Body", ir a la opción RAW y colocar un JSON. Presionar "SEND".

### 2. RENDER 
El proyecto ha sido desplegado en Render (plataforma de hosting en la nube), puede ser accedido mediante el siguiente enlace:
https://parcialprogperrotta.onrender.com

## Pruebas Unitarias
Se incluyen casos de pruebas contemplando los errores de ingreso como las verificaciones con ADN tanto cortos como largos.

## Diagrama de Secuencia
![Captura de pantalla 2024-10-14 220048](https://github.com/user-attachments/assets/841d7a21-0599-4799-bf45-4e1e16f9828b)

