import java.util.*;

public class Valeurs {

    Map<String, Double> valeur = new HashMap<>();
    Map<String, String> parent = new HashMap<>();


    public void setValeur(String nom, double valeur) {
        this.valeur.put(nom, valeur);
    }

    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }


    public String getParent(String nom) {
        return this.parent.get(nom);
    }


    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

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


    public List<String> calculerChemin(String cible) {
        List<String> chemin = new ArrayList<>();

        while (cible != null) {
            chemin.add(cible);
            cible = this.getParent(cible);
        }

        if (chemin.isEmpty() || (chemin.size() == 1 && this.getValeur(cible) == Double.MAX_VALUE)) {
            return new ArrayList<>();
        }

        Collections.reverse(chemin);
        return chemin;
    }

}