package banque.evenement;

import banque.Client;

/**
 * Classe permettant de notifier qu'un client est arriver
 *
 * @version 2022-01-09
 * @author SOW
 */

public class ArriveeClient extends EvenementClient {
    public ArriveeClient(double temps) {
        super(new Client(temps), temps);
    }
}
