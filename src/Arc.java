public class Arc {
    private int poids;
    private String cible;

    public Arc(String idNoeudCible, int poids) {
        this.cible = idNoeudCible;
        this.poids = poids;
    }
}
