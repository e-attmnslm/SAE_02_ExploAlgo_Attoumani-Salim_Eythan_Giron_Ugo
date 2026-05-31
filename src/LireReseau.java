import java.io.*;
import java.util.Scanner;
/**
 * Cette classe extrait la structure d'un graphe à partir de fichiers de données textuels,
 * instancie les entités correspondantes et assemble le graphe en mémoire.
 */

public class LireReseau {

    /**
     * Lit les fichiers du réseau STAN et construit le graphe
     * @param fichier_stations Chemin vers le fichier des noeuds (stan.nodes.txt)
     * @param fichier_connexions Chemin vers le fichier des arcs (stan.edges.txt)
     * @return Le graphe complété
     */
    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe graphe = new GrapheListe();

        // Lecture des Noeuds
        try (BufferedReader br = new BufferedReader(new FileReader(fichier_stations))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (!ligne.trim().isEmpty()) {
                    String[] colonnes = ligne.split(";");
                    if (colonnes.length >= 2) {
                        String id = colonnes[0].trim();
                        String nom = colonnes[1].trim();
                        graphe.ajouter(new Noeud(id, nom));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture des stations : " + e.getMessage());
        }

        // Lecture des Arcs
        try (BufferedReader br = new BufferedReader(new FileReader(fichier_connexions))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (!ligne.trim().isEmpty()) {
                    String[] colonnes = ligne.split(";");
                    if (colonnes.length >= 3) {
                        String source = colonnes[0].trim();
                        String destination = colonnes[1].trim();
                        try {
                            double poids = Double.parseDouble(colonnes[2].trim());
                            graphe.ajouter(source, destination, poids);

                            graphe.ajouter(destination, source, poids);
                        } catch (NumberFormatException e) {
                            System.err.println("Poids invalide sur la ligne : " + ligne);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture des connexions : " + e.getMessage());
        }

        return graphe;
    }
}