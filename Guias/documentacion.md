# Guía 05: Documentación en Java

La documentación es una parte fundamental de la ingeniería de software. No solo ayuda a otros desarrolladores a entender tu código, sino que también permite generar manuales técnicos automáticos y facilita el mantenimiento a largo plazo.

---

## 1. Comentarios Internos vs. JavaDoc
En Java, existen dos tipos principales de documentación dentro del código:

| Tipo | Sintaxis | Propósito |
| :--- | :--- | :--- |
| **Comentario Interno** | `//` o `/* ... */` | Explicar lógica compleja dentro de un método para el programador. |
| **JavaDoc** | `/** ... */` | Documentar la API (clases, métodos, atributos) para el usuario del código. |

---

## 2. El Estándar JavaDoc
JavaDoc es una herramienta que genera documentación en formato HTML a partir de comentarios especiales. En este repositorio, es **obligatorio** para todas las soluciones.

### Estructura de un bloque JavaDoc
Un bloque JavaDoc se coloca inmediatamente **antes** de la declaración de la clase, atributo o método.

```java
/**
 * Descripción breve de lo que hace el método o la clase.
 * Puede incluir una descripción más detallada si es necesario.
 * 
 * @param nombreParametro Explicación de qué debe recibir.
 * @return Explicación de qué valor devuelve.
 */
```

---

## 3. Etiquetas (Tags) más comunes
Las etiquetas permiten estructurar la información técnica:

- **`@param`**: Describe un parámetro de entrada. Indica su nombre y propósito.
- **`@return`**: Describe el valor que el método devuelve (no se usa en métodos `void`).
- **`@throws`**: Describe las excepciones que el método podría lanzar y por qué.
- **`@author`**: Indica el autor del código (usado a nivel de clase).
- **`@version`**: Indica la versión actual del archivo.

---

## 4. Ejemplo Académico Completo
Siguiendo nuestro estándar de desarrollo, así es como debería documentarse una clase:

```java
/**
 * Representa una calculadora académica básica para operaciones seguras.
 * 
 * @author Daniel Durán García
 * @version 1.0
 */
public class Calculadora {

    /**
     * Realiza la división entre dos números reales.
     * 
     * @param dividendo El número que será dividido.
     * @param divisor El número por el cual se divide (no debe ser 0).
     * @return El resultado de la división como un double.
     * @throws ArithmeticException Si el divisor es cero.
     */
    public double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return dividendo / divisor;
    }
}
```

---

## 5. Buenas Prácticas
1.  **No documentar lo obvio**: Evita comentarios redundantes como `i++; // Incrementa i`. Documenta el **"por qué"** de la lógica compleja.
2.  **Sincronización**: Si cambias el código (ej. cambias un parámetro), debes actualizar inmediatamente el JavaDoc.
3.  **Gramática**: La documentación es parte del producto técnico; usa una redacción clara y profesional en español.


---

**Nota Académica**: Un código bien documentado es señal de un programador profesional. En las evaluaciones de POO, la omisión de JavaDoc suele ser motivo de descuento de puntaje, ya que la comunicación del diseño es tan importante como su ejecución.
