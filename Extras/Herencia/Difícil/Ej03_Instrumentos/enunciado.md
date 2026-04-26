# Ejercicio 3: Orquesta Sinfónica

## 📝 Descripción
Modela una clase abstracta `Instrumento` con un método `tocar()`. Las subclases `Guitarra` y `Piano` deben implementar este método de forma visual (imprimiendo cómo suenan). Añade un método común `afinar()` en la clase base.

> **Contexto Académico**: Refuerza la mezcla entre métodos concretos (comunes a todos) y métodos abstractos (únicos de cada uno) dentro de una clase abstracta.

## 🎯 Objetivos de Aprendizaje
- Combinación de métodos abstractos y concretos.
- Modelado de jerarquías de dominio artístico.
- Uso de `abstract` para evitar instancias sin sentido.

## 📥 Ejemplo de Entrada
```text
Instrumentos: [Guitarra, Piano]
Acción: Afinar todos, Tocar todos
```

## 📤 Ejemplo de Salida
```text
Afinando el instrumento... Listo.
Tocando la guitarra: ¡Strum! ¡Strum!
Afinando el instrumento... Listo.
Tocando el piano: ¡Plink! ¡Plonk!
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: Métodos concretos en clases abstractas.
