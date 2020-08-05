package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.Timer;

public class GameTimer implements ActionListener {

    static Timer timer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            syncBackground();

            increaseDifficulty();

            syncPlatforms();

            GlobalElements.playFrame.validate();
            GlobalElements.playFrame.repaint();
            Toolkit.getDefaultToolkit().sync();

        }

    });

    static Timer rocketTimer = new Timer(40000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RocketPlatform();
        }
    });

    private static void syncBackground() {

        if (GlobalElements.backY1 < GlobalElements.screenHeight) {
            GlobalElements.backY1 += GlobalElements.backgroundSpeed;

        } else {
            GlobalElements.backY1 = -GlobalElements.screenHeight;

        }
        if (GlobalElements.backY2 < GlobalElements.screenHeight) {
            GlobalElements.backY2 += GlobalElements.backgroundSpeed;

        } else {
            GlobalElements.backY2 = -GlobalElements.screenHeight;

        }

        GlobalElements.monsterY += GlobalElements.backgroundSpeed;

    }

    private static void increaseDifficulty() {

        if (GlobalElements.score > GlobalElements.intermediateScore + 15) {
            GlobalElements.monsterDelay -= 4000;
            GlobalElements.bluePlatformSpeed += 0.1;
            GlobalElements.numberOfGreenPlatforms -= 1;
            GlobalElements.intermediateScore = GlobalElements.score;
        }
    }

    private static void syncPlatforms() {
        new GreenPlatform();
        new BrownPlatform();
        new SpringPlatform();

        if (GlobalElements.score > 5) {
            new BluePlatform();
        }

        if (GlobalElements.score > 10) {
            new WhitePlatform();
        }

        if (GlobalElements.score > 15) {
            rocketTimer.start();
            GlobalElements.rocketY += GlobalElements.backgroundSpeed;
        }

        if (GlobalElements.score > 40) {
            new DarkPlatforms();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}