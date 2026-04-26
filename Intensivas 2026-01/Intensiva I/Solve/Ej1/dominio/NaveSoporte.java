package dominio;

public class NaveSoporte extends Nave {
	private int capacidadEscudo;

	public NaveSoporte(String id, String nombre, double energia, int capacidadEscudo) {
		super(id, nombre, energia);
		this.capacidadEscudo = capacidadEscudo;
	}

	public int getCapacidadEscudo() {
		return capacidadEscudo;
	}

	public void setCapacidadEscudo(int capacidadEscudo) {
		this.capacidadEscudo = capacidadEscudo;
	}

	@Override
	public void realizarAccion() {
		System.out.println("Nave " + id + " lista para defender.");
	}

	@Override
	public void recibirDaño(int puntosAtaque) {
		if (puntosAtaque > capacidadEscudo) {
			int dañoRestante = puntosAtaque - capacidadEscudo;
			System.out.println("Escudo destruido! El exceso de " + dañoRestante + " pasó a la energía.");

			capacidadEscudo = 0;
			energia -= dañoRestante;

			if (energia <= 0) {
				this.energia = 0;
				this.estado = "destruida";
				System.out.println("Daño fatal: La nave ha sido destruida.");
			} else {
				System.out.println("Energía restante: " + energia);
			}
		} else {
			capacidadEscudo -= puntosAtaque;
			System.out.println("El escudo absorbió el impacto. Escudo restante: " + capacidadEscudo);
		}
	}

	@Override
	public String toString() {
		return "ID: " + id + "\n" +
				"Nombre: " + nombre + "\n" +
				"Energía: " + energia + "\n" +
				"Estado: " + estado + "\n" +
				"Capacidad de escudo: " + capacidadEscudo + "\n" +
				"Posición: " + fila + "," + columna;

	}

}
