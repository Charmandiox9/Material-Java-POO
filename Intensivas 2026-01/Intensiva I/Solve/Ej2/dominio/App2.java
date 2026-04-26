package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import dominio.Artista;
import dominio.Banda;
import dominio.Solista;
import dominio.Album;
import dominio.Cancion;
import dominio.Playlist;

public class App2 {

	private static List<Artista> artistas = new ArrayList<>();
	private static List<Album> albumes = new ArrayList<>();
	private static List<Cancion> canciones = new ArrayList<>();
	private static List<Playlist> playlists = new ArrayList<>();

	private static Artista crearArtista(String linea) {
		String[] partes = linea.split(",");
		String tipo = partes[0];
		int id = Integer.parseInt(partes[1]);
		String nombre = partes[2];
		int anio = Integer.parseInt(partes[3]);

		Artista artista = null;

		switch (tipo.toLowerCase()) {
			case "banda":
				int cantidadIntegrantes = Integer.parseInt(partes[4]);
				artista = new Banda(id, nombre, anio, cantidadIntegrantes);
				break;
			case "solista":
				String nacionalidad = partes[4];
				artista = new Solista(id, nombre, anio, nacionalidad);
				break;
		}
		return artista;
	}

	private static Album crearAlbum(String linea) {
		String[] partes = linea.split(",");
		int id = Integer.parseInt(partes[1]);
		String nombre = partes[2];
		int idArtista = Integer.parseInt(partes[3]);
		int anioLanzamiento = Integer.parseInt(partes[4]);
		int cantidadCanciones = Integer.parseInt(partes[5]);

		Album album = new Album(id, nombre, anioLanzamiento, cantidadCanciones);
		for (Artista artista : artistas) {
			if (artista.getId() == idArtista) {
				album.setArtista(artista);
				artista.agregarAlbum(album);
				break;
			}
		}

		return album;
	}

	private static Cancion crearCancion(String linea, int albumId) {
		String[] partes = linea.split(",");
		int id = Integer.parseInt(partes[1]);
		String nombre = partes[2];
		String duracion = partes[3];
		String estilo = partes[4];
		int rating = Integer.parseInt(partes[5]);

		Cancion cancion = new Cancion(id, nombre, duracion, estilo, rating);
		for (Album a : albumes) {
			if (a.getId() == albumId) {
				cancion.setAlbum(a);
				cancion.setArtista(a.getArtista());
				a.agregarCancion(cancion);
				break;
			}
		}

		return cancion;
	}

	private static Playlist crearPlaylist(String linea) {
		String[] partes = linea.split(",");
		String nombre = partes[0];
		int cantidadCanciones = Integer.parseInt(partes[1]);

		return new Playlist(nombre, cantidadCanciones);
	}

	private static void cargarPlaylist(String linea, Playlist playlist) {
		String[] partes = linea.split(",");
		for (int i = 0; i < partes.length; i++) {
			int idCancion = Integer.parseInt(partes[i]);
			for (Cancion c : canciones) {
				if (c.getId() == idCancion) {
					playlist.agregarCancion(c);
					break;
				}
			}
		}
	}

