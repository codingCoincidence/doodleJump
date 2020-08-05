package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Hit  implements ActionListener {

    static Timer hitTimer;

    public Hit() {

        hitTimer = new Timer(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
     
                hitGreen();
                hitBlue();
                hitWhite();


            }
        });

       
    }

    public void hitGreen() {
        for (int i = 0; i <= GlobalElements.numberOfGreenPlatforms - 1; i++) {

            if ((GlobalElements.doodleX - 20 <= GlobalElements.greenPlatformX[i] + 29)
                    && (GlobalElements.doodleX + 30 >= GlobalElements.greenPlatformX[i] - 29)
                    && (GlobalElements.doodleY + 50 >= GlobalElements.greenPlatformY[i] - 7.5)
                    && (GlobalElements.doodleY + 50 <= GlobalElements.greenPlatformY[i] + 2) && (GlobalElements.falling)) {
            	
            	GlobalElements.hitSpringP = false;
                GlobalElements.hit = true;

            }
        }

    }

    public void hitWhite() {
        for (int i = 0; i < GlobalElements.whitePlatformX.length; i++) {

            if ((GlobalElements.doodleX - 20 <= GlobalElements.whitePlatformX[i] + 29)
                    && (GlobalElements.doodleX + 30 >= GlobalElements.whitePlatformX[i] - 29)
                    && (GlobalElements.doodleY + 50 >= GlobalElements.whitePlatformY[i] - 7.5)
                    && (GlobalElements.doodleY + 50 <= GlobalElements.whitePlatformY[i] + 2) && (GlobalElements.falling)){
            	GlobalElements.hitSpringP = false;
                GlobalElements.hit = true;

            }

        }
    }

    public void hitBlue() {

        for (int i = 0; i < GlobalElements.numberOfBluePlatforms; i++) {

            if ((GlobalElements.doodleX - 20 <= GlobalElements.bluePlatformX[i] + 29)
                    && (GlobalElements.doodleX + 30 >= GlobalElements.bluePlatformX[i] - 29)
                    && (GlobalElements.doodleY + 50 >= GlobalElements.bluePlatformY[i] - 7.5)
                    && (GlobalElements.doodleY + 50 <= GlobalElements.bluePlatformY[i] + 2) && (GlobalElements.falling)) {
            	GlobalElements.hitSpringP = false;
                GlobalElements.hit = true;

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    

    }

}