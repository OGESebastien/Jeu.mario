package com.seb.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.seb.jeu.Main;
import com.seb.objets.Objet;
import com.seb.objets.Piece;

public class Mario extends Personnage{

	
	//**** VARIABLES ****//
	private Image imgMario;
	private ImageIcon icoMario;
    private boolean saut; // vrai si mario saute
    private int compteurSaut; // duree du saut et hauteur du saut
    private int compteurMort;
	
	//**** CONSTRUCTEUR	****//	
	public Mario(int x, int y) {

	super(x, y, 28, 50);		
	this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
	this.imgMario = this.icoMario.getImage();
	
	this.saut = false;
	this.compteurSaut = 0;
	this.compteurMort = 0;
	}

		
	//**** GETTERS ****//		
	public Image getImgMario() {return imgMario;}

	public boolean isSaut() {return saut;}
	
		
	//**** SETTERS ****//
	public void setSaut(boolean saut) {this.saut = saut;}

	//**** METHODES ****//
	@Override
	public Image marche(String nom, int frequence) {
    	String str;
    	ImageIcon ico;
		Image img;			
		if (this.marche == false || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430) {
			if(this.versDroite == true){str = "../../../images/" + nom + "ArretDroite.png";}
			else{str = "../../../images/" + nom + "ArretGauche.png";}				
		}else{
		    this.compteur++;
		    if (this.compteur / frequence == 0) { // quotient de la division euclidienne de compteur par frequence
		    	if(this.versDroite == true){
					str = "../../../images/" + nom + "ArretDroite.png";
				}
		    	else{
					str = "../../../images/" + nom + "ArretGauche.png";
				}					
		    }else{
		    	if(this.versDroite == true){str = "../../../images/" + nom + "MarcheDroite.png";}
		    	else{str = "../../../images/" + nom + "MarcheGauche.png";}	
		    }		    
		    if (this.compteur == 2 * frequence) {this.compteur = 0;}
		}
		// Affichage de l'image du personnage
		//System.out.println(str);
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
    public Image saute(){		
	    ImageIcon ico;
	    Image img;
	    String str;
	
   this.compteurSaut++;
 
        // Ajustement : Augmentation de la hauteur du saut
        int hauteurSautMax = 60;
        
        // Montée du saut       
        if (this.compteurSaut <= hauteurSautMax) {
            // Ajustement : Augmentation progressive de la hauteur de la montée
            int vitesseMontee = (int) Math.ceil(4 * Math.sin(Math.toRadians((this.compteurSaut * 90) / hauteurSautMax)));
        
            if (this.getY() > Main.scene.getHautPlafond()) {
                this.setY(this.getY() - vitesseMontee);
            } else {
                this.compteurSaut = hauteurSautMax + 1;
            }
        
            if (this.isVersDroite()) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/marioSautGauche.png";
            }
        
        // Retombée du saut
        } else if (this.getY() + this.getHauteur() < Main.scene.getySol()) {
            this.setY(this.getY() + 1);
        
            if (this.isVersDroite()) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/marioSautGauche.png";
            }
        
        // Saut terminé
        } else {
            if (this.isVersDroite()) {
                str = "/images/marioArretDroite.png";
            } else {
                str = "/images/marioArretGauche.png";
            }
        
            // Ajustement : Réduire le décalage vers le bas pour une retombée plus douce
            this.setY(Main.scene.getySol() - this.getHauteur());
        
            this.saut = false;
            this.compteurSaut = 0;
        }
		// Affichage de l'image de mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
    
	public void contact(Objet objet) {
		// contact horizontal
		if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
			Main.scene.setDx(0);
		    this.setMarche(false);
		}
		// contact avec un objet en dessous
        if(super.contactDessous(objet) == true && this.saut == true){ // Mario saute sur un objet
			Main.scene.setySol(objet.getY());			
		}else if(super.contactDessous(objet) == false){ // Mario tombe sur le sol initial
			Main.scene.setySol(293); // altitude du sol initial
			if(this.saut == false){this.setY(243);} // altitude initiale de Mario
		}
        // contact avec un objet au-dessus
        if(super.contactDessus(objet) == true){
			Main.scene.setHautPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
		}else if(super.contactDessus(objet) == false && this.saut == false){
			Main.scene.setHautPlafond(0);// altitude du plafond initial (ciel)
		}     
	}
	
	public boolean contactPiece(Piece piece){
		// Le contact avec une piéce n'a aucune répercussion sur Mario
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || 
		   this.contactDessus(piece) == true){
			return true;			
		}else{return false;}
	}	

	public void contact(Personnage personnage) {		
		if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
			this.setMarche(false);
		    this.setVivant(false);
		}else if(super.contactDessous(personnage) == true){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
    }
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/boom.png";
        this.compteurMort++;
        if(this.compteurMort > 100){
        	str = "/images/marioMeurt.png";
        	this.setY(this.getY() - 1);
        }
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img; 
	} 
}
