package dominio;

import java.util.ArrayList;
import java.util.List;

public class Album {
	private int id;
	private String nombre;
	private Artista artista;
	private int anioLanzamiento;
	private int cantidadCanciones;
	private List<Cancion> canciones;

	public Album(int id, String nombre, int anioLanzamiento, int cantidadCanciones) {
		this.id = id;
		this.nombre = nombre;
		this.anioLanzamiento = anioLanzamiento;
		this.cantidadCanciones = cantidadCanciones;
		this.artista = null;
		this.canciones = new ArrayList<>();
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

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(int anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public int getCantidadCanciones() {
		return cantidadCanciones;
	}

	public void setCantidadCanciones(int cantidadCanciones) {
		this.cantidadCanciones = cantidadCanciones;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public void agregarCancion(Cancion c) {
		canciones.add(c);
	}

	public void eliminarCancion(Cancion c) {
		canciones.remove(c);
	}

	@Override
	public String toString() {

		String detalleCanciones = "";

		for (Cancion c : canciones) {
			detalleCanciones += c.toString();
			detalleCanciones += "==========";
		}

		return "ID: " + id + "\n" +
				"Nombre: " + nombre + "\n" +
				"Artista: " + artista.getNombre() + "\n" +
				"Año de lanzamiento: " + anioLanzamiento + "\n" +
				"Cantidad de canciones: " + cantidadCanciones + "\n" +
				"Canciones: " + detalleCanciones;
	}

}
