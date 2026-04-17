# 🚀 Ayudantía Intensiva I: Operación "Nebulosa de Orión"

## 📝 Descripción Académica
El objetivo de esta sesión es integrar los pilares fundamentales de la Programación Orientada a Objetos (POO) mediante la simulación de un **Centro de Control Táctico Espacial**. Como ingenieros de software de la Alianza, deben desarrollar un sistema capaz de gestionar una flota de naves espaciales y proyectar su ubicación en un **Mapa Sectorial (Matriz 10x10)**. 

Este ejercicio profundiza en la **Asociación entre Objetos**, donde los datos técnicos de una nave (leídos de un archivo) deben sincronizarse con sus coordenadas espaciales (leídos de otro archivo) para poblar una estructura bidimensional. Se pondrá énfasis en la **Herencia**, permitiendo que diferentes tipos de naves reaccionen de forma polimórfica ante eventos de combate y movimiento, y en el uso de **Colecciones** para la gestión dinámica de la flota.

## 🎯 Objetivos de Aprendizaje
-   **Herencia y Abstracción**: Diseñar una jerarquía de clases con una base abstracta `Nave` y subclases especializadas.
-   **Gestión de Matrices**: Implementar un mapa táctico de `10x10` donde se almacenen las referencias o identificadores de las naves.
-   **Cruce de Persistencia**: Leer y procesar dos archivos independientes, utilizando el `ID` de la nave como llave primaria para la vinculación.
-   **Encapsulamiento y Validación**: Asegurar que las coordenadas de la matriz no se desborden y que el estado de las naves sea consistente.
-   **Polimorfismo**: Implementar métodos que varíen su comportamiento según el tipo de nave.

## 📥 Entrada (Archivos de Texto)

### 1. Archivo `naves.txt`
Contiene los registros técnicos de la flota. Formato: `TIPO;ID;NOMBRE;ENERGIA;ATRIBUTO_ESPECIFICO`
```text
GUERRA;N-01;Destructor-X;100.0;500
SOPORTE;S-12;Reparador-Alpha;85.0;200
EXPLORACION;E-05;Sonda-Voyager;60.0;15.5
```

### 2. Archivo `posiciones.txt`
Contiene la ubicación actual en el sector. Formato: `ID_NAVE;FILA;COLUMNA`
```text
N-01;0;0
S-12;5;5
E-05;9;2
```

## 📤 Salida Esperada: Menú de Operaciones
El sistema debe desplegar un menú interactivo. A continuación se detalla el comportamiento esperado de cada opción:

1.  **Cargar Flota y Sincronizar Mapa**: 
    -   Lee `naves.txt` para crear los objetos y almacenarlos en un `ArrayList`.
    -   Lee `posiciones.txt` para asignar las coordenadas a cada nave. 
    -   Puebla la matriz `10x10` con los `ID` de las naves en sus respectivas posiciones.
2.  **Visualizar Mapa Táctico**: 
    -   Imprime la matriz de forma cuadriculada. Las celdas vacías deben mostrar `[ . ]` y las ocupadas el `ID` de la nave (ej: `[N-01]`).
3.  **Mostrar Estado Detallado**: 
    -   Lista todas las naves con sus atributos base y específicos, incluyendo su ubicación actual o si se encuentran "En Hiperespacio".
4.  **Simulación de Combate**: 
    -   Solicita el ID de una `NaveGuerra` (atacante) y el ID de cualquier otra nave (objetivo). 
    -   Aplica el daño basado en el `poderAtaque` de la nave atacante al objetivo.
5.  **Realizar acciones**: 
    -   Ejecuta el método `realizarAccion()` de todas las naves en la lista. Cada tipo de nave debe imprimir o ejecutar un comportamiento distinto basado en su atributo específico.
6.  **Mover Nave**: 
    -   Solicita el ID de una nave y nuevas coordenadas. 
    -   **Validación**: Debe limpiar la posición anterior en la matriz y verificar que la nueva posición no esté ocupada ni fuera de los límites.
7.  **Estadísticas del Sector**: 
    -   Muestra el conteo total de naves activas, el promedio de energía de la flota y qué tipo de nave es la predominante en el sector.
8.  **Salir**: Cierra el sistema de comando.

## 🛠️ Detalles Técnicos y Atributos Específicos

### A. Utilidad de los Atributos Específicos
Cada subclase posee un atributo que define su rol táctico y se utiliza en los cálculos del sistema:
-   **NaveGuerra (`poderAtaque`)**: Define la cantidad de energía que resta a un objetivo durante la opción de combate. Un mayor valor permite neutralizar enemigos más rápido.
-   **NaveSoporte (`capacidadEscudo`)**: Actúa como un modificador de defensa. Cuando una nave de soporte recibe daño, este se reduce proporcionalmente a su escudo. Además, su acción especial puede restaurar energía a aliados cercanos.
-   **NaveExploracion (`rangoVisibilidad`)**: Determina el alcance de su escaneo. En sistemas avanzados, este valor define cuántas celdas a la redonda puede "revelar" en el mapa.

### B. Lógica de la Matriz y Validaciones
-   La matriz debe ser de tipo `String[][]`.
-   **Validación de Rango**: Cualquier nave con coordenadas menores a 0 o mayores a 9 en el archivo de entrada no debe ser colocada en la matriz y su estado debe ser "FUERA_DE_RANGO".
-   **Colisión**: Si dos naves intentan ocupar la misma celda en el archivo de entrada, la segunda nave debe ser desplazada a la siguiente celda disponible o quedar en espera.

---
🕓 **Dificultad estimada**: Muy Alta
📚 **Contenidos**: Herencia, Matrices (2D Arrays), List/ArrayList, Manejo de Archivos (Scanner/PrintWriter), Asociación de Objetos, Polimorfismo.
🗂️ **Ayudantía**: Intensiva I – Sistema de Control Táctico POO
