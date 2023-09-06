package com.seb.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//***** La classe Clavier gère les actions utilisateur au clavier *****//
public class Clavier implements KeyListener{

	
	//**** METHODES **//
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){ // flèche droite
		
        	if(Main.scene.getxPos() == -1){ 
        		Main.scene.setxPos(0);     // Réinitialisation de setxPos
        		Main.scene.setxFond1(-50); // Réinitialisation de xFond1
        		Main.scene.setxFond2(750); // Réinitialisation de xFond2
        	}
        	Main.scene.mario.setMarche(true);
        	Main.scene.mario.setVersDroite(true);
			Main.scene.setDx(1);  // Déplacement du fond vers la gauche lors de l'appui sur la touche "flèche droite"
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){ // flèche gauche
			Main.scene.mario.setMarche(true);
        	Main.scene.mario.setVersDroite(false);
			Main.scene.setDx(-1); // Déplacement du fond vers la droite lors de l'appui sur la touche "flèche gauche"
			}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.mario.setMarche(false);
		Main.scene.setDx(0);// Remise à 0 de la variable dx de la l'objet scene 
		}                   // lors du relâchement des touches
	                                                           
	@Override
	public void keyTyped(KeyEvent e) {}
}
