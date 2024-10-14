# PARCIAL DETECCION DE MUTANTES

Este proyecto implementa una API REST que analiza secuencias de ADN para determinar si una persona es mutante o humana, según las reglas establecidas por Magneto. La API recibe las secuencias en formato JSON y utiliza un algoritmo que busca más de una secuencia de cuatro letras iguales consecutivas (horizontal, vertical o diagonal) para identificar mutaciones.

El sistema es escalable e incluye pruebas automáticas para garantizar su correcto funcionamiento. Las secuencias analizadas se almacenan en una base de datos H2, indicando si pertenecen a mutantes o humanos. Además, el proyecto proporciona un endpoint para estadísticas , permitiendo consultar la cantidad total de secuencias procesadas y la proporción entre mutantes y humanos.

## Funcionamiento

El programa recibirá un arreglo de cadenas (Strings), donde cada elemento del arreglo representa una fila de una tabla de 6x6 que contiene la secuencia de ADN. Las letras en las cadenas pueden ser únicamente: **A**, **T**, **C**, **G**, que corresponden a las bases nitrogenadas del ADN.

Un humano será identificado como mutante si se encuentran **más de una secuencia** de cuatro letras iguales, ya sea de forma oblicua, horizontal o vertical.

Las filas de la matriz se ingresarán por teclado.

### Ejemplo de entrada:

- Una entrada típica sería algo como: `'ATCGTA'` 

## Instrucciones de ejecución

### Tecnologías Implementadas:
Java 17
Spring Boot
H2 Console
JPA
Postman
Render 
Swagger

### RENDER 
El proyecto ha sido desplegado en Render (plataforma de hosting en la nube), puede ser accedido mediante el siguiente enlace:
https://parcialprogramacionmutantes.onrender.com

#### /mutant

- **POST** /mutant - Recibe un JSON con la matriz de ADN a verificar. Ejemplo:

```json
{
  "dna": [
  "ATGCCA",
  "CCTGTA",
  "CCCCTA",
  "AGTAAG",
  "CCTGAC",
  "TTAACG"
]
}

```
- **GET** /mutant/list - Devuelve un JSON con todos los ADN verificados. Ejemplo:

```json
[
  {
    "id": 1,
    "dna": [
      "ATGCCA",
      "CCTGTA",
      "CCCCTA",
      "AGTAAG",
      "CCTGAC",
      "TTAACG"
    ],
    "isMutant": false
  }
]

```
- **GET** /mutant/detail/{id} - Devuelve un JSON con todos los datos del id especificado. Ejemplo:

```json
{
  "dna": [
    "ATGCCA",
    "CCTGTA",
    "CCCCTA",
    "AGTAAG",
    "CCTGAC",
    "TTAACG"
  ],
  "isMutant": false,
  "id": 1
}
```
- **GET** /mutant/short/{id} - Devuelve un JSON con **SOLO** el ADN del id especificado. Ejemplo:

```json
{
  "dna": [
    "ATGCCA",
    "CCTGTA",
    "CCCCTA",
    "AGTAAG",
    "CCTGAC",
    "TTAACG"
  ]
}
```

#### /stats

- **GET** /stats/list - Devuelve un JSON todas las estadisticas de todos los ADN verificados. Ejemplo:

```json
[
  {
    "id": 1,
    "countMutantDNA": 1,
    "countHumanDNA": 53,
    "ratio": 0.018518518518518517
  }
]
```
- **GET** /stats/list/{id} - Devuelve un JSON todas las stats del ADN especificado. Ejemplo:

```json
{
  "countMutantDNA": 1,
  "countHumanDNA": 53,
  "ratio": 0.018518518518518517
}
```
## Pruebas Unitarias

Se incluyen casos de pruebas contemplando los errores de ingreso como las verificaciones con ADN tanto cortos como largos.
