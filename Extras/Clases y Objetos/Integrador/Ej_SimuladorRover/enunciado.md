# Ejercicio Integrador Maestro: Simulador de Robot Explorador (Mars Rover)

## 📝 Descripción
Eres el ingeniero encargado de la lógica de un Robot Explorador en Marte. El robot se mueve sobre una matriz bidimensional (la superficie marciana), gasta batería con cada acción, y no puede atravesar obstáculos ni salir de los límites del mapa. Además, debe recolectar minerales valiosos en su inventario.

Este ejercicio requiere diseñar la interacción entre **dos objetos fundamentales**: el entorno (`Superficie`) y el actor (`Rover`).

> **Contexto Académico**: Se evalúa tu capacidad de conectar todo lo aprendido: matrices (mapa espacial), arreglos (inventario), estructuras de control (movimiento y colisiones) y diseño de estado interno (batería, orientación, posición). **Duración estimada: 1 hora.**

## 🎯 Requisitos Técnicos

### 1. Clase `Superficie`
- Un atributo privado `char[][] mapa`.
- Los caracteres representan:
  - `'.'` : Terreno libre.
  - `'X'` : Obstáculo (roca).
  - `'*'` : Mineral valioso.
- Métodos para consultar si una coordenada (X,Y) está dentro de los límites y qué hay en ella.
- Método para extraer un mineral (cambia el `'*'` por un `'.'`).

### 2. Clase `Rover`
- **Atributos**: Posición (`x`, `y`), Orientación (`'N'`, `'S'`, `'E'`, `'O'`), Batería (`int`, 0 a 100), Inventario (`String[]` para máximo 3 minerales), y una referencia al objeto `Superficie`.
- **Métodos**:
  - `girarDerecha()` y `girarIzquierda()`: Cambia la orientación actual (ej. de 'N' a 'E'). Consume 1 de batería.
  - `avanzar(int casillas)`: El rover intenta moverse en su dirección actual celda por celda. Si encuentra un obstáculo o el borde del mapa, **se detiene en la celda anterior**. Cada casilla avanzada consume 5 de batería. Si la batería llega a 0, se apaga.
  - `recolectar()`: Si en su posición (X,Y) actual hay un mineral (`'*'`), lo guarda en el primer espacio vacío de su inventario. Consume 10 de batería.
  - `mostrarEstado()`: Imprime las coordenadas, orientación, batería restante y el inventario.

## 📥 Ejemplo de Flujo (en el `main`)
```java
// Mapa 5x5. Rover inicia en (0,0) mirando al 'S' (Sur). Batería: 100.
// Mapa en (2,0) tiene un '*', en (3,0) tiene una 'X'.
rover.avanzar(4); // Intenta avanzar 4 casillas hacia el Sur.
// Se detiene en (2,0) debido al obstáculo en (3,0). Batería baja 10.
rover.recolectar(); // Recoge el mineral. Batería baja 10.
rover.girarIzquierda(); // Mira al 'E'. Batería baja 1.
rover.mostrarEstado();
```

## 📤 Ejemplo de Salida Esperada
```text
[Avanzando...] Batería: 90. Detenido en (2,0). Motivo: Obstáculo detectado.
[Recolectando...] Mineral guardado. Batería: 80.
[Girando] Orientación actual: E. Batería: 79.
--- ESTADO DEL ROVER ---
Posición: (2, 0) | Orientación: E
Batería: 79%
Inventario: [Muestra 1, Vacío, Vacío]
```

---
🕓 **Dificultad**: Extrema (Integrador)
📚 **Temas**: Matrices, Arreglos, Lógica de colisión, Interacción entre objetos, Encapsulamiento.
