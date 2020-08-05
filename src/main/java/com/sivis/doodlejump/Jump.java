
package com.sivis.doodlejump;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jump implements ActionListener {

    static Timer jumpTimer;
    int upperScreen;

    public Jump() {

        upperScreen = GlobalElements.screenHeight / 5;

        jumpTimer = new Timer(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (GlobalElements.rocketHit) {
                    GlobalElements.hit = false;
                    GlobalElements.hitSpringP = false;
                    GlobalElements.hitBrownP = false;

                } else if (GlobalElements.doodleY >= upperScreen) {
                    GlobalElements.doodleY -= GlobalElements.speedUp - GlobalElements.time;
                    GlobalElements.time += 0.1;
                    GlobalElements.movingDirection = GlobalElements.speedUp - GlobalElements.time;
                    if (GlobalElements.movingDirection < 0) {
                        GlobalElements.falling = true;
                    }
                } else {
                    GlobalElements.doodleY -= GlobalElements.speedUp - GlobalElements.time;
                    GlobalElements.time += 0.2;
                    GlobalElements.movingDirection = GlobalElements.speedUp - GlobalElements.time;
                    if (GlobalElements.movingDirection < 0) {
                        GlobalElements.falling = true;
                    }
                }

                if (GlobalElements.hit) {
                    
                    GlobalElements.time = 0.1;
                    Jump.jumpTimer.restart();
                    GlobalElements.hit = false;
                    GlobalElements.movingDirection = 0;
                    GlobalElements.falling = false;
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}