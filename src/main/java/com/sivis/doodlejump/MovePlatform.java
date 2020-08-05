package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MovePlatform implements ActionListener {

    // contains Timer to (re-) move all platforms in game
    // instead of having one Timer for each Platform Type

    static Timer moveTimer;
    int systemTime;

    public MovePlatform() {

        systemTime = 0;
        movePlatforms();

    }

    public void movePlatforms() {

        moveTimer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakBrownPlatforms();
                moveBluePlatforms();
                removeWhitePlatforms();
            }
        });

    }

    public void breakBrownPlatforms() {

        if (GlobalElements.hitBrownP) {
            for (int i = 0; i < GlobalElements.brownCoordinateX.length; i++) {
                GlobalElements.brownCoordinateY[i] += 4;
            }
        }

    }

    public void moveBluePlatforms() {

        for (int i = 0; i < GlobalElements.numberOfBluePlatforms - 1; i++) {
            if ((GlobalElements.bluePlatformX[i] < GlobalElements.screenWidth) && (GlobalElements.bluePlatformX[i] > 5)
                    && (GlobalElements.pBlueDirection[i].equals("right"))) {
                GlobalElements.bluePlatformX[i] += GlobalElements.bluePlatformSpeed;
            } else if ((GlobalElements.bluePlatformX[i] < GlobalElements.screenWidth)
                    && (GlobalElements.bluePlatformX[i] > 5) && (GlobalElements.pBlueDirection[i].equals("left"))) {
                GlobalElements.bluePlatformX[i] -= GlobalElements.bluePlatformSpeed;
            }
            if (GlobalElements.bluePlatformX[i] <= 10) {
                GlobalElements.bluePlatformX[i] += GlobalElements.bluePlatformSpeed;
                GlobalElements.pBlueDirection[i] = "right";
            }
            if (GlobalElements.bluePlatformX[i] >= (GlobalElements.screenWidth / 1.08)) {
                GlobalElements.bluePlatformX[i] -= GlobalElements.bluePlatformSpeed;
                GlobalElements.pBlueDirection[i] = "left";
            }
        }

    }

    public void removeWhitePlatforms() {

        systemTime += 1;

        if (systemTime == 100) {
            GlobalElements.whitePlatformY[0] += GlobalElements.screenHeight;
        } else if (systemTime == 300) {
            GlobalElements.whitePlatformY[4] += GlobalElements.screenHeight;
        } else if (systemTime == 400) {
            GlobalElements.whitePlatformY[1] += GlobalElements.screenHeight;
            GlobalElements.whitePlatformY[3] += GlobalElements.screenHeight;
        } else if (systemTime == 700) {
            GlobalElements.whitePlatformY[2] += GlobalElements.screenHeight;
            systemTime = 0;
        }
        
        new Draw();

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}