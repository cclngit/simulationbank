package banque;

import banque.evenement.DepartClient;
import simulation.evenement.EvenementEcouteur;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe permettant de modeliser un Caissier
 *
 * @version 2022-01-09
 * @author ALTMANN
 */
public class Caissier {

    private Banque travail;
    private double efficacite;
    private ArrayList<Client> clientServis;
    private EvenementEcouteur sonnetteProchainClient;

    public Caissier(Banque travail, EvenementEcouteur sonnette) {
        this.travail = travail;
        Random random = new Random();
        //  On genere une efficacite entre -50 et 100 %
        //  Si -50 : il fini la tache en moitie moins de temps
        //  Si 100 : il prend 2 fois plus de temps pour finir la tache
        this.efficacite = random.nextDouble(100 - (-50) + 1) / 100;
        this.clientServis = new ArrayList<>();
        //  On donne une sonnette pour appeler le client suivant
        this.sonnetteProchainClient = sonnette;
    }

    /**
     * Sert les client dans l'ordre
     *
     * @param temps le temps d'arriver du Client
     *
     */
    public void prendreUnClientDansFileAttente(double temps){

        //  Si il y a un client dans la file d'attente, on recupere le premier
        if (!this.travail.getFileAttente().isEmpty()){
            Client client = this.travail.getFileAttente().pop();
            client.setTempsPriseEnCharge(temps);
            client.setTempsDepart(temps + this.travail.DUREE_SERVICE_CAISSIER + (this.travail.DUREE_SERVICE_CAISSIER * this.efficacite));

            //  On appuis sur la sonnette pour dire que le client est parti
            DepartClient departClient = new DepartClient(client);
            departClient.souscrireUnAbonnement(this.sonnetteProchainClient);
            this.clientServis.add(client);
            departClient.lancer();
        }
    }

    /**
     * Accesseur de l'efficacite
     *
     * @return une efficacite
     *
     */
    public double getEfficacite() {
        return 1 - efficacite;
    }

    /**
     * Accesseur de l'efficacite
     *
     * @return une efficacite en pourcentage
     *
     */
    public double getEfficaciteEnPourcentage() {
        return this.getEfficacite() * 100;
    }

    /**
     * Accesseur de l'efficacite
     *
     * @param temps le temps d'arriver du Client
     * @return true ou false (true si disponible)
     *
     */
    public boolean estDisponible(double temps) {

        //  S'il a deja eu un client
        if (!this.clientServis.isEmpty()){
            //  On recupere le dernier de la liste
            Client dernierClient = this.clientServis.get(this.clientServis.size()-1);
            //  On verifie que le client n'est plus devant le caissier
            return temps >= dernierClient.getTempsDepart();
        }
        //  Si il n'a pas eu de client alors il est disponible
        return true;
    }

    /**
     * Le nombre de client servie
     *
     * @return un entier - le nombre de client servie
     *
     */
    public int nombreDeClientServis(){
        return this.clientServis.size();
    }

    /**
     * Calcul le taux d'occupation d'un Caissier
     *
     * @param temps le temps d'arriver du Client
     * @return le taux d'occupation d'un Caissier
     *
     */
    public double tauxOccupation(double temps){
        double tempsService = 0;
        for (Client client : this.clientServis){
            tempsService += client.dureeService();
        }
        return tempsService / temps;
    }

    /**
     * Calcul le taux d'occupation (%) d'un Caissier
     *
     * @param temps le temps d'arriver du Client
     * @return le taux d'occupation d'un Caissier en poucentage
     *
     */
    public double tauxOccupationEnPourcentage(double temps){
        return this.tauxOccupation(temps) * 100;
    }

    /**
     * Calcul le taux d'occupation d'un Caissier
     *
     * @return le temps d'attent moyen de client
     *
     */
    public double tempsAttenteMoyenDeMesClient(){
        double tempsAttente = 0;
        for (Client client : this.clientServis){
            tempsAttente += client.dureeAttente();
        }

        return tempsAttente / this.clientServis.size();
    }
}
