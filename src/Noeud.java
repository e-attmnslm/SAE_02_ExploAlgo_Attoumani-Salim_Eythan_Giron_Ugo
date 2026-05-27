import java.util.List;


public class Noeud{

    private final String id;
    private final String nom;
    private final Arcs arcs = new Arcs();

    public Noeud(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }


    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }


    public Arcs getArcs() {
        return arcs;
    }


    public String toString() {
        String string = this.nom + " - > ";
        List<Arc> liste = this.arcs.getListe();

        for (int i = 0; i < liste.size(); i++) {
            Arc arc = liste.get(i);
            String nomCible = arc.getCible().toUpperCase();

            string = string + nomCible + "(" + (int)arc.getPoids() + ") ";
        }
        return string + "\n";
    }

    private double valeur;
    private Noeud parent;

    /**
     *
     * @return
     */
    public double getValeur() { return valeur; }

    /**
     *
     * @param v
     */
    public void setValeur(double v) { this.valeur = v; }

    /**
     *
     * @return
     */
    public Noeud getParent() { return parent; }

    /**
     *
     * @param p
     */
    public void setParent(Noeud p) { this.parent = p; }
}