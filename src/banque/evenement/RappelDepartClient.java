package banque.evenement;

import simulation.evenement.Evenement;

/**
 * Classe permettant de repeler qu'un client est partis
 *
 * @version 2022-01-09
 * @author ALTMANN
 */
public class RappelDepartClient extends Evenement {
    public RappelDepartClient(double temps) {
        super(temps);
    }
}
