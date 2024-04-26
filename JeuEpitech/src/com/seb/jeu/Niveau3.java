package com.seb.jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.seb.affichage.CompteARebours;
import com.seb.affichage.Score;
import com.seb.objets.Bloc;
import com.seb.objets.Objet;
import com.seb.objets.Piece;
import com.seb.objets.TuyauRouge;
import com.seb.personnages.Champ;
import com.seb.personnages.Mario;
import com.seb.personnages.Tortue;
import com.seb.personnages.Plante;


// rejouer / quitter (boutons)
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.util.Random;
import java.util.List;

//***** La classe Scene est le classe la plus importante de l'application. *****//
//***** Elle est accessible par toutes les autres classes, contient le "moteur" de l'application *****//
//***** Elle gére la partie graphique. *****//
@SuppressWarnings("serial")
public class Niveau3 extends NiveauBase {
	
	
	//**** VARIABLES **//
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;  
	private Image imgChateau1;  
	private ImageIcon icoDepart;  
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;   // déplacement du fond d'écran.
	private int xPos; // position absolue dans le jeu
	private int ySol; // hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	
	public Mario mario;
	
	public TuyauRouge tuyauRouge1;
	public TuyauRouge tuyauRouge2;
	public TuyauRouge tuyauRouge3;
	public TuyauRouge tuyauRouge4;
	public TuyauRouge tuyauRouge5;
	public TuyauRouge tuyauRouge6;
	public TuyauRouge tuyauRouge7;
	public TuyauRouge tuyauRouge8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	public Champ champ1;
	public Champ champ2;
	public Champ champ3;
	public Champ champ4;
	public Champ champ5;
	public Champ champ6;
	public Champ champ7;
	public Champ champ8;
	
	public Tortue tortue1;
	public Tortue tortue2;
	public Tortue tortue3;
	public Tortue tortue4;
	public Tortue tortue5;
	public Tortue tortue6;
	public Tortue tortue7;
	public Tortue tortue8;
	public Tortue tortue9;

	public Plante plante1;
	
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	private ArrayList<Objet> tabObjets; // tableau qui enregistre tous les objets du jeu
	private ArrayList<Piece> tabPieces; // tableau qui enregistre toutes les piéces du jeu
	private ArrayList<Tortue> tabTortues; // tableau qui enregistre toutes les tortues du jeu
	private ArrayList<Champ> tabChamps; // tableau qui enregistre tous les champignons du jeu
	
	private Score score;
	private Font police;
	private CompteARebours compteARebours;
	

	private JButton btnRejouer;
	private JButton btnQuitter;

	private int scoreTotal;
    private boolean partieTerminee = false;
    private int tempsInitial;

	private List<Bloc> blocs;
	
//**** CONSTRUCTEUR ****//	
	public Niveau3(){
		super();

	 Random random = new Random();
    blocs = new ArrayList<>();
		

    this.scoreTotal = 8000; // Initialisez scoreTotal à 0
    this.tempsInitial = 100; // Par exemple, si le compte à rebours commence à 100 secondes
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png")); 
		this.imgChateau1 = this.icoChateau1.getImage();  
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		mario = new Mario(300, 245);
		

		tuyauRouge1 = new TuyauRouge(600, 230);
		tuyauRouge2 = new TuyauRouge(1000, 230);
		tuyauRouge3 = new TuyauRouge(1600, 230);
		tuyauRouge4 = new TuyauRouge(1900, 230);
		tuyauRouge5 = new TuyauRouge(2500, 230);
		tuyauRouge6 = new TuyauRouge(3000, 230);
		tuyauRouge7 = new TuyauRouge(3800, 230);
		tuyauRouge8 = new TuyauRouge(4500, 230);
		

	    blocs.add(new Bloc(random.nextInt(4201) + 400, random.nextInt(61) + 140));

        while (blocs.size() < 12) {
            int newX = random.nextInt(4201) + 400;
            int newY = random.nextInt(61) + 140;
            boolean isFarEnough = true;

            for (Bloc existingBloc : blocs) {
                if (Math.abs(existingBloc.getX() - newX) < 20 && Math.abs(existingBloc.getY() - newY) < 20) {
                    isFarEnough = false;
                    break;
                }
            }

            if (isFarEnough) {
                blocs.add(new Bloc(newX, newY));
            }
        }
 
		
        piece1 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece2 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece3 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece4 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece5 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece6 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece7 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece8 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece9 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);
        piece10 = new Piece(random.nextInt(4201) + 400, random.nextInt(61) + 140);

		
        champ1 = new Champ(random.nextInt(3801) + 800, 263);
        champ2 = new Champ(random.nextInt(3801) + 800, 263);
        champ3 = new Champ(random.nextInt(3801) + 800, 263);
        champ4 = new Champ(random.nextInt(3801) + 800, 263);
        champ5 = new Champ(random.nextInt(3801) + 800, 263);
        champ6 = new Champ(random.nextInt(3801) + 800, 263);
        champ7 = new Champ(random.nextInt(3801) + 800, 263);
        champ8 = new Champ(random.nextInt(3801) + 800, 263);

		
        tortue1 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue2 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue3 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue4 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue5 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue6 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue7 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue8 = new Tortue(random.nextInt(4201) + 400, 243);
        tortue9 = new Tortue(random.nextInt(4201) + 400, 243);

