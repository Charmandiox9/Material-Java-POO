# Ejercicio 1: Gestor de Playlist Pro

## 📝 Descripción
Diseña un sistema para gestionar una lista de reproducción. Debes permitir:
1. Agregar canciones al final.
2. Mover una canción de una posición a otra (intercambio).
3. Eliminar canciones que contengan una palabra prohibida (ej: "remix").
4. Invertir el orden de la lista completa.

> **Contexto Académico**: Se enfoca en la manipulación estructural de la lista (mover elementos) y en la eliminación segura mientras se itera, lo cual es un reto común en programación.

## 🎯 Objetivos de Aprendizaje
- Uso de `Collections.swap()` o intercambio manual.
- Eliminación de elementos durante el recorrido (evitando `ConcurrentModificationException`).
- Inversión de colecciones con `Collections.reverse()`.

## 📥 Ejemplo de Entrada
```text
Playlist: ["Song A", "Song B", "Song C (remix)", "Song D"]
Acción: Mover Song B (pos 1) a pos 3.
Acción: Eliminar "remix".
```

## 📤 Ejemplo de Salida
```text
Playlist Final: ["Song D", "Song B", "Song A"] (invertida tras operaciones)
```

---
🕓 **Dificultad**: Difícil
📚 **Temas**: swap(), reverse(), Eliminación segura.
