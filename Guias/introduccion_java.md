# Guía 01: Introducción a Java

Esta guía sienta las bases fundamentales del lenguaje Java. Más allá de la sintaxis, exploraremos la lógica detrás de sus estructuras para comprender cómo interactúan con la memoria y el flujo de ejecución de un programa.

---

## 1. El Punto de Entrada: El Método `main`
En Java, toda aplicación comienza su ejecución en un punto específico: el método `public static void main(String[] args)`.

### ¿Por qué esta firma exacta?
La Máquina Virtual de Java (JVM) busca esta firma al iniciar un programa por las siguientes razones:
- **`public`**: Permite que la JVM acceda al método desde fuera de la clase.
- **`static`**: Permite que el método se ejecute sin necesidad de crear un objeto de la clase primero. Al arrancar el programa, aún no existen objetos en memoria.
- **`void`**: Indica que el método no devuelve ningún valor tras finalizar.
- **`String[] args`**: Es un arreglo que permite recibir parámetros desde la línea de comandos.

```java
public class HolaMundo {
    /**
     * Punto de entrada principal de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // System.out es un flujo de salida estándar (consola)
        System.out.println("¡Hola, Java!");
    }
}
```

---

## 2. Tipado Fuerte y Variables
Java es un lenguaje de **tipado estático y fuerte**. Esto significa que el tipo de una variable se conoce en tiempo de compilación y no puede cambiar, lo que previene errores lógicos graves.

### Categorías de Datos
1. **Primitivos**: Almacenan el valor directamente en la memoria. Son rápidos y eficientes.
   - `int`: Enteros (ej. 10).
   - `double`: Decimales (ej. 3.14).
   - `boolean`: Lógicos (`true`/`false`).
   - `char`: Un carácter (ej. 'A').
2. **De Referencia**: Almacenan la dirección de memoria donde se encuentra el objeto (ej. `String`, `Scanner`).

```java
int edad = 20;               // Entero
double precio = 15.50;       // Decimal
boolean esEstudiante = true; // Valor lógico
String nombre = "Juan";      // Objeto de texto
```

---

## 3. Operadores
Permiten realizar manipulaciones sobre los datos:
- **Aritméticos**: `+`, `-`, `*`, `/`, `%` (módulo).
- **Relacionales**: `==`, `!=`, `>`, `<`, `>=`, `<=`.
- **Lógicos**: `&&` (AND), `||` (OR), `!` (NOT).

---

## 4. Estructuras de Control de Flujo

### Condicionales
Permiten tomar decisiones basadas en condiciones booleanas.

```java
// if-else: Evaluación por rangos
int nota = 85;
if (nota >= 90) {
    System.out.println("Excelente");
} else if (nota >= 70) {
    System.out.println("Aprobado");
} else {
    System.out.println("Reprobado");
}

// switch: Selección de opciones específicas
int dia = 3;
switch (dia) {
    case 1: System.out.println("Lunes"); break;
    case 3: System.out.println("Miércoles"); break;
    default: System.out.println("Otro día");
}
```

### Ciclos o Bucles
Permiten repetir un bloque de código según una condición.

- **`for`**: Ideal cuando conocemos la cantidad exacta de iteraciones.
- **`while`**: Se usa cuando la repetición depende de una condición evaluada **antes** del bloque.
- **`do-while`**: Garantiza que el código se ejecute **al menos una vez**, ya que la condición se evalúa al final.

```java
// Ejemplo do-while para Menú
int opcion;
Scanner scan = new Scanner(System.in);
do {
    System.out.println("1. Procesar | 0. Salir");
    opcion = scan.nextInt();
} while (opcion != 0);
```

---

## 5. Arreglos y Matrices: Memoria Estática
Los arreglos son objetos de **tamaño fijo** que almacenan elementos de forma contigua en memoria.

### ¿Por qué declarar el tamaño?
1. **Eficiencia**: El acceso mediante índices es instantáneo ($O(1)$).
2. **Seguridad**: Java reserva un bloque exacto de memoria para evitar sobreescribir datos adyacentes.

```java
// Vector (1D)
int[] calificaciones = new int[5]; 

// Matriz (2D)
int[][] tablero = new int[3][3];
```

---

## 6. Procesamiento de Datos

### Ordenamiento Burbuja (BubbleSort)
Algoritmo académico para entender la lógica de comparación e intercambio.

```java
int[] numeros = {64, 34, 25, 12, 22};
int n = numeros.length;

for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        if (numeros[j] > numeros[j + 1]) {
            int temp = numeros[j];
            numeros[j] = numeros[j + 1];
            numeros[j + 1] = temp;
        }
    }
}
```

### Recorrido de Matrices
Uso de ciclos anidados para procesar estructuras bidimensionales.

```java
int[][] matriz = {{1, 2}, {3, 4}};
int suma = 0;

for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        suma += matriz[i][j];
    }
}
```

---

## 7. Entrada y Salida (I/O)
Uso de la clase `Scanner` para interactuar con la consola.

```java
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Edad: ");
        int edad = scan.nextInt();
        scan.close();
    }
}
```

---
**Nota Académica**: Los arreglos son inmutables en tamaño. Para estructuras dinámicas, estudiaremos las *Colecciones* en la Guía 04.
