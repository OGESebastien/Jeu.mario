package com.seb.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.seb.jeu.Main;

public class Personnage {
	
	//**** Variables ****//
	private int largeur, hauteur; // dimensions du personnage
	private int x, y; // position du personnage
	private boolean marche; // vrai quand le personnage marche
	private boolean versDroite; // vrai quand le personnage est tourné vers la droite
	public int compteur; // Compteur des pas du personnage

	//**** Constructeur ****//
	public Personnage(int x, int y, int largeur, int hauteur){
		
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.compteur = 0;
		this.marche = false;
		this.versDroite = true;
	}

	

	

	

	


	


	

	
	//**** Getters ****//
	
	public int getX() {return x;}
	public int getY() {return y;}
	public int getLargeur() {return largeur;}
	public int getHauteur() {return hauteur;}
	public boolean isMarche() {return marche;}
	public boolean isVersDroite() {return versDroite;}
	public int getCompteur() {return compteur;}

	//**** SETTERS ****//
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setMarche(boolean marche) {this.marche = marche;}
	public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}
	public void setCompteur(int compteur) {this.compteur = compteur;}


	
	 //**** METHODES ****//
	public Image marche(String nom, int frequence){
		
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.marche == false || Main.scene.getxPos() <= 0){
			if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
			else{str = "/images/" + nom + "ArretGauche.png";}
		}else{
			this.compteur++;
			if(this.compteur / frequence == 0){
				if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
				else{str = "/images/" + nom + "ArretGauche.png";}
			}else{
				if(this.versDroite == true){str = "/images/" + nom + "MarcheDroite.png";}
				else{str = "/images/" + nom + "MarcheGauche.png";}
			}
			if(this.compteur == 2 * frequence){this.compteur = 0;}
		}
		//Affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}


