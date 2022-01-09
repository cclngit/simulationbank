package simulation.evenement;


/**
 * Classe permettant de modeliser un ecouteur d'evenement
 *
 * @version 2022-01-09
 * @author SOW
 *
 */
public interface EvenementEcouteur {

    /**
     * Notifie l'evenement ecouté
     *
     */
    void notifier(Evenement evenement);
}
