# Problema 1: AI Studio Analytics

## Herencia, polimorfismo y vectores estáticos

Una plataforma ofrece distintas inteligencias artificiales especializadas en modelado, programación y generación de texto. Cada IA mantiene un historial de chats y un registro de las imágenes generadas durante esos chats.

Se pide desarrollar un programa que cargue esta información desde archivos y permita analizarla. El diseño debe usar herencia y polimorfismo para representar las especialidades, y **vectores estáticos** para almacenar los datos.

## Diseño del sistema

Antes de programar, diseñe las clases necesarias para representar las inteligencias artificiales, sus especialidades, los chats y las imágenes. Decida qué datos y responsabilidades corresponden a cada clase, cómo se relacionan y qué comportamiento debe resolverse mediante polimorfismo.

El diseño debe cumplir con las funcionalidades y restricciones de este enunciado. La sección desplegable siguiente ofrece una posible guía si necesita ayuda; consúltela después de intentar proponer su propio diseño.

<details>
<summary>Ayuda opcional: una posible propuesta de clases</summary>

## Clases requeridas

### `IA` — clase abstracta

Debe ser una clase base **abstracta** con estos atributos privados:

- `id`
- `nombre`
- `proveedor`
- `Chat[] chats`
- `cantidadChats`
- `Imagen[] imagenes`
- `cantidadImagenes`

Debe incluir operaciones para agregar chats e imágenes, buscar un chat o una imagen por ID y mostrar el resumen de la IA.

El método `mostrarResumen()` debe ser abstracto. Cada especialidad lo sobrescribirá para mostrar sus datos específicos.

### `IAModelado`

Hereda de `IA` y agrega estos atributos privados:

- `tipoModelado`: por ejemplo, personajes, arquitectura o productos.
- `formatosSoportados`: vector estático de formatos, como OBJ, STL o FBX.
- `cantidadFormatos`
- `permiteTexturas`
- `nivelDetalleMaximo`: valor entero.

### `IACodigo`

Hereda de `IA` y agrega estos atributos privados:

- `lenguajePrincipal`
- `lenguajesSoportados`: vector estático de lenguajes.
- `cantidadLenguajes`
- `puedeDepurar`
- `puedeExplicarCodigo`
- `nivelExperiencia`: básico, intermedio o avanzado.

### `IATexto`

Hereda de `IA` y agrega estos atributos privados:

- `tipoTexto`: por ejemplo, creativo, técnico, académico o resumido.
- `idiomaPrincipal`
- `idiomasSoportados`: vector estático de idiomas.
- `cantidadIdiomas`
- `longitudMaximaRespuesta`
- `permiteUsarTonoCreativo`

### `Chat`

Debe contener:

- `id`
- `nombre`
- `tema`
- `fechaCreacion`
- `Imagen[] imagenes`
- `cantidadImagenes`

Cada chat pertenece a una sola IA. Debe poder agregar imágenes y consultar cuántas imágenes tiene de cada estilo.

### `Imagen`

Debe contener:

- `id`
- `nombre`
- `estilo`: por ejemplo, realista, boceto, pixel art o ilustración.
- `fechaGeneracion`
- `rating`: entero entre 1 y 5.
- `Chat chat`: referencia al chat donde se generó.

</details>

## Archivos de entrada

El programa utilizará tres archivos de texto separados por comas. Cada línea representa un registro. Los IDs permiten relacionar las IAs, los chats y las imágenes al cargar los datos.

### 1. `ias.txt`

Contiene una IA por línea. El primer campo indica su especialidad: `MODELADO`, `CODIGO` o `TEXTO`. Los campos siguientes incluyen sus datos generales y los atributos particulares de esa especialidad.

**Campos comunes:**

- `Tipo`: especialidad de la IA; determina qué subclase se debe crear.
- `ID`: identificador único de la IA.
- `Nombre`: nombre con que se identifica la IA.
- `Proveedor`: empresa o entidad que ofrece la IA.

**Campos para `MODELADO`:**

