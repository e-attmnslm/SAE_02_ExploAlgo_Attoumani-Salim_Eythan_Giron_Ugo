import java.util.ArrayList;
import java.util.List;


public class Dijkstra {

    public static Valeurs resoudre(Graphe g, String debut) {

        Valeurs resultats = new Valeurs();
        List<Noeud> list = new ArrayList<>();
        List<Noeud> noeuds = g.getNoeuds();

        noeuds.forEach(n -> {
            resultats.setValeur(n.getId(), Double.MAX_VALUE);
            resultats.setParent(n.getId(), null);
            list.add(n);
        });

        resultats.setValeur(debut, 0);

        while (!list.isEmpty()) {

            Noeud noeud = trouverMin(list, resultats);
            list.remove(noeud);

            for (Arc arc : noeud.getArcs().getListe()) {
                Noeud noeud2 = chercherNoeud(noeuds, arc.getCible());
                if (noeud2 != null && list.contains(noeud2)) {
                    double d = resultats.getValeur(noeud.getId()) + arc.getPoids();

                    if (d < resultats.getValeur(noeud2.getId())) {
                        resultats.setValeur(noeud2.getId(), d);
                        resultats.setParent(noeud2.getId(), noeud.getId());
                    }
                }
            }
        }
        return resultats;
    }

    private static Noeud trouverMin(List<Noeud> q, Valeurs vls) {
        Noeud min = q.get(0);
        for (Noeud n : q) {
            // Comparaison des valeurs stockées dans l'objet Valeurs
            if (vls.getValeur(n.getId()) < vls.getValeur(min.getId())) {
                min = n;
            }
        }
        return min;
    }

    private static Noeud chercherNoeud(List<Noeud> liste, String id) {
        for (Noeud n : liste) {
            if (n.getId().equals(id)) return n;
        }
        return null;
    }

}

