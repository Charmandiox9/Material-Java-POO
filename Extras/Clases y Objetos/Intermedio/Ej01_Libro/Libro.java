/**
 * Clase Libro con validación de datos.
 */
public class Libro {
    
    private String titulo;
    private String autor;
    private int paginas;
    private String isbn;

    /**
     * Constructor que utiliza setters para garantizar la integridad.
     */
    public Libro(String titulo, String autor, int paginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.setPaginas(paginas); // Usamos el setter para validar
        this.isbn = isbn;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getPaginas() { return paginas; }
    public String getIsbn() { return isbn; }

    // Setters con validación
    public void setPaginas(int paginas) {
        if (paginas >= 0) {
            this.paginas = paginas;
        } else {
            System.out.println("Error: El número de páginas no puede ser negativo.");
            this.paginas = 0;
        }
    }

    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " | Autor: " + autor + " | Páginas: " + paginas);
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", -50, "978-0307474728");
        libro1.mostrarInfo();
    }
}
