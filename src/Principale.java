public class Principale {
    public static void main(String[] args) {
        Noeud a = new Noeud("a","A");
        Noeud b = new Noeud("b","B");
        Noeud c = new Noeud("c","C");
        Noeud d = new Noeud("d","D");
        Noeud e = new Noeud("e","E");

        Arc arcAB = new Arc(b,12);
        Arc arcAD = new Arc(d,87);
        Arc arcCA = new Arc(a,19);
        Arc arcDC = new Arc(c,10);
        Arc arcDB = new Arc(b,23);
        Arc arcBE = new Arc(e,11);
        Arc arcED = new Arc(e,43);

        a.ajouter(arcAB);
        a.ajouter(arcAD);
        c.ajouter(arcCA);
        d.ajouter(arcDC);
        d.ajouter(arcDB);
        b.ajouter(arcBE);
        e.ajouter(arcED);


    }
}
