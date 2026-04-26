package dominio;

import java.util.ArrayList;
import java.util.List;

public class Solista extends Artista {
	private String nacionalidad;

	public Solista(int id, String nombre, int anio, String nacionalidad) {
		super(id, nombre, anio);
		this.nacionalidad = nacionalidad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		String detalleAlbumes = "";

		for (Album a : albumes) {
			detalleAlbumes += a.toString();
			detalleAlbumes += "==========";
		}

		return "ID: " + id + "\n" +
				"Nombre: " + nombre + "\n" +
				"Año de fundación: " + anio + "\n" +
				"Nacionalidad: " + nacionalidad + "\n" +
				"Albumes: " + detalleAlbumes;

	}

	@Override
	public String reporteDeEstilos() {
		List<Cancion> todasLasCanciones = new ArrayList<>();
		for (Album album : albumes) {
			for (Cancion cancion : album.getCanciones()) {
				todasLasCanciones.add(cancion);
			}
		}

		int totalCanciones = todasLasCanciones.size();
		if (totalCanciones == 0)
			return "Sin canciones registradas.";

		List<String> estilosVistos = new ArrayList<>();
		List<Integer> contadores = new ArrayList<>();

		for (Cancion c : todasLasCanciones) {
			String estiloActual = c.getEstilo();
			boolean encontrado = false;

			for (int i = 0; i < estilosVistos.size(); i++) {
				if (estilosVistos.get(i).equalsIgnoreCase(estiloActual)) {
					int cuentaActual = contadores.get(i);
					contadores.set(i, cuentaActual + 1);
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				estilosVistos.add(estiloActual);
				contadores.add(1);
			}
		}

		String reporte = "- Banda: " + nombre + " (Nacionalidad: " + nacionalidad + ")\n";
		for (int i = 0; i < estilosVistos.size(); i++) {
			int porcentaje = (contadores.get(i) * 100) / totalCanciones;
			reporte += "  " + estilosVistos.get(i) + " (" + porcentaje + "%)\n";
		}

		return reporte;
	}

}
