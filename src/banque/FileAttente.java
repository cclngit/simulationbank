package banque;

import java.util.LinkedList;

public class FileAttente extends LinkedList<Client> {

    private Banque banque;

    public FileAttente(Banque banque){
        this.banque = banque;
    }

    public boolean estVide() {
        return this.isEmpty();
    }

    public int longueurMax() {
        return 0;
    }
    public double longueurMoyenne() {
        return 0;
    }
    public double tempsMoyenAttente() {
        return 0;
    }

    public void ajouter(Client c){
        this.add(c);
    }

    public Client retirer(){
        return this.pop();
    }
}
