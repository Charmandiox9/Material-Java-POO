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

## 3. Estilo y Convenciones
- **Nomenclatura**: Seguir las convenciones de Java (camelCase para variables/métodos, PascalCase para clases, UPPER_SNAKE_CASE para constantes).
- **Documentación JavaDoc**: Todas las clases, interfaces, atributos y métodos (públicos y protegidos) deben incluir bloques JavaDoc (`/** ... */`) detallando su propósito, parámetros (`@param`) y valores de retorno (`@return`).
- **Comentarios Explicativos**: El código debe incluir comentarios internos (`//`) que expliquen la lógica de bloques complejos, justifiquen decisiones de diseño o aclaren el uso de conceptos de POO.
- **Estructura de Archivos**: Los ejercicios deben seguir la estructura definida en el `README.md` (enunciado, solución, datos, diagrama).
- **Idioma**: Toda la documentación, enunciados y comentarios deben estar en **español**, manteniendo la consistencia con el repositorio.

## 4. Proceso de Resolución (Enfoque Académico)
Antes de proponer o implementar una solución a un ejercicio extra:
1. **Análisis Pedagógico**: La solución debe diseñarse para enseñar un concepto específico (ej. "Cómo aplicar polimorfismo en un sistema de pagos").
2. **Redacción de Enunciados**: Deben ser claros, con un contexto realista y objetivos de aprendizaje explícitos.
3. **Desarrollo Explicativo**: La solución no debe ser solo "código que funciona", sino "código que explica". Se debe priorizar la claridad y la correcta aplicación de los principios de diseño (SOLID, GRASP) sobre la optimización extrema o el uso de trucos sintácticos.
4. **Validación**: Consultar la carpeta `Guias/` y ejemplos existentes para alinear el nivel de complejidad.

---
*Nota: Si una guía en `Guias/` está vacía, Gemini debe limitar el uso de ese tópico a sus conceptos fundamentales de POO.*
