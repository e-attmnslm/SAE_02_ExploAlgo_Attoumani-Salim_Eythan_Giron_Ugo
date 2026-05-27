import java.util.List;

public class MainBellmanFord {
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
