package banque;

import java.util.LinkedList;

public class FileAttente extends LinkedList<Client> {

    private Banque banque;
    private int longueurMax;

    public FileAttente(Banque banque){
        this.banque = banque;
    }

    public boolean estVide() {
        return this.isEmpty();
    }

    public int getLongueurMax() {
        return longueurMax;
    }

    public double longueurMoyenne() {
        return 0;
    }
    public double tempsMoyenAttente() {
        return 0;
    }

    public void ajouter(Client c){
        this.add(c);
        if (this.size() > this.longueurMax) {
            this.longueurMax = this.size();
        }
    }

    public Client retirer(){
        return this.pop();
    }
}
