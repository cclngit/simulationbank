package banque.evenement;

import banque.Client;
import simulation.evenement.Evenement;

/**
 * Classe permettant de notifier qu'un client est partis
 *
 * @version 2022-01-09
 * @author SOW
 */

public class DepartClient extends EvenementClient {
    public DepartClient(Client client) {
        super(client, client.getTempsDepart());
    }
}
