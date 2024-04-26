package com.seb.jeu;

import javax.swing.*;

public class Main {

    public static NiveauBase scene; // Modifié pour utiliser NiveauBase au lieu de JPanel
    public static JFrame fenetre;

    public static void main(String[] args) {
        initialiserJeu();
    }

    public static void initialiserJeu() {
        if (fenetre != null) {
            fenetre.dispose();
        }

        String[] niveaux = {"Niveau 1", "Niveau 2", "Niveau 3"};
        String[] personnages = {"Mario", "Luigi"};

        String selectedNiveau = (String) JOptionPane.showInputDialog(
                null,
                "Sélectionnez le niveau :",
                "Choix du Niveau",
                JOptionPane.QUESTION_MESSAGE,
                null,
                niveaux,
                niveaux[0]
        );

        String selectedPersonnage = (String) JOptionPane.showInputDialog(
                null,
                "Sélectionnez le personnage :",
                "Choix du Personnage",
                JOptionPane.QUESTION_MESSAGE,
                null,
                personnages,
                personnages[0]
        );

        System.out.println("Personnage sélectionné : " + selectedPersonnage);
        System.out.println("Niveau sélectionné : " + selectedNiveau);

        fenetre = new JFrame("Jeu style Mario");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700, 360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);

        switch (selectedNiveau) {
            case "Niveau 1":
                scene = new Niveau1();
                break;
            case "Niveau 2":
                scene = new Niveau2();
                break;
            case "Niveau 3":
                scene = new Niveau3();
                break;
            // Ajoutez des cas supplémentaires pour les niveaux 3, 4, etc.
            default:
                scene = new Niveau1(); // Niveau par défaut si aucun n'est sélectionné
                break;
        }

        fenetre.setContentPane(scene);
        fenetre.setVisible(true);

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }
}
