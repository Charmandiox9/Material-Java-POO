# Ejercicio 1: Pasarela de Pagos

## 📝 Descripción
Diseña una clase abstracta `MetodoPago` con un método abstracto `procesarPago(double monto)`. Implementa dos subclases: `TarjetaCredito` (aplica un recargo del 5%) y `Efectivo` (aplica un descuento del 10%). 

> **Contexto Académico**: Las clases abstractas definen un "contrato" que las subclases deben cumplir. En este caso, no existe un "pago genérico", siempre debe ser a través de un método específico.

## 🎯 Objetivos de Aprendizaje
- Definición de clases abstractas (`abstract`).
- Implementación obligatoria de métodos abstractos.
- Lógica de negocio diferenciada por tipo de pago.

## 📥 Ejemplo de Entrada
```text
Pago Tarjeta: $1000
Pago Efectivo: $1000
```

## 📤 Ejemplo de Salida
```text
Procesando tarjeta: $1000 + $50 comisión. Total: $1050.0
Procesando efectivo: $1000 - $100 descuento. Total: $900.0
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: Clases Abstractas, Métodos Abstractos.
