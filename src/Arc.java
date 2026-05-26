public class Arc {
    public int poids;
    public Noeud cible;

    public Arc(Noeud noeud, int poids) {
        this.cible = noeud;
        this.poids = poids;
    }
}
