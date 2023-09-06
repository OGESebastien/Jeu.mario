package com.seb.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.seb.personnages.Mario;

@SuppressWarnings("serial")
public class Scene extends JPanel {

	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;
	private int xPos;
	
	public Mario mario;
	
	
	
	
	//**** CONSTRUCTEUR ****//	
	public Scene(){
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
	
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
		this.imgChateau1 = this.icoChateau1.getImage();
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		mario = new Mario(300, 245);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread (new Chrono());
		chronoEcran.start();
	}
	
			
	
	//*** GETTERS ***//
	public int getDx() {return dx;}
	public int getxPos() {return xPos;}
	
	



	//*** SETTERS ***//
	public void setDx(int dx) {this.dx = dx;}
	public void setxPos(int xPos) {this.xPos = xPos;}
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}
	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}
	
	//**** METHODES ****//
	public void deplacementFond(){
		
	if(this.xPos >= 0){
		this.xPos = this.xPos + this.dx;
	this.xFond1 = this.xFond1 - this.dx;
	this.xFond2 = this.xFond2 - this.dx;
	}
	if(this.xFond1 == -800){this.xFond1 = 800;}
	else if (this.xFond2 == -800){this.xFond2 = 800;}
	else if (this.xFond1 == 800){this.xFond1 = -800;}
	else if (this.xFond2 == 800){this.xFond2 = -800;}
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		this.deplacementFond();
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond  		 	    
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); 
		g2.drawImage(this.mario.marche("mario",25), 300, 245, null); //*** code provisoire
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
	}
}



