import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrapheTest {

    @Test
    public void testCreationNoeudEtArc() {
        Noeud n = new Noeud("A", "Sommet A");
        assertEquals("A", n.getId());
        assertEquals("Sommet A", n.getNom());

        Arc a = new Arc("A", 1);
        assertEquals("A", a.getCible());
        assertEquals(1, a.getPoids());
    }

    @Test
    public void testAjoutNoeudEtArcDansGraphe() {
        GrapheListe graphe = new GrapheListe();

        Noeud n1 = new Noeud("A", "Source");
        graphe.ajouter(n1);
        assertEquals(1, graphe.getNoeuds().size());


        graphe.ajouter("A", "B", 5.0);
        Arcs adj = graphe.getArcs(n1);
        assertEquals(1, adj.getListe().size());
        assertEquals("B", adj.getListe().getFirst().getCible());
    }

    @Test
    public void testAjoutArcNoeudInexistant() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouter(new Noeud("A", "Source"));
        graphe.ajouter("Z", "B", 5.0);
        assertEquals(0, graphe.getArcs(graphe.getNoeuds().getFirst()).getListe().size());
    }

}