package com.seb.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if (Main.scene instanceof Niveau1) {
            Niveau1 niveau1 = (Niveau1) Main.scene;
            handleKeyPressNiveau1(niveau1, e);
        } else if (Main.scene instanceof Niveau2) {
            Niveau2 niveau2 = (Niveau2) Main.scene;
            handleKeyPressNiveau2(niveau2, e);
        } else if (Main.scene instanceof Niveau3) {
            Niveau3 niveau3 = (Niveau3) Main.scene;
            handleKeyPressNiveau3(niveau3, e);
        }
    }

    private void handleKeyPressNiveau1(Niveau1 niveau, KeyEvent e) {
        if (niveau.mario.isVivant()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (niveau.getxPos() == -1) {
                    niveau.setxPos(0);
                    niveau.setxFond1(-50);
                    niveau.setxFond2(750);
                }
                niveau.mario.setMarche(true);
                niveau.mario.setVersDroite(true);
                niveau.setDx(1);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (niveau.getxPos() == 4431) {
                    niveau.setxPos(4430);
                    niveau.setxFond1(-50);
                    niveau.setxFond2(750);
                }
                niveau.mario.setMarche(true);
                niveau.mario.setVersDroite(false);
                niveau.setDx(-1);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                niveau.mario.setSaut(true);
            }
        }
    }




    private void handleKeyPressNiveau2(Niveau2 niveau, KeyEvent e) {
       if (niveau.mario.isVivant()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (niveau.getxPos() == -1) {
                    niveau.setxPos(0);
                    niveau.setxFond1(-50);
                    niveau.setxFond2(750);
                }
                niveau.mario.setMarche(true);
                niveau.mario.setVersDroite(true);
                niveau.setDx(1);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (niveau.getxPos() == 4431) {
                    niveau.setxPos(4430);
                    niveau.setxFond1(-50);
                    niveau.setxFond2(750);
                }
                niveau.mario.setMarche(true);
                niveau.mario.setVersDroite(false);
                niveau.setDx(-1);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                niveau.mario.setSaut(true);
            }
        }
    }



    private void handleKeyPressNiveau3(Niveau3 niveau, KeyEvent e) {
        // Vous pouvez réutiliser la même logique que Niveau1 ou Niveau2, ou la personnaliser pour Niveau3
       if (niveau.mario.isVivant()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (niveau.getxPos() == -1) {
                    niveau.setxPos(0);
                    niveau.setxFond1(-50);
                    niveau.setxFond2(750);
                }
                niveau.mario.setMarche(true);
                niveau.mario.setVersDroite(true);
                niveau.setDx(1);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (niveau.getxPos() == 4431) {
                    niveau.setxPos(4430);
                    niveau.setxFond1(-50);
                    niveau.setxFond2(750);
                }
                niveau.mario.setMarche(true);
                niveau.mario.setVersDroite(false);
                niveau.setDx(-1);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                niveau.mario.setSaut(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (Main.scene instanceof Niveau1) {
            Niveau1 niveau1 = (Niveau1) Main.scene;
            niveau1.mario.setMarche(false);
            niveau1.setDx(0);
        } else if (Main.scene instanceof Niveau2) {
            Niveau2 niveau2 = (Niveau2) Main.scene;
            niveau2.mario.setMarche(false);
            niveau2.setDx(0);
        } else if (Main.scene instanceof Niveau3) {
            Niveau3 niveau3 = (Niveau3) Main.scene;
            niveau3.mario.setMarche(false);
            niveau3.setDx(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
