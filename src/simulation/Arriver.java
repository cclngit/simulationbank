package simulation;

import banque.Banque;
import banque.Caissier;
import banque.Client;

public class Arriver extends Evenement {
    protected Caissier cs;

    public Arriver(double heure, SED sed) {
        super(heure, sed);
    }

    @Override
    public void lancer() {
        
    }

}
