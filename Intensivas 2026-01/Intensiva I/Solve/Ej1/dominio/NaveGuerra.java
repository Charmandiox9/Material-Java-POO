package dominio;

public class NaveGuerra extends Nave {
	private int poderAtaque;

	public NaveGuerra(String id, String nombre, double energia, int poderAtaque) {
		super(id, nombre, energia);
		this.poderAtaque = poderAtaque;
	}

	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	@Override
	public void realizarAccion() {
		System.out.println("Nave " + id + " lista para atacar.");
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
				"Poder de Ataque: " + poderAtaque + "\n" +
				"Posición: " + fila + "," + columna;
	}

}
