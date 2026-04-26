/**
 * Clase que simula un Reloj en formato 24 horas.
 */
public class Reloj {
    
    private int horas;
    private int minutos;
    private int segundos;

    public Reloj(int h, int m, int s) {
        setTiempo(h, m, s);
    }

    /**
     * Valida y asigna el tiempo inicial.
     */
    public void setTiempo(int h, int m, int s) {
        this.horas = (h >= 0 && h < 24) ? h : 0;
        this.minutos = (m >= 0 && m < 60) ? m : 0;
        this.segundos = (s >= 0 && s < 60) ? s : 0;
    }

    /**
     * Avanza el reloj un segundo, manejando el desbordamiento.
     */
    public void ticTac() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
            if (minutos == 60) {
                minutos = 0;
                horas++;
                if (horas == 24) {
                    horas = 0;
                }
            }
        }
    }

    /**
     * Retorna la hora formateada HH:MM:SS.
     */
    public String obtenerHora() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public static void main(String[] args) {
        Reloj miReloj = new Reloj(23, 59, 58);
        
        System.out.println("Inicio: " + miReloj.obtenerHora());
        miReloj.ticTac();
        System.out.println("Tictac: " + miReloj.obtenerHora());
        miReloj.ticTac();
        System.out.println("Tictac: " + miReloj.obtenerHora());
    }
}
