import java.util.ArrayList;
import java.util.List;

/**
 * Représente une collection d'arcs sortants d'un nœud dans un graphe.
 * Cette classe encapsule une liste d'objets d'Arc pour faciliter la manipulation
 * des adjacences d'un sommet.
 *
 *
 */
public class Arcs {

    /**
     * La liste contenant l'ensemble des arcs interconnectés.
     */
    private List<Arc> liste = new ArrayList<>();

    /**
     * Ajoute un nouvel arc à la collection.
     *
     * @param a L'objet Arc à ajouter à la liste.
     */
    public void ajouter(Arc a) {
        liste.add(a);
    }

    /**
     * Retourne la liste de tous les arcs contenus dans cette collection.
     *
     * @return Une listes d'objets d'Arc.
     */
    public List<Arc> getListe() {
        return liste;
    }
}