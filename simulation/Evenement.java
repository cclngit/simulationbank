package simulation;

public class Evenement {
    protected static float heure;
    protected SED s;

    public Evenement(float heure, SED se) {
        Evenement.heure = heure;
        se.ajouter(this);
    }

    public float heure() {
        return heure;
    }

    public void traiter() {
    }
}
