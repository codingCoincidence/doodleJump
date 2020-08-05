package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

public class DoodleMovement implements ActionListener {

    static Timer doodleMovement;
    double upperScreen;
    double middleScreen;

    public DoodleMovement() {

        upperScreen = GlobalElements.screenHeight / 3;
        middleScreen = GlobalElements.screenHeight / 2.5;
        createDoodleMovement();

    }

    public void createDoodleMovement() {

        doodleMovement = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new EditScore();

                getDirections();

                if (GlobalElements.killed) {                	
                    killedByMonster();
                } else if (GlobalElements.rocketHit) {
                    rocketFlight();
                } else if (GlobalElements.hitSpringP) {
                    fireSpring();
                } else {
                    normalJump();
                }

                if (GlobalElements.doodleY > GlobalElements.screenHeight - 30) {
                    if (GlobalElements.enableSound) {
                        fallSound();
                    }
                    GlobalElements.playFrame.dispose();
                    new GameOver(450, 600);
                    killAllTimer();
                }

                if (GlobalElements.killedMonster) {
                    GlobalElements.monsterY += GlobalElements.screenHeight;
                }

            }

        });

    }

    public void getDirections() {

        if (GlobalElements.moveRight) {
            if (GlobalElements.doodleX <= GlobalElements.screenWidth) {
                GlobalElements.doodleX += GlobalElements.speedRight;

                if (GlobalElements.doodleX >= GlobalElements.screenWidth) {
                    GlobalElements.doodleX = 0;

                }

            }
        } else if (GlobalElements.moveLeft) {
            if (GlobalElements.doodleX > 0) {
                GlobalElements.doodleX -= GlobalElements.speedLeft;

                if (GlobalElements.doodleX <= 0) {
                    GlobalElements.doodleX = GlobalElements.screenWidth - 20;
                }

            }
        }
    }

    public void killedByMonster() {
    
    
        GlobalElements.hit = false;
        GlobalElements.rocketHit = false;
        GlobalElements.hitSpringP = false;
        GlobalElements.doodleY += 11;
        GlobalElements.backgroundSpeed = 2;

    }

    public void fallSound() {

        try {

            Clip fallClip = (Clip) AudioSystem.getClip();
            fallClip.open(AudioSystem
                    .getAudioInputStream(GlobalElements.getURL("etc/sound/fall.wav", DoodleMovement.class)));
            fallClip.start();
            Thread.sleep(1500);
            fallClip.close();
            GlobalElements.enableSound = false;

        } catch (Exception e) {
            System.out.println("could not play sound");
        }

    }

    public void rocketFlight() {
        GlobalElements.playFrame.requestFocus();

        if (GlobalElements.doodleY > upperScreen) {

            GlobalElements.killed = false;
            GlobalElements.doodleY -= 1;
            GlobalElements.backgroundSpeed = 10;
            GameTimer.timer.restart();

        } else {

            GlobalElements.doodleY -= 1;
            GlobalElements.backgroundSpeed = 7;
            GameTimer.timer.restart();

        }

        if (GlobalElements.doodleY <= 80) {
            GlobalElements.doodle = GlobalElements.doodleR;
            GlobalElements.rocketHit = false;
            GameTimer.timer.stop();

        }

    }

    public void fireSpring() {

        GlobalElements.hit = true;
        GlobalElements.backgroundSpeed = 3;
        GlobalElements.speedUp = 7;
        GameTimer.timer.restart();
        
      

        if (GlobalElements.doodleY < upperScreen) {
            GlobalElements.hitSpringP = false;
            GlobalElements.time += 1;
        }

    }

    public void normalJump() {

        if (GlobalElements.doodleY <= middleScreen) {
            GlobalElements.backgroundSpeed = 2;
            GlobalElements.speedUp = 5;
            GameTimer.timer.restart();

        } else if (GlobalElements.doodleY > middleScreen) {
            GlobalElements.backgroundSpeed = 1;
            GlobalElements.speedUp = 7;
            GameTimer.timer.stop();

        }

    }

    public void killAllTimer() {

        Hit.hitTimer.stop();
        HitSpecial.hitTimer.stop();
        Jump.jumpTimer.stop();

        MovePlatform.moveTimer.stop();
        DoodleMovement.doodleMovement.stop();
        Monster.monsterTimer.stop();
        Monster.moveMonster.stop();
        GameTimer.timer.stop();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}