import java.util.List;
import java.util.ArrayList;

/**
 * Implémentation de l'interface Graphe utilisant une liste de nœuds (Graphe représenté par listes d'adjacence).
 * Chaque nœud de la liste a ses propres arcs sortants vers ses voisins.
 *
 */
public class GrapheListe implements Graphe {

    /**
     * La liste contenant l'ensemble des nœuds (sommets) constituant le graphe.
     */
    public List<Noeud> noeuds = new ArrayList<>();

    /**
     * Ajoute un arc orienté et pondéré entre un nœud source existant et un nœud cible.
     * La méthode parcourt la liste des nœuds pour trouver le nœud source correspondant à l'identifiant fourni.
     *
     * @param source L'identifiant (nom) du nœud de départ de l'arc.
     * @param cible  L'identifiant (nom) du nœud de destination de l'arc.
     * @param poids  Le poids (coût, distance) associé à cet arc.
     */
    public void ajouter(String source, String cible, double poids) {
        for (Noeud n : noeuds) {
            if (n.getId().equals(source)) {
                n.getArcs().ajouter(new Arc(cible, poids));
            }
        }
    }

    /**
     * Ajoute un nouveau nœud au graphe.
     *
     * @param n L'objet Noeud à insérer dans le graphe.
     */
    public void ajouter(Noeud n) {
        this.noeuds.add(n);
    }

    /**
     * Génère une représentation textuelle globale de la structure du graphe.
     * Elle concatène la représentation de chaque nœud individuel contenu dans le graphe.
     *
     * @return Une chaîne de caractères représentant l'ensemble du graphe.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        this.noeuds.forEach(string::append);

        return string.toString();
    }

    /**
     * Récupère la liste de tous les nœuds du graphe.
     *
     * @return La liste (ArrayList) des objets Noeud.
     */
    @Override
    public List<Noeud> getNoeuds() {
        return this.noeuds;
    }

    /**
     * Récupère l'ensemble des arcs sortants attachés à un nœud spécifique.
     * Si le nœud fourni est null, une collection d'arcs vide est retournée par sécurité.
     *
     * @param noeud Le nœud dont on veut extraire les arcs adjacents.
     * @return Un objet Arcs contenant la liste des arcs du nœud, ou un objet Arcs vide si le nœud est null.
     */
    @Override
    public Arcs getArcs(Noeud noeud) {
        return noeud == null ? new Arcs() : noeud.getArcs();
    }
}