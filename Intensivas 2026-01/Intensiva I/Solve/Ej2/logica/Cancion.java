package dominio;

public class Cancion {
	private int id;
	private String nombre;
	private String duracion;
	private String estilo;
	private int rating;
	private Album album;
	private Artista artista;

	public Cancion(int id, String nombre, String duracion, String estilo, int rating) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.estilo = estilo;
		this.rating = rating;
		this.album = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "ID:" + id + "\n" +
				"Nombre:" + nombre + "\n" +
				"Duración:" + duracion + "\n" +
				"Estilo:" + estilo + "\n" +
				"Rating:" + rating + "\n" +
				"Album:" + album.getNombre() + "\n" +
				"Artista: " + artista.getNombre();
	}

}
