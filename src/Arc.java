/**
 * Représente un arc orienté et pondéré dans un graphe.
 * Un arc possède une destination (cible) et un coût associé (poids).

 */
public class Arc {

    /**
     * Le poids  associé à cet arc.
     */
    private double poids;

    /**
     * l'identifiant du nœud de destination .
     */
    private String cible;

    /**
     * Constructeur permettant d'initialiser un arc avec sa cible et son poids.
     *
     * @param noeud l'identifiant du nœud vers lequel pointe l'arc.
     * @param poids Le poids (distance, temps, coût) de cet arc.
     */
    public Arc(String noeud, double poids) {
        this.cible = noeud;
        this.poids = poids;
    }

    /**
     * Retourne le poids de l'arc.
     *
     * @return Le poids sous forme de double.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Modifie le poids de l'arc.
     *
     * @param poids Le nouveau poids à appliquer.
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Retourne l'identifiant du nœud cible (la destination de l'arc).
     *
     * @return Une chaîne de caractères représentant le nœud cible.
     */
    public String getCible() {
        return cible;
    }

    /**
     * Modifie le nœud cible de l'arc.
     *
     * @param cible l'identifiant du nouveau nœud cible.
     */
    public void setCible(String cible) {
        this.cible = cible;
    }
}