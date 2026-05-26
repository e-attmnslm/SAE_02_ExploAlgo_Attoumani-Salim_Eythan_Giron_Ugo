import java.util.ArrayList;
import java.util.List;

public class Noeud {
    public String id;
    public String nom;
    public List<Arc> adj;

    public Noeud(String id, String nom) {
        this.id = id;
        this.nom = nom;
        this.adj = new ArrayList<>();
    }
}