	public static void leerArtistas() {
		try {
			Scanner scan = new Scanner(new File("artistas.txt"));
			while (scan.hasNextLine()) {
				String linea = scan.nextLine();
				artistas.add(crearArtista(linea));
			}

			System.out.println("Artistas cargados correctamente!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void leerMusica() {
		try {
			Scanner scan = new Scanner(new File("musica.txt"));
			while (scan.hasNextLine()) {
				String linea = scan.nextLine();
				String[] partes = linea.split(",");
				String tipo = partes[0];

				Album album = crearAlbum(linea);
				albumes.add(album);
				for (int i = 0; i < album.getCantidadCanciones(); i++) {
					linea = scan.nextLine();
					Cancion cancion = crearCancion(linea, album.getId());
					canciones.add(cancion);
				}
			}
			System.out.println("Albumes y canciones cargados correctamente!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void leerPlaylists() {
		try {
			Scanner scan = new Scanner(new File("playlists.txt"));
			while (scan.hasNextLine()) {
				String linea = scan.nextLine();
				Playlist playlist = crearPlaylist(linea);
				cargarPlaylist(scan.nextLine(), playlist);
				playlists.add(playlist);
			}
			System.out.println("Playlists cargadas correctamente!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void reporteEstilos() {
		System.out.println("=== Reporte de Estilos de Artistas ===");
		for (Artista a : artistas) {
			System.out.println(a.reporteDeEstilos());
		}
	}

	public static void analisisPlaylists() {
		System.out.println("=== Análisis de Playlists ===");
		if (playlists.isEmpty()) {
			System.out.println("No hay playlists cargadas.");
			return;
		}

		for (Playlist p : playlists) {
			System.out.println("- " + p.getNombre());
			System.out.print(p.proporcionAlbumes());
		}
	}

	public static void albumesPorDecadas() {
		System.out.println("=== Álbumes por Década ===");

		if (albumes.isEmpty()) {
			System.out.println("No hay álbumes cargados.");
			return;
		}

		int minAnio = 2026;
		int maxAnio = 0;
		for (Album a : albumes) {
			if (a.getAnioLanzamiento() < minAnio)
				minAnio = a.getAnioLanzamiento();
			if (a.getAnioLanzamiento() > maxAnio)
				maxAnio = a.getAnioLanzamiento();
		}

		int decadaInicio = (minAnio / 10) * 10;
		int decadaFin = (maxAnio / 10) * 10;

		for (int d = decadaInicio; d <= decadaFin; d += 10) {
			boolean hayAlbumesEnEstaDecada = false;
			String listaDeEstaDecada = "";

			for (Album a : albumes) {
				int decadaAlbum = (a.getAnioLanzamiento() / 10) * 10;

				if (decadaAlbum == d) {
					listaDeEstaDecada += "   - " + a.getNombre() + " (" + a.getAnioLanzamiento() + ")\n";
					hayAlbumesEnEstaDecada = true;
				}
			}

			if (hayAlbumesEnEstaDecada) {
				System.out.println("Década " + d + "-" + (d + 9) + ":");
				System.out.print(listaDeEstaDecada);
			}
		}
	}

	public static void ratingPorTipoDeArtista() {
		int cantidadCancionesBandas = 0;
		int sumaRatingBandas = 0;
		int cantidadCancionesSolistas = 0;
		int sumaRatingSolistas = 0;

		for (Artista artista : artistas) {
			if (artista.getClass().getSimpleName().toLowerCase().equals("banda")) {
				for (Album album : artista.getAlbumes()) {
					for (Cancion cancion : album.getCanciones()) {
						cantidadCancionesBandas++;
						sumaRatingBandas += cancion.getRating();
					}
				}
			} else if (artista.getClass().getSimpleName().toLowerCase().equals("solista")) {
				for (Album album : artista.getAlbumes()) {
					for (Cancion cancion : album.getCanciones()) {
						cantidadCancionesSolistas++;
						sumaRatingSolistas += cancion.getRating();
					}
				}
			}
		}

		System.out.println("--- Rating Promedio por Tipo de Artista ---");
		if (cantidadCancionesBandas > 0) {
			double promedio = (double) sumaRatingBandas / cantidadCancionesBandas;
			System.out.println("Rating promedio de Bandas: " + promedio);
		} else {
			System.out.println("No se encontraron canciones de Bandas.");
		}

		if (cantidadCancionesSolistas > 0) {
			double promedio = (double) sumaRatingSolistas / cantidadCancionesSolistas;
			System.out.println("Rating promedio de Solistas: " + promedio);
		} else {
			System.out.println("No se encontraron canciones de Solistas.");
		}
	}

	public static void desplegarMenu() {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("===================================");
			System.out.println("1. Cargar datos.");
			System.out.println("2. Reporte de estilos.");
			System.out.println("3. Análisis de playlists.");
			System.out.println("4. Álbumes por decada.");
			System.out.println("5. Rating por tipo de artista.");
			System.out.println("6. Salir.");
			System.out.println("===================================");
			System.out.print("Seleccione una opción: ");
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
				case 1:
					leerArtistas();
					leerMusica();
					leerPlaylists();
					break;
				case 2:
					reporteEstilos();
					break;
				case 3:
					analisisPlaylists();
					break;
				case 4:
					albumesPorDecadas();
					break;
				case 5:
					ratingPorTipoDeArtista();
					break;

			}

		} while (opcion != 6);
	}

	public static void main(String[] args) {
		desplegarMenu();
	}

}
