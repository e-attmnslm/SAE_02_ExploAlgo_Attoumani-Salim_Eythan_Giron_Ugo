import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> liste = new ArrayList<Arc>();

    public void ajouter(Arc a){
        liste.add(a);
    }

    public List<Arc> getListe(){
        return this.liste;
    }
}
