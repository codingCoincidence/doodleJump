package com.sivis.doodlejump;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyActions implements KeyListener, MouseListener {
    // contains reactions to KeyActions/ MouseActions

    static boolean gamePaused = false;

    public void pauseGame() {
        Jump.jumpTimer.stop();
        DoodleMovement.doodleMovement.stop();
        GameTimer.timer.stop();
        MovePlatform.moveTimer.stop();
        gamePaused = true;

    }

    public void restartGame() {
        Jump.jumpTimer.start();
        DoodleMovement.doodleMovement.start();
        GameTimer.timer.start();
        MovePlatform.moveTimer.start();
        gamePaused = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        GlobalElements.createShootingDoodle = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        GlobalElements.createShootingDoodle = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_SPACE) && (!gamePaused)) {

            DoodleMovement.doodleMovement.start();
            Jump.jumpTimer.start();
            Hit.hitTimer.start();
            HitSpecial.hitTimer.start();
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            GlobalElements.moveLeft = true;
            GlobalElements.doodle = GlobalElements.doodleL;
            if (GlobalElements.rocketHit) {
                GlobalElements.doodle = GlobalElements.doodleRocket;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            GlobalElements.moveRight = true;
            GlobalElements.doodle = GlobalElements.doodleR;
            if (GlobalElements.rocketHit) {
                GlobalElements.doodle = GlobalElements.doodleRocket;
            }

        }
        if ((e.getKeyCode() == KeyEvent.VK_P) && (!gamePaused)) {

            pauseGame();

        } else if ((e.getKeyCode() == KeyEvent.VK_P) && (gamePaused)) {

            restartGame();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_A) {
            GlobalElements.moveLeft = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            GlobalElements.moveRight = false;

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        GlobalElements.shoot = true;
        GlobalElements.bulletX = GlobalElements.doodleX;
        GlobalElements.bulletY = GlobalElements.doodleY;

        GlobalElements.firePosX = GlobalElements.doodleX;
        GlobalElements.firePosY = GlobalElements.doodleY;
        GlobalElements.clickX = e.getX();
        GlobalElements.clickY = e.getY();
        GlobalElements.angle = Math.atan2(GlobalElements.clickY - GlobalElements.doodleY,
                GlobalElements.clickX - GlobalElements.doodleX);

        GlobalElements.dX = GlobalElements.bulletSpeed * Math.cos(GlobalElements.angle);
        GlobalElements.dY = GlobalElements.bulletSpeed * Math.sin(GlobalElements.angle);
        Shoot.shootTimer.start();

    }

}