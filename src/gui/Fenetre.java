package gui;

import banque.SimulationBanque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre implements ActionListener {
    private JPanel panel1;
    private JTextField dureeSimulation;
    private JTextField nombreCaissier;
    private JTextField dureeMoyenService;
    private JTextField dureeEntreArriveeClient;
    private JTextPane resultatSimulation;
    private JButton lancerButton;
    private SimulationBanque simulationBanque;

    public Fenetre() {
        lancerButton.addActionListener(this);
    }

    public void start() {
        JFrame frame = new JFrame("BANQUE SIMULATION");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new Fenetre().start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.lancerButton){
            try {
                double dureeSimulation; int nombreCaissier; double dureeMoyenService; double dureeEntreArriveeClient;
                dureeSimulation = Double.parseDouble(this.dureeSimulation.getText());
                nombreCaissier = Integer.parseInt(this.nombreCaissier.getText());
                dureeMoyenService = Double.parseDouble(this.dureeMoyenService.getText());
                dureeEntreArriveeClient = Double.parseDouble(this.dureeEntreArriveeClient.getText());
                this.simulationBanque = new SimulationBanque(dureeSimulation, nombreCaissier, dureeMoyenService, dureeEntreArriveeClient);
                this.simulationBanque.initialiser();
                this.simulationBanque.executer();
                this.resultatSimulation.setText(this.simulationBanque.resultat());
            } catch (Exception exception){
                this.resultatSimulation.setText("Veuillez remplir les champs avec des valeurs conforme");
            }
        }

    }
}
