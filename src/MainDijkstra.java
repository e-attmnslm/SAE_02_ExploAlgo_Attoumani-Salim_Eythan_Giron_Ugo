import java.util.List;
/**
 * Cette classe permet de charger le réseau de transport STAN à partir de fichiers de données,
 * d'extraire les identifiants de départ et d'arrivée depuis les arguments de la ligne de commande,
 * puis d'afficher le plus court chemin calculé sous la forme d'une chaîne .
 *
 */

public class MainDijkstra {
    /**
     * Méthode principale exécutant la recherche de chemin via l'algorithme de Dijkstra.
     * Elle valide la présence des paramètres requis, extrait les identifiants des stations,
     * charge le graphe en mémoire, résout le plus court chemin et écrit le résultat sur la
     * sortie .
     *
     * @param args Tableau d'arguments de la ligne de commande.
     * args[0] : Chaîne ou libellé contenant l'identifiant du nœud de départ.
     * args[1] : Chaîne ou libellé contenant l'identifiant du nœud d'arrivée.
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar MainDijkstra <StringDuNomDuDepart> <StringDuNomDarrive>");
            return;
        }
        String idDepart = getIdFromArg(args[0]);
        String idArrivee = getIdFromArg(args[1]);

        Graphe graphe = LireReseau.lire("STAN.GTFS/stan.nodes.txt", "STAN.GTFS/stan.edges.txt");
        List<String> chemin = Dijkstra.resoudre(graphe, idDepart).calculerChemin(idArrivee);

        System.out.println(chemin.isEmpty() ? "" : String.join(";", chemin));
    }

    /**
     * Extrait l'identifiant d'un nœud à partir d'un argument textuel.
     * Si l'argument contient des crochets (ex: "Gare [1234]"), la méthode isole et
     * retourne le contenu situé entre les derniers crochets rencontrés ("1234").
     * Sinon, elle retourne l'argument .
     *
     * @param arg La chaîne de caractères brute passée en paramètre.
     * @return L'identifiant extrait ou la chaîne d'origine si aucun crochet n'est détecté.
     */

    public static String getIdFromArg(String arg) {
        return arg.contains("[") && arg.contains("]") ?  arg.substring(arg.lastIndexOf("[") + 1, arg.lastIndexOf("]")) : arg;
    }
}