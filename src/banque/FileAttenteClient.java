package banque;

import java.util.ArrayList;
import java.util.LinkedList;

public class FileAttenteClient extends LinkedList<Client> {

    private ArrayList<Integer> longueurs = new ArrayList<>();

    @Override
    public Client pop() {

        // On ajoute la longueurs dans la liste
        this.longueurs.add(this.size());

        return super.pop();
    }

    public int longueurMax() {
        Integer max = 0;
        for (Integer longueur : this.longueurs){
            if (longueur > max)
                max = longueur;
        }
        return max;
    }

    public double longueurMoyenne() {
        double somme = 0;
        for (Integer longueur : this.longueurs){
            somme+=longueur;
        }
        return somme/this.longueurs.size();
    }


}
