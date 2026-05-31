import java.util.List;

/**
 * Classe pour la résolution
 * du problème des plus courts chemins dans un graphe.
 * Cet algorithme prend en compte les graphes orientés et pondérés, et permet de
 * déterminer les distances minimales depuis un sommet de départ unique.
 *

 */
public class BellmanFord {

    /**
     * Résout le problème du plus court chemin depuis un nœud de départ donné
     * en utilisant l'algorithme de Bellman-Ford .
     *
     * @param g      Le graphe sur lequel appliquer l'algorithme.
     * @param depart L'identifiant  du nœud de départ de l'itinéraire.
     * @return Un objet Valeurs contenant les distances minimales trouvées et les parents de chaque nœud.
     */
    public static Valeurs resoudre(Graphe g, String depart) {
        Valeurs res = new Valeurs();
        List<Noeud> noeuds = g.getNoeuds();
        double vMax = Double.MAX_VALUE;

        // Initialisation de tous les nœuds avec une distance infinie et aucun parent
        noeuds.forEach(n -> {
            res.setValeur(n.getId(), vMax);
            res.setParent(n.getId(), null);
        });

        // La distance du point de départ vers lui-même est de 0
        res.setValeur(depart, 0.0);

        boolean valeurModifiee = true;
        // Boucle d'ajustement (relaxation des arcs) tant que des améliorations de distance sont trouvées
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
                        // Si un chemin plus court vers le nœud cible est découvert
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