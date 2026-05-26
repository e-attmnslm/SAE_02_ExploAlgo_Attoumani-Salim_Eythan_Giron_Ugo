import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    public Arcs arcs;

    @Override
    public List<Noeud> getNoeuds() {
        return arcs.getListe()
                .stream()
                .map(arc -> arc.cible)
                .toList();
    }

    @Override
    public List<Arc> getArcs() {
        return arcs.getListe();
    }


}
