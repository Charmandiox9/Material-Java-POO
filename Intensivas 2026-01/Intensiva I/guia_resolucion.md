# 📘 Guía de Resolución: Sistema de Control Táctico "Nebulosa de Orión"

Esta guía proporciona la hoja de ruta técnica y arquitectónica para resolver el ejercicio intensivo, asegurando el cumplimiento de los objetivos pedagógicos de POO, Matrices y Persistencia.

## 1. Arquitectura de Clases (`dominio`)

### A. Jerarquía de Herencia
Se debe implementar una clase base abstracta para evitar la instanciación de naves genéricas.

- **`Nave` (Clase Abstracta)**:
  - **Atributos**: `id` (String), `nombre` (String), `energia` (double), `fila` (int), `columna` (int).
  - **Métodos**:
    - `public abstract void realizarAccion()`: Método polimórfico.
    - `public void recibirImpacto(double danio)`: Implementa la lógica de reducción de energía. En `NaveSoporte`, debe considerar el `capacidadEscudo`.
    - `toString()`: Sobrescribir para mostrar información técnica y ubicación.

- **Subclases Especializadas**:
  - `NaveGuerra`: Añade `poderAtaque`. Su `realizarAccion()` simula una descarga de energía.
  - `NaveSoporte`: Añade `capacidadEscudo`. Su `realizarAccion()` puede curar a la misma nave.
  - `NaveExploracion`: Añade `rangoVisibilidad`. Su `realizarAccion()` simula un mapeo de largo alcance.

---

## 2. Controlador Lógico (`logica.ControladorTactico`)
Esta clase es el núcleo del sistema y debe gestionar tanto la colección dinámica como la estructura estática (matriz).

- **Atributos**:
  - `private List<Nave> flota`: Para gestión CRUD y búsqueda.
  - `private String[][] mapa`: Matriz de `10x10` para representación espacial.

- **Métodos Críticos**:
  1. `inicializarMapa()`: Llena la matriz con `[ . ]`.
  2. `cargarDatos(String rutaNaves, String rutaPosiciones)`:
     - **Paso 1**: Leer `naves.txt`, instanciar la subclase correcta y agregarla a `flota`.
     - **Paso 2**: Leer `posiciones.txt`. Por cada ID, buscar la nave en `flota` y actualizar sus atributos `fila` y `columna`.
     - **Paso 3**: Llamar a un método interno para actualizar la matriz con los IDs de las naves validadas.
  3. `actualizarMatriz()`: Recorre la lista de naves y coloca el ID en `mapa[fila][columna]` solo si las coordenadas son válidas (0-9).
  4. `moverNave(String id, int nuevaF, int nuevaC)`:
     - Debe limpiar la celda actual en la matriz.
     - Validar que la nueva posición esté dentro de los límites y no esté ocupada.
     - Actualizar la nave y la matriz.

---

## 3. Lógica de Interfaz (`logica.Main`)
El menú debe ser implementado con un bucle `do-while` y un `switch-case`. Se recomienda el uso de un método auxiliar para leer las entradas del usuario y evitar errores de buffer con `Scanner`.

---

## 4. Consideraciones Académicas (Puntos de Evaluación)

### A. El Cruce de Archivos
Es fundamental que el estudiante no asuma que los archivos vienen ordenados. El uso de un bucle de búsqueda (o un `Map` si se permite, aunque `ArrayList` es el estándar de la guía) para encontrar la nave por ID es un requisito de lógica esencial.

### B. El Poder del Polimorfismo
En la **Opción 5 (Maniobra de Escaneo)**, no se deben usar bloques `if (nave instanceof ...)`. El sistema debe simplemente iterar la lista y llamar a `nave.realizarAccion()`, permitiendo que cada objeto ejecute su propia implementación.

### C. Persistencia de Salida
En la **Opción 8 (Exportar Reporte)**, se debe utilizar `java.io.PrintWriter` o `FileWriter`. El formato debe ser limpio y profesional, actuando como un "Log de Misión" final.

### D. Validaciones de Matriz
Se debe prestar especial atención al manejo de índices para evitar el error `ArrayIndexOutOfBoundsException`. Cada acceso a la matriz `mapa[f][c]` debe estar precedido por una validación `if(f >= 0 && f < 10 && c >= 0 && c < 10)`.

---

## 5. Ejemplo de Flujo de Datos
- **Entrada**: Nave `N-01` en `(12, 5)`.
- **Lógica**: El sistema detecta que `12 > 9`.
- **Resultado**: La nave se agrega a la lista `flota` con energía y nombre, pero su ubicación en la matriz es nula y su estado se reporta como "FUERA_DE_RANGO".
