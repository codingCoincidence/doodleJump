package com.sivis.doodlejump;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shoot implements ActionListener {

    static Timer shootTimer;

    public Shoot() {
        startShooting();
    }

    public void startShooting() {

        shootTimer = new Timer(1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (GlobalElements.shoot) {

                    GlobalElements.angle = Math.atan2(GlobalElements.clickY - GlobalElements.firePosY,
                            GlobalElements.clickX - GlobalElements.firePosX);

                    GlobalElements.dX = GlobalElements.bulletSpeed * Math.cos(GlobalElements.angle);
                    GlobalElements.dY = GlobalElements.bulletSpeed * Math.sin(GlobalElements.angle);

                    GlobalElements.bulletX += GlobalElements.dX;

                    GlobalElements.bulletY += GlobalElements.dY;

                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}