import java.util.List;

public interface Graphe {
    List<Noeud> getNoeuds();
    Arcs getArcs(Noeud noeud);
}
