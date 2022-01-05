package simulation;

import banque.Banque;
import banque.Caissier;
import banque.Client;

public class Arriver extends Evenement {
    private static SED se;
    protected Banque bq;
    protected Client cl;
    protected Caissier cs;
    protected float clientSuivant;

    public Arriver(float clientSuivant2, Banque bq2) {
        super(heure, se);
    }

    public void traiter(){
        bq = new Banque();
        cl = new Client();
        if(clientSuivant < bq.getdureeSimulation()){
            bq.ajo(new Arriver(clientSuivant, bq));
        }


    }

    /*Banque *s = (Banque *)ds;
    Client *c = new Client(_time, s);
    double next = _time + Poisson::next(s->tempsMoyenEntreArrivees());
    if (next < s->dureePrevue())
        s->add(new Arrivee(next, s));
    Caissier *cs = s->unCaissierLibre();
    if (cs)
        cs->servir(c);
    else
        s->fileAttente()->ajouter(c);*/
}
