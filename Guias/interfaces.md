# Guía 06: Interfaces y Arquitectura de Software

En el desarrollo de software profesional, no basta con que el código funcione; debe estar organizado de manera que los cambios en una parte del sistema no rompan el resto. Aquí es donde entran las **Interfaces** y los principios de **Arquitectura**.

---

## 1. La Interfaz como Contrato
Una interfaz en Java es un tipo de referencia que define **qué** debe hacer una clase, pero no **cómo** debe hacerlo. Es un "contrato" que cualquier clase implementadora está obligada a cumplir.

- **Diferencia Clave**: Mientras que una Clase Abstracta define una identidad ("es un"), una Interfaz define un comportamiento ("puede hacer" o "actúa como").

```java
/**
 * Interfaz que define el contrato de un sistema de persistencia.
 */
public interface IPersistencia {
    /**
     * Guarda un objeto en el medio de almacenamiento.
     * @param dato El objeto a guardar.
     */
    void guardar(Object dato);
}
```

---

## 2. Desacoplamiento (Loose Coupling)
El desacoplamiento es la práctica de reducir las dependencias entre clases. Si una clase `A` depende directamente de una clase `B`, cualquier cambio en `B` afecta a `A`. 

**Solución**: Hacer que `A` dependa de una **Interfaz** en lugar de una clase concreta.

```mermaid
graph LR
    App --> ISistema
    ISistema <|.. SistemaImpl
    style ISistema fill:#f9f,stroke:#333,stroke-width:4px
```

---

## 3. Arquitectura: Separación de Lógica y Dominio
Un error común en estudiantes es mezclar la entrada de datos, la lógica de negocio y la gestión de objetos en un solo lugar. Una arquitectura limpia propone:

1.  **Modelo de Dominio**: Clases que representan los datos (ej. `Producto`, `Cliente`). No deben contener lógica de "sistema" (como leer archivos).
2.  **Lógica del Sistema (`ISistema` / `SistemaImpl`)**: Clases que coordinan las acciones. Gestionan las listas, realizan búsquedas y aplican reglas de negocio.
3.  **Clase App (Controlador)**: Contiene el `main`. Se encarga únicamente de interactuar con el usuario (menús, `Scanner`) y llamar al sistema.

---

## 4. Implementación del Patrón Arquitectónico (Ejemplo Completo)

Este es el estándar que seguiremos para desacoplar la interfaz de usuario (el menú) de la lógica de negocio (el sistema).

### Paso 1: Definir la Interfaz (`ISistema`)
```java
/**
 * Interfaz que define las operaciones permitidas por el sistema de gestión.
 */
public interface ISistema {
    void agregarElemento(String nombre);
    void mostrarElementos();
}
```

### Paso 2: Implementar la Lógica (`SistemaImpl`)
```java
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta de la lógica del sistema.
 */
public class SistemaImpl implements ISistema {
    private List<String> lista;

    public SistemaImpl() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void agregarElemento(String nombre) {
        this.lista.add(nombre);
        System.out.println("Elemento agregado con éxito.");
    }

    @Override
    public void mostrarElementos() {
        for (String e : lista) {
            System.out.println("- " + e);
        }
    }
}
```

### Paso 3: Clase App (El Menú)
```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // [ESTÁNDAR CRÍTICO]: Referencia de Interfaz = Objeto de Implementación
        ISistema sistema = new SistemaImpl(); 
        
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar | 2. Mostrar | 0. Salir");
            opcion = scan.nextInt();
            
            switch(opcion) {
                case 1:
                    sistema.agregarElemento("Ejemplo");
                    break;
                case 2:
                    sistema.mostrarElementos();
                    break;
            }
        } while (opcion != 0);
    }
}
```

---

## 5. ¿Por qué usamos `ISistema s = new SistemaImpl()`?

Esta línea es el corazón del desacoplamiento arquitectónico:
1.  **Polimorfismo**: Tratamos a un objeto específico como un concepto general.
2.  **Protección**: La clase `App` solo puede acceder a los métodos definidos en la Interfaz. Si `SistemaImpl` tiene métodos privados o adicionales, `App` no puede "verlos".
3.  **Flexibilidad**: Si mañana creamos `SistemaRemotoImpl`, solo cambiamos una línea en `App`, y el resto del menú seguirá funcionando igual.

---

**Nota Académica**: Al resolver ejercicios extras, siempre crea una interfaz para tu lógica principal. Esto demuestra una comprensión profunda de la arquitectura y eleva la calidad técnica de tu solución.
