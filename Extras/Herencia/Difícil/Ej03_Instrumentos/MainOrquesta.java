/**
 * Clase abstracta Instrumento.
 */
abstract class Instrumento {
    public void afinar() {
        System.out.println("Afinando el instrumento... Listo.");
    }

    public abstract void tocar();
}

class Guitarra extends Instrumento {
    @Override
    public void tocar() {
        System.out.println("Tocando la guitarra: ¡Strum! ¡Strum!");
    }
}

class Piano extends Instrumento {
    @Override
    public void tocar() {
        System.out.println("Tocando el piano: ¡Plink! ¡Plonk!");
    }
}

public class MainOrquesta {
    public static void main(String[] args) {
        Instrumento[] orquesta = { new Guitarra(), new Piano() };

        for (Instrumento i : orquesta) {
            i.afinar();
            i.tocar();
        }
    }
}
