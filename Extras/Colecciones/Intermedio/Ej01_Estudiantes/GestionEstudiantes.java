import java.util.ArrayList;

class Estudiante {
    private String nombre;
    private double nota;

    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() { return nombre; }
    public double getNota() { return nota; }
}

public class GestionEstudiantes {
    public static void main(String[] args) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("Ana", 8.5));
        lista.add(new Estudiante("Pedro", 9.2));
        lista.add(new Estudiante("Luis", 7.0));

        Estudiante mejor = lista.get(0);

        for (Estudiante e : lista) {
            if (e.getNota() > mejor.getNota()) {
                mejor = e;
            }
        }

        System.out.println("El mejor estudiante es " + mejor.getNombre() + " con una nota de " + mejor.getNota() + ".");
    }
}
