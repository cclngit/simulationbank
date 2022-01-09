package banque.evenement;

import banque.Client;

public class ArriveeClient extends EvenementClient {
    public ArriveeClient(double temps) {
        super(new Client(temps), temps);
    }
}
