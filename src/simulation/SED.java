package simulation;

import simulation.evenement.Evenement;

import java.util.LinkedList;

/**
 * Classe permettant de simuler des evenements discret
 *
 * @version 2022-01-09
 * @author ALTMANN
 */

public abstract class SED extends LinkedList<Evenement> {

    public void executer(){
        Evenement evenement;
        while (!this.isEmpty()){
            evenement = this.pop();
            evenement.lancer();
        }
    }
}
