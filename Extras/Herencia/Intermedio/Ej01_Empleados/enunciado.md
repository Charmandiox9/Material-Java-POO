# Ejercicio 1: Nómina de Empleados

## 📝 Descripción
Desarrolla una clase `Empleado` con nombre y salario base. Crea dos subclases: `Vendedor` (recibe una comisión por ventas) y `Repartidor` (recibe un bono si tiene menos de 25 años). Ambas deben sobrescribir un método para calcular el salario final.

> **Contexto Académico**: Introduce la sobrescritura de métodos (`@Override`). Cada subclase tiene una lógica distinta para determinar su ingreso total basándose en sus propios atributos.

## 🎯 Objetivos de Aprendizaje
- Uso de la anotación `@Override`.
- Lógica condicional dentro de métodos sobrescritos.
- Diferenciación de comportamiento entre subclases.

## 📥 Ejemplo de Entrada
```text
Vendedor: "Carlos", Salario: $1000, Comisión: $200
Repartidor: "Dani", Salario: $1000, Edad: 22 (Aplica bono de $100)
```

## 📤 Ejemplo de Salida
```text
Salario de Carlos: $1200.0
Salario de Dani: $1100.0
```

---
🕓 **Dificultad**: Intermedio
📚 **Temas**: Sobrescritura (@Override), Polimorfismo.
