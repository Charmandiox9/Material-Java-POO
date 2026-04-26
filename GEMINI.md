# Reglas para Gemini - Material Java POO

Este archivo define las directrices y limitaciones que Gemini debe seguir al redactar y desarrollar soluciones para los ejercicios extras en este repositorio.

## 1. Alcance Técnico (Carpeta `Guias/`)
Gemini solo debe utilizar conceptos, herramientas y características de Java que estén explícitamente permitidos en los tópicos de la carpeta `Guias/`. Dado que los archivos pueden estar vacíos, se asume que los **títulos de los archivos** representan los tópicos permitidos:

- **introduccion_java.md**: Sintaxis básica, tipos de datos, operadores, estructuras de control (if-else, switch-case, for, while, do-while), arreglos (vectores) y matrices.
- **uml.md**: Modelado de diagramas de clase.
- **poo.md**: Clases, objetos, herencia, polimorfismo, encapsulamiento, abstracción y interfaces.
- **colecciones.md**: Uso de colecciones estándar (principalmente `ArrayList`, `List`).
- **documentacion.md**: Uso de JavaDoc y comentarios claros.
- **patrones.md**: Patrones de diseño específicos (Singleton, Factory, Strategy, Visitor).
- **gui.md**: Desarrollo de interfaces gráficas (Swing).
- **frameworks.md**: Frameworks específicos mencionados en esta guía (si los hay).

## 2. Restricciones de Desarrollo
- **Versión de Java**: Mantener un estilo de Java "clásico" (Java 8/11). Evitar características modernas como `Streams`, `Lambdas`, `Optional`, `Records`, `Sealed Classes` o `Text Blocks`, a menos que se agreguen explícitamente a las guías.
- **Entrada/Salida**: Utilizar `java.util.Scanner` para entrada por consola y `java.io.File` / `java.io.PrintWriter` / `Scanner` para archivos de texto.
- **Librerías Externas**: No utilizar librerías externas (como Jackson, Gson, Lombok, JUnit, etc.) a menos que se especifique en `frameworks.md`.
- **Manejo de Excepciones**: Utilizar bloques `try-catch` tradicionales y excepciones personalizadas cuando el ejercicio lo requiera.

## 3. Estructura de Carpetas (Extras)
Todos los ejercicios nuevos en la carpeta `Extras/` deben seguir obligatoriamente esta jerarquía:
1. **Tópico**: Carpeta con el nombre del tema (ej. `Herencia`).
2. **Categoría**: Subcarpetas por nivel de dificultad: `Fácil`, `Intermedio`, `Difícil`, `Integrador`.
3. **Ejercicio**: Carpeta con el prefijo `EjXX_Nombre` (ej. `Ej01_Vehiculos`).
4. **Contenido**: Dentro de la carpeta del ejercicio debe existir:
   - `enunciado.md`: Descripción detallada del problema.
   - `Solucion.java`: El código fuente completo (incluyendo el `main` de prueba).

## 4. Formato Estándar de Enunciados (`enunciado.md`)
Los enunciados deben ser visualmente atractivos y seguir esta estructura estricta:
- **Título**: `# Ejercicio X: Nombre del Ejercicio`
- **📝 Descripción**: Contexto realista del problema y qué se debe programar. Incluir un bloque `> **Contexto Académico**` explicando por qué es importante.
- **🎯 Objetivos de Aprendizaje**: Lista de puntos técnicos que el alumno reforzará.
- **📥 Ejemplo de Entrada**: Bloque de código `text` con los datos sugeridos.
- **📤 Ejemplo de Salida**: Bloque de código `text` con el resultado esperado por consola.
- **Footer**: Separador `---` seguido de:
  - 🕓 **Dificultad**: [Fácil/Intermedio/Difícil/Integrador]
  - 📚 **Temas**: [Lista de tags]

## 5. Estilo y Convenciones de Código
- **Nomenclatura**: Seguir las convenciones de Java (camelCase para variables/métodos, PascalCase para clases, UPPER_SNAKE_CASE para constantes).
- **Documentación JavaDoc**: Todas las clases, interfaces, atributos y métodos (públicos y protegidos) deben incluir bloques JavaDoc (`/** ... */`) detallando su propósito, parámetros (`@param`) y valores de retorno (`@return`).
- **Comentarios Explicativos**: El código debe incluir comentarios internos (`//`) que expliquen la lógica compleja.
- **Idioma**: Toda la documentación, enunciados y comentarios deben estar en **español**.

## 6. Proceso de Resolución (Enfoque Académico)
1. **Análisis Pedagógico**: La solución debe diseñarse para enseñar un concepto específico.
2. **Dificultad Incremental**: Dentro de una misma categoría, la dificultad debe subir ligeramente. Entre categorías debe haber un salto conceptual claro.
3. **Ejercicios Integradores**: Deben ser retos de alta complejidad (duración estimada 1h) que combinen el tópico actual con conocimientos de tópicos anteriores (ej. Herencia + Matrices).

---
*Nota: Este documento es la verdad absoluta para la generación de contenido por parte de la IA.*
