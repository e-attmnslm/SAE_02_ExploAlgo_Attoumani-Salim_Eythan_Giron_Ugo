import java.util.List;

/**
 * Représente un nœud (ou sommet) individuel dans un graphe.
 * Un nœud possède un identifiant unique, un nom descriptif, et gère la liste de ses arcs sortants.
 *
 */

public class Noeud {

    /**
     * L'identifiant unique du nœud .
     */
    private final String id;

    /**
     * Le nom d'affichage ou libellé du nœud.
     */
    private final String nom;

    /**
     * La collection des arcs sortants reliés aux nœuds adjacents.
     */
    private final Arcs arcs = new Arcs();

    /**
     * Constructeur permettant d'initialiser un nœud avec son identifiant et son nom.
     *
     * @param id  L'identifiant unique du nœud.
     * @param nom Le nom ou libellé du nœud.
     */
    public Noeud(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Retourne l'identifiant unique du nœud.
     *
     * @return L'identifiant sous forme de chaîne de caractères.
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne le nom ou libellé du nœud.
     *
     * @return Le nom du nœud.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la collection d'arcs sortants de ce nœud.
     *
     * @return Un objet Arcs contenant la liste des arcs adjacents.
     */
    public Arcs getArcs() {
        return arcs;
    }

    /**
     * Génère une représentation textuelle du nœud et de ses connexions directes.
     * Le format de sortie est : "NomDuNoeud - > CIBLE1(poids) CIBLE2(poids) ... \n",
     * où les noms des cibles sont convertis en majuscules et les poids convertis en entiers.
     *
     * @return Une chaîne de caractères décrivant le nœud et ses arcs sortants.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(this.nom + " - > ");
        List<Arc> liste = this.arcs.getListe();

        for (Arc arc : liste) {
            String nomCible = arc.getCible().toUpperCase();
            string.append(nomCible).append("(").append((int) arc.getPoids()).append(") ");
        }

        return string + "\n";
    }

    /**
     * Valeur numérique associée temporairement au nœud (ex: distance accumulée).
     */
    private double valeur;

    /**
     * Référence vers le nœud parent direct dans un arbre de parcours.
     */
    private Noeud parent;

    /**
     * Retourne la valeur temporaire actuellement stockée dans le nœud.
     *
     * @return La valeur sous forme de double.
     */
    public double getValeur() {return valeur;}

    /**
     * Modifie la valeur temporaire stockée dans le nœud.
     *
     * @param v La nouvelle valeur à attribuer.
     */
    public void setValeur(double v) {this.valeur = v;}

    /**
     * Retourne le nœud parent associé à ce nœud dans le cadre d'un chemin.
     *
     * @return L'objet Noeud parent, ou null s'il n'est pas défini.
     */
    public Noeud getParent() {return parent;}

    /**
     * Modifie ou définit le nœud parent de ce nœud.
     *
     * @p Le nouvel objet Noeud à définir comme parent.
     */
    public void setParent(Noeud p) {this.parent = p;}
}