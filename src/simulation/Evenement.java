package simulation;

public abstract class Evenement {
    private double heure;
    private SED sed;

    public Evenement(double heure, SED sed) {
        this.heure = heure;
        this.sed = sed;
    }

    public double getHeure() {
        return this.heure;
    }

    public abstract void lancer();

    public SED getSed() {
        return sed;
    }
}
