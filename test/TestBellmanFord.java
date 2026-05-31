import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Suite de tests unitaires JUnit 5 pour valider la robustesse
 * et la justesse de l'algorithme de Bellman-Ford.
 */
public class TestBellmanFord {

    /**
     * TEST 1 : Vérifie qu'un chemin possédant un détour plus avantageux
     * est correctement privilégié par rapport à un arc direct plus lourd.
     */
    @Test
    public void testCheminStandard() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouter(new Noeud("A", "Station A"));
        graphe.ajouter(new Noeud("B", "Station B"));
        graphe.ajouter(new Noeud("C", "Station C"));
        graphe.ajouter(new Noeud("D", "Station D"));

        // Liaison directe lourde : A -> B (4.0)
        graphe.ajouter("A", "B", 4.0);
        // Détour plus avantageux : A -> C (2.0) puis C -> B (1.0) = coût total de 3.0
        graphe.ajouter("A", "C", 2.0);
        graphe.ajouter("C", "B", 1.0);

        graphe.ajouter("B", "D", 3.0);
        graphe.ajouter("C", "D", 5.0);

        Valeurs resultats = BellmanFord.resoudre(graphe, "A");

        // Assertions sur les coûts optimaux calculés
        assertEquals(0.0, resultats.getValeur("A"));
        assertEquals(2.0, resultats.getValeur("C"));
        assertEquals(3.0, resultats.getValeur("B"));
        assertEquals(6.0, resultats.getValeur("D"));

        // Validation de la reconstruction de l'itinéraire
        List<String> cheminObtenu = resultats.calculerChemin("D");
        List<String> cheminAttendu = new ArrayList<>();
        cheminAttendu.add("A");
        cheminAttendu.add("C");
        cheminAttendu.add("B");
        cheminAttendu.add("D");
        assertEquals(cheminAttendu, cheminObtenu, "Le chemin reconstruit doit être [A, C, B, D]");
    }

    /**
     * TEST 2 : Vérifie le comportement de sécurité de l'algorithme
     * face à un nœud déconnecté du réseau.
     */
    @Test
    public void testNoeudInaccessible() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouter(new Noeud("A", "Départ"));
        graphe.ajouter(new Noeud("B", "Station accessible"));
        graphe.ajouter(new Noeud("X", "Station isolée")); // Nœud sans aucun arc entrant ni sortant

        graphe.ajouter("A", "B", 1.5);

        Valeurs resultats = BellmanFord.resoudre(graphe, "A");

        // Le nœud accessible doit être mis à jour
        assertEquals(1.5, resultats.getValeur("B"));

        // Le nœud inaccessible doit conserver sa valeur infinie par défaut
        assertEquals(Double.MAX_VALUE, resultats.getValeur("X"), "Un nœud inaccessible doit rester à l'infini.");

        // Le chemin vers ce nœud doit renvoyer une liste vide sécurisée
        assertTrue(resultats.calculerChemin("X").isEmpty(), "Le chemin vers un nœud inaccessible doit être vide.");
    }


}