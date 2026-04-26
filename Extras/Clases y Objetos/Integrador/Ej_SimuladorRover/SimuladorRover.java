class Superficie {
    private char[][] mapa;
    private int filas;
    private int columnas;

    public Superficie(int f, int c) {
        this.filas = f;
        this.columnas = c;
        this.mapa = new char[f][c];
        // Inicializar vacío
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                mapa[i][j] = '.';
            }
        }
    }

    public void colocarObstaculo(int f, int c) {
        if (esValida(f, c)) mapa[f][c] = 'X';
    }

    public void colocarMineral(int f, int c) {
        if (esValida(f, c)) mapa[f][c] = '*';
    }

    public boolean esValida(int f, int c) {
        return (f >= 0 && f < filas && c >= 0 && c < columnas);
    }

    public boolean hayObstaculo(int f, int c) {
        if (!esValida(f, c)) return true; // El borde actúa como obstáculo
        return mapa[f][c] == 'X';
    }

    public boolean hayMineral(int f, int c) {
        if (!esValida(f, c)) return false;
        return mapa[f][c] == '*';
    }

    public void extraerMineral(int f, int c) {
        if (esValida(f, c)) mapa[f][c] = '.';
    }
}

class Rover {
    private int filaActual;
    private int colActual;
    private char orientacion; // 'N' (Norte), 'S' (Sur), 'E' (Este), 'O' (Oeste)
    private int bateria;
    private String[] inventario;
    private Superficie superficie;

    public Rover(int f, int c, char o, int bat, Superficie sup) {
        this.filaActual = f;
        this.colActual = c;
        this.orientacion = o;
        this.bateria = bat;
        this.inventario = new String[3]; // Max 3 minerales
        this.superficie = sup;
    }

    public void girarDerecha() {
        if (bateria < 1) return;
        bateria -= 1;
        switch (orientacion) {
            case 'N': orientacion = 'E'; break;
            case 'E': orientacion = 'S'; break;
            case 'S': orientacion = 'O'; break;
            case 'O': orientacion = 'N'; break;
        }
        System.out.println("[Giro Derecha] Orientación: " + orientacion + ". Batería: " + bateria);
    }

    public void girarIzquierda() {
        if (bateria < 1) return;
        bateria -= 1;
        switch (orientacion) {
            case 'N': orientacion = 'O'; break;
            case 'O': orientacion = 'S'; break;
            case 'S': orientacion = 'E'; break;
            case 'E': orientacion = 'N'; break;
        }
        System.out.println("[Giro Izquierda] Orientación: " + orientacion + ". Batería: " + bateria);
    }

    public void avanzar(int casillas) {
        int avanzadas = 0;
        String motivoParada = "Destino alcanzado";

        for (int i = 0; i < casillas; i++) {
            if (bateria < 5) {
                motivoParada = "Batería agotada";
                break;
            }

            int proxF = filaActual;
            int proxC = colActual;

            if (orientacion == 'N') proxF--;
            else if (orientacion == 'S') proxF++;
            else if (orientacion == 'E') proxC++;
            else if (orientacion == 'O') proxC--;

            if (superficie.hayObstaculo(proxF, proxC) || !superficie.esValida(proxF, proxC)) {
                motivoParada = "Borde/Obstáculo detectado";
                break;
            }

            filaActual = proxF;
            colActual = proxC;
            bateria -= 5;
            avanzadas++;
        }
        System.out.println("[Avanzando " + avanzadas + " casillas] Detenido en (" + filaActual + "," + colActual + "). Motivo: " + motivoParada + ". Batería: " + bateria);
    }

    public void recolectar() {
        if (bateria < 10) {
            System.out.println("[Error] Batería insuficiente para recolectar.");
            return;
        }
        
        if (superficie.hayMineral(filaActual, colActual)) {
            boolean guardado = false;
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i] == null) {
                    inventario[i] = "Mineral_Coord_" + filaActual + "_" + colActual;
                    superficie.extraerMineral(filaActual, colActual);
                    bateria -= 10;
                    guardado = true;
                    System.out.println("[Recolectando...] Mineral guardado. Batería: " + bateria);
                    break;
                }
            }
            if (!guardado) {
                System.out.println("[Error] Inventario lleno.");
            }
        } else {
            System.out.println("[Error] No hay minerales en esta casilla.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n--- ESTADO DEL ROVER ---");
        System.out.println("Posición: (" + filaActual + ", " + colActual + ") | Orientación: " + orientacion);
        System.out.println("Batería: " + bateria + "%");
        System.out.print("Inventario: [");
        for (int i = 0; i < inventario.length; i++) {
            System.out.print((inventario[i] == null ? "Vacío" : inventario[i]) + (i < inventario.length - 1 ? ", " : ""));
        }
        System.out.println("]\n");
    }
}

public class SimuladorRover {
    public static void main(String[] args) {
        Superficie marte = new Superficie(5, 5);
        marte.colocarMineral(2, 0);
        marte.colocarObstaculo(3, 0);

        // Inicia en (0,0) mirando al Sur
        Rover rover = new Rover(0, 0, 'S', 100, marte);
        
        rover.avanzar(4); 
        rover.recolectar(); 
        rover.girarIzquierda(); 
        rover.mostrarEstado();
    }
}
