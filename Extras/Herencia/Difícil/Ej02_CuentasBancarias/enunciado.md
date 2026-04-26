# Ejercicio 2: Cuentas Ahorro y Corriente

## 📝 Descripción
Crea una clase abstracta `Cuenta` con saldo y titular. Deriva `CuentaAhorro` (con un interés anual que se aplica al saldo) y `CuentaCorriente` (permite un sobregiro o saldo negativo hasta un límite). 

> **Contexto Académico**: Este ejercicio muestra cómo la herencia permite modelar comportamientos financieros opuestos (ganar intereses vs permitir deudas) bajo una misma base estructural.

## 🎯 Objetivos de Aprendizaje
- Gestión de estados financieros complejos.
- Uso de atributos protegidos para cálculos en subclases.
- Validación de límites específicos (sobregiro).

## 📥 Ejemplo de Entrada
```text
Ahorro: Saldo $1000, Interés 5% -> Aplicar
Corriente: Saldo $500, Límite Sobregiro -$200 -> Retirar $600
```

## 📤 Ejemplo de Salida
```text
Nuevo saldo ahorro con intereses: $1050.0
Retiro exitoso de cuenta corriente. Saldo: -$100.0
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: Abstracción, Lógica Bancaria.
