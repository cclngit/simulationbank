package banque;

public class Client {
    private double tempsArrivee;
    private double tempsPriseEnCharge;
    private double tempsDepart;

    public Client(double tempsArrivee) {
        this.tempsArrivee = tempsArrivee;
    }

    public double getTempsArrivee() {
        return tempsArrivee;
    }

    public double getTempsPriseEnCharge() {
        return tempsPriseEnCharge;
    }

    public void setTempsPriseEnCharge(double tempsPriseEnCharge) {
        this.tempsPriseEnCharge = tempsPriseEnCharge;
    }

    public double getTempsDepart() {
        return tempsDepart;
    }

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
