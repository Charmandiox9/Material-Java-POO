package dominio;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private String nombre;
	private int cantidadCanciones;
	private List<Cancion> canciones;

	public Playlist(String nombre, int cantidadCanciones) {
		this.nombre = nombre;
		this.cantidadCanciones = cantidadCanciones;
		this.canciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String proporcionAlbumes() {
		if (canciones.isEmpty()) {
			return "  (Playlist vacía)";
		}

		List<String> nombresAlbumes = new ArrayList<>();
		List<Integer> contadores = new ArrayList<>();
		int totalCanciones = canciones.size();

		for (Cancion c : canciones) {
			String nombreAlbum = c.getAlbum().getNombre();
			boolean encontrado = false;

			for (int i = 0; i < nombresAlbumes.size(); i++) {
				if (nombresAlbumes.get(i).equals(nombreAlbum)) {
					contadores.set(i, contadores.get(i) + 1);
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				nombresAlbumes.add(nombreAlbum);
				contadores.add(1);
			}
		}

		String resultado = "";
		for (int i = 0; i < nombresAlbumes.size(); i++) {
			double porcentaje = (contadores.get(i) * 100.0) / totalCanciones;

			resultado += "  " + nombresAlbumes.get(i) + " (" + porcentaje + "%)\n";
		}

		return resultado;
	}
}
