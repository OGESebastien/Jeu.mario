package com.seb.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.seb.objets.Objet;

public class Plante extends Personnage implements Runnable{

	private Image imgPlante;
	private ImageIcon icoPlante;
	
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxPlante; // pas de déplacement de la plante
	
	//**** CONSTRUCTEUR	****//
	public Plante(int x, int y) {
			
		super(x, y, 43, 50);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxPlante = 1;
			
		this.icoPlante = new ImageIcon(getClass().getResource("/images/plante1.png"));
		this.imgPlante = this.icoPlante.getImage();
			
		Thread chronoChamp = new Thread(this);
		chronoChamp.start();
		}
	//**** GETTERS ****//		
	public Image getImgPlante() {return imgPlante;}

			
	//**** SETTERS ****//
			
			
	//**** METHODES ****//	
	public void bouge(){ // Déplacement de la plante
	    if(super.isVersDroite() == true){this.dxPlante = 1;}
	    else{this.dxPlante = -1;}
	    super.setX(super.getX() + this.dxPlante);  	
	}
	
	@Override
	public void run() {
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient complétement créés
		catch (InterruptedException e){}		
		
		while(true){ // boucle infinie
			if(this.vivant == true){
		    this.bouge();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			}
		}
	}
	

	public void contact(Objet objet) {			
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
	    	this.dxPlante = -1; 
	    }else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxPlante = 1;     
	    }	
	}
	
	public void contact(Personnage personnage) {		
	    if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
    	    this.dxPlante = -1; 
        }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
    	    super.setVersDroite(true);
    	    this.dxPlante = 1;     
        }	
    }
	
    public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/plante1.png";	
        ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}
