package simulation;

import banque.Banque;
import banque.Caissier;
import banque.Client;

public class Arriver extends Evenement {
    private static SED se;
    protected Caissier cs;
    protected float clientSuivant;

    public Arriver(float clientSuivant2, Banque bq2) {
        super(heure, se);
    }

    public void traiter(){
        Banque bq = new Banque();
        Client cl = new Client();
        clientSuivant = (float) (heure + Poisson.next(bq.gettempsEntreArrivee()));
        if(clientSuivant < bq.getdureeSimulation()){
            bq.ajouter(new Arriver(clientSuivant, bq));
        Caissier cs = bq.unCaussierLibre();
        if(cs != null)
            cs.servic(cl);
        else
            bq.fileAttente().ajouter(cl);
        }
    }
}
