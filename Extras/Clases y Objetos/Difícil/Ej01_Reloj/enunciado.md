# Ejercicio 1: Reloj Digital 24h

## 📝 Descripción
Implementa una clase `Reloj` que simule el comportamiento de un reloj digital en formato de 24 horas. El reloj debe ser capaz de avanzar un segundo a la vez y ajustar automáticamente los minutos y las horas cuando corresponda.

> **Contexto Académico**: Este ejercicio requiere el manejo de desbordamientos numéricos (rollover). Cuando los segundos llegan a 60, se reinician y aumentan los minutos, y así sucesivamente con las horas al llegar a 24.

## 🎯 Objetivos de Aprendizaje
- Lógica de control para el paso del tiempo.
- Encapsulamiento de múltiples atributos interdependientes.
- Formateo de salida con ceros a la izquierda (ej. "08:05:09").

## 📥 Ejemplo de Entrada
```text
Hora inicial: 23:59:58
Acción: Avanzar 1 segundo
Acción: Avanzar 1 segundo
```

## 📤 Ejemplo de Salida
```text
Hora: 23:59:59
Hora: 00:00:00 (Reinicio de ciclo)
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: Lógica de desbordamiento, Formateo de Strings.
