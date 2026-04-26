# Ejercicio 2: Gestión de Cuenta Bancaria

## 📝 Descripción
Crea un sistema para gestionar una cuenta bancaria simple. El sistema debe permitir depósitos y retiros, manteniendo un registro del saldo actual. Sin embargo, no se puede retirar más dinero del que hay disponible.

> **Contexto Académico**: Introduce la lógica de negocio donde un método depende de múltiples atributos y condiciones de estado.

## 🎯 Objetivos de Aprendizaje
- Control de flujos financieros básicos.
- Protección de la integridad del saldo (evitar saldos negativos no autorizados).
- Simulación de transacciones reales.

## 📥 Ejemplo de Entrada
```text
Titular: "Juan Pérez", Saldo Inicial: 1000.0
Operación: Retirar 1200.0
Operación: Depositar 500.0
Operación: Retirar 300.0
```

## 📤 Ejemplo de Salida
```text
Error: Fondos insuficientes para retirar $1200.0
Depósito exitoso. Nuevo saldo: $1500.0
Retiro exitoso. Nuevo saldo: $1200.0
```

---
🕓 **Dificultad**: Intermedio
📚 **Temas**: Lógica de Negocio, Estado del Objeto.
