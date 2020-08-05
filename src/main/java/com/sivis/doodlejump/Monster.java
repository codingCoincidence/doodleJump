package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Monster implements ActionListener {

    static Timer monsterTimer;
    static Timer moveMonster;
    int turningPointRight;
    int turningPointLeft;
    double upperScreen;
    double width;

    public Monster() {

        upperScreen = GlobalElements.screenHeight / 200;
        width = GlobalElements.screenWidth / 1.08;

        createMonster();
        moveMonster();

    }

    public void createMonster() {

        monsterTimer = new Timer(GlobalElements.monsterDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GlobalElements.killedMonster = false;

                if (GlobalElements.score > 19) {

                    GlobalElements.monsterToDraw = GlobalElements.monsterList.get((int) (3 * Math.random()));
                    GlobalElements.monsterY = (int) (upperScreen * Math.random());
                    GlobalElements.monsterX = (int) (width * Math.random());
                    turningPointRight = GlobalElements.monsterX + (GlobalElements.screenWidth / 14);
                    turningPointLeft = GlobalElements.monsterX - (GlobalElements.screenWidth / 14);
                }

            }
        });

    }

    public void moveMonster() {

        moveMonster = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((GlobalElements.monsterX > turningPointLeft) && (GlobalElements.monsterX < turningPointRight)
                        && (GlobalElements.monsterDirection.equals("right"))) {
                    GlobalElements.monsterX += 4;
                } else if ((GlobalElements.monsterX > turningPointLeft) && (GlobalElements.monsterX < turningPointRight)
                        && (GlobalElements.monsterDirection.equals("left"))) {
                    GlobalElements.monsterX -= 4;
                }
                if (GlobalElements.monsterX <= turningPointLeft) {
                    GlobalElements.monsterX += 4;
                    GlobalElements.monsterDirection = "right";
                }
                if (GlobalElements.monsterX >= turningPointRight) {
                    GlobalElements.monsterX -= 4;
                    GlobalElements.monsterDirection = "left";
                }

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}