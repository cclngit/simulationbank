package banque;

import simulation.evenement.EvenementEcouteur;

/**
 * Classe permettant de modeliser une banque
 *
 * @version 2022-01-09
 * @author ALTMANN
 */
public class Banque {
    public final double DUREE_SERVICE_CAISSIER;
    private FileAttenteClient fileAttente;
    private Caissier[] employers;

    public Banque(double dureeServiceCaissier, int nombreCaissiers, EvenementEcouteur sonnetteProchainClient) {
        DUREE_SERVICE_CAISSIER = dureeServiceCaissier;
        this.fileAttente = new FileAttenteClient();
        this.initialiserLesCaissiers(nombreCaissiers, sonnetteProchainClient);
    }

    /**
     * Initialise les Caissier
     *
     * @param nombre le nombre de Caissier
     * @param sonnetteProchainClient Ecouteur de l'evenment DepartClient
     *
     */
    public void initialiserLesCaissiers(int nombre, EvenementEcouteur sonnetteProchainClient){
        this.employers = new Caissier[nombre];
        for (int i = 0; i < nombre; i++) {
            this.employers[i] = new Caissier(this, sonnetteProchainClient);
        }
    }

    /**
     * recupere la file d'attente
     *
     *  @return une file d'attente
     */
    public FileAttenteClient getFileAttente() {
        return fileAttente;
    }

    /**
     * Ajoute un client a la file d'attente
     *
     * @param client un client
     *
     */
    public void unClientEstArrivee(Client client){
        //  Quand un client arrive, on l'ajoute a la file d'attente
        this.fileAttente.add(client);

        //  On verifie qu'un caissier est disponible pour le prendre en charge
        for (Caissier caissier: this.employers){
            if (caissier.estDisponible(client.getTempsArrivee())){
                caissier.prendreUnClientDansFileAttente(client.getTempsArrivee());
            }
        }
    }

    /**
     * Prend le prochain client de la file d'attente
     *
     * @param temps un client
     *
     */
    public void unClientEstParti(double temps){
        //  Quand un client part, on prend le client suivant
        for (Caissier caissier : this.employers){
            if (caissier.estDisponible(temps)){
                caissier.prendreUnClientDansFileAttente(temps);
            }
        }
    }

    /**
     * accesseur d'un tabeau de Caissier
     *
     * @return un tableau Caissier
     */
    public Caissier[] getEmployers() {
        return employers;
    }

    /**
     * Compte le nombre total de client
     *
     * @return le nombre totale de client
     */
    public int nombreTotalDeClientsServis(){
        int total = 0;
        for (Caissier caissier : this.employers){
            total += caissier.nombreDeClientServis();
        }
        return total;
    }

    /**
     * Compte le nombre de client servi par Caissier
     *
     * @return un tableau du nomdre de client servi par Caissier
     */
    public int[] nombreDeClientServisParEmployer(){
        int[] resultats = new int[this.employers.length];
        for (int i = 0; i < this.employers.length; i++){
            resultats[i] = this.employers[i].nombreDeClientServis();
        }
        return resultats;
    }

    /**
     * Calcul le taux d'occupation par Caissier
     *
     * @param tempsTotal le temps de travail totaux
     * @return un tableau du taux d'occupation par Caissier
     */
    public double[] tauxOccupationParEmployer(double tempsTotal){
        double[] resultats = new double[this.employers.length];
        for (int i = 0; i < this.employers.length; i++){
            resultats[i] = this.employers[i].tauxOccupationEnPourcentage(tempsTotal);
        }
        return resultats;
    }

    /**
     * Calcul le temps d'attente moyen des client
     *
     * @return le temps d'attente moyen des client
     */
    public double tempsAttenteMoyenClient(){
        double temps = 0;
        for (Caissier caissier : this.employers){
            temps += caissier.tempsAttenteMoyenDeMesClient();
        }
        return temps / this.employers.length;
    }
}
