package simulation;

public class Depart extends Evenement {

    public Depart(double heure, SED sed) {
        super(heure, sed);
    }

    @Override
    public void lancer() {
        this.getSed().notifierDepart(this.getHeure());
    }


}
