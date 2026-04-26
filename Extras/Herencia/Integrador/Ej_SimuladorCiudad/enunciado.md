# Ejercicio Integrador Maestro: Simulador de Gestión de Ciudad (Mini SimCity)

## 📝 Descripción
Deberás construir el motor lógico (motor de turnos) para un juego de gestión de ciudad. La ciudad posee diferentes tipos de **edificios** que interactúan mediante un presupuesto monetario y una red eléctrica global. Al final de cada día (turno), el sistema debe encender los edificios, cobrar sus mantenimientos y recaudar impuestos.

Este ejercicio exige dominar la manipulación de **arreglos de superclases**, el uso de **clases abstractas** para obligar a las subclases a implementar lógicas de negocio, y el manejo de recursos compartidos (Presupuesto y Energía).

> **Contexto Académico**: Se evalúa la comprensión profunda de la **Herencia**, el **Polimorfismo** (resolución dinámica de métodos durante el ciclo de actualización) y la manipulación segura del estado (evitar sobregiros). **Duración estimada: 1 hora.**

## 🎯 Requisitos Técnicos

### 1. Clase Abstracta `Edificio`
- **Atributos:** `nombre`, `costoMantenimiento`, `consumoEnergia` (puede ser negativo si produce), `encendido` (boolean).
- **Método Abstracto:** `public abstract double procesarTurno()`. Debe devolver la cantidad de dinero (impuestos o ventas) que genera en ese turno.

### 2. Subclases de Edificios
- `EdificioResidencial`: Atributo adicional `habitantes`. Si está encendido, en `procesarTurno()` retorna `habitantes * 10.0` (impuestos).
- `EdificioComercial`: Atributo `ventasDiarias`. Si está encendido, retorna `ventasDiarias * 0.15` (15% de impuestos).
- `PlantaElectrica`: Su consumo de energía es *negativo* (produce energía). En `procesarTurno()` retorna `0.0` (las plantas no pagan impuestos, son del estado).

### 3. Clase `Ciudad` (El Administrador)
- **Atributos:** Arreglo `Edificio[] edificios`, contador de edificios actuales, `double presupuesto`, `int energiaDisponible`.
- **Método `avanzarDia()`**: 
  Este método debe ejecutar las siguientes fases en orden:
  1. **Generación de Energía:** Recorrer todos los edificios y sumar la energía de las Plantas Eléctricas (los que tienen `consumoEnergia < 0`) a `energiaDisponible`.
  2. **Consumo de Energía:** Recorrer los demás edificios. Si `energiaDisponible >= consumoEnergia`, se enciende el edificio y se resta la energía. Si no alcanza, el edificio se apaga (`encendido = false`).
  3. **Mantenimiento y Recaudación:** Por cada edificio encendido, se resta su `costoMantenimiento` al presupuesto de la ciudad. Si el presupuesto queda en negativo, la ciudad quiebra y el edificio se apaga forzosamente. Luego, se suma al presupuesto lo que devuelva el método sobrescrito `procesarTurno()`.
  4. Imprimir un reporte del día.

## 📤 Salida Esperada al Simular Turnos
Al probar con una planta, 1 residencial y 2 comerciales, y luego ir avanzando los días, el sistema debe informar quién no pudo encender por falta de energía o quién generó qué cantidad de impuestos.

---
🕓 **Dificultad**: Extrema (Integrador)
📚 **Temas**: Clases abstractas, Polimorfismo, Enlace dinámico, Máquinas de estado.
