package banque.evenement;

import banque.Client;
import simulation.evenement.Evenement;

public abstract class EvenementClient extends Evenement {
    private Client client;
    public EvenementClient(Client client, double temps) {
        super(temps);
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
