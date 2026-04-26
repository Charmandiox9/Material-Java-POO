# Ejercicio 2: Simulador de Ascensor

## 📝 Descripción
Diseña una clase `Ascensor` que gestione el movimiento entre pisos de un edificio. El ascensor tiene un límite de pisos (mínimo y máximo) y una capacidad máxima de personas. No debe moverse si el peso/capacidad se excede.

> **Contexto Académico**: Se enfoca en la gestión de restricciones físicas representadas mediante software y el cambio de estado condicional complejo.

## 🎯 Objetivos de Aprendizaje
- Gestión de estados booleanos (puertas abiertas/cerradas).
- Validación de múltiples restricciones simultáneas.
- Simulación de comportamientos mecánicos.

## 📥 Ejemplo de Entrada
```text
Pisos: 0 al 10, Capacidad: 5 personas
Estado inicial: Piso 0, 0 personas
Acción: Subir 6 personas (Error esperado)
Acción: Subir 3 personas, Ir al piso 12 (Error esperado)
Acción: Subir 3 personas, Ir al piso 5 (Éxito)
```

## 📤 Ejemplo de Salida
```text
Error: Capacidad excedida.
Error: El piso 12 no existe.
Ascensor llegando al piso 5... Puertas abiertas.
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: Restricciones de estado, Atributos de configuración.
