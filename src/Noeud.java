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
        StringBuilder string = new StringBuilder(this.nom + " - > ");
        List<Arc> liste = this.arcs.getListe();

        for (Arc arc : liste) {
            String nomCible = arc.getCible().toUpperCase();
            string.append(nomCible).append("(").append((int) arc.getPoids()).append(") ");
        }

        return string + "\n";
    }

    private double valeur;
    private Noeud parent;

    public double getValeur() { return valeur; }

    public void setValeur(double v) { this.valeur = v; }

    public Noeud getParent() { return parent; }

    public void setParent(Noeud p) { this.parent = p; }
}