		plante1 = new Plante(400, 243);

		
		this.icoChateauFin = new ImageIcon(getClass().getResource("/images/chateauFin.png")); 
		this.imgChateauFin = this.icoChateauFin.getImage(); 
		
		tabObjets = new ArrayList<Objet>();			
		this.tabObjets.add(this.tuyauRouge1);
		this.tabObjets.add(this.tuyauRouge2);
		this.tabObjets.add(this.tuyauRouge3);
		this.tabObjets.add(this.tuyauRouge4);
		this.tabObjets.add(this.tuyauRouge5);
		this.tabObjets.add(this.tuyauRouge6);
		this.tabObjets.add(this.tuyauRouge7);
		this.tabObjets.add(this.tuyauRouge8);
		
        this.tabObjets.addAll(blocs);
			
		tabPieces = new ArrayList<Piece>();			
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		
		tabChamps = new ArrayList<Champ>();	
		this.tabChamps.add(this.champ1);
		this.tabChamps.add(this.champ2);
		this.tabChamps.add(this.champ3);
		this.tabChamps.add(this.champ4);
		this.tabChamps.add(this.champ5);
		this.tabChamps.add(this.champ6);
		this.tabChamps.add(this.champ7);
		this.tabChamps.add(this.champ8);
		
		tabTortues = new ArrayList<Tortue>();
		this.tabTortues.add(this.tortue1);
		this.tabTortues.add(this.tortue2);
		this.tabTortues.add(this.tortue3);
		this.tabTortues.add(this.tortue4);
		this.tabTortues.add(this.tortue5);
		this.tabTortues.add(this.tortue6);
		this.tabTortues.add(this.tortue7);
		this.tabTortues.add(this.tortue8);
		this.tabTortues.add(this.tortue9);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		compteARebours = new CompteARebours();
				
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();



