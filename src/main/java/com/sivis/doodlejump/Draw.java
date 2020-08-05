package com.sivis.doodlejump;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Draw extends JPanel {

    // class draws all needed images on game panel

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static Timer imageTimer;

    public Draw() {

        drawGameObjects();

    }

    public void drawGameObjects() {
        GlobalElements.gamePanel = new JPanel() {

            /**
            	 *
            	 */
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g.drawImage(GlobalElements.backImg1, 0, GlobalElements.backY1, GlobalElements.screenWidth,
                        GlobalElements.screenHeight, null);
                g.drawImage(GlobalElements.backImg2, 0, GlobalElements.backY2, GlobalElements.screenWidth,
                        GlobalElements.screenHeight, null);
                g.setFont(GlobalElements.font);
                g.setColor(Color.red.darker());
                for (int i = 0; i <= GlobalElements.numberOfGreenPlatforms - 1; i++) {
                    g.drawImage(GlobalElements.pGreen, GlobalElements.greenPlatformX[i],
                            GlobalElements.greenPlatformY[i], 58, 15, null);
                }

                if (GlobalElements.score > 5) {

                    for (int i = 0; i < GlobalElements.numberOfBluePlatforms; i++) {
                        g.drawImage(GlobalElements.pBlue, (int) GlobalElements.bluePlatformX[i],
                                (int) GlobalElements.bluePlatformY[i], 58, 15, null);
                    }
                }

                for (int i = 0; i < GlobalElements.brownPlatformX.length; i++) {
                    g.drawImage(GlobalElements.pBrown1, GlobalElements.brownPlatformX[i],
                            GlobalElements.brownPlatformY[i], 58, 15, null);
                    MovePlatform.moveTimer.start();
                }

                if (GlobalElements.hitBrownP) {
                    for (int i = 0; i < GlobalElements.brownCoordinateX.length; i++) {
                        g.drawImage(GlobalElements.pBrownGif, GlobalElements.brownCoordinateX[i],
                                GlobalElements.brownCoordinateY[i], 58, 15, null);
                    }

                }

                if (GlobalElements.score > 10) {
                    for (int i = 0; i < GlobalElements.whitePlatformY.length; i++) {
                        g.drawImage(GlobalElements.pWhite, GlobalElements.whitePlatformX[i],
                                GlobalElements.whitePlatformY[i], 58, 15, null);

                    }
                }

                if (GlobalElements.score > 15) {
                    g.drawImage(GlobalElements.rocket, GlobalElements.rocketX, GlobalElements.rocketY, 50, 90, null);
                    if (GlobalElements.rocketHit) {
                        g.drawImage(GlobalElements.pGreen, GlobalElements.rocketX, GlobalElements.rocketY - 20, 58, 15,
                                null);
                    }
                }

                if (GlobalElements.score > 40) {
                    for (int i = 0; i < GlobalElements.darkPlatformX.length; i++) {
                        g.drawImage(GlobalElements.pDark, GlobalElements.darkPlatformX[i],
                                GlobalElements.darkPlatformY[i], 58, 15, null);
                    }

                }

                g.drawImage(GlobalElements.pSpring1, GlobalElements.pSpringX, GlobalElements.pSpringY, 58, 20, null);

                if (GlobalElements.hitSpringP) {
                    g.drawImage(GlobalElements.movingSpring, GlobalElements.pSpringX, GlobalElements.pSpringY, 58, 25,
                            null);
                }

                g.drawImage(GlobalElements.topBar, 0, 0, GlobalElements.screenWidth, (GlobalElements.screenHeight / 25),
                        null);
                g.drawString("Score: " + Math.round(GlobalElements.score), 5, (GlobalElements.screenHeight / 50));
                g.drawString("current Player: " + GlobalElements.userName, (int) (GlobalElements.screenWidth / 2.5),
                        (GlobalElements.screenHeight / 50));

                if (KeyActions.gamePaused) {

                    g.drawString("GAME PAUSED", (int) (GlobalElements.screenWidth / 2.5),
                            (int) (GlobalElements.screenHeight / 2));

                }

                if (GlobalElements.score >= 20) {
                    g.drawImage(GlobalElements.monsterToDraw, GlobalElements.monsterX, GlobalElements.monsterY, 120,
                            120, null);
                    Monster.monsterTimer.start();
                    Monster.moveMonster.start();

                }

                if (GlobalElements.shoot) {
                    g.drawImage(GlobalElements.bullet, (int) GlobalElements.bulletX, (int) GlobalElements.bulletY, 15,
                            15, null);
                }

                if (GlobalElements.createShootingDoodle) {

                    g.drawImage(GlobalElements.shootingDoodle, (int) GlobalElements.doodleX,
                            (int) GlobalElements.doodleY, 40, 75, null);

                } else if (GlobalElements.rocketHit) {
                    g.drawImage(GlobalElements.doodleRocket, (int) GlobalElements.doodleX, (int) GlobalElements.doodleY,
                            70, 69, null);
                    GlobalElements.rocketY += 1000;
                } else {
                    g.drawImage(GlobalElements.doodle, (int) GlobalElements.doodleX, (int) GlobalElements.doodleY, 60,
                            59, null);
                }

                repaint();
                Toolkit.getDefaultToolkit().sync();

            }
        };

    }

}
