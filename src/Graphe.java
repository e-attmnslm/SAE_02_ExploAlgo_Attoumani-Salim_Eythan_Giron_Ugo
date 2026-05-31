import java.util.List;

/**
 * Interface définissant la structure d'un graphe orienté et pondéré.
 */
public interface Graphe {

    /**
     * Récupère la liste de tous les nœuds présents dans le graphe.
     *
     * @return Une List contenant l'ensemble des objets Noeud du graphe.
     */
    List<Noeud> getNoeuds();

    /**
     * Récupère l'ensemble des arcs sortants associés à un nœud spécifique du graphe.
     * Cette méthode permet d'explorer les successeurs du nœud donné.
     *
     * @param noeud Le nœud dont on souhaite obtenir les arcs adjacents.
     * @return Un objet Arcs contenant la liste des arcs sortants de ce nœud.
     */
    Arcs getArcs(Noeud noeud);
}