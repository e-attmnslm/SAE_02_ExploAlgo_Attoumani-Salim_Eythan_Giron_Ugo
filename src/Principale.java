/**
 * Classe d'exécution principale de démonstration et de validation initiale.
 * Cette classe permet de tester manuellement la construction de la structure d'un
 * graphe (représenté par la figure 1 du sujet de SAÉ) en instanciant des nœuds,
 * en créant des connexions et en affichant la structure finale en mémoire.
 *

 */
public class Principale {
    public static void main (String[] args){

        GrapheListe figure1 = new GrapheListe();

        Noeud a = new Noeud("a","A");
        Noeud b = new Noeud("b","B");
        Noeud c = new Noeud("c","C");
        Noeud d = new Noeud("d","D");
        Noeud e = new Noeud("e","E");

        figure1.ajouter(a);
        figure1.ajouter(b);
        figure1.ajouter(c);
        figure1.ajouter(d);
        figure1.ajouter(e);

        figure1.ajouter("a","b",12);
        figure1.ajouter("a","d",87);
        figure1.ajouter("b","e",11);
        figure1.ajouter("c","a",19);
        figure1.ajouter("d","c",10);
        figure1.ajouter("d","b",23);
        figure1.ajouter("e","d",43);

        System.out.println(figure1.toString());




    }
}
