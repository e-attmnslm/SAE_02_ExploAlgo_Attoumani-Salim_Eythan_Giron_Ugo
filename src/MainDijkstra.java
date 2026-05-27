import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar MainDijkstra <StringDuNomDuDepart> <StringDuNomDarrive>");
            return;
        }
        String idDepart = getIdFromArg(args[0]);
        String idArrivee = getIdFromArg(args[1]);

        Graphe graphe = LireReseau.lire("STAN.GTFS/stan.nodes.txt", "STAN.GTFS/stan.edges.txt");
        Dijkstra dijkstra = new Dijkstra();
        Valeurs resultats = dijkstra.resoudre(graphe, idDepart);
        List<String> chemin = resultats.calculerChemin(idArrivee);

        System.out.println(chemin.isEmpty() ? "" : String.join(";", chemin));
    }

    public static String getIdFromArg(String arg) {
        return arg.contains("[") && arg.contains("]") ?  arg.substring(arg.lastIndexOf("[") + 1, arg.lastIndexOf("]")) : arg;
    }
}