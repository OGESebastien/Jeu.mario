package com.seb.jeu;

public class Chrono implements Runnable {

    private final int PAUSE = 3;
    private boolean running = true;

    public void arreter() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            if (Main.scene != null && !Main.scene.estPartieTerminee()) {
                Main.scene.repaint();
            } else {
                arreter();
            }

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}
