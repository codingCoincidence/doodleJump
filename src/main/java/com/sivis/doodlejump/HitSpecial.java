package com.sivis.doodlejump;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HitSpecial implements ActionListener {

    static Timer hitTimer;

    public HitSpecial() {

        hitTimer = new Timer(3, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                hitBrown();
                hitSpring();
                hitRocket();
                if (GlobalElements.score >= 40) {
                    hitDark();
                }
                if (GlobalElements.score >= 19) {
                    shootMonster();
                }
                hitMonster();

            }

        });
    }

    public void hitBrown() {

        for (int i = 0; i < GlobalElements.brownPlatformX.length; i++) {

            if ((GlobalElements.doodleX - 20 <= GlobalElements.brownPlatformX[i] + 25)
                    && (GlobalElements.doodleX + 30 >= GlobalElements.brownPlatformX[i] - 25)
                    && (GlobalElements.doodleY + 50 >= GlobalElements.brownPlatformY[i] - 7.5)
                    && (GlobalElements.doodleY + 50 <= GlobalElements.brownPlatformY[i] + 2) && (GlobalElements.falling)) {

                GlobalElements.brownCoordinateX[i] = GlobalElements.brownPlatformX[i];
                GlobalElements.brownCoordinateY[i] = GlobalElements.brownPlatformY[i];
                GlobalElements.brownPlatformY[i] += GlobalElements.screenHeight;

                GlobalElements.hitBrownP = true;

            }
        }

    }

    public void hitSpring() {
    	

        if ((GlobalElements.doodleX - 20 <= GlobalElements.pSpringX + 29)
                && (GlobalElements.doodleX + 30 >= GlobalElements.pSpringX - 29)
                && (GlobalElements.doodleY + 50 >= GlobalElements.pSpringY - 7.5)
                && (GlobalElements.doodleY + 50 <= GlobalElements.pSpringY + 2) && (GlobalElements.falling)){       	
        	
        		
        		GlobalElements.hitSpringP = true;
        	

        }

    }

    public void hitRocket() {
        if ((GlobalElements.doodleX - 20 <= GlobalElements.rocketX + 30)
                && (GlobalElements.doodleX + 20 >= GlobalElements.rocketX - 30)
                && (GlobalElements.doodleY + 30 >= GlobalElements.rocketY - 30)
                && (GlobalElements.doodleY + 40 <= GlobalElements.rocketY + 35)){
        	GlobalElements.hitSpringP = false;
            GlobalElements.rocketHit = true;
        }
    }

    public void hitMonster() {
        if ((GlobalElements.doodleX - 30 <= GlobalElements.monsterX + 100)
                && (GlobalElements.doodleX + 30 >= GlobalElements.monsterX)
                && (GlobalElements.doodleY + 10 >= GlobalElements.monsterY)
                && (GlobalElements.doodleY + 50 <= GlobalElements.monsterY + 100) && (GlobalElements.score > 20)) {
        	
        	try {
        		Thread.sleep(100);                		
        	} catch (Exception exception) {
        		exception.printStackTrace();                		
        	}


            GlobalElements.killed = true;
            System.out.println("killed");

        }
    }

    public void shootMonster() {

        if ((GlobalElements.bulletX - 10 <= GlobalElements.monsterX + 90)
                && (GlobalElements.bulletX + 10 >= GlobalElements.monsterX)
                && (GlobalElements.bulletY + 10 >= GlobalElements.monsterY)
                && (GlobalElements.bulletY + 10 <= GlobalElements.monsterY + 90) && (GlobalElements.shoot)) {

            GlobalElements.killedMonster = true;
            GlobalElements.score += 10;

        }
    }

    public void hitDark() {

        for (int i = 0; i < GlobalElements.darkPlatformX.length; i++) {

            if ((GlobalElements.doodleX - 20 <= GlobalElements.darkPlatformX[i] + 25)
                    && (GlobalElements.doodleX + 30 >= GlobalElements.darkPlatformX[i] - 25)
                    && (GlobalElements.doodleY + 50 >= GlobalElements.darkPlatformY[i] - 7.5)
                    && (GlobalElements.doodleY + 50 <= GlobalElements.darkPlatformY[i] + 2) && (GlobalElements.falling)) {
            	
            	GlobalElements.hitSpringP = false;
                GlobalElements.hit = true;
                GlobalElements.darkPlatformY[i] += GlobalElements.screenHeight;

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}