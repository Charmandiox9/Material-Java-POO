/**
 * Clase base Mascota.
 */
class Mascota {
    public void hacerSonido() {
        System.out.println("La mascota hace un sonido.");
    }
}

class Perro extends Mascota {
    @Override
    public void hacerSonido() {
        System.out.println("El perro dice: ¡Guau!");
    }
}

class Gato extends Mascota {
    @Override
    public void hacerSonido() {
        System.out.println("El gato dice: ¡Miau!");
    }
}

class Pajaro extends Mascota {
    @Override
    public void hacerSonido() {
        System.out.println("El pájaro dice: ¡Pío!");
    }
}

public class MainMascotas {
    public static void main(String[] args) {
        // Demostración de Polimorfismo
        Mascota[] misMascotas = {
            new Perro(),
            new Gato(),
            new Pajaro()
        };

        for (Mascota m : misMascotas) {
            m.hacerSonido();
        }
    }
}
