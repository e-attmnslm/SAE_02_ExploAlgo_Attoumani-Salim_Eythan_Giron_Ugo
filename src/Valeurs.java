import java.util.*;

/**
 * Classe de stockage des résultats intermédiaires et finaux pour les algorithmes
 * de recherche de chemins (tels que Dijkstra et Bellman-Ford).
 * Elle maintient à l'aide de tables de hachage (Map) les coûts cumulés pour atteindre
 * chaque nœud ainsi que le prédécesseur (parent) de chacun d'eux afin de pouvoir
 * reconstituer les itinéraires minimaux.
 *

 */
public class Valeurs {

    /**
     * Association entre l'identifiant d'un nœud et sa valeur numérique calculée
     * (généralement la distance cumulée minimale depuis le nœud de départ).
     */
    private final Map<String, Double> valeur = new HashMap<>();

    /**
     * Association entre l'identifiant d'un nœud et l'identifiant de son nœud parent
     * direct dans l'arborescence des plus courts chemins.
     */
    private final Map<String, String> parent = new HashMap<>();

    /**
     * Enregistre ou met à jour la valeur (distance/coût) associée à un nœud donné.
     *
     * @param nom    L'identifiant du nœud cible.
     * @param valeur La nouvelle distance ou coût à attribuer à ce nœud.
     */

    public void setValeur(String nom, double valeur) {
        this.valeur.put(nom, valeur);
    }

    /**
     * Enregistre ou met à jour le nœud parent (prédécesseur) d'un nœud donné.
     *
     * @param nom    L'identifiant du nœud dont on définit le parent.
     * @param parent L'identifiant du nœud parent choisi.
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * Récupère l'identifiant du nœud parent associé au nœud demandé.
     * @param nom L'identifiant du nœud dont on cherche le parent.
     * @return L'identifiant du nœud parent, ou null si aucun parent n'est défini.
     */

    public String getParent(String nom) {
        return this.parent.get(nom);
    }

    /**
     * Récupère la valeur numérique (distance/coût) actuellement associée au nœud demandé.
     *
     * @param nom L'identifiant du nœud.
     * @return La valeur sous forme de double (peut renvoyer Double.MAX_VALUE si non atteint).
     */

    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * Génère une représentation textuelle globale de l'ensemble des résultats stockés.
     * Le format de sortie pour chaque nœud est : "{id_noeud: [valeur, id_parent]}".
     *
     * @return Une chaîne de caractères contenant l'état de l'ensemble des valeurs et des parents.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        List<String> keys = new ArrayList<>(this.valeur.keySet());
        keys.forEach(key -> {
            Double valeurNoeud = valeur.get(key);
            String noeudParent = parent.get(key);
            string.append("{%s: [%.2f, %s]}".formatted(key, valeurNoeud, noeudParent));
        });

        return string.toString();
    }

    /**
     * Reconstitue le chemin optimal complet menant à un nœud cible donné,
     * en remontant la chaîne des parents de proche en proche à partir de la cible.
     * La liste finale est inversée pour présenter le chemin dans le sens chronologique
     * (du départ à l'arrivée).
     *
     * @param cible L'identifiant du nœud de destination dont on souhaite tracer le chemin.
     * @return Une List de chaînes de caractères représentant la suite ordonnée des nœuds à parcourir,
     * ou une liste vide si le chemin est inaccessible ou inexistant.
     */
    public List<String> calculerChemin(String cible) {
        if (cible == null) {
            return new ArrayList<>();
        }

        List<String> chemin = new ArrayList<>();
        String cibleOrigine = cible;

        while (cible != null) {
            chemin.add(cible);
            cible = this.getParent(cible);
        }

        if (chemin.isEmpty() || (chemin.size() == 1 && this.getValeur(cibleOrigine) == Double.MAX_VALUE)) {
            return new ArrayList<>();
        }

        Collections.reverse(chemin);
        return chemin;
    }

}