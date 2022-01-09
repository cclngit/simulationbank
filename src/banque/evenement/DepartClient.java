package banque.evenement;

import banque.Client;
import simulation.evenement.Evenement;

public class DepartClient extends EvenementClient {
    public DepartClient(Client client) {
        super(client, client.getTempsDepart());
    }
}
