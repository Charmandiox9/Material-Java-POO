package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Nave;
import dominio.NaveGuerra;
import dominio.NaveSoporte;
import dominio.NaveExploracion;

public class App {

	private static List<Nave> naves = new ArrayList<>();
	private static String[][] mapa = new String[10][10];

	private static Nave crearNave(String linea) {
		String[] partes = linea.split(";");
		String tipo = partes[0].toLowerCase();
		String id = partes[1];
		String nombre = partes[2];
		double energia = Double.parseDouble(partes[3]);

		switch (tipo) {
			case "guerra":
				int poderAtaque = Integer.parseInt(partes[4]);
				return new NaveGuerra(id, nombre, energia, poderAtaque);
			case "soporte":
				int capacidadEscudo = Integer.parseInt(partes[4]);
				return new NaveSoporte(id, nombre, energia, capacidadEscudo);
			case "exploracion":
				double rangoVisibilidad = Double.parseDouble(partes[4]);
				return new NaveExploracion(id, nombre, energia, rangoVisibilidad);
			default:
				return null;
		}

	}

	public static void cargarSincronizar() {
		Scanner scan;
		try {
			scan = new Scanner(new File("naves.txt"));
			while (scan.hasNextLine()) {
				String linea = scan.nextLine();
				naves.add(crearNave(linea));
			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			scan = new Scanner(new File("posiciones.txt"));
			while (scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(";");
				String idNave = partes[0];
				int fila = Integer.parseInt(partes[1]);
				int columna = Integer.parseInt(partes[2]);

				for (Nave nave : naves) {
					if (nave.getId().equals(idNave)) {
						nave.setFila(fila);
						nave.setColumna(columna);
						break;
					}
				}
			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				mapa[i][j] = ".";
			}
		}

		for (Nave nave : naves) {
			int fila = nave.getFila();
			int columna = nave.getColumna();
			if (fila > 9 || fila < 0 || columna > 9 || columna < 0) {
				nave.setEstado("FUERA_DE_RANGO");
			} else {
				nave.setEstado("ACTIVA");
				mapa[fila][columna] = nave.getId();
			}

		}

		System.out.println("Sistema cargado y sincronizado");
	}

	public static void visualizarMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				System.out.print(mapa[i][j]);
			}
			System.out.println();
		}
	}

	public static void detalleEstado() {
		for (Nave n : naves) {
			System.out.println(n);
			System.out.println("==========");
		}
	}

	private static void simularAtaque() {
		Scanner scan = new Scanner(System.in);
		for (Nave n : naves) {
			System.out.println(n.getId() + " - " + n.getClass().getSimpleName());
		}

		System.out.print("Indique el id de la nave atacante (de guerra): ");
		String idAtacante = scan.nextLine();

		NaveGuerra naveAtacante = null;
		for (Nave n : naves) {
			if (n.getId().equals(idAtacante) && n.getClass().equals(NaveGuerra.class)) {
				naveAtacante = (NaveGuerra) n;
				break;
			}
		}

		if (naveAtacante == null) {
			System.out.println("Error: El ID no existe o la nave no es de clase Guerra.");
			return;
		}

		System.out.print("Indique el id de la nave objetivo: ");
		String idObjetivo = scan.nextLine();

		Nave naveObjetivo = null;
		for (Nave n : naves) {
			if (n.getId().equals(idObjetivo)) {
				naveObjetivo = n;
				break;
			}
		}

		if (naveObjetivo == null) {
			System.out.println("Nave no encontrada.");
			return;
		}

		naveObjetivo.recibirDaño(naveAtacante.getPoderAtaque());

	}

	public static void ejecutarAcciones() {
		for (Nave n : naves) {
			n.realizarAccion();
		}
	}

	public static void moverNave() {
		Scanner scan = new Scanner(System.in);
		for (Nave n : naves) {
			System.out.println(n.getId() + " - [" + n.getFila() + "," + n.getColumna() + "]");
		}

		System.out.print("Indique el id de la nave a mover: ");
		String idNave = scan.nextLine().trim();

		Nave nave = null;
		for (Nave n : naves) {
			if (n.getId().equalsIgnoreCase(idNave)) {
				nave = n;
				break;
			}
		}

		if (nave == null) {
			System.out.println("Error: El ID no existe.");
			return;
		}

		try {
			System.out.print("Indique la fila nueva (0-9): ");
			int fila = Integer.parseInt(scan.nextLine());
			System.out.print("Indique la columna nueva (0-9): ");
			int columna = Integer.parseInt(scan.nextLine());

			if (fila > 9 || fila < 0 || columna > 9 || columna < 0) {
				System.out.println("Error: Posición fuera de los límites del mapa (10x10).");
				return;
			}

			if (!mapa[fila][columna].equals(".")) {
				System.out
						.println("Error: La posición " + fila + "," + columna + " ya está ocupada por " + mapa[fila][columna]);
				return;
			}

			mapa[nave.getFila()][nave.getColumna()] = ".";
			nave.setFila(fila);
			nave.setColumna(columna);
			mapa[fila][columna] = nave.getId();

			System.out.println("Nave " + idNave + " movida exitosamente.");

		} catch (NumberFormatException e) {
			System.out.println("Error: Debe ingresar un número válido para las coordenadas.");
		}
	}

	public static void estadisticasSector() {
		int totalNavesActivas = 0;
		int totalEnergia = 0;
		int totalGuerra = 0;
		int totalSoporte = 0;
		int totalExploracion = 0;

		for (Nave n : naves) {
			if (n.getEstado().equals("ACTIVA")) {
				totalNavesActivas++;
				totalEnergia += n.getEnergia();

				if (n.getClass().equals(NaveGuerra.class)) {
					totalGuerra++;
				} else if (n.getClass().equals(NaveSoporte.class)) {
					totalSoporte++;
				} else if (n.getClass().equals(NaveExploracion.class)) {
					totalExploracion++;
				}
			}
		}

		System.out.println("Total de naves activas: " + totalNavesActivas);
		System.out.println("Promedio de energia: " + (totalEnergia / totalNavesActivas));
		if (totalGuerra > totalSoporte && totalGuerra > totalExploracion) {
			System.out.println("Tipo de nave predominante: " + NaveGuerra.class.getSimpleName());
		} else if (totalSoporte > totalGuerra && totalSoporte > totalExploracion) {
			System.out.println("Tipo de nave predominante: " + NaveSoporte.class.getSimpleName());
		} else if (totalExploracion > totalGuerra && totalExploracion > totalSoporte) {
			System.out.println("Tipo de nave predominante: " + NaveExploracion.class.getSimpleName());
		}
	}

	public static void desplegarMenu() {
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("-------------------------------------------");
			System.out.println("1. Cargar Flota y Sincronizar Mapa.");
			System.out.println("2. Visualizar Mapa Táctico.");
			System.out.println("3. Mostrar Estado Detallado.");
			System.out.println("4. Simulación de Combate.");
			System.out.println("5. Realizar acciones.");
			System.out.println("6. Mover Nave.");
			System.out.println("7. Estadísticas del Sector.");
			System.out.println("8. Salir.");
			System.out.println("-------------------------------------------");
			System.out.print("Seleccione una opción: ");
			opcion = scan.nextInt();

			switch (opcion) {
				case 1:
					cargarSincronizar();
					break;
				case 2:
					visualizarMapa();
					break;
				case 3:
					detalleEstado();
					break;
				case 4:
					simularAtaque();
					break;
				case 5:
					ejecutarAcciones();
					break;
				case 6:
					moverNave();
					break;
				case 7:
					estadisticasSector();
					break;
			}

		} while (opcion != 8);
	}

	public static void main(String[] args) {
		desplegarMenu();
	}

}
