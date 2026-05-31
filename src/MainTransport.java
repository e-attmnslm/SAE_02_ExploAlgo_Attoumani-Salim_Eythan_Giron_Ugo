import java.util.List;
/**
 * Point d'entrée principal pour l'évaluation et la comparaison des performances du réseau STAN.
 * Cette classe charge l'intégralité de la structure du réseau depuis les fichiers physiques
 * GTFS, résout le problème du plus court chemin en utilisant simultanément les algorithmes
 * de Dijkstra et de Bellman-Ford, puis mesure précisément leurs temps d'exécution respectifs
 * en millisecondes.
 */

public class MainTransport {

    public static void main(String[] args) {

        if (args.length < 2) {
            return;
        }

        String depart = MainDijkstra.getIdFromArg(args[0]);
        String arrivee = MainDijkstra.getIdFromArg(args[1]);

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

        double tempsDijkstra = (endDijkstra - startDijkstra) / 1_000_000.0;
        double tempsBellman = (endBellman - startBellman) / 1_000_000.0;

        System.out.println("Station départ : " + depart);
        System.out.println("Station arrivée : " + arrivee);
        System.out.println("Durée Dijkstra : " + tempsDijkstra + " ms");
        System.out.println("Durée Bellman-Ford : " + tempsBellman + " ms");
    }

}