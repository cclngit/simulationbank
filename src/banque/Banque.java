package banque;

import simulation.evenement.EvenementEcouteur;

public class Banque {
    public final double DUREE_SERVICE_CAISSIER;
    private FileAttenteClient fileAttente;
    private Caissier[] employers;

    public Banque(double dureeServiceCaissier, int nombreCaissiers, EvenementEcouteur sonnetteProchainClient) {
        DUREE_SERVICE_CAISSIER = dureeServiceCaissier;
        this.fileAttente = new FileAttenteClient();
        this.initialiserLesCaissiers(nombreCaissiers, sonnetteProchainClient);
    }

    public void initialiserLesCaissiers(int nombre, EvenementEcouteur sonnetteProchainClient){
        this.employers = new Caissier[nombre];
        for (int i = 0; i < nombre; i++) {
            this.employers[i] = new Caissier(this, sonnetteProchainClient);
        }
    }

    public FileAttenteClient getFileAttente() {
        return fileAttente;
    }

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

    public void unClientEstParti(double temps){
        //  Quand un client part, on prend le client suivant
        for (Caissier caissier : this.employers){
            if (caissier.estDisponible(temps)){
                caissier.prendreUnClientDansFileAttente(temps);
            }
        }
    }

    public Caissier[] getEmployers() {
        return employers;
    }

    public int nombreTotalDeClientsServis(){
        int total = 0;
        for (Caissier caissier : this.employers){
            total += caissier.nombreDeClientServis();
        }
        return total;
    }

    public int[] nombreDeClientServisParEmployer(){
        int[] resultats = new int[this.employers.length];
        for (int i = 0; i < this.employers.length; i++){
            resultats[i] = this.employers[i].nombreDeClientServis();
        }
        return resultats;
    }

    public double[] tauxOccupationParEmployer(double tempsTotal){
        double[] resultats = new double[this.employers.length];
        for (int i = 0; i < this.employers.length; i++){
            resultats[i] = this.employers[i].tauxOccupationEnPourcentage(tempsTotal);
        }
        return resultats;
    }

    public double tempsAttenteMoyenClient(){
        double temps = 0;
        for (Caissier caissier : this.employers){
            temps += caissier.tempsAttenteMoyenDeMesClient();
        }
        return temps / this.employers.length;
    }
}
