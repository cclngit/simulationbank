package banque;

import banque.evenement.ArriveeClient;
import banque.evenement.DepartClient;
import banque.evenement.RappelDepartClient;
import simulation.Poisson;
import simulation.SED;
import simulation.evenement.Evenement;
import simulation.evenement.EvenementEcouteur;

import java.util.Comparator;
import java.util.Scanner;

public class SimulationBanque extends SED implements EvenementEcouteur {

    private Banque banque;
    private double dureeSimulation;
    private double dureeEntreArriveeClient;
    private double dureeReelSimulation;

    public SimulationBanque(double dureeSimulation, int nombreCaissier, double dureeMoyenService, double dureeEntreArriveeClient) {
        banque = new Banque(dureeMoyenService, nombreCaissier, this);
        this.dureeSimulation = dureeSimulation;
        this.dureeEntreArriveeClient = dureeEntreArriveeClient;
    }

    @Override
    public void notifier(Evenement evenement) {

        //  On reçoit la notification d'arrivee du client
        if (evenement instanceof ArriveeClient){

            //  On fait rentrer le client dans la banque
            this.banque.unClientEstArrivee(((ArriveeClient) evenement).getClient());
        }else if (evenement instanceof DepartClient){

            //  On met un rappel, pour executer le depart client a l'heure ou il part reelement
            RappelDepartClient rappelDepartClient = new RappelDepartClient(evenement.getTemps());
            this.add(rappelDepartClient);
            rappelDepartClient.souscrireUnAbonnement(this);

            //  On trie la liste d'evenement dans l'ordre chronologique
            this.trierEvenementDansOrdreChronologique();

        }else if (evenement instanceof RappelDepartClient){

            //  On met le client dehors
            this.banque.unClientEstParti(evenement.getTemps());
            this.dureeReelSimulation = evenement.getTemps();
        }
    }

    public void trierEvenementDansOrdreChronologique(){
        this.sort(new Comparator<Evenement>() {
            @Override
            public int compare(Evenement o1, Evenement o2) {
                return o1.getTemps() - o2.getTemps() > 0? 1 : 0;
            }
        });
    }

    public void initialiser(){
        double tempsArrivee = 0;
        while (tempsArrivee < this.dureeSimulation) {
            tempsArrivee += Poisson.next(this.dureeEntreArriveeClient);
            ArriveeClient arriveeClient = new ArriveeClient(tempsArrivee);
            arriveeClient.souscrireUnAbonnement(this);
            this.add(arriveeClient);
        }
    }

    @Override
    public String toString() {
        return "SimulationBanque{" +
                "banque=" + banque +
                ", dureeSimulation=" + dureeSimulation +
                ", dureeEntreArriveeClient=" + dureeEntreArriveeClient +
                '}';
    }

    public String resultat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Duree reel simulation = " + this.dureeReelSimulation + "\n");
        stringBuilder.append("Longueur max file d'attente = " + this.banque.getFileAttente().longueurMax() + "\n");
        stringBuilder.append("Longueur moyenne file d'attente = " + this.banque.getFileAttente().longueurMoyenne() + "\n");
        stringBuilder.append("Nombre total de client servis = " + this.banque.nombreTotalDeClientsServis() + "\n");
        stringBuilder.append("Nombre de client par caissier = " + "\n");
        int[] nbClientServis = this.banque.nombreDeClientServisParEmployer();
        for (int i = 0; i < nbClientServis.length; i++){
            stringBuilder.append("\t - [Caissier "+i+" (eficacite = "+this.banque.getEmployers()[i].getEfficaciteEnPourcentage()+" )][ "+nbClientServis[i]+" ]" + "\n");
        }
        stringBuilder.append("Taux occupation par caissier = "  + "\n");
        double[] tauxOccupations = this.banque.tauxOccupationParEmployer(this.dureeReelSimulation);
        for (int i = 0; i < tauxOccupations.length; i++){
            stringBuilder.append("\t - [Caissier "+i+" (eficacite = "+this.banque.getEmployers()[i].getEfficaciteEnPourcentage()+" )][ "+tauxOccupations[i]+"  ]" + "\n");
        }
        stringBuilder.append("Temps d'attente moyen client = " + this.banque.tempsAttenteMoyenClient() + "\n");
        stringBuilder.append("File attente a la fin = " + this.banque.getFileAttente().size() + "\n");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        double dureeSimulation; int nombreCaissier; double dureeMoyenService; double dureeEntreArriveeClient;
        Scanner sc = new Scanner(System.in);
        System.out.print("dureeSimulation : ");
        dureeSimulation = sc.nextDouble();
        System.out.print("nombreCaissier : ");
        nombreCaissier = sc.nextInt();
        System.out.print("dureeMoyenService : ");
        dureeMoyenService = sc.nextDouble();
        System.out.print("dureeEntreArriveeClient : ");
        dureeEntreArriveeClient = sc.nextDouble();
        sc.close();

        SimulationBanque simulationBanque = new SimulationBanque(dureeSimulation, nombreCaissier, dureeMoyenService, dureeEntreArriveeClient);
        simulationBanque.initialiser();
        simulationBanque.executer();
        System.out.println(simulationBanque.resultat());
    }
}
