import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class MainTransport {

    public static void main(String[] args) {

        if (args.length < 2) {
            return;
        }

        String depart = recupererIdentifiant(args[0]);
        String arrivee = recupererIdentifiant(args[1]);

        Graphe graphe = LireReseau.lire(
                "STAN.GTFS/stan.nodes.txt",
                "STAN.GTFS/stan.edges.txt"
        );

        long startDijkstra = System.nanoTime();
        Valeurs resultatDijkstra = Dijkstra.resoudre(graphe, depart);
        long endDijkstra = System.nanoTime();

        long startBellman = System.nanoTime();
        Valeurs resultatBellman = BellmanFord.resoudre(graphe, depart);
        long endBellman = System.nanoTime();

        List<String> trajet = resultatDijkstra.calculerChemin(arrivee);

        if (trajet.isEmpty()) {
            System.out.println();
        } else {
            System.out.println(String.join(";", trajet));
        }

        enregistrerPerformances(
                depart,
                arrivee,
                startDijkstra,
                endDijkstra,
                startBellman,
                endBellman
        );
    }

    private static void enregistrerPerformances(
            String depart,
            String arrivee,
            long debutD,
            long finD,
            long debutB,
            long finB
    ) {

        double tempsDijkstra = (finD - debutD) / 1_000_000.0;
        double tempsBellman = (finB - debutB) / 1_000_000.0;

        try (
                FileWriter writer = new FileWriter("resultats_perf.log", true);
                PrintWriter sortie = new PrintWriter(writer)
        ) {

            sortie.println("Station départ : " + depart);
            sortie.println("Station arrivée : " + arrivee);
            sortie.println("Durée Dijkstra : " + tempsDijkstra + " ms");
            sortie.println("Durée Bellman-Ford : " + tempsBellman + " ms");
            sortie.println();

            System.err.println("Log sauvegardé.");

        } catch (IOException exception) {
            System.err.println("Impossible d'écrire le fichier : " + exception.getMessage());
        }
    }

    private static String recupererIdentifiant(String texte) {

        int debut = texte.lastIndexOf('[');
        int fin = texte.lastIndexOf(']');

        if (debut != -1 && fin != -1 && debut < fin) {
            return texte.substring(debut + 1, fin);
        }

        return texte;
    }
}