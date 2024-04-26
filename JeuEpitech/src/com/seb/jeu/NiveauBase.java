package com.seb.jeu;

import javax.swing.JPanel;
import java.awt.Graphics;

public abstract class NiveauBase extends JPanel {
    protected int dx;   // déplacement du fond d'écran.
    protected int xPos; // position absolue dans le jeu
    protected int ySol; // hauteur courante du sol
    protected int hauteurPlafond; // hauteur courante du plafond

    public abstract void deplacementFond();
    public abstract boolean estPartieTerminee();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Appel nécessaire pour le rendu correct du composant
        // Vous pouvez ajouter ici une logique de rendu de base si nécessaire
    }

    public int getDx() { return dx; }
    public void setDx(int dx) { this.dx = dx; }
    public int getxPos() { return xPos; }
    public void setxPos(int xPos) { this.xPos = xPos; }
    public int getySol() { return ySol; }
    public void setySol(int ySol) { this.ySol = ySol; }
    public int getHautPlafond() { return hauteurPlafond; }
    public void setHautPlafond(int hauteurPlafond) { this.hauteurPlafond = hauteurPlafond; }
}
