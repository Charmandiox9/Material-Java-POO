# Ejercicio Integrador: Sistema de Gestión de Reservas de Cine

## 📝 Descripción
Un cine local te ha contratado para desarrollar la lógica de su nuevo sistema de reservas de asientos. La sala de cine se representa como una **matriz de 5 filas por 5 columnas** (25 asientos en total). 

El sistema debe manejar diferentes tipos de tarifas, las cuales están almacenadas en un **vector de precios**:
- Índice 0: General ($5.000)
- Índice 1: Estudiante ($3.500)
- Índice 2: Tercera Edad ($3.000)

Debes implementar un menú interactivo continuo con las siguientes opciones:
1. **Mostrar Sala**: Imprimir la matriz indicando asientos Libres (`L`) y Ocupados (`X`).
2. **Reservar Asiento**: Solicitar fila y columna. Validar que existan y que el asiento esté libre. Luego, preguntar el tipo de tarifa y acumular la ganancia.
3. **Cancelar Reserva**: Solicitar fila y columna. Validar y liberar el asiento (no se resta ganancia por simplicidad de política del cine).
4. **Resumen de Ventas**: Mostrar cuántos asientos están ocupados, cuántos libres y el total de dinero recaudado en la sesión.
5. **Salir**.

> **Contexto Académico**: Este es el desafío final de Introducción a Java. Requiere dominar el acceso a índices de matrices y vectores simultáneamente, además de mantener un flujo de ejecución validado y robusto mediante menús y condicionales anidados.

## 🎯 Objetivos de Aprendizaje
- Integración de todas las estructuras de control (`do-while`, `switch`, `if-else`, `for`).
- Gestión simultánea de estado en Vectores (precios) y Matrices (asientos).
- Validación robusta de rangos (evitar `ArrayIndexOutOfBoundsException`).
- Acumulación de variables persistentes durante el ciclo de vida del programa.

## 📥/📤 Ejemplo de Ejecución Esperada
```text
=== SISTEMA DE CINE ===
1. Mostrar Sala
2. Reservar Asiento
3. Cancelar Reserva
4. Resumen de Ventas
0. Salir
Opción: 1

[L][L][L][L][L]
[L][L][L][L][L]
[L][L][L][L][L]
...

Opción: 2
Fila (0-4): 2
Columna (0-4): 2
Tipo de entrada (0: General, 1: Estudiante, 2: Tercera Edad): 1
¡Reserva exitosa! Se han cobrado $3500.

Opción: 4
Asientos Ocupados: 1
Asientos Libres: 24
Recaudación Total: $3500.0
```

---
🕓 **Dificultad**: Integrador (Extrema)
📚 **Temas**: Variables, Condicionales, Ciclos, Vectores, Matrices, Lógica de Negocio.
