package simulation;

public class Arriver extends Evenement {

    public Arriver(double heure, SED sed) {
        super(heure, sed);
    }

    @Override
    public void lancer() {
        this.getSed().notifierArrivee(this.getHeure());
        
    }

}
