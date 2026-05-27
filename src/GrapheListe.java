import java.util.List;
import java.util.ArrayList;

public class GrapheListe implements Graphe {

    public List<Noeud> noeuds = new ArrayList<>();

    public void ajouter(String source, String cible, double poids) {
        for (Noeud n : noeuds) {
            if (n.getId().equals(source)) {
                n.getArcs().ajouter(new Arc(cible, poids));
            }
        }
    }

    public void ajouter(Noeud n) {
        this.noeuds.add(n);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        this.noeuds.forEach(string::append);

        return string.toString();
    }

    @Override
    public List<Noeud> getNoeuds() {
        return this.noeuds;
    }

    @Override
    public Arcs getArcs(Noeud noeud) {
        return noeud == null ? new Arcs() : noeud.getArcs();
    }
}