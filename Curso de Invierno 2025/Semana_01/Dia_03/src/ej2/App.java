package ej2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	static ArrayList<Tarea> tareas = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	public static void leerArchivo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("tareas.txt"));
		
		while(sc.hasNextLine()) {
			String[] partes = sc.nextLine().split(",");
			String tarea = partes[0];
			int prioridad = Integer.parseInt(partes[1]);
			String encargado = partes[2];
			
			tareas.add(new Tarea(tarea, prioridad, encargado));
		}
		sc.close();
		salida();
	}
	
	public static void salida() {
		System.out.println("=== GESTOR DE TAREAS ===");
		System.out.println("Tareas por prioridad (1=Alta, 2=Media, 3=Baja):");
		
		ArrayList<Tarea> pAlta = new ArrayList<>();
		ArrayList<Tarea> pMedia = new ArrayList<>();
		ArrayList<Tarea> pBaja = new ArrayList<>();
		
		for(Tarea t: tareas) {
			switch(t.getPrioridad()) {
				case 1:
					pAlta.add(t);
					break;
				case 2:
					pMedia.add(t);
					break;
				case 3:
					pBaja.add(t);
					break;
			}
		}
		
		System.out.println("\nPRIORIDAD ALTA:");
		if(pAlta.size() > 0) {
			for(Tarea t: pAlta) {
				System.out.println("- " + t.getTarea() + " (Asignado: " + t.getEncargado() + ")");
			}
		}
		
		System.out.println("\nPRIORIDAD MEDIA:");
		if(pMedia.size() > 0) {
			for(Tarea t: pMedia) {
				System.out.println("- " + t.getTarea() + " (Asignado: " + t.getEncargado() + ")");
			}
		}
		
		System.out.println("\nPRIORIDAD BAJA:");
		if(pBaja.size() > 0) {
			for(Tarea t: pBaja) {
				System.out.println("- " + t.getTarea() + " (Asignado: " + t.getEncargado() + ")");
			}
		}
		
			
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		leerArchivo();
	}
}
