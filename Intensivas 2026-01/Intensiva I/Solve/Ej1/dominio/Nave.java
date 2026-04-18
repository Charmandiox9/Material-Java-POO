package dominio;

public abstract class Nave {
	protected String id;
	protected String nombre;
	protected double energia;
	protected String estado;
	protected int fila;
	protected int columna;

	public Nave(String id, String nombre, double energia) {
		this.id = id;
		this.nombre = nombre;
		this.energia = energia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getEnergia() {
		return energia;
	}

	public void setEnergia(double energia) {
		this.energia = energia;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public abstract void realizarAccion();

	public abstract void recibirDaño(int puntosAtaque);

	@Override
	public String toString() {
		return "Nave [id=" + id + ", nombre=" + nombre + ", energia=" + energia + "]";
	}

}