	btnRejouer = new JButton("Rejouer");
    btnRejouer.setBounds(220, 220, 100, 30); // ajustez la position et la taille
	btnRejouer.addActionListener(new 	ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(btnRejouer);
			if (topFrame != null) {
				topFrame.dispose();
			}
			Main.initialiserJeu();
		}
	});


    this.add(btnRejouer);
    btnRejouer.setVisible(false);

    btnQuitter = new JButton("Quitter");
    btnQuitter.setBounds(340, 220, 100, 30); // ajustez la position et la taille
    btnQuitter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0); // Quitter l'application
        }
    });
    this.add(btnQuitter);
    btnQuitter.setVisible(false);




	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHautPlafond(){return hauteurPlafond;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}


	//**** METHODES ****//
	public void deplacementFond(){ // Déplacement des images "fixes" de l'écran simulant le déplacement de mario 

		if(this.xPos >= 0 && this.xPos <= 4430){
			// Mise é jour des positions des éléments du jeu lors du déplacement de mario
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		// Permanence du fond d'écran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}


    public void setPartieTerminee(boolean partieTerminee) {
        this.partieTerminee = partieTerminee;
    }

    public boolean estPartieTerminee() {
        return partieTerminee;
    }

	private boolean partieGagnee() {     
		if(this.compteARebours.getCompteurTemps() > 0 && this.mario.isVivant() == true && this.score.getNbrePieces() == 10 
			&& this.xPos > 4400) {
			// Diminuer le score total en fonction du temps écoulé
			int tempsEcoule = tempsInitial - this.compteARebours.getCompteurTemps();
			this.scoreTotal -= tempsEcoule * 3.5;
			return true;
		} else {
			return false;
		}
	}



	
private boolean partiePerdue() {
    if(this.mario.isVivant() == false || this.compteARebours.getCompteurTemps() <= 0) {
        // Diminuer le score total en fonction du temps écoulé
        int tempsEcoule = tempsInitial - this.compteARebours.getCompteurTemps();
        this.scoreTotal -= tempsEcoule * 6; // par exemple, 5 points par seconde écoulée
        return true;
    } else {
        return false;
    }
}


		
	public boolean finDePartie(){
		if(this.partieGagnee() == true || this.partiePerdue() == true){return true;}
		else{return false;}
	}
	



	public void paintComponent(Graphics g) { // Dessin de toutes les images visibles é l'écran (appel toutes les 3 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;

		// Détections des contacts avec des objets
		for(int i = 0; i < this.tabObjets.size(); i++){
		    // mario
		    if(this.mario.proche(this.tabObjets.get(i))){this.mario.contact(this.tabObjets.get(i));}
		    // champignons
 		    for(int j = 0; j < this.tabChamps.size(); j++){
 			  if(this.tabChamps.get(j).proche(this.tabObjets.get(i))){this.tabChamps.get(j).contact(this.tabObjets.get(i));} 
 		    }
 		    // tortues
 		    for(int j = 0; j < this.tabTortues.size(); j++){
 			  if(this.tabTortues.get(j).proche(this.tabObjets.get(i))){this.tabTortues.get(j).contact(this.tabObjets.get(i));} 
 		    }
		}
		
	// Détection des contacts de mario avec des pièces
	for(int i = 0; i < this.tabPieces.size(); i++){
		if(this.mario.proche(this.tabPieces.get(i))){
			if(this.mario.contactPiece(this.tabPieces.get(i))){
				this.tabPieces.remove(i);
				this.score.setNbrePieces(this.score.getNbrePieces() + 1);
				this.scoreTotal += 100; // Augmente le score total de 100 points par pièce ramassée
			}
		}
	}

		
 	    // Détections des contacts des champignons avec les personnages (hors mario)
 	 	for(int i = 0; i < this.tabChamps.size(); i++){ 
 	 		// champignons
 	 		for(int j = 0; j < this.tabChamps.size(); j++){
 	 			if(j != i){ 					 				
 	 	 			 if(this.tabChamps.get(j).proche(this.tabChamps.get(i))){this.tabChamps.get(j).contact(this.tabChamps.get(i));}
 	 			}
 	 	 	}
 	 		// tortues
 	 		for(int j = 0; j < this.tabTortues.size(); j++){
 		 		if(this.tabTortues.get(j).proche(this.tabChamps.get(i))){this.tabTortues.get(j).contact(this.tabChamps.get(i));}
 		 	}
 	    }

 	 	// Détections des contacts des tortues avec les personnages (hors mario)
 	 	for(int i = 0; i < this.tabTortues.size(); i++){  
 	 	 	// champignons
 	 	 	for(int j = 0; j < this.tabChamps.size(); j++){
 	 	 	 	if(this.tabChamps.get(j).proche(this.tabTortues.get(i))){this.tabChamps.get(j).contact(this.tabTortues.get(i));} 
 	 	 	}
 	 	 	// tortues
 	 	 	for(int j = 1; j < this.tabTortues.size(); j++){
 	 			if(j != i){
 	 		 		if(this.tabTortues.get(j).proche(this.tabTortues.get(i))){this.tabTortues.get(j).contact(this.tabTortues.get(i));} 
 	 			}
 	 		}
 	 	}    
 	 	
 	 	// Détection des contacts de mario avec des personnages
 	 	// champignons
 	 	for(int i = 0; i < this.tabChamps.size(); i++){ 
 	 		if(this.mario.proche(this.tabChamps.get(i)) && this.tabChamps.get(i).isVivant() == true){
 	 			this.mario.contact(this.tabChamps.get(i)); 				  				
 	 		}
 	 	}
 	 	// tortues
 	 	for(int i = 0; i < this.tabTortues.size(); i++){
 	 	 	if(this.mario.proche(this.tabTortues.get(i)) && this.tabTortues.get(i).isVivant() == true){
 	 	 		this.mario.contact(this.tabTortues.get(i)); 	 		
 	 	 	}
 	 	}
 	 	
		// Déplacement de tous les objets "fixes" du jeu		
		this.deplacementFond();		
		
		if(this.xPos >= 0 && this.xPos <= 4430){
		    for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}
		    for(int i = 0; i < this.tabPieces.size(); i++){this.tabPieces.get(i).deplacement();}
		    for(int i = 0; i < this.tabChamps.size(); i++){this.tabChamps.get(i).deplacement();}
	 		for(int i = 0; i < this.tabTortues.size(); i++){this.tabTortues.get(i).deplacement();}
		}
		
		// Image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		
		// Image du chéteau du départ
 		g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null);
    	// Image du panneau de départ
 		g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null);

     	// Images des objets
 	 	for(int i = 0; i < this.tabObjets.size(); i++){
 	 		g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
 	 	}	
 	 	 
 	 	// Images des piéces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 		g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
 	 	}
 	 	
 	    // Image du drapeau d'arrivée
 	 	g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
 	    // Image du chéteau d'arrivée
 		g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
 	 	
        // Image de mario
 		if(this.mario.isVivant() == true){
 			if(this.mario.isSaut()){g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);}
 	 		else{g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);}
 		}else{g2.drawImage(this.mario.meurt(), this.mario.getX(), this.mario.getY(), null);}
 				
 	    // Images des champignons
 	 	for(int i = 0; i < this.tabChamps.size(); i++){
 	 		if(this.tabChamps.get(i).isVivant() == true){
 	 		    g2.drawImage(this.tabChamps.get(i).marche("champ", 45), this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY(), null);
 	 		}else{
 	 			g2.drawImage(this.tabChamps.get(i).meurt(), this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY() + 20, null); 								
 	 		}
 	 	}
 	 		
 	 	// Images des tortues
 	    for(int i = 0; i < this.tabTortues.size(); i++){
 	 		if(this.tabTortues.get(i).isVivant() == true){
 	 		    g2.drawImage(this.tabTortues.get(i).marche("tortue", 50), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY(), null);
 	 	    }else{
 	 			g2.drawImage(this.tabTortues.get(i).meurt(), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY() + 30, null);				
 	 		}
 	 	}

		// Images des plante
 	    
		
		
 	    // Mise é jour du score
	    g2.setFont(police);
	    g2.drawString(this.score.getNbrePieces() + " pièce(s) trouvée(s) sur " + this.score.getNBRE_TOTAL_PIECES(), 460, 25);
	    
	    // Mise é jour du temps de jeu restant
	    g2.drawString(this.compteARebours.getStr(), 5, 25);
	    
	    // Fin de partie
	if(this.finDePartie() == true){
		this.setPartieTerminee(true);
		btnRejouer.setVisible(true);
		btnQuitter.setVisible(true);
		Font policeFin = new Font("Arial", Font.BOLD, 50);
		g2.setFont(policeFin);
		if(this.partieGagnee() == true){
		 g2.drawString("Vous avez gagné !", 120, 180);
		g2.drawString("Score: " + this.scoreTotal, 120, 230); // Décalage pour la nouvelle ligne
	} else {
		g2.drawString("Vous avez perdu...", 120, 180);
		g2.drawString("Score: " + this.scoreTotal, 120, 230); // Décalage pour la nouvelle ligne
	}
	} else {
		btnRejouer.setVisible(false);
		btnQuitter.setVisible(false);
	}


    }
}