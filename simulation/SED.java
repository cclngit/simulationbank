package simulation;

import java.util.LinkedList;
import banque.Banque;

public class SED {
    protected float heure;
    protected LinkedList<Evenement> event = new LinkedList<Evenement>();

    public SED(){
        heure = 0;
    }
    
    public void ajouter(Evenement e){
         event.add(e);
    }

    public void lancer(Banque b){
        while(event.size() !=0 ){
            Evenement e = event.getFirst();
            event.removeFirst();
            heure = e.heure();
            e.traiter();
        }
    }
}