- `TipoModelado`: clase de contenido que puede modelar, por ejemplo, personajes, arquitectura o productos.
- `PermiteTexturas`: indica si la IA puede crear o aplicar texturas (`SI` o `NO`).
- `NivelDetalle`: nivel máximo de detalle que puede producir, expresado como entero.
- `CantidadFormatos`: cantidad de formatos que se informan a continuación.
- `Formato1,...,FormatoN`: formatos de archivo soportados, por ejemplo, OBJ, STL o FBX.

```text
MODELADO,ID,Nombre,Proveedor,TipoModelado,PermiteTexturas,NivelDetalle,CantidadFormatos,Formato1,...,FormatoN
```

**Campos para `CODIGO`:**

- `LenguajePrincipal`: lenguaje de programación principal de la IA.
- `PuedeDepurar`: indica si puede ayudar a encontrar errores (`SI` o `NO`).
- `PuedeExplicar`: indica si puede explicar código (`SI` o `NO`).
- `NivelExperiencia`: nivel de dificultad del código que puede manejar: básico, intermedio o avanzado.
- `CantidadLenguajes`: cantidad de lenguajes que se informan a continuación.
- `Lenguaje1,...,LenguajeN`: lenguajes de programación soportados.

```text
CODIGO,ID,Nombre,Proveedor,LenguajePrincipal,PuedeDepurar,PuedeExplicar,NivelExperiencia,CantidadLenguajes,Lenguaje1,...,LenguajeN
```

**Campos para `TEXTO`:**

- `TipoTexto`: tipo de contenido que genera, por ejemplo, creativo, técnico, académico o resumido.
- `IdiomaPrincipal`: idioma principal de generación.
- `LongitudMaxima`: cantidad máxima de caracteres permitida en una respuesta.
- `TonoCreativo`: indica si permite generar respuestas con un tono creativo (`SI` o `NO`).
- `CantidadIdiomas`: cantidad de idiomas que se informan a continuación.
- `Idioma1,...,IdiomaN`: idiomas en que puede generar contenido.

```text
TEXTO,ID,Nombre,Proveedor,TipoTexto,IdiomaPrincipal,LongitudMaxima,TonoCreativo,CantidadIdiomas,Idioma1,...,IdiomaN
```

Los valores booleanos se escribirán como `SI` o `NO`. La cantidad indicada antes de una lista determina cuántos campos de esa lista deben leerse.

Ejemplos:

```text
MODELADO,1,Modela3D,CreativaAI,Personajes,SI,5,3,OBJ,STL,FBX
CODIGO,2,CodePilot,DevAI,Java,SI,SI,AVANZADO,3,Java,Python,JavaScript
TEXTO,3,Redactor,PalabraAI,Creativo,Español,2000,SI,2,Español,Inglés
```

### 2. `chats.txt`

Contiene una línea por chat. Cada registro indica a qué IA pertenece mediante `ID_IA`.

- `ID_Chat`: identificador único del chat.
- `Nombre`: nombre o título del chat.
- `Tema`: asunto principal tratado en el chat.
- `FechaCreacion`: fecha en que se creó el chat, con formato `AAAA-MM-DD`.
- `ID_IA`: identificador de la IA propietaria del chat; debe coincidir con un ID de `ias.txt`.

```text
ID_Chat,Nombre,Tema,FechaCreacion,ID_IA
```

Ejemplos:

```text
101,Criatura fantástica,Diseño de personajes,2026-03-12,1
102,Ayuda con arreglos,Depuración de código,2026-04-01,2
```

### 3. `imagenes.txt`

Contiene una línea por imagen generada. Cada registro incluye sus características y los IDs del chat y de la IA asociados.

- `ID_Imagen`: identificador único de la imagen.
- `Nombre`: nombre o descripción breve de la imagen.
- `Estilo`: estilo visual, por ejemplo, realista, boceto, pixel art o ilustración.
- `FechaGeneracion`: fecha en que se generó la imagen, con formato `AAAA-MM-DD`.
- `Rating`: calificación de la imagen, como entero entre 1 y 5.
- `ID_Chat`: identificador del chat donde se generó; debe coincidir con un ID de `chats.txt`.
- `ID_IA`: identificador de la IA que la generó; debe coincidir con un ID de `ias.txt`.

