package banque;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Classe permettant de modeliser une File d'attente
 *
 * @version 2022-01-09
 * @author ALTMANN
 */
public class FileAttenteClient extends LinkedList<Client> {

    private ArrayList<Integer> longueurs = new ArrayList<>();

    @Override
    public Client pop() {

        // On ajoute la longueurs dans la liste
        this.longueurs.add(this.size());

        return super.pop();
    }

    /**
     * Calcul la longueur max de la file d'attente
     *
     * @return la longueur max de la file d'attente
     *
     */
    public int longueurMax() {
        Integer max = 0;
        for (Integer longueur : this.longueurs){
            if (longueur > max)
                max = longueur;
        }
        return max;
    }

    /**
     * Calcul la longueur moyenne de la file d'attente
     *
     * @return la longueur moyenne de la file d'attente
     *
     */
    public double longueurMoyenne() {
        double somme = 0;
        for (Integer longueur : this.longueurs){
            somme+=longueur;
        }
        return somme/this.longueurs.size();
    }


}
