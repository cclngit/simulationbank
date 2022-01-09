package ihm;

import banque.Banque;
import simulation.Poisson;

import java.util.Scanner;

public class CLI {


    public static void run() {
        double dureePrevue ; int nbCaissiers; double tService; double tempsEntreArrivee;
        Scanner sc = new Scanner(System.in);
        System.out.print("dureePrevue : ");
        dureePrevue = sc.nextDouble();
        System.out.print("nbCaissiers : ");
        nbCaissiers = sc.nextInt();
        System.out.print("tService : ");
        tService = sc.nextDouble();
        System.out.print("tempsEntreArrivee : ");
        tempsEntreArrivee = sc.nextDouble();
        sc.close();

        Banque banque = new Banque(dureePrevue, nbCaissiers, tService, tempsEntreArrivee);
        banque.executer();

        System.out.println("Resultat : " + banque.getResultat());
    }

    public static void main(String[] args) {
        CLI.run();
    }
}
