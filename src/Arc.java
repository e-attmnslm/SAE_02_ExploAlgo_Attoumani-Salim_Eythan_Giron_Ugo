public class Arc {
    private double poids;
    private String cible;

    public Arc(String noeud, double poids) {
        this.cible = noeud;
        this.poids = poids;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }
}
