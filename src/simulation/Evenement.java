package simulation;

public abstract class Evenement {
    private double heure;
    private SED s;

    public Evenement(double heure, SED sed) {
        this.heure = heure;
        sed.ajouter(this);
    }

    public double getHeure() {
        return this.heure;
    }

    public abstract void lancer();
}
