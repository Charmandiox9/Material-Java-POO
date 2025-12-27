package ej1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
	static ArrayList<Contacto> contactos = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	public static void leerArchivo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("contactos.txt"));
		
		while(sc.hasNextLine()) {
			String[] partes = sc.nextLine().split(",");
			String nombre = partes[0];
			String telefono = partes[1];
			String email = partes[2];
			
			contactos.add(new Contacto(nombre, telefono, email));
		}
		sc.close();
		desplegarMenu();
	}
	
	public static void desplegarMenu() {
		int opcion;
		
		do {
			System.out.println("=== AGENDA INTELIGENTE ===");
			System.out.println("1. Mostrar todos los contactos");
			System.out.println("2. Buscar contacto por nombre");
			System.out.println("3. Agregar nuevo contacto");
			System.out.println("4. Eliminar contacto");
			System.out.println("5. Salir");
			System.out.print("Opción: ");
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch(opcion) {
				case 1:
					mostrarContactos();
					break;
				case 2:
					buscarContacto();
					break;
				case 3:
					agregarContacto();
					break;
				case 4:
					eliminarContacto();
					break;
			}
			
		} while(opcion != 5);
	}
	
	public static void mostrarContactos() {
		for(Contacto c: contactos) {
			System.out.println(c);
		}
	}
	
	public static void buscarContacto() {
		System.out.print("Ingrese el nombre: ");
		String nombre = scan.nextLine();
		Contacto contacto = null;
		
		for(Contacto c: contactos) {
			if(c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
	            contacto = c;
	            break;
	        }
		}
		
		System.out.println(contacto != null ? contacto : "Nombre de contacto no encontrado");
	}
	
	public static void agregarContacto() {
		System.out.print("Ingrese el nombre: ");
		String nombre = scan.nextLine();
		System.out.print("Ingrese el teléfono: ");
		String telefono = scan.nextLine();
		System.out.print("Ingrese el email: ");
		String email = scan.nextLine();
		
		contactos.add(new Contacto(nombre, telefono, email));
		System.out.println("Contacto agregado!");
	}
	
	public static void eliminarContacto() {
		System.out.print("Ingrese el email: ");
		String email = scan.nextLine();
		Contacto contacto = null;
		
		for(Contacto c: contactos) {
			if(c.getEmail().equalsIgnoreCase(email)) {
				contacto = c;
				break;
			}
		}
		
		if(contacto != null) {
			contactos.remove(contacto);
			System.out.println("Contacto eliminado correctamente!");
		} else {
			System.out.println("No se ha encontrado el contacto.");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		leerArchivo();
	}

}
