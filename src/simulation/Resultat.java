package simulation;

public class Resultat {
    private double dureeReelSimulation;
    private int longueurMaxFileAttente;
    private double longueurMoyFileAttente;
    private int nbClient;
    private double tauxOcccupationCaissier;
    private double tempsMoyAttenteClient;

    public Resultat(){

    }

    public double getDureeReelSimulation() {
        return dureeReelSimulation;
    }

    public void setDureeReelSimulation(double dureeReelSimulation) {
        this.dureeReelSimulation = dureeReelSimulation;
    }

    public int getLongueurMaxFileAttente() {
        return longueurMaxFileAttente;
    }

    public void setLongueurMaxFileAttente(int longueurMaxFileAttente) {
        this.longueurMaxFileAttente = longueurMaxFileAttente;
    }

    public double getLongueurMoyFileAttente() {
        return longueurMoyFileAttente;
    }

    public void setLongueurMoyFileAttente(double longueurMoyFileAttente) {
        this.longueurMoyFileAttente = longueurMoyFileAttente;
    }

    public int getNbClient() {
        return nbClient;
    }

    public void setNbClient(int nbClient) {
        this.nbClient = nbClient;
    }

    public double getTauxOcccupationCaissier() {
        return tauxOcccupationCaissier;
    }

    public void setTauxOcccupationCaissier(double tauxOcccupationCaissier) {
        this.tauxOcccupationCaissier = tauxOcccupationCaissier;
    }

    public double getTempsMoyAttenteClient() {
        return tempsMoyAttenteClient;
    }

    public void setTempsMoyAttenteClient(double tempsMoyAttenteClient) {
        this.tempsMoyAttenteClient = tempsMoyAttenteClient;
    }

    public void incrementNbClient() {
        this.nbClient++;
    }

    @Override
    public String toString() {
        return "Resultat{" +
                "dureeReelSimulation=" + dureeReelSimulation +
                ", longueurMaxFileAttente=" + longueurMaxFileAttente +
                ", longueurMoyFileAttente=" + longueurMoyFileAttente +
                ", nbClient=" + nbClient +
                ", tauxOcccupationCaissier=" + tauxOcccupationCaissier +
                ", tempsMoyAttenteClient=" + tempsMoyAttenteClient +
                '}';
    }
}
