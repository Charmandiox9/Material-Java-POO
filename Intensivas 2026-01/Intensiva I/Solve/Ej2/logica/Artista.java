package dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Artista {
	protected int id;
	protected String nombre;
	protected int anio;
	protected List<Album> albumes;

	public Artista(int id, String nombre, int anio) {
		this.id = id;
		this.nombre = nombre;
		this.anio = anio;
		this.albumes = new ArrayList<>();
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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public List<Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}

	public void agregarAlbum(Album a) {
		albumes.add(a);
	}

	public void eliminarAlbum(int id) {
		for (Album a : albumes) {
			if (a.getId() == id) {
				albumes.remove(a);
				break;
			}
		}
	}

	public abstract String reporteDeEstilos();
}
