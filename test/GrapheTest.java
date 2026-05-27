import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrapheTest {

    @Test
    void testCreationNoeudEtArc() {
        // Test de la classe Noeud
        Noeud n = new Noeud("A", "Sommet A");
        assertEquals("A", n.getIdt());
        assertEquals("Sommet A", n.getNom());

        // Test de la classe Arc
        Arc a = new Arc(10.5, "B");

        @Test
        void testAjoutNoeudEtArcDansGraphe() {
            GrapheListe graphe = new GrapheListe();

            Noeud n1 = new Noeud("A", "Source");
            graphe.ajouter(n1);
            assertEquals(1, graphe.recupNoeud().size());


            graphe.ajouter("A", "B", 5.0);
            Arcs adj = graphe.recupAdj(n1);
            assertEquals(1, adj.getLiArc().size());
            assertEquals("B", adj.getLiArc().get(0).getCible());
        }

        @Test
        void testAjoutArcNoeudInexistant() {
            GrapheListe graphe = new GrapheListe();
            graphe.ajouter(new Noeud("A", "Source"));
            graphe.ajouter("Z", "B", 5.0);
            assertEquals(0, graphe.recupAdj(graphe.recupNoeud().get(0)).getLiArc().size());
        }

    }
}
