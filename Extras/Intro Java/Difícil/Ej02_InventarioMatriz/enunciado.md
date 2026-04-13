# Ejercicio 2: Sistema de Inventario Avanzado (Matrices)

## 📝 Descripción
Un centro de distribución necesita gestionar el stock de sus productos de manera eficiente. Debes desarrollar un programa que utilice una **matriz de 2 columnas** para representar el inventario:
- **Columna 0**: ID del producto (número entero).
- **Columna 1**: Cantidad en stock (número entero).

El programa debe permitir al usuario:
1. Registrar un conjunto inicial de productos.
2. Realizar "Ventas" (restar stock) validando que exista suficiente disponibilidad.
3. Realizar "Abastecimiento" (sumar stock) buscando el producto por su ID.
4. Mostrar el inventario completo.

> **Contexto Académico**: Este ejercicio simula una base de datos relacional simple mediante el uso de matrices, reforzando la búsqueda lineal y la actualización selectiva de datos en estructuras bidimensionales.

## 🎯 Objetivos de Aprendizaje
- Gestión de matrices con diferentes propósitos por columna.
- Implementación de algoritmos de búsqueda para actualización de datos.
- Validación de integridad de datos (stock no negativo).
- Desarrollo de menús interactivos complejos asociados a estructuras de datos.

## 📥 Ejemplo de Entrada
```text
Cantidad de productos a registrar: 2
ID 1: 101, Stock: 50
ID 2: 202, Stock: 30

Menú:
1. Venta | 2. Abastecer | 3. Ver | 0. Salir
Opción: 1
ID Producto: 101
Cantidad a vender: 10
```

## 📤 Ejemplo de Salida
```text
Venta exitosa. Stock restante de 101: 40
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: Matrices de 2 dimensiones, Búsqueda, Validación de Datos.
