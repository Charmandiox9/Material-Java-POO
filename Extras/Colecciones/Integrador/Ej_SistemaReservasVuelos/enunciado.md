# Ejercicio Integrador Maestro: Sistema de Reservas de Vuelos

## 📝 Descripción
Eres el desarrollador de un sistema de reservas para una aerolínea. Debes gestionar una flota de vuelos, cada uno con una lista de pasajeros. El sistema debe ser capaz de procesar reservas, cancelaciones y generar reportes financieros complejos.

Este ejercicio requiere manejar una **lista de objetos complejos**, donde uno de los atributos de cada objeto es **otra lista**.

> **Contexto Académico**: Se evalúa la capacidad de gestionar colecciones anidadas de objetos, realizar búsquedas por múltiples criterios (ej. buscar un pasajero en todos los vuelos) y mantener la integridad de los datos durante las cancelaciones. **Duración estimada: 1 hora.**

## 🎯 Requisitos Técnicos

### 1. Clase `Pasajero`
- Atributos: `nombre`, `pasaporte`, `edad`.

### 2. Clase `Vuelo`
- Atributos: `codigoVuelo`, `destino`, `capacidadMaxima`, `precioPasaje`, y una `ArrayList<Pasajero> pasajeros`.
- Métodos:
  - `reservar(Pasajero p)`: Agrega al pasajero si hay capacidad. Retorna boolean.
  - `cancelar(String pasaporte)`: Busca al pasajero por pasaporte y lo elimina.
  - `calcularIngresos()`: Retorna el total recaudado por el vuelo.

### 3. Clase `Aerolinea` (El Administrador)
- Atributos: `ArrayList<Vuelo> vuelos`.
- Métodos:
  - `buscarPasajero(String pasaporte)`: Recorre todos los vuelos y muestra en cuál(es) está registrado el pasajero.
  - `vueloMasRentable()`: Retorna el código del vuelo que ha generado más dinero.
  - `generarReporteOcupacion()`: Muestra cada vuelo, su destino y el porcentaje de ocupación (pasajeros actuales / capacidad).

## 📥 Ejemplo de Flujo (en el `main`)
```java
// Crear Aerolínea con 2 vuelos (Santiago y Lima)
// Agregar 3 pasajeros al vuelo de Santiago.
// Agregar 1 pasajero al vuelo de Lima.
aerolinea.buscarPasajero("P123"); // "El pasajero está en el vuelo SCL-101"
aerolinea.vueloMasRentable(); // "El vuelo más rentable es LIM-202 con $..."
```

## 📤 Ejemplo de Salida Esperada
```text
=== REPORTE DE OCUPACIÓN ===
Vuelo: SCL-101 | Destino: Santiago | Ocupación: 75.0%
Vuelo: LIM-202 | Destino: Lima | Ocupación: 40.0%

Pasajero P123 encontrado en: Vuelo SCL-101 hacia Santiago.
El vuelo más rentable es: SCL-101 ($1500.0)
```

---
🕓 **Dificultad**: Extrema (Integrador)
📚 **Temas**: Colecciones anidadas, Algoritmos de búsqueda cruzada, Lógica de reportes, Encapsulamiento.
