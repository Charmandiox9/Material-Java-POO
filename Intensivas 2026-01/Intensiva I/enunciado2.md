# Problema 2: Music Analytics V2 (Herencia y Polimorfismo)

Usted tiene gustos musicales bastante amplios y escucha una gama variada de artistas. Le llama la atención el potencial análisis que se puede lograr respecto a estilos, por ejemplo, cómo algunos artistas evolucionan a lo largo de las décadas.

A diferencia del sistema original, ahora se requiere modelar los distintos tipos de artistas musicales usando **Herencia**. Existen dos tipos de artistas principales en su biblioteca: **Bandas** y **Solistas**. Ambos comparten atributos comunes, pero tienen características específicas que alteran la forma en que se presentan sus datos.

Para poner a prueba sus conocimientos de Programación Orientada a Objetos, tomará los archivos base y creará un sistema que registre esta información organizándola bajo una jerarquía de clases.

## Archivos de Entrada

**1. `artistas.txt`**
Contiene los datos de los artistas. El primer campo indica el tipo de artista (`BANDA` o `SOLISTA`).
Formato: `TIPO,ID_Artista,Nombre,Año,Atributo_Extra`
- Si es `BANDA`: El año corresponde a su fundación y el atributo extra a la cantidad de integrantes.
- Si es `SOLISTA`: El año corresponde a su nacimiento y el atributo extra a su nacionalidad.

**2. `musica.txt`**
Registra los álbumes y sus canciones en líneas consecutivas.
- Línea Álbum: `ALBUM,ID_Album,Nombre_Album,ID_Artista,Año_Lanzamiento,Cantidad_Canciones`
- Líneas Canción (Siguientes N líneas): `CANCION,ID_Cancion,Nombre_Cancion,Duracion,Estilo,Rating`

**3. `playlists.txt`**
- Línea 1: `Nombre_Playlist,Cantidad_Canciones`
- Línea 2: `ID_Cancion1,ID_Cancion2,...`

## Funcionalidades Requeridas (Menú)

1. **Cargar datos**: Al iniciar el programa, leer los tres archivos y poblar sus colecciones utilizando la herencia para instanciar objetos de tipo `Banda` y `Solista`, los cuales heredan de una clase base abstracta `Artista`.
2. **Reporte de Estilos**: Mostrar la composición de estilos musicales para cada artista (basado en sus canciones). En el encabezado de cada artista, **se debe utilizar polimorfismo** llamando a un método sobreescrito que imprima un resumen específico.
   Ejemplo de salida esperada:
   ```text
   - Banda: The Beatles (4 integrantes)
     Rock (100%)
   - Solista: Gustavo Cerati (Nacionalidad: Argentina)
     Rock (100%)
   ```
3. **Análisis de Playlists**: Para cada playlist, mostrar la proporción de álbumes que la componen basándose en sus canciones.
   Ejemplo:
   ```text
   - Viaje
     Abbey Road (66.6%)
     Bocanada (33.3%)
   ```
4. **Álbumes por Década**: Listar los álbumes agrupados por décadas de lanzamiento (ej. 1950-1959, 1960-1969, etc.).
5. **Rating por Tipo de Artista**: Calcular y mostrar el rating promedio de todas las canciones cantadas por `Bandas` versus el rating promedio de todas las canciones cantadas por `Solistas`.

## Consideraciones
- Debe usar herencia de manera obligatoria para los `Artista` (Clase Base Abstracta).
- El método que entrega el detalle del artista debe ser polimórfico.
- Entregue un Diagrama de Clases (UML) que modele el nuevo diseño.
- El código fuente debe exportarlo en un solo archivo `.zip` y subirlo a la plataforma.