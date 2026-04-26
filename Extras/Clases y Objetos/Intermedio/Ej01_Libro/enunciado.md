# Ejercicio 1: Biblioteca Personal

## 📝 Descripción
Desarrolla una clase que represente un Libro. A diferencia de los ejercicios básicos, aquí debemos asegurar que los datos ingresados sean válidos. Por ejemplo, el número de páginas no puede ser negativo y el ISBN debe tener un formato específico (aunque sea simulado).

> **Contexto Académico**: Refuerza el concepto de encapsulamiento mediante el uso de Getters y Setters con validaciones lógicas antes de modificar el estado.

## 🎯 Objetivos de Aprendizaje
- Implementación rigurosa de Getters y Setters.
- Validación de datos dentro de los métodos Setter.
- Uso de constructores que aprovechan los setters para validar.

## 📥 Ejemplo de Entrada
```text
Título: "Cien años de soledad"
Autor: "Gabriel García Márquez"
Páginas: -50 (Debe fallar o asignar 0)
ISBN: "978-0307474728"
```

## 📤 Ejemplo de Salida
```text
Error: El número de páginas no puede ser negativo.
Libro: Cien años de soledad | Autor: G.G. Márquez | Páginas: 0
```

---
🕓 **Dificultad**: Intermedio
📚 **Temas**: Encapsulamiento, Validación, Setters/Getters.
