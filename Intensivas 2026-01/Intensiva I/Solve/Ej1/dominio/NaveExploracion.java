package dominio;

public class NaveExploracion extends Nave {
	private double rangoVisibilidad;

	public NaveExploracion(String id, String nombre, double energia, double rangoVisibilidad) {
		super(id, nombre, energia);
		this.rangoVisibilidad = rangoVisibilidad;
	}

	public double getRangoVisibilidad() {
		return rangoVisibilidad;
	}

	public void setRangoVisibilidad(double rangoVisibilidad) {
		this.rangoVisibilidad = rangoVisibilidad;
	}

	@Override
	public void realizarAccion() {
		System.out.println("Nave " + id + " lista para explorar.");
	}

	@Override
	public void recibirDaño(int puntosAtaque) {
		if (puntosAtaque > this.energia) {
			this.energia = 0;
			this.estado = "destruida";
			System.out.println("Daño total, se ha destruido la nave");
			return;
		}
		this.energia -= puntosAtaque;
		System.out.println("Daño recibido, se ha reducido " + puntosAtaque + " de energía");
	}

	@Override
	public String toString() {
		return "ID: " + id + "\n" +
				"Nombre: " + nombre + "\n" +
				"Energía: " + energia + "\n" +
				"Estado: " + estado + "\n" +
				"Rango de visibilidad: " + rangoVisibilidad + "\n" +
				"Posición: " + fila + "," + columna;
	}

}
