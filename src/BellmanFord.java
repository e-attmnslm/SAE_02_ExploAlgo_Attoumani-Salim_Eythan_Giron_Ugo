import java.util.List;

public class BellmanFord {

    /**
     *
     * @param g
     * @param depart
     * @return
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs res = new Valeurs();
        List<Noeud> noeuds = g.getNoeuds();
        double vMax = Double.MAX_VALUE;

        noeuds.forEach(n -> {
            res.setValeur(n.getId(), vMax);
            res.setParent(n.getId(), null);
        });

        res.setValeur(depart, 0.0);

        boolean valeurModifiee = true;
        while (valeurModifiee) {
            valeurModifiee = false;
            for (Noeud noeud : noeuds) {
                double valeurX = res.getValeur(noeud.getId());
                if (valeurX != vMax) {
                    List<Arc> arcs = noeud.getArcs().getListe();

                    for (Arc arc : arcs) {
                        String nom = arc.getCible();
                        double poids = arc.getPoids();
                        double estim = valeurX + poids;
                        double ancienneVal = res.getValeur(nom);
                        if (estim < ancienneVal) {
                            res.setValeur(nom, estim);
                            res.setParent(nom, noeud.getId());
                            valeurModifiee = true;
                        }
                    }
                }
            }
        }

        return res;
    }
}