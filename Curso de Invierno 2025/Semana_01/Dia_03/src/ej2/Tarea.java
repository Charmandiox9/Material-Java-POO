package ej2;

public class Tarea {
	private String tarea;
	private int prioridad;
	private String encargado;
	
	public Tarea(String tarea, int prioridad, String encargado){
		this.tarea = tarea;
		this.prioridad = prioridad;
		this.encargado = encargado;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	@Override
	public String toString() {
		return "Tarea [tarea=" + tarea + ", prioridad=" + prioridad + ", encargado=" + encargado + "]";
	}
	
	
}
