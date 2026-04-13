# Guía 07: Patrones de Software

Los Patrones de Diseño son soluciones probadas para problemas recurrentes. En un contexto académico, su uso demuestra una transición de "simplemente programar" a "diseñar arquitectura de software".

---

## 1. Patrón Singleton (Creacional)
**Propósito**: Garantizar una única instancia global de una clase.
- **Uso**: Gestores de configuración, conexiones únicas o logs.
- **Clave**: Constructor privado y método estático `getInstancia()`.

---

## 2. Patrón Factory (Creacional)
**Propósito**: Delegar la responsabilidad de la instanciación a una clase especializada ("La Fábrica").

### ¿Por qué usarlo?
Si tu aplicación crea muchos tipos de objetos que comparten una interfaz (ej. diferentes tipos de Notificaciones), usar `new` en toda la aplicación dispersa la lógica. Si el nombre de una clase cambia o se añade un nuevo tipo, tendrías que modificar muchos archivos. Con Factory, solo modificas la Fábrica.

### Ejemplo: Sistema de Notificaciones
```java
/**
 * Interfaz común para todos los productos de la fábrica.
 */
public interface INotificacion {
    void enviar(String mensaje);
}

/**
 * La Fábrica encapsula la lógica de creación.
 */
public class NotificacionFactory {
    /**
     * Crea una notificación basada en el tipo solicitado.
     * @param tipo "SMS" o "EMAIL".
     * @return El objeto concreto que implementa INotificacion.
     */
    public INotificacion crearNotificacion(String tipo) {
        if (tipo.equalsIgnoreCase("SMS")) {
            return new NotificacionSMS();
        } else if (tipo.equalsIgnoreCase("EMAIL")) {
            return new NotificacionEmail();
        }
        throw new IllegalArgumentException("Tipo desconocido");
    }
}
```

---

## 3. Patrón Strategy (Comportamiento)
**Propósito**: Definir una familia de algoritmos, encapsular cada uno y hacerlos intercambiables en tiempo de ejecución.

### ¿Por qué usarlo?
Evita el uso de condicionales masivos (`if-else` o `switch` gigantes) dentro de tu lógica de negocio. En lugar de que una clase "sepa cómo hacer todo", ella "tiene un objeto" que sabe cómo hacer esa tarea específica.

### Ejemplo: Cálculo de Descuentos
```java
/**
 * Interfaz de la Estrategia.
 */
public interface IDescuentoStrategy {
    double aplicarDescuento(double total);
}

/**
 * Clase Contexto que utiliza la estrategia.
 */
public class Venta {
    private double monto;
    private IDescuentoStrategy estrategia; // Composición

    public void setEstrategia(IDescuentoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularTotal() {
        // La lógica de cálculo se delega a la estrategia actual
        return estrategia.aplicarDescuento(this.monto);
    }
}

// Implementaciones concretas
public class DescuentoNavidad implements IDescuentoStrategy {
    @Override public double aplicarDescuento(double t) { return t * 0.5; }
}
public class SinDescuento implements IDescuentoStrategy {
    @Override public double aplicarDescuento(double t) { return t; }
}
```

---

## 4. Patrón Visitor (Comportamiento)
**Propósito**: Separar un algoritmo de la estructura de objetos sobre la que opera. Permite añadir nuevas operaciones sin modificar las clases de dichos objetos.

### ¿Por qué usarlo?
Si tienes una jerarquía de clases fija (ej. `Circulo`, `Cuadrado`) y quieres añadirles constantemente nuevas funciones (ej. `ExportarAXml`, `CalcularPerimetro`, `Dibujar`), en lugar de modificar cada clase cada vez, creas un "Visitante" que sabe cómo procesar cada tipo.

### Ejemplo: Reporte de Formas Geométricas
```java
/**
 * Interfaz que deben implementar los elementos visitables.
 */
public interface IForma {
    void accept(IVisitor visitor);
}

/**
 * Interfaz del Visitante con un método para cada tipo concreto.
 */
public interface IVisitor {
    void visit(Circulo c);
    void visit(Cuadrado c);
}

/**
 * Elemento concreto.
 */
public class Circulo implements IForma {
    private double radio;
    
    @Override
    public void accept(IVisitor visitor) {
        // Doble despacho: el círculo le dice al visitante "procésame como círculo"
        visitor.visit(this);
    }
    public double getRadio() { return radio; }
}

/**
 * Operación externa (Visitante) que calcula el área.
 */
public class CalculadorArea implements IVisitor {
    @Override
    public void visit(Circulo c) {
        double area = Math.PI * Math.pow(c.getRadio(), 2);
        System.out.println("Área Círculo: " + area);
    }
    @Override
    public void visit(Cuadrado c) { /* lógica para cuadrado */ }
}
```

---

## 5. Resumen de Aplicación
1.  **Singleton**: "Pueden llamarme las veces que quieran, pero no crearme cuando quieran".
2.  **Factory**: "No sé qué objeto necesito hasta que el usuario elija una opción".
3.  **Strategy**: "Sé qué objeto tengo, pero quiero cambiar CÓMO se comporta dinámicamente".
4.  **Visitor**: "Tengo mis objetos listos y no quiero tocarlos más, pero necesito sacarles nuevos reportes".

---

**Nota Académica**: Al implementar estos patrones, recuerda siempre usar **Interfaces** como tipos de referencia. Esto permite que el sistema sea extensible: añadir un nuevo `IDescuentoStrategy` no requiere cambiar la clase `Venta`.
