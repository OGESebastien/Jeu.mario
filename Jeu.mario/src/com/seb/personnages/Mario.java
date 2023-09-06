package com.seb.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personnage{

	
	//**** VARIABLES ****//
	private Image imgMario;
	private ImageIcon icoMario;
	
	
	//**** CONSTRUCTEUR ****//
	public Mario (int x, int y){
		
	super (x, y, 28, 50);
	this.icoMario = new ImageIcon ("src/images/marioMarcheDroite.png");
	this.imgMario = this.icoMario.getImage();	
	}
	
	
	//**** GETTERS ****//
	public Image getImgMario() {return imgMario;}
	
	
	//**** SETTERS ****//
	
	
	
	//**** METHODES ****//
	
	
}
