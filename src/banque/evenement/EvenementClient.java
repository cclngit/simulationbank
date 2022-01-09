package banque.evenement;

import banque.Client;
import simulation.evenement.Evenement;

/**
 * Classe permettant de gerer les evenements liés à un client
 *
 * @version 2022-01-09
 * @author ALTMANN
 */

public abstract class EvenementClient extends Evenement {
    private Client client;
    public EvenementClient(Client client, double temps) {
        super(temps);
        this.client = client;
    }

    /**
     * recuperer le client
     *
     * @return un client
     */
    public Client getClient() {
        return client;
    }
}