```text
ID_Imagen,Nombre,Estilo,FechaGeneracion,Rating,ID_Chat,ID_IA
```

Ejemplo:

```text
501,Dragón de hielo,Realista,2026-03-12,5,101,1
502,Dragón pixelado,Pixel art,2026-03-12,4,101,1
```

## Funcionalidades requeridas

### 1. Cargar datos

Al iniciar el programa, leer los tres archivos y crear los objetos correspondientes.

- Instanciar la subclase correcta según el tipo registrado en `ias.txt`.
- Asociar cada chat con su IA usando el ID de la IA.
- Asociar cada imagen con su chat usando el ID del chat.
- Agregar cada imagen al historial general de imágenes de la IA y al vector de imágenes de su chat.

La imagen debe ser **un solo objeto**. La IA y el chat deben guardar referencias a esa misma instancia.

### 2. Reporte de imágenes por IA

Para cada IA:

1. Mostrar su resumen llamando a `mostrarResumen()` de forma polimórfica.
2. Mostrar qué porcentaje de sus imágenes corresponde a cada estilo.

Ejemplo:

```text
- IA de modelado: Modela3D (Tipo: Personajes, texturas: sí)
  Realista (60.0%)
  Boceto (40.0%)

- IA de código: CodePilot (Lenguaje principal: Java, depuración: sí)
  Sin imágenes registradas
```

El porcentaje de un estilo se calcula respecto del total de imágenes de esa IA. Si no tiene imágenes, se debe informar que no hay imágenes registradas.

### 3. Análisis de imágenes por chat

Para cada IA, mostrar sus chats y la proporción de imágenes de cada estilo que se generaron en cada chat.

```text
- Criatura fantástica
  Realista (66.7%)
  Pixel art (33.3%)
```

Si un chat no tiene imágenes, mostrar un mensaje que lo indique.

### 4. Imágenes agrupadas por década

Listar las imágenes según la década de generación. Cada década debe mostrarse como un intervalo, por ejemplo:

```text
2020-2029
  Dragón de hielo — Realista — Rating: 5
  Dragón pixelado — Pixel art — Rating: 4

2030-2039
  Ciudad futurista — Boceto — Rating: 3
```

Las décadas sin imágenes no deben aparecer.

### 5. Rating promedio por especialidad

Calcular y mostrar el rating promedio de las imágenes generadas por cada tipo de IA:

- IAs de modelado.
- IAs de código.
- IAs de generación de texto.

El promedio se calcula usando todas las imágenes pertenecientes a IAs de esa especialidad.

```text
Modelado: 4.5
Código: 3.8
Generación de texto: sin imágenes registradas
```

### 6. Menú principal

El programa debe ofrecer un menú para ejecutar los reportes:

```text
1. Reporte de imágenes por IA
2. Análisis de imágenes por chat
3. Imágenes agrupadas por década
4. Rating promedio por especialidad
0. Salir
```

Los datos se cargan automáticamente al iniciar. El menú se repite hasta que el usuario seleccione la opción de salida.

## Restricciones técnicas

- Se deben usar vectores estáticos; no se permite usar `ArrayList`, `LinkedList`, `HashMap`, `Vector` ni otras colecciones dinámicas.
- Cada vector debe tener una capacidad máxima definida y un contador de elementos ocupados.
- Capacidades sugeridas:
  - Hasta 50 IAs.
  - Hasta 100 chats por IA.
  - Hasta 500 imágenes por IA.
  - Hasta 100 imágenes por chat.
  - Hasta 10 idiomas, lenguajes o formatos por IA.
- Las clases deben respetar el encapsulamiento: los atributos serán privados y se accederá a ellos mediante métodos.
- Se asume que los archivos existen, que respetan el formato indicado y que sus IDs son válidos.

## Diagrama UML y entrega

Entregar un diagrama UML que incluya:

- La clase abstracta `IA` y sus tres subclases.
- Las clases `Chat` e `Imagen`.
- Los atributos principales y las operaciones necesarias.
- Las relaciones entre las clases y sus multiplicidades.
- La sobrescritura polimórfica de `mostrarResumen()`.

El trabajo se realizará en dos etapas:

- **UML: 45 minutos**
- **Código: 135 minutos**
