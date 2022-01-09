package banque;

/**
 * Classe permettant de modeliser un Client
 *
 * @version 2022-01-09
 * @author SOW
 */
public class Client {
    private double tempsArrivee;
    private double tempsPriseEnCharge;
    private double tempsDepart;

    public Client(double tempsArrivee) {
        this.tempsArrivee = tempsArrivee;
    }

    /**
     * Accesseur temps arriver client
     *
     * @return le temps arriver client
     *
     */
    public double getTempsArrivee() {
        return tempsArrivee;
    }


    public double getTempsPriseEnCharge() {
        return tempsPriseEnCharge;
    }

    /**
     * Accesseur sur le temps de prise en charge
     *
     * @param tempsPriseEnCharge le temps de prise en charge
     */
    public void setTempsPriseEnCharge(double tempsPriseEnCharge) {
        this.tempsPriseEnCharge = tempsPriseEnCharge;
    }

    /**
     * Accesseur temps depart client
     *
     * @return le temps depart client
     *
     */
    public double getTempsDepart() {
        return tempsDepart;
    }

    /**
     * Modifie le temps de depart
     *
     * @param tempsDepart le temps de depart
     *
     */
    public void setTempsDepart(double tempsDepart) {
        this.tempsDepart = tempsDepart;
    }

    public double dureeAttente(){
        return this.tempsPriseEnCharge - this.tempsArrivee;
    }

    public double dureeService() {
        return this.tempsDepart - this.tempsPriseEnCharge;
    }
}
