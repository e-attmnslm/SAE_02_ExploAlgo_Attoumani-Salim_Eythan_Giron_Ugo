import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour la résolution
 * du problème des plus courts chemins dans un graphe.
 * Cet algorithme calcule les distances minimales depuis un sommet initial unique.
 *
 *
 */

public class Dijkstra {

    /**
     * Résout le problème du plus court chemin depuis un nœud de départ donné
     * en utilisant l'algorithme de Dijkstra .
     *
     * @param g     Le graphe orienté et pondéré à analyser.
     * @param debut L'identifiant  du nœud de départ.
     * @return Un objet Valeurs contenant les distances minimales et les parents de chaque nœud.
     */
    public static Valeurs resoudre(Graphe g, String debut) {

        Valeurs resultats = new Valeurs();
        List<Noeud> list = new ArrayList<>();
        List<Noeud> noeuds = g.getNoeuds();

        // Initialisation : tous les nœuds ont une distance infinie, aucun parent, et sont ajoutés à la liste des nœuds à traiter
        noeuds.forEach(n -> {
            resultats.setValeur(n.getId(), Double.MAX_VALUE);
            resultats.setParent(n.getId(), null);
            list.add(n);
        });

        // La distance du nœud initial vers lui-même est de 0
        resultats.setValeur(debut, 0);

        // Boucle principale : tant qu'il reste des nœuds non traités
        while (!list.isEmpty()) {

            // Recherche du nœud possédant la distance minimale actuelle
            Noeud noeud = trouverMin(list, resultats);
            list.remove(noeud);

            // Relâchement des arcs sortants du nœud pivot
            for (Arc arc : noeud.getArcs().getListe()) {
                Noeud noeud2 = chercherNoeud(noeuds, arc.getCible());
                // On ne met à jour le nœud cible que s'il est valide et pas encore définitivement traité
                if (noeud2 != null && list.contains(noeud2)) {
                    double d = resultats.getValeur(noeud.getId()) + arc.getPoids();

                    // Si un chemin plus court est découvert vers noeud2
                    if (d < resultats.getValeur(noeud2.getId())) {
                        resultats.setValeur(noeud2.getId(), d);
                        resultats.setParent(noeud2.getId(), noeud.getId());
                    }
                }
            }
        }
        return resultats;
    }

    /**
     * Méthode permettant de trouver le nœud ayant la plus petite valeur de distance
     * parmi une liste de nœuds donnée.
     *
     * @param q   La liste des nœuds restants à analyser.
     * @param vls L'objet contenant les distances actuellement calculées pour chaque nœud.
     * @return Le nœud possédant la distance minimale dans la liste.
     */
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

    /**
     * Méthode permettant de rechercher un objet Noeud dans une liste
     * à partir de son identifiant.
     *
     * @param liste La liste de nœuds dans laquelle chercher.
     * @param id    L'identifiant du nœud recherché.
     * @return L'objet Noeud correspondant, ou null si aucun nœud ne possède cet identifiant.
     */
    private static Noeud chercherNoeud(List<Noeud> liste, String id) {
        for (Noeud n : liste) {
            if (n.getId().equals(id)) return n;
        }
        return null;
    }

}