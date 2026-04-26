import java.util.ArrayList;
import java.util.Collections;

public class PlaylistPro {
    public static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C (remix)");
        playlist.add("Song D");

        System.out.println("Original: " + playlist);

        // 1. Mover Song B (indice 1) al indice 3
        Collections.swap(playlist, 1, 3);
        System.out.println("Tras mover B: " + playlist);

        // 2. Eliminar canciones con "remix"
        // Nota académica: Recorrer de atrás hacia adelante para eliminar seguro
        for (int i = playlist.size() - 1; i >= 0; i--) {
            if (playlist.get(i).contains("remix")) {
                playlist.remove(i);
            }
        }
        System.out.println("Tras eliminar remix: " + playlist);

        // 3. Invertir
        Collections.reverse(playlist);
        System.out.println("Playlist Final (invertida): " + playlist);
    }
}
