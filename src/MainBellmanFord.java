import java.util.List;
/**
 * Cette classe permet de charger le réseau de transport STAN à partir de fichiers de données,
 * d'extraire les identifiants de départ et d'arrivée depuis les arguments de la ligne de commande,
 * puis d'afficher le plus court chemin calculé sous la forme d'une chaîne .
 *
 */

public class MainBellmanFord {
    /**
     * Méthode principale exécutant la recherche de chemin via l'algorithme de Bellman-Ford.
     * Elle valide la présence des paramètres requis, extrait les identifiants des stations
     * en réutilisant la logique de décodage de MainDijkstra, charge le graphe en mémoire,
     * calcule l'arborescence des chemins minimaux et écrit l'itinéraire trouvé sur la
     * sortie .
     *
     * @param args Tableau d'arguments de la ligne de commande.
     * args[0] : Chaîne ou libellé contenant l'identifiant du nœud de départ.
     * args[1] : Chaîne ou libellé contenant l'identifiant du nœud d'arrivée.
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar MainBellmanFord <StringDuNomDuDepart> <StringDuNomDarrive>");
            return;
        }

        String depart = MainDijkstra.getIdFromArg(args[0]);
        String arrivee = MainDijkstra.getIdFromArg(args[1]);

        Graphe graphe = LireReseau.lire("STAN.GTFS/stan.nodes.txt", "STAN.GTFS/stan.edges.txt");

        List<String> chemin = BellmanFord.resoudre(graphe, depart).calculerChemin(arrivee);

        System.out.println(chemin.isEmpty() ? "" : String.join(";", chemin));
    }
}